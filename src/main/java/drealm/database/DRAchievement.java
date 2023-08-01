package drealm.database;

import drealm.util.DRCommander;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRAchievement.Category;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import java.util.EnumMap;
import java.util.Map;

public class DRAchievement {
	public static Map<ArmorMaterial, LOTRAchievement> armorAchievements = new EnumMap<>(ArmorMaterial.class);

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

	public static LOTRAchievement createArmorAchievement(LOTRAchievement.Category category, int id, Item item, String name) {
		LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
		armorAchievements.put(((ItemArmor) item).getArmorMaterial(), achievement);
		return achievement;
	}

	public static void onInit() {
		smeltRedDwarfSteel = new LOTRAchievement(Category.OROCARNI, 1, DRRegistry.redDwarfSteel, "smeltRedDwarfSteel");
		killRedDwarf = new LOTRAchievement(Category.OROCARNI, 2, LOTRMod.dwarfBone, "killRedDwarf").setRequiresEnemy(DRFaction.RED_MOUNTAINS).createTitle();
		wearFullRedDwarven = createArmorAchievement(Category.OROCARNI, 3, DRRegistry.bodyRedDwarven, "wearFullRedDwarven");
		useRedDwarvenTable = new LOTRAchievement(Category.OROCARNI, 4, DRRegistry.redDwarvenTable, "useRedDwarvenTable").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		tradeRedDwarfSmith = new LOTRAchievement(Category.OROCARNI, 5, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		tradeRedDwarfMiner = new LOTRAchievement(Category.OROCARNI, 6, LOTRMod.silverCoin, "tradeRedDwarfMiner").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		tradeRedDwarfCommander = new LOTRAchievement(Category.OROCARNI, 7, LOTRMod.silverCoin, "tradeRedDwarfCommander").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		tradeRedDwarfMerchant = new LOTRAchievement(Category.OROCARNI, 8, LOTRMod.silverCoin, "tradeRedDwarfMerchant").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		marryRedDwarf = new LOTRAchievement(Category.OROCARNI, 9, LOTRMod.dwarvenRing, "marryRedDwarf").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		doMiniquestRedMountains = new LOTRAchievement(Category.OROCARNI, 10, LOTRMod.redBook, "doMiniquestRedMountains").setRequiresAlly(DRFaction.RED_MOUNTAINS);
		tradeRedDwarfSmith = new LOTRAchievement(Category.OROCARNI, 11, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFaction.RED_MOUNTAINS);

		smeltWindDwarfSteel = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 12, DRRegistry.windDwarfSteel, "smeltWindDwarfSteel");
		killWindDwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 13, LOTRMod.dwarfBone, "killWindDwarf").setRequiresEnemy(DRFaction.WIND_MOUNTAINS).createTitle();
		wearFullWindDwarven = createArmorAchievement(DRAchievementCategory.WIND_MOUNTAINS, 14, DRRegistry.bodyWindDwarven, "wearFullWindDwarven");
		useWindDwarvenTable = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 15, DRRegistry.windDwarvenTable, "useWindDwarvenTable").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		tradeWindDwarfSmith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 16, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		tradeWindDwarfMiner = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 17, LOTRMod.silverCoin, "tradeWindDwarfMiner").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		tradeWindDwarfCommander = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 18, LOTRMod.silverCoin, "tradeWindDwarfCommander").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		tradeWindDwarfMerchant = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 19, LOTRMod.silverCoin, "tradeWindDwarfMerchant").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		marryWindDwarf = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 20, LOTRMod.dwarvenRing, "marryWindDwarf").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		doMiniquestWindMountains = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 21, LOTRMod.redBook, "doMiniquestWindMountains").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
		tradeWindDwarfSmith = new LOTRAchievement(DRAchievementCategory.WIND_MOUNTAINS, 22, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFaction.WIND_MOUNTAINS);
	}

	public static void runAchievementCheck(EntityPlayer player) {
		ItemArmor.ArmorMaterial material = DRMaterial.getFullArmorMaterial(player);
		if (armorAchievements.containsKey(material)) {
			LOTRLevelData.getData(player).addAchievement(armorAchievements.get(material));
		}
	}

	public static class DRAchievementCategory {
		public static LOTRAchievement.Category WIND_MOUNTAINS;

		public static void onInit() {
			WIND_MOUNTAINS = DRCommander.addAchievementCategory("WIND_MOUNTAINS", DRFaction.WIND_MOUNTAINS);
		}
	}
}