package drealm;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import drealm.biome.DRBiome;
import drealm.database.*;
import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.entity.DREntity;
import drealm.item.DRItemBanner;
import drealm.map.DRRoads;
import drealm.map.DRWaypoint;
import drealm.proxy.DRServerProxy;
import drealm.structure.DRStructure;
import drealm.util.*;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "drealm", dependencies = "required-after:lotr")
public class DwarvenRealm {
	@SidedProxy(serverSide = "drealm.proxy.DRServerProxy", clientSide = "drealm.proxy.DRClientProxy")
	public static DRServerProxy proxy;
	@Mod.Instance("drealm")
	public static DwarvenRealm instance;
	public static DREventHandler eventHandler;
	public static DRTickHandlerServer tickHandler;

	public static ModContainer getModContainer() {
		return FMLCommonHandler.instance().findContainerFor(instance);
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		DRMaterial.onInit();
		DRShields.onInit();
		DRInvasions.onInit();
		DRAchievementCategory.onInit();
		DRAchievement.onInit();
		DRFaction.onInit();
		DRMiniQuestFactory.onInit();
		DRRoads.onInit();
		DRSpeech.onInit();
		DRCommander.setServerMapImage(new ResourceLocation("drealm:map/map.png"));
		tickHandler = new DRTickHandlerServer();
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		eventHandler = new DREventHandler();
		DRConfig.preInit();
		DRCreativeTabs.preInit();
		DRFaction.preInit();
		DRWaypoint.preInit();
		DRItemBanner.preInit();
		DRRegistry.preInit();
		DREntity.preInit();
		DRStructure.preInit();
		DRRecipe.preInit();
		DRBiome.preInit();
		proxy.preInit(event);
	}
}
