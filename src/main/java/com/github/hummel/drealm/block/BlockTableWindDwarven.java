package com.github.hummel.drealm.block;

import com.github.hummel.drealm.Main;
import com.github.hummel.drealm.init.Blocks;
import com.github.hummel.drealm.init.Factions;
import com.github.hummel.drealm.util.GuiIds;
import com.github.hummel.drealm.init.Recipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.client.gui.LOTRGuiCraftingTable;
import lotr.common.LOTRLevelData;
import lotr.common.block.LOTRBlockCraftingTable;
import lotr.common.fac.LOTRAlignmentValues;
import lotr.common.inventory.LOTRContainerCraftingTable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTableWindDwarven extends LOTRBlockCraftingTable {
	@SideOnly(Side.CLIENT)
	private IIcon[] tableIcons;

	public BlockTableWindDwarven() {
		super(Material.rock, Factions.windMountains, GuiIds.WIND_DWARVEN.ordinal());
		setStepSound(soundTypeStone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (i == 1) {
			return tableIcons[2];
		}
		if (i == 0) {
			return net.minecraft.init.Blocks.stone.getIcon(0, 0);
		}
		return tableIcons[i == 4 || i == 5 ? 0 : 1];
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int side, float f, float f1, float f2) {
		boolean hasRequiredAlignment = LOTRLevelData.getData(entityplayer).getAlignment(tableFaction) >= 1.0f;
		if (hasRequiredAlignment) {
			if (!world.isRemote) {
				entityplayer.openGui(Main.instance, tableGUIID, world, i, j, k);
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

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		tableIcons = new IIcon[3];
		tableIcons[0] = iconregister.registerIcon(getTextureName() + "_side0");
		tableIcons[1] = iconregister.registerIcon(getTextureName() + "_side1");
		tableIcons[2] = iconregister.registerIcon(getTextureName() + "_top");
	}

	public static class Container extends LOTRContainerCraftingTable {
		public Container(InventoryPlayer inv, World world, int i, int j, int k) {
			super(inv, world, i, j, k, Recipes.WIND_MOUNTAINS, Blocks.windDwarvenTable);
		}
	}

	@SideOnly(Side.CLIENT)
	public static class Gui extends LOTRGuiCraftingTable {
		public Gui(InventoryPlayer inv, World world, int i, int j, int k) {
			super(new Container(inv, world, i, j, k), "wind_mountains");
		}
	}
}