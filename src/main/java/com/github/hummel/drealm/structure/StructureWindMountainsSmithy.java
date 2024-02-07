package com.github.hummel.drealm.structure;

import com.github.hummel.drealm.entity.EntityWindDwarfSmith;
import com.github.hummel.drealm.init.Blocks;
import com.github.hummel.drealm.init.ChestContents;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class StructureWindMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public StructureWindMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = Blocks.brick;
		baseBrickMeta = 0;
		carvedBrickBlock = Blocks.brick;
		carvedBrickMeta = 1;
		pillarBlock = Blocks.pillar;
		pillarMeta = 0;
		tableBlock = Blocks.windDwarvenTable;
		barsBlock = Blocks.windDwarfBars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new EntityWindDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return ChestContents.windMountainsSmithy;
	}
}