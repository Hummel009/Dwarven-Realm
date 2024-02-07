package com.github.hummel.drealm.init;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.common.LOTRMod;
import lotr.common.recipe.LOTRRecipePoisonWeapon;
import lotr.common.recipe.LOTRRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Recipes {
	private static final String STICK_WOOD = "stickWood";
	private static final String INGOT_IRON = "ingotIron";
	private static final String NUGGET_GOLD = "nuggetGold";
	private static final String NUGGET_SILVER = "nuggetSilver";
	private static final String PLANK_WOOD = "plankWood";
	private static final String ORE_IRON = "oreIron";

	public static List<IRecipe> redMountains = new ArrayList<>();
	public static List<IRecipe> windMountains = new ArrayList<>();

	private Recipes() {
	}

	private static void createOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(Blocks.wall, 6, 0), "XXX", "XXX", 'X', new ItemStack(Blocks.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.slabSingle, 6, 0), "XXX", 'X', new ItemStack(Blocks.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.pillar, 3, 0), "X", "X", "X", 'X', new ItemStack(net.minecraft.init.Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(Blocks.brick, 1, 1), "XX", "XX", 'X', new ItemStack(Blocks.brick, 4, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.brick, 4, 0), "XX", "XX", 'X', new ItemStack(net.minecraft.init.Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(Blocks.oreStorage, 1, 0), "XXX", "XXX", "XXX", 'X', Items.windDwarfSteel);
		GameRegistry.addRecipe(new ItemStack(Blocks.oreStorage, 1, 1), "XXX", "XXX", "XXX", 'X', Items.redDwarfSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.windDwarfSteel, 9), new ItemStack(Blocks.oreStorage, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.redDwarfSteel, 9), new ItemStack(Blocks.oreStorage, 1, 1));
	}

	private static void createRedMountainsRecipes() {
		redMountains.add(new ShapelessOreRecipe(new ItemStack(Items.redDwarfSteel, 1), new ItemStack(LOTRMod.rock, 1, 4), INGOT_IRON));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerRedDwarvenPoisoned), " ", "Y", "X", 'X', Items.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerRedDwarvenPoisoned), "Y", "X", " ", 'X', Items.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.redDwarvenTable), "XX", "YY", 'X', PLANK_WOOD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.shovelRedDwarven), "X", "Y", "Y", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.pickaxeRedDwarven), "XXX", " Y ", " Y ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.axeRedDwarven), "XX", "XY", " Y", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.swordRedDwarven), "X", "X", "Y", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.hoeRedDwarven), "XX", " Y", " Y", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerRedDwarven), "X", "Y", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.battleaxeRedDwarven), "XXX", "XYX", " Y ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.hammerRedDwarven), "XYX", "XYX", " Y ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.helmetRedDwarven), "XXX", "X X", 'X', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.bodyRedDwarven), "X X", "XXX", "XXX", 'X', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.legsRedDwarven), "XXX", "X X", "X X", 'X', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.bootsRedDwarven), "X X", "X X", 'X', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.throwingAxeRedDwarven), " X ", " YX", "Y  ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.chandelier, 0, 8), " X ", "YZY", 'X', STICK_WOOD, 'Y', net.minecraft.init.Blocks.torch, 'Z', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.mattockRedDwarven), "XXX", "XY ", " Y ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, BannerTypes.redMountains.bannerID), "X", "Y", "Z", 'X', net.minecraft.init.Blocks.wool, 'Y', STICK_WOOD, 'Z', PLANK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.spearRedDwarven), "  X", " Y ", "Y  ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.redDwarfBars, 16), "XXX", "XXX", 'X', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.boarArmorRedDwarven), "X  ", "XYX", "XXX", 'X', Items.redDwarfSteel, 'Y', net.minecraft.init.Items.leather));
		redMountains.add(new ShapedOreRecipe(new ItemStack(Items.pikeRedDwarven), "  X", " YX", "Y  ", 'X', Items.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', net.minecraft.init.Items.flint, 'Z', Items.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', net.minecraft.init.Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', net.minecraft.init.Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', net.minecraft.init.Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', net.minecraft.init.Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', net.minecraft.init.Blocks.wool, 'Y', PLANK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', NUGGET_SILVER, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', NUGGET_GOLD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", 'X', LOTRMod.mithrilNugget, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", 'X', net.minecraft.init.Items.glowstone_dust, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickCracked, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 6), "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 5), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.pillar2, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 14), "XX", "XX", 'X', LOTRMod.obsidianShard));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickObsidian, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 6), "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 6), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		redMountains.add(new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, new ItemStack(LOTRMod.ithildin, 1, 0)));
	}

	private static void createUnsmeltRecipes() {
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(redMountains);
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(windMountains);
	}

	private static void createWindMountainsRecipes() {
		windMountains.add(new ShapelessOreRecipe(new ItemStack(Items.windDwarfSteel, 1), new ItemStack(net.minecraft.init.Blocks.stained_hardened_clay, 1, 9), INGOT_IRON));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerWindDwarvenPoisoned), " ", "Y", "X", 'X', Items.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerWindDwarvenPoisoned), "Y", "X", " ", 'X', Items.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.windDwarvenTable), "XX", "YY", 'X', PLANK_WOOD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.shovelWindDwarven), "X", "Y", "Y", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.pickaxeWindDwarven), "XXX", " Y ", " Y ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.axeWindDwarven), "XX", "XY", " Y", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.swordWindDwarven), "X", "X", "Y", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.hoeWindDwarven), "XX", " Y", " Y", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.daggerWindDwarven), "X", "Y", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.battleaxeWindDwarven), "XXX", "XYX", " Y ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.hammerWindDwarven), "XYX", "XYX", " Y ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.helmetWindDwarven), "XXX", "X X", 'X', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.bodyWindDwarven), "X X", "XXX", "XXX", 'X', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.legsWindDwarven), "XXX", "X X", "X X", 'X', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.bootsWindDwarven), "X X", "X X", 'X', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.throwingAxeWindDwarven), " X ", " YX", "Y  ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.chandelier, 1, 8), " X ", "YZY", 'X', STICK_WOOD, 'Y', net.minecraft.init.Blocks.torch, 'Z', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.mattockWindDwarven), "XXX", "XY ", " Y ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, BannerTypes.redMountains.bannerID), "X", "Y", "Z", 'X', net.minecraft.init.Blocks.wool, 'Y', STICK_WOOD, 'Z', PLANK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.spearWindDwarven), "  X", " Y ", "Y  ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Blocks.windDwarfBars, 16), "XXX", "XXX", 'X', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.boarArmorWindDwarven), "X  ", "XYX", "XXX", 'X', Items.windDwarfSteel, 'Y', net.minecraft.init.Items.leather));
		windMountains.add(new ShapedOreRecipe(new ItemStack(Items.pikeWindDwarven), "  X", " YX", "Y  ", 'X', Items.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', net.minecraft.init.Items.flint, 'Z', Items.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', net.minecraft.init.Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', net.minecraft.init.Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', net.minecraft.init.Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', net.minecraft.init.Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', net.minecraft.init.Blocks.wool, 'Y', PLANK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', NUGGET_SILVER, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', NUGGET_GOLD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", 'X', LOTRMod.mithrilNugget, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", 'X', net.minecraft.init.Items.glowstone_dust, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickCracked, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 6), "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 5), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 5)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.pillar2, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 14), "XX", "XX", 'X', LOTRMod.obsidianShard));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickObsidian, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 6), "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 6), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick4, 1, 14)));
		windMountains.add(new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, new ItemStack(LOTRMod.ithildin, 1, 0)));
	}

	public static boolean isIron(ItemStack itemstack) {
		return LOTRMod.isOreNameEqual(itemstack, ORE_IRON) || LOTRMod.isOreNameEqual(itemstack, INGOT_IRON);
	}

	public static void onInit() {
		createRedMountainsRecipes();
		createWindMountainsRecipes();
		createOtherRecipes();
		createUnsmeltRecipes();
	}
}