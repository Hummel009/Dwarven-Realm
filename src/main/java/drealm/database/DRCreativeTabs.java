package drealm.database;

import drealm.util.DRReflectionHelper;
import lotr.common.LOTRCreativeTabs;

public class DRCreativeTabs {
	public static LOTRCreativeTabs tabCombat;
	public static LOTRCreativeTabs tabTools;
	public static LOTRCreativeTabs tabMaterials;
	public static LOTRCreativeTabs tabBlocks;

	public static void preInit() {
		tabCombat = DRReflectionHelper.getLOTRCreativeTab("tabCombat");
		tabTools = DRReflectionHelper.getLOTRCreativeTab("tabTools");
		tabMaterials = DRReflectionHelper.getLOTRCreativeTab("tabMaterials");
		tabBlocks = DRReflectionHelper.getLOTRCreativeTab("tabBlock");
	}
}
