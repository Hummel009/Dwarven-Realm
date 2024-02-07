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

public class EntityWindDwarf extends LOTREntityDwarf {
	public EntityWindDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = EntityWindDwarf.class;
		familyInfo.marriageAchievement = Achievements.marryWindDwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return MiniQuests.windMountains.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return MiniQuests.windMountains;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return Foods.windDwarf;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return Items.windDwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return Factions.windMountains;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return ChestContents.windMountainsStronghold;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return Achievements.killWindDwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return ChestContents.windDwarfHouseLarder;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "windDwarf/dwarf/hired";
			}
			return isChild() ? "windDwarf/child/friendly" : "windDwarf/dwarf/friendly";
		}
		return isChild() ? "windDwarf/child/hostile" : "windDwarf/dwarf/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.daggerWindDwarven));
		npcItemsInv.setIdleItem(null);
		return d;
	}
}