package com.github.hummel.drealm.init;

import com.github.hummel.drealm.entity.*;
import com.github.hummel.drealm.util.EnumHelper;
import com.github.hummel.drealm.util.ReflectionHelper;
import lotr.common.world.spawning.LOTRInvasions;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Invasions {
	public static LOTRInvasions redMountains;
	public static LOTRInvasions windMountains;

	private Invasions() {
	}

	private static void addInvasionIcons() {
		ReflectionHelper.changeInvasionIcon(redMountains, Items.hammerRedDwarven);
		ReflectionHelper.changeInvasionIcon(windMountains, Items.hammerWindDwarven);
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
		redMountains = EnumHelper.addInvasion("RED_MOUNTAINS", Factions.redMountains);
		windMountains = EnumHelper.addInvasion("WIND_MOUNTAINS", Factions.windMountains);
	}
}
