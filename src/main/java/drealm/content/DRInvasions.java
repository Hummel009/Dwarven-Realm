package drealm.content;

import drealm.entity.*;
import drealm.util.DRAPI;
import lotr.common.world.spawning.LOTRInvasions;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRInvasions {
	public static LOTRInvasions redMountains;
	public static LOTRInvasions windMountains;

	private DRInvasions() {
	}

	private static void addInvasionIcons() {
		DRAPI.changeInvasionIcon(redMountains, DRItems.hammerRedDwarven);
		DRAPI.changeInvasionIcon(windMountains, DRItems.hammerWindDwarven);
	}

	private static void addInvasionMobs() {
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityRedDwarfWarrior.class, 10));
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityRedDwarfAxeThrower.class, 5));
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityRedDwarfBannerBearer.class, 2));

		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityWindDwarfWarrior.class, 10));
		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityWindDwarfAxeThrower.class, 5));
		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(DREntityWindDwarfBannerBearer.class, 2));
	}

	public static void onInit() {
		setupInvasions();
		addInvasionIcons();
		addInvasionMobs();
	}

	private static void setupInvasions() {
		redMountains = DRAPI.addInvasion("RED_MOUNTAINS", DRFactions.redMountains);
		windMountains = DRAPI.addInvasion("WIND_MOUNTAINS", DRFactions.windMountains);
	}
}
