package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.TradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTravellingTrader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedDwarfMerchant extends EntityRedDwarf implements LOTRTravellingTrader {
	public EntityRedDwarfMerchant(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendly(entityplayer);
	}

	@Override
	public LOTREntityNPC createTravellingEscort() {
		return new EntityRedDwarf(worldObj);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return TradeEntries.redDwarfMerchantBuy;
	}

	@Override
	public String getDepartureSpeech() {
		return "redDwarf/merchant/departure";
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return TradeEntries.redDwarfMerchantSell;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			return "redDwarf/merchant/friendly";
		}
		return "redDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeRedDwarfMerchant);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}