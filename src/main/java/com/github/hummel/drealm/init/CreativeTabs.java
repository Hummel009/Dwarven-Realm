package com.github.hummel.drealm.init;

import com.github.hummel.drealm.util.ReflectionHelper;
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
		tabCombat = ReflectionHelper.getLOTRCreativeTab("tabCombat");
		tabTools = ReflectionHelper.getLOTRCreativeTab("tabTools");
		tabMaterials = ReflectionHelper.getLOTRCreativeTab("tabMaterials");
		tabBlocks = ReflectionHelper.getLOTRCreativeTab("tabBlock");
	}
}
