package com.github.hummel.drealm.init;

import com.github.hummel.drealm.util.EnumHelper;
import lotr.common.world.map.LOTRWaypoint;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Waypoints {
	public static LOTRWaypoint naragGund;
	public static LOTRWaypoint khibilTarag;
	public static LOTRWaypoint kheledDum;
	public static LOTRWaypoint redRoad;
	public static LOTRWaypoint bragazgathol;

	private Waypoints() {
	}

	public static void preInit() {
		naragGund = EnumHelper.addWaypoint("NARAG_GUND", LOTRWaypoint.Region.RHUN, Factions.redMountains, 2579.0, 1262.0);
		khibilTarag = EnumHelper.addWaypoint("KHIBIL_TARAG", LOTRWaypoint.Region.RHUN, Factions.redMountains, 2448.0, 952.0);
		kheledDum = EnumHelper.addWaypoint("KHELED_DUM", LOTRWaypoint.Region.RHUN, Factions.redMountains, 2382.0, 570.0);
		bragazgathol = EnumHelper.addWaypoint("BRAGAZGATHOL", LOTRWaypoint.Region.RHUN, Factions.windMountains, 2362.0, 1573.0);
	}
}