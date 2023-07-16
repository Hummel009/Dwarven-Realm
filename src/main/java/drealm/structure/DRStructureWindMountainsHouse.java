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
		ItemStack[] items = {new ItemStack(DRRegistry.helmetWindDwarven), new ItemStack(DRRegistry.bodyWindDwarven), new ItemStack(DRRegistry.legsWindDwarven), new ItemStack(DRRegistry.bootsWindDwarven), new ItemStack(DRRegistry.windDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = {new ItemStack(DRRegistry.swordWindDwarven), new ItemStack(DRRegistry.daggerWindDwarven), new ItemStack(DRRegistry.hammerWindDwarven), new ItemStack(DRRegistry.battleaxeWindDwarven), new ItemStack(DRRegistry.pickaxeWindDwarven), new ItemStack(DRRegistry.mattockWindDwarven), new ItemStack(DRRegistry.throwingAxeWindDwarven), new ItemStack(DRRegistry.pikeWindDwarven)};
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
		tableBlock = DRRegistry.windDwarvenTable;
		barsBlock = DRRegistry.windDwarfBars;
		larderContents = DRChestContents.WIND_DWARF_HOUSE_LARDER;
		personalContents = DRChestContents.WIND_MOUNTAINS_STRONGHOLD;
		plateFoods = DRFoods.WIND_DWARF;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}