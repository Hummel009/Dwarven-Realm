package drealm.render;

import drealm.entity.DREntityRedDwarf;
import drealm.entity.DREntityWindDwarf;
import lotr.client.model.LOTRModelDwarf;
import lotr.client.render.entity.LOTRRandomSkins;
import lotr.client.render.entity.LOTRRenderBiped;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityBlueDwarf;
import lotr.common.entity.npc.LOTREntityDwarf;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DRRenderDwarf extends LOTRRenderBiped {
	private static final ResourceLocation RING_TEXTURE = new ResourceLocation("lotr:mob/dwarf/ring.png");

	private static final LOTRRandomSkins DWARF_SKINS_MALE = LOTRRandomSkins.loadSkinsList("lotr:mob/dwarf/dwarf_male");
	private static final LOTRRandomSkins DWARF_SKINS_FEMALE = LOTRRandomSkins.loadSkinsList("lotr:mob/dwarf/dwarf_female");
	private static final LOTRRandomSkins BLUE_DWARF_SKINS_MALE = LOTRRandomSkins.loadSkinsList("lotr:mob/dwarf/blueMountains_male");
	private static final LOTRRandomSkins BLUE_DWARF_SKINS_FEMALE = LOTRRandomSkins.loadSkinsList("lotr:mob/dwarf/blueMountains_female");
	private static final LOTRRandomSkins RED_DWARF_SKINS_MALE = LOTRRandomSkins.loadSkinsList("drealm:mob/dwarf/redMountains_male");
	private static final LOTRRandomSkins RED_DWARF_SKINS_FEMALE = LOTRRandomSkins.loadSkinsList("drealm:mob/dwarf/redMountains_female");
	private static final LOTRRandomSkins WIND_DWARF_SKINS_MALE = LOTRRandomSkins.loadSkinsList("drealm:mob/dwarf/windMountains_male");
	private static final LOTRRandomSkins WIND_DWARF_SKINS_FEMALE = LOTRRandomSkins.loadSkinsList("drealm:mob/dwarf/windMountains_female");

	protected ModelBiped standardRenderPassModel = new LOTRModelDwarf(0.5f, 64, 64);

	public DRRenderDwarf() {
		super(new LOTRModelDwarf(), 0.5f);
		setRenderPassModel(standardRenderPassModel);
	}

	@Override
	public void func_82421_b() {
		field_82423_g = new LOTRModelDwarf(1.0f);
		field_82425_h = new LOTRModelDwarf(0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		LOTREntityDwarf dwarf = (LOTREntityDwarf) entity;
		if (dwarf instanceof LOTREntityBlueDwarf) {
			if (dwarf.familyInfo.isMale()) {
				return BLUE_DWARF_SKINS_MALE.getRandomSkin(dwarf);
			}
			return BLUE_DWARF_SKINS_FEMALE.getRandomSkin(dwarf);
		}
		if (dwarf instanceof DREntityRedDwarf) {
			if (dwarf.familyInfo.isMale()) {
				return RED_DWARF_SKINS_MALE.getRandomSkin(dwarf);
			}
			return RED_DWARF_SKINS_FEMALE.getRandomSkin(dwarf);
		}
		if (dwarf instanceof DREntityWindDwarf) {
			if (dwarf.familyInfo.isMale()) {
				return WIND_DWARF_SKINS_MALE.getRandomSkin(dwarf);
			}
			return WIND_DWARF_SKINS_FEMALE.getRandomSkin(dwarf);
		}
		if (dwarf.familyInfo.isMale()) {
			return DWARF_SKINS_MALE.getRandomSkin(dwarf);
		}
		return DWARF_SKINS_FEMALE.getRandomSkin(dwarf);
	}

	@Override
	public float getHeldItemYTranslation() {
		return 0.125f;
	}

	@Override
	public void preRenderCallback(EntityLivingBase entity, float f) {
		super.preRenderCallback(entity, f);
		GL11.glScalef(0.8125f, 0.8125f, 0.8125f);
		if (LOTRMod.isAprilFools()) {
			GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		}
	}

	@Override
	public int shouldRenderPass(EntityLiving entity, int pass, float f) {
		LOTREntityDwarf dwarf = (LOTREntityDwarf) entity;
		if (pass == 1 && dwarf.getClass() == dwarf.familyInfo.marriageEntityClass && dwarf.getEquipmentInSlot(4) != null && dwarf.getEquipmentInSlot(4).getItem() == dwarf.familyInfo.marriageRing) {
			bindTexture(RING_TEXTURE);
			setRenderPassModel(standardRenderPassModel);
			((ModelBiped) renderPassModel).bipedRightArm.showModel = false;
			return 1;
		}
		return super.shouldRenderPass(entity, pass, f);
	}
}