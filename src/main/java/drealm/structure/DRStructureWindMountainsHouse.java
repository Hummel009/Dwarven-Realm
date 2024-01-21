package drealm.structure;

import drealm.content.DRBlocks;
import drealm.content.DRChestContents;
import drealm.content.DRFoods;
import drealm.content.DRItems;
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
		ItemStack[] items = new ItemStack[]{new ItemStack(DRItems.helmetWindDwarven), new ItemStack(DRItems.bodyWindDwarven), new ItemStack(DRItems.legsWindDwarven), new ItemStack(DRItems.bootsWindDwarven), new ItemStack(DRItems.windDwarfSteel), new ItemStack(LOTRMod.bronze), new ItemStack(Items.iron_ingot), new ItemStack(LOTRMod.silver), new ItemStack(LOTRMod.silverNugget), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget)};
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	public ItemStack getRandomWeaponItem(Random random) {
		ItemStack[] items = new ItemStack[]{new ItemStack(DRItems.swordWindDwarven), new ItemStack(DRItems.daggerWindDwarven), new ItemStack(DRItems.hammerWindDwarven), new ItemStack(DRItems.battleaxeWindDwarven), new ItemStack(DRItems.pickaxeWindDwarven), new ItemStack(DRItems.mattockWindDwarven), new ItemStack(DRItems.throwingAxeWindDwarven), new ItemStack(DRItems.pikeWindDwarven)};
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
		brick2Block = DRBlocks.brick;
		brick2Meta = 0;
		pillarBlock = DRBlocks.pillar;
		pillarMeta = 0;
		chandelierBlock = DRBlocks.chandelier;
		chandelierMeta = 1;
		tableBlock = DRBlocks.windDwarvenTable;
		barsBlock = DRBlocks.windDwarfBars;
		larderContents = DRChestContents.windDwarfHouseLarder;
		personalContents = DRChestContents.windMountainsStronghold;
		plateFoods = DRFoods.windDwarf;
		drinkFoods = LOTRFoods.DWARF_DRINK;
	}
}