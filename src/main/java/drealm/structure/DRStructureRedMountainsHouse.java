package drealm.structure;

import drealm.content.DRBlocks;
import drealm.content.DRChestContents;
import drealm.content.DRFoods;
import drealm.content.DRItems;
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
		ItemStack[] items = new ItemStack[]{new ItemStack(DRItems.helmetRedDwarven), new ItemStack(DRItems.bodyRedDwarven), new ItemStack(DRItems.legsRedDwarven), new ItemStack(DRItems.bootsRedDwarven), new ItemStack(DRItems.redDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = new ItemStack[]{new ItemStack(DRItems.swordRedDwarven), new ItemStack(DRItems.daggerRedDwarven), new ItemStack(DRItems.hammerRedDwarven), new ItemStack(DRItems.battleaxeRedDwarven), new ItemStack(DRItems.pickaxeRedDwarven), new ItemStack(DRItems.mattockRedDwarven), new ItemStack(DRItems.throwingAxeRedDwarven), new ItemStack(DRItems.pikeRedDwarven)};
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
		chandelierBlock = DRBlocks.chandelier;
		chandelierMeta = 0;
		tableBlock = DRBlocks.redDwarvenTable;
		barsBlock = DRBlocks.redDwarfBars;
		larderContents = DRChestContents.redDwarfHouseLarder;
		personalContents = DRChestContents.redMountainsStronghold;
		plateFoods = DRFoods.redDwarf;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}