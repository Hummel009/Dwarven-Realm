package drealm.database;

import drealm.util.DRCommander;
import lotr.common.LOTRCreativeTabs;

public class DRCreativeTabs {
	public static LOTRCreativeTabs tabCombat;
	public static LOTRCreativeTabs tabTools;
	public static LOTRCreativeTabs tabMaterials;
	public static LOTRCreativeTabs tabBlocks;

	public static void preInit() {
		tabCombat = DRCommander.getLOTRCreativeTab("tabCombat");
		tabTools = DRCommander.getLOTRCreativeTab("tabTools");
		tabMaterials = DRCommander.getLOTRCreativeTab("tabMaterials");
		tabBlocks = DRCommander.getLOTRCreativeTab("tabBlock");
	}
}
