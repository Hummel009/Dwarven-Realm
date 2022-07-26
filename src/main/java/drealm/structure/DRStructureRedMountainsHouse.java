package drealm.structure;

import java.util.Random;

import drealm.database.*;
import drealm.entity.DREntityRedDwarf;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DRStructureRedMountainsHouse extends LOTRWorldGenDwarfHouse {
	public DRStructureRedMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	protected LOTREntityDwarf createDwarf(World world) {
		return new DREntityRedDwarf(world);
	}

	@Override
	protected ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = { new ItemStack(DRRegistry.helmet_red_dwarven), new ItemStack(DRRegistry.body_red_dwarven), new ItemStack(DRRegistry.legs_red_dwarven), new ItemStack(DRRegistry.boots_red_dwarven), new ItemStack(DRRegistry.red_dwarf_steel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	protected ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = { new ItemStack(DRRegistry.sword_red_dwarven), new ItemStack(DRRegistry.dagger_red_dwarven), new ItemStack(DRRegistry.hammer_red_dwarven), new ItemStack(DRRegistry.battleaxe_red_dwarven), new ItemStack(DRRegistry.pickaxe_red_dwarven), new ItemStack(DRRegistry.mattock_red_dwarven), new ItemStack(DRRegistry.throwing_axe_red_dwarven), new ItemStack(DRRegistry.pike_red_dwarven) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	protected void setupRandomBlocks(Random random) {
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
		tableBlock = DRRegistry.red_dwarven_table;
		barsBlock = DRRegistry.red_dwarf_bars;
		larderContents = DRChestContents.RED_DWARF_HOUSE_LARDER;
		personalContents = DRChestContents.RED_MOUNTAINS_STRONGHOLD;
		plateFoods = DRFoods.RED_DWARF;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}
