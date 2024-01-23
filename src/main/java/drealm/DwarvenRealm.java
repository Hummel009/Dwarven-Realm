package drealm;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import drealm.biome.DRBiome;
import drealm.content.*;
import drealm.entity.DREntity;
import drealm.item.DRItemBanner;
import drealm.proxy.DRCommonProxy;
import drealm.structure.DRStructure;
import drealm.util.*;
import integrator.NEIDRIntegrator;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "drealm", dependencies = "required-after:lotr", useMetadata = true)
public class DwarvenRealm {
	@Mod.Instance("drealm")
	private static DwarvenRealm instance;
	@SidedProxy(serverSide = "drealm.proxy.DRCommonProxy", clientSide = "drealm.proxy.DRClientProxy")
	private static DRCommonProxy proxy;

	public static DwarvenRealm getInstance() {
		return instance;
	}

	public static ModContainer getModContainer() {
		return FMLCommonHandler.instance().findContainerFor(instance);
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		DRTickHandlerServer tickHandler = new DRTickHandlerServer();
		DRMaterials.onInit();
		DRChestContents.onInit();
		DRInvasions.onInit();
		DRSpawnLists.onInit();
		DRBiome.onInit();
		DRRecipes.onInit();
		DRAchievements.onInit();
		DRRoads.onInit();
		DRTradeEntries.onInit();
		DRUnitTradeEntries.onInit();
		DRSpeech.onInit();
		DRStructure.onInit();
		DRMiniQuests.onInit();
		DRFactions.onInit();
		DRAPI.setServerMapImage(new ResourceLocation("drealm:map/map.png"));
		tickHandler.onInit();
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		DREventHandler eventHandler = new DREventHandler();
		DRConfig.preInit();
		DRFactions.preInit();
		DRWaypoints.preInit();
		DRItemBanner.preInit();
		DRCreativeTabs.preInit();
		DRBlocks.preInit();
		DRItems.preInit();
		DRFoods.preInit();
		DREntity.preInit();
		DRShields.preInit();
		if (DRModChecker.hasNEI() && DRModChecker.hasGuiContainer()) {
			NEIDRIntegrator.registerRecipes();
		}
		eventHandler.preInit();
		proxy.preInit(event);
	}
}
