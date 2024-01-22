package drealm.content;

import drealm.util.DRAPI;
import lotr.common.world.map.LOTRWaypoint;

public class DRRoads {

	private DRRoads() {
	}

	public static void onInit() {
		DRAPI.registerRoad("EastWind", LOTRWaypoint.KHAND_NORTH_ROAD, new int[]{2043, 1357}, new int[]{2118, 1410}, new int[]{2216, 1518}, new int[]{2318, 1532}, DRWaypoints.bragazgathol);
		DRAPI.registerRoad("NaragGund", LOTRWaypoint.RHUN_EAST_CITY, LOTRWaypoint.BALCARAS, new int[]{2364, 1172}, DRWaypoints.naragGund);
		DRAPI.registerRoad("KheledDum", DRWaypoints.kheledDum, LOTRWaypoint.RHUN_ROAD_WAY, LOTRWaypoint.BALCARAS);
		DRAPI.registerRoad("KhibilTarag", DRWaypoints.khibilTarag, new int[]{2421, 1029}, LOTRWaypoint.BALCARAS);
	}
}