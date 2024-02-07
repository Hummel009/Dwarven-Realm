package com.github.hummel.drealm;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Config {
	public static boolean enableTextures14;
	public static boolean enableRussian;

	private static Configuration configuration;
	private static boolean loaded;

	private Config() {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		if (!loaded) {
			configuration = new Configuration(event.getSuggestedConfigurationFile());
			setDefaultValues();
		}
	}

	private static void setDefaultValues() {
		try {
			configuration.load();
			enableTextures14 = configuration.get("misc", "Enable 1.14 Textures", false).getBoolean();
			enableRussian = configuration.get("misc", "Enable Russian text assets", false).getBoolean();
		} catch (Exception e) {
			FMLLog.severe("Dwarven Realm has a problem loading it's configuration");
		} finally {
			configuration.save();
			loaded = true;
		}
	}
}