package com.github.hummel.drealm.init;

import com.github.hummel.drealm.Config;
import com.github.hummel.drealm.item.ItemArmor;
import com.github.hummel.drealm.item.ItemStructureSpawner;
import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import lotr.common.block.LOTRBlockSlabBase;
import lotr.common.item.*;
import net.minecraft.item.Item;

import java.util.Collection;
import java.util.HashSet;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Items {
	public static final Collection<Item> CONTENT = new HashSet<>();

	public static Item axeRedDwarven;
	public static Item axeWindDwarven;
	public static Item battleaxeRedDwarven;
	public static Item battleaxeWindDwarven;
	public static Item boarArmorRedDwarven;
	public static Item boarArmorWindDwarven;
	public static Item bodyRedDwarven;
	public static Item bodyWindDwarven;
	public static Item bootsRedDwarven;
	public static Item bootsWindDwarven;
	public static Item daggerRedDwarven;
	public static Item daggerRedDwarvenPoisoned;
	public static Item daggerWindDwarven;
	public static Item daggerWindDwarvenPoisoned;
	public static Item hammerRedDwarven;
	public static Item hammerWindDwarven;
	public static Item helmetRedDwarven;
	public static Item helmetWindDwarven;
	public static Item hoeRedDwarven;
	public static Item hoeWindDwarven;
	public static Item legsRedDwarven;
	public static Item legsWindDwarven;
	public static Item mattockRedDwarven;
	public static Item mattockWindDwarven;
	public static Item pickaxeRedDwarven;
	public static Item pickaxeWindDwarven;
	public static Item pikeRedDwarven;
	public static Item pikeWindDwarven;
	public static Item redDwarfSteel;
	public static Item shovelRedDwarven;
	public static Item shovelWindDwarven;
	public static Item spearRedDwarven;
	public static Item spearWindDwarven;
	public static Item structureSpawner;
	public static Item swordRedDwarven;
	public static Item swordWindDwarven;
	public static Item throwingAxeRedDwarven;
	public static Item throwingAxeWindDwarven;
	public static Item windDwarfSteel;

	private Items() {
	}

	public static void preInit() {
		if (Config.enableTextures14) {
			bodyRedDwarven = new ItemArmor(Materials.redDwarven14, 1);
			bodyWindDwarven = new ItemArmor(Materials.windDwarven14, 1);
			legsRedDwarven = new ItemArmor(Materials.redDwarven14, 2);
			legsWindDwarven = new ItemArmor(Materials.windDwarven14, 2);
			bootsRedDwarven = new ItemArmor(Materials.redDwarven14, 3);
			bootsWindDwarven = new ItemArmor(Materials.windDwarven14, 3);
			helmetRedDwarven = new ItemArmor(Materials.redDwarven14, 0);
			helmetWindDwarven = new ItemArmor(Materials.windDwarven14, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(Materials.redDwarven14, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(Materials.windDwarven14, LOTRItemMountArmor.Mount.BOAR);
		} else {
			bodyRedDwarven = new ItemArmor(Materials.redDwarven, 1);
			bodyWindDwarven = new ItemArmor(Materials.windDwarven, 1);
			legsRedDwarven = new ItemArmor(Materials.redDwarven, 2);
			legsWindDwarven = new ItemArmor(Materials.windDwarven, 2);
			bootsRedDwarven = new ItemArmor(Materials.redDwarven, 3);
			bootsWindDwarven = new ItemArmor(Materials.windDwarven, 3);
			helmetRedDwarven = new ItemArmor(Materials.redDwarven, 0);
			helmetWindDwarven = new ItemArmor(Materials.windDwarven, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(Materials.redDwarven, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(Materials.windDwarven, LOTRItemMountArmor.Mount.BOAR);
		}
		axeRedDwarven = new LOTRItemAxe(Materials.redDwarven);
		axeWindDwarven = new LOTRItemAxe(Materials.windDwarven);
		battleaxeRedDwarven = new LOTRItemBattleaxe(Materials.redDwarven);
		battleaxeWindDwarven = new LOTRItemBattleaxe(Materials.windDwarven);
		daggerRedDwarven = new LOTRItemDagger(Materials.redDwarven);
		daggerRedDwarvenPoisoned = new LOTRItemDagger(Materials.redDwarven, LOTRItemDagger.DaggerEffect.POISON);
		daggerWindDwarven = new LOTRItemDagger(Materials.windDwarven);
		daggerWindDwarvenPoisoned = new LOTRItemDagger(Materials.windDwarven, LOTRItemDagger.DaggerEffect.POISON);
		hammerRedDwarven = new LOTRItemHammer(Materials.redDwarven);
		hammerWindDwarven = new LOTRItemHammer(Materials.windDwarven);
		hoeRedDwarven = new LOTRItemHoe(Materials.redDwarven);
		hoeWindDwarven = new LOTRItemHoe(Materials.windDwarven);
		mattockRedDwarven = new LOTRItemMattock(Materials.redDwarven);
		mattockWindDwarven = new LOTRItemMattock(Materials.windDwarven);
		pickaxeRedDwarven = new LOTRItemPickaxe(Materials.redDwarven);
		pickaxeWindDwarven = new LOTRItemPickaxe(Materials.windDwarven);
		pikeRedDwarven = new LOTRItemPike(Materials.redDwarven);
		pikeWindDwarven = new LOTRItemPike(Materials.windDwarven);
		redDwarfSteel = new Item().setCreativeTab(CreativeTabs.tabMaterials);
		shovelRedDwarven = new LOTRItemShovel(Materials.redDwarven);
		shovelWindDwarven = new LOTRItemShovel(Materials.windDwarven);
		spearRedDwarven = new LOTRItemSpear(Materials.redDwarven);
		spearWindDwarven = new LOTRItemSpear(Materials.windDwarven);
		structureSpawner = new ItemStructureSpawner();
		swordRedDwarven = new LOTRItemSword(Materials.redDwarven);
		swordWindDwarven = new LOTRItemSword(Materials.windDwarven);
		throwingAxeRedDwarven = new LOTRItemThrowingAxe(Materials.redDwarven);
		throwingAxeWindDwarven = new LOTRItemThrowingAxe(Materials.windDwarven);
		windDwarfSteel = new Item().setCreativeTab(CreativeTabs.tabMaterials);

		LOTRBlockSlabBase.registerSlabs(Blocks.slabSingle, Blocks.slabDouble);

		registerItem(redDwarfSteel, "redDwarfSteel");
		registerItem(windDwarfSteel, "windDwarfSteel");
		registerItem(helmetRedDwarven, "helmetRedDwarven");
		registerItem(bodyRedDwarven, "bodyRedDwarven");
		registerItem(legsRedDwarven, "legsRedDwarven");
		registerItem(bootsRedDwarven, "bootsRedDwarven");
		registerItem(helmetWindDwarven, "helmetWindDwarven");
		registerItem(bodyWindDwarven, "bodyWindDwarven");
		registerItem(legsWindDwarven, "legsWindDwarven");
		registerItem(bootsWindDwarven, "bootsWindDwarven");
		registerItem(shovelRedDwarven, "shovelRedDwarven");
		registerItem(pickaxeRedDwarven, "pickaxeRedDwarven");
		registerItem(axeRedDwarven, "axeRedDwarven");
		registerItem(swordRedDwarven, "swordRedDwarven");
		registerItem(hoeRedDwarven, "hoeRedDwarven");
		registerItem(daggerRedDwarven, "daggerRedDwarven");
		registerItem(daggerRedDwarvenPoisoned, "daggerRedDwarvenPoisoned");
		registerItem(battleaxeRedDwarven, "battleaxeRedDwarven");
		registerItem(hammerRedDwarven, "hammerRedDwarven");
		registerItem(mattockRedDwarven, "mattockRedDwarven");
		registerItem(throwingAxeRedDwarven, "throwingAxeRedDwarven");
		registerItem(spearRedDwarven, "spearRedDwarven");
		registerItem(boarArmorRedDwarven, "boarArmorRedDwarven");
		registerItem(pikeRedDwarven, "pikeRedDwarven");
		registerItem(shovelWindDwarven, "shovelWindDwarven");
		registerItem(pickaxeWindDwarven, "pickaxeWindDwarven");
		registerItem(axeWindDwarven, "axeWindDwarven");
		registerItem(swordWindDwarven, "swordWindDwarven");
		registerItem(hoeWindDwarven, "hoeWindDwarven");
		registerItem(daggerWindDwarven, "daggerWindDwarven");
		registerItem(daggerWindDwarvenPoisoned, "daggerWindDwarvenPoisoned");
		registerItem(battleaxeWindDwarven, "battleaxeWindDwarven");
		registerItem(hammerWindDwarven, "hammerWindDwarven");
		registerItem(mattockWindDwarven, "mattockWindDwarven");
		registerItem(throwingAxeWindDwarven, "throwingAxeWindDwarven");
		registerItem(spearWindDwarven, "spearWindDwarven");
		registerItem(boarArmorWindDwarven, "boarArmorWindDwarven");
		registerItem(pikeWindDwarven, "pikeWindDwarven");
		registerItemLOTR(structureSpawner, "structureSpawner");
	}

	private static void registerItem(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		String prefix = "drealm:";
		item.setUnlocalizedName(itemName);
		if (Config.enableTextures14) {
			item.setTextureName(prefix + itemName + "14");
		} else {
			item.setTextureName(prefix + itemName);
		}
		GameRegistry.registerItem(item, itemName);
		CONTENT.add(item);
	}

	private static void registerItemLOTR(Item item, String name) {
		String prefix = "lotr:";
		item.setTextureName(prefix + name);
		item.setUnlocalizedName(prefix + name);
		GameRegistry.registerItem(item, name);
		CONTENT.add(item);
	}
}