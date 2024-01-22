package drealm.content;

import drealm.util.DRAPI;
import lotr.common.LOTRCreativeTabs;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRCreativeTabs {
	public static LOTRCreativeTabs tabCombat;
	public static LOTRCreativeTabs tabTools;
	public static LOTRCreativeTabs tabMaterials;
	public static LOTRCreativeTabs tabBlocks;

	private DRCreativeTabs() {
	}

	public static void preInit() {
		tabCombat = DRAPI.getLOTRCreativeTab("tabCombat");
		tabTools = DRAPI.getLOTRCreativeTab("tabTools");
		tabMaterials = DRAPI.getLOTRCreativeTab("tabMaterials");
		tabBlocks = DRAPI.getLOTRCreativeTab("tabBlock");
	}
}
