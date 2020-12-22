package drealm.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import drealm.database.DRAchievement;
import drealm.item.DRItemStructureSpawner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.*;

public class DRTickHandlerServer {
	public DRTickHandlerServer() {
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
		DRAchievement.runAchievementCheck(player);
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (event.phase == TickEvent.Phase.END) {
			if (world == DimensionManager.getWorld(0)) {
				if (DRItemStructureSpawner.lastStructureSpawnTick > 0) {
					--DRItemStructureSpawner.lastStructureSpawnTick;
				}
			}
		}
	}

}
