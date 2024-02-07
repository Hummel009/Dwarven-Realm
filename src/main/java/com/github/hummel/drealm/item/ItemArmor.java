package com.github.hummel.drealm.item;

import com.github.hummel.drealm.util.ReflectionHelper;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemArmor extends LOTRItemArmor {
	public ItemArmor(LOTRMaterial material, int slotType) {
		super(material, slotType);
	}

	public ItemArmor(LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("drealm:armor/").append(ReflectionHelper.getArmorName(this));
		if (type != null) {
			texture.append('_').append(type);
		}
		return texture.append(".png").toString();
	}
}