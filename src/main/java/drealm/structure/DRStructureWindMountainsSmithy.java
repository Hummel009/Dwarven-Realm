package drealm.structure;

import drealm.database.DRChestContents;
import drealm.database.DRRegistry;
import drealm.entity.DREntityWindDwarfSmith;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class DRStructureWindMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public DRStructureWindMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = DRRegistry.brick;
		baseBrickMeta = 0;
		carvedBrickBlock = DRRegistry.brick;
		carvedBrickMeta = 1;
		pillarBlock = DRRegistry.pillar;
		pillarMeta = 0;
		tableBlock = DRRegistry.windDwarvenTable;
		barsBlock = DRRegistry.windDwarfBars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new DREntityWindDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return DRChestContents.WIND_MOUNTAINS_SMITHY;
	}
}