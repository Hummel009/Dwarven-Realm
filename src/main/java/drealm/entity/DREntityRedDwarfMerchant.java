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

public class DREntityRedDwarfMerchant extends DREntityRedDwarf implements LOTRTravellingTrader {
	public DREntityRedDwarfMerchant(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendly(entityplayer);
	}

	@Override
	public LOTREntityNPC createTravellingEscort() {
		return new DREntityRedDwarf(worldObj);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return DRTradeEntries.redDwarfMerchantBuy;
	}

	@Override
	public String getDepartureSpeech() {
		return "redDwarf/merchant/departure";
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return DRTradeEntries.redDwarfMerchantSell;
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
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievements.tradeRedDwarfMerchant);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}