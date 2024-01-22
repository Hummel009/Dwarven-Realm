package drealm.entity;

import lotr.common.entity.LOTREntities;

public class DREntity {
	private static int id = 3000;

	private DREntity() {
	}

	public static void preInit() {
		LOTREntities.registerCreature(DREntityRedDwarf.class, "RedDwarf", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfWarrior.class, "RedDwarfWarrior", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfAxeThrower.class, "RedDwarfAxeThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfFireThrower.class, "RedDwarfFireThrower", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfBannerBearer.class, "RedDwarfBannerBearer", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfCommander.class, "RedDwarfCommander", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfMiner.class, "RedDwarfMiner", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfMerchant.class, "RedDwarfMerchant", id++, 0x570000, 0x570000);
		LOTREntities.registerCreature(DREntityRedDwarfSmith.class, "RedDwarfSmith", id++, 0x570000, 0x570000);

		LOTREntities.registerCreature(DREntityWindDwarf.class, "WindDwarf", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfWarrior.class, "WindDwarfWarrior", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfAxeThrower.class, "WindDwarfAxeThrower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfCrossbower.class, "WindDwarfCrossbower", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfBannerBearer.class, "WindDwarfBannerBearer", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfCommander.class, "WindDwarfCommander", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfMiner.class, "WindDwarfMiner", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfMerchant.class, "WindDwarfMerchant", id++, 0xCEA863, 0xCEA863);
		LOTREntities.registerCreature(DREntityWindDwarfSmith.class, "WindDwarfSmith", id++, 0xCEA863, 0xCEA863);
	}
}
