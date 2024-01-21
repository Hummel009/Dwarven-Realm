package drealm.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drealm.content.DRBlocks;
import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockWallBase;
import net.minecraft.util.IIcon;

public class DRBlockWall extends LOTRBlockWallBase {
	public DRBlockWall() {
		super(LOTRMod.brick, 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return DRBlocks.brick.getIcon(i, 0);
		}
		return super.getIcon(i, j);
	}
}