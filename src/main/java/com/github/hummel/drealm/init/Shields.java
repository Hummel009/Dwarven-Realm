package com.github.hummel.drealm.init;

import com.github.hummel.drealm.util.EnumHelper;
import lotr.common.LOTRShields;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Shields {
	public static LOTRShields alignmentWindMountains;
	public static LOTRShields alignmentRedMountains;

	private Shields() {
	}

	public static void preInit() {
		alignmentWindMountains = EnumHelper.addAlignmentShield("ALIGNMENT_WIND_MOUNTAINS", Factions.windMountains);
		alignmentRedMountains = EnumHelper.addAlignmentShield("ALIGNMENT_RED_MOUNTAINS", Factions.redMountains);
	}
}
