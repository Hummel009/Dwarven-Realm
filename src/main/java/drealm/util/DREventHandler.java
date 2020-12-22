package drealm.util;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import drealm.block.*;
import drealm.database.*;
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
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote) {
			return;
		}
		Container container = player.openContainer;
		if (container instanceof DRBlockTableRedDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(DRAchievement.use_red_dwarven_table);
		} else if (container instanceof DRBlockTableWindDwarven.Container) {
			LOTRLevelData.getData(player).addAchievement(DRAchievement.use_wind_dwarven_table);
		}
	}

	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent event) {
		EntityPlayer entityplayer = event.player;
		ItemStack itemstack = event.smelting;
		if (!entityplayer.worldObj.isRemote) {
			if (itemstack.getItem() == DRRegistry.red_dwarf_steel) {
				LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.smelt_red_dwarf_steel);
			} else if (itemstack.getItem() == DRRegistry.wind_dwarf_steel) {
				LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.smelt_wind_dwarf_steel);
			}
		}
	}

}
