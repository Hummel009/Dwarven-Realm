package drealm.util;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.client.LOTRTextures;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRCreativeTabs;
import lotr.common.LOTRDimension;
import lotr.common.LOTRShields;
import lotr.common.entity.npc.LOTRSpeech;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRank;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRMaterial;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.util.LOTRLog;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DRAPI {
	private static int lastBannerId = 52;

	private DRAPI() {
	}

	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		return EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
	}

	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		return EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
	}

	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerId++;
		LOTRItemBanner.BannerType banner = EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(Locale.ROOT), new Class[]{Integer.TYPE, String.class, LOTRFaction.class}, new Object[]{id, name, faction});
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map<Integer, LOTRItemBanner.BannerType> map = ReflectionHelper.getPrivateValue(LOTRItemBanner.BannerType.class, null, "bannerForID");
		map.put(id, banner);
		return banner;
	}

	public static void addControlZone(LOTRFaction faction, LOTRControlZone zone) {
		findAndInvokeMethod(zone, LOTRFaction.class, faction, "addControlZone", LOTRControlZone.class);
	}

	private static LOTRFaction addFaction(String enumName, int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, boolean player, boolean registry, int alignment, LOTRMapRegion mapInfo, Set<LOTRFaction.FactionType> types) {
		Class<?>[] classArr = new Class[]{Integer.TYPE, LOTRDimension.class, LOTRDimension.DimensionRegion.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, LOTRMapRegion.class, EnumSet.class};
		Object[] args = new Object[]{color, dim, region, player, registry, alignment, mapInfo, types};
		return EnumHelper.addEnum(LOTRFaction.class, enumName, classArr, args);
	}

	public static LOTRFaction addFaction(String enumName, int color, LOTRDimension.DimensionRegion region, Set<LOTRFaction.FactionType> types) {
		return addFaction(enumName, color, LOTRDimension.MIDDLE_EARTH, region, true, true, Integer.MIN_VALUE, null, types);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name) {
		return addFactionRank(faction, alignment, name, false);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name, boolean gendered) {
		return findAndInvokeMethod(new Object[]{alignment, name, gendered}, LOTRFaction.class, faction, "addRank", Float.TYPE, String.class, Boolean.TYPE);
	}

	public static LOTRInvasions addInvasion(String enumName, LOTRFaction faction) {
		return addInvasion(enumName, faction, null);
	}

	private static LOTRInvasions addInvasion(String enumName, LOTRFaction faction, String subfaction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class, String.class};
		Object[] args = new Object[]{faction, subfaction};
		return EnumHelper.addEnum(LOTRInvasions.class, enumName, classArr, args);
	}

	public static void addMiniQuest(LOTRMiniQuestFactory factory, LOTRMiniQuest.QuestFactoryBase<? extends LOTRMiniQuest> questFactory) {
		findAndInvokeMethod(questFactory, LOTRMiniQuestFactory.class, factory, "addQuest", LOTRMiniQuest.QuestFactoryBase.class);
	}

	public static LOTRMiniQuestFactory addMiniQuestFactory(String enumName, String name) {
		Class<?>[] classArr = new Class[]{String.class};
		Object[] args = new Object[]{name};
		return EnumHelper.addEnum(LOTRMiniQuestFactory.class, enumName, classArr, args);
	}

	static void addSpeechBank(String name, boolean rand, List<String> lines) {
		Class<?> speechBankClass = LOTRSpeech.class.getDeclaredClasses()[0];
		Object speechBank = findAndInvokeConstructor(new Object[]{name, rand, lines}, speechBankClass, String.class, boolean.class, List.class);
		Map<String, Object> allSpeechBanks = ReflectionHelper.getPrivateValue(LOTRSpeech.class, null, "allSpeechBanks");
		allSpeechBanks.put(name, speechBank);
		ReflectionHelper.setPrivateValue(LOTRSpeech.class, null, allSpeechBanks, "allSpeechBanks");
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double d, double e) {
		return addWaypoint(name, region, faction, d, e, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class<?>[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
		Object[] args = new Object[]{region, faction, x, z, hidden};
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static void changeInvasionIcon(LOTRInvasions invasion, Item icon) {
		ReflectionHelper.setPrivateValue(LOTRInvasions.class, invasion, (Object) icon, "invasionIcon");
	}

	private static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
		Constructor<E> constructor = findConstructor(clazz, parameterTypes);
		constructor.setAccessible(true);
		try {
			return constructor.newInstance(args);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException |
		         InvocationTargetException e) {
			LOTRLog.logger.error("Error when initializing constructor from class {} with parameters {}", clazz.getSimpleName(), args);
			e.printStackTrace();
			return null;
		}
	}

	private static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	private static <E> void findAndInvokeMethod(Object arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		findAndInvokeMethod(new Object[]{arg}, clazz, instance, new String[]{methodName}, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[]{methodName}, methodTypes);
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
			LOTRLog.logger.error("Error when getting constructor from class {} with parameters {}", clazz.getSimpleName(), parameterTypes);
			e.printStackTrace();
			return null;
		}
	}

	public static String getArmorName(LOTRItemArmor armor) {
		return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
	}

	private static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}

	private static BufferedImage getImage(InputStream in) {
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException ignored) {
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
		return ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + '/' + res.getResourcePath();
	}

	public static LOTRSpawnList newLOTRSpawnList(LOTRSpawnEntry... entries) {
		return findAndInvokeConstructor(new Object[]{entries}, LOTRSpawnList.class, LOTRSpawnEntry[].class);
	}

	public static void registerRoad(String name, Object... waypoints) {
		findAndInvokeMethod(new Object[]{name, waypoints}, LOTRRoads.class, null, "registerRoad", String.class, Object[].class);
	}

	@SideOnly(Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		ResourceLocation sepiaMapTexture;
		try {
			BufferedImage mapImage = getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = findAndInvokeMethod(new Object[]{mapImage, new ResourceLocation("lotr:map_sepia")}, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
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

	private static void setMaterialCraftingItem(LOTRMaterial material, Item toolItem, Item armorItem) {
		findAndInvokeMethod(new Object[]{toolItem, armorItem}, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
	}

	public static void setMiniQuestFactoryAchievement(LOTRMiniQuestFactory factory, LOTRAchievement achievement) {
		findAndInvokeMethod(achievement, LOTRMiniQuestFactory.class, factory, "setAchievement", LOTRAchievement.class);
	}

	@SuppressWarnings("NumericCastThatLosesPrecision")
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

	public static void setShieldTexture(LOTRShields shield, ResourceLocation resourceLocation) {
		try {
			Field privateField = LOTRShields.class.getDeclaredField("shieldTexture");
			privateField.setAccessible(true);
			privateField.set(shield, resourceLocation);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e2) {
			e2.printStackTrace();
		}
	}
}