package drealm.entity;

import drealm.database.*;
import lotr.common.LOTRLevelData;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.animal.LOTREntityWildBoar;
import lotr.common.entity.npc.*;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DREntityWindDwarfCommander extends DREntityWindDwarfWarrior implements LOTRUnitTradeable {
	public static final LOTRUnitTradeEntries WIND_DWARF_COMMANDER = new LOTRUnitTradeEntries(200.0f, new LOTRUnitTradeEntry(DREntityWindDwarf.class, 20, 0.0f), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, 30, 50.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, 50, 100.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfWarrior.class, LOTREntityWildBoar.class, "WindDwarfWarrior_Boar", 50, 150.0f).setMountArmor(DRRegistry.boar_armor_wind_dwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfAxeThrower.class, LOTREntityWildBoar.class, "WindDwarfAxeThrower_Boar", 70, 200.0f).setMountArmor(DRRegistry.boar_armor_wind_dwarven).setPledgeExclusive(), new LOTRUnitTradeEntry(DREntityWindDwarfBannerBearer.class, 50, 200.0f).setPledgeExclusive());

	public DREntityWindDwarfCommander(World world) {
		super(world);
		this.addTargetTasks(false);
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
		if (isFriendly(entityplayer)) {
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
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(DRRegistry.hammer_wind_dwarven));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(DRRegistry.boots_wind_dwarven));
		setCurrentItemOrArmor(2, new ItemStack(DRRegistry.legs_wind_dwarven));
		setCurrentItemOrArmor(3, new ItemStack(DRRegistry.body_wind_dwarven));
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(DRAchievement.trade_wind_dwarf_commander);
	}

	@Override
	public boolean shouldTraderRespawn() {
		return true;
	}
}
