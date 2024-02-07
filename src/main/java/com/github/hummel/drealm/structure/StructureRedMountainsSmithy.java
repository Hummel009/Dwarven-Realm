package com.github.hummel.drealm.structure;

import com.github.hummel.drealm.entity.EntityRedDwarfSmith;
import com.github.hummel.drealm.init.Blocks;
import com.github.hummel.drealm.init.ChestContents;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityDwarf;
import lotr.common.world.structure.LOTRChestContents;
import lotr.common.world.structure2.LOTRWorldGenDwarfSmithy;
import net.minecraft.world.World;

public class StructureRedMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public StructureRedMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = LOTRMod.brick2;
		baseBrickMeta = 2;
		carvedBrickBlock = LOTRMod.brick2;
		carvedBrickMeta = 2;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 4;
		tableBlock = Blocks.redDwarvenTable;
		barsBlock = Blocks.redDwarfBars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new EntityRedDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return ChestContents.redMountainsSmithy;
	}
}