package drealm.util;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRConfig {
	private static final String CATEGORY_MISC = "1_misc";
	private static Configuration config;

	public static boolean enableTextures14;
	public static boolean enableRussian;

	private DRConfig() {
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