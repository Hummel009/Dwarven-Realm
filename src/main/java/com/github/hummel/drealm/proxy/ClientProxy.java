package com.github.hummel.drealm.proxy;

import com.github.hummel.drealm.entity.*;
import com.github.hummel.drealm.listener.ReloadListener;
import com.github.hummel.drealm.nei.NEIDRIntegrator;
import com.github.hummel.drealm.render.RenderDwarf;
import com.github.hummel.drealm.render.RenderDwarfCommander;
import com.github.hummel.drealm.render.RenderDwarfSmith;
import com.github.hummel.drealm.util.NeiChecker;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit(FMLInitializationEvent event) {
		IResourceManagerReloadListener reloadListener = new ReloadListener.Map();
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		reloadListener.onResourceManagerReload(resourceManager);
		((IReloadableResourceManager) resourceManager).registerReloadListener(reloadListener);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		IResourceManagerReloadListener reloadListener = new ReloadListener.Items();
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		reloadListener.onResourceManagerReload(resourceManager);
		((IReloadableResourceManager) resourceManager).registerReloadListener(reloadListener);

		RenderingRegistry.registerEntityRenderingHandler(EntityRedDwarf.class, new RenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedDwarfSmith.class, new RenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedDwarfCommander.class, new RenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedDwarfMerchant.class, new RenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(EntityWindDwarf.class, new RenderDwarf());
		RenderingRegistry.registerEntityRenderingHandler(EntityWindDwarfSmith.class, new RenderDwarfSmith());
		RenderingRegistry.registerEntityRenderingHandler(EntityWindDwarfCommander.class, new RenderDwarfCommander());
		RenderingRegistry.registerEntityRenderingHandler(EntityWindDwarfMerchant.class, new RenderDwarfCommander());

		if (NeiChecker.hasNEI()) {
			NEIDRIntegrator.registerRecipes();
		}
	}
}