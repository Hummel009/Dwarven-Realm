package drealm.entity;

import drealm.content.DRItems;
import drealm.content.DRShields;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfWarrior extends DREntityWindDwarf {
	public DREntityWindDwarfWarrior(World world) {
		super(world);
		npcShield = DRShields.alignmentWindMountains;
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
				npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.swordWindDwarven));
				break;
			case 1:
			case 2:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.battleaxeWindDwarven));
				break;
			case 3:
			case 4:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.hammerWindDwarven));
				break;
			case 5:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.mattockWindDwarven));
				break;
			case 6:
				npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.pikeWindDwarven));
				break;
			default:
				break;
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.spearWindDwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRItems.bootsWindDwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRItems.legsWindDwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRItems.bodyWindDwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(DRItems.helmetWindDwarven));
		}
		return d;
	}
}