package drealm.structure;

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

public class DRStructure {
	public static final Map<Integer, StructureColorInfo> STRUCTURE_ITEM_SPAWNERS = new LinkedHashMap<>();

	private static final Map<Integer, IStructureProvider> ID_TO_CLASS_MAPPING = new HashMap<>();
	private static final Map<Integer, String> ID_TO_STRING_MAPPING = new HashMap<>();
	private static int id = 3000;

	private DRStructure() {
	}

	public static String getNameFromID(int id) {
		return ID_TO_STRING_MAPPING.get(id);
	}

	public static IStructureProvider getStructureForID(int id) {
		return ID_TO_CLASS_MAPPING.get(id);
	}

	public static void onInit() {
		registerStructure(id++, DRStructureRedMountainsHouse.class, "RedMountainsHouse", 0x570000, 0x570000);
		registerStructure(id++, DRStructureRedMountainsSmithy.class, "RedMountainsSmithy", 0x570000, 0x570000);
		registerStructure(id++, DRStructureRedMountainsStronghold.class, "RedMountainsStronghold", 0x570000, 0x570000);

		registerStructure(id++, DRStructureWindMountainsHouse.class, "WindMountainsHouse", 0xCEA863, 0xCEA863);
		registerStructure(id++, DRStructureWindMountainsSmithy.class, "WindMountainsSmithy", 0xCEA863, 0xCEA863);
		registerStructure(id++, DRStructureWindMountainsStronghold.class, "WindMountainsStronghold", 0xCEA863, 0xCEA863);
	}

	private static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG) {
		registerStructure(id, strClass, name, colorBG, colorFG, false);
	}

	private static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG, boolean hide) {
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
		registerStructure(id, strProvider, name, colorBG, colorFG, hide);
	}

	private static void registerStructure(int id, IStructureProvider str, String name, int colorBG, int colorFG, boolean hide) {
		if (ID_TO_CLASS_MAPPING.containsKey(id)) {
			throw new IllegalArgumentException("Structure ID " + id + " is already registered to " + name + '!');
		}
		ID_TO_CLASS_MAPPING.put(id, str);
		ID_TO_STRING_MAPPING.put(id, name);
		STRUCTURE_ITEM_SPAWNERS.put(id, new StructureColorInfo(id, colorBG, colorFG, str.isVillage(), hide));
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

		protected StructureColorInfo(int i, int colorBG, int colorFG, boolean vill, boolean hide) {
			spawnedID = i;
			colorBackground = colorBG;
			colorForeground = colorFG;
			isVillage = vill;
			isHidden = hide;
		}
	}
}