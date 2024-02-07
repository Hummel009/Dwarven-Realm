package com.github.hummel.drealm.util;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
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
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.util.LOTRLog;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRSpawnEntry;
import lotr.common.world.spawning.LOTRSpawnList;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ReflectionHelper {
	private ReflectionHelper() {
	}

	public static void addControlZone(LOTRFaction faction, LOTRControlZone zone) {
		findAndInvokeMethod(zone, LOTRFaction.class, faction, "addControlZone", LOTRControlZone.class);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name) {
		return addFactionRank(faction, alignment, name, false);
	}

	public static LOTRFactionRank addFactionRank(LOTRFaction faction, float alignment, String name, boolean gendered) {
		return findAndInvokeMethod(new Object[]{alignment, name, gendered}, LOTRFaction.class, faction, "addRank", Float.TYPE, String.class, Boolean.TYPE);
	}

	public static void addMiniQuest(LOTRMiniQuestFactory factory, LOTRMiniQuest.QuestFactoryBase<? extends LOTRMiniQuest> questFactory) {
		findAndInvokeMethod(questFactory, LOTRMiniQuestFactory.class, factory, "addQuest", LOTRMiniQuest.QuestFactoryBase.class);
	}

	public static void addSpeechBank(String name, boolean rand, List<String> lines) {
		Class<?> speechBankClass = LOTRSpeech.class.getDeclaredClasses()[0];
		Object speechBank = findAndInvokeConstructor(new Object[]{name, rand, lines}, speechBankClass, String.class, boolean.class, List.class);
		Map<String, Object> allSpeechBanks = cpw.mods.fml.relauncher.ReflectionHelper.getPrivateValue(LOTRSpeech.class, null, "allSpeechBanks");
		allSpeechBanks.put(name, speechBank);
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRSpeech.class, null, allSpeechBanks, "allSpeechBanks");
	}

	public static void changeInvasionIcon(LOTRInvasions invasion, Item icon) {
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRInvasions.class, invasion, (Object) icon, "invasionIcon");
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
		Method addControlZoneMethod = cpw.mods.fml.relauncher.ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
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
		return cpw.mods.fml.relauncher.ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + '/' + res.getResourcePath();
	}

	public static LOTRSpawnList addLotrSpawnList(LOTRSpawnEntry... entries) {
		return findAndInvokeConstructor(new Object[]{entries}, LOTRSpawnList.class, LOTRSpawnEntry[].class);
	}

	public static void registerRoad(String name, Object... waypoints) {
		findAndInvokeMethod(new Object[]{name, waypoints}, LOTRRoads.class, null, "registerRoad", String.class, Object[].class);
	}

	@SideOnly(Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		ResourceLocation sepiaMapTexture;
		try {
			BufferedImage mapImage = getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = findAndInvokeMethod(new Object[]{mapImage, new ResourceLocation("lotr:map_sepia")}, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
		} catch (IOException e) {
			FMLLog.severe("Failed to generate GOT sepia map");
			e.printStackTrace();
			sepiaMapTexture = res;
		}
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
	}

	public static void setFactionAchievementCategory(LOTRFaction faction, LOTRAchievement.Category category) {
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRFaction.class, faction, category, "achieveCategory");
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
	public static void setCommonMapImage(ResourceLocation res) {
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
		cpw.mods.fml.relauncher.ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
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