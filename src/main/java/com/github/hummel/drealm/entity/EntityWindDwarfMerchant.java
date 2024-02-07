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

public class EntityWindDwarfMerchant extends EntityWindDwarf implements LOTRTravellingTrader {
	public EntityWindDwarfMerchant(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendly(entityplayer);
	}

	@Override
	public LOTREntityNPC createTravellingEscort() {
		return new EntityWindDwarf(worldObj);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return TradeEntries.windDwarfMerchantBuy;
	}

	@Override
	public String getDepartureSpeech() {
		return "windDwarf/merchant/departure";
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return TradeEntries.windDwarfMerchantSell;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			return "windDwarf/merchant/friendly";
		}
		return "windDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeWindDwarfMerchant);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}