package com.github.hummel.drealm.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public interface CommonProxy {
	void onInit(FMLInitializationEvent event);

	void preInit(FMLPreInitializationEvent event);
}
