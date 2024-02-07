package com.github.hummel.drealm.init;

import com.github.hummel.drealm.entity.*;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeEntry;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class UnitTradeEntries {
	public static LOTRUnitTradeEntries redDwarfCommander;
	public static LOTRUnitTradeEntries windDwarfCommander;

	private UnitTradeEntries() {
	}

	public static void onInit() {
		redDwarfCommander = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(EntityRedDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(EntityRedDwarfWarrior.class, 30, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(EntityRedDwarfAxeThrower.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(EntityRedDwarfFireThrower.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(EntityRedDwarfWarrior.class, LOTREntityWildBoar.class, "RedDwarfWarrior_Boar", 50, 150.0f).setMountArmor(Items.boarArmorRedDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(EntityRedDwarfAxeThrower.class, LOTREntityWildBoar.class, "RedDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(Items.boarArmorRedDwarven).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF), new LOTRUnitTradeEntry(EntityRedDwarfBannerBearer.class, 50, 200.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_DWARF));
		windDwarfCommander = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(EntityWindDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(EntityWindDwarfWarrior.class, 30, 50.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(EntityWindDwarfAxeThrower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(EntityWindDwarfCrossbower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(EntityWindDwarfWarrior.class, LOTREntityWildBoar.class, "WindDwarfWarrior_Boar", 50, 150.0f).setMountArmor(Items.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(EntityWindDwarfAxeThrower.class, LOTREntityWildBoar.class, "WindDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(Items.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(EntityWindDwarfBannerBearer.class, 50, 200.0f).setPledgeExclusive());
	}
}