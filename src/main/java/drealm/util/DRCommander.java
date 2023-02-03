package drealm.util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import javax.imageio.ImageIO;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import lotr.client.LOTRTextures;
import lotr.common.*;
import lotr.common.entity.npc.LOTRSpeech;
import lotr.common.fac.*;
import lotr.common.item.*;
import lotr.common.item.LOTRItemBanner.BannerType;
import lotr.common.quest.*;
import lotr.common.util.LOTRLog;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class DRCommander {
	public static int lastBannerID = 52;

	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class[] classArr = { LOTRFaction.class };
		Object[] args = { faction };
		return EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
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

	static void addSpeechBank(String name, boolean rand, List<String> lines) {
		Class<?> speechBankClass = LOTRSpeech.class.getDeclaredClasses()[0];
		Object speechBank = findAndInvokeConstructor(new Object[] { name, Boolean.valueOf(rand), lines }, speechBankClass, String.class, boolean.class, List.class);
		Map<String, Object> allSpeechBanks = (Map<String, Object>) ReflectionHelper.getPrivateValue(LOTRSpeech.class, null, "allSpeechBanks");
		allSpeechBanks.put(name, speechBank);
		ReflectionHelper.setPrivateValue(LOTRSpeech.class, null, allSpeechBanks, "allSpeechBanks");
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double d, double e) {
		return addWaypoint(name, region, faction, d, e, false);
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class[] classArr = { LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE };
		Object[] args = { region, faction, x, z, hidden };
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static void changeInvasionIcon(LOTRInvasions invasion, Item icon) {
		ReflectionHelper.setPrivateValue(LOTRInvasions.class, invasion, (Object) icon, "invasionIcon");
	}

	public static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
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

	private static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	public static <T, E> T findAndInvokeMethod(Object arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(new Object[] { arg }, clazz, instance, new String[] { methodName }, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return DRCommander.findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <E> Constructor<E> findConstructor(Class<E> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Error when getting constructor from class " + clazz.getSimpleName() + " with parameters " + parameterTypes);
			e.printStackTrace();
			return null;
		}
	}

	public static String getArmorName(LOTRItemArmor armor) {
		return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
	}

	public static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}

	public static BufferedImage getImage(InputStream in) {
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

	public static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	public static InputStream getInputStream(ResourceLocation res) {
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

	public static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}

	public static LOTRSpawnList newLOTRSpawnList(LOTRSpawnEntry... entries) {
		return findAndInvokeConstructor(new Object[] { entries }, LOTRSpawnList.class, LOTRSpawnEntry[].class);
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

	public static void setMiniQuestFactoryAchievement(LOTRMiniQuestFactory factory, LOTRAchievement achievement) {
		findAndInvokeMethod(achievement, LOTRMiniQuestFactory.class, factory, "setAchievement", LOTRAchievement.class);
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