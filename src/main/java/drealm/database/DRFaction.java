package drealm.database;

import java.util.EnumSet;

import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.util.DRReflectionHelper;
import lotr.common.*;
import lotr.common.fac.*;
import lotr.common.world.map.LOTRWaypoint;

public class DRFaction {
	public static LOTRFaction RED_MOUNTAINS;
	public static LOTRFaction WIND_MOUNTAINS;

	public static void onInit() {
		DRFaction.setupRelations();
		DRFaction.setupMapInfo();
		DRFaction.setupControlZones();
		DRFaction.setupRanks();
	}

	public static void preInit() {
		DRFaction.setupFactions();
	}

	private static void setupControlZones() {
		DRReflectionHelper.addControlZone(RED_MOUNTAINS, new LOTRControlZone(2437, 898, 454));
		DRReflectionHelper.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(2500, 1535, 292));
		DRReflectionHelper.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRReflectionHelper.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRReflectionHelper.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRReflectionHelper.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
	}

	private static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);
		RED_MOUNTAINS = DRReflectionHelper.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		WIND_MOUNTAINS = DRReflectionHelper.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
		RED_MOUNTAINS.approvesWarCrimes = false;
	}

	private static void setupMapInfo() {
		RED_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		WIND_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
	}

	private static void setupRanks() {
		DRReflectionHelper.setFactionAchievementCategory(RED_MOUNTAINS, LOTRAchievement.Category.OROCARNI);
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(RED_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DRReflectionHelper.setFactionAchievementCategory(WIND_MOUNTAINS, DRAchievementCategory.WIND_MOUNTAINS);
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRReflectionHelper.addFactionRank(WIND_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
	}

	private static void setupRelations() {
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.ALLY);

		LOTRFactionRelations.setDefaultRelations(RED_MOUNTAINS, WIND_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);

		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DALE, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(WIND_MOUNTAINS, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.NEUTRAL);
	}
}
