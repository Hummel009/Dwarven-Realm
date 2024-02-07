package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.entity.*;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class SpawnLists {
	public static LOTRSpawnList redDwarves;
	public static LOTRSpawnList windDwarves;

	private SpawnLists() {
	}

	public static void onInit() {
		redDwarves = API.addLotrSpawnList(new LOTRSpawnEntry(EntityRedDwarf.class, 100, 4, 4), new LOTRSpawnEntry(EntityRedDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(EntityRedDwarfWarrior.class, 20, 4, 4), new LOTRSpawnEntry(EntityRedDwarfAxeThrower.class, 10, 4, 4), new LOTRSpawnEntry(EntityRedDwarfFireThrower.class, 10, 4, 4));
		windDwarves = API.addLotrSpawnList(new LOTRSpawnEntry(EntityWindDwarf.class, 100, 4, 4), new LOTRSpawnEntry(EntityWindDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(EntityWindDwarfWarrior.class, 20, 4, 4), new LOTRSpawnEntry(EntityWindDwarfAxeThrower.class, 10, 4, 4), new LOTRSpawnEntry(EntityWindDwarfCrossbower.class, 10, 4, 4));
	}
}