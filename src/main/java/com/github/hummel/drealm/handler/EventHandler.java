package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.block.BlockTableRedDwarven;
import com.github.hummel.drealm.block.BlockTableWindDwarven;
import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Items;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import lotr.common.LOTRLevelData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EventHandler {
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		EntityPlayer entityPlayer = event.player;
		World world = entityPlayer.worldObj;
		if (world.isRemote) {
			return;
		}
		Container container = entityPlayer.openContainer;
		if (container instanceof BlockTableRedDwarven.Container) {
			LOTRLevelData.getData(entityPlayer).addAchievement(Achievements.useRedDwarvenTable);
		} else if (container instanceof BlockTableWindDwarven.Container) {
			LOTRLevelData.getData(entityPlayer).addAchievement(Achievements.useWindDwarvenTable);
		}
	}

	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
		EntityPlayer entityPlayer = event.player;
		World world = entityPlayer.worldObj;
		if (world.isRemote) {
			return;
		}
		ItemStack itemStack = event.smelting;
		if (itemStack.getItem() == Items.redDwarfSteel) {
			LOTRLevelData.getData(entityPlayer).addAchievement(Achievements.smeltRedDwarfSteel);
		} else if (itemStack.getItem() == Items.windDwarfSteel) {
			LOTRLevelData.getData(entityPlayer).addAchievement(Achievements.smeltWindDwarfSteel);
		}
	}
}