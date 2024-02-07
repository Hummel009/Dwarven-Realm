package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.Config;
import com.github.hummel.drealm.block.BlockTableRedDwarven;
import com.github.hummel.drealm.block.BlockTableWindDwarven;
import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Items;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import lotr.common.LOTRLevelData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EventHandler {
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if ("com/github/hummel/drealm".equals(event.modID)) {
			Config.load();
		}
	}

	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote) {
			return;
		}
		Container container = player.openContainer;
		if (container instanceof BlockTableRedDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(Achievements.useRedDwarvenTable);
		} else if (container instanceof BlockTableWindDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(Achievements.useWindDwarvenTable);
		}
	}

	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
		EntityPlayer entityplayer = event.player;
		ItemStack itemstack = event.smelting;
		if (!entityplayer.worldObj.isRemote) {
			if (itemstack.getItem() == Items.redDwarfSteel) {
				LOTRLevelData.getData(entityplayer).addAchievement(Achievements.smeltRedDwarfSteel);
			} else if (itemstack.getItem() == Items.windDwarfSteel) {
				LOTRLevelData.getData(entityplayer).addAchievement(Achievements.smeltWindDwarfSteel);
			}
		}
	}
}