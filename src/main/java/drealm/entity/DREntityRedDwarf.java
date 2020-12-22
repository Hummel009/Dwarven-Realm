package drealm.entity;

import drealm.database.*;
import lotr.common.*;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.*;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class DREntityRedDwarf extends LOTREntityDwarf {
	public DREntityRedDwarf(World world) {
		super(world);
		familyInfo.marriageEntityClass = DREntityRedDwarf.class;
		familyInfo.marriageAchievement = DRAchievement.marry_red_dwarf;
	}

	@Override
	protected LOTRFoods getDwarfFoods() {
		return DRFoods.RED_DWARF;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.dagger_red_dwarven));
		npcItemsInv.setIdleItem(null);
		return data;
	}

	@Override
	public LOTRFaction getFaction() {
		return DRFaction.RED_MOUNTAINS;
	}

	@Override
	protected Item getDwarfSteelDrop() {
		return DRRegistry.red_dwarf_steel;
	}

	@Override
	protected LOTRChestContents getLarderDrops() {
		return DRChestContents.RED_DWARF_HOUSE_LARDER;
	}

	@Override
	protected LOTRChestContents getGenericDrops() {
		return DRChestContents.RED_MOUNTAINS_STRONGHOLD;
	}

	@Override
	protected LOTRAchievement getKillAchievement() {
		return DRAchievement.kill_red_dwarf;
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "redDwarf/dwarf/hired";
			}
			return isChild() ? "redDwarf/child/friendly" : "redDwarf/dwarf/friendly";
		}
		return isChild() ? "redDwarf/child/hostile" : "redDwarf/dwarf/hostile";
	}

	@Override
	public LOTRMiniQuest createMiniQuest() {
		return DRMiniQuestFactory.RED_MOUNTAINS.createQuest(this);
	}

	@Override
	public LOTRMiniQuestFactory getBountyHelpSpeechDir() {
		return DRMiniQuestFactory.RED_MOUNTAINS;
	}
}
