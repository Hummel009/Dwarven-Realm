package drealm.structure;

import java.util.*;

import cpw.mods.fml.common.FMLLog;
import lotr.common.LOTRConfig;
import lotr.common.world.structure.LOTRWorldGenStructureBase;
import lotr.common.world.structure2.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DRStructure {
	public static Map<Integer, IStructureProvider> idToClassMapping = new HashMap();
	public static Map<Integer, String> idToStringMapping = new HashMap();
	public static Map<Integer, StructureColorInfo> structureItemSpawners = new LinkedHashMap<>();
	public static int id = 3000;

	public static String getNameFromID(int ID) {
		return idToStringMapping.get(ID);
	}

	public static IStructureProvider getStructureForID(int ID) {
		return idToClassMapping.get(ID);
	}

	public static void preInit() {
		DRStructure.registerStructure(id++, DRStructureRedMountainsHouse.class, "RedMountainsHouse", 0x570000, 0x570000);
		DRStructure.registerStructure(id++, DRStructureRedMountainsSmithy.class, "RedMountainsSmithy", 0x570000, 0x570000);
		DRStructure.registerStructure(id++, DRStructureRedMountainsStronghold.class, "RedMountainsStronghold", 0x570000, 0x570000);

		DRStructure.registerStructure(id++, DRStructureWindMountainsHouse.class, "WindMountainsHouse", 0xCEA863, 0xCEA863);
		DRStructure.registerStructure(id++, DRStructureWindMountainsSmithy.class, "WindMountainsSmithy", 0xCEA863, 0xCEA863);
		DRStructure.registerStructure(id++, DRStructureWindMountainsStronghold.class, "WindMountainsStronghold", 0xCEA863, 0xCEA863);
	}

	public static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG) {
		DRStructure.registerStructure(id, strClass, name, colorBG, colorFG, false);
	}

	public static void registerStructure(int id, final Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG, boolean hide) {
		IStructureProvider strProvider = new IStructureProvider() {

			@Override
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

			@Override
			public boolean isVillage() {
				return false;
			}
		};
		DRStructure.registerStructure(id, strProvider, name, colorBG, colorFG, hide);
	}

	public static void registerStructure(int id, IStructureProvider str, String name, int colorBG, int colorFG, boolean hide) {
		if (idToClassMapping.containsKey(id)) {
			throw new IllegalArgumentException("Structure ID " + id + " is already registered to " + name + "!");
		}
		idToClassMapping.put(id, str);
		idToStringMapping.put(id, name);
		structureItemSpawners.put(id, new StructureColorInfo(id, colorBG, colorFG, str.isVillage(), hide));
	}

	public interface IStructureProvider {
		boolean generateStructure(World var1, EntityPlayer var2, int var3, int var4, int var5);

		boolean isVillage();
	}

	public static class StructureColorInfo {
		public final int spawnedID;
		public final int colorBackground;
		public final int colorForeground;
		public final boolean isVillage;
		public final boolean isHidden;

		public StructureColorInfo(int i, int colorBG, int colorFG, boolean vill, boolean hide) {
			spawnedID = i;
			colorBackground = colorBG;
			colorForeground = colorFG;
			isVillage = vill;
			isHidden = hide;
		}
	}

}
