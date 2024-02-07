package com.github.hummel.drealm.entity;

import com.github.hummel.drealm.init.Items;
import com.github.hummel.drealm.init.Shields;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedDwarfWarrior extends EntityRedDwarf {
	public EntityRedDwarfWarrior(World world) {
		super(world);
		npcShield = Shields.alignmentRedMountains;
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
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.swordRedDwarven));
				break;
			case 1:
			case 2:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.battleaxeRedDwarven));
				break;
			case 3:
			case 4:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.hammerRedDwarven));
				break;
			case 5:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.mattockRedDwarven));
				break;
			case 6:
				npcItemsInv.setMeleeWeapon(new ItemStack(Items.pikeRedDwarven));
				break;
			default:
				break;
		}
		if (rand.nextInt(6) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(Items.spearRedDwarven));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(Items.bootsRedDwarven));
		setCurrentItemOrArmor(2, new ItemStack(Items.legsRedDwarven));
		setCurrentItemOrArmor(3, new ItemStack(Items.bodyRedDwarven));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(Items.helmetRedDwarven));
		}
		return d;
	}
}