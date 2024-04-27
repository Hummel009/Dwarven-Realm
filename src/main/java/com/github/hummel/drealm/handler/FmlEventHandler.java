package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.block.BlockTableRedDwarven;
import com.github.hummel.drealm.block.BlockTableWindDwarven;
import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.item.ItemStructureSpawner;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import lotr.common.LOTRLevelData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class FmlEventHandler {
	@SubscribeEvent
	@SuppressWarnings("MethodMayBeStatic")
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote || !player.isEntityAlive() || event.phase != TickEvent.Phase.END) {
			return;
		}
		Achievements.runAchievementCheck(player);
	}

	@SubscribeEvent
	@SuppressWarnings("MethodMayBeStatic")
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (event.phase == TickEvent.Phase.END && world == DimensionManager.getWorld(0) && ItemStructureSpawner.getLastStructureSpawnTick() > 0) {
			ItemStructureSpawner.setLastStructureSpawnTick(ItemStructureSpawner.getLastStructureSpawnTick() - 1);
		}
	}

	@SubscribeEvent
	@SuppressWarnings("MethodMayBeStatic")
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
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
	@SuppressWarnings("MethodMayBeStatic")
	public void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
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