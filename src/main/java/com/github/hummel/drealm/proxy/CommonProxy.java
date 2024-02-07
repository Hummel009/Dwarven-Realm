package com.github.hummel.drealm.proxy;

import com.github.hummel.drealm.api.API;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;

public interface CommonProxy {
	default void onInit(FMLInitializationEvent event) {
		API.setCommonMapImage(new ResourceLocation("drealm:map/map.png"));
	}

	void preInit(FMLPreInitializationEvent event);
}
