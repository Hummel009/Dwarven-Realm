package lotr.common.tileentity;

import drealm.database.DRRegistry;
import lotr.common.LOTRMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.StatCollector;

public class LOTRTileEntityDwarvenForge extends LOTRTileEntityAlloyForgeBase {
	@Override
	public String getForgeName() {
		return StatCollector.translateToLocal("container.lotr.dwarvenForge");
	}

	@Override
	public ItemStack getSmeltingResult(ItemStack itemstack) {
		if (itemstack.getItem() == Item.getItemFromBlock(LOTRMod.oreMithril)) {
			return new ItemStack(LOTRMod.mithril);
		}
		return super.getSmeltingResult(itemstack);
	}

	@Override
	protected ItemStack getAlloySmeltingResult(ItemStack itemstack, ItemStack alloyItem) {
		if (isIron(itemstack) && isCoal(alloyItem)) {
			return new ItemStack(LOTRMod.dwarfSteel);
		}
		if (isIron(itemstack) && alloyItem.getItem() == LOTRMod.quenditeCrystal) {
			return new ItemStack(LOTRMod.galvorn);
		}
		if (isIron(itemstack) && alloyItem.getItem() == Item.getItemFromBlock(LOTRMod.rock) && alloyItem.getItemDamage() == 3) {
			return new ItemStack(LOTRMod.blueDwarfSteel);
		}
		if (isIron(itemstack) && alloyItem.getItem() == Item.getItemFromBlock(LOTRMod.rock) && alloyItem.getItemDamage() == 4) {
			return new ItemStack(DRRegistry.red_dwarf_steel);
		}
		if (isIron(itemstack) && alloyItem.getItem() == Item.getItemFromBlock(Blocks.stained_hardened_clay) && alloyItem.getItemDamage() == 9) {
			return new ItemStack(DRRegistry.wind_dwarf_steel);
		}
		return super.getAlloySmeltingResult(itemstack, alloyItem);
	}
}
