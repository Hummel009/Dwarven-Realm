package drealm.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DRConfig {
	public static Configuration config;
	public static List<String> allCategories;
	public static String CATEGORY_MISC;
	public static boolean enableTextures14;

	static {
		allCategories = new ArrayList<>();
		CATEGORY_MISC = getCategory("1_misc");
	}

	public static String getCategory(String category) {
		allCategories.add(category);
		return category;
	}

	public static void load() {
		enableTextures14 = config.get(CATEGORY_MISC, "Enable 1.14 Textures", false).getBoolean();
		if (config.hasChanged()) {
			config.save();
		}
	}

	public static void preInit() {
		config = new Configuration(new File("config", "Dwarven Realm.cfg"));
		load();
	}
}