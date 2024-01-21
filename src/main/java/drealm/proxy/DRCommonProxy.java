package drealm.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import drealm.block.DRBlockTableRedDwarven;
import drealm.block.DRBlockTableWindDwarven;
import drealm.content.DRGuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DRCommonProxy implements IGuiHandler {
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		DRGuiIds gui = DRGuiIds.values()[ID];
		switch (gui) {
			case RED_DWARVEN:
				return new DRBlockTableRedDwarven.Gui(entityplayer.inventory, world, i, j, k);
			case WIND_DWARVEN:
				return new DRBlockTableWindDwarven.Gui(entityplayer.inventory, world, i, j, k);
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		DRGuiIds gui = DRGuiIds.values()[ID];
		switch (gui) {
			case RED_DWARVEN:
				return new DRBlockTableRedDwarven.Container(entityplayer.inventory, world, i, j, k);
			case WIND_DWARVEN:
				return new DRBlockTableWindDwarven.Container(entityplayer.inventory, world, i, j, k);
			default:
				return null;
		}
	}

	public void onInit(FMLInitializationEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}
}