package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRDimension;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.world.map.LOTRWaypoint;

import java.util.EnumSet;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Factions {
	public static LOTRFaction redMountains;
	public static LOTRFaction windMountains;

	private Factions() {
	}

	public static void onInit() {
		setupRelations();
		setupMapInfo();
		setupControlZones();
		setupRanks();
	}

	public static void preInit() {
		setupFactions();
	}

	private static void setupControlZones() {
		API.addControlZone(redMountains, new LOTRControlZone(2437, 898, 454));
		API.addControlZone(redMountains, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		API.addControlZone(redMountains, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		API.addControlZone(windMountains, new LOTRControlZone(2500, 1535, 292));
		API.addControlZone(windMountains, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		API.addControlZone(windMountains, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
	}

	private static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);

		redMountains = API.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		redMountains.approvesWarCrimes = false;
		windMountains = API.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
	}

	private static void setupMapInfo() {
		redMountains.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		windMountains.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
	}

	private static void setupRanks() {
		API.setFactionAchievementCategory(redMountains, LOTRAchievement.Category.OROCARNI);
		API.addFactionRank(redMountains, 10.0F, "guest").makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 50.0F, "friend").makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		API.addFactionRank(redMountains, 200.0F, "axebearer").makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 500.0F, "champion").makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 1000.0F, "commander").makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 1500.0F, "lord", true).makeAchievement().makeTitle();
		API.addFactionRank(redMountains, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		API.setFactionAchievementCategory(windMountains, Achievements.Category.windMountains);
		API.addFactionRank(windMountains, 10.0F, "guest").makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 50.0F, "friend").makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		API.addFactionRank(windMountains, 200.0F, "axebearer").makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 500.0F, "champion").makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 1000.0F, "commander").makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 1500.0F, "lord", true).makeAchievement().makeTitle();
		API.addFactionRank(windMountains, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
	}

	private static void setupRelations() {
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.DALE, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.ALLY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.ALLY);

		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.HIGH_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.ANGMAR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.WOOD_ELF, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.LOTHLORIEN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.ISENGARD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.DOL_GULDUR, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.DORWINION, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.NEAR_HARAD, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.GONDOR, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.ROHAN, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.DALE, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.NEUTRAL);
	}
}
