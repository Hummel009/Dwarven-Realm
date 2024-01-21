package drealm.content;

import drealm.util.DRAPI;
import lotr.common.world.map.LOTRWaypoint;

public class DRWaypoints {
	public static LOTRWaypoint naragGund;
	public static LOTRWaypoint khibilTarag;
	public static LOTRWaypoint kheledDum;
	public static LOTRWaypoint redRoad;
	public static LOTRWaypoint bragazgathol;

	public static void preInit() {
		naragGund = DRAPI.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, DRFactions.redMountains, 2579.0, 1262.0);
		khibilTarag = DRAPI.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, DRFactions.redMountains, 2448.0, 952.0);
		kheledDum = DRAPI.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, DRFactions.redMountains, 2382.0, 570.0);
		bragazgathol = DRAPI.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, DRFactions.windMountains, 2362.0, 1573.0);
	}
}