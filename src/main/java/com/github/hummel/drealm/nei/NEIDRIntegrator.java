package com.github.hummel.drealm.nei;

import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.github.hummel.drealm.block.BlockTableRedDwarven;
import com.github.hummel.drealm.block.BlockTableWindDwarven;
import com.github.hummel.drealm.init.Recipes;
import com.github.hummel.drealm.nei.handler.ShapedTableHandler;
import com.github.hummel.drealm.nei.handler.ShapelessTableHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class NEIDRIntegrator {
	private NEIDRIntegrator() {
	}

	private static void registerHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, List<IRecipe> recipes) {
		registerHandler(new ShapedTableHandler(recipes, guiClass, unlocalizedName));
		registerHandler(new ShapelessTableHandler(recipes, guiClass, unlocalizedName));
	}

	private static void registerHandler(TemplateRecipeHandler handler) {
		GuiCraftingRecipe.craftinghandlers.add(handler);
		GuiUsageRecipe.usagehandlers.add(handler);
	}

	public static void registerRecipes() {
		registerHandler("red_mountains", BlockTableRedDwarven.Gui.class, Recipes.RED_MOUNTAINS);
		registerHandler("wind_mountains", BlockTableWindDwarven.Gui.class, Recipes.WIND_MOUNTAINS);
	}
}