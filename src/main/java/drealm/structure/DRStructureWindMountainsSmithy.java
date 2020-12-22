package drealm.structure;

import drealm.database.*;
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
		tableBlock = DRRegistry.wind_dwarven_table;
		barsBlock = DRRegistry.wind_dwarf_bars;
	}

	@Override
	protected LOTREntityDwarf createSmith(World world) {
		return new DREntityWindDwarfSmith(world);
	}

	@Override
	protected LOTRChestContents getChestContents() {
		return DRChestContents.WIND_MOUNTAINS_SMITHY;
	}
}
