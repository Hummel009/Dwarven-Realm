package drealm.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class DRBiomeRedMountainsFoothills extends DRBiomeRedMountains {
	public DRBiomeRedMountainsFoothills(int i, boolean major) {
		super(i, major);
		decorator.biomeGemFactor = 1.0f;
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
	}
}
