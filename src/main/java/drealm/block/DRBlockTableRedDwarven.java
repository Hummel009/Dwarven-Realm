package drealm.block;

import cpw.mods.fml.relauncher.*;
import drealm.DwarvenRealm;
import drealm.database.*;
import lotr.client.gui.LOTRGuiCraftingTable;
import lotr.common.*;
import lotr.common.block.LOTRBlockCraftingTable;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.inventory.LOTRContainerCraftingTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.*;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class DRBlockTableRedDwarven extends LOTRBlockCraftingTable {
	@SideOnly(value = Side.CLIENT)
	private IIcon[] tableIcons;

	public DRBlockTableRedDwarven() {
		super(Material.rock, DRFaction.RED_MOUNTAINS, 0);
		setStepSound(Block.soundTypeStone);
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (i == 1) {
			return tableIcons[2];
		}
		if (i == 0) {
			return LOTRMod.brick2.getIcon(0, 2);
		}
		return i == 4 || i == 5 ? tableIcons[0] : tableIcons[1];
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		tableIcons = new IIcon[3];
		tableIcons[0] = iconregister.registerIcon(getTextureName() + "_side0");
		tableIcons[1] = iconregister.registerIcon(getTextureName() + "_side1");
		tableIcons[2] = iconregister.registerIcon(getTextureName() + "_top");
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int side, float f, float f1, float f2) {
		boolean hasRequiredAlignment;
		hasRequiredAlignment = LOTRLevelData.getData(entityplayer).getAlignment(tableFaction) >= 1.0f;
		if (hasRequiredAlignment) {
			if (!world.isRemote) {
				entityplayer.openGui(DwarvenRealm.instance, tableGUIID, world, i, j, k);
			}
		} else {
			for (int l = 0; l < 8; ++l) {
				double d = i + world.rand.nextFloat();
				double d1 = j + 1.0;
				double d2 = k + world.rand.nextFloat();
				world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0);
			}
			if (!world.isRemote) {
				LOTRAlignmentValues.notifyAlignmentNotHighEnough(entityplayer, 1.0f, tableFaction);
			}
		}
		return true;
	}

	@SideOnly(value = Side.CLIENT)
	public static class Gui extends LOTRGuiCraftingTable {
		public Gui(InventoryPlayer inv, World world, int i, int j, int k) {
			super(new Container(inv, world, i, j, k), "red_mountains");
		}
	}

	public static class Container extends LOTRContainerCraftingTable {
		public Container(InventoryPlayer inv, World world, int i, int j, int k) {
			super(inv, world, i, j, k, DRRecipe.red_mountains, DRRegistry.red_dwarven_table);
		}
	}
}
