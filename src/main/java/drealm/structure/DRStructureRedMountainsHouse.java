package drealm.structure;

import drealm.database.DRChestContents;
import drealm.database.DRFoods;
import drealm.database.DRRegistry;
import drealm.entity.DREntityRedDwarf;
import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class DRStructureRedMountainsHouse extends LOTRWorldGenDwarfHouse {
	public DRStructureRedMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	public LOTREntityDwarf createDwarf(World world) {
		return new DREntityRedDwarf(world);
	}

	@Override
	public ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = {new ItemStack(DRRegistry.helmetRedDwarven), new ItemStack(DRRegistry.bodyRedDwarven), new ItemStack(DRRegistry.legsRedDwarven), new ItemStack(DRRegistry.bootsRedDwarven), new ItemStack(DRRegistry.redDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = {new ItemStack(DRRegistry.swordRedDwarven), new ItemStack(DRRegistry.daggerRedDwarven), new ItemStack(DRRegistry.hammerRedDwarven), new ItemStack(DRRegistry.battleaxeRedDwarven), new ItemStack(DRRegistry.pickaxeRedDwarven), new ItemStack(DRRegistry.mattockRedDwarven), new ItemStack(DRRegistry.throwingAxeRedDwarven), new ItemStack(DRRegistry.pikeRedDwarven)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		stoneBlock = Blocks.stone;
		stoneMeta = 0;
		fillerBlock = LOTRMod.rock;
		fillerMeta = 4;
		topBlock = LOTRMod.rock;
		topMeta = 4;
		brick2Block = LOTRMod.brick2;
		brick2Meta = 2;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 4;
		chandelierBlock = DRRegistry.chandelier;
		chandelierMeta = 0;
		tableBlock = DRRegistry.redDwarvenTable;
		barsBlock = DRRegistry.redDwarfBars;
		larderContents = DRChestContents.RED_DWARF_HOUSE_LARDER;
		personalContents = DRChestContents.RED_MOUNTAINS_STRONGHOLD;
		plateFoods = DRFoods.RED_DWARF;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}