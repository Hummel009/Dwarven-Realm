package drealm.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.common.block.LOTRBlockOreStorageBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class DRBlockOreStorage extends LOTRBlockOreStorageBase {
	public DRBlockOreStorage() {
		setOreStorageNames("windDwarfSteel", "redDwarfSteel");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int i, int j) {
		return super.getIcon(i, j);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister) {
		super.registerBlockIcons(iconregister);
	}
}