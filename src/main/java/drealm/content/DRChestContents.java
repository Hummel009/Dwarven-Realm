package drealm.content;

import lotr.common.LOTRMod;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;

public class DRChestContents {
	public static LOTRChestContents redDwarfHouseLarder;
	public static LOTRChestContents redMountainsStronghold;
	public static LOTRChestContents redMountainsSmithy;
	public static LOTRChestContents windDwarfHouseLarder;
	public static LOTRChestContents windMountainsStronghold;
	public static LOTRChestContents windMountainsSmithy;

	public static void onInit() {
		redDwarfHouseLarder = new LOTRChestContents(2, 5, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(Items.bread), 1, 3, 100), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 3, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_fished), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.mug), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.aleHorn), 1, 2, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletWood), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletGold), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.ceramicPlate), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.woodPlate), 1, 2, 50)});
		redMountainsStronghold = new LOTRChestContents(3, 5, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(DRItems.helmetRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.bodyRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.legsRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.bootsRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.swordRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.spearRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.battleaxeRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.daggerRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.hammerRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.pikeRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.pickaxeRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.mattockRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.throwingAxeRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.boarArmorRedDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(Items.coal), 1, 3, 100), new WeightedRandomChestContent(new ItemStack(Blocks.torch), 2, 4, 100), new WeightedRandomChestContent(new ItemStack(Items.iron_ingot), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.ironNugget), 1, 6, 25), new WeightedRandomChestContent(new ItemStack(DRItems.redDwarfSteel), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.mug), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.aleHorn), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletWood), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 1, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.compass), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.dwarvenRing), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.mithrilBook), 1, 1, 15)});
		redMountainsSmithy = new LOTRChestContents(3, 4, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(Items.coal), 1, 4, 100), new WeightedRandomChestContent(new ItemStack(Items.coal, 1, 1), 1, 4, 100), new WeightedRandomChestContent(new ItemStack(LOTRMod.rock, 1, 3), 1, 8, 50), new WeightedRandomChestContent(new ItemStack(Items.iron_ingot), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.ironNugget), 1, 6, 10), new WeightedRandomChestContent(new ItemStack(DRItems.redDwarfSteel), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.bronze), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.copper), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.tin), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.silver), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(Items.bucket), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(Items.bread), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.mithrilBook), 1, 1, 15)});
		windDwarfHouseLarder = new LOTRChestContents(2, 5, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(Items.bread), 1, 3, 100), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 2, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 3, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_fished), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.mug), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.aleHorn), 1, 2, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletWood), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletGold), 1, 3, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.ceramicPlate), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.woodPlate), 1, 2, 50)});
		windMountainsStronghold = new LOTRChestContents(3, 5, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(DRItems.helmetWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.bodyWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.legsWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.bootsWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.swordWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.spearWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.battleaxeWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.daggerWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.hammerWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.pikeWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.pickaxeWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.mattockWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.throwingAxeWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(DRItems.boarArmorWindDwarven), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(Items.coal), 1, 3, 100), new WeightedRandomChestContent(new ItemStack(Blocks.torch), 2, 4, 100), new WeightedRandomChestContent(new ItemStack(Items.iron_ingot), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.ironNugget), 1, 6, 25), new WeightedRandomChestContent(new ItemStack(DRItems.windDwarfSteel), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.mug), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.aleHorn), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gobletWood), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 1, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 1, 75), new WeightedRandomChestContent(new ItemStack(Items.compass), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.dwarvenRing), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.mithrilBook), 1, 1, 15)});
		windMountainsSmithy = new LOTRChestContents(3, 4, new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(Items.coal), 1, 4, 100), new WeightedRandomChestContent(new ItemStack(Items.coal, 1, 1), 1, 4, 100), new WeightedRandomChestContent(new ItemStack(LOTRMod.rock, 1, 3), 1, 8, 50), new WeightedRandomChestContent(new ItemStack(Items.iron_ingot), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.ironNugget), 1, 6, 10), new WeightedRandomChestContent(new ItemStack(DRItems.windDwarfSteel), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.bronze), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.copper), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.tin), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.silver), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(Items.bucket), 1, 2, 50), new WeightedRandomChestContent(new ItemStack(Items.cooked_porkchop), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(Items.cooked_chicken), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(Items.cooked_beef), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.muttonCooked), 1, 4, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.gammon), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(LOTRMod.deerCooked), 1, 1, 25), new WeightedRandomChestContent(new ItemStack(Items.bread), 1, 3, 50), new WeightedRandomChestContent(new ItemStack(LOTRMod.mithrilBook), 1, 1, 15)});
	}
}