package com.github.hummel.drealm.init;

import com.github.hummel.drealm.api.API;
import lotr.common.item.LOTRMaterial;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Materials {
	public static LOTRMaterial redDwarven;
	public static LOTRMaterial windDwarven;
	public static LOTRMaterial redDwarven14;
	public static LOTRMaterial windDwarven14;

	private Materials() {
	}

	public static void preInit() {
		redDwarven = API.addLotrMaterial("RED_DWARVEN", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
		windDwarven = API.addLotrMaterial("WIND_DWARVEN", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
		redDwarven14 = API.addLotrMaterial("RED_DWARVEN14", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
		windDwarven14 = API.addLotrMaterial("WIND_DWARVEN14", 650, 3.0f, 0.7f, 7.0f, 3, 12, null);
	}

	public static void onInit() {
		API.setMaterialCraftingItem(redDwarven, Items.redDwarfSteel);
		API.setMaterialCraftingItem(windDwarven, Items.windDwarfSteel);
		API.setMaterialCraftingItem(redDwarven14, Items.redDwarfSteel);
		API.setMaterialCraftingItem(windDwarven14, Items.windDwarfSteel);
	}
}