package drealm.content;

import drealm.util.DRAPI;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import net.minecraft.util.ResourceLocation;

import java.util.Locale;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRShields {
	public static LOTRShields alignmentWindMountains;
	public static LOTRShields alignmentRedMountains;

	private DRShields() {
	}

	private static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		LOTRShields shield = DRAPI.addAlignmentShield(enumName, faction);
		DRAPI.setShieldTexture(shield, new ResourceLocation("drealm", "shield/" + shield.name().toLowerCase(Locale.ROOT) + ".png"));
		return shield;
	}

	public static void preInit() {
		alignmentWindMountains = addAlignmentShield("ALIGNMENT_WIND_MOUNTAINS", DRFactions.windMountains);
		alignmentRedMountains = addAlignmentShield("ALIGNMENT_RED_MOUNTAINS", DRFactions.redMountains);
	}
}
