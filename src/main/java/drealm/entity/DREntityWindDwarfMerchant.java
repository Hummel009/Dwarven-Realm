package drealm.entity;

import drealm.content.DRAchievements;
import drealm.content.DRTradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTravellingTrader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfMerchant extends DREntityWindDwarf implements LOTRTravellingTrader {
	public DREntityWindDwarfMerchant(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendly(entityplayer);
	}

	@Override
	public LOTREntityNPC createTravellingEscort() {
		return new DREntityWindDwarf(worldObj);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return DRTradeEntries.windDwarfMerchantBuy;
	}

	@Override
	public String getDepartureSpeech() {
		return "windDwarf/merchant/departure";
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return DRTradeEntries.windDwarfMerchantSell;
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
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievements.tradeWindDwarfMerchant);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}