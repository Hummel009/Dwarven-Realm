package drealm.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import drealm.content.DRAchievements;
import drealm.item.DRItemStructureSpawner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

public class DRTickHandlerServer {
	public void onInit() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote || !player.isEntityAlive() || event.phase != TickEvent.Phase.END) {
			return;
		}
		DRAchievements.runAchievementCheck(player);
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (event.phase == TickEvent.Phase.END && world == DimensionManager.getWorld(0) && DRItemStructureSpawner.getLastStructureSpawnTick() > 0) {
			DRItemStructureSpawner.setLastStructureSpawnTick(DRItemStructureSpawner.getLastStructureSpawnTick() - 1);
		}
	}
}