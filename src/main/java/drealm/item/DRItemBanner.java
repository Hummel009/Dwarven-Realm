package drealm.item;

import drealm.database.DRFaction;
import drealm.util.DRCommander;
import lotr.common.item.LOTRItemBanner;
import lotr.common.recipe.LOTRRecipes;
import net.minecraft.init.Blocks;

public class DRItemBanner {
	public static LOTRItemBanner.BannerType RED_MOUNTAINS;
	public static LOTRItemBanner.BannerType WIND_MOUNTAINS;

	public static void preInit() {
		RED_MOUNTAINS = DRCommander.addBanner("red_mountains", DRFaction.RED_MOUNTAINS);
		WIND_MOUNTAINS = DRCommander.addBanner("wind_mountains", DRFaction.WIND_MOUNTAINS);
	}
}
