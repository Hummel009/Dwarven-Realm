package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.BannerTypes;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class EntityRedDwarfBannerBearer extends EntityRedDwarfWarrior implements LOTRBannerBearer {
	public EntityRedDwarfBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return BannerTypes.redMountains;
	}
}