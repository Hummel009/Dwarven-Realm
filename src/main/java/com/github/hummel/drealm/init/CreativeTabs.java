package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRCreativeTabs;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class CreativeTabs {
	public static LOTRCreativeTabs tabCombat;
	public static LOTRCreativeTabs tabTools;
	public static LOTRCreativeTabs tabMaterials;
	public static LOTRCreativeTabs tabBlocks;

	private CreativeTabs() {
	}

	public static void preInit() {
		tabCombat = API.getLOTRCreativeTab("tabCombat");
		tabTools = API.getLOTRCreativeTab("tabTools");
		tabMaterials = API.getLOTRCreativeTab("tabMaterials");
		tabBlocks = API.getLOTRCreativeTab("tabBlock");
	}
}
