package com.github.hummel.drealm.structure;

import com.github.hummel.drealm.entity.EntityWindDwarf;
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

public class StructureWindMountainsHouse extends LOTRWorldGenDwarfHouse {
	public StructureWindMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	public LOTREntityDwarf createDwarf(World world) {
		return new EntityWindDwarf(world);
	}

	@Override
	public ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = {new ItemStack(Items.helmetWindDwarven), new ItemStack(Items.bodyWindDwarven), new ItemStack(Items.legsWindDwarven), new ItemStack(Items.bootsWindDwarven), new ItemStack(Items.windDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(net.minecraft.init.Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(net.minecraft.init.Items.gold_ingot), new ItemStack(net.minecraft.init.Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = {new ItemStack(Items.swordWindDwarven), new ItemStack(Items.daggerWindDwarven), new ItemStack(Items.hammerWindDwarven), new ItemStack(Items.battleaxeWindDwarven), new ItemStack(Items.pickaxeWindDwarven), new ItemStack(Items.mattockWindDwarven), new ItemStack(Items.throwingAxeWindDwarven), new ItemStack(Items.pikeWindDwarven)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		stoneBlock = net.minecraft.init.Blocks.stone;
		stoneMeta = 0;
		fillerBlock = net.minecraft.init.Blocks.stone;
		fillerMeta = 0;
		topBlock = net.minecraft.init.Blocks.stone;
		topMeta = 0;
		brick2Block = Blocks.brick;
		brick2Meta = 0;
		pillarBlock = Blocks.pillar;
		pillarMeta = 0;
		chandelierBlock = Blocks.chandelier;
		chandelierMeta = 1;
		tableBlock = Blocks.windDwarvenTable;
		barsBlock = Blocks.windDwarfBars;
		larderContents = ChestContents.windDwarfHouseLarder;
		personalContents = ChestContents.windMountainsStronghold;
		plateFoods = Foods.windDwarf;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}