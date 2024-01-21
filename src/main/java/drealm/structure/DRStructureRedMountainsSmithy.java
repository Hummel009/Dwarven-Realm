package drealm.structure;

import drealm.content.DRBlocks;
import drealm.content.DRChestContents;
import drealm.entity.DREntityRedDwarfSmith;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class DRStructureRedMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public DRStructureRedMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = LOTRMod.brick2;
		baseBrickMeta = 2;
		carvedBrickBlock = LOTRMod.brick2;
		carvedBrickMeta = 2;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 4;
		tableBlock = DRBlocks.redDwarvenTable;
		barsBlock = DRBlocks.redDwarfBars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new DREntityRedDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return DRChestContents.redMountainsSmithy;
	}
}