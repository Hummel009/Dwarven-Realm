package drealm.database;

import cpw.mods.fml.common.registry.GameRegistry;
import drealm.block.*;
import drealm.item.*;
import drealm.util.DRConfig;
import lotr.common.block.*;
import lotr.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;

public class DRRegistry {
	public static Block brick;
	public static Block chandelier;
	public static Block ore_storage;
	public static Block pillar;
	public static Block red_dwarf_bars;
	public static Block red_dwarven_table;
	public static Block slab_double;
	public static Block slab_single;
	public static Block wall;
	public static Block wind_dwarf_bars;
	public static Block wind_dwarven_table;
	public static Item axe_red_dwarven;
	public static Item axe_wind_dwarven;
	public static Item battleaxe_red_dwarven;
	public static Item battleaxe_wind_dwarven;
	public static Item boar_armor_red_dwarven;
	public static Item boar_armor_wind_dwarven;
	public static Item body_red_dwarven;
	public static Item body_wind_dwarven;
	public static Item boots_red_dwarven;
	public static Item boots_wind_dwarven;
	public static Item dagger_red_dwarven;
	public static Item dagger_red_dwarven_poisoned;
	public static Item dagger_wind_dwarven;
	public static Item dagger_wind_dwarven_poisoned;
	public static Item hammer_red_dwarven;
	public static Item hammer_wind_dwarven;
	public static Item helmet_red_dwarven;
	public static Item helmet_wind_dwarven;
	public static Item hoe_red_dwarven;
	public static Item hoe_wind_dwarven;
	public static Item legs_red_dwarven;
	public static Item legs_wind_dwarven;
	public static Item mattock_red_dwarven;
	public static Item mattock_wind_dwarven;
	public static Item pickaxe_red_dwarven;
	public static Item pickaxe_wind_dwarven;
	public static Item pike_red_dwarven;
	public static Item pike_wind_dwarven;
	public static Item red_dwarf_steel;
	public static Item shovel_red_dwarven;
	public static Item shovel_wind_dwarven;
	public static Item spear_red_dwarven;
	public static Item spear_wind_dwarven;
	public static Item structure_spawner;
	public static Item sword_red_dwarven;
	public static Item sword_wind_dwarven;
	public static Item throwing_axe_red_dwarven;
	public static Item throwing_axe_wind_dwarven;
	public static Item wind_dwarf_steel;

	public static void preInit() {
		brick = new DRBlockBrick();
		chandelier = new DRBlockChandelier();
		ore_storage = new DRBlockOreStorage();
		pillar = new DRBlockPillar();
		red_dwarf_bars = new LOTRBlockBars();
		red_dwarven_table = new DRBlockTableRedDwarven();
		slab_double = new DRBlockSlab(true).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_double");
		slab_single = new DRBlockSlab(false).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_single");
		wall = new DRBlockWall();
		wind_dwarf_bars = new LOTRBlockBars();
		wind_dwarven_table = new DRBlockTableWindDwarven();
		if (DRConfig.enableTextures14) {
			body_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 1);
			body_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 1);
			legs_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 2);
			legs_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 2);
			boots_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 3);
			boots_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 3);
			helmet_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 0);
			helmet_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 0);
			boar_armor_red_dwarven = new LOTRItemMountArmor(DRMaterial.RED_DWARVEN14, LOTRItemMountArmor.Mount.BOAR);
			boar_armor_wind_dwarven = new LOTRItemMountArmor(DRMaterial.WIND_DWARVEN14, LOTRItemMountArmor.Mount.BOAR);
		} else {
			body_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 1);
			body_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 1);
			legs_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 2);
			legs_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 2);
			boots_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 3);
			boots_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 3);
			helmet_red_dwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 0);
			helmet_wind_dwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 0);
			boar_armor_red_dwarven = new LOTRItemMountArmor(DRMaterial.RED_DWARVEN, LOTRItemMountArmor.Mount.BOAR);
			boar_armor_wind_dwarven = new LOTRItemMountArmor(DRMaterial.WIND_DWARVEN, LOTRItemMountArmor.Mount.BOAR);
		}
		axe_red_dwarven = new LOTRItemAxe(DRMaterial.RED_DWARVEN);
		axe_wind_dwarven = new LOTRItemAxe(DRMaterial.WIND_DWARVEN);
		battleaxe_red_dwarven = new LOTRItemBattleaxe(DRMaterial.RED_DWARVEN);
		battleaxe_wind_dwarven = new LOTRItemBattleaxe(DRMaterial.WIND_DWARVEN);
		dagger_red_dwarven = new LOTRItemDagger(DRMaterial.RED_DWARVEN);
		dagger_red_dwarven_poisoned = new LOTRItemDagger(DRMaterial.RED_DWARVEN, LOTRItemDagger.DaggerEffect.POISON);
		dagger_wind_dwarven = new LOTRItemDagger(DRMaterial.WIND_DWARVEN);
		dagger_wind_dwarven_poisoned = new LOTRItemDagger(DRMaterial.WIND_DWARVEN, LOTRItemDagger.DaggerEffect.POISON);
		hammer_red_dwarven = new LOTRItemHammer(DRMaterial.RED_DWARVEN);
		hammer_wind_dwarven = new LOTRItemHammer(DRMaterial.WIND_DWARVEN);
		hoe_red_dwarven = new LOTRItemHoe(DRMaterial.RED_DWARVEN);
		hoe_wind_dwarven = new LOTRItemHoe(DRMaterial.WIND_DWARVEN);
		mattock_red_dwarven = new LOTRItemMattock(DRMaterial.RED_DWARVEN);
		mattock_wind_dwarven = new LOTRItemMattock(DRMaterial.WIND_DWARVEN);
		pickaxe_red_dwarven = new LOTRItemPickaxe(DRMaterial.RED_DWARVEN);
		pickaxe_wind_dwarven = new LOTRItemPickaxe(DRMaterial.WIND_DWARVEN);
		pike_red_dwarven = new LOTRItemPolearm(DRMaterial.RED_DWARVEN);
		pike_wind_dwarven = new LOTRItemPolearm(DRMaterial.WIND_DWARVEN);
		red_dwarf_steel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);
		shovel_red_dwarven = new LOTRItemShovel(DRMaterial.RED_DWARVEN);
		shovel_wind_dwarven = new LOTRItemShovel(DRMaterial.WIND_DWARVEN);
		spear_red_dwarven = new LOTRItemSpear(DRMaterial.RED_DWARVEN);
		spear_wind_dwarven = new LOTRItemSpear(DRMaterial.WIND_DWARVEN);
		structure_spawner = new DRItemStructureSpawner();
		sword_red_dwarven = new LOTRItemSword(DRMaterial.RED_DWARVEN);
		sword_wind_dwarven = new LOTRItemSword(DRMaterial.WIND_DWARVEN);
		throwing_axe_red_dwarven = new LOTRItemThrowingAxe(DRMaterial.RED_DWARVEN);
		throwing_axe_wind_dwarven = new LOTRItemThrowingAxe(DRMaterial.WIND_DWARVEN);
		wind_dwarf_steel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);

		LOTRBlockSlabBase.registerSlabs(slab_single, slab_double);

		registerBlockV(wind_dwarf_bars, "wind_dwarf_bars");
		registerBlockV(red_dwarf_bars, "red_dwarf_bars");
		registerBlock(red_dwarven_table, "red_dwarven_table");
		registerBlock(wind_dwarven_table, "wind_dwarven_table");
		registerBlockV(chandelier, "chandelier", LOTRItemBlockMetadata.class);
		registerBlock(brick, "brick", LOTRItemBlockMetadata.class);
		registerBlock(pillar, "pillar", LOTRItemBlockMetadata.class);
		registerBlockV(ore_storage, "ore_storage", LOTRItemBlockMetadata.class);
		registerBlock(wall, "wall", LOTRItemBlockMetadata.class, true);
		registerBlock(slab_single, "slab_single", DRBlockSlab.SlabExSingle.class);
		registerBlock(slab_double, "slab_double", DRBlockSlab.SlabExDouble.class);

		registerItemV(red_dwarf_steel, "red_dwarf_steel");
		registerItemV(wind_dwarf_steel, "wind_dwarf_steel");
		registerItemV(helmet_red_dwarven, "helmet_red_dwarven");
		registerItemV(body_red_dwarven, "body_red_dwarven");
		registerItemV(legs_red_dwarven, "legs_red_dwarven");
		registerItemV(boots_red_dwarven, "boots_red_dwarven");
		registerItemV(helmet_wind_dwarven, "helmet_wind_dwarven");
		registerItemV(body_wind_dwarven, "body_wind_dwarven");
		registerItemV(legs_wind_dwarven, "legs_wind_dwarven");
		registerItemV(boots_wind_dwarven, "boots_wind_dwarven");
		registerItemV(shovel_red_dwarven, "shovel_red_dwarven");
		registerItemV(pickaxe_red_dwarven, "pickaxe_red_dwarven");
		registerItemV(axe_red_dwarven, "axe_red_dwarven");
		registerItemV(sword_red_dwarven, "sword_red_dwarven");
		registerItemV(hoe_red_dwarven, "hoe_red_dwarven");
		registerItemV(dagger_red_dwarven, "dagger_red_dwarven");
		registerItemV(dagger_red_dwarven_poisoned, "dagger_red_dwarven_poisoned");
		registerItemV(battleaxe_red_dwarven, "battleaxe_red_dwarven");
		registerItemV(hammer_red_dwarven, "hammer_red_dwarven");
		registerItemV(mattock_red_dwarven, "mattock_red_dwarven");
		registerItemV(throwing_axe_red_dwarven, "throwing_axe_red_dwarven");
		registerItemV(spear_red_dwarven, "spear_red_dwarven");
		registerItemV(boar_armor_red_dwarven, "boar_armor_red_dwarven");
		registerItemV(pike_red_dwarven, "pike_red_dwarven");
		registerItemV(shovel_wind_dwarven, "shovel_wind_dwarven");
		registerItemV(pickaxe_wind_dwarven, "pickaxe_wind_dwarven");
		registerItemV(axe_wind_dwarven, "axe_wind_dwarven");
		registerItemV(sword_wind_dwarven, "sword_wind_dwarven");
		registerItemV(hoe_wind_dwarven, "hoe_wind_dwarven");
		registerItemV(dagger_wind_dwarven, "dagger_wind_dwarven");
		registerItemV(dagger_wind_dwarven_poisoned, "dagger_wind_dwarven_poisoned");
		registerItemV(battleaxe_wind_dwarven, "battleaxe_wind_dwarven");
		registerItemV(hammer_wind_dwarven, "hammer_wind_dwarven");
		registerItemV(mattock_wind_dwarven, "mattock_wind_dwarven");
		registerItemV(throwing_axe_wind_dwarven, "throwing_axe_wind_dwarven");
		registerItemV(spear_wind_dwarven, "spear_wind_dwarven");
		registerItemV(boar_armor_wind_dwarven, "boar_armor_wind_dwarven");
		registerItemV(pike_wind_dwarven, "pike_wind_dwarven");
		registerItem(structure_spawner, "lotr:structureSpawner");
	}

	public static void registerBlockV(Block block, String name) {
		block.setBlockName(name);
		if (DRConfig.enableTextures14) {
			block.setBlockTextureName("drealm:" + name + "14");
		} else {
			block.setBlockTextureName("drealm:" + name);
		}
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlockV(Block block, String name, Class<? extends ItemBlock> itemClass) {
		block.setBlockName(name);
		if (DRConfig.enableTextures14) {
			block.setBlockTextureName("drealm:" + name + "14");
		} else {
			block.setBlockTextureName("drealm:" + name);
		}
		GameRegistry.registerBlock(block, itemClass, name);
	}

	public static void registerItemV(Item item, String name) {
		item.setUnlocalizedName(name);
		if (DRConfig.enableTextures14) {
			item.setTextureName("drealm:" + name + "14");
		} else {
			item.setTextureName("drealm:" + name);
		}
		GameRegistry.registerItem(item, name);
	}

	public static void registerBlock(Block block, String name) {
		block.setBlockName(name);
		block.setBlockTextureName("drealm:" + name);
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlock(Block block, String name, Class<? extends ItemBlock> itemClass) {
		block.setBlockName(name);
		block.setBlockTextureName("drealm:" + name);
		GameRegistry.registerBlock(block, itemClass, name);
	}

	public static void registerBlock(Block block, String name, Class<? extends ItemBlock> itemClass, boolean hasNoTexture) {
		block.setBlockName(name);
		GameRegistry.registerBlock(block, itemClass, name);
	}

	public static void registerItem(Item item, String name) {
		item.setTextureName(name);
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
	}
}