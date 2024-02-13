package com.github.hummel.drealm;

import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.handler.EventHandler;
import com.github.hummel.drealm.handler.GuiHandler;
import com.github.hummel.drealm.init.*;
import com.github.hummel.drealm.proxy.CommonProxy;
import com.github.hummel.drealm.util.ResourceHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.util.ResourceLocation;
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
		EventBus eventBus = MinecraftForge.EVENT_BUS;
		EventHandler eventHandler = new EventHandler();
		eventBus.register(eventHandler);

		Materials.onInit();
		ChestContents.onInit();
		Invasions.onInit();
		SpawnLists.onInit();
		Biomes.onInit();
		Recipes.onInit();
		Achievements.onInit();
		Roads.onInit();
		TradeEntries.onInit();
		UnitTradeEntries.onInit();
		Structures.onInit();
		MiniQuests.onInit();
		Factions.onInit();

		ResourceHelper.loadSpeeechBanks();
		API.setCommonMapImage(new ResourceLocation("drealm:map/map.png"));

		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry networkRegistry = NetworkRegistry.INSTANCE;
		IGuiHandler guiHandler = new GuiHandler();
		networkRegistry.registerGuiHandler(this, guiHandler);

		Config.preInit(event);

		Factions.preInit();
		Waypoints.preInit();
		BannerTypes.preInit();
		CreativeTabs.preInit();
		Materials.preInit();
		Blocks.preInit();
		Items.preInit();
		Foods.preInit();
		Entities.preInit();
		Shields.preInit();

		proxy.preInit(event);
	}
}
