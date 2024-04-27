package com.github.hummel.drealm.structure;

import com.github.hummel.drealm.entity.EntityRedDwarf;
import com.github.hummel.drealm.init.Blocks;
import com.github.hummel.drealm.init.ChestContents;
import com.github.hummel.drealm.init.Foods;
import com.github.hummel.drealm.init.Items;
import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class StructureRedMountainsHouse extends LOTRWorldGenDwarfHouse {
	public StructureRedMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	public LOTREntityDwarf createDwarf(World world) {
		return new EntityRedDwarf(world);
	}

	@Override
	public ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = {new ItemStack(Items.helmetRedDwarven), new ItemStack(Items.bodyRedDwarven), new ItemStack(Items.legsRedDwarven), new ItemStack(Items.bootsRedDwarven), new ItemStack(Items.redDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(net.minecraft.init.Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(net.minecraft.init.Items.gold_ingot), new ItemStack(net.minecraft.init.Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = {new ItemStack(Items.swordRedDwarven), new ItemStack(Items.daggerRedDwarven), new ItemStack(Items.hammerRedDwarven), new ItemStack(Items.battleaxeRedDwarven), new ItemStack(Items.pickaxeRedDwarven), new ItemStack(Items.mattockRedDwarven), new ItemStack(Items.throwingAxeRedDwarven), new ItemStack(Items.pikeRedDwarven)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		stoneBlock = net.minecraft.init.Blocks.stone;
		stoneMeta = 0;
		fillerBlock = LOTRMod.rock;
		fillerMeta = 4;
		topBlock = LOTRMod.rock;
		topMeta = 4;
		brick2Block = LOTRMod.brick2;
		brick2Meta = 2;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 4;
		chandelierBlock = Blocks.chandelier;
		chandelierMeta = 0;
		tableBlock = Blocks.redDwarvenTable;
		barsBlock = Blocks.redDwarfBars;
		larderContents = ChestContents.redDwarfHouseLarder;
		personalContents = ChestContents.redMountainsStronghold;
		plateFoods = Foods.redDwarf;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}