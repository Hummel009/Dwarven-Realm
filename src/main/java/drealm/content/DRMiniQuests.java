package drealm.content;

import drealm.util.DRAPI;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityMordorOrc;
import lotr.common.entity.npc.LOTREntityMordorWarg;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRMiniQuests {
	public static LOTRMiniQuestFactory redMountains;
	public static LOTRMiniQuestFactory windMountains;

	private DRMiniQuests() {
	}

	private static void addMiniQuestsFactories() {
		redMountains = DRAPI.addMiniQuestFactory("RED_MOUNTAINS", "redMountains");
		windMountains = DRAPI.addMiniQuestFactory("WIND_MOUNTAINS", "windMountains");
	}

	public static void onInit() {
		addMiniQuestsFactories();
		setupMiniQuestFactories();
	}

	private static void setupMiniQuestFactories() {
		DRAPI.setMiniQuestFactoryAchievement(redMountains, DRAchievements.doMiniquestRedMountains);
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.hammerRedDwarven), 1, 3).setRewardFactor(5.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.battleaxeRedDwarven), 1, 3).setRewardFactor(5.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.throwingAxeRedDwarven), 1, 4).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestKillFaction.QFKillFaction("killMordor").setKillFaction(LOTRFaction.MORDOR, 20, 40));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityMordorOrc.class, 10, 30));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityMordorWarg.class, 10, 30));
		DRAPI.addMiniQuest(redMountains, new LOTRMiniQuestBounty.QFBounty<>("bounty"));

		DRAPI.setMiniQuestFactoryAchievement(windMountains, DRAchievements.doMiniquestWindMountains);
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.hammerWindDwarven), 1, 3).setRewardFactor(5.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.battleaxeWindDwarven), 1, 3).setRewardFactor(5.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRItems.throwingAxeWindDwarven), 1, 4).setRewardFactor(4.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction("killGondor").setKillFaction(LOTRFaction.GONDOR, 20, 40));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction("killElf").setKillFaction(LOTRFaction.WOOD_ELF, 20, 40));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction("killDorwinion").setKillFaction(LOTRFaction.DORWINION, 20, 40));
		DRAPI.addMiniQuest(windMountains, new LOTRMiniQuestBounty.QFBounty<>("bounty"));
	}
}
