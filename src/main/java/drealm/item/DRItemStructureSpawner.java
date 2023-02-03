package drealm.item;

import java.util.List;

import cpw.mods.fml.relauncher.*;
import drealm.structure.DRStructure;
import lotr.common.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class DRItemStructureSpawner extends Item {
	public static int lastStructureSpawnTick;
	@SideOnly(value = Side.CLIENT)
	public IIcon iconBase;
	@SideOnly(value = Side.CLIENT)
	public IIcon iconOverlay;
	@SideOnly(value = Side.CLIENT)
	public IIcon iconVillageBase;
	@SideOnly(value = Side.CLIENT)
	public IIcon iconVillageOverlay;

	public DRItemStructureSpawner() {
		setHasSubtypes(true);
		setCreativeTab(LOTRCreativeTabs.tabSpawn);
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int pass) {
		DRStructure.StructureColorInfo info = DRStructure.structureItemSpawners.get(itemstack.getItemDamage());
		if (info != null) {
			if (pass == 0) {
				return info.colorBackground;
			}
			return info.colorForeground;
		}
		return 16777215;
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int i, int pass) {
		DRStructure.StructureColorInfo info = DRStructure.structureItemSpawners.get(i);
		if (info != null) {
			if (info.isVillage) {
				if (pass == 0) {
					return iconVillageBase;
				}
				return iconVillageOverlay;
			}
			if (pass == 0) {
				return iconBase;
			}
			return iconOverlay;
		}
		return iconBase;
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		StringBuilder s = new StringBuilder().append(("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim());
		String structureName = DRStructure.getNameFromID(itemstack.getItemDamage());
		if (structureName != null) {
			s.append(" ").append(StatCollector.translateToLocal("lotr.structure." + structureName + ".name"));
		}
		return s.toString();
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (DRStructure.StructureColorInfo info : DRStructure.structureItemSpawners.values()) {
			if (info.isHidden) {
				continue;
			}
			list.add(new ItemStack(item, 1, info.spawnedID));
		}
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int side, float f, float f1, float f2) {
		if (world.isRemote) {
			return true;
		}
		if (LOTRLevelData.structuresBanned()) {
			entityplayer.addChatMessage(new ChatComponentTranslation("chat.lotr.spawnStructure.disabled"));
			return false;
		}
		if (LOTRLevelData.isPlayerBannedForStructures(entityplayer)) {
			entityplayer.addChatMessage(new ChatComponentTranslation("chat.lotr.spawnStructure.banned"));
			return false;
		}
		if (lastStructureSpawnTick > 0) {
			entityplayer.addChatMessage(new ChatComponentTranslation("chat.lotr.spawnStructure.wait", lastStructureSpawnTick / 20.0));
			return false;
		}
		if (spawnStructure(entityplayer, world, itemstack.getItemDamage(), i += Facing.offsetsXForSide[side], j += Facing.offsetsYForSide[side], k += Facing.offsetsZForSide[side]) && !entityplayer.capabilities.isCreativeMode) {
			--itemstack.stackSize;
		}
		return true;
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public void registerIcons(IIconRegister iconregister) {
		iconBase = iconregister.registerIcon(getIconString() + "_base");
		iconOverlay = iconregister.registerIcon(getIconString() + "_overlay");
		iconVillageBase = iconregister.registerIcon(getIconString() + "_village_base");
		iconVillageOverlay = iconregister.registerIcon(getIconString() + "_village_overlay");
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	public static boolean spawnStructure(EntityPlayer entityplayer, World world, int id, int i, int j, int k) {
		if (!DRStructure.structureItemSpawners.containsKey(id)) {
			return false;
		}
		DRStructure.IStructureProvider strProvider = DRStructure.getStructureForID(id);
		if (strProvider != null) {
			boolean generated = strProvider.generateStructure(world, entityplayer, i, j, k);
			if (generated) {
				lastStructureSpawnTick = 20;
				world.playSoundAtEntity(entityplayer, "lotr:item.structureSpawner", 1.0f, 1.0f);
			}
			return generated;
		}
		return false;
	}
}
