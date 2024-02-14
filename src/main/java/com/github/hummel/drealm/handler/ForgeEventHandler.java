package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.listener.ReloadListener;
import com.github.hummel.drealm.render.RenderLargeItem;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.client.event.TextureStitchEvent;

public class ForgeEventHandler {
	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (RenderLargeItem largeRenderer : ReloadListener.Items.LARGE_ITEM_RENDERERS) {
				largeRenderer.registerIcons(map);
			}
		}
	}
}