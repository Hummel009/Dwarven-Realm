package com.github.hummel.drealm.biome;

import com.github.hummel.drealm.entity.EntityWindDwarfMerchant;
import com.github.hummel.drealm.init.SpawnLists;
import com.github.hummel.drealm.structure.StructureWindMountainsHouse;
import com.github.hummel.drealm.structure.StructureWindMountainsSmithy;
import com.github.hummel.drealm.structure.StructureWindMountainsStronghold;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.feature.LOTRWorldGenMountainsideBush;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRBiomeSpawnList;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeWindMountains extends LOTRBiome {
	public BiomeWindMountains(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[1];
		arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(SpawnLists.windDwarves, 10);
		npcSpawnList.newFactionList(600).add(arrspawnListContainer);
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.3f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.3f);
		decorator.biomeGemFactor = 1.0f;
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.SPRUCE, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 50);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA_THIN, 10);
		decorator.addTree(LOTRTreeType.LARCH, 500);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		decorator.addTree(LOTRTreeType.MAPLE, 300);
		decorator.addRandomStructure(new StructureWindMountainsStronghold(false), 200);
		decorator.addRandomStructure(new StructureWindMountainsSmithy(false), 75);
		registerMountainsFlowers();
		biomeColors.setSky(11653858);
		registerTravellingTrader(EntityWindDwarfMerchant.class);
		registerTravellingTrader(LOTREntityScrapTrader.class);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		WorldGenerator str1 = new LOTRWorldGenMountainsideBush(LOTRMod.leaves5, 0);
		WorldGenerator str2 = new StructureWindMountainsHouse(false);
		for (int l = 0; l < 3; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = MathHelper.getRandomIntegerInRange(random, 70, 160);
			int k1 = k + random.nextInt(16) + 8;
			str1.generate(world, random, i1, j1, k1);
		}
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = 70 + random.nextInt(80);
			int k1 = k + random.nextInt(16) + 8;
			str2.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 150 - rockDepth;
		int stoneHeight = snowHeight - 40;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (j >= snowHeight && block == topBlock) {
				blocks[index] = Blocks.snow;
				meta[index] = 0;
			} else if (block == topBlock || block == fillerBlock) {
				blocks[index] = Blocks.stone;
				meta[index] = 0;
			}
			block = blocks[index];
			if (block != Blocks.stone) {
				continue;
			}
			if (random.nextInt(6) == 0) {
				int h = 1 + random.nextInt(6);
				for (int j1 = j; j1 > j - h && j1 > 0; --j1) {
					int indexH = xzIndex * ySize + j1;
					if (blocks[indexH] != Blocks.stone) {
						continue;
					}
					blocks[indexH] = Blocks.stained_hardened_clay;
					meta[indexH] = 9;
				}
				continue;
			}
			if (random.nextInt(16) != 0) {
				continue;
			}
			blocks[index] = Blocks.clay;
			meta[index] = 0;
		}
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return LOTRAchievement.enterMountainsWind;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.RHUN.getSubregion("windMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.RHUN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.0f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.2f;
	}
}
