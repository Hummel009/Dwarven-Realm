package drealm.item;

import drealm.content.DRFactions;
import drealm.util.DRAPI;
import lotr.common.item.LOTRItemBanner;

public class DRItemBanner {
	public static LOTRItemBanner.BannerType redMountains;
	public static LOTRItemBanner.BannerType windMountains;

	public static void preInit() {
		redMountains = DRAPI.addBanner("red_mountains", DRFactions.redMountains);
		windMountains = DRAPI.addBanner("wind_mountains", DRFactions.windMountains);
	}
}