package drealm.render;

import java.util.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import drealm.database.DRRegistry;
import drealm.util.DRCommander;
import lotr.client.render.item.*;
import lotr.common.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class DRRendererManager implements IResourceManagerReloadListener {
	public static List<DRRenderLargeItem> largeItemRenderers;

	public DRRendererManager() {
		largeItemRenderers = new ArrayList<>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		this.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(this);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
		for (Item item : DRCommander.getObjectFieldsOfType(DRRegistry.class, Item.class)) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			DRRenderLargeItem largeItemRenderer = DRRenderLargeItem.getRendererIfLarge(item);
			if (item instanceof LOTRItemCrossbow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderCrossbow());
			} else if (item instanceof LOTRItemBow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderBow(largeItemRenderer));
			} else if (item instanceof LOTRItemSword && ((LOTRItemSword) item).isElvenBlade()) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderElvenBlade(24.0, largeItemRenderer));
			} else if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
			}
			if (largeItemRenderer == null) {
				continue;
			}
			largeItemRenderers.add(largeItemRenderer);
		}
	}

	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (DRRenderLargeItem largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}
