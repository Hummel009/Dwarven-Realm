package drealm.content;

import drealm.entity.*;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeEntry;

public class DRUnitTradeEntries {
	public static LOTRUnitTradeEntries redDwarfCommander;
	public static LOTRUnitTradeEntries windDwarfCommander;

	public static void onInit() {
		redDwarfCommander = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityRedDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityRedDwarfWarrior.class, 30, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityRedDwarfAxeThrower.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityRedDwarfFireThrower.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityRedDwarfWarrior.class, LOTREntityWildBoar.class, "RedDwarfWarrior_Boar", 50, 150.0f).setMountArmor(DRItems.boarArmorRedDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityRedDwarfAxeThrower.class, LOTREntityWildBoar.class, "RedDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(DRItems.boarArmorRedDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(DREntityRedDwarfBannerBearer.class, 50, 200.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF));
		windDwarfCommander = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityWindDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, 30, 50.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfCrossbower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, LOTREntityWildBoar.class, "WindDwarfWarrior_Boar", 50, 150.0f).setMountArmor(DRItems.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, LOTREntityWildBoar.class, "WindDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(DRItems.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfBannerBearer.class, 50, 200.0f).setPledgeExclusive());
	}
}