package drealm.content;

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

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRRecipes {
	private static final String STICK_WOOD = "stickWood";
	private static final String INGOT_IRON = "ingotIron";
	private static final String NUGGET_GOLD = "nuggetGold";
	private static final String NUGGET_SILVER = "nuggetSilver";
	private static final String PLANK_WOOD = "plankWood";
	private static final String ORE_IRON = "oreIron";

	public static List<IRecipe> redMountains = new ArrayList<>();
	public static List<IRecipe> windMountains = new ArrayList<>();

	private DRRecipes() {
	}

	private static void createOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(DRBlocks.wall, 6, 0), "XXX", "XXX", 'X', new ItemStack(DRBlocks.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRBlocks.slabSingle, 6, 0), "XXX", 'X', new ItemStack(DRBlocks.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRBlocks.pillar, 3, 0), "X", "X", "X", 'X', new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRBlocks.brick, 1, 1), "XX", "XX", 'X', new ItemStack(DRBlocks.brick, 4, 0));
		GameRegistry.addRecipe(new ItemStack(DRBlocks.brick, 4, 0), "XX", "XX", 'X', new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRBlocks.oreStorage, 1, 0), "XXX", "XXX", "XXX", 'X', DRItems.windDwarfSteel);
		GameRegistry.addRecipe(new ItemStack(DRBlocks.oreStorage, 1, 1), "XXX", "XXX", "XXX", 'X', DRItems.redDwarfSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(DRItems.windDwarfSteel, 9), new ItemStack(DRBlocks.oreStorage, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(DRItems.redDwarfSteel, 9), new ItemStack(DRBlocks.oreStorage, 1, 1));
	}

	private static void createRedMountainsRecipes() {
		redMountains.add(new ShapelessOreRecipe(new ItemStack(DRItems.redDwarfSteel, 1), new ItemStack(LOTRMod.rock, 1, 4), INGOT_IRON));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerRedDwarvenPoisoned), " ", "Y", "X", 'X', DRItems.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerRedDwarvenPoisoned), "Y", "X", " ", 'X', DRItems.daggerRedDwarven, 'Y', LOTRMod.bottlePoison));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.redDwarvenTable), "XX", "YY", 'X', PLANK_WOOD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.shovelRedDwarven), "X", "Y", "Y", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.pickaxeRedDwarven), "XXX", " Y ", " Y ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.axeRedDwarven), "XX", "XY", " Y", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.swordRedDwarven), "X", "X", "Y", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.hoeRedDwarven), "XX", " Y", " Y", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerRedDwarven), "X", "Y", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.battleaxeRedDwarven), "XXX", "XYX", " Y ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.hammerRedDwarven), "XYX", "XYX", " Y ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.helmetRedDwarven), "XXX", "X X", 'X', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.bodyRedDwarven), "X X", "XXX", "XXX", 'X', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.legsRedDwarven), "XXX", "X X", "X X", 'X', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.bootsRedDwarven), "X X", "X X", 'X', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.throwingAxeRedDwarven), " X ", " YX", "Y  ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.chandelier, 0, 8), " X ", "YZY", 'X', STICK_WOOD, 'Y', Blocks.torch, 'Z', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.mattockRedDwarven), "XXX", "XY ", " Y ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.redMountains.bannerID), "X", "Y", "Z", 'X', Blocks.wool, 'Y', STICK_WOOD, 'Z', PLANK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.spearRedDwarven), "  X", " Y ", "Y  ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.redDwarfBars, 16), "XXX", "XXX", 'X', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.boarArmorRedDwarven), "X  ", "XYX", "XXX", 'X', DRItems.redDwarfSteel, 'Y', Items.leather));
		redMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.pikeRedDwarven), "  X", " YX", "Y  ", 'X', DRItems.redDwarfSteel, 'Y', STICK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', Items.flint, 'Z', DRItems.redDwarfSteel));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', Blocks.stone));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', Blocks.wool, 'Y', PLANK_WOOD));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', NUGGET_SILVER, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		redMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', NUGGET_GOLD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
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

	private static void createUnsmeltRecipes() {
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(redMountains);
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(windMountains);
	}

	private static void createWindMountainsRecipes() {
		windMountains.add(new ShapelessOreRecipe(new ItemStack(DRItems.windDwarfSteel, 1), new ItemStack(Blocks.stained_hardened_clay, 1, 9), INGOT_IRON));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerWindDwarvenPoisoned), " ", "Y", "X", 'X', DRItems.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerWindDwarvenPoisoned), "Y", "X", " ", 'X', DRItems.daggerWindDwarven, 'Y', LOTRMod.bottlePoison));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.windDwarvenTable), "XX", "YY", 'X', PLANK_WOOD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.shovelWindDwarven), "X", "Y", "Y", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.pickaxeWindDwarven), "XXX", " Y ", " Y ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.axeWindDwarven), "XX", "XY", " Y", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.swordWindDwarven), "X", "X", "Y", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.hoeWindDwarven), "XX", " Y", " Y", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.daggerWindDwarven), "X", "Y", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.battleaxeWindDwarven), "XXX", "XYX", " Y ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.hammerWindDwarven), "XYX", "XYX", " Y ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.helmetWindDwarven), "XXX", "X X", 'X', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.bodyWindDwarven), "X X", "XXX", "XXX", 'X', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.legsWindDwarven), "XXX", "X X", "X X", 'X', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.bootsWindDwarven), "X X", "X X", 'X', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.throwingAxeWindDwarven), " X ", " YX", "Y  ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.chandelier, 1, 8), " X ", "YZY", 'X', STICK_WOOD, 'Y', Blocks.torch, 'Z', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.mattockWindDwarven), "XXX", "XY ", " Y ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.redMountains.bannerID), "X", "Y", "Z", 'X', Blocks.wool, 'Y', STICK_WOOD, 'Z', PLANK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.spearWindDwarven), "  X", " Y ", "Y  ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRBlocks.windDwarfBars, 16), "XXX", "XXX", 'X', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.boarArmorWindDwarven), "X  ", "XYX", "XXX", 'X', DRItems.windDwarfSteel, 'Y', Items.leather));
		windMountains.add(new ShapedOreRecipe(new ItemStack(DRItems.pikeWindDwarven), "  X", " YX", "Y  ", 'X', DRItems.windDwarfSteel, 'Y', STICK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", 'X', LOTRMod.gateGear, 'Y', new ItemStack(LOTRMod.brick, 1, 6), 'Z', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", 'X', "ingotCopper", 'Y', Items.flint, 'Z', DRItems.windDwarfSteel));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", 'X', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", 'X', new ItemStack(LOTRMod.pillar, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", 'X', Blocks.stone));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", 'X', Blocks.stone, 'Y', new ItemStack(LOTRMod.ithildin, 1, 0)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", 'X', Blocks.wool, 'Y', PLANK_WOOD));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", 'X', NUGGET_SILVER, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
		windMountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", 'X', NUGGET_GOLD, 'Y', new ItemStack(LOTRMod.brick, 1, 6)));
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
		return LOTRMod.isOreNameEqual(itemstack, ORE_IRON) || LOTRMod.isOreNameEqual(itemstack, INGOT_IRON);
	}

	public static void onInit() {
		createRedMountainsRecipes();
		createWindMountainsRecipes();
		createOtherRecipes();
		createUnsmeltRecipes();
	}
}