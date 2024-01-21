package drealm.biome;

import drealm.content.DRSpawnLists;
import drealm.entity.DREntityRedDwarfMerchant;
import drealm.structure.DRStructureRedMountainsHouse;
import drealm.structure.DRStructureRedMountainsSmithy;
import drealm.structure.DRStructureRedMountainsStronghold;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRBiomeSpawnList;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class DRBiomeRedMountains extends LOTRBiome {
	public DRBiomeRedMountains(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[1];
		arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(DRSpawnLists.redDwarves, 10);
		npcSpawnList.newFactionList(600).add(arrspawnListContainer);
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		decorator.biomeOreFactor = 2.0f;
		decorator.biomeGemFactor = 1.5f;
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 4, 60, Blocks.stone), 12.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.treesPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.MAPLE, 300);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 50);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		decorator.addRandomStructure(new DRStructureRedMountainsStronghold(false), 200);
		decorator.addRandomStructure(new DRStructureRedMountainsSmithy(false), 75);
		registerMountainsFlowers();
		addFlower(LOTRMod.dwarfHerb, 0, 1);
		biomeColors.setSky(13541522);
		registerTravellingTrader(DREntityRedDwarfMerchant.class);
		registerTravellingTrader(LOTREntityScrapTrader.class);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		WorldGenerator str = new DRStructureRedMountainsHouse(false);
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = 70 + random.nextInt(80);
			int k1 = k + random.nextInt(16) + 8;
			str.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int stoneHeight = 110 - rockDepth;
		int sandHeight = stoneHeight - 6;
		for (int j = ySize - 1; j >= sandHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			if (j >= stoneHeight) {
				blocks[index] = LOTRMod.rock;
				meta[index] = 4;
				continue;
			}
			blocks[index] = Blocks.sand;
			meta[index] = 1;
		}
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return LOTRAchievement.enterRedMountains;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DWARVEN.getSubregion("redMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.RED_MOUNTAINS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.2f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.DWARVEN;
	}
}