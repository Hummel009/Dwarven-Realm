package drealm.map;

import drealm.database.DRFaction;
import drealm.util.DRReflectionHelper;
import lotr.common.world.map.LOTRWaypoint;

public class DRWaypoint {
	public static LOTRWaypoint NARAG_GUND;
	public static LOTRWaypoint KHIBIL_TARAG;
	public static LOTRWaypoint KHELED_DUM;
	public static LOTRWaypoint RED_ROAD;
	public static LOTRWaypoint BRAGAZGATHOL;

	public static void preInit() {
		NARAG_GUND = DRReflectionHelper.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2579.0, 1262.0);
		KHIBIL_TARAG = DRReflectionHelper.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2448.0, 952.0);
		KHELED_DUM = DRReflectionHelper.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, DRFaction.RED_MOUNTAINS, 2382.0, 570.0);
		BRAGAZGATHOL = DRReflectionHelper.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, DRFaction.WIND_MOUNTAINS, 2362.0, 1573.0);
	}
}
