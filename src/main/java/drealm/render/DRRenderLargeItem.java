package drealm.render;

import java.io.IOException;
import java.util.*;

import org.lwjgl.opengl.GL11;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.client.render.item.LOTRRenderLargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.IResource;
import net.minecraft.item.Item;
import net.minecraft.util.*;

public class DRRenderLargeItem extends LOTRRenderLargeItem {
	private static Map<String, Float> sizeFolders = new HashMap<>();
	static {
		sizeFolders.put("large", 2.0f);
		sizeFolders.put("large2", 3.0f);
	}
	private final Item theItem;
	private final String folderName;
	private final float largeIconScale;
	private IIcon largeIcon;

	private List<LOTRRenderLargeItem.ExtraLargeIconToken> extraTokens = new ArrayList<>();

	public DRRenderLargeItem(Item item, String dir, float f) {
		super(item, dir, f);
		theItem = item;
		folderName = dir;
		largeIconScale = f;
	}

	private void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
	}

	@Override
	public LOTRRenderLargeItem.ExtraLargeIconToken extraIcon(String name) {
		LOTRRenderLargeItem.ExtraLargeIconToken token = new LOTRRenderLargeItem.ExtraLargeIconToken(name);
		extraTokens.add(token);
		return token;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		largeIcon = registerLargeIcon(register, null);
		for (LOTRRenderLargeItem.ExtraLargeIconToken token : extraTokens) {
			token.icon = registerLargeIcon(register, token.name);
		}
	}

	private IIcon registerLargeIcon(IIconRegister register, String extra) {
		String itemName = theItem.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(theItem);
		String modID = (StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ":";
		StringBuilder path = new StringBuilder().append(modID).append(folderName).append("/").append(itemName);
		if (!StringUtils.isNullOrEmpty(extra)) {
			path.append("_").append(extra);
		}
		return register.registerIcon(path.toString());
	}

	@Override
	public void renderLargeItem() {
		this.renderLargeItem(largeIcon);
	}

	private void renderLargeItem(IIcon icon) {
		doTransformations();
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
	}

	private static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
		String modID = StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId;
		return new ResourceLocation(modID, "textures/items/" + folder + "/" + itemIconString + ".png");
	}

	public static DRRenderLargeItem getRendererIfLarge(Item item) {
		for (String folder : sizeFolders.keySet()) {
			float iconScale = sizeFolders.get(folder);
			try {
				ResourceLocation resLoc = DRRenderLargeItem.getLargeTexturePath(item, folder);
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res == null) {
					continue;
				}
				return new DRRenderLargeItem(item, folder, iconScale);
			} catch (IOException resLoc) {
			}
		}
		return null;
	}
}
