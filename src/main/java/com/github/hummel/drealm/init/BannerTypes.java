package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.item.LOTRItemBanner;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class BannerTypes {
	public static LOTRItemBanner.BannerType redMountains;
	public static LOTRItemBanner.BannerType windMountains;

	private BannerTypes() {
	}

	public static void preInit() {
		redMountains = API.addBanner("red_mountains", Factions.redMountains);
		windMountains = API.addBanner("wind_mountains", Factions.windMountains);
	}
}