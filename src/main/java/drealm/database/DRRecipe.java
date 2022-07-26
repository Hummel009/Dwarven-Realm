package drealm.database;

import java.util.*;

import cpw.mods.fml.common.registry.GameRegistry;
import drealm.item.DRItemBanner;
import lotr.common.LOTRMod;
import lotr.common.recipe.*;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.*;

public class DRRecipe {
	public static List<IRecipe> red_mountains = new ArrayList<>();
	public static List<IRecipe> wind_mountains = new ArrayList<>();

	public static void createOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(DRRegistry.wall, 6, 0), "XXX", "XXX", Character.valueOf('X'), new ItemStack(DRRegistry.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.slab_single, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(DRRegistry.brick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.pillar, 3, 0), "X", "X", "X", Character.valueOf('X'), new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.brick, 1, 1), "XX", "XX", Character.valueOf('X'), new ItemStack(DRRegistry.brick, 4, 0));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.brick, 4, 0), "XX", "XX", Character.valueOf('X'), new ItemStack(Blocks.stained_hardened_clay, 1, 9));
		GameRegistry.addRecipe(new ItemStack(DRRegistry.ore_storage, 1, 0), "XXX", "XXX", "XXX", Character.valueOf('X'), DRRegistry.wind_dwarf_steel);
		GameRegistry.addRecipe(new ItemStack(DRRegistry.ore_storage, 1, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), DRRegistry.red_dwarf_steel);
		GameRegistry.addShapelessRecipe(new ItemStack(DRRegistry.wind_dwarf_steel, 9), new ItemStack(DRRegistry.ore_storage, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(DRRegistry.red_dwarf_steel, 9), new ItemStack(DRRegistry.ore_storage, 1, 1));
	}

	public static void createRedMountainsRecipes() {
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.red_dwarven_table), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.shovel_red_dwarven), "X", "Y", "Y", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pickaxe_red_dwarven), "XXX", " Y ", " Y ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.axe_red_dwarven), "XX", "XY", " Y", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.sword_red_dwarven), "X", "X", "Y", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hoe_red_dwarven), "XX", " Y", " Y", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.dagger_red_dwarven), "X", "Y", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.battleaxe_red_dwarven), "XXX", "XYX", " Y ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hammer_red_dwarven), "XYX", "XYX", " Y ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.helmet_red_dwarven), "XXX", "X X", Character.valueOf('X'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.body_red_dwarven), "X X", "XXX", "XXX", Character.valueOf('X'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.legs_red_dwarven), "XXX", "X X", "X X", Character.valueOf('X'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boots_red_dwarven), "X X", "X X", Character.valueOf('X'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.throwing_axe_red_dwarven), " X ", " YX", "Y  ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.chandelier, 0, 8), " X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.mattock_red_dwarven), "XXX", "XY ", " Y ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.RED_MOUNTAINS.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.spear_red_dwarven), "  X", " Y ", "Y  ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.red_dwarf_bars, 16), "XXX", "XXX", Character.valueOf('X'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boar_armor_red_dwarven), "X  ", "XYX", "XXX", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), Items.leather));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pike_red_dwarven), "  X", " YX", "Y  ", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6), Character.valueOf('Z'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), DRRegistry.red_dwarf_steel));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", Character.valueOf('X'), Blocks.stone));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", Character.valueOf('X'), Blocks.stone));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 0)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", Character.valueOf('X'), Blocks.stone));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", Character.valueOf('X'), Blocks.stone, Character.valueOf('Y'), new ItemStack(LOTRMod.ithildin, 1, 0)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", Character.valueOf('X'), Items.glowstone_dust, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 6), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 5), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 7), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 0)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 14), "XX", "XX", Character.valueOf('X'), LOTRMod.obsidianShard));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickObsidian, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 6), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 6), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		red_mountains.add(new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, new ItemStack(LOTRMod.ithildin, 1, 0)));
		red_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.ironCrossbow), "XXY", "ZYX", "YZX", Character.valueOf('X'), DRRegistry.red_dwarf_steel, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), Items.string));
		red_mountains.add(new ShapelessOreRecipe(new ItemStack(DRRegistry.red_dwarf_steel, 1), new ItemStack(LOTRMod.rock, 1, 4), "ingotIron"));
	}

	public static void createUnsmeltRecipes() {
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(red_mountains);
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(wind_mountains);
	}

	public static void createWindMountainsRecipes() {
		wind_mountains.add(new ShapelessOreRecipe(new ItemStack(DRRegistry.wind_dwarf_steel, 1), new ItemStack(Blocks.stained_hardened_clay, 1, 9), "ingotIron"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.wind_dwarven_table), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.shovel_wind_dwarven), "X", "Y", "Y", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pickaxe_wind_dwarven), "XXX", " Y ", " Y ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.axe_wind_dwarven), "XX", "XY", " Y", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.sword_wind_dwarven), "X", "X", "Y", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hoe_wind_dwarven), "XX", " Y", " Y", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.dagger_wind_dwarven), "X", "Y", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.battleaxe_wind_dwarven), "XXX", "XYX", " Y ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.hammer_wind_dwarven), "XYX", "XYX", " Y ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.helmet_wind_dwarven), "XXX", "X X", Character.valueOf('X'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.body_wind_dwarven), "X X", "XXX", "XXX", Character.valueOf('X'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.legs_wind_dwarven), "XXX", "X X", "X X", Character.valueOf('X'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boots_wind_dwarven), "X X", "X X", Character.valueOf('X'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.throwing_axe_wind_dwarven), " X ", " YX", "Y  ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.chandelier, 1, 8), " X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.mattock_wind_dwarven), "XXX", "XY ", " Y ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, DRItemBanner.RED_MOUNTAINS.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.spear_wind_dwarven), "  X", " Y ", "Y  ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.wind_dwarf_bars, 16), "XXX", "XXX", Character.valueOf('X'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.boar_armor_wind_dwarven), "X  ", "XYX", "XXX", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), Items.leather));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(DRRegistry.pike_wind_dwarven), "  X", " YX", "Y  ", Character.valueOf('X'), DRRegistry.wind_dwarf_steel, Character.valueOf('Y'), "stickWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6), Character.valueOf('Z'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), DRRegistry.wind_dwarf_steel));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 6), "XX", "XX", Character.valueOf('X'), Blocks.stone));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrick, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 7), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 7), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 0), "X", "X", "X", Character.valueOf('X'), Blocks.stone));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenForge), "XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 0)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoor), "XX", "XX", "XX", Character.valueOf('X'), Blocks.stone));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenDoorIthildin), "XX", "XY", "XX", Character.valueOf('X'), Blocks.stone, Character.valueOf('Y'), new ItemStack(LOTRMod.ithildin, 1, 0)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenBedItem), "XXX", "YYY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "plankWood"));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 8), " X ", "XYX", " X ", Character.valueOf('X'), "nuggetSilver", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 9), " X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 10), " X ", "XYX", " X ", Character.valueOf('X'), LOTRMod.mithrilNugget, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 12), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick3, 1, 12), " X ", "XYX", " X ", Character.valueOf('X'), Items.glowstone_dust, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 6), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 5), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 5)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle7, 6, 7), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 0)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 4, 14), "XX", "XX", Character.valueOf('X'), LOTRMod.obsidianShard));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsDwarvenBrickObsidian, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle8, 6, 6), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		wind_mountains.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 6), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick4, 1, 14)));
		wind_mountains.add(new LOTRRecipePoisonWeapon(LOTRMod.chisel, LOTRMod.chiselIthildin, new ItemStack(LOTRMod.ithildin, 1, 0)));
	}

	protected static boolean isIron(ItemStack itemstack) {
		return LOTRMod.isOreNameEqual(itemstack, "oreIron") || LOTRMod.isOreNameEqual(itemstack, "ingotIron");
	}

	public static void preInit() {
		DRRecipe.createRedMountainsRecipes();
		DRRecipe.createWindMountainsRecipes();
		DRRecipe.createOtherRecipes();
		DRRecipe.createUnsmeltRecipes();
	}
}