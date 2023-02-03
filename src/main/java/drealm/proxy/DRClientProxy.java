package drealm.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.*;
import drealm.entity.*;
import drealm.render.*;
import drealm.util.DRCommander;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;

public class DRClientProxy extends DRServerProxy implements IResourceManagerReloadListener {
	public static DRRendererManager rendererManager;

	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new DRClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		DRCommander.setClientMapImage(new ResourceLocation("drealm:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		rendererManager = new DRRendererManager();
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
