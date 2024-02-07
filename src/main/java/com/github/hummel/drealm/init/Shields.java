package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import net.minecraft.util.ResourceLocation;

import java.util.Locale;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Shields {
	public static LOTRShields alignmentWindMountains;
	public static LOTRShields alignmentRedMountains;

	private Shields() {
	}

	private static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		LOTRShields shield = API.addAlignmentShield(enumName, faction);
		API.setShieldTexture(shield, new ResourceLocation("com/github/hummel/drealm", "shield/" + shield.name().toLowerCase(Locale.ROOT) + ".png"));
		return shield;
	}

	public static void preInit() {
		alignmentWindMountains = addAlignmentShield("ALIGNMENT_WIND_MOUNTAINS", Factions.windMountains);
		alignmentRedMountains = addAlignmentShield("ALIGNMENT_RED_MOUNTAINS", Factions.redMountains);
	}
}
