package drealm.content;

import com.google.common.base.CaseFormat;
import cpw.mods.fml.common.registry.GameRegistry;
import drealm.item.DRItemArmor;
import drealm.item.DRItemStructureSpawner;
import drealm.util.DRConfig;
import lotr.common.block.LOTRBlockSlabBase;
import lotr.common.item.*;
import net.minecraft.item.Item;

import java.util.Collection;
import java.util.HashSet;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class DRItems {
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

	private DRItems() {
	}

	public static void preInit() {
		if (DRConfig.enableTextures14) {
			bodyRedDwarven = new DRItemArmor(DRMaterials.redDwarven14, 1);
			bodyWindDwarven = new DRItemArmor(DRMaterials.windDwarven14, 1);
			legsRedDwarven = new DRItemArmor(DRMaterials.redDwarven14, 2);
			legsWindDwarven = new DRItemArmor(DRMaterials.windDwarven14, 2);
			bootsRedDwarven = new DRItemArmor(DRMaterials.redDwarven14, 3);
			bootsWindDwarven = new DRItemArmor(DRMaterials.windDwarven14, 3);
			helmetRedDwarven = new DRItemArmor(DRMaterials.redDwarven14, 0);
			helmetWindDwarven = new DRItemArmor(DRMaterials.windDwarven14, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(DRMaterials.redDwarven14, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(DRMaterials.windDwarven14, LOTRItemMountArmor.Mount.BOAR);
		} else {
			bodyRedDwarven = new DRItemArmor(DRMaterials.redDwarven, 1);
			bodyWindDwarven = new DRItemArmor(DRMaterials.windDwarven, 1);
			legsRedDwarven = new DRItemArmor(DRMaterials.redDwarven, 2);
			legsWindDwarven = new DRItemArmor(DRMaterials.windDwarven, 2);
			bootsRedDwarven = new DRItemArmor(DRMaterials.redDwarven, 3);
			bootsWindDwarven = new DRItemArmor(DRMaterials.windDwarven, 3);
			helmetRedDwarven = new DRItemArmor(DRMaterials.redDwarven, 0);
			helmetWindDwarven = new DRItemArmor(DRMaterials.windDwarven, 0);
			boarArmorRedDwarven = new LOTRItemMountArmor(DRMaterials.redDwarven, LOTRItemMountArmor.Mount.BOAR);
			boarArmorWindDwarven = new LOTRItemMountArmor(DRMaterials.windDwarven, LOTRItemMountArmor.Mount.BOAR);
		}
		axeRedDwarven = new LOTRItemAxe(DRMaterials.redDwarven);
		axeWindDwarven = new LOTRItemAxe(DRMaterials.windDwarven);
		battleaxeRedDwarven = new LOTRItemBattleaxe(DRMaterials.redDwarven);
		battleaxeWindDwarven = new LOTRItemBattleaxe(DRMaterials.windDwarven);
		daggerRedDwarven = new LOTRItemDagger(DRMaterials.redDwarven);
		daggerRedDwarvenPoisoned = new LOTRItemDagger(DRMaterials.redDwarven, LOTRItemDagger.DaggerEffect.POISON);
		daggerWindDwarven = new LOTRItemDagger(DRMaterials.windDwarven);
		daggerWindDwarvenPoisoned = new LOTRItemDagger(DRMaterials.windDwarven, LOTRItemDagger.DaggerEffect.POISON);
		hammerRedDwarven = new LOTRItemHammer(DRMaterials.redDwarven);
		hammerWindDwarven = new LOTRItemHammer(DRMaterials.windDwarven);
		hoeRedDwarven = new LOTRItemHoe(DRMaterials.redDwarven);
		hoeWindDwarven = new LOTRItemHoe(DRMaterials.windDwarven);
		mattockRedDwarven = new LOTRItemMattock(DRMaterials.redDwarven);
		mattockWindDwarven = new LOTRItemMattock(DRMaterials.windDwarven);
		pickaxeRedDwarven = new LOTRItemPickaxe(DRMaterials.redDwarven);
		pickaxeWindDwarven = new LOTRItemPickaxe(DRMaterials.windDwarven);
		pikeRedDwarven = new LOTRItemPike(DRMaterials.redDwarven);
		pikeWindDwarven = new LOTRItemPike(DRMaterials.windDwarven);
		redDwarfSteel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);
		shovelRedDwarven = new LOTRItemShovel(DRMaterials.redDwarven);
		shovelWindDwarven = new LOTRItemShovel(DRMaterials.windDwarven);
		spearRedDwarven = new LOTRItemSpear(DRMaterials.redDwarven);
		spearWindDwarven = new LOTRItemSpear(DRMaterials.windDwarven);
		structureSpawner = new DRItemStructureSpawner();
		swordRedDwarven = new LOTRItemSword(DRMaterials.redDwarven);
		swordWindDwarven = new LOTRItemSword(DRMaterials.windDwarven);
		throwingAxeRedDwarven = new LOTRItemThrowingAxe(DRMaterials.redDwarven);
		throwingAxeWindDwarven = new LOTRItemThrowingAxe(DRMaterials.windDwarven);
		windDwarfSteel = new Item().setCreativeTab(DRCreativeTabs.tabMaterials);

		LOTRBlockSlabBase.registerSlabs(DRBlocks.slabSingle, DRBlocks.slabDouble);

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
		if (DRConfig.enableTextures14) {
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