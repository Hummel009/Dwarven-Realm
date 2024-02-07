package com.github.hummel.drealm.init;

import com.github.hummel.drealm.biome.BiomeRedMountains;
import com.github.hummel.drealm.biome.BiomeRedMountainsFoothills;
import com.github.hummel.drealm.biome.BiomeWindMountains;
import com.github.hummel.drealm.biome.BiomeWindMountainsFoothills;
import lotr.common.LOTRDimension;
import lotr.common.world.biome.LOTRBiome;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Biomes {
	public static LOTRBiome redMountains;
	public static LOTRBiome redMountainsFoothills;
	public static LOTRBiome windMountains;
	public static LOTRBiome windMountainsFoothills;

	private Biomes() {
	}

	public static void onInit() {
		for (int i : new int[]{117, 118, 164, 165}) {
			LOTRDimension.MIDDLE_EARTH.biomeList[i] = null;
		}
		redMountains = new BiomeRedMountains(117, true).setTemperatureRainfall(0.3f, 0.4f).setMinMaxHeight(1.5f, 2.0f).setColor(0x93714D).setBiomeName("redMountains");
		redMountainsFoothills = new BiomeRedMountainsFoothills(118, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.5f, 0.9f).setColor(0x999453).setBiomeName("redMountainsFoothills");
		windMountains = new BiomeWindMountains(164, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(0xD3D3D4).setBiomeName("windMountains");
		windMountainsFoothills = new BiomeWindMountainsFoothills(165, true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(0.5f, 0.6f).setColor(0x9A9F6B).setBiomeName("windMountainsFoothills");
	}
}