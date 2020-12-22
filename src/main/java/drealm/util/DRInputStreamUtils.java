package drealm.util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;

import cpw.mods.fml.relauncher.*;
import lotr.common.util.LOTRLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

public class DRInputStreamUtils {
	public static BufferedReader getReader(InputStream in) {
		if (in == null) {
			return null;
		}
		return new BufferedReader(new InputStreamReader(in, Charsets.UTF_8));
	}

	public static Map<String, BufferedReader> getReaders(Map<String, InputStream> ins) {
		HashMap<String, BufferedReader> map = new HashMap<>();
		for (Map.Entry<String, InputStream> entry : ins.entrySet()) {
			map.put(entry.getKey(), DRInputStreamUtils.getReader(entry.getValue()));
		}
		return map;
	}

	public static String[] getAsStringArray(InputStream in, boolean hasComments) {
		return DRInputStreamUtils.getAsStringList(in, hasComments).toArray(new String[0]);
	}

	public static List<String> getAsStringList(InputStream in, boolean hasComments) {
		BufferedReader reader = DRInputStreamUtils.getReader(in);
		List<String> list = new ArrayList<>();
		if (reader == null) {
			LOTRLog.logger.warn("Tried getting string list form reader but the reader is null.");
			return list;
		}
		try {
			list = reader.lines().filter(line -> hasComments ? !line.startsWith("#") : true).map(line -> line.trim()).filter(line -> !line.isEmpty()).collect(Collectors.toList());
		} catch (UncheckedIOException e) {
			LOTRLog.logger.error("Errored while getting getting string list from reader.");
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
		}
		return list;
	}

	public static BufferedImage getImage(InputStream in) {
		try {
			BufferedImage bufferedImage = ImageIO.read(in);
			return bufferedImage;
		} catch (IOException e) {
			LOTRLog.logger.error("Failed to convert a input stream into a buffered image.");
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	@SideOnly(value = Side.CLIENT)
	public static ResourceLocation getTextureResourceLocation(InputStream in, String textureName) {
		BufferedImage img = DRInputStreamUtils.getImage(in);
		if (img != null) {
			return Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(textureName, new DynamicTexture(img));
		}
		return null;
	}
}