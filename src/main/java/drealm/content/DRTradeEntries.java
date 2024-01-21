package drealm.content;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.entity.npc.LOTRTradeEntry;
import lotr.common.entity.npc.LOTRTradeEntryBarrel;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DRTradeEntries {
	public static LOTRTradeEntries redDwarfMerchantBuy;
	public static LOTRTradeEntries redDwarfMerchantSell;
	public static LOTRTradeEntries redDwarfMinerBuy;
	public static LOTRTradeEntries redDwarfMinerSell;
	public static LOTRTradeEntries redDwarfSmithBuy;
	public static LOTRTradeEntries redDwarfSmithSell;
	public static LOTRTradeEntries windDwarfMerchantBuy;
	public static LOTRTradeEntries windDwarfMerchantSell;
	public static LOTRTradeEntries windDwarfMinerBuy;
	public static LOTRTradeEntries windDwarfMinerSell;
	public static LOTRTradeEntries windDwarfSmithBuy;
	public static LOTRTradeEntries windDwarfSmithSell;

	public static void onInit() {
		redDwarfMerchantBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenForge), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 16), new LOTRTradeEntry(new ItemStack(DRItems.swordRedDwarven), 16), new LOTRTradeEntry(new ItemStack(DRItems.spearRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.battleaxeRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.hammerRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.pikeRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.daggerRedDwarven), 13), new LOTRTradeEntry(new ItemStack(DRItems.axeRedDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeRedDwarven), 14), new LOTRTradeEntry(new ItemStack(DRItems.shovelRedDwarven), 12), new LOTRTradeEntry(new ItemStack(DRItems.mattockRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.throwingAxeRedDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.helmetRedDwarven), 25), new LOTRTradeEntry(new ItemStack(DRItems.bodyRedDwarven), 36), new LOTRTradeEntry(new ItemStack(DRItems.legsRedDwarven), 30), new LOTRTradeEntry(new ItemStack(DRItems.bootsRedDwarven), 22), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 9999), 9), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenTonic, 1, 9999), 14), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 2), 120), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 3), 160), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarfHerb), 10), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.brick3, 1, 12), 4), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
		redDwarfMerchantSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2));
		redDwarfMinerBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(Items.coal, 2), 4), new LOTRTradeEntry(new ItemStack(Blocks.iron_ore), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.oreCopper), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreTin), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreSilver), 12), new LOTRTradeEntry(new ItemStack(Blocks.gold_ore), 22), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 3), new LOTRTradeEntry(new ItemStack(Blocks.cobblestone, 8), 1), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 20), new LOTRTradeEntry(new ItemStack(Items.flint), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.sulfur), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.saltpeter), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
		redDwarfMinerSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.mugAle, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugMead, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugCider, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugPerry, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 32767), 12), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeRedDwarven), 10));
		redDwarfSmithBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(DRBlocks.redDwarvenTable), 100), new LOTRTradeEntry(new ItemStack(LOTRMod.blacksmithHammer), 18), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 20), new LOTRTradeEntry(new ItemStack(DRItems.swordRedDwarven), 16), new LOTRTradeEntry(new ItemStack(DRItems.spearRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.battleaxeRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.hammerRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.pikeRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.daggerRedDwarven), 13), new LOTRTradeEntry(new ItemStack(DRItems.axeRedDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeRedDwarven), 14), new LOTRTradeEntry(new ItemStack(DRItems.shovelRedDwarven), 12), new LOTRTradeEntry(new ItemStack(DRItems.mattockRedDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.throwingAxeRedDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.helmetRedDwarven), 25), new LOTRTradeEntry(new ItemStack(DRItems.bodyRedDwarven), 36), new LOTRTradeEntry(new ItemStack(DRItems.legsRedDwarven), 30), new LOTRTradeEntry(new ItemStack(DRItems.bootsRedDwarven), 22), new LOTRTradeEntry(new ItemStack(DRItems.boarArmorRedDwarven), 25), new LOTRTradeEntry(new ItemStack(DRBlocks.redDwarfBars, 8), 20));
		redDwarfSmithSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(DRItems.redDwarfSteel), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 3), 1), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(Items.string, 3), 1), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 16));
		windDwarfMerchantBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenForge), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 16), new LOTRTradeEntry(new ItemStack(DRItems.swordWindDwarven), 16), new LOTRTradeEntry(new ItemStack(DRItems.spearWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.battleaxeWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.hammerWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.pikeWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.daggerWindDwarven), 13), new LOTRTradeEntry(new ItemStack(DRItems.axeWindDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeWindDwarven), 14), new LOTRTradeEntry(new ItemStack(DRItems.shovelWindDwarven), 12), new LOTRTradeEntry(new ItemStack(DRItems.mattockWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.throwingAxeWindDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.helmetWindDwarven), 25), new LOTRTradeEntry(new ItemStack(DRItems.bodyWindDwarven), 36), new LOTRTradeEntry(new ItemStack(DRItems.legsWindDwarven), 30), new LOTRTradeEntry(new ItemStack(DRItems.bootsWindDwarven), 22), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 9999), 9), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenTonic, 1, 9999), 14), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 2), 120), new LOTRTradeEntryBarrel(new ItemStack(LOTRMod.mugDwarvenAle, 1, 3), 160), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarfHerb), 10), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.brick3, 1, 12), 4), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 4), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
		windDwarfMerchantSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2));
		windDwarfMinerBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(Items.coal, 2), 4), new LOTRTradeEntry(new ItemStack(Blocks.iron_ore), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.oreCopper), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreTin), 7), new LOTRTradeEntry(new ItemStack(LOTRMod.oreSilver), 12), new LOTRTradeEntry(new ItemStack(Blocks.gold_ore), 22), new LOTRTradeEntry(new ItemStack(Items.glowstone_dust, 4), 3), new LOTRTradeEntry(new ItemStack(Blocks.cobblestone, 8), 1), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 20), new LOTRTradeEntry(new ItemStack(Items.flint), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.sulfur), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.saltpeter), 6), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 40), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 20), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 12));
		windDwarfMinerSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(LOTRMod.mugAle, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugMead, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugCider, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugPerry, 1, 32767), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.mugDwarvenAle, 1, 32767), 12), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeWindDwarven), 10));
		windDwarfSmithBuy = new LOTRTradeEntries(LOTRTradeEntries.TradeType.BUY, new LOTRTradeEntry(new ItemStack(DRBlocks.windDwarvenTable), 100), new LOTRTradeEntry(new ItemStack(LOTRMod.blacksmithHammer), 18), new LOTRTradeEntry(new ItemStack(LOTRMod.dwarvenRing), 20), new LOTRTradeEntry(new ItemStack(DRItems.swordWindDwarven), 16), new LOTRTradeEntry(new ItemStack(DRItems.spearWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.battleaxeWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.hammerWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.pikeWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.daggerWindDwarven), 13), new LOTRTradeEntry(new ItemStack(DRItems.axeWindDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.pickaxeWindDwarven), 14), new LOTRTradeEntry(new ItemStack(DRItems.shovelWindDwarven), 12), new LOTRTradeEntry(new ItemStack(DRItems.mattockWindDwarven), 18), new LOTRTradeEntry(new ItemStack(DRItems.throwingAxeWindDwarven), 15), new LOTRTradeEntry(new ItemStack(DRItems.helmetWindDwarven), 25), new LOTRTradeEntry(new ItemStack(DRItems.bodyWindDwarven), 36), new LOTRTradeEntry(new ItemStack(DRItems.legsWindDwarven), 30), new LOTRTradeEntry(new ItemStack(DRItems.bootsWindDwarven), 22), new LOTRTradeEntry(new ItemStack(DRItems.boarArmorWindDwarven), 25), new LOTRTradeEntry(new ItemStack(DRBlocks.windDwarfBars, 8), 20));
		windDwarfSmithSell = new LOTRTradeEntries(LOTRTradeEntries.TradeType.SELL, new LOTRTradeEntry(new ItemStack(Items.iron_ingot), 3), new LOTRTradeEntry(new ItemStack(DRItems.windDwarfSteel), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rock, 8, 3), 1), new LOTRTradeEntry(new ItemStack(Items.coal, 2, 32767), 1), new LOTRTradeEntry(new ItemStack(Items.gold_ingot), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.copper), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.tin), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.bronze), 3), new LOTRTradeEntry(new ItemStack(Items.string, 3), 1), new LOTRTradeEntry(new ItemStack(LOTRMod.diamond), 25), new LOTRTradeEntry(new ItemStack(LOTRMod.emerald), 15), new LOTRTradeEntry(new ItemStack(LOTRMod.sapphire), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.ruby), 12), new LOTRTradeEntry(new ItemStack(LOTRMod.opal), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amber), 10), new LOTRTradeEntry(new ItemStack(LOTRMod.amethyst), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.topaz), 8), new LOTRTradeEntry(new ItemStack(LOTRMod.pearl), 25), new LOTRTradeEntry(new ItemStack(Items.cooked_beef), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_porkchop), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.muttonCooked), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_chicken), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.gammon), 3), new LOTRTradeEntry(new ItemStack(Items.cooked_fished), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.rabbitCooked), 3), new LOTRTradeEntry(new ItemStack(LOTRMod.deerCooked), 3), new LOTRTradeEntry(new ItemStack(Items.bread), 2), new LOTRTradeEntry(new ItemStack(Items.lava_bucket), 16));
	}
}
