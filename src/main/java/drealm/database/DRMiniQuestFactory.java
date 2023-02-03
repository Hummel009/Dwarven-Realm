package drealm.database;

import drealm.util.DRReflectionHelper;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DRMiniQuestFactory {
	public static LOTRMiniQuestFactory RED_MOUNTAINS;
	public static LOTRMiniQuestFactory WIND_MOUNTAINS;

	private static void addMiniQuestsFactories() {
		RED_MOUNTAINS = DRReflectionHelper.addMiniQuestFactory("RED_MOUNTAINS", "redMountains");
		WIND_MOUNTAINS = DRReflectionHelper.addMiniQuestFactory("WIND_MOUNTAINS", "windMountains");
	}

	public static void onInit() {
		DRMiniQuestFactory.addMiniQuestsFactories();
		DRMiniQuestFactory.setupMiniQuestFactories();
	}

	private static void setupMiniQuestFactories() {
		DRReflectionHelper.setMiniQuestFactoryAchievement(RED_MOUNTAINS, DRAchievement.do_miniquest_red_mountains);
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammer_red_dwarven), 1, 3).setRewardFactor(5.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxe_red_dwarven), 1, 3).setRewardFactor(5.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwing_axe_red_dwarven), 1, 4).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killMordor").setKillFaction(LOTRFaction.MORDOR, 20, 40));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killOrc").setKillEntity(LOTREntityMordorOrc.class, 10, 30));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityMordorWarg.class, 10, 30));
		DRReflectionHelper.addMiniQuest(RED_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty("bounty"));

		DRReflectionHelper.setMiniQuestFactoryAchievement(WIND_MOUNTAINS, DRAchievement.do_miniquest_wind_mountains);
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("mineMithril").setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectMineral").setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.hammer_wind_dwarven), 1, 3).setRewardFactor(5.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.battleaxe_wind_dwarven), 1, 3).setRewardFactor(5.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("forgeDwarfWeapon").setCollectItem(new ItemStack(DRRegistry.throwing_axe_wind_dwarven), 1, 4).setRewardFactor(4.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestCollect.QFCollect("collectDrink").setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killGondor").setKillFaction(LOTRFaction.GONDOR, 20, 40));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killDale").setKillFaction(LOTRFaction.DALE, 20, 40));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestKillFaction.QFKillFaction("killElf").setKillFaction(LOTRFaction.WOOD_ELF, 20, 40));
		DRReflectionHelper.addMiniQuest(WIND_MOUNTAINS, new LOTRMiniQuestBounty.QFBounty("bounty"));
	}
}
