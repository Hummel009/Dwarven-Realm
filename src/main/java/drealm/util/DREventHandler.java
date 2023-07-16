package drealm.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import drealm.block.DRBlockTableRedDwarven;
import drealm.block.DRBlockTableWindDwarven;
import drealm.database.DRAchievement;
import drealm.database.DRRegistry;
import lotr.common.LOTRLevelData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class DREventHandler {
	public DREventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if ("drealm".equals(event.modID)) {
			DRConfig.load();
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
		if (container instanceof DRBlockTableRedDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(DRAchievement.useRedDwarvenTable);
		} else if (container instanceof DRBlockTableWindDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(DRAchievement.useWindDwarvenTable);
		}
	}

	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
		EntityPlayer entityplayer = event.player;
		ItemStack itemstack = event.smelting;
		if (!entityplayer.worldObj.isRemote) {
			if (itemstack.getItem() == DRRegistry.redDwarfSteel) {
				LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.smeltRedDwarfSteel);
			} else if (itemstack.getItem() == DRRegistry.windDwarfSteel) {
				LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.smeltWindDwarfSteel);
			}
		}
	}
}