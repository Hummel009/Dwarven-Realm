package drealm.entity;

import drealm.database.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRedDwarfWarrior extends DREntityRedDwarf {
	public DREntityRedDwarfWarrior(World world) {
		super(world);
		npcShield = DRShields.ALIGNMENT_RED_MOUNTAINS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(7);
		if (i == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.sword_red_dwarven));
		} else if (i == 1 || i == 2) {
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.battleaxe_red_dwarven));
		} else if (i == 3 || i == 4) {
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammer_red_dwarven));
		} else if (i == 5) {
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.mattock_red_dwarven));
		} else if (i == 6) {
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.pike_red_dwarven));
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.spear_red_dwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.boots_red_dwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legs_red_dwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.body_red_dwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(DRRegistry.helmet_red_dwarven));
		}
		return data;
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}
}
