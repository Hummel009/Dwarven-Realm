package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.EnumMap;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Achievements {
	private static final Map<ItemArmor.ArmorMaterial, LOTRAchievement> ARMOR_ACHIEVEMENTS = new EnumMap<>(ItemArmor.ArmorMaterial.class);
	public static LOTRAchievement tradeRedDwarfSmith;
	public static LOTRAchievement tradeRedDwarfMiner;
	public static LOTRAchievement tradeRedDwarfCommander;
	public static LOTRAchievement tradeRedDwarfMerchant;
	public static LOTRAchievement killRedDwarf;
	public static LOTRAchievement marryRedDwarf;
	public static LOTRAchievement doMiniquestRedMountains;
	public static LOTRAchievement smeltRedDwarfSteel;
	public static LOTRAchievement wearFullRedDwarven;
	public static LOTRAchievement useRedDwarvenTable;
	public static LOTRAchievement tradeWindDwarfSmith;
	public static LOTRAchievement tradeWindDwarfMiner;
	public static LOTRAchievement tradeWindDwarfCommander;
	public static LOTRAchievement tradeWindDwarfMerchant;
	public static LOTRAchievement killWindDwarf;
	public static LOTRAchievement marryWindDwarf;
	public static LOTRAchievement doMiniquestWindMountains;
	public static LOTRAchievement smeltWindDwarfSteel;
	public static LOTRAchievement wearFullWindDwarven;
	public static LOTRAchievement useWindDwarvenTable;

	private Achievements() {
	}

	private static LOTRAchievement createArmorAchievement(LOTRAchievement.Category category, int id, Item item, String name) {
		LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
		ARMOR_ACHIEVEMENTS.put(((ItemArmor) item).getArmorMaterial(), achievement);
		return achievement;
	}

	public static void onInit() {
		Category.onInit();
		smeltRedDwarfSteel = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 1, Items.redDwarfSteel, "smeltRedDwarfSteel");
		killRedDwarf = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 2, LOTRMod.dwarfBone, "killRedDwarf").setRequiresEnemy(Factions.redMountains).createTitle();
		wearFullRedDwarven = createArmorAchievement(LOTRAchievement.Category.OROCARNI, 3, Items.bodyRedDwarven, "wearFullRedDwarven");
		useRedDwarvenTable = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 4, Blocks.redDwarvenTable, "useRedDwarvenTable").setRequiresAlly(Factions.redMountains);
		tradeRedDwarfSmith = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 5, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(Factions.redMountains);
		tradeRedDwarfMiner = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 6, LOTRMod.silverCoin, "tradeRedDwarfMiner").setRequiresAlly(Factions.redMountains);
		tradeRedDwarfCommander = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 7, LOTRMod.silverCoin, "tradeRedDwarfCommander").setRequiresAlly(Factions.redMountains);
		tradeRedDwarfMerchant = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 8, LOTRMod.silverCoin, "tradeRedDwarfMerchant").setRequiresAlly(Factions.redMountains);
		marryRedDwarf = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 9, LOTRMod.dwarvenRing, "marryRedDwarf").setRequiresAlly(Factions.redMountains);
		doMiniquestRedMountains = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 10, LOTRMod.redBook, "doMiniquestRedMountains").setRequiresAlly(Factions.redMountains);
		tradeRedDwarfSmith = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 11, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(Factions.redMountains);

		smeltWindDwarfSteel = new LOTRAchievement(Category.windMountains, 12, Items.windDwarfSteel, "smeltWindDwarfSteel");
		killWindDwarf = new LOTRAchievement(Category.windMountains, 13, LOTRMod.dwarfBone, "killWindDwarf").setRequiresEnemy(Factions.windMountains).createTitle();
		wearFullWindDwarven = createArmorAchievement(Category.windMountains, 14, Items.bodyWindDwarven, "wearFullWindDwarven");
		useWindDwarvenTable = new LOTRAchievement(Category.windMountains, 15, Blocks.windDwarvenTable, "useWindDwarvenTable").setRequiresAlly(Factions.windMountains);
		tradeWindDwarfSmith = new LOTRAchievement(Category.windMountains, 16, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(Factions.windMountains);
		tradeWindDwarfMiner = new LOTRAchievement(Category.windMountains, 17, LOTRMod.silverCoin, "tradeWindDwarfMiner").setRequiresAlly(Factions.windMountains);
		tradeWindDwarfCommander = new LOTRAchievement(Category.windMountains, 18, LOTRMod.silverCoin, "tradeWindDwarfCommander").setRequiresAlly(Factions.windMountains);
		tradeWindDwarfMerchant = new LOTRAchievement(Category.windMountains, 19, LOTRMod.silverCoin, "tradeWindDwarfMerchant").setRequiresAlly(Factions.windMountains);
		marryWindDwarf = new LOTRAchievement(Category.windMountains, 20, LOTRMod.dwarvenRing, "marryWindDwarf").setRequiresAlly(Factions.windMountains);
		doMiniquestWindMountains = new LOTRAchievement(Category.windMountains, 21, LOTRMod.redBook, "doMiniquestWindMountains").setRequiresAlly(Factions.windMountains);
		tradeWindDwarfSmith = new LOTRAchievement(Category.windMountains, 22, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(Factions.windMountains);
	}

	public static void runAchievementCheck(EntityPlayer player) {
		ItemArmor.ArmorMaterial material = getFullArmorMaterial(player);
		if (ARMOR_ACHIEVEMENTS.containsKey(material)) {
			LOTRLevelData.getData(player).addAchievement(ARMOR_ACHIEVEMENTS.get(material));
		}
	}

	private static ItemArmor.ArmorMaterial getFullArmorMaterial(EntityLivingBase entity) {
		ItemArmor.ArmorMaterial material = null;
		for (int i = 1; i <= 4; ++i) {
			ItemStack item = entity.getEquipmentInSlot(i);
			if (item == null || !(item.getItem() instanceof ItemArmor)) {
				return null;
			}
			ItemArmor.ArmorMaterial itemMaterial = ((ItemArmor) item.getItem()).getArmorMaterial();
			if (material != null && itemMaterial != material) {
				return null;
			}
			material = itemMaterial;
		}
		return material;
	}

	@SuppressWarnings({"WeakerAccess", "PublicField"})
	public static class Category {
		public static LOTRAchievement.Category windMountains;

		private Category() {
		}

		public static void onInit() {
			windMountains = API.addAchievementCategory("WIND_MOUNTAINS", Factions.windMountains);
		}
	}
}