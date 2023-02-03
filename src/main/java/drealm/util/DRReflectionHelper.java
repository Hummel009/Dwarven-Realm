package drealm.util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import javax.imageio.ImageIO;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import drealm.database.DRRegistry;
import lotr.client.LOTRTextures;
import lotr.common.*;
import lotr.common.LOTRDimension.DimensionRegion;
import lotr.common.entity.npc.*;
import lotr.common.fac.*;
import lotr.common.item.*;
import lotr.common.item.LOTRItemBanner.BannerType;
import lotr.common.quest.*;
import lotr.common.util.LOTRLog;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.scan.LOTRStructureScan;
import net.minecraft.client.Minecraft;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class DRReflectionHelper {
	public static int lastBannerID = 52;

	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class[] classArr = { LOTRFaction.class };
		Object[] args = { faction };
		return EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
	}

	public static void setShieldTexture(LOTRShields shield, ResourceLocation resourceLocation) {
		try {
			Field privateField = LOTRShields.class.getDeclaredField("shieldTexture");
			privateField.setAccessible(true);
			privateField.set(shield, resourceLocation);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e2) {
			e2.printStackTrace();
		}
	}

	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class[] classArr = { LOTRFaction.class };
		Object[] args = { faction };
		return EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
	}

	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerID++;
		LOTRItemBanner.BannerType banner = EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(), new Class[] { Integer.TYPE, String.class, LOTRFaction.class }, new Object[] { id, name, faction });
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map map = (Map) ReflectionHelper.getPrivateValue(LOTRItemBanner.BannerType.class, null, "bannerForID");
		LOTRItemBanner.BannerType prior = (BannerType) map.put(id, banner);
		if (prior != null) {
		}
		return banner;
	}

	public static void addControlZone(LOTRFaction faction, LOTRControlZone zone) {
		findAndInvokeMethod(zone, LOTRFaction.class, faction, "addControlZone", LOTRControlZone.class);
	}

	public static LOTRFaction addFaction(String enumName, int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, boolean player, boolean registry, int alignment, LOTRMapRegion mapInfo, Set<LOTRFaction.FactionType> types) {
		Class[] classArr = { Integer.TYPE, LOTRDimension.class, LOTRDimension.DimensionRegion.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, LOTRMapRegion.class, EnumSet.class };
		Object[] args = { color, dim, region, player, registry, alignment, mapInfo, types };
		return EnumHelper.addEnum(LOTRFaction.class, enumName, classArr, args);
	}

	public static LOTRFaction addFaction(String enumName, int color, LOTRDimension.DimensionRegion region, Set<LOTRFaction.FactionType> types) {
		return addFaction(enumName, color, LOTRDimension.MIDDLE_EARTH, region, true, true, Integer.MIN_VALUE, null, types);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name) {
		return addFactionRank(faction, alignment, name, false);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name, boolean gendered) {
		return (LOTRFactionRank) findAndInvokeMethod(new Object[] { Float.valueOf(alignment), name, gendered }, LOTRFaction.class, faction, "addRank", Float.TYPE, String.class, Boolean.TYPE);
	}

	public static LOTRInvasions addInvasion(String enumName, LOTRFaction faction) {
		return addInvasion(enumName, faction, null);
	}

	public static LOTRInvasions addInvasion(String enumName, LOTRFaction faction, String subfaction) {
		Class[] classArr = { LOTRFaction.class, String.class };
		Object[] args = { faction, subfaction };
		return EnumHelper.addEnum(LOTRInvasions.class, enumName, classArr, args);
	}

	public static void addMiniQuest(LOTRMiniQuestFactory factory, LOTRMiniQuest.QuestFactoryBase<? extends LOTRMiniQuest> questFactory) {
		findAndInvokeMethod(questFactory, LOTRMiniQuestFactory.class, factory, "addQuest", LOTRMiniQuest.QuestFactoryBase.class);
	}

	public static LOTRMiniQuestFactory addMiniQuestFactory(String enumName, String name) {
		Class[] classArr = { String.class };
		Object[] args = { name };
		return EnumHelper.addEnum(LOTRMiniQuestFactory.class, enumName, classArr, args);
	}

	public static void addNameBanks(Map<String, String[]> nameBanks) {
		Map allNameBanks = (Map) ReflectionHelper.getPrivateValue(LOTRNames.class, null, "allNameBanks");
		allNameBanks.putAll(nameBanks);
		ReflectionHelper.setPrivateValue(LOTRNames.class, null, (Object) allNameBanks, "allNameBanks");
	}

	public static LOTRWaypoint.Region addRegion(String name) {
		Class[] classArr = {};
		Object[] args = {};
		return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
	}

	public static void addSpeechBank(String name, boolean rand, List<String> lines) {
		Class<?> speechBankClass = LOTRSpeech.class.getDeclaredClasses()[0];
		Object speechBank = findAndInvokeConstructor(new Object[] { name, rand, lines }, speechBankClass, String.class, Boolean.TYPE, List.class);
		Map allSpeechBanks = (Map) ReflectionHelper.getPrivateValue(LOTRSpeech.class, null, "allSpeechBanks");
		allSpeechBanks.put(name, speechBank);
		ReflectionHelper.setPrivateValue(LOTRSpeech.class, null, allSpeechBanks, "allSpeechBanks");
	}

	public static void addSTRScans(Map<String, LOTRStructureScan> scans) {
		Map allScans = (Map) ReflectionHelper.getPrivateValue(LOTRStructureScan.class, null, "allLoadedScans");
		allScans.putAll(scans);
		ReflectionHelper.setPrivateValue(LOTRStructureScan.class, null, (Object) allScans, "allLoadedScans");
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double d, double e) {
		return addWaypoint(name, region, faction, d, e, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class[] classArr = { LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE };
		Object[] args = { region, faction, x, z, hidden };
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static void changeInvasionIcon(LOTRInvasions invasion, Item icon) {
		ReflectionHelper.setPrivateValue(LOTRInvasions.class, invasion, (Object) icon, "invasionIcon");
	}

	public static void clearMiniQuestFactory(LOTRMiniQuestFactory factory) {
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, null, "baseSpeechGroup");
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, null, "questAchievement");
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, new ArrayList(), "loreCategories");
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, null, "alignmentRewardOverride");
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, (Object) false, "noAlignRewardForEnemy");
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, new HashMap(), "questFactories");
	}

	private static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
		Constructor<E> constructor = findConstructor(clazz, parameterTypes);
		constructor.setAccessible(true);
		try {
			return constructor.newInstance(args);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e) {
			LOTRLog.logger.error("Error when initializing constructor from class " + clazz.getSimpleName() + " with parameters " + args);
			e.printStackTrace();
			return null;
		}
	}

	private static <T, E> T findAndInvokeMethod(Object arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(new Object[] { arg }, clazz, instance, new String[] { methodName }, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return DRReflectionHelper.findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static <E> Constructor<E> findConstructor(Class<E> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Error when getting constructor from class " + clazz.getSimpleName() + " with parameters " + parameterTypes);
			e.printStackTrace();
			return null;
		}
	}

	private static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}

	public static List<Item> getFields() {
		return getObjectFieldsOfType(DRRegistry.class, Item.class);
	}

	private static BufferedImage getImage(InputStream in) {
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	private static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	private static InputStream getInputStream(ResourceLocation res) {
		return getInputStream(getContainer(res), getPath(res));
	}

	public static LOTRCreativeTabs getLOTRCreativeTab(String name) {
		return (LOTRCreativeTabs) ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
		return getObjectFieldsOfType(clazz, null, type);
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, E instance, Class<? extends T> type) {
		List<T> list = new ArrayList<>();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (field != null) {
					Object fieldObj = null;
					if (Modifier.isStatic(field.getModifiers())) {
						fieldObj = field.get(null);
					} else if (instance != null) {
						fieldObj = field.get(instance);
					}
					if (fieldObj != null && type.isAssignableFrom(fieldObj.getClass())) {
						list.add((T) fieldObj);
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {

		}
		return list;
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}

	public static LOTRSpawnList newLOTRSpawnList(LOTRSpawnEntry... entries) {
		return findAndInvokeConstructor(new Object[] { entries }, LOTRSpawnList.class, LOTRSpawnEntry[].class);
	}

	public static DimensionRegion newRegion(String name, LOTRDimension dimension) {
		DimensionRegion ret = EnumHelper.addEnum(DimensionRegion.class, name.toUpperCase(), new Class[] { String.class }, new Object[] { name });
		dimension.dimensionRegions.add(ret);
		ret.setDimension(LOTRDimension.MIDDLE_EARTH);
		ret.factionList = new ArrayList();
		return ret;
	}

	public static void registerRoad(String name, Object... waypoints) {
		findAndInvokeMethod(new Object[] { name, waypoints }, LOTRRoads.class, null, "registerRoad", String.class, Object[].class);
	}

	@SideOnly(value = Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		ResourceLocation sepiaMapTexture;
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		try {
			BufferedImage mapImage = getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = findAndInvokeMethod(new Object[] { mapImage, new ResourceLocation("lotr:map_sepia") }, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
		} catch (IOException e) {
			FMLLog.severe("Failed to generate GOT sepia map");
			e.printStackTrace();
			sepiaMapTexture = res;
		}
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
	}

	public static void setFactionAchievementCategory(LOTRFaction faction, LOTRAchievement.Category category) {
		ReflectionHelper.setPrivateValue(LOTRFaction.class, faction, category, "achieveCategory");
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item item) {
		setMaterialCraftingItem(material, item, item);
	}

	public static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		findAndInvokeMethod(new Object[] { toolItem, armorItem }, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
	}

	public static void setMiniQuestBaseSpeechGroup(LOTRMiniQuestFactory factory, LOTRMiniQuestFactory quest) {
		ReflectionHelper.setPrivateValue(LOTRMiniQuestFactory.class, factory, quest, "baseSpeechGroup");
	}

	public static void setMiniQuestFactoryAchievement(LOTRMiniQuestFactory factory, LOTRAchievement achievement) {
		findAndInvokeMethod(achievement, LOTRMiniQuestFactory.class, factory, "setAchievement", LOTRAchievement.class);
	}

	public static void setMiniQuestFactoryLore(LOTRMiniQuestFactory factory, LOTRLore.LoreCategory... lore) {
		findAndInvokeMethod(new Object[] { lore }, LOTRMiniQuestFactory.class, factory, "setLore", LOTRLore.LoreCategory[].class);
	}

	public static void setServerMapImage(ResourceLocation res) {
		BufferedImage img = getImage(getInputStream(res));
		LOTRGenLayerWorld.imageWidth = img.getWidth();
		LOTRGenLayerWorld.imageHeight = img.getHeight();
		int[] colors = img.getRGB(0, 0, LOTRGenLayerWorld.imageWidth, LOTRGenLayerWorld.imageHeight, null, 0, LOTRGenLayerWorld.imageWidth);
		byte[] biomeImageData = new byte[LOTRGenLayerWorld.imageWidth * LOTRGenLayerWorld.imageHeight];
		for (int i = 0; i < colors.length; ++i) {
			int color = colors[i];
			Integer biomeID = LOTRDimension.MIDDLE_EARTH.colorsToBiomeIDs.get(color);
			if (biomeID != null) {
				biomeImageData[i] = (byte) biomeID.intValue();
			}
		}
		ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
	}

	public static void setToolMaterialRepairItem(Item.ToolMaterial material, ItemStack item) {
		ReflectionHelper.setPrivateValue(Item.ToolMaterial.class, material, item, "repairMaterial");
	}

}