package drealm.structure;

import drealm.content.DRBlocks;
import drealm.content.DRChestContents;
import drealm.entity.DREntityWindDwarfSmith;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class DRStructureWindMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public DRStructureWindMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = DRBlocks.brick;
		baseBrickMeta = 0;
		carvedBrickBlock = DRBlocks.brick;
		carvedBrickMeta = 1;
		pillarBlock = DRBlocks.pillar;
		pillarMeta = 0;
		tableBlock = DRBlocks.windDwarvenTable;
		barsBlock = DRBlocks.windDwarfBars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new DREntityWindDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return DRChestContents.windMountainsSmithy;
	}
}