package drealm.structure;

import java.util.Random;

import drealm.database.*;
import drealm.entity.DREntityWindDwarf;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DRStructureWindMountainsHouse extends LOTRWorldGenDwarfHouse {
	public DRStructureWindMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	protected LOTREntityDwarf createDwarf(World world) {
		return new DREntityWindDwarf(world);
	}

	@Override
	protected void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		stoneBlock = Blocks.stone;
		stoneMeta = 0;
		fillerBlock = Blocks.stone;
		fillerMeta = 0;
		topBlock = Blocks.stone;
		topMeta = 0;
		brick2Block = DRRegistry.brick;
		brick2Meta = 0;
		pillarBlock = DRRegistry.pillar;
		pillarMeta = 0;
		chandelierBlock = DRRegistry.chandelier;
		chandelierMeta = 1;
		tableBlock = DRRegistry.wind_dwarven_table;
		barsBlock = DRRegistry.wind_dwarf_bars;
		larderContents = DRChestContents.WIND_DWARF_HOUSE_LARDER;
		personalContents = DRChestContents.WIND_MOUNTAINS_STRONGHOLD;
		plateFoods = DRFoods.WIND_DWARF;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}

	@Override
	protected ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = new ItemStack[] { new ItemStack(DRRegistry.sword_wind_dwarven), new ItemStack(DRRegistry.dagger_wind_dwarven), new ItemStack(DRRegistry.hammer_wind_dwarven), new ItemStack(DRRegistry.battleaxe_wind_dwarven), new ItemStack(DRRegistry.pickaxe_wind_dwarven), new ItemStack(DRRegistry.mattock_wind_dwarven), new ItemStack(DRRegistry.throwing_axe_wind_dwarven), new ItemStack(DRRegistry.pike_wind_dwarven) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	protected ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = new ItemStack[] { new ItemStack(DRRegistry.helmet_wind_dwarven), new ItemStack(DRRegistry.body_wind_dwarven), new ItemStack(DRRegistry.legs_wind_dwarven), new ItemStack(DRRegistry.boots_wind_dwarven), new ItemStack(DRRegistry.wind_dwarf_steel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget) };
		return items[random.nextInt(items.length)].copy();
	}
}
