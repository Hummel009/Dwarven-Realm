package drealm.map;

import drealm.database.DRFaction;
import drealm.util.DRCommander;
import lotr.common.world.map.LOTRWaypoint;

public class DRWaypoint {
	public static LOTRWaypoint NARAG_GUND;
	public static LOTRWaypoint KHIBIL_TARAG;
	public static LOTRWaypoint KHELED_DUM;
	public static LOTRWaypoint RED_ROAD;
	public static LOTRWaypoint BRAGAZGATHOL;

	public static void preInit() {
		NARAG_GUND = DRCommander.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2579.0, 1262.0);
		KHIBIL_TARAG = DRCommander.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2448.0, 952.0);
		KHELED_DUM = DRCommander.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2382.0, 570.0);
		BRAGAZGATHOL = DRCommander.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2362.0, 1573.0);
	}
}