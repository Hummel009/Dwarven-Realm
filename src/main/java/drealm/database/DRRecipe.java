package drealm.database;

import cpw.mods.fml.common.registry.GameRegistry;
import drealm.item.DRItemBanner;
import lotr.common.LOTRMod;
import lotr.common.recipe.LOTRRecipePoisonWeapon;
import lotr.common.recipe.LOTRRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

public class DRRecipe {
	public static List<IRecipe> redMountains = new ArrayList<>();
	public static List<IRecipe> windMountains = new ArrayList<>();

	public static void createOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(DRRegistry.wall, 6, 0), "XXX", "XXX", 'X', new ItemStack(DRRegistry.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.slabSingle, 6, 0), "XXX", 'X', new ItemStack(DRRegistry.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.pillar, 3, 0), "X", "X", "X", 'X', new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.brick, 1, 1), "XX", "XX", 'X', new ItemStack(DRRegistry.brick, 4, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.brick, 4, 0), "XX", "XX", 'X', new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.oreStorage, 1, 0), "XXX", "XXX", "XXX", 'X', DRRegistry.windDwarfSteel);
		GameRegistry.addRecipe(new ItemStack(DRRegistry.oreStorage, 1, 1), "XXX", "XXX", "XXX", 'X', DRRegistry.redDwarfSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(DRRegistry.windDwarfSteel, 9), new ItemStack(DRRegistry.oreStorage, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(DRRegistry.redDwarfSteel, 9), new ItemStack(DRRegistry.oreStorage, 1, 1));
	}

	public static void createRedMountainsRecipes() {
		redMountains.add(new ShapelessOreRecipe(new ItemStack(DRRegistry.redDwarfSteel, 1), new ItemStack(LOTRMod.rock, 1, 4), "ingotIron"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerRedDwarvenPoisoned), " ", "Y", "X", 'X', DRRegistry.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerRedDwarvenPoisoned), "Y", "X", " ", 'X', DRRegistry.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.redDwarvenTable), "XX", "YY", 'X', "plankWood", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.shovelRedDwarven), "X", "Y", "Y", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pickaxeRedDwarven), "XXX", " Y ", " Y ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.axeRedDwarven), "XX", "XY", " Y", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.swordRedDwarven), "X", "X", "Y", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hoeRedDwarven), "XX", " Y", " Y", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerRedDwarven), "X", "Y", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.battleaxeRedDwarven), "XXX", "XYX", " Y ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hammerRedDwarven), "XYX", "XYX", " Y ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.helmetRedDwarven), "XXX", "X X", 'X', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.bodyRedDwarven), "X X", "XXX", "XXX", 'X', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.legsRedDwarven), "XXX", "X X", "X X", 'X', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.bootsRedDwarven), "X X", "X X", 'X', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.throwingAxeRedDwarven), " X ", " YX", "Y  ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.chandelier, 0, 8), " X ", "YZY", 'X', "stickWood", 'Y', Blocks.torch, 'Z', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.mattockRedDwarven), "XXX", "XY ", " Y ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.RED_MOUNTAINS.bannerID), "X", "Y", "Z", 'X', Blocks.wool, 'Y', "stickWood", 'Z', "plankWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.spearRedDwarven), "  X", " Y ", "Y  ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.redDwarfBars, 16), "XXX", "XXX", 'X', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boarArmorRedDwarven), "X  ", "XYX", "XXX", 'X', DRRegistry.redDwarfSteel, 'Y', Items.leather));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pikeRedDwarven), "  X", " YX", "Y  ", 'X', DRRegistry.redDwarfSteel, 'Y', "stickWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', Items.flint, 'Z', DRRegistry.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', Blocks.wool, 'Y', "plankWood"));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', "nuggetSilver", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', "nuggetGold", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", 'X', LOTRMod.mithrilNugget, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", 'X', Items.glowstone_dust, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
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

	public static void createUnsmeltRecipes() {
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(redMountains);
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(windMountains);
	}

	public static void createWindMountainsRecipes() {
		windMountains.add(new ShapelessOreRecipe(new ItemStack(DRRegistry.windDwarfSteel, 1), new ItemStack(Blocks.stained_hardened_clay, 1, 9), "ingotIron"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerWindDwarvenPoisoned), " ", "Y", "X", 'X', DRRegistry.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerWindDwarvenPoisoned), "Y", "X", " ", 'X', DRRegistry.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.windDwarvenTable), "XX", "YY", 'X', "plankWood", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.shovelWindDwarven), "X", "Y", "Y", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pickaxeWindDwarven), "XXX", " Y ", " Y ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.axeWindDwarven), "XX", "XY", " Y", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.swordWindDwarven), "X", "X", "Y", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hoeWindDwarven), "XX", " Y", " Y", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.daggerWindDwarven), "X", "Y", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.battleaxeWindDwarven), "XXX", "XYX", " Y ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hammerWindDwarven), "XYX", "XYX", " Y ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.helmetWindDwarven), "XXX", "X X", 'X', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.bodyWindDwarven), "X X", "XXX", "XXX", 'X', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.legsWindDwarven), "XXX", "X X", "X X", 'X', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.bootsWindDwarven), "X X", "X X", 'X', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.throwingAxeWindDwarven), " X ", " YX", "Y  ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.chandelier, 1, 8), " X ", "YZY", 'X', "stickWood", 'Y', Blocks.torch, 'Z', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.mattockWindDwarven), "XXX", "XY ", " Y ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.RED_MOUNTAINS.bannerID), "X", "Y", "Z", 'X', Blocks.wool, 'Y', "stickWood", 'Z', "plankWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.spearWindDwarven), "  X", " Y ", "Y  ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.windDwarfBars, 16), "XXX", "XXX", 'X', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boarArmorWindDwarven), "X  ", "XYX", "XXX", 'X', DRRegistry.windDwarfSteel, 'Y', Items.leather));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pikeWindDwarven), "  X", " YX", "Y  ", 'X', DRRegistry.windDwarfSteel, 'Y', "stickWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', Items.flint, 'Z', DRRegistry.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', Blocks.wool, 'Y', "plankWood"));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', "nuggetSilver", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', "nuggetGold", 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", 'X', LOTRMod.mithrilNugget, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", 'X', Items.glowstone_dust, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
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
		return LOTRMod.isOreNameEqual(itemstack, "oreIron") || LOTRMod.isOreNameEqual(itemstack, "ingotIron");
	}

	public static void preInit() {
		createRedMountainsRecipes();
		createWindMountainsRecipes();
		createOtherRecipes();
		createUnsmeltRecipes();
	}
}