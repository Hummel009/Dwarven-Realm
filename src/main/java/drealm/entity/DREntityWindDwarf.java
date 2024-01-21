package drealm.entity;

import drealm.content.*;
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

public class DREntityWindDwarf extends LOTREntityDwarf {
	public DREntityWindDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = DREntityWindDwarf.class;
		familyInfo.marriageAchievement = DRAchievements.marryWindDwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuests.windMountains.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuests.windMountains;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return DRFoods.windDwarf;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return DRItems.windDwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFactions.windMountains;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return DRChestContents.windMountainsStronghold;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return DRAchievements.killWindDwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return DRChestContents.windDwarfHouseLarder;
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
		npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.daggerWindDwarven));
		npcItemsInv.setIdleItem(null);
		return d;
	}
}