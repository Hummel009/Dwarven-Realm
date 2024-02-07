package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.world.map.LOTRWaypoint;

public class Roads {

	private Roads() {
	}

	public static void onInit() {
		API.registerRoad("EastWind", LOTRWaypoint.KHAND_NORTH_ROAD, new int[]{2043, 1357}, new int[]{2118, 1410}, new int[]{2216, 1518}, new int[]{2318, 1532}, Waypoints.bragazgathol);
		API.registerRoad("NaragGund", LOTRWaypoint.RHUN_EAST_CITY, LOTRWaypoint.BALCARAS, new int[]{2364, 1172}, Waypoints.naragGund);
		API.registerRoad("KheledDum", Waypoints.kheledDum, LOTRWaypoint.RHUN_ROAD_WAY, LOTRWaypoint.BALCARAS);
		API.registerRoad("KhibilTarag", Waypoints.khibilTarag, new int[]{2421, 1029}, LOTRWaypoint.BALCARAS);
	}
}