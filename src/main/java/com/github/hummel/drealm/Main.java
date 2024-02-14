package com.github.hummel.drealm;

import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.handler.FmlEventHandler;
import com.github.hummel.drealm.handler.ForgeEventHandler;
import com.github.hummel.drealm.handler.GuiHandler;
import com.github.hummel.drealm.init.*;
import com.github.hummel.drealm.proxy.CommonProxy;
import com.github.hummel.drealm.util.ResourceHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

@SuppressWarnings({"PublicField", "WeakerAccess"})
@Mod(modid = "drealm", dependencies = "required-after:lotr", useMetadata = true)
public class Main {
	@Mod.Instance("drealm")
	public static Main instance;

	@SidedProxy(clientSide = "com.github.hummel.drealm.proxy.ClientProxy", serverSide = "com.github.hummel.drealm.proxy.ServerProxy")
	public static CommonProxy proxy;

	public Main() {
		EventBus fmlEventBus = FMLCommonHandler.instance().bus();
		FmlEventHandler fmlEventHandler = new FmlEventHandler();
		fmlEventBus.register(fmlEventHandler);

		EventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		ForgeEventHandler forgeEventHandler = new ForgeEventHandler();
		forgeEventBus.register(forgeEventHandler);
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

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
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
}