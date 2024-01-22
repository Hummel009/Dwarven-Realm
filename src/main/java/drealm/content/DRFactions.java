package drealm.content;

import drealm.util.DRAPI;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRDimension;
import lotr.common.fac.LOTRControlZone;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.LOTRFactionRelations;
import lotr.common.fac.LOTRMapRegion;
import lotr.common.world.map.LOTRWaypoint;

import java.util.EnumSet;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRFactions {
	public static LOTRFaction redMountains;
	public static LOTRFaction windMountains;

	private DRFactions() {
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
		DRAPI.addControlZone(redMountains, new LOTRControlZone(2437, 898, 454));
		DRAPI.addControlZone(redMountains, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRAPI.addControlZone(redMountains, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		DRAPI.addControlZone(windMountains, new LOTRControlZone(2500, 1535, 292));
		DRAPI.addControlZone(windMountains, new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		DRAPI.addControlZone(windMountains, new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
	}

	private static void setupFactions() {
		EnumSet<LOTRFaction.FactionType> enumSetFreeDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_FREE, LOTRFaction.FactionType.TYPE_DWARF);
		EnumSet<LOTRFaction.FactionType> enumSetEvilDwarf = EnumSet.of(LOTRFaction.FactionType.TYPE_ORC, LOTRFaction.FactionType.TYPE_DWARF);

		redMountains = DRAPI.addFaction("RED_MOUNTAINS", 0x570000, LOTRDimension.DimensionRegion.EAST, enumSetFreeDwarf);
		redMountains.approvesWarCrimes = false;
		windMountains = DRAPI.addFaction("WIND_MOUNTAINS", 0xCEA863, LOTRDimension.DimensionRegion.EAST, enumSetEvilDwarf);
	}

	private static void setupMapInfo() {
		redMountains.factionMapInfo = new LOTRMapRegion(2437, 898, 454);
		windMountains.factionMapInfo = new LOTRMapRegion(2500, 1535, 292);
	}

	private static void setupRanks() {
		DRAPI.setFactionAchievementCategory(redMountains, LOTRAchievement.Category.OROCARNI);
		DRAPI.addFactionRank(redMountains, 10.0F, "guest").makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 50.0F, "friend").makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRAPI.addFactionRank(redMountains, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 500.0F, "champion").makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 1000.0F, "commander").makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRAPI.addFactionRank(redMountains, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DRAPI.setFactionAchievementCategory(windMountains, DRAchievements.Category.windMountains);
		DRAPI.addFactionRank(windMountains, 10.0F, "guest").makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 50.0F, "friend").makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DRAPI.addFactionRank(windMountains, 200.0F, "axebearer").makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 500.0F, "champion").makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 1000.0F, "commander").makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 1500.0F, "lord", true).makeAchievement().makeTitle();
		DRAPI.addFactionRank(windMountains, 3000.0F, "uzbad", true).makeAchievement().makeTitle();
	}

	private static void setupRelations() {
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.GUNDABAD, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.MORTAL_ENEMY);
		LOTRFactionRelations.setDefaultRelations(redMountains, LOTRFaction.RHUDEL, LOTRFactionRelations.Relation.FRIEND);
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

		LOTRFactionRelations.setDefaultRelations(redMountains, windMountains, LOTRFactionRelations.Relation.NEUTRAL);

		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.MORDOR, LOTRFactionRelations.Relation.ALLY);
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
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.BLUE_MOUNTAINS, LOTRFactionRelations.Relation.NEUTRAL);
		LOTRFactionRelations.setDefaultRelations(windMountains, LOTRFaction.DURINS_FOLK, LOTRFactionRelations.Relation.NEUTRAL);
	}
}
