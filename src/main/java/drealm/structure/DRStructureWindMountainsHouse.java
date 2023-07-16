package drealm.structure;

import drealm.database.DRChestContents;
import drealm.database.DRFoods;
import drealm.database.DRRegistry;
import drealm.entity.DREntityWindDwarf;
import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure2.LOTRWorldGenDwarfHouse;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class DRStructureWindMountainsHouse extends LOTRWorldGenDwarfHouse {
	public DRStructureWindMountainsHouse(boolean flag) {
		super(flag);
	}

	@Override
	public LOTREntityDwarf createDwarf(World world) {
		return new DREntityWindDwarf(world);
	}

	@Override
	public ItemStack getRandomOtherItem(Random random) {
		ItemStack[] items = {new ItemStack(DRRegistry.helmet_wind_dwarven), new ItemStack(DRRegistry.body_wind_dwarven), new ItemStack(DRRegistry.legs_wind_dwarven), new ItemStack(DRRegistry.boots_wind_dwarven), new ItemStack(DRRegistry.wind_dwarf_steel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = {new ItemStack(DRRegistry.sword_wind_dwarven), new ItemStack(DRRegistry.dagger_wind_dwarven), new ItemStack(DRRegistry.hammer_wind_dwarven), new ItemStack(DRRegistry.battleaxe_wind_dwarven), new ItemStack(DRRegistry.pickaxe_wind_dwarven), new ItemStack(DRRegistry.mattock_wind_dwarven), new ItemStack(DRRegistry.throwing_axe_wind_dwarven), new ItemStack(DRRegistry.pike_wind_dwarven)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public void setupRandomBlocks(Random random) {
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
}