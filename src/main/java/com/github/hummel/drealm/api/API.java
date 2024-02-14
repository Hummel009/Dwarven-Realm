package com.github.hummel.drealm.api;

import com.github.hummel.drealm.Main;
import cpw.mods.fml.common.FMLCommonHandler;
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

public class API {
	private static int lastBannerId = 52;
	private static boolean setup;
	private static Method setUses;
	private static Method setDamage;
	private static Method setProtection;
	private static Method setSpeed;
	private static Method setHarvestLevel;
	private static Method setEnchantibility;
	private static Method setCraftingMaterial;
	private static Method setUndamageable;
	private static Method setManFlesh;
	private static Constructor<LOTRMaterial> constructor;

	private API() {
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
		Map<String, Object> allSpeechBanks = ReflectionHelper.getPrivateValue(LOTRSpeech.class, null, "allSpeechBanks");
		allSpeechBanks.put(name, speechBank);
		ReflectionHelper.setPrivateValue(LOTRSpeech.class, null, allSpeechBanks, "allSpeechBanks");
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

	public static ModContainer getModContainer() {
		return FMLCommonHandler.instance().findContainerFor(Main.instance);
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

	public static LOTRSpawnList addLotrSpawnList(LOTRSpawnEntry... entries) {
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
		ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
	}

	private static void setShieldTexture(LOTRShields shield, ResourceLocation resourceLocation) {
		try {
			Field privateField = LOTRShields.class.getDeclaredField("shieldTexture");
			privateField.setAccessible(true);
			privateField.set(shield, resourceLocation);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		return EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
	}

	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		LOTRShields shield = EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
		setShieldTexture(shield, new ResourceLocation("drealm", "shield/" + shield.name().toLowerCase(Locale.ROOT) + ".png"));
		return shield;
	}

	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerId++;
		LOTRItemBanner.BannerType banner = EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(Locale.ROOT), new Class[]{Integer.TYPE, String.class, LOTRFaction.class}, new Object[]{id, name, faction});
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map<Integer, LOTRItemBanner.BannerType> map = ReflectionHelper.getPrivateValue(LOTRItemBanner.BannerType.class, null, "bannerForID");
		map.put(id, banner);
		return banner;
	}

	private static LOTRFaction addFaction(String enumName, int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, boolean player, boolean registry, int alignment, LOTRMapRegion mapInfo, Set<LOTRFaction.FactionType> types) {
		Class<?>[] classArr = new Class[]{Integer.TYPE, LOTRDimension.class, LOTRDimension.DimensionRegion.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, LOTRMapRegion.class, EnumSet.class};
		Object[] args = new Object[]{color, dim, region, player, registry, alignment, mapInfo, types};
		return EnumHelper.addEnum(LOTRFaction.class, enumName, classArr, args);
	}

	public static LOTRFaction addFaction(String enumName, int color, LOTRDimension.DimensionRegion region, Set<LOTRFaction.FactionType> types) {
		return addFaction(enumName, color, LOTRDimension.MIDDLE_EARTH, region, true, true, Integer.MIN_VALUE, null, types);
	}

	public static LOTRInvasions addInvasion(String enumName, LOTRFaction faction) {
		return addInvasion(enumName, faction, null);
	}

	private static LOTRInvasions addInvasion(String enumName, LOTRFaction faction, String subfaction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class, String.class};
		Object[] args = new Object[]{faction, subfaction};
		return EnumHelper.addEnum(LOTRInvasions.class, enumName, classArr, args);
	}

	public static LOTRMiniQuestFactory addMiniQuestFactory(String enumName, String name) {
		Class<?>[] classArr = new Class[]{String.class};
		Object[] args = new Object[]{name};
		return EnumHelper.addEnum(LOTRMiniQuestFactory.class, enumName, classArr, args);
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double d, double e) {
		return addWaypoint(name, region, faction, d, e, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class<?>[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
		Object[] args = new Object[]{region, faction, x, z, hidden};
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	private static LOTRMaterial editLotrMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		accessLotrMaterial();
		try {
			if (uses != -1) {
				setUses.invoke(material, uses);
			}
			if (damage != -1.0f) {
				setDamage.invoke(material, damage);
			}
			if (protection != -1.0f) {
				setProtection.invoke(material, protection);
			}
			if (speed != -1.0f) {
				setSpeed.invoke(material, speed);
			}
			if (harvestLevel != -1) {
				setHarvestLevel.invoke(material, harvestLevel);
			}
			if (enchantability != -1) {
				setEnchantibility.invoke(material, enchantability);
			}
			if (craftingMaterialTool != null && craftingMaterialArmor != null) {
				setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke(material);
			}
			if (manFlesh) {
				setManFlesh.invoke(material);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOTRLog.logger.error("Failed to edit LOTRMaterial {}", material, e);
		}
		return material;
	}

	public static LOTRMaterial addLotrMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return addLotrMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	private static LOTRMaterial addLotrMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return addLotrMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	private static LOTRMaterial addLotrMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		accessLotrMaterial();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException |
		         InvocationTargetException e) {
			LOTRLog.logger.error("Failed to create LOTRMaterial {}", name, e);
		}
		return editLotrMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	private static void accessLotrMaterial() {
		if (setup) {
			return;
		}
		try {
			Class<LOTRMaterial> clazz = LOTRMaterial.class;
			constructor = clazz.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			setUses = clazz.getDeclaredMethod("setUses", Integer.TYPE);
			setUses.setAccessible(true);
			setDamage = clazz.getDeclaredMethod("setDamage", Float.TYPE);
			setDamage.setAccessible(true);
			setProtection = clazz.getDeclaredMethod("setProtection", Float.TYPE);
			setProtection.setAccessible(true);
			setSpeed = clazz.getDeclaredMethod("setSpeed", Float.TYPE);
			setSpeed.setAccessible(true);
			setHarvestLevel = clazz.getDeclaredMethod("setHarvestLevel", Integer.TYPE);
			setHarvestLevel.setAccessible(true);
			setEnchantibility = clazz.getDeclaredMethod("setEnchantability", Integer.TYPE);
			setEnchantibility.setAccessible(true);
			setCraftingMaterial = clazz.getDeclaredMethod("setCraftingItems", Item.class, Item.class);
			setCraftingMaterial.setAccessible(true);
			setUndamageable = clazz.getDeclaredMethod("setUndamageable");
			setUndamageable.setAccessible(true);
			setManFlesh = clazz.getDeclaredMethod("setManFlesh");
			setManFlesh.setAccessible(true);
			setup = true;
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Failed to setup LOTRMaterials.", e);
		}
	}
}