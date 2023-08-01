package drealm.entity;

import drealm.database.*;
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
		familyInfo.marriageAchievement = DRAchievement.marryRedDwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuestFactory.RED_MOUNTAINS.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuestFactory.RED_MOUNTAINS;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return DRFoods.RED_DWARF;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return DRRegistry.redDwarfSteel;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFaction.RED_MOUNTAINS;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return DRChestContents.RED_MOUNTAINS_STRONGHOLD;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return DRAchievement.killRedDwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return DRChestContents.RED_DWARF_HOUSE_LARDER;
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
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.daggerRedDwarven));
		npcItemsInv.setIdleItem(null);
		return data;
	}
}