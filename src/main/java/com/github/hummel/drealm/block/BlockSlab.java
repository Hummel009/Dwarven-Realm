package com.github.hummel.drealm.block;

import com.github.hummel.drealm.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.common.block.LOTRBlockSlabBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.IIcon;

public class BlockSlab extends LOTRBlockSlabBase {
	public BlockSlab(boolean flag) {
		super(flag, Material.rock, 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return Blocks.pillar.getIcon(i, 0);
		}
		return super.getIcon(i, j);
	}

	public static class SlabExDouble extends ItemSlab {
		public SlabExDouble(Block block) {
			super(block, (net.minecraft.block.BlockSlab) Blocks.slabSingle, (net.minecraft.block.BlockSlab) Blocks.slabDouble, true);
		}
	}

	public static class SlabExSingle extends ItemSlab {
		public SlabExSingle(Block block) {
			super(block, (net.minecraft.block.BlockSlab) Blocks.slabSingle, (net.minecraft.block.BlockSlab) Blocks.slabDouble, false);
		}
	}
}