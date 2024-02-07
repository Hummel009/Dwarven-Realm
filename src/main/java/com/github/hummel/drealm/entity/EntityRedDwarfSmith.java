package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.init.TradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTradeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedDwarfSmith extends EntityRedDwarf implements LOTRTradeable.Smith {
	public EntityRedDwarfSmith(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendly(entityplayer);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		dropItem(Items.redDwarfSteel, 1 + rand.nextInt(3) + rand.nextInt(i + 1));
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return TradeEntries.redDwarfSmithBuy;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return TradeEntries.redDwarfSmithSell;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "redDwarf/smith/friendly";
			}
			return "redDwarf/smith/neutral";
		}
		return "redDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeRedDwarfSmith);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.blacksmithHammer));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return d;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}