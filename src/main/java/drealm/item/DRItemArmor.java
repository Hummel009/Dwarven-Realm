package drealm.item;

import drealm.util.DRAPI;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class DRItemArmor extends LOTRItemArmor {
	public DRItemArmor(LOTRMaterial material, int slotType) {
		super(material, slotType);
	}

	public DRItemArmor(LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("drealm:armor/").append(DRAPI.getArmorName(this));
		if (type != null) {
			texture.append('_').append(type);
		}
		return texture.append(".png").toString();
	}
}