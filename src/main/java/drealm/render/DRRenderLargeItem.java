package drealm.render;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.client.LOTRClientProxy;
import lotr.common.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.IResource;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.client.IItemRenderer;

public class DRRenderLargeItem implements IItemRenderer {
	private static Map<String, Float> sizeFolders = new HashMap<>();
	private static Map<Pair<Item, String>, ResourceLocation> largeItemTextures;
	private final Item theItem;
	private final ResourceLocation largeTexture;
	private final String folderName;
	private final float largeIconScale;
	private final int largeIconSize;

	private static ResourceLocation createLargeItemTexture(Item item, String folder) {
		return DRRenderLargeItem.createLargeItemTexture(item, "", folder);
	}

	private static ResourceLocation createLargeItemTexture(Item item, String extra, String folder) {
		String modID;
		String itemIconString = item.getUnlocalizedName();
		if ((itemIconString = itemIconString.substring("item.".length())).contains(":")) {
			modID = itemIconString.substring(0, itemIconString.indexOf(":") + 1);
			itemIconString.substring(itemIconString.indexOf(":") + 1);
		} else {
			GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(item);
			if (UID == null) {

			}
			modID = "drealm:";
		}
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		String s = modID + "textures/items/" + folder + "/" + itemIconString;
		if (!StringUtils.isNullOrEmpty(extra)) {
			s = s + "_" + extra;
		}
		s = s + ".png";
		return new ResourceLocation(s);
	}

	public static ResourceLocation getOrCreateLargeItemTexture(Item item, String folder) {
		return DRRenderLargeItem.getOrCreateLargeItemTexture(item, "", folder);
	}

	public static ResourceLocation getOrCreateLargeItemTexture(Item item, String extra, String folder) {
		ResourceLocation texture;
		Pair key;
		if (StringUtils.isNullOrEmpty(extra)) {
			extra = "";
		}
		if ((texture = largeItemTextures.get(key = Pair.of((Object) item, (Object) extra))) == null) {
			texture = DRRenderLargeItem.createLargeItemTexture(item, extra, folder);
			largeItemTextures.put(key, texture);
		}
		return texture;
	}

	public static DRRenderLargeItem getLargeIconSize(Item item) {
		for (String folder : sizeFolders.keySet()) {
			float iconScale = sizeFolders.get(folder);
			try {
				ResourceLocation resLoc = DRRenderLargeItem.createLargeItemTexture(item, folder);
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res == null) {
					continue;
				}
				try {
					BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(res.getInputStream()));
					if (img == null) {
						continue;
					}
					if (img.getWidth() == img.getHeight()) {
						return new DRRenderLargeItem(item, resLoc, folder, iconScale, img.getWidth());
					}

				} catch (IOException e) {

				}
			} catch (IOException resLoc) {
			}
		}
		return null;
	}

	public DRRenderLargeItem(Item item, ResourceLocation res, String dir, float f, int i) {
		theItem = item;
		largeTexture = res;
		folderName = dir;
		largeIconScale = f;
		largeIconSize = i;
	}

	private ResourceLocation getSubtypeTexture(String extra) {
		return DRRenderLargeItem.getOrCreateLargeItemTexture(theItem, extra, folderName);
	}

	private void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
	}

	public void renderLargeItem() {
		this.renderLargeItem(null);
	}

	public void renderLargeItem(String extra) {
		doTransformations();
		ResourceLocation res = extra == null ? largeTexture : getSubtypeTexture(extra);
		Minecraft.getMinecraft().getTextureManager().bindTexture(res);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tessellator = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tessellator, 1.0f, 0.0f, 0.0f, 1.0f, largeIconSize, largeIconSize, 0.0625f);
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemstack, Object... data) {
		EntityLivingBase entityliving;
		GL11.glPushMatrix();
		Entity holder = (Entity) data[1];
		boolean isFirstPerson = holder == Minecraft.getMinecraft().thePlayer && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0;
		Item item = itemstack.getItem();
		if (item instanceof LOTRItemSpear && holder instanceof EntityPlayer && ((EntityPlayer) holder).getItemInUse() == itemstack) {
			GL11.glRotatef(260.0f, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-1.0f, 0.0f, 0.0f);
		}
		if (item instanceof LOTRItemPike && holder instanceof EntityLivingBase && (entityliving = (EntityLivingBase) holder).getHeldItem() == itemstack && entityliving.swingProgress <= 0.0f) {
			if (entityliving.isSneaking()) {
				if (isFirstPerson) {
					GL11.glRotatef(270.0f, 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(-1.0f, 0.0f, 0.0f);
				} else {
					GL11.glTranslatef(0.0f, -0.1f, 0.0f);
					GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
				}
			} else if (!isFirstPerson) {
				GL11.glTranslatef(0.0f, -0.3f, 0.0f);
				GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
			}
		}
		if (item instanceof LOTRItemLance && holder instanceof EntityLivingBase && (entityliving = (EntityLivingBase) holder).getHeldItem() == itemstack) {
			if (isFirstPerson) {
				GL11.glRotatef(260.0f, 0.0f, 0.0f, 1.0f);
				GL11.glTranslatef(-1.0f, 0.0f, 0.0f);
			} else {
				GL11.glTranslatef(0.7f, 0.0f, 0.0f);
				GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
				GL11.glTranslatef(-1.0f, 0.0f, 0.0f);
			}
		}
		this.renderLargeItem();
		if (itemstack != null && itemstack.hasEffect(0)) {
			LOTRClientProxy.renderEnchantmentEffect();
		}
		GL11.glPopMatrix();
	}

	static {
		sizeFolders.put("large", 2.0f);
		sizeFolders.put("large2", 3.0f);
		largeItemTextures = new HashMap<>();
	}

	@Override
	public boolean handleRenderType(ItemStack itemstack, IItemRenderer.ItemRenderType type) {
		return type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack itemstack, IItemRenderer.ItemRendererHelper helper) {
		return false;
	}

	static {
		sizeFolders.put("large", 2.0f);
		sizeFolders.put("large2", 3.0f);
		largeItemTextures = new HashMap<>();
	}
}
