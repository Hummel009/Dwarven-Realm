package drealm.entity;

import drealm.database.DRRegistry;
import drealm.database.DRShields;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRedDwarfWarrior extends DREntityRedDwarf {
	public DREntityRedDwarfWarrior(World world) {
		super(world);
		npcShield = DRShields.ALIGNMENT_RED_MOUNTAINS;
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		int i = rand.nextInt(7);
		switch (i) {
			case 0:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.swordRedDwarven));
				break;
			case 1:
			case 2:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.battleaxeRedDwarven));
				break;
			case 3:
			case 4:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammerRedDwarven));
				break;
			case 5:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.mattockRedDwarven));
				break;
			case 6:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.pikeRedDwarven));
				break;
			default:
				break;
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.spearRedDwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.bootsRedDwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legsRedDwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.bodyRedDwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(DRRegistry.helmetRedDwarven));
		}
		return d;
	}
}