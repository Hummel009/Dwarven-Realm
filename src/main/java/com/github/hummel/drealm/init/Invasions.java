package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.entity.*;
import lotr.common.world.spawning.LOTRInvasions;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Invasions {
	public static LOTRInvasions redMountains;
	public static LOTRInvasions windMountains;

	private Invasions() {
	}

	private static void addInvasionIcons() {
		API.changeInvasionIcon(redMountains, Items.hammerRedDwarven);
		API.changeInvasionIcon(windMountains, Items.hammerWindDwarven);
	}

	private static void addInvasionMobs() {
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityRedDwarfWarrior.class, 10));
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityRedDwarfAxeThrower.class, 5));
		redMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityRedDwarfBannerBearer.class, 2));

		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityWindDwarfWarrior.class, 10));
		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityWindDwarfAxeThrower.class, 5));
		windMountains.invasionMobs.add(new LOTRInvasions.InvasionSpawnEntry(EntityWindDwarfBannerBearer.class, 2));
	}

	public static void onInit() {
		setupInvasions();
		addInvasionIcons();
		addInvasionMobs();
	}

	private static void setupInvasions() {
		redMountains = API.addInvasion("RED_MOUNTAINS", Factions.redMountains);
		windMountains = API.addInvasion("WIND_MOUNTAINS", Factions.windMountains);
	}
}
