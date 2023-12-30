package drealm.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class DRConfig {
	public static Configuration config;
	public static Collection<String> allCategories = new ArrayList<>();
	public static String CATEGORY_MISC = getCategory("1_misc");
	public static boolean enableTextures14;
	public static boolean enableRussian;

	public static String getCategory(String category) {
		allCategories.add(category);
		return category;
	}

	public static void load() {
		enableTextures14 = config.get(CATEGORY_MISC, "Enable 1.14 Textures", false).getBoolean();
		enableRussian = config.get(CATEGORY_MISC, "Enable Russian text assets", false).getBoolean();
		if (config.hasChanged()) {
			config.save();
		}
	}

	public static void preInit() {
		config = new Configuration(new File("config", "Dwarven Realm.cfg"));
		load();
	}
}