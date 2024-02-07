package com.github.hummel.drealm.handler;

import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.item.ItemStructureSpawner;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class TickHandler {
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote || !player.isEntityAlive() || event.phase != TickEvent.Phase.END) {
			return;
		}
		Achievements.runAchievementCheck(player);
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (event.phase == TickEvent.Phase.END && world == DimensionManager.getWorld(0) && ItemStructureSpawner.getLastStructureSpawnTick() > 0) {
			ItemStructureSpawner.setLastStructureSpawnTick(ItemStructureSpawner.getLastStructureSpawnTick() - 1);
		}
	}
}