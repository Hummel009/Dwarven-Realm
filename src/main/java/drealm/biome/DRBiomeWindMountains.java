package drealm.biome;

import java.util.Random;

import drealm.entity.*;
import drealm.structure.*;
import drealm.util.DRCommander;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DRBiomeWindMountains extends LOTRBiome {
	public static final LOTRSpawnList WIND_DWARVES = DRCommander.newLOTRSpawnList(new LOTRSpawnEntry(DREntityWindDwarf.class, 100, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfMiner.class, 15, 1, 3), new LOTRSpawnEntry(DREntityWindDwarfWarrior.class, 20, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfAxeThrower.class, 10, 4, 4), new LOTRSpawnEntry(DREntityWindDwarfCrossbower.class, 10, 4, 4));

	public DRBiomeWindMountains(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[1];
		arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(WIND_DWARVES, 10);
		npcSpawnList.newFactionList(600).add(arrspawnListContainer);
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.3f);
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
		decorator.addRandomStructure(new DRStructureWindMountainsStronghold(false), 400);
		decorator.addRandomStructure(new DRStructureWindMountainsSmithy(false), 150);
		registerMountainsFlowers();
		biomeColors.setSky(11653858);
		registerTravellingTrader(DREntityWindDwarfMerchant.class);
		registerTravellingTrader(LOTREntityScrapTrader.class);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 3; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = MathHelper.getRandomIntegerInRange(random, 70, 160);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenMountainsideBush(LOTRMod.leaves5, 0).generate(world, random, i1, j1, k1);
		}
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = 70 + random.nextInt(80);
			int k1 = k + random.nextInt(16) + 8;
			new DRStructureWindMountainsHouse(false).generate(world, random, i1, j1, k1);
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
