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

public class DREntityWindDwarf extends LOTREntityDwarf {
	public DREntityWindDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = DREntityWindDwarf.class;
		familyInfo.marriageAchievement = DRAchievement.marry_wind_dwarf;
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuestFactory.WIND_MOUNTAINS.createQuest(this);
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuestFactory.WIND_MOUNTAINS;
	}

	@Override
	public LOTRFoods getDwarfFoods() {
		return DRFoods.WIND_DWARF;
	}

	@Override
	public Item getDwarfSteelDrop() {
		return DRRegistry.wind_dwarf_steel;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFaction.WIND_MOUNTAINS;
	}

	@Override
	public LOTRChestContents getGenericDrops() {
		return DRChestContents.WIND_MOUNTAINS_STRONGHOLD;
	}

	@Override
	public LOTRAchievement getKillAchievement() {
		return DRAchievement.kill_wind_dwarf;
	}

	@Override
	public LOTRChestContents getLarderDrops() {
		return DRChestContents.WIND_DWARF_HOUSE_LARDER;
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
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.dagger_wind_dwarven));
		npcItemsInv.setIdleItem(null);
		return data;
	}
}