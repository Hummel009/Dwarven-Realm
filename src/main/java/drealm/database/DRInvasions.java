package drealm.database;

import drealm.entity.*;
import drealm.util.DRCommander;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRInvasions.InvasionSpawnEntry;

public class DRInvasions {
	public static LOTRInvasions RED_MOUNTAINS;
	public static LOTRInvasions WIND_MOUNTAINS;

	public static void onInit() {
		DRInvasions.setupInvasions();
		DRInvasions.addInvasionIcons();
		DRInvasions.addInvasionMobs();
	}

	private static void setupInvasions() {
		RED_MOUNTAINS = DRCommander.addInvasion("RED_MOUNTAINS", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRCommander.addInvasion("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
	}

	private static void addInvasionIcons() {
		DRCommander.changeInvasionIcon(RED_MOUNTAINS, DRRegistry.hammer_red_dwarven);
		DRCommander.changeInvasionIcon(WIND_MOUNTAINS, DRRegistry.hammer_wind_dwarven);
	}

	private static void addInvasionMobs() {
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfWarrior.class, 10));
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfAxeThrower.class, 5));
		DRInvasions.RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfBannerBearer.class, 2));

		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfWarrior.class, 10));
		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfAxeThrower.class, 5));
		DRInvasions.WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfBannerBearer.class, 2));
	}
}
