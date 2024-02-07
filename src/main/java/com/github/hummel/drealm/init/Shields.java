package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRShields;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Shields {
	public static LOTRShields alignmentWindMountains;
	public static LOTRShields alignmentRedMountains;

	private Shields() {
	}

	public static void preInit() {
		alignmentWindMountains = API.addAlignmentShield("ALIGNMENT_WIND_MOUNTAINS", Factions.windMountains);
		alignmentRedMountains = API.addAlignmentShield("ALIGNMENT_RED_MOUNTAINS", Factions.redMountains);
	}
}
