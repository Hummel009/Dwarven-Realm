package drealm.entity;

import drealm.database.DRAchievement;
import drealm.database.DRRegistry;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import lotr.common.entity.npc.LOTRTradeEntries.TradeType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRedDwarfMerchant extends DREntityRedDwarf implements LOTRTravellingTrader {
	public static final LOTRTradeEntries RED_DWARF_MERCHANT_BUY = new LOTRTradeEntries(TradeType.BUY, new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenForge), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 16), new LOTRTradeEntry(new ItemStack(DRRegistry.sword_red_dwarven), 16), new LOTRTradeEntry(new ItemStack(DRRegistry.spear_red_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.battleaxe_red_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.hammer_red_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.pike_red_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.dagger_red_dwarven), 13), new LOTRTradeEntry(new ItemStack(DRRegistry.axe_red_dwarven), 15), new LOTRTradeEntry(new ItemStack(DRRegistry.pickaxe_red_dwarven), 14), new LOTRTradeEntry(new ItemStack(DRRegistry.shovel_red_dwarven), 12), new LOTRTradeEntry(new ItemStack(DRRegistry.mattock_red_dwarven), 18), new LOTRTradeEntry(new ItemStack(DRRegistry.throwing_axe_red_dwarven), 15), new LOTRTradeEntry(new ItemStack(DRRegistry.helmet_red_dwarven), 25), new LOTRTradeEntry(new ItemStack(DRRegistry.body_red_dwarven), 36), new LOTRTradeEntry(new ItemStack(DRRegistry.legs_red_dwarven), 30), new LOTRTradeEntry(new ItemStack(DRRegistry.boots_red_dwarven), 22), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 9999), 9), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenTonic, 1, 9999), 14), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 2), 120), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 3), 160), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarfHerb), 10), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.brick3, 1, 12), 4), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
	public static final LOTRTradeEntries RED_DWARF_MERCHANT_SELL = new LOTRTradeEntries(TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2));

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
		return RED_DWARF_MERCHANT_BUY;
	}

	@Override
	public String getDepartureSpeech() {
		return "redDwarf/merchant/departure";
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return RED_DWARF_MERCHANT_SELL;
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
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_red_dwarf_merchant);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}