package drealm.content;

import drealm.util.DRAPI;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

import java.util.EnumMap;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRAchievements {
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

	private DRAchievements() {
	}

	private static LOTRAchievement createArmorAchievement(LOTRAchievement.Category category, int id, Item item, String name) {
		LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
		ARMOR_ACHIEVEMENTS.put(((ItemArmor) item).getArmorMaterial(), achievement);
		return achievement;
	}

	public static void onInit() {
		Category.onInit();
		smeltRedDwarfSteel = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 1, DRItems.redDwarfSteel, "smeltRedDwarfSteel");
		killRedDwarf = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 2, LOTRMod.dwarfBone, "killRedDwarf").setRequiresEnemy(DRFactions.redMountains).createTitle();
		wearFullRedDwarven = createArmorAchievement(LOTRAchievement.Category.OROCARNI, 3, DRItems.bodyRedDwarven, "wearFullRedDwarven");
		useRedDwarvenTable = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 4, DRBlocks.redDwarvenTable, "useRedDwarvenTable").setRequiresAlly(DRFactions.redMountains);
		tradeRedDwarfSmith = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 5, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFactions.redMountains);
		tradeRedDwarfMiner = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 6, LOTRMod.silverCoin, "tradeRedDwarfMiner").setRequiresAlly(DRFactions.redMountains);
		tradeRedDwarfCommander = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 7, LOTRMod.silverCoin, "tradeRedDwarfCommander").setRequiresAlly(DRFactions.redMountains);
		tradeRedDwarfMerchant = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 8, LOTRMod.silverCoin, "tradeRedDwarfMerchant").setRequiresAlly(DRFactions.redMountains);
		marryRedDwarf = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 9, LOTRMod.dwarvenRing, "marryRedDwarf").setRequiresAlly(DRFactions.redMountains);
		doMiniquestRedMountains = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 10, LOTRMod.redBook, "doMiniquestRedMountains").setRequiresAlly(DRFactions.redMountains);
		tradeRedDwarfSmith = new LOTRAchievement(LOTRAchievement.Category.OROCARNI, 11, LOTRMod.silverCoin, "tradeRedDwarfSmith").setRequiresAlly(DRFactions.redMountains);

		smeltWindDwarfSteel = new LOTRAchievement(Category.windMountains, 12, DRItems.windDwarfSteel, "smeltWindDwarfSteel");
		killWindDwarf = new LOTRAchievement(Category.windMountains, 13, LOTRMod.dwarfBone, "killWindDwarf").setRequiresEnemy(DRFactions.windMountains).createTitle();
		wearFullWindDwarven = createArmorAchievement(Category.windMountains, 14, DRItems.bodyWindDwarven, "wearFullWindDwarven");
		useWindDwarvenTable = new LOTRAchievement(Category.windMountains, 15, DRBlocks.windDwarvenTable, "useWindDwarvenTable").setRequiresAlly(DRFactions.windMountains);
		tradeWindDwarfSmith = new LOTRAchievement(Category.windMountains, 16, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFactions.windMountains);
		tradeWindDwarfMiner = new LOTRAchievement(Category.windMountains, 17, LOTRMod.silverCoin, "tradeWindDwarfMiner").setRequiresAlly(DRFactions.windMountains);
		tradeWindDwarfCommander = new LOTRAchievement(Category.windMountains, 18, LOTRMod.silverCoin, "tradeWindDwarfCommander").setRequiresAlly(DRFactions.windMountains);
		tradeWindDwarfMerchant = new LOTRAchievement(Category.windMountains, 19, LOTRMod.silverCoin, "tradeWindDwarfMerchant").setRequiresAlly(DRFactions.windMountains);
		marryWindDwarf = new LOTRAchievement(Category.windMountains, 20, LOTRMod.dwarvenRing, "marryWindDwarf").setRequiresAlly(DRFactions.windMountains);
		doMiniquestWindMountains = new LOTRAchievement(Category.windMountains, 21, LOTRMod.redBook, "doMiniquestWindMountains").setRequiresAlly(DRFactions.windMountains);
		tradeWindDwarfSmith = new LOTRAchievement(Category.windMountains, 22, LOTRMod.silverCoin, "tradeWindDwarfSmith").setRequiresAlly(DRFactions.windMountains);
	}

	public static void runAchievementCheck(EntityPlayer player) {
		ItemArmor.ArmorMaterial material = DRMaterials.getFullArmorMaterial(player);
		if (ARMOR_ACHIEVEMENTS.containsKey(material)) {
			LOTRLevelData.getData(player).addAchievement(ARMOR_ACHIEVEMENTS.get(material));
		}
	}

	@SuppressWarnings({"WeakerAccess", "PublicField"})
	public static class Category {
		public static LOTRAchievement.Category windMountains;

		private Category() {
		}

		public static void onInit() {
			windMountains = DRAPI.addAchievementCategory("WIND_MOUNTAINS", DRFactions.windMountains);
		}
	}
}