package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.block.BlockTableRedDwarven;
import com.github.hummel.drealm.block.BlockTableWindDwarven;
import com.github.hummel.drealm.util.GuiIds;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getClientGuiElement(int id, EntityPlayer entityplayer, World world, int i, int j, int k) {
		GuiIds gui = GuiIds.values()[id];
		switch (gui) {
			case RED_DWARVEN:
				return new BlockTableRedDwarven.Gui(entityplayer.inventory, world, i, j, k);
			case WIND_DWARVEN:
				return new BlockTableWindDwarven.Gui(entityplayer.inventory, world, i, j, k);
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer entityplayer, World world, int i, int j, int k) {
		GuiIds gui = GuiIds.values()[id];
		switch (gui) {
			case RED_DWARVEN:
				return new BlockTableRedDwarven.Container(entityplayer.inventory, world, i, j, k);
			case WIND_DWARVEN:
				return new BlockTableWindDwarven.Container(entityplayer.inventory, world, i, j, k);
			default:
				return null;
		}
	}
}
