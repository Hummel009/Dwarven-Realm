package drealm.entity;

import drealm.content.DRItems;
import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import lotr.common.entity.npc.LOTREntityNPC;
import lotr.common.entity.projectile.LOTREntityFirePot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityRedDwarfFireThrower extends DREntityRedDwarfWarrior {
	private final EntityAIBase rangedAttackAI = createRedRangedAI();
	private EntityAIBase meleeAttackAI;

	public DREntityRedDwarfFireThrower(World world) {
		super(world);
		spawnRidingHorse = false;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
		EntityArrow template = new EntityArrow(worldObj, this, target, 1.0f, 0.5f);
		LOTREntityFirePot pot = new LOTREntityFirePot(worldObj, this);
		pot.setLocationAndAngles(template.posX, template.posY, template.posZ, template.rotationYaw, template.rotationPitch);
		pot.motionX = template.motionX;
		pot.motionY = template.motionY;
		pot.motionZ = template.motionZ;
		playSound("random.bow", 1.0f, 1.0f / (rand.nextFloat() * 0.4f + 0.8f));
		worldObj.spawnEntityInWorld(pot);
	}

	private EntityAIBase createRedRangedAI() {
		return new LOTREntityAIRangedAttack(this, 1.3, 20, 30, 16.0f);
	}

	@Override
	public EntityAIBase getDwarfAttackAI() {
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
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRItems.swordRedDwarven));
		npcItemsInv.setRangedWeapon(new ItemStack(LOTRMod.rhunFirePot));
		npcItemsInv.setIdleItem(npcItemsInv.getRangedWeapon());
		return d;
	}
}