package drealm.util;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.nio.file.FileSystem;
import java.util.*;
import java.util.stream.Stream;

import cpw.mods.fml.common.*;
import lotr.common.util.LOTRLog;
import net.minecraft.util.ResourceLocation;

public class DRResourceHelper {
	public static InputStream getInputStream(ResourceLocation res) {
		return DRResourceHelper.getInputStream(DRResourceHelper.getContainer(res), DRResourceHelper.getPath(res));
	}

	private static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	public static Map<String, InputStream> getInputStreams(ResourceLocation res, String... extensions) {
		HashMap<String, InputStream> map = new HashMap<>();
		for (Map.Entry<String, ResourceLocation> entry : DRResourceHelper.getSubFileResourceLocations(res, extensions).entrySet()) {
			map.put(entry.getKey(), DRResourceHelper.getInputStream(entry.getValue()));
		}
		return map;
	}

	public static Map<String, ResourceLocation> getSubFileResourceLocations(ResourceLocation res, String... extensions) {
		HashMap<String, ResourceLocation> map = new HashMap<>();
		String basePath = DRResourceHelper.getPath(res);
		for (String file : DRResourceHelper.getAllSubFilePaths(res, extensions)) {
			String name = file.replace("\\", "/");
			int startIndex = name.contains(basePath) ? name.lastIndexOf(basePath) + basePath.length() + (basePath.endsWith("/") ? 0 : 1) : 0;
			int endIndex = name.indexOf(".");
			String newResPath = res.getResourcePath() + (res.getResourcePath().endsWith("/") ? "" : "/") + name.substring(startIndex, name.length());
			ResourceLocation fileRes = new ResourceLocation(res.getResourceDomain(), newResPath);
			name = name.substring(startIndex, endIndex);
			map.put(name, fileRes);
		}
		return map;
	}

	public static List<String> getAllSubFilePaths(ResourceLocation res, String... extensions) {
		ArrayList<String> list = new ArrayList<>();
		String baseStringPath = DRResourceHelper.getPath(res);
		ModContainer container = DRResourceHelper.getContainer(res);
		if (baseStringPath.contains(".")) {
			LOTRLog.logger.error("Tried searching input stream in a file: " + res);
			throw new IllegalArgumentException("Can't search files in a file.");
		}
		try {
			Path basePath;
			URI uri = container.getClass().getResource(baseStringPath).toURI();
			FileSystem fileSystem = null;
			if (uri.getScheme().equals("jar")) {
				fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
				basePath = fileSystem.getPath(baseStringPath, new String[0]);
			} else {
				basePath = Paths.get(uri);
			}
			Stream<Path> allFilePaths = Files.walk(basePath, new FileVisitOption[0]);
			Iterator it = allFilePaths.iterator();
			block2: while (it.hasNext()) {
				Path filePath = (Path) it.next();
				String stringFilePath = filePath.toString();
				if (!stringFilePath.contains(".")) {
					continue;
				}
				String extension = stringFilePath.substring(stringFilePath.indexOf(".") + 1, stringFilePath.length());
				if (extensions.length != 0) {
					for (String allowedExtension : extensions) {
						if (!allowedExtension.equalsIgnoreCase(extension)) {
							continue;
						}
						list.add(stringFilePath);
						continue block2;
					}
					continue;
				}
				list.add(stringFilePath);
			}
			allFilePaths.close();
			if (fileSystem != null) {
				fileSystem.close();
			}
		} catch (IOException | URISyntaxException e) {
			LOTRLog.logger.error("Something went wrong when searching for all files in: " + res);
			e.printStackTrace();
		}
		return list;
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}

	private static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}
}
