package drealm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import drealm.entity.*;
import drealm.render.DRRenderDwarf;
import drealm.render.DRRenderDwarfCommander;
import drealm.render.DRRenderDwarfSmith;
import drealm.render.DRRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraftforge.common.MinecraftForge;

public class DRClientProxy extends DRCommonProxy {
	@Override
	public void onInit(FMLInitializationEvent event) {
		IResourceManagerReloadListener rendererManager = new DRRenderManager.Map();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		rendererManager.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(rendererManager);
		MinecraftForge.EVENT_BUS.register(rendererManager);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		IResourceManagerReloadListener rendererManager = new DRRenderManager.Items();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		rendererManager.onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(rendererManager);
		MinecraftForge.EVENT_BUS.register(rendererManager);

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