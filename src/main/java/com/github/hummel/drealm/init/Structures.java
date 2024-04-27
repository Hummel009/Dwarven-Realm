package com.github.hummel.drealm.init;

import com.github.hummel.drealm.structure.*;
import cpw.mods.fml.common.FMLLog;
import lotr.common.LOTRConfig;
import lotr.common.world.structure.LOTRWorldGenStructureBase;
import lotr.common.world.structure2.LOTRStructureTimelapse;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Structures {
	public static final Map<Integer, StructureColorInfo> STRUCTURE_ITEM_SPAWNERS = new LinkedHashMap<>();

	private static final Map<Integer, StructureProvider> ID_TO_CLASS_MAPPING = new HashMap<>();
	private static final Map<Integer, String> ID_TO_STRING_MAPPING = new HashMap<>();

	private Structures() {
	}

	public static String getNameFromID(int id) {
		return ID_TO_STRING_MAPPING.get(id);
	}

	public static StructureProvider getStructureForID(int id) {
		return ID_TO_CLASS_MAPPING.get(id);
	}

	@SuppressWarnings({"ValueOfIncrementOrDecrementUsed", "UnusedAssignment"})
	public static void onInit() {
		int id = 3000;
		registerStructure(id++, StructureRedMountainsHouse.class, "RedMountainsHouse", 0x570000, 0x570000);
		registerStructure(id++, StructureRedMountainsSmithy.class, "RedMountainsSmithy", 0x570000, 0x570000);
		registerStructure(id++, StructureRedMountainsStronghold.class, "RedMountainsStronghold", 0x570000, 0x570000);

		registerStructure(id++, StructureWindMountainsHouse.class, "WindMountainsHouse", 0xCEA863, 0xCEA863);
		registerStructure(id++, StructureWindMountainsSmithy.class, "WindMountainsSmithy", 0xCEA863, 0xCEA863);
		registerStructure(id++, StructureWindMountainsStronghold.class, "WindMountainsStronghold", 0xCEA863, 0xCEA863);
	}

	private static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG) {
		registerStructure(id, strClass, name, colorBG, colorFG, false);
	}

	private static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG, boolean hide) {
		StructureProvider strProvider = new StructureProvider(strClass);
		registerStructure(id, strProvider, name, colorBG, colorFG, hide);
	}

	public static class StructureProvider {
		private final Class<? extends WorldGenerator> strClass;

		protected StructureProvider(Class<? extends WorldGenerator> strClass) {
			this.strClass = strClass;
		}

		public boolean generateStructure(World world, EntityPlayer entityplayer, int i, int j, int k) {
			WorldGenerator generator = null;
			try {
				generator = strClass.getConstructor(Boolean.TYPE).newInstance(true);
			} catch (Exception e) {
				FMLLog.warning("Failed to build LOTR structure " + strClass.getName());
				e.printStackTrace();
			}
			if (generator != null) {
				boolean timelapse = LOTRConfig.strTimelapse;
				if (generator instanceof LOTRWorldGenStructureBase2) {
					LOTRWorldGenStructureBase2 strGen = (LOTRWorldGenStructureBase2) generator;
					strGen.restrictions = false;
					strGen.usingPlayer = entityplayer;
					if (timelapse) {
						LOTRStructureTimelapse.start(strGen, world, i, j, k);
						return true;
					}
					return strGen.generateWithSetRotation(world, world.rand, i, j, k, strGen.usingPlayerRotation());
				}
				if (generator instanceof LOTRWorldGenStructureBase) {
					LOTRWorldGenStructureBase strGen = (LOTRWorldGenStructureBase) generator;
					strGen.restrictions = false;
					strGen.usingPlayer = entityplayer;
					if (timelapse) {
						LOTRStructureTimelapse.start(strGen, world, i, j, k);
						return true;
					}
					return strGen.generate(world, world.rand, i, j, k);
				}
			}
			return false;
		}
	}

	private static void registerStructure(int id, StructureProvider str, String name, int colorBG, int colorFG, boolean hide) {
		if (ID_TO_CLASS_MAPPING.containsKey(id)) {
			throw new IllegalArgumentException("Structure ID " + id + " is already registered to " + name + '!');
		}
		ID_TO_CLASS_MAPPING.put(id, str);
		ID_TO_STRING_MAPPING.put(id, name);
		STRUCTURE_ITEM_SPAWNERS.put(id, new StructureColorInfo(id, colorBG, colorFG, false, hide));
	}

	public static class StructureColorInfo {
		private final int spawnedID;
		private final int colorBackground;
		private final int colorForeground;
		private final boolean isVillage;
		private final boolean isHidden;

		protected StructureColorInfo(int i, int colorBG, int colorFG, boolean vill, boolean hide) {
			spawnedID = i;
			colorBackground = colorBG;
			colorForeground = colorFG;
			isVillage = vill;
			isHidden = hide;
		}

		public int getSpawnedID() {
			return spawnedID;
		}

		public int getColorBackground() {
			return colorBackground;
		}

		public int getColorForeground() {
			return colorForeground;
		}

		public boolean isVillage() {
			return isVillage;
		}

		public boolean isHidden() {
			return isHidden;
		}
	}
}