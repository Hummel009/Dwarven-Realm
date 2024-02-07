package com.github.hummel.drealm.proxy;

import com.github.hummel.drealm.Config;
import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.init.*;
import com.github.hummel.drealm.util.ResourceHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;

public interface CommonProxy {
	default void onInit(FMLInitializationEvent event) {
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
	}

	default void preInit(FMLPreInitializationEvent event) {
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
	}
}
