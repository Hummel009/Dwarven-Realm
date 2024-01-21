package drealm.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drealm.content.DRBlocks;
import lotr.common.block.LOTRBlockSlabBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.IIcon;

public class DRBlockSlab extends LOTRBlockSlabBase {
	public DRBlockSlab(boolean flag) {
		super(flag, Material.rock, 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		if (j == 0) {
			return DRBlocks.pillar.getIcon(i, 0);
		}
		return super.getIcon(i, j);
	}

	public static class SlabExDouble extends ItemSlab {
		public SlabExDouble(Block block) {
			super(block, (BlockSlab) DRBlocks.slabSingle, (BlockSlab) DRBlocks.slabDouble, true);
		}
	}

	public static class SlabExSingle extends ItemSlab {
		public SlabExSingle(Block block) {
			super(block, (BlockSlab) DRBlocks.slabSingle, (BlockSlab) DRBlocks.slabDouble, false);
		}
	}
}