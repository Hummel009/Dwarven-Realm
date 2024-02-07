package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Achievements;
import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.init.TradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTradeable;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedDwarfMiner extends EntityRedDwarf implements LOTRTradeable {
	public EntityRedDwarfMiner(World world) {
		super(world);
	}

	@Override
	public boolean canDwarfSpawnAboveGround() {
		return false;
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendly(entityplayer);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		if (flag) {
			if (rand.nextInt(4) == 0) {
				dropChestContents(LOTRChestContents.DWARVEN_MINE_CORRIDOR, 1, 2 + i);
			}
			if (rand.nextInt(15) == 0) {
				entityDropItem(new ItemStack(LOTRMod.mithrilNugget), 0.0f);
			}
		}
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return TradeEntries.redDwarfMinerBuy;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return TradeEntries.redDwarfMinerSell;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "redDwarf/miner/friendly";
			}
			return "redDwarf/miner/neutral";
		}
		return "redDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(Achievements.tradeRedDwarfMiner);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.pickaxeRedDwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return d;
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}