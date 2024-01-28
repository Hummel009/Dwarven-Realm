package drealm.render;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import drealm.content.DRItems;
import drealm.util.DRAPI;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;

import java.util.ArrayList;
import java.util.Collection;

public class DRRenderManager {
	public static class Map implements IResourceManagerReloadListener {
		@Override
		public void onResourceManagerReload(IResourceManager resourceManager) {
			DRAPI.setClientMapImage(new ResourceLocation("drealm:map/map.png"));
		}
	}

	public static class Items implements IResourceManagerReloadListener {
		private static final Collection<DRRenderLargeItem> LARGE_ITEM_RENDERERS = new ArrayList<>();

		@Override
		public void onResourceManagerReload(IResourceManager resourceManager) {
			LARGE_ITEM_RENDERERS.clear();
			IItemRenderer renderCrossbow = new LOTRRenderCrossbow();
			for (Item item : DRItems.CONTENT) {
				MinecraftForgeClient.registerItemRenderer(item, null);
				DRRenderLargeItem largeItemRenderer = DRRenderLargeItem.getRendererIfLarge(item);
				if (item instanceof LOTRItemCrossbow) {
					MinecraftForgeClient.registerItemRenderer(item, renderCrossbow);
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
				LARGE_ITEM_RENDERERS.add(largeItemRenderer);
			}
		}

		@SubscribeEvent
		public void preTextureStitch(TextureStitchEvent.Pre event) {
			TextureMap map = event.map;
			if (map.getTextureType() == 1) {
				for (DRRenderLargeItem largeRenderer : LARGE_ITEM_RENDERERS) {
					largeRenderer.registerIcons(map);
				}
			}
		}
	}

}
