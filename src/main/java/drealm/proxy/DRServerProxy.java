package drealm.proxy;

import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.IGuiHandler;
import drealm.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DRServerProxy implements IGuiHandler {

	public void preInit(FMLPreInitializationEvent event) {
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		if (ID == 0) {
			return new DRBlockTableRedDwarven.Gui(entityplayer.inventory, world, i, j, k);
		}
		if (ID == 1) {
			return new DRBlockTableWindDwarven.Gui(entityplayer.inventory, world, i, j, k);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		if (ID == 0) {
			return new DRBlockTableRedDwarven.Container(entityplayer.inventory, world, i, j, k);
		}
		if (ID == 1) {
			return new DRBlockTableWindDwarven.Container(entityplayer.inventory, world, i, j, k);
		}
		return null;
	}

	public void onInit(FMLInitializationEvent event) {
	}
}