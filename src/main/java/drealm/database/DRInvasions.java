package drealm.database;

import drealm.entity.*;
import drealm.util.DRReflectionHelper;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRInvasions.InvasionSpawnEntry;

public class DRInvasions {
	public static LOTRInvasions RED_MOUNTAINS;
	public static LOTRInvasions WIND_MOUNTAINS;

	private static void addInvasionIcons() {
		DRReflectionHelper.changeInvasionIcon(RED_MOUNTAINS, DRRegistry.hammer_red_dwarven);
		DRReflectionHelper.changeInvasionIcon(WIND_MOUNTAINS, DRRegistry.hammer_wind_dwarven);
	}

	private static void addInvasionMobs() {
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfWarrior.class, 10));
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfAxeThrower.class, 5));
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfBannerBearer.class, 2));

		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfWarrior.class, 10));
		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfAxeThrower.class, 5));
		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfBannerBearer.class, 2));
	}

	public static void onInit() {
		DRInvasions.setupInvasions();
		DRInvasions.addInvasionIcons();
		DRInvasions.addInvasionMobs();
	}

	private static void setupInvasions() {
		RED_MOUNTAINS = DRReflectionHelper.addInvasion("RED_MOUNTAINS", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRReflectionHelper.addInvasion("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
	}
}
