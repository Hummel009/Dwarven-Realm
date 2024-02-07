package com.github.hummel.drealm.item;

import com.github.hummel.drealm.api.API;
import com.github.hummel.drealm.init.Factions;
import lotr.common.item.LOTRItemBanner;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class ItemBanner {
	public static LOTRItemBanner.BannerType redMountains;
	public static LOTRItemBanner.BannerType windMountains;

	private ItemBanner() {
	}

	public static void preInit() {
		redMountains = API.addBanner("red_mountains", Factions.redMountains);
		windMountains = API.addBanner("wind_mountains", Factions.windMountains);
	}
}