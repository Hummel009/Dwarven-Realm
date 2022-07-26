package drealm.database;

import drealm.util.DRCommander;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import net.minecraft.util.ResourceLocation;

public class DRShields {
	public static LOTRShields ALIGNMENT_WIND_MOUNTAINS;
	public static LOTRShields ALIGNMENT_RED_MOUNTAINS;

	private static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		LOTRShields shield = DRCommander.addAlignmentShield(enumName, faction);
		shield.shieldTexture = new ResourceLocation("drealm", "shield/" + shield.name().toLowerCase() + ".png");
		return shield;
	}

	public static void onInit() {
		ALIGNMENT_WIND_MOUNTAINS = DRShields.addAlignmentShield("ALIGNMENT_WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
		ALIGNMENT_RED_MOUNTAINS = DRShields.addAlignmentShield("ALIGNMENT_RED_MOUNTAINS", DRFaction.RED_MOUNTAINS);
	}
}
