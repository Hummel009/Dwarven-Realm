package drealm.database;

import drealm.database.DRAchievement.DRAchievementCategory;
import drealm.util.DRCommander;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRDimension;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.world.map.LOTRWaypoint;

import java.util.EnumSet;

public class DRFaction {
	public static LOTRFaction RED_MOUNTAINS;
	public static LOTRFaction WIND_MOUNTAINS;

	public static void onInit() {
		setupRelations();
		setupMapInfo();
		setupControlZones();
		setupRanks();
	}

	public static void preInit() {
		setupFactions();
	}

	public static void setupControlZones() {
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(2437, 898, 454));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(2500, 1535, 292));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(WIND_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRCommander.addControlZone(RED_MOUNTAINS, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
	}

	public static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		RED_MOUNTAINS = DRCommander.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);
		WIND_MOUNTAINS = DRCommander.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
		RED_MOUNTAINS.approvesWarCrimes = false;
	}

	public static void setupMapInfo() {
		RED_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		WIND_MOUNTAINS.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
	}

	public static void setupRanks() {
		DRCommander.setFactionAchievementCategory(RED_MOUNTAINS, LOTRAchievement.Category.OROCARNI);
		DRCommander.addFactionRank(RED_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(RED_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(RED_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DRCommander.setFactionAchievementCategory(WIND_MOUNTAINS, DRAchievementCategory.WIND_MOUNTAINS);
		DRCommander.addFactionRank(WIND_MOUNTAINS, 10.0F, "guest").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 50.0F, "friend").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 500.0F, "champion").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1000.0F, "commander").makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRCommander.addFactionRank(WIND_MOUNTAINS, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
	}

	public static void setupRelations() {
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
