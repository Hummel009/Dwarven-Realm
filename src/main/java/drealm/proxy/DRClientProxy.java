package drealm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import drealm.entity.*;
import drealm.render.DRRenderDwarf;
import drealm.render.DRRenderDwarfCommander;
import drealm.render.DRRenderDwarfSmith;
import drealm.render.DRRendererManager;
import drealm.util.DRAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;

public class DRClientProxy extends DRCommonProxy implements IResourceManagerReloadListener {

	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new DRClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		DRAPI.setClientMapImage(new ResourceLocation("drealm:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		DRRendererManager rendererManager = new DRRendererManager();
		rendererManager.preInit();
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityRedDwarfMerchant.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarf.class, new DRRenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfSmith.class, new DRRenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfCommander.class, new DRRenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(DREntityWindDwarfMerchant.class, new DRRenderDwarfCommander());
	}
}