package drealm.content;

import drealm.entity.*;
import drealm.util.DRAPI;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRSpawnLists {
	public static LOTRSpawnList redDwarves;
	public static LOTRSpawnList windDwarves;

	private DRSpawnLists() {
	}

	public static void onInit() {
		redDwarves = DRAPI.newLOTRSpawnList(new LOTRSpawnEntry(DREntityRedDwarf.class, 100, 4, 4), new LOTRSpawnEntry(DREntityRedDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(DREntityRedDwarfWarrior.class, 20, 4, 4), new LOTRSpawnEntry(DREntityRedDwarfAxeThrower.class, 10, 4, 4), new LOTRSpawnEntry(DREntityRedDwarfFireThrower.class, 10, 4, 4));
		windDwarves = DRAPI.newLOTRSpawnList(new LOTRSpawnEntry(DREntityWindDwarf.class, 100, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(DREntityWindDwarfWarrior.class, 20, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfAxeThrower.class, 10, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfCrossbower.class, 10, 4, 4));
	}
}