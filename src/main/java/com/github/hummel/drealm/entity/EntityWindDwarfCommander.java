package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Invasions;
import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.init.UnitTradeEntries;
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

public class EntityWindDwarfCommander extends EntityWindDwarfWarrior implements LOTRUnitTradeable {
	public EntityWindDwarfCommander(World world) {
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
				return "windDwarf/commander/friendly";
			}
			return "windDwarf/commander/neutral";
		}
		return "windDwarf/dwarf/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return UnitTradeEntries.windDwarfCommander;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return Invasions.windMountains;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.hammerWindDwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(Items.bootsWindDwarven));
		setCurrentItemOrArmor(2, new ItemStack(Items.legsWindDwarven));
		setCurrentItemOrArmor(3, new ItemStack(Items.bodyWindDwarven));
		setCurrentItemOrArmor(4, null);
		return d;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeWindDwarfCommander);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}