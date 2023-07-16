package drealm.structure;

import drealm.database.DRChestContents;
import drealm.database.DRRegistry;
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
		tableBlock = DRRegistry.red_dwarven_table;
		barsBlock = DRRegistry.red_dwarf_bars;
	}

	@Override
	public LOTREntityDwarf createSmith(World world) {
		return new DREntityRedDwarfSmith(world);
	}

	@Override
	public LOTRChestContents getChestContents() {
		return DRChestContents.RED_MOUNTAINS_SMITHY;
	}
}