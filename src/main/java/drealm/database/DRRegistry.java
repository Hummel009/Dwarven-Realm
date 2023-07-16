package drealm.database;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import drealm.block.*;
import drealm.item.DRItemArmor;
import drealm.item.DRItemStructureSpawner;
import drealm.util.DRConfig;
import lotr.common.block.LOTRBlockBars;
import lotr.common.block.LOTRBlockSlabBase;
import lotr.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class DRRegistry {
	public static Block brick;
	public static Block chandelier;
	public static Block oreStorage;
	public static Block pillar;
	public static Block redDwarfBars;
	public static Block redDwarvenTable;
	public static Block slabDouble;
	public static Block slabSingle;
	public static Block wall;
	public static Block windDwarfBars;
	public static Block windDwarvenTable;

	public static Item axeRedDwarven;
	public static Item axeWindDwarven;
	public static Item battleaxeRedDwarven;
	public static Item battleaxeWindDwarven;
	public static Item boarArmorRedDwarven;
	public static Item boarArmorWindDwarven;
	public static Item bodyRedDwarven;
	public static Item bodyWindDwarven;
	public static Item bootsRedDwarven;
	public static Item bootsWindDwarven;
	public static Item daggerRedDwarven;
	public static Item daggerRedDwarvenPoisoned;
	public static Item daggerWindDwarven;
	public static Item daggerWindDwarvenPoisoned;
	public static Item hammerRedDwarven;
	public static Item hammerWindDwarven;
	public static Item helmetRedDwarven;
	public static Item helmetWindDwarven;
	public static Item hoeRedDwarven;
	public static Item hoeWindDwarven;
	public static Item legsRedDwarven;
	public static Item legsWindDwarven;
	public static Item mattockRedDwarven;
	public static Item mattockWindDwarven;
	public static Item pickaxeRedDwarven;
	public static Item pickaxeWindDwarven;
	public static Item pikeRedDwarven;
	public static Item pikeWindDwarven;
	public static Item redDwarfSteel;
	public static Item shovelRedDwarven;
	public static Item shovelWindDwarven;
	public static Item spearRedDwarven;
	public static Item spearWindDwarven;
	public static Item structureSpawner;
	public static Item swordRedDwarven;
	public static Item swordWindDwarven;
	public static Item throwingAxeRedDwarven;
	public static Item throwingAxeWindDwarven;
	public static Item windDwarfSteel;

	public static void preInit() {
		brick = new DRBlockBrick();
		chandelier = new DRBlockChandelier();
		oreStorage = new DRBlockOreStorage();
		pillar = new DRBlockPillar();
		redDwarfBars = new LOTRBlockBars();
		redDwarvenTable = new DRBlockTableRedDwarven();
		slabDouble = new DRBlockSlab(true).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_double");
		slabSingle = new DRBlockSlab(false).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_single");
		wall = new DRBlockWall();
		windDwarfBars = new LOTRBlockBars();
		windDwarvenTable = new DRBlockTableWindDwarven();
		if (DRConfig.enableTextures14) {
			bodyRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 1);
			bodyWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 1);
			legsRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 2);
			legsWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 2);
			bootsRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 3);
			bootsWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 3);
			helmetRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN14, 0);
			helmetWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN14, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(DRMaterial.RED_DWARVEN14, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(DRMaterial.WIND_DWARVEN14, LOTRItemMountArmor.Mount.BOAR);
		} else {
			bodyRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 1);
			bodyWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 1);
			legsRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 2);
			legsWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 2);
			bootsRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 3);
			bootsWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 3);
			helmetRedDwarven = new DRItemArmor(DRMaterial.RED_DWARVEN, 0);
			helmetWindDwarven = new DRItemArmor(DRMaterial.WIND_DWARVEN, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(DRMaterial.RED_DWARVEN, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(DRMaterial.WIND_DWARVEN, LOTRItemMountArmor.Mount.BOAR);
		}
		axeRedDwarven = new LOTRItemAxe(DRMaterial.RED_DWARVEN);
		axeWindDwarven = new LOTRItemAxe(DRMaterial.WIND_DWARVEN);
		battleaxeRedDwarven = new LOTRItemBattleaxe(DRMaterial.RED_DWARVEN);
		battleaxeWindDwarven = new LOTRItemBattleaxe(DRMaterial.WIND_DWARVEN);
		daggerRedDwarven = new LOTRItemDagger(DRMaterial.RED_DWARVEN);
		daggerRedDwarvenPoisoned = new LOTRItemDagger(DRMaterial.RED_DWARVEN, LOTRItemDagger.DaggerEffect.POISON);
		daggerWindDwarven = new LOTRItemDagger(DRMaterial.WIND_DWARVEN);
		daggerWindDwarvenPoisoned = new LOTRItemDagger(DRMaterial.WIND_DWARVEN, LOTRItemDagger.DaggerEffect.POISON);
		hammerRedDwarven = new LOTRItemHammer(DRMaterial.RED_DWARVEN);
		hammerWindDwarven = new LOTRItemHammer(DRMaterial.WIND_DWARVEN);
		hoeRedDwarven = new LOTRItemHoe(DRMaterial.RED_DWARVEN);
		hoeWindDwarven = new LOTRItemHoe(DRMaterial.WIND_DWARVEN);
		mattockRedDwarven = new LOTRItemMattock(DRMaterial.RED_DWARVEN);
		mattockWindDwarven = new LOTRItemMattock(DRMaterial.WIND_DWARVEN);
		pickaxeRedDwarven = new LOTRItemPickaxe(DRMaterial.RED_DWARVEN);
		pickaxeWindDwarven = new LOTRItemPickaxe(DRMaterial.WIND_DWARVEN);
		pikeRedDwarven = new LOTRItemPolearm(DRMaterial.RED_DWARVEN);
		pikeWindDwarven = new LOTRItemPolearm(DRMaterial.WIND_DWARVEN);
		redDwarfSteel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);
		shovelRedDwarven = new LOTRItemShovel(DRMaterial.RED_DWARVEN);
		shovelWindDwarven = new LOTRItemShovel(DRMaterial.WIND_DWARVEN);
		spearRedDwarven = new LOTRItemSpear(DRMaterial.RED_DWARVEN);
		spearWindDwarven = new LOTRItemSpear(DRMaterial.WIND_DWARVEN);
		structureSpawner = new DRItemStructureSpawner();
		swordRedDwarven = new LOTRItemSword(DRMaterial.RED_DWARVEN);
		swordWindDwarven = new LOTRItemSword(DRMaterial.WIND_DWARVEN);
		throwingAxeRedDwarven = new LOTRItemThrowingAxe(DRMaterial.RED_DWARVEN);
		throwingAxeWindDwarven = new LOTRItemThrowingAxe(DRMaterial.WIND_DWARVEN);
		windDwarfSteel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);

		LOTRBlockSlabBase.registerSlabs(slabSingle, slabDouble);

		registerBlockV(windDwarfBars, "windDwarfBars");
		registerBlockV(redDwarfBars, "redDwarfBars");
		registerBlock(redDwarvenTable, "redDwarvenTable");
		registerBlock(windDwarvenTable, "windDwarvenTable");
		registerBlockV(chandelier, "chandelier", LOTRItemBlockMetadata.class);
		registerBlock(brick, "brick", LOTRItemBlockMetadata.class);
		registerBlock(pillar, "pillar", LOTRItemBlockMetadata.class);
		registerBlockV(oreStorage, "oreStorage", LOTRItemBlockMetadata.class);
		registerBlock(wall, "wall", LOTRItemBlockMetadata.class, true);
		registerBlock(slabSingle, "slabSingle", DRBlockSlab.SlabExSingle.class);
		registerBlock(slabDouble, "slabDouble", DRBlockSlab.SlabExDouble.class);

		registerItemV(redDwarfSteel, "redDwarfSteel");
		registerItemV(windDwarfSteel, "windDwarfSteel");
		registerItemV(helmetRedDwarven, "helmetRedDwarven");
		registerItemV(bodyRedDwarven, "bodyRedDwarven");
		registerItemV(legsRedDwarven, "legsRedDwarven");
		registerItemV(bootsRedDwarven, "bootsRedDwarven");
		registerItemV(helmetWindDwarven, "helmetWindDwarven");
		registerItemV(bodyWindDwarven, "bodyWindDwarven");
		registerItemV(legsWindDwarven, "legsWindDwarven");
		registerItemV(bootsWindDwarven, "bootsWindDwarven");
		registerItemV(shovelRedDwarven, "shovelRedDwarven");
		registerItemV(pickaxeRedDwarven, "pickaxeRedDwarven");
		registerItemV(axeRedDwarven, "axeRedDwarven");
		registerItemV(swordRedDwarven, "swordRedDwarven");
		registerItemV(hoeRedDwarven, "hoeRedDwarven");
		registerItemV(daggerRedDwarven, "daggerRedDwarven");
		registerItemV(daggerRedDwarvenPoisoned, "daggerRedDwarvenPoisoned");
		registerItemV(battleaxeRedDwarven, "battleaxeRedDwarven");
		registerItemV(hammerRedDwarven, "hammerRedDwarven");
		registerItemV(mattockRedDwarven, "mattockRedDwarven");
		registerItemV(throwingAxeRedDwarven, "throwingAxeRedDwarven");
		registerItemV(spearRedDwarven, "spearRedDwarven");
		registerItemV(boarArmorRedDwarven, "boarArmorRedDwarven");
		registerItemV(pikeRedDwarven, "pikeRedDwarven");
		registerItemV(shovelWindDwarven, "shovelWindDwarven");
		registerItemV(pickaxeWindDwarven, "pickaxeWindDwarven");
		registerItemV(axeWindDwarven, "axeWindDwarven");
		registerItemV(swordWindDwarven, "swordWindDwarven");
		registerItemV(hoeWindDwarven, "hoeWindDwarven");
		registerItemV(daggerWindDwarven, "daggerWindDwarven");
		registerItemV(daggerWindDwarvenPoisoned, "daggerWindDwarvenPoisoned");
		registerItemV(battleaxeWindDwarven, "battleaxeWindDwarven");
		registerItemV(hammerWindDwarven, "hammerWindDwarven");
		registerItemV(mattockWindDwarven, "mattockWindDwarven");
		registerItemV(throwingAxeWindDwarven, "throwingAxeWindDwarven");
		registerItemV(spearWindDwarven, "spearWindDwarven");
		registerItemV(boarArmorWindDwarven, "boarArmorWindDwarven");
		registerItemV(pikeWindDwarven, "pikeWindDwarven");
		registerItem(structureSpawner, "lotr:structureSpawner");
	}

	public static void registerBlockV(Block block, String name) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		if (DRConfig.enableTextures14) {
			block.setBlockTextureName("drealm:" + blockName + "14");
		} else {
			block.setBlockTextureName("drealm:" + blockName);
		}
		GameRegistry.registerBlock(block, blockName);
	}

	public static void registerBlockV(Block block, String name, Class<? extends ItemBlock> itemClass) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		if (DRConfig.enableTextures14) {
			block.setBlockTextureName("drealm:" + blockName + "14");
		} else {
			block.setBlockTextureName("drealm:" + blockName);
		}
		GameRegistry.registerBlock(block, itemClass, blockName);
	}

	public static void registerItemV(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setUnlocalizedName(itemName);
		if (DRConfig.enableTextures14) {
			item.setTextureName("drealm:" + itemName + "14");
		} else {
			item.setTextureName("drealm:" + itemName);
		}
		GameRegistry.registerItem(item, itemName);
	}

	public static void registerBlock(Block block, String name) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		block.setBlockTextureName("drealm:" + blockName);
		GameRegistry.registerBlock(block, blockName);
	}

	public static void registerBlock(Block block, String name, Class<? extends ItemBlock> itemClass) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		block.setBlockTextureName("drealm:" + blockName);
		GameRegistry.registerBlock(block, itemClass, blockName);
	}

	public static void registerBlock(Block block, String name, Class<? extends ItemBlock> itemClass, boolean hasNoTexture) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		GameRegistry.registerBlock(block, itemClass, blockName);
	}

	public static void registerItem(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setTextureName(itemName);
		item.setUnlocalizedName(itemName);
		GameRegistry.registerItem(item, itemName);
	}
}