package com.github.hummel.drealm.util;

import lotr.common.LOTRAchievement;
import lotr.common.LOTRDimension;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.item.LOTRItemBanner;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.util.ResourceLocation;

import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class EnumHelper {
	private static int lastBannerId = 52;

	private EnumHelper() {
	}

	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		return net.minecraftforge.common.util.EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
	}

	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = new Class[]{LOTRFaction.class};
		Object[] args = new Object[]{faction};
		LOTRShields shield = net.minecraftforge.common.util.EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
		ReflectionHelper.setShieldTexture(shield, new ResourceLocation("drealm", "shield/" + shield.name().toLowerCase(Locale.ROOT) + ".png"));
		return shield;
	}

	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerId++;
		LOTRItemBanner.BannerType banner = net.minecraftforge.common.util.EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(Locale.ROOT), new Class[]{Integer.TYPE, String.class, LOTRFaction.class}, new Object[]{id, name, faction});
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map<Integer, LOTRItemBanner.BannerType> map = cpw.mods.fml.relauncher.ReflectionHelper.getPrivateValue(LOTRItemBanner.BannerType.class, null, "bannerForID");
		map.put(id, banner);
		return banner;
	}

	private static LOTRFaction addFaction(String enumName, int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, boolean player, boolean registry, int alignment, LOTRMapRegion mapInfo, Set<LOTRFaction.FactionType> types) {
		Class<?>[] classArr = new Class[]{Integer.TYPE, LOTRDimension.class, LOTRDimension.DimensionRegion.class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, LOTRMapRegion.class, EnumSet.class};
		Object[] args = new Object[]{color, dim, region, player, registry, alignment, mapInfo, types};
		return net.minecraftforge.common.util.EnumHelper.addEnum(LOTRFaction.class, enumName, classArr, args);
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
		return net.minecraftforge.common.util.EnumHelper.addEnum(LOTRInvasions.class, enumName, classArr, args);
	}

	public static LOTRMiniQuestFactory addMiniQuestFactory(String enumName, String name) {
		Class<?>[] classArr = new Class[]{String.class};
		Object[] args = new Object[]{name};
		return net.minecraftforge.common.util.EnumHelper.addEnum(LOTRMiniQuestFactory.class, enumName, classArr, args);
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double d, double e) {
		return addWaypoint(name, region, faction, d, e, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class<?>[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
		Object[] args = new Object[]{region, faction, x, z, hidden};
		return net.minecraftforge.common.util.EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}
}
