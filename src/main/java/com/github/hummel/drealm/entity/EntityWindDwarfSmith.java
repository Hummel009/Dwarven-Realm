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

public class EntityWindDwarfSmith extends EntityWindDwarf implements LOTRTradeable.Smith {
	public EntityWindDwarfSmith(World world) {
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
		dropItem(Items.windDwarfSteel, 1 + rand.nextInt(3) + rand.nextInt(i + 1));
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return TradeEntries.windDwarfSmithBuy;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return TradeEntries.windDwarfSmithSell;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "windDwarf/smith/friendly";
			}
			return "windDwarf/smith/neutral";
		}
		return "windDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeWindDwarfSmith);
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