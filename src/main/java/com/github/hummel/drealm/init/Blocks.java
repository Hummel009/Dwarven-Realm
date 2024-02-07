package com.github.hummel.drealm.init;

import com.github.hummel.drealm.Config;
import com.github.hummel.drealm.block.*;
import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import lotr.common.block.LOTRBlockBars;
import lotr.common.item.LOTRItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Blocks {
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

	private Blocks() {
	}

	public static void preInit() {
		brick = new BlockBrick();
		chandelier = new BlockChandelier();
		oreStorage = new BlockOreStorage();
		pillar = new BlockPillar();
		redDwarfBars = new LOTRBlockBars();
		redDwarvenTable = new BlockTableRedDwarven();
		slabDouble = new BlockSlab(true).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_double");
		slabSingle = new BlockSlab(false).setHardness(2.0f).setResistance(10.0f).setStepSound(Block.soundTypeStone).setBlockName("slab_single");
		wall = new BlockWall();
		windDwarfBars = new LOTRBlockBars();
		windDwarvenTable = new BlockTableWindDwarven();

		registerBlock(windDwarfBars, "windDwarfBars");
		registerBlock(redDwarfBars, "redDwarfBars");
		registerBlockNoAlt(redDwarvenTable, "redDwarvenTable");
		registerBlockNoAlt(windDwarvenTable, "windDwarvenTable");
		registerBlock(chandelier, "chandelier", LOTRItemBlockMetadata.class);
		registerBlockNoAlt(brick, "brick", LOTRItemBlockMetadata.class, true);
		registerBlockNoAlt(pillar, "pillar", LOTRItemBlockMetadata.class, true);
		registerBlock(oreStorage, "oreStorage", LOTRItemBlockMetadata.class);
		registerBlockNoAlt(wall, "wall", LOTRItemBlockMetadata.class, false);
		registerBlockNoAlt(slabSingle, "slabSingle", BlockSlab.SlabExSingle.class, true);
		registerBlockNoAlt(slabDouble, "slabDouble", BlockSlab.SlabExDouble.class, true);
	}

	private static void registerBlock(Block block, String name) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		block.setBlockName(blockName);
		if (Config.enableTextures14) {
			block.setBlockTextureName("drealm:" + blockName + "14");
		} else {
			block.setBlockTextureName("drealm:" + blockName);
		}
		GameRegistry.registerBlock(block, blockName);
	}

	private static void registerBlock(Block block, String name, Class<? extends ItemBlock> itemClass) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		String prefix = "drealm:";
		block.setBlockName(blockName);
		if (Config.enableTextures14) {
			block.setBlockTextureName(prefix + blockName + "14");
		} else {
			block.setBlockTextureName(prefix + blockName);
		}
		GameRegistry.registerBlock(block, itemClass, blockName);
	}

	private static void registerBlockNoAlt(Block block, String name) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		String prefix = "drealm:";
		block.setBlockName(blockName);
		block.setBlockTextureName(prefix + blockName);
		GameRegistry.registerBlock(block, blockName);
	}

	private static void registerBlockNoAlt(Block block, String name, Class<? extends ItemBlock> itemClass, boolean hasTexture) {
		String blockName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		String prefix = "drealm:";
		block.setBlockName(blockName);
		if (hasTexture) {
			block.setBlockTextureName(prefix + blockName);
		}
		GameRegistry.registerBlock(block, itemClass, blockName);
	}
}