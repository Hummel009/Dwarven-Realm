package drealm.entity;

import drealm.database.*;
import lotr.common.*;
import lotr.common.entity.npc.*;
import lotr.common.entity.npc.LOTRTradeEntries.TradeType;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfMiner extends DREntityWindDwarf implements LOTRTradeable {
	public static final LOTRTradeEntries WIND_DWARF_MINER_BUY = new LOTRTradeEntries(TradeType.BUY, new LOTRTradeEntry(new ItemStack(Items.coal, 2), 4), new LOTRTradeEntry(new ItemStack(Blocks.iron_ore), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.oreCopper), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreTin), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreSilver), 12), new LOTRTradeEntry(new ItemStack(Blocks.gold_ore), 22), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 3), new LOTRTradeEntry(new ItemStack(Blocks.cobblestone, 8), 1), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 20), new LOTRTradeEntry(new ItemStack(Items.flint), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.sulfur), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.saltpeter), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
	public static final LOTRTradeEntries WIND_DWARF_MINER_SELL = new LOTRTradeEntries(TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.mugAle, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugMead, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugCider, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugPerry, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 32767), 12), new LOTRTradeEntry(new ItemStack(DRRegistry.pickaxe_wind_dwarven), 10));

	public DREntityWindDwarfMiner(World world) {
		super(world);
	}

	@Override
	protected boolean canDwarfSpawnAboveGround() {
		return false;
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendly(entityplayer);
	}

	@Override
	protected void dropFewItems(boolean flag, int i) {
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
		return WIND_DWARF_MINER_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return WIND_DWARF_MINER_SELL;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendly(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "windDwarf/miner/friendly";
			}
			return "windDwarf/miner/neutral";
		}
		return "windDwarf/dwarf/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_wind_dwarf_miner);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.pickaxe_wind_dwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return data;
	}

	@Override
	public boolean shouldTraderRespawn() {
		return false;
	}
}
