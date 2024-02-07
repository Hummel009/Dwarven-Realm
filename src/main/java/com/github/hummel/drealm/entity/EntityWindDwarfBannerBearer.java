package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.BannerTypes;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class EntityWindDwarfBannerBearer extends EntityWindDwarfWarrior implements LOTRBannerBearer {
	public EntityWindDwarfBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return BannerTypes.windMountains;
	}
}