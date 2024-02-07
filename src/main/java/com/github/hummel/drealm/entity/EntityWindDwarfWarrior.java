package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.init.Shields;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityWindDwarfWarrior extends EntityWindDwarf {
	public EntityWindDwarfWarrior(World world) {
		super(world);
		npcShield = Shields.alignmentWindMountains;
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
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.swordWindDwarven));
				break;
			case 1:
			case 2:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.battleaxeWindDwarven));
				break;
			case 3:
			case 4:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.hammerWindDwarven));
				break;
			case 5:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.mattockWindDwarven));
				break;
			case 6:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.pikeWindDwarven));
				break;
			default:
				break;
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(Items.spearWindDwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(Items.bootsWindDwarven));
		setCurrentItemOrArmor(2, new ItemStack(Items.legsWindDwarven));
		setCurrentItemOrArmor(3, new ItemStack(Items.bodyWindDwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(Items.helmetWindDwarven));
		}
		return d;
	}
}