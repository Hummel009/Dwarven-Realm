package drealm.entity;

import drealm.item.DRItemBanner;
import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class DREntityWindDwarfBannerBearer extends DREntityWindDwarfWarrior implements LOTRBannerBearer {
	public DREntityWindDwarfBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return DRItemBanner.windMountains;
	}
}