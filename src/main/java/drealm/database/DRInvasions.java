package drealm.database;

import drealm.entity.*;
import drealm.util.DRCommander;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRInvasions.InvasionSpawnEntry;

public class DRInvasions {
	public static LOTRInvasions RED_MOUNTAINS;
	public static LOTRInvasions WIND_MOUNTAINS;

	public static void addInvasionIcons() {
		DRCommander.changeInvasionIcon(RED_MOUNTAINS, DRRegistry.hammerRedDwarven);
		DRCommander.changeInvasionIcon(WIND_MOUNTAINS, DRRegistry.hammerWindDwarven);
	}

	public static void addInvasionMobs() {
		RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfWarrior.class, 10));
		RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfAxeThrower.class, 5));
		RED_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityRedDwarfBannerBearer.class, 2));

		WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfWarrior.class, 10));
		WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfAxeThrower.class, 5));
		WIND_MOUNTAINS.invasionMobs.add(new InvasionSpawnEntry(DREntityWindDwarfBannerBearer.class, 2));
	}

	public static void onInit() {
		setupInvasions();
		addInvasionIcons();
		addInvasionMobs();
	}

	public static void setupInvasions() {
		RED_MOUNTAINS = DRCommander.addInvasion("RED_MOUNTAINS", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRCommander.addInvasion("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
	}
}
