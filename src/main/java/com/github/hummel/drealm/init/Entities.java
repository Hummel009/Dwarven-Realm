package com.github.hummel.drealm.init;

import com.github.hummel.drealm.entity.*;
import lotr.common.entity.LOTREntities;

public class Entities {
	private Entities() {
	}

	@SuppressWarnings({"ValueOfIncrementOrDecrementUsed", "UnusedAssignment"})
	public static void preInit() {
		int id = 3000;
		LOTREntities.registerCreature(EntityRedDwarf.class, "RedDwarf", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfWarrior.class, "RedDwarfWarrior", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfAxeThrower.class, "RedDwarfAxeThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfFireThrower.class, "RedDwarfFireThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfBannerBearer.class, "RedDwarfBannerBearer", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfCommander.class, "RedDwarfCommander", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfMiner.class, "RedDwarfMiner", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfMerchant.class, "RedDwarfMerchant", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(EntityRedDwarfSmith.class, "RedDwarfSmith", id++, 0x570000, 0x570000);

		LOTREntities.registerCreature(EntityWindDwarf.class, "WindDwarf", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfWarrior.class, "WindDwarfWarrior", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfAxeThrower.class, "WindDwarfAxeThrower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfCrossbower.class, "WindDwarfCrossbower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfBannerBearer.class, "WindDwarfBannerBearer", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfCommander.class, "WindDwarfCommander", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfMiner.class, "WindDwarfMiner", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfMerchant.class, "WindDwarfMerchant", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(EntityWindDwarfSmith.class, "WindDwarfSmith", id++, 0xCEA863, 0xCEA863);
	}
}
