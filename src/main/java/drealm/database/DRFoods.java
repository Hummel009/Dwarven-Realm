package drealm.database;

import lotr.common.LOTRFoods;
import lotr.common.LOTRMod;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DRFoods {
	public static LOTRFoods RED_DWARF = new LOTRFoods(new ItemStack[]{new ItemStack(Items.cooked_porkchop), new ItemStack(Items.cooked_fished), new ItemStack(Items.cooked_chicken), new ItemStack(Items.cooked_beef), new ItemStack(LOTRMod.muttonCooked), new ItemStack(LOTRMod.gammon), new ItemStack(Items.bread)});
	public static LOTRFoods WIND_DWARF = new LOTRFoods(new ItemStack[]{new ItemStack(Items.cooked_porkchop), new ItemStack(Items.cooked_fished), new ItemStack(Items.cooked_chicken), new ItemStack(Items.cooked_beef), new ItemStack(LOTRMod.muttonCooked), new ItemStack(LOTRMod.gammon), new ItemStack(Items.bread)});
}