package drealm.entity;

import drealm.database.DRRegistry;
import drealm.database.DRShields;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfWarrior extends DREntityWindDwarf {
	public DREntityWindDwarfWarrior(World world) {
		super(world);
		npcShield = DRShields.ALIGNMENT_WIND_MOUNTAINS;
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(7);
		switch (i) {
			case 0:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.sword_wind_dwarven));
				break;
			case 1:
			case 2:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.battleaxe_wind_dwarven));
				break;
			case 3:
			case 4:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammer_wind_dwarven));
				break;
			case 5:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.mattock_wind_dwarven));
				break;
			case 6:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.pike_wind_dwarven));
				break;
			default:
				break;
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.spear_wind_dwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.boots_wind_dwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legs_wind_dwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.body_wind_dwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(DRRegistry.helmet_wind_dwarven));
		}
		return data;
	}
}