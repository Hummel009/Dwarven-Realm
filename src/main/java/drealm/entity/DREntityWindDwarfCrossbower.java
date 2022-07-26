package drealm.entity;

import drealm.database.DRRegistry;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import lotr.common.entity.npc.LOTREntityNPC;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfCrossbower extends DREntityWindDwarfWarrior {
	public EntityAIBase rangedAttackAI = createRedRangedAI();
	public EntityAIBase meleeAttackAI;

	public DREntityWindDwarfCrossbower(World world) {
		super(world);
		spawnRidingHorse = false;
	}

	protected EntityAIBase createRedRangedAI() {
		return new LOTREntityAIRangedAttack(this, 1.3, 20, 30, 16.0f);
	}

	@Override
	protected EntityAIBase getDwarfAttackAI() {
		meleeAttackAI = super.getDwarfAttackAI();
		return meleeAttackAI;
	}

	@Override
	public double getMeleeRange() {
		EntityLivingBase target = getAttackTarget();
		if (target != null && target.isBurning()) {
			return Double.MAX_VALUE;
		}
		return super.getMeleeRange();
	}

	@Override
	public void onAttackModeChange(LOTREntityNPC.AttackMode mode, boolean mounted) {
		if (mode == LOTREntityNPC.AttackMode.IDLE) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getIdleItem());
		}
		if (mode == LOTREntityNPC.AttackMode.MELEE) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			tasks.addTask(2, meleeAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getMeleeWeapon());
		}
		if (mode == LOTREntityNPC.AttackMode.RANGED) {
			tasks.removeTask(meleeAttackAI);
			tasks.removeTask(rangedAttackAI);
			tasks.addTask(2, rangedAttackAI);
			setCurrentItemOrArmor(0, npcItemsInv.getRangedWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.sword_wind_dwarven));
		npcItemsInv.setRangedWeapon(new ItemStack(LOTRMod.ironCrossbow));
		npcItemsInv.setIdleItem(npcItemsInv.getRangedWeapon());
		return data;
	}
}
