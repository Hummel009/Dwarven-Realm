package drealm.entity;

import drealm.database.DRAchievement;
import drealm.database.DRInvasions;
import drealm.database.DRRegistry;
import lotr.common.LOTRLevelData;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.LOTRUnitTradeEntries;
import lotr.common.entity.npc.LOTRUnitTradeEntry;
import lotr.common.entity.npc.LOTRUnitTradeable;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfCommander extends DREntityWindDwarfWarrior implements LOTRUnitTradeable {
	public static final LOTRUnitTradeEntries WIND_DWARF_COMMANDER = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityWindDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, 30, 50.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfCrossbower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, LOTREntityWildBoar.class, "WindDwarfWarrior_Boar", 50, 150.0f).setMountArmor(DRRegistry.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, LOTREntityWildBoar.class, "WindDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(DRRegistry.boarArmorWindDwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfBannerBearer.class, 50, 200.0f).setPledgeExclusive());

	public DREntityWindDwarfCommander(World world) {
		super(world);
		addTargetTasks(false);
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 200.0f && isFriendly(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public EntityAIBase getDwarfAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, false);
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "windDwarf/commander/friendly";
			}
			return "windDwarf/commander/neutral";
		}
		return "windDwarf/dwarf/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return WIND_DWARF_COMMANDER;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return DRInvasions.WIND_MOUNTAINS;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		IEntityLivingData d = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammerWindDwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.bootsWindDwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legsWindDwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.bodyWindDwarven));
		setCurrentItemOrArmor(4, null);
		return d;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.tradeWindDwarfCommander);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}