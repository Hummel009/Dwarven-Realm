package integrator;

import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import drealm.block.DRBlockTableRedDwarven;
import drealm.block.DRBlockTableWindDwarven;
import drealm.content.DRRecipes;
import integrator.handler.DRHandlerTableShaped;
import integrator.handler.DRHandlerTableShapeless;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class NEIDRIntegrator {
	private NEIDRIntegrator() {
	}

	private static void registerHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, List<IRecipe> recipes) {
		registerHandler(new DRHandlerTableShaped(recipes, guiClass, unlocalizedName));
		registerHandler(new DRHandlerTableShapeless(recipes, guiClass, unlocalizedName));
	}

	private static void registerHandler(TemplateRecipeHandler handler) {
		GuiCraftingRecipe.craftinghandlers.add(handler);
		GuiUsageRecipe.usagehandlers.add(handler);
	}

	public static void registerRecipes() {
		registerHandler("red_mountains", DRBlockTableRedDwarven.Gui.class, DRRecipes.redMountains);
		registerHandler("wind_mountains", DRBlockTableWindDwarven.Gui.class, DRRecipes.windMountains);
	}
}