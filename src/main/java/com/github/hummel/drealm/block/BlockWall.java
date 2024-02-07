package com.github.hummel.drealm.block;

import com.github.hummel.drealm.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockWallBase;
import net.minecraft.util.IIcon;

public class BlockWall extends LOTRBlockWallBase {
	public BlockWall() {
		super(LOTRMod.brick, 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return Blocks.brick.getIcon(i, 0);
		}
		return super.getIcon(i, j);
	}
}