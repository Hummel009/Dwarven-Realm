package drealm.entity;

import drealm.content.DRAchievements;
import drealm.content.DRInvasions;
import drealm.content.DRItems;
import drealm.content.DRUnitTradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRedDwarfCommander extends DREntityRedDwarfWarrior implements LOTRUnitTradeable {
	public DREntityRedDwarfCommander(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 200.0f && isFriendly(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public EntityAIBase getDwarfAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, false);
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "redDwarf/commander/friendly";
			}
			return "redDwarf/commander/neutral";
		}
		return "redDwarf/dwarf/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return DRUnitTradeEntries.redDwarfCommander;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return DRInvasions.redMountains;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.hammerRedDwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRItems.bootsRedDwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRItems.legsRedDwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRItems.bodyRedDwarven));
		setCurrentItemOrArmor(4, null);
		return d;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievements.tradeRedDwarfCommander);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}