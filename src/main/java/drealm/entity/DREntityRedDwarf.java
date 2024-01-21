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

public class DREntityRedDwarf extends LOTREntityDwarf {
	public DREntityRedDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = DREntityRedDwarf.class;
		familyInfo.marriageAchievement = DRAchievements.marryRedDwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuests.redMountains.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuests.redMountains;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return DRFoods.redDwarf;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return DRItems.redDwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFactions.redMountains;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return DRChestContents.redMountainsStronghold;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return DRAchievements.killRedDwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return DRChestContents.redDwarfHouseLarder;
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
		npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.daggerRedDwarven));
		npcItemsInv.setIdleItem(null);
		return d;
	}
}