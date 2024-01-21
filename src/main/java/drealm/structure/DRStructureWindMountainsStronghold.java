package drealm.structure;

import drealm.content.DRBlocks;
import drealm.content.DRChestContents;
import drealm.entity.DREntityWindDwarf;
import drealm.entity.DREntityWindDwarfAxeThrower;
import drealm.entity.DREntityWindDwarfCommander;
import drealm.entity.DREntityWindDwarfWarrior;
import drealm.item.DRItemBanner;
import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure.LOTRWorldGenStructureBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class DRStructureWindMountainsStronghold extends LOTRWorldGenStructureBase {
	public DRStructureWindMountainsStronghold(boolean flag) {
		super(flag);
	}

	private static void spawnDwarf(World world, int i, int j, int k) {
		DREntityWindDwarfWarrior dwarf = world.rand.nextInt(3) == 0 ? new DREntityWindDwarfAxeThrower(world) : new DREntityWindDwarfWarrior(world);
		dwarf.setLocationAndAngles(i + 0.5, j, k + 0.5, 0.0f, 0.0f);
		((DREntityWindDwarf) dwarf).onSpawnWithEgg(null);
		dwarf.isNPCPersistent = true;
		dwarf.setHomeArea(i, j, k, 16);
		world.spawnEntityInWorld(dwarf);
	}

	private static void spawnDwarfCommander(World world, int i, int j, int k) {
		DREntityWindDwarfCommander dwarf = new DREntityWindDwarfCommander(world);
		dwarf.setLocationAndAngles(i + 0.5, j, k + 0.5, 0.0f, 0.0f);
		((LOTREntityDwarf) dwarf).onSpawnWithEgg(null);
		dwarf.setHomeArea(i, j, k, 16);
		world.spawnEntityInWorld(dwarf);
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		int k3 = k;
		int i3 = i;
		int j2 = j;
		Block block;
		if (restrictions && (block = world.getBlock(i3, j2 - 1, k3)) != Blocks.grass && block != Blocks.stone && block != Blocks.dirt && block != Blocks.stained_hardened_clay && block != Blocks.snow) {
			return false;
		}
		--j2;
		int rotation = random.nextInt(4);
		if (!restrictions && usingPlayer != null) {
			rotation = usingPlayerRotation();
		}
		switch (rotation) {
			case 0:
				k3 += 8;
				break;
			case 1:
				i3 -= 8;
				break;
			case 2:
				k3 -= 8;
				break;
			case 3:
				i3 += 8;
				break;
			default:
				break;
		}
		if (restrictions) {
			int minHeight = j2;
			int maxHeight = j2;
			for (int i13 = i3 - 6; i13 <= i3 + 6; ++i13) {
				for (int k12 = k3 - 6; k12 <= k3 + 6; ++k12) {
					int j1 = world.getTopSolidOrLiquidBlock(i13, k12) - 1;
					Block block2 = world.getBlock(i13, j1, k12);
					if (block2 != Blocks.grass && block2 != Blocks.stone && block2 != Blocks.dirt && block2 != LOTRMod.rock && block2 != Blocks.snow) {
						return false;
					}
					if (j1 < minHeight) {
						minHeight = j1;
					}
					if (j1 <= maxHeight) {
						continue;
					}
					maxHeight = j1;
				}
			}
			if (maxHeight - minHeight > 10) {
				return false;
			}
		}
		int i1;
		int k1;
		for (k1 = k3 - 6; k1 <= k3 + 6; ++k1) {
			for (i1 = i3 - 6; i1 <= i3 + 6; ++i1) {
				boolean flag = Math.abs(k1 - k3) == 6 && Math.abs(i1 - i3) == 6;
				for (int j1 = j2 + 7; (j1 >= j2 || !LOTRMod.isOpaque(world, i1, j1, k1)) && j1 >= 0; --j1) {
					if (flag) {
						setBlockAndNotifyAdequately(world, i1, j1, k1, DRBlocks.pillar, 0);
					} else {
						if (Math.abs(i1 - i3) < 6 && Math.abs(k1 - k3) < 6) {
							if (j1 >= j2 + 1 && j1 <= j2 + 3 || j1 >= j2 + 4 && j1 <= j2 + 7) {
								setAir(world, i1, j1, k1);
								continue;
							}
							if (j1 == j2) {
								setBlockAndNotifyAdequately(world, i1, j1, k1, Blocks.planks, 1);
								continue;
							}
						}
						setBlockAndNotifyAdequately(world, i1, j1, k1, DRBlocks.brick, 0);
					}
					if (j1 > j2) {
						continue;
					}
					setGrassToDirt(world, i1, j1 - 1, k1);
				}
			}
		}
		int i12;
		for (i12 = i3 - 6; i12 <= i3 + 6; ++i12) {
			setBlockAndNotifyAdequately(world, i12, j2 + 8, k3 - 6, LOTRMod.stairsDwarvenBrick, 2);
			setBlockAndNotifyAdequately(world, i12, j2 + 8, k3 + 6, LOTRMod.stairsDwarvenBrick, 3);
		}
		for (k1 = k3 - 6; k1 <= k3 + 6; ++k1) {
			setBlockAndNotifyAdequately(world, i3 - 6, j2 + 8, k1, LOTRMod.stairsDwarvenBrick, 0);
			setBlockAndNotifyAdequately(world, i3 + 6, j2 + 8, k1, LOTRMod.stairsDwarvenBrick, 1);
		}
		for (k1 = k3 - 5; k1 <= k3 + 5; ++k1) {
			for (i1 = i3 - 5; i1 <= i3 + 5; ++i1) {
				setBlockAndNotifyAdequately(world, i1, j2 + 4, k1, DRBlocks.slabDouble, 0);
				setBlockAndNotifyAdequately(world, i1, j2 + 8, k1, DRBlocks.slabDouble, 0);
				int i2 = Math.abs(i1 - i3);
				int k2 = Math.abs(k1 - k3);
				int l = -1;
				if (i2 == 5) {
					l = k2 % 2;
				} else if (k2 == 5) {
					l = i2 % 2;
				}
				if (l == -1) {
					continue;
				}
				if (l == 1) {
					for (int j1 = j2 + 9; j1 <= j2 + 11; ++j1) {
						setBlockAndNotifyAdequately(world, i1, j1, k1, DRBlocks.pillar, 0);
					}
					continue;
				}
				setBlockAndNotifyAdequately(world, i1, j2 + 9, k1, DRBlocks.wall, 0);
			}
		}
		for (i12 = i3 - 5; i12 <= i3 + 5; ++i12) {
			setBlockAndNotifyAdequately(world, i12, j2 + 12, k3 - 5, LOTRMod.stairsDwarvenBrick, 2);
			setBlockAndNotifyAdequately(world, i12, j2 + 12, k3 + 5, LOTRMod.stairsDwarvenBrick, 3);
		}
		for (k1 = k3 - 5; k1 <= k3 + 5; ++k1) {
			setBlockAndNotifyAdequately(world, i3 - 5, j2 + 12, k1, LOTRMod.stairsDwarvenBrick, 0);
			setBlockAndNotifyAdequately(world, i3 + 5, j2 + 12, k1, LOTRMod.stairsDwarvenBrick, 1);
		}
		for (k1 = k3 - 4; k1 <= k3 + 4; ++k1) {
			for (i1 = i3 - 4; i1 <= i3 + 4; ++i1) {
				setBlockAndNotifyAdequately(world, i1, j2 + 12, k1, LOTRMod.slabSingle, 15);
			}
		}
		setBlockAndNotifyAdequately(world, i3, j2 + 7, k3, DRBlocks.chandelier, 1);
		setBlockAndNotifyAdequately(world, i3, j2 + 11, k3, DRBlocks.chandelier, 1);
		setBlockAndNotifyAdequately(world, i3, j2 + 12, k3, LOTRMod.brick, 6);
		switch (rotation) {
			case 0:
				generateFacingSouth(world, random, i3, j2, k3);
				break;
			case 1:
				generateFacingWest(world, random, i3, j2, k3);
				break;
			case 2:
				generateFacingNorth(world, random, i3, j2, k3);
				break;
			case 3:
				generateFacingEast(world, random, i3, j2, k3);
				break;
			default:
				break;
		}
		spawnDwarfCommander(world, i3, j2 + 9, k3);
		for (int l = 0; l < 4; ++l) {
			spawnDwarf(world, i3, j2 + 5, k3);
		}
		LOTREntityNPCRespawner respawner = new LOTREntityNPCRespawner(world);
		respawner.setSpawnClasses(DREntityWindDwarfWarrior.class, DREntityWindDwarfAxeThrower.class);
		respawner.setCheckRanges(8, -8, 16, 8);
		respawner.setSpawnRanges(8, 1, 10, 16);
		placeNPCRespawner(respawner, world, i3, j2, k3);
		return true;
	}

	private void generateFacingEast(World world, Random random, int i, int j, int k) {
		int k12;
		int j1;
		for (k12 = k - 6; k12 <= k + 6; ++k12) {
			setBlockAndNotifyAdequately(world, i - 7, j + 1, k12, DRBlocks.slabSingle, 0);
			setGrassToDirt(world, i - 7, j, k12);
			for (j1 = j; !LOTRMod.isOpaque(world, i - 7, j1, k12) && j1 >= 0; --j1) {
				setBlockAndNotifyAdequately(world, i - 7, j1, k12, DRBlocks.pillar, 0);
				setGrassToDirt(world, i - 7, j1 - 1, k12);
			}
		}
		int j12;
		for (j12 = j + 1; j12 <= j + 2; ++j12) {
			setAir(world, i - 6, j12, k);
			setBlockAndNotifyAdequately(world, i - 7, j12, k - 1, DRBlocks.pillar, 0);
			setBlockAndNotifyAdequately(world, i - 7, j12, k + 1, DRBlocks.pillar, 0);
		}
		setBlockAndNotifyAdequately(world, i - 7, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i - 6, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i - 7, j + 1, k, LOTRMod.doorSpruce, 0);
		setBlockAndNotifyAdequately(world, i - 7, j + 2, k, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i - 7, j + 3, k - 1, LOTRMod.stairsDwarvenBrick, 2);
		setBlockAndNotifyAdequately(world, i - 7, j + 3, k, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i - 7, j + 3, k + 1, LOTRMod.stairsDwarvenBrick, 3);
		setBlockAndNotifyAdequately(world, i - 7, j + 4, k, LOTRMod.slabSingle, 7);
		placeWallBanner(world, i - 6, j + 6, k, 1, DRItemBanner.windMountains);
		int k13;
		int i1;
		for (j12 = j + 1; j12 <= j + 3; ++j12) {
			for (i1 = i - 4; i1 <= i - 1; ++i1) {
				for (k13 = k - 5; k13 <= k - 1; ++k13) {
					setBlockAndNotifyAdequately(world, i1, j12, k13, DRBlocks.brick, 0);
				}
				for (k13 = k + 1; k13 <= k + 5; ++k13) {
					setBlockAndNotifyAdequately(world, i1, j12, k13, DRBlocks.brick, 0);
				}
			}
			for (i1 = i - 2; i1 <= i + 5; ++i1) {
				setBlockAndNotifyAdequately(world, i1, j12, k - 1, DRBlocks.brick, 0);
				setBlockAndNotifyAdequately(world, i1, j12, k + 1, DRBlocks.brick, 0);
			}
		}
		setBlockAndNotifyAdequately(world, i + 3, j + 1, k - 1, LOTRMod.doorSpruce, 1);
		setBlockAndNotifyAdequately(world, i + 3, j + 2, k - 1, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i + 3, j + 1, k + 1, LOTRMod.doorSpruce, 3);
		setBlockAndNotifyAdequately(world, i + 3, j + 2, k + 1, LOTRMod.doorSpruce, 8);
		for (k12 = k - 5; k12 <= k + 2; k12 += 7) {
			setBlockAndNotifyAdequately(world, i + 1, j + 1, k12, LOTRMod.dwarvenBed, 1);
			setBlockAndNotifyAdequately(world, i, j + 1, k12, LOTRMod.dwarvenBed, 9);
			setBlockAndNotifyAdequately(world, i + 1, j + 1, k12 + 3, LOTRMod.dwarvenBed, 1);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 3, LOTRMod.dwarvenBed, 9);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 1, Blocks.chest, 0);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 2, Blocks.chest, 0);
			LOTRChestContents.fillChest(world, random, i, j + 1, k12 + 1, LOTRChestContents.DWARF_HOUSE_LARDER);
			LOTRChestContents.fillChest(world, random, i, j + 1, k12 + 2, DRChestContents.windMountainsStronghold);
			setBlockAndNotifyAdequately(world, i + 3, j + 3, k12 + 1, DRBlocks.chandelier, 1);
			setBlockAndNotifyAdequately(world, i + 5, j + 1, k12, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i + 5, j + 1, k12 + 3, Blocks.planks, 1);
			placeBarrel(world, random, i + 5, j + 2, k12, 4, LOTRFoods.DWARF_DRINK);
			placeBarrel(world, random, i + 5, j + 2, k12 + 3, 4, LOTRFoods.DWARF_DRINK);
			setBlockAndNotifyAdequately(world, i + 5, j + 1, k12 + 1, Blocks.furnace, 0);
			setBlockMetadata(world, i + 5, j + 1, k12 + 1, 4);
			setBlockAndNotifyAdequately(world, i + 5, j + 1, k12 + 2, Blocks.furnace, 0);
			setBlockMetadata(world, i + 5, j + 1, k12 + 2, 4);
		}
		setAir(world, i - 5, j + 4, k);
		int stairX = 1;
		int j2;
		for (j1 = j + 1; j1 <= j + 4; ++j1) {
			setAir(world, i - 5, j + 4, k - stairX);
			setAir(world, i - 5, j + 4, k + stairX);
			setBlockAndNotifyAdequately(world, i - 5, j1, k - stairX, LOTRMod.stairsDwarvenBrick, 3);
			setBlockAndNotifyAdequately(world, i - 5, j1, k + stairX, LOTRMod.stairsDwarvenBrick, 2);
			for (j2 = j1 - 1; j2 > j; --j2) {
				setBlockAndNotifyAdequately(world, i - 5, j2, k - stairX, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i - 5, j2, k + stairX, LOTRMod.brick, 6);
			}
			++stairX;
		}
		for (j1 = j + 1; j1 <= j + 3; ++j1) {
			setBlockAndNotifyAdequately(world, i - 5, j1, k - stairX, LOTRMod.brick, 6);
			setBlockAndNotifyAdequately(world, i - 5, j1, k + stairX, LOTRMod.brick, 6);
		}
		int k1;
		for (k1 = k - 5; k1 <= k + 5; k1 += 10) {
			setBlockAndNotifyAdequately(world, i - 2, j + 5, k1, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i - 2, j + 6, k1, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i + 2, j + 5, k1, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i + 2, j + 6, k1, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i, j + 5, k1, DRBlocks.windDwarvenTable, 0);
			setBlockAndNotifyAdequately(world, i - 1, j + 5, k1, LOTRMod.dwarvenForge, 0);
			setBlockAndNotifyAdequately(world, i + 1, j + 5, k1, LOTRMod.dwarvenForge, 0);
		}
		setBlockAndNotifyAdequately(world, i + 6, j + 6, k - 3, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 6, j + 6, k + 3, LOTRMod.brick3, 12);
		stairX = 4;
		for (j1 = j + 5; j1 <= j + 8; ++j1) {
			setAir(world, i - 4, j + 8, k - stairX);
			setAir(world, i - 4, j + 8, k + stairX);
			setBlockAndNotifyAdequately(world, i - 4, j1, k - stairX, LOTRMod.stairsDwarvenBrick, 2);
			setBlockAndNotifyAdequately(world, i - 4, j1, k + stairX, LOTRMod.stairsDwarvenBrick, 3);
			for (j2 = j1 - 1; j2 > j + 4; --j2) {
				setBlockAndNotifyAdequately(world, i - 4, j2, k - stairX, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i - 4, j2, k + stairX, LOTRMod.brick, 6);
			}
			--stairX;
		}
		for (j1 = j + 5; j1 <= j + 7; ++j1) {
			setBlockAndNotifyAdequately(world, i - 4, j1, k, LOTRMod.brick, 6);
		}
		setBlockAndNotifyAdequately(world, i - 4, j + 6, k, LOTRMod.brick3, 12);
		for (i1 = i + 7; i1 <= i + 8; ++i1) {
			for (k13 = k - 4; k13 <= k + 4; ++k13) {
				placeBalconySection(world, i1, j, k13, false, false);
			}
			placeBalconySection(world, i1, j, k - 5, true, false);
			placeBalconySection(world, i1, j, k + 5, true, false);
		}
		for (k1 = k - 2; k1 <= k + 2; ++k1) {
			placeBalconySection(world, i + 9, j, k1, false, false);
		}
		for (k1 = k - 5; k1 <= k + 5; ++k1) {
			if (Math.abs(k1 - k) < 3) {
				continue;
			}
			placeBalconySection(world, i + 9, j, k1, true, false);
		}
		for (k1 = k - 1; k1 <= k + 1; ++k1) {
			placeBalconySection(world, i + 10, j, k1, false, false);
		}
		for (k1 = k - 3; k1 <= k + 3; ++k1) {
			if (Math.abs(k1 - k) < 2) {
				continue;
			}
			placeBalconySection(world, i + 10, j, k1, true, false);
		}
		for (k1 = k - 2; k1 <= k + 2; ++k1) {
			if (Math.abs(k1 - k) == 0) {
				placeBalconySection(world, i + 11, j, k1, true, true);
				continue;
			}
			placeBalconySection(world, i + 11, j, k1, true, false);
		}
		setBlockAndNotifyAdequately(world, i + 6, j + 4, k, DRBlocks.slabDouble, 0);
		setAir(world, i + 6, j + 5, k);
		setAir(world, i + 6, j + 6, k);
		setBlockAndNotifyAdequately(world, i + 6, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i + 6, j + 1, k, LOTRMod.doorSpruce, 2);
		setBlockAndNotifyAdequately(world, i + 6, j + 2, k, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i + 8, j + 3, k, DRBlocks.chandelier, 1);
		for (j1 = j + 1; j1 <= j + 2; ++j1) {
			for (int i12 = i + 7; i12 <= i + 8; ++i12) {
				placeRandomOre(world, random, i12, j1, k - 4);
				placeRandomOre(world, random, i12, j1, k - 3);
				placeRandomOre(world, random, i12, j1, k + 3);
				placeRandomOre(world, random, i12, j1, k + 4);
			}
			placeRandomOre(world, random, i + 9, j1, k - 2);
			placeRandomOre(world, random, i + 9, j1, k + 2);
			for (k13 = k - 1; k13 <= k + 1; ++k13) {
				placeRandomOre(world, random, i + 10, j1, k13);
			}
		}
		setBlockAndNotifyAdequately(world, i + 3, j + 9, k, LOTRMod.commandTable, 0);
	}

	private void generateFacingNorth(World world, Random random, int i, int j, int k) {
		int i12;
		int j1;
		for (i12 = i - 6; i12 <= i + 6; ++i12) {
			setBlockAndNotifyAdequately(world, i12, j + 1, k + 7, DRBlocks.slabSingle, 0);
			setGrassToDirt(world, i12, j, k + 7);
			for (j1 = j; !LOTRMod.isOpaque(world, i12, j1, k + 7) && j1 >= 0; --j1) {
				setBlockAndNotifyAdequately(world, i12, j1, k + 7, DRBlocks.pillar, 0);
				setGrassToDirt(world, i12, j1 - 1, k + 7);
			}
		}
		int j12;
		for (j12 = j + 1; j12 <= j + 2; ++j12) {
			setAir(world, i, j12, k + 6);
			setBlockAndNotifyAdequately(world, i - 1, j12, k + 7, DRBlocks.pillar, 0);
			setBlockAndNotifyAdequately(world, i + 1, j12, k + 7, DRBlocks.pillar, 0);
		}
		setBlockAndNotifyAdequately(world, i, j, k + 7, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j, k + 6, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j + 1, k + 7, LOTRMod.doorSpruce, 3);
		setBlockAndNotifyAdequately(world, i, j + 2, k + 7, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i - 1, j + 3, k + 7, LOTRMod.stairsDwarvenBrick, 0);
		setBlockAndNotifyAdequately(world, i, j + 3, k + 7, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 1, j + 3, k + 7, LOTRMod.stairsDwarvenBrick, 1);
		setBlockAndNotifyAdequately(world, i, j + 4, k + 7, LOTRMod.slabSingle, 7);
		placeWallBanner(world, i, j + 6, k + 6, 0, DRItemBanner.windMountains);
		int i1;
		int k1;
		for (j12 = j + 1; j12 <= j + 3; ++j12) {
			for (k1 = k + 4; k1 >= k + 1; --k1) {
				for (i1 = i - 5; i1 <= i - 1; ++i1) {
					setBlockAndNotifyAdequately(world, i1, j12, k1, DRBlocks.brick, 0);
				}
				for (i1 = i + 1; i1 <= i + 5; ++i1) {
					setBlockAndNotifyAdequately(world, i1, j12, k1, DRBlocks.brick, 0);
				}
			}
			for (k1 = k + 2; k1 >= k - 5; --k1) {
				setBlockAndNotifyAdequately(world, i - 1, j12, k1, DRBlocks.brick, 0);
				setBlockAndNotifyAdequately(world, i + 1, j12, k1, DRBlocks.brick, 0);
			}
		}
		setBlockAndNotifyAdequately(world, i - 1, j + 1, k - 3, LOTRMod.doorSpruce, 0);
		setBlockAndNotifyAdequately(world, i - 1, j + 2, k - 3, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i + 1, j + 1, k - 3, LOTRMod.doorSpruce, 2);
		setBlockAndNotifyAdequately(world, i + 1, j + 2, k - 3, LOTRMod.doorSpruce, 8);
		for (i12 = i - 5; i12 <= i + 2; i12 += 7) {
			setBlockAndNotifyAdequately(world, i12, j + 1, k - 1, LOTRMod.dwarvenBed, 0);
			setBlockAndNotifyAdequately(world, i12, j + 1, k, LOTRMod.dwarvenBed, 8);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k - 1, LOTRMod.dwarvenBed, 0);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k, LOTRMod.dwarvenBed, 8);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 1, k, Blocks.chest, 0);
			setBlockAndNotifyAdequately(world, i12 + 2, j + 1, k, Blocks.chest, 0);
			LOTRChestContents.fillChest(world, random, i12 + 1, j + 1, k, LOTRChestContents.DWARF_HOUSE_LARDER);
			LOTRChestContents.fillChest(world, random, i12 + 2, j + 1, k, DRChestContents.windMountainsStronghold);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 3, k - 3, DRBlocks.chandelier, 1);
			setBlockAndNotifyAdequately(world, i12, j + 1, k - 5, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k - 5, Blocks.planks, 1);
			placeBarrel(world, random, i12, j + 2, k - 5, 3, LOTRFoods.DWARF_DRINK);
			placeBarrel(world, random, i12 + 3, j + 2, k - 5, 3, LOTRFoods.DWARF_DRINK);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 1, k - 5, Blocks.furnace, 0);
			setBlockMetadata(world, i12 + 1, j + 1, k - 5, 3);
			setBlockAndNotifyAdequately(world, i12 + 2, j + 1, k - 5, Blocks.furnace, 0);
			setBlockMetadata(world, i12 + 2, j + 1, k - 5, 3);
		}
		setAir(world, i, j + 4, k + 5);
		int stairX = 1;
		int j2;
		for (j1 = j + 1; j1 <= j + 4; ++j1) {
			setAir(world, i - stairX, j + 4, k + 5);
			setAir(world, i + stairX, j + 4, k + 5);
			setBlockAndNotifyAdequately(world, i - stairX, j1, k + 5, LOTRMod.stairsDwarvenBrick, 1);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k + 5, LOTRMod.stairsDwarvenBrick, 0);
			for (j2 = j1 - 1; j2 > j; --j2) {
				setBlockAndNotifyAdequately(world, i - stairX, j2, k + 5, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + stairX, j2, k + 5, LOTRMod.brick, 6);
			}
			++stairX;
		}
		for (j1 = j + 1; j1 <= j + 3; ++j1) {
			setBlockAndNotifyAdequately(world, i - stairX, j1, k + 5, LOTRMod.brick, 6);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k + 5, LOTRMod.brick, 6);
		}
		int i13;
		for (i13 = i - 5; i13 <= i + 5; i13 += 10) {
			setBlockAndNotifyAdequately(world, i13, j + 5, k + 2, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i13, j + 6, k + 2, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i13, j + 5, k - 2, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i13, j + 6, k - 2, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i13, j + 5, k, DRBlocks.windDwarvenTable, 0);
			setBlockAndNotifyAdequately(world, i13, j + 5, k + 1, LOTRMod.dwarvenForge, 0);
			setBlockAndNotifyAdequately(world, i13, j + 5, k - 1, LOTRMod.dwarvenForge, 0);
		}
		setBlockAndNotifyAdequately(world, i - 3, j + 6, k - 6, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 3, j + 6, k - 6, LOTRMod.brick3, 12);
		stairX = 4;
		for (j1 = j + 5; j1 <= j + 8; ++j1) {
			setAir(world, i - stairX, j + 8, k + 4);
			setAir(world, i + stairX, j + 8, k + 4);
			setBlockAndNotifyAdequately(world, i - stairX, j1, k + 4, LOTRMod.stairsDwarvenBrick, 0);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k + 4, LOTRMod.stairsDwarvenBrick, 1);
			for (j2 = j1 - 1; j2 > j + 4; --j2) {
				setBlockAndNotifyAdequately(world, i - stairX, j2, k + 4, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + stairX, j2, k + 4, LOTRMod.brick, 6);
			}
			--stairX;
		}
		for (j1 = j + 5; j1 <= j + 7; ++j1) {
			setBlockAndNotifyAdequately(world, i, j1, k + 4, LOTRMod.brick, 6);
		}
		setBlockAndNotifyAdequately(world, i, j + 6, k + 4, LOTRMod.brick3, 12);
		for (k1 = k - 7; k1 >= k - 8; --k1) {
			for (i1 = i - 4; i1 <= i + 4; ++i1) {
				placeBalconySection(world, i1, j, k1, false, false);
			}
			placeBalconySection(world, i - 5, j, k1, true, false);
			placeBalconySection(world, i + 5, j, k1, true, false);
		}
		for (i13 = i - 2; i13 <= i + 2; ++i13) {
			placeBalconySection(world, i13, j, k - 9, false, false);
		}
		for (i13 = i - 5; i13 <= i + 5; ++i13) {
			if (Math.abs(i13 - i) < 3) {
				continue;
			}
			placeBalconySection(world, i13, j, k - 9, true, false);
		}
		for (i13 = i - 1; i13 <= i + 1; ++i13) {
			placeBalconySection(world, i13, j, k - 10, false, false);
		}
		for (i13 = i - 3; i13 <= i + 3; ++i13) {
			if (Math.abs(i13 - i) < 2) {
				continue;
			}
			placeBalconySection(world, i13, j, k - 10, true, false);
		}
		for (i13 = i - 2; i13 <= i + 2; ++i13) {
			if (Math.abs(i13 - i) == 0) {
				placeBalconySection(world, i13, j, k - 11, true, true);
				continue;
			}
			placeBalconySection(world, i13, j, k - 11, true, false);
		}
		setBlockAndNotifyAdequately(world, i, j + 4, k - 6, DRBlocks.slabDouble, 0);
		setAir(world, i, j + 5, k - 6);
		setAir(world, i, j + 6, k - 6);
		setBlockAndNotifyAdequately(world, i, j, k - 6, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j + 1, k - 6, LOTRMod.doorSpruce, 1);
		setBlockAndNotifyAdequately(world, i, j + 2, k - 6, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i, j + 3, k - 8, DRBlocks.chandelier, 1);
		for (j1 = j + 1; j1 <= j + 2; ++j1) {
			for (int k12 = k - 7; k12 >= k - 8; --k12) {
				placeRandomOre(world, random, i - 4, j1, k12);
				placeRandomOre(world, random, i - 3, j1, k12);
				placeRandomOre(world, random, i + 3, j1, k12);
				placeRandomOre(world, random, i + 4, j1, k12);
			}
			placeRandomOre(world, random, i - 2, j1, k - 9);
			placeRandomOre(world, random, i + 2, j1, k - 9);
			for (i1 = i - 1; i1 <= i + 1; ++i1) {
				placeRandomOre(world, random, i1, j1, k - 10);
			}
		}
		setBlockAndNotifyAdequately(world, i, j + 9, k - 3, LOTRMod.commandTable, 0);
	}

	private void generateFacingSouth(World world, Random random, int i, int j, int k) {
		int i12;
		int j1;
		for (i12 = i - 6; i12 <= i + 6; ++i12) {
			setBlockAndNotifyAdequately(world, i12, j + 1, k - 7, DRBlocks.slabSingle, 0);
			setGrassToDirt(world, i12, j, k - 7);
			for (j1 = j; !LOTRMod.isOpaque(world, i12, j1, k - 7) && j1 >= 0; --j1) {
				setBlockAndNotifyAdequately(world, i12, j1, k - 7, DRBlocks.pillar, 0);
				setGrassToDirt(world, i12, j1 - 1, k - 7);
			}
		}
		int j12;
		for (j12 = j + 1; j12 <= j + 2; ++j12) {
			setAir(world, i, j12, k - 6);
			setBlockAndNotifyAdequately(world, i - 1, j12, k - 7, DRBlocks.pillar, 0);
			setBlockAndNotifyAdequately(world, i + 1, j12, k - 7, DRBlocks.pillar, 0);
		}
		setBlockAndNotifyAdequately(world, i, j, k - 7, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j, k - 6, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j + 1, k - 7, LOTRMod.doorSpruce, 1);
		setBlockAndNotifyAdequately(world, i, j + 2, k - 7, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i - 1, j + 3, k - 7, LOTRMod.stairsDwarvenBrick, 0);
		setBlockAndNotifyAdequately(world, i, j + 3, k - 7, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 1, j + 3, k - 7, LOTRMod.stairsDwarvenBrick, 1);
		setBlockAndNotifyAdequately(world, i, j + 4, k - 7, LOTRMod.slabSingle, 7);
		placeWallBanner(world, i, j + 6, k - 6, 2, DRItemBanner.windMountains);
		int i1;
		int k1;
		for (j12 = j + 1; j12 <= j + 3; ++j12) {
			for (k1 = k - 4; k1 <= k - 1; ++k1) {
				for (i1 = i - 5; i1 <= i - 1; ++i1) {
					setBlockAndNotifyAdequately(world, i1, j12, k1, DRBlocks.brick, 0);
				}
				for (i1 = i + 1; i1 <= i + 5; ++i1) {
					setBlockAndNotifyAdequately(world, i1, j12, k1, DRBlocks.brick, 0);
				}
			}
			for (k1 = k - 2; k1 <= k + 5; ++k1) {
				setBlockAndNotifyAdequately(world, i - 1, j12, k1, DRBlocks.brick, 0);
				setBlockAndNotifyAdequately(world, i + 1, j12, k1, DRBlocks.brick, 0);
			}
		}
		setBlockAndNotifyAdequately(world, i - 1, j + 1, k + 3, LOTRMod.doorSpruce, 0);
		setBlockAndNotifyAdequately(world, i - 1, j + 2, k + 3, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i + 1, j + 1, k + 3, LOTRMod.doorSpruce, 2);
		setBlockAndNotifyAdequately(world, i + 1, j + 2, k + 3, LOTRMod.doorSpruce, 8);
		for (i12 = i - 5; i12 <= i + 2; i12 += 7) {
			setBlockAndNotifyAdequately(world, i12, j + 1, k + 1, LOTRMod.dwarvenBed, 2);
			setBlockAndNotifyAdequately(world, i12, j + 1, k, LOTRMod.dwarvenBed, 10);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k + 1, LOTRMod.dwarvenBed, 2);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k, LOTRMod.dwarvenBed, 10);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 1, k, Blocks.chest, 0);
			setBlockAndNotifyAdequately(world, i12 + 2, j + 1, k, Blocks.chest, 0);
			LOTRChestContents.fillChest(world, random, i12 + 1, j + 1, k, LOTRChestContents.DWARF_HOUSE_LARDER);
			LOTRChestContents.fillChest(world, random, i12 + 2, j + 1, k, DRChestContents.windMountainsStronghold);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 3, k + 3, DRBlocks.chandelier, 1);
			setBlockAndNotifyAdequately(world, i12, j + 1, k + 5, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i12 + 3, j + 1, k + 5, Blocks.planks, 1);
			placeBarrel(world, random, i12, j + 2, k + 5, 2, LOTRFoods.DWARF_DRINK);
			placeBarrel(world, random, i12 + 3, j + 2, k + 5, 2, LOTRFoods.DWARF_DRINK);
			setBlockAndNotifyAdequately(world, i12 + 1, j + 1, k + 5, Blocks.furnace, 0);
			setBlockMetadata(world, i12 + 1, j + 1, k + 5, 2);
			setBlockAndNotifyAdequately(world, i12 + 2, j + 1, k + 5, Blocks.furnace, 0);
			setBlockMetadata(world, i12 + 2, j + 1, k + 5, 2);
		}
		setAir(world, i, j + 4, k - 5);
		int stairX = 1;
		int j2;
		for (j1 = j + 1; j1 <= j + 4; ++j1) {
			setAir(world, i - stairX, j + 4, k - 5);
			setAir(world, i + stairX, j + 4, k - 5);
			setBlockAndNotifyAdequately(world, i - stairX, j1, k - 5, LOTRMod.stairsDwarvenBrick, 1);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k - 5, LOTRMod.stairsDwarvenBrick, 0);
			for (j2 = j1 - 1; j2 > j; --j2) {
				setBlockAndNotifyAdequately(world, i - stairX, j2, k - 5, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + stairX, j2, k - 5, LOTRMod.brick, 6);
			}
			++stairX;
		}
		for (j1 = j + 1; j1 <= j + 3; ++j1) {
			setBlockAndNotifyAdequately(world, i - stairX, j1, k - 5, LOTRMod.brick, 6);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k - 5, LOTRMod.brick, 6);
		}
		int i13;
		for (i13 = i - 5; i13 <= i + 5; i13 += 10) {
			setBlockAndNotifyAdequately(world, i13, j + 5, k - 2, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i13, j + 6, k - 2, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i13, j + 5, k + 2, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i13, j + 6, k + 2, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i13, j + 5, k, DRBlocks.windDwarvenTable, 0);
			setBlockAndNotifyAdequately(world, i13, j + 5, k - 1, LOTRMod.dwarvenForge, 0);
			setBlockAndNotifyAdequately(world, i13, j + 5, k + 1, LOTRMod.dwarvenForge, 0);
		}
		setBlockAndNotifyAdequately(world, i - 3, j + 6, k + 6, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 3, j + 6, k + 6, LOTRMod.brick3, 12);
		stairX = 4;
		for (j1 = j + 5; j1 <= j + 8; ++j1) {
			setAir(world, i - stairX, j + 8, k - 4);
			setAir(world, i + stairX, j + 8, k - 4);
			setBlockAndNotifyAdequately(world, i - stairX, j1, k - 4, LOTRMod.stairsDwarvenBrick, 0);
			setBlockAndNotifyAdequately(world, i + stairX, j1, k - 4, LOTRMod.stairsDwarvenBrick, 1);
			for (j2 = j1 - 1; j2 > j + 4; --j2) {
				setBlockAndNotifyAdequately(world, i - stairX, j2, k - 4, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + stairX, j2, k - 4, LOTRMod.brick, 6);
			}
			--stairX;
		}
		for (j1 = j + 5; j1 <= j + 7; ++j1) {
			setBlockAndNotifyAdequately(world, i, j1, k - 4, LOTRMod.brick, 6);
		}
		setBlockAndNotifyAdequately(world, i, j + 6, k - 4, LOTRMod.brick3, 12);
		for (k1 = k + 7; k1 <= k + 8; ++k1) {
			for (i1 = i - 4; i1 <= i + 4; ++i1) {
				placeBalconySection(world, i1, j, k1, false, false);
			}
			placeBalconySection(world, i - 5, j, k1, true, false);
			placeBalconySection(world, i + 5, j, k1, true, false);
		}
		for (i13 = i - 2; i13 <= i + 2; ++i13) {
			placeBalconySection(world, i13, j, k + 9, false, false);
		}
		for (i13 = i - 5; i13 <= i + 5; ++i13) {
			if (Math.abs(i13 - i) < 3) {
				continue;
			}
			placeBalconySection(world, i13, j, k + 9, true, false);
		}
		for (i13 = i - 1; i13 <= i + 1; ++i13) {
			placeBalconySection(world, i13, j, k + 10, false, false);
		}
		for (i13 = i - 3; i13 <= i + 3; ++i13) {
			if (Math.abs(i13 - i) < 2) {
				continue;
			}
			placeBalconySection(world, i13, j, k + 10, true, false);
		}
		for (i13 = i - 2; i13 <= i + 2; ++i13) {
			if (Math.abs(i13 - i) == 0) {
				placeBalconySection(world, i13, j, k + 11, true, true);
				continue;
			}
			placeBalconySection(world, i13, j, k + 11, true, false);
		}
		setBlockAndNotifyAdequately(world, i, j + 4, k + 6, DRBlocks.slabDouble, 0);
		setAir(world, i, j + 5, k + 6);
		setAir(world, i, j + 6, k + 6);
		setBlockAndNotifyAdequately(world, i, j, k + 6, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i, j + 1, k + 6, LOTRMod.doorSpruce, 3);
		setBlockAndNotifyAdequately(world, i, j + 2, k + 6, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i, j + 3, k + 8, DRBlocks.chandelier, 1);
		for (j1 = j + 1; j1 <= j + 2; ++j1) {
			for (int k12 = k + 7; k12 <= k + 8; ++k12) {
				placeRandomOre(world, random, i - 4, j1, k12);
				placeRandomOre(world, random, i - 3, j1, k12);
				placeRandomOre(world, random, i + 3, j1, k12);
				placeRandomOre(world, random, i + 4, j1, k12);
			}
			placeRandomOre(world, random, i - 2, j1, k + 9);
			placeRandomOre(world, random, i + 2, j1, k + 9);
			for (i1 = i - 1; i1 <= i + 1; ++i1) {
				placeRandomOre(world, random, i1, j1, k + 10);
			}
		}
		setBlockAndNotifyAdequately(world, i, j + 9, k + 3, LOTRMod.commandTable, 0);
	}

	private void generateFacingWest(World world, Random random, int i, int j, int k) {
		int k12;
		int j1;
		for (k12 = k - 6; k12 <= k + 6; ++k12) {
			setBlockAndNotifyAdequately(world, i + 7, j + 1, k12, DRBlocks.slabSingle, 0);
			setGrassToDirt(world, i + 7, j, k12);
			for (j1 = j; !LOTRMod.isOpaque(world, i + 7, j1, k12) && j1 >= 0; --j1) {
				setBlockAndNotifyAdequately(world, i + 7, j1, k12, DRBlocks.pillar, 0);
				setGrassToDirt(world, i + 7, j1 - 1, k12);
			}
		}
		int j12;
		for (j12 = j + 1; j12 <= j + 2; ++j12) {
			setAir(world, i + 6, j12, k);
			setBlockAndNotifyAdequately(world, i + 7, j12, k - 1, DRBlocks.pillar, 0);
			setBlockAndNotifyAdequately(world, i + 7, j12, k + 1, DRBlocks.pillar, 0);
		}
		setBlockAndNotifyAdequately(world, i + 7, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i + 6, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i + 7, j + 1, k, LOTRMod.doorSpruce, 2);
		setBlockAndNotifyAdequately(world, i + 7, j + 2, k, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i + 7, j + 3, k - 1, LOTRMod.stairsDwarvenBrick, 2);
		setBlockAndNotifyAdequately(world, i + 7, j + 3, k, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i + 7, j + 3, k + 1, LOTRMod.stairsDwarvenBrick, 3);
		setBlockAndNotifyAdequately(world, i + 7, j + 4, k, LOTRMod.slabSingle, 7);
		placeWallBanner(world, i + 6, j + 6, k, 3, DRItemBanner.windMountains);
		int k13;
		int i1;
		for (j12 = j + 1; j12 <= j + 3; ++j12) {
			for (i1 = i + 4; i1 >= i + 1; --i1) {
				for (k13 = k - 5; k13 <= k - 1; ++k13) {
					setBlockAndNotifyAdequately(world, i1, j12, k13, DRBlocks.brick, 0);
				}
				for (k13 = k + 1; k13 <= k + 5; ++k13) {
					setBlockAndNotifyAdequately(world, i1, j12, k13, DRBlocks.brick, 0);
				}
			}
			for (i1 = i + 2; i1 >= i - 5; --i1) {
				setBlockAndNotifyAdequately(world, i1, j12, k - 1, DRBlocks.brick, 0);
				setBlockAndNotifyAdequately(world, i1, j12, k + 1, DRBlocks.brick, 0);
			}
		}
		setBlockAndNotifyAdequately(world, i - 3, j + 1, k - 1, LOTRMod.doorSpruce, 1);
		setBlockAndNotifyAdequately(world, i - 3, j + 2, k - 1, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i - 3, j + 1, k + 1, LOTRMod.doorSpruce, 3);
		setBlockAndNotifyAdequately(world, i - 3, j + 2, k + 1, LOTRMod.doorSpruce, 8);
		for (k12 = k - 5; k12 <= k + 2; k12 += 7) {
			setBlockAndNotifyAdequately(world, i - 1, j + 1, k12, LOTRMod.dwarvenBed, 3);
			setBlockAndNotifyAdequately(world, i, j + 1, k12, LOTRMod.dwarvenBed, 11);
			setBlockAndNotifyAdequately(world, i - 1, j + 1, k12 + 3, LOTRMod.dwarvenBed, 3);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 3, LOTRMod.dwarvenBed, 11);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 1, Blocks.chest, 0);
			setBlockAndNotifyAdequately(world, i, j + 1, k12 + 2, Blocks.chest, 0);
			LOTRChestContents.fillChest(world, random, i, j + 1, k12 + 1, LOTRChestContents.DWARF_HOUSE_LARDER);
			LOTRChestContents.fillChest(world, random, i, j + 1, k12 + 2, DRChestContents.windMountainsStronghold);
			setBlockAndNotifyAdequately(world, i - 3, j + 3, k12 + 1, DRBlocks.chandelier, 1);
			setBlockAndNotifyAdequately(world, i - 5, j + 1, k12, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i - 5, j + 1, k12 + 3, Blocks.planks, 1);
			placeBarrel(world, random, i - 5, j + 2, k12, 5, LOTRFoods.DWARF_DRINK);
			placeBarrel(world, random, i - 5, j + 2, k12 + 3, 5, LOTRFoods.DWARF_DRINK);
			setBlockAndNotifyAdequately(world, i - 5, j + 1, k12 + 1, Blocks.furnace, 0);
			setBlockMetadata(world, i - 5, j + 1, k12 + 1, 5);
			setBlockAndNotifyAdequately(world, i - 5, j + 1, k12 + 2, Blocks.furnace, 0);
			setBlockMetadata(world, i - 5, j + 1, k12 + 2, 5);
		}
		setAir(world, i + 5, j + 4, k);
		int stairX = 1;
		int j2;
		for (j1 = j + 1; j1 <= j + 4; ++j1) {
			setAir(world, i + 5, j + 4, k - stairX);
			setAir(world, i + 5, j + 4, k + stairX);
			setBlockAndNotifyAdequately(world, i + 5, j1, k - stairX, LOTRMod.stairsDwarvenBrick, 3);
			setBlockAndNotifyAdequately(world, i + 5, j1, k + stairX, LOTRMod.stairsDwarvenBrick, 2);
			for (j2 = j1 - 1; j2 > j; --j2) {
				setBlockAndNotifyAdequately(world, i + 5, j2, k - stairX, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + 5, j2, k + stairX, LOTRMod.brick, 6);
			}
			++stairX;
		}
		for (j1 = j + 1; j1 <= j + 3; ++j1) {
			setBlockAndNotifyAdequately(world, i + 5, j1, k - stairX, LOTRMod.brick, 6);
			setBlockAndNotifyAdequately(world, i + 5, j1, k + stairX, LOTRMod.brick, 6);
		}
		int k1;
		for (k1 = k - 5; k1 <= k + 5; k1 += 10) {
			setBlockAndNotifyAdequately(world, i - 2, j + 5, k1, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i - 2, j + 6, k1, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i + 2, j + 5, k1, Blocks.planks, 1);
			setBlockAndNotifyAdequately(world, i + 2, j + 6, k1, Blocks.wooden_slab, 1);
			setBlockAndNotifyAdequately(world, i, j + 5, k1, DRBlocks.windDwarvenTable, 0);
			setBlockAndNotifyAdequately(world, i - 1, j + 5, k1, LOTRMod.dwarvenForge, 0);
			setBlockAndNotifyAdequately(world, i + 1, j + 5, k1, LOTRMod.dwarvenForge, 0);
		}
		setBlockAndNotifyAdequately(world, i - 6, j + 6, k - 3, LOTRMod.brick3, 12);
		setBlockAndNotifyAdequately(world, i - 6, j + 6, k + 3, LOTRMod.brick3, 12);
		stairX = 4;
		for (j1 = j + 5; j1 <= j + 8; ++j1) {
			setAir(world, i + 4, j + 8, k - stairX);
			setAir(world, i + 4, j + 8, k + stairX);
			setBlockAndNotifyAdequately(world, i + 4, j1, k - stairX, LOTRMod.stairsDwarvenBrick, 2);
			setBlockAndNotifyAdequately(world, i + 4, j1, k + stairX, LOTRMod.stairsDwarvenBrick, 3);
			for (j2 = j1 - 1; j2 > j + 4; --j2) {
				setBlockAndNotifyAdequately(world, i + 4, j2, k - stairX, LOTRMod.brick, 6);
				setBlockAndNotifyAdequately(world, i + 4, j2, k + stairX, LOTRMod.brick, 6);
			}
			--stairX;
		}
		for (j1 = j + 5; j1 <= j + 7; ++j1) {
			setBlockAndNotifyAdequately(world, i + 4, j1, k, LOTRMod.brick, 6);
		}
		setBlockAndNotifyAdequately(world, i + 4, j + 6, k, LOTRMod.brick3, 12);
		for (i1 = i - 7; i1 >= i - 8; --i1) {
			for (k13 = k - 4; k13 <= k + 4; ++k13) {
				placeBalconySection(world, i1, j, k13, false, false);
			}
			placeBalconySection(world, i1, j, k - 5, true, false);
			placeBalconySection(world, i1, j, k + 5, true, false);
		}
		for (k1 = k - 2; k1 <= k + 2; ++k1) {
			placeBalconySection(world, i - 9, j, k1, false, false);
		}
		for (k1 = k - 5; k1 <= k + 5; ++k1) {
			if (Math.abs(k1 - k) < 3) {
				continue;
			}
			placeBalconySection(world, i - 9, j, k1, true, false);
		}
		for (k1 = k - 1; k1 <= k + 1; ++k1) {
			placeBalconySection(world, i - 10, j, k1, false, false);
		}
		for (k1 = k - 3; k1 <= k + 3; ++k1) {
			if (Math.abs(k1 - k) < 2) {
				continue;
			}
			placeBalconySection(world, i - 10, j, k1, true, false);
		}
		for (k1 = k - 2; k1 <= k + 2; ++k1) {
			if (Math.abs(k1 - k) == 0) {
				placeBalconySection(world, i - 11, j, k1, true, true);
				continue;
			}
			placeBalconySection(world, i - 11, j, k1, true, false);
		}
		setBlockAndNotifyAdequately(world, i - 6, j + 4, k, DRBlocks.slabDouble, 0);
		setAir(world, i - 6, j + 5, k);
		setAir(world, i - 6, j + 6, k);
		setBlockAndNotifyAdequately(world, i - 6, j, k, Blocks.planks, 1);
		setBlockAndNotifyAdequately(world, i - 6, j + 1, k, LOTRMod.doorSpruce, 0);
		setBlockAndNotifyAdequately(world, i - 6, j + 2, k, LOTRMod.doorSpruce, 8);
		setBlockAndNotifyAdequately(world, i - 8, j + 3, k, DRBlocks.chandelier, 1);
		for (j1 = j + 1; j1 <= j + 2; ++j1) {
			for (int i12 = i - 7; i12 >= i - 8; --i12) {
				placeRandomOre(world, random, i12, j1, k - 4);
				placeRandomOre(world, random, i12, j1, k - 3);
				placeRandomOre(world, random, i12, j1, k + 3);
				placeRandomOre(world, random, i12, j1, k + 4);
			}
			placeRandomOre(world, random, i - 9, j1, k - 2);
			placeRandomOre(world, random, i - 9, j1, k + 2);
			for (k13 = k - 1; k13 <= k + 1; ++k13) {
				placeRandomOre(world, random, i - 10, j1, k13);
			}
		}
		setBlockAndNotifyAdequately(world, i - 3, j + 9, k, LOTRMod.commandTable, 0);
	}

	private void placeBalconySection(World world, int i, int j, int k, boolean isEdge, boolean isPillar) {
		if (isEdge) {
			for (int j1 = j + 4; (j1 >= j || !LOTRMod.isOpaque(world, i, j1, k)) && j1 >= 0; --j1) {
				if (isPillar) {
					setBlockAndNotifyAdequately(world, i, j1, k, DRBlocks.pillar, 0);
				} else {
					setBlockAndNotifyAdequately(world, i, j1, k, DRBlocks.brick, 0);
				}
				setGrassToDirt(world, i, j1 - 1, k);
			}
			if (isPillar) {
				setBlockAndNotifyAdequately(world, i, j + 4, k, LOTRMod.brick3, 12);
			}
			setBlockAndNotifyAdequately(world, i, j + 5, k, LOTRMod.brick, 6);
			setBlockAndNotifyAdequately(world, i, j + 6, k, DRBlocks.wall, 0);
		} else {
			int j1;
			for (j1 = j - 1; !LOTRMod.isOpaque(world, i, j1, k) && j1 >= 0; --j1) {
				setBlockAndNotifyAdequately(world, i, j1, k, DRBlocks.brick, 0);
				setGrassToDirt(world, i, j1 - 1, k);
			}
			setBlockAndNotifyAdequately(world, i, j, k, Blocks.planks, 1);
			for (j1 = j + 1; j1 <= j + 6; ++j1) {
				setAir(world, i, j1, k);
			}
			setBlockAndNotifyAdequately(world, i, j + 4, k, DRBlocks.slabDouble, 0);
		}
	}

	private void placeRandomOre(World world, Random random, int i, int j, int k) {
		if (!LOTRMod.isOpaque(world, i, j - 1, k) || !random.nextBoolean()) {
			return;
		}
		int l = random.nextInt(5);
		Block block;
		switch (l) {
			case 0:
				block = Blocks.iron_ore;
				break;
			case 1:
				block = Blocks.gold_ore;
				break;
			case 2:
				block = LOTRMod.oreCopper;
				break;
			case 3:
				block = LOTRMod.oreTin;
				break;
			default:
				block = LOTRMod.oreSilver;
				break;
		}
		setBlockAndNotifyAdequately(world, i, j, k, block, 0);
	}
}