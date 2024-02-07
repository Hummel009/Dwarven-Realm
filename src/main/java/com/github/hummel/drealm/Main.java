package com.github.hummel.drealm;

import com.github.hummel.drealm.handler.EventHandler;
import com.github.hummel.drealm.handler.GuiHandler;
import com.github.hummel.drealm.handler.TickHandler;
import com.github.hummel.drealm.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "drealm", dependencies = "required-after:lotr", useMetadata = true)
public class Main {
	@Mod.Instance("drealm")
	private static Main instance;

	@SidedProxy(clientSide = "com.github.hummel.drealm.proxy.ClientProxy", serverSide = "com.github.hummel.drealm.proxy.ServerProxy")
	private static CommonProxy proxy;

	public static Main getInstance() {
		return instance;
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		TickHandler tickHandler = new TickHandler();

		MinecraftForge.EVENT_BUS.register(tickHandler);
		FMLCommonHandler.instance().bus().register(tickHandler);

		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		IGuiHandler guiHandler = new GuiHandler();
		EventHandler eventHandler = new EventHandler();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
		FMLCommonHandler.instance().bus().register(eventHandler);

		proxy.preInit(event);
	}
}
