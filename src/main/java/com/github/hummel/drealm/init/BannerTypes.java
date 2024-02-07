package com.github.hummel.drealm.init;

import com.github.hummel.drealm.util.EnumHelper;
import lotr.common.item.LOTRItemBanner;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class BannerTypes {
	public static LOTRItemBanner.BannerType redMountains;
	public static LOTRItemBanner.BannerType windMountains;

	private BannerTypes() {
	}

	public static void preInit() {
		redMountains = EnumHelper.addBanner("red_mountains", Factions.redMountains);
		windMountains = EnumHelper.addBanner("wind_mountains", Factions.windMountains);
	}
}