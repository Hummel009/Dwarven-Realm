package drealm.database;

import drealm.util.DRCommander;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityMordorOrc;
import lotr.common.entity.npc.LOTREntityMordorWarg;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DRMiniQuestFactory {
	public static LOTRMiniQuestFactory RED_MOUNTAINS;
	public static LOTRMiniQuestFactory WIND_MOUNTAINS;

	public static void addMiniQuestsFactories() {
		RED_MOUNTAINS = DRCommander.addMiniQuestFactory("RED_MOUNTAINS", "redMountains");
		WIND_MOUNTAINS = DRCommander.addMiniQuestFactory("WIND_MOUNTAINS", "windMountains");
	}

	public static void onInit() {
		addMiniQuestsFactories();
		setupMiniQuestFactories();
	}

	public static void setupMiniQuestFactories() {
		DRCommander.setMiniQuestFactoryAchievement(RED_MOUNTAINS, DRAchievement.doMiniquestRedMountains);
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammerRedDwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxeRedDwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwingAxeRedDwarven), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killMordor").setKillFaction(LOTRFaction.MORDOR, 20, 40));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityMordorOrc.class, 10, 30));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityMordorWarg.class, 10, 30));
		DRCommander.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty<>("bounty"));

		DRCommander.setMiniQuestFactoryAchievement(WIND_MOUNTAINS, DRAchievement.doMiniquestWindMountains);
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammerWindDwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxeWindDwarven), 1, 3).setRewardFactor(5.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwingAxeWindDwarven), 1, 4).setRewardFactor(4.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect<>("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killGondor").setKillFaction(LOTRFaction.GONDOR, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killElf").setKillFaction(LOTRFaction.WOOD_ELF, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killDorwinion").setKillFaction(LOTRFaction.DORWINION, 20, 40));
		DRCommander.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty<>("bounty"));
	}
}
