package com.github.hummel.drealm.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements CommonProxy {
	@Override
	public void onInit(FMLInitializationEvent event) {
		CommonProxy.super.onInit(event);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	}
}