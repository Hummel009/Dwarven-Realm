package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityMordorOrc;
import lotr.common.entity.npc.LOTREntityMordorWarg;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class MiniQuests {
	private static final String COLLECT_MINERAL = "collectMineral";
	private static final String FORGE_DWARF_WEAPON = "forgeDwarfWeapon";
	private static final String COLLECT_DRINK = "collectDrink";
	private static final String KILL_GONDOR = "killGondor";
	private static final String KILL_ELF = "killElf";
	private static final String KILL_DORWINION = "killDorwinion";
	private static final String BOUNTY = "bounty";
	private static final String KILL_WARG = "killWarg";
	private static final String KILL_ORC = "killOrc";
	private static final String KILL_MORDOR = "killMordor";
	private static final String MINE_MITHRIL = "mineMithril";

	public static LOTRMiniQuestFactory redMountains;
	public static LOTRMiniQuestFactory windMountains;

	private MiniQuests() {
	}

	private static void addMiniQuestsFactories() {
		redMountains = API.addMiniQuestFactory("RED_MOUNTAINS", "redMountains");
		windMountains = API.addMiniQuestFactory("WIND_MOUNTAINS", "windMountains");
	}

	public static void onInit() {
		addMiniQuestsFactories();
		setupMiniQuestFactories();
	}

	private static void setupMiniQuestFactories() {
		API.setMiniQuestFactoryAchievement(redMountains, Achievements.doMiniquestRedMountains);
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(MINE_MITHRIL).setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(net.minecraft.init.Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(net.minecraft.init.Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.hammerRedDwarven), 1, 3).setRewardFactor(5.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.battleaxeRedDwarven), 1, 3).setRewardFactor(5.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.throwingAxeRedDwarven), 1, 4).setRewardFactor(4.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_DRINK).setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		API.addMiniQuest(redMountains, new LOTRMiniQuestKillFaction.QFKillFaction(KILL_MORDOR).setKillFaction(LOTRFaction.MORDOR, 20, 40));
		API.addMiniQuest(redMountains, new LOTRMiniQuestKillEntity.QFKillEntity(KILL_ORC).setKillEntity(LOTREntityMordorOrc.class, 10, 30));
		API.addMiniQuest(redMountains, new LOTRMiniQuestKillEntity.QFKillEntity(KILL_WARG).setKillEntity(LOTREntityMordorWarg.class, 10, 30));
		API.addMiniQuest(redMountains, new LOTRMiniQuestBounty.QFBounty<>(BOUNTY));

		API.setMiniQuestFactoryAchievement(windMountains, Achievements.doMiniquestWindMountains);
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(MINE_MITHRIL).setCollectItem(new ItemStack(LOTRMod.mithril), 1, 2).setRewardFactor(50.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(net.minecraft.init.Items.gold_ingot), 3, 15).setRewardFactor(4.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.silver), 3, 15).setRewardFactor(4.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(net.minecraft.init.Items.glowstone_dust), 5, 15).setRewardFactor(2.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.diamond), 1, 3).setRewardFactor(15.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.sapphire), 1, 3).setRewardFactor(12.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.opal), 1, 3).setRewardFactor(10.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_MINERAL).setCollectItem(new ItemStack(LOTRMod.amethyst), 1, 3).setRewardFactor(10.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.hammerWindDwarven), 1, 3).setRewardFactor(5.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.battleaxeWindDwarven), 1, 3).setRewardFactor(5.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(FORGE_DWARF_WEAPON).setCollectItem(new ItemStack(Items.throwingAxeWindDwarven), 1, 4).setRewardFactor(4.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestCollect.QFCollect<>(COLLECT_DRINK).setCollectItem(new ItemStack(LOTRMod.mugDwarvenAle), 2, 5).setRewardFactor(3.0f));
		API.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction(KILL_GONDOR).setKillFaction(LOTRFaction.GONDOR, 20, 40));
		API.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction(KILL_ELF).setKillFaction(LOTRFaction.WOOD_ELF, 20, 40));
		API.addMiniQuest(windMountains, new LOTRMiniQuestKillFaction.QFKillFaction(KILL_DORWINION).setKillFaction(LOTRFaction.DORWINION, 20, 40));
		API.addMiniQuest(windMountains, new LOTRMiniQuestBounty.QFBounty<>(BOUNTY));
	}
}
