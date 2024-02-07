package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.*;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRFoods;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedDwarf extends LOTREntityDwarf {
	public EntityRedDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = EntityRedDwarf.class;
		familyInfo.marriageAchievement = Achievements.marryRedDwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return MiniQuests.redMountains.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return MiniQuests.redMountains;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return Foods.redDwarf;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return Items.redDwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return Factions.redMountains;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return ChestContents.redMountainsStronghold;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return Achievements.killRedDwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return ChestContents.redDwarfHouseLarder;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "redDwarf/dwarf/hired";
			}
			return isChild() ? "redDwarf/child/friendly" : "redDwarf/dwarf/friendly";
		}
		return isChild() ? "redDwarf/child/hostile" : "redDwarf/dwarf/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.daggerRedDwarven));
		npcItemsInv.setIdleItem(null);
		return d;
	}
}