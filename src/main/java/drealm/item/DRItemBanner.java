package drealm.item;

import drealm.database.DRFaction;
import drealm.util.DRReflectionHelper;
import lotr.common.item.LOTRItemBanner;

public class DRItemBanner {
	public static LOTRItemBanner.BannerType RED_MOUNTAINS;
	public static LOTRItemBanner.BannerType WIND_MOUNTAINS;

	public static void preInit() {
		RED_MOUNTAINS = DRReflectionHelper.addBanner("red_mountains", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRReflectionHelper.addBanner("wind_mountains", DRFaction.WIND_MOUNTAINS);
	}
}
