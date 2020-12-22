package drealm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.*;
import drealm.entity.*;
import drealm.render.*;
import drealm.util.DRCommander;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.common.item.LOTRItemCrossbow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class DRClientProxy extends DRServerProxy implements IResourceManagerReloadListener {

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		DRCommander.setClientMapImage(new ResourceLocation("drealm:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		for (Item item : DRCommander.getFields()) {
			boolean large;
			if (item == null) {
				continue;
			}
			DRRenderLargeItem largeItemRenderer = DRRenderLargeItem.getLargeIconSize(item);
			large = largeItemRenderer != null;
			if (item instanceof LOTRItemCrossbow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderCrossbow());
				continue;
			}
			if (!large) {
				continue;
			}
			MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
		}

		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfMerchant.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfMerchant.class, new DRRenderDwarfCommander());
	}

	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new DRClientProxy());
	}
}
