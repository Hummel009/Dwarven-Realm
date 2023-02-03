package drealm.database;

import java.lang.reflect.*;

import drealm.util.DRReflectionHelper;
import lotr.common.item.LOTRMaterial;
import lotr.common.util.LOTRLog;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;

public class DRMaterial {
	public static LOTRMaterial RED_DWARVEN = DRMaterial.newLOTRMaterial("RED_DWARVEN", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
	public static LOTRMaterial WIND_DWARVEN = DRMaterial.newLOTRMaterial("WIND_DWARVEN", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
	private static boolean setup = false;
	private static Constructor<LOTRMaterial> constructor;
	private static Method setUses;
	private static Method setDamage;
	private static Method setProtection;
	private static Method setSpeed;
	private static Method setHarvestLevel;
	private static Method setEnchantibility;
	private static Method setCraftingMaterial;
	private static Method setUndamageable;
	private static Method setManFlesh;

	private static LOTRMaterial editLOTRMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		DRMaterial.setup();
		try {
			if (uses != -1) {
				setUses.invoke(material, uses);
			}
			if (damage != -1.0f) {
				setDamage.invoke(material, Float.valueOf(damage));
			}
			if (protection != -1.0f) {
				setProtection.invoke(material, Float.valueOf(protection));
			}
			if (speed != -1.0f) {
				setSpeed.invoke(material, Float.valueOf(speed));
			}
			if (harvestLevel != -1) {
				setHarvestLevel.invoke(material, harvestLevel);
			}
			if (enchantability != -1) {
				setEnchantibility.invoke(material, enchantability);
			}
			if (craftingMaterialTool != null && craftingMaterialArmor != null) {
				setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke(material);
			}
			if (manFlesh) {
				setManFlesh.invoke(material);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOTRLog.logger.error("Failed to edit LOTRMaterial " + material.toString(), e);
		}
		return material;
	}

	public static ItemArmor.ArmorMaterial getFullArmorMaterial(EntityLivingBase entity) {
		ItemArmor.ArmorMaterial material = null;
		for (int i = 1; i <= 4; ++i) {
			ItemStack item = entity.getEquipmentInSlot(i);
			if (item == null || !(item.getItem() instanceof ItemArmor)) {
				return null;
			}
			ItemArmor.ArmorMaterial itemMaterial = ((ItemArmor) item.getItem()).getArmorMaterial();
			if (material != null && itemMaterial != material) {
				return null;
			}
			material = itemMaterial;
		}
		return material;
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return DRMaterial.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return DRMaterial.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		DRMaterial.setup();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e) {
			LOTRLog.logger.error("Failed to create LOTRMaterial " + name, e);
		}
		return DRMaterial.editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	public static void onInit() {
		DRReflectionHelper.setMaterialCraftingItem(RED_DWARVEN, DRRegistry.red_dwarf_steel);
		DRReflectionHelper.setMaterialCraftingItem(WIND_DWARVEN, DRRegistry.wind_dwarf_steel);
	}

	private static void setup() {
		if (setup) {
			return;
		}
		try {
			Class<LOTRMaterial> clazz = LOTRMaterial.class;
			constructor = clazz.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			setUses = clazz.getDeclaredMethod("setUses", Integer.TYPE);
			setUses.setAccessible(true);
			setDamage = clazz.getDeclaredMethod("setDamage", Float.TYPE);
			setDamage.setAccessible(true);
			setProtection = clazz.getDeclaredMethod("setProtection", Float.TYPE);
			setProtection.setAccessible(true);
			setSpeed = clazz.getDeclaredMethod("setSpeed", Float.TYPE);
			setSpeed.setAccessible(true);
			setHarvestLevel = clazz.getDeclaredMethod("setHarvestLevel", Integer.TYPE);
			setHarvestLevel.setAccessible(true);
			setEnchantibility = clazz.getDeclaredMethod("setEnchantability", Integer.TYPE);
			setEnchantibility.setAccessible(true);
			setCraftingMaterial = clazz.getDeclaredMethod("setCraftingItems", Item.class, Item.class);
			setCraftingMaterial.setAccessible(true);
			setUndamageable = clazz.getDeclaredMethod("setUndamageable");
			setUndamageable.setAccessible(true);
			setManFlesh = clazz.getDeclaredMethod("setManFlesh");
			setManFlesh.setAccessible(true);
			setup = true;
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Failed to setup LOTRMaterials.", e);
		}
	}
}
