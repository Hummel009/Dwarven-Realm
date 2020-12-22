package drealm.render;

import lotr.client.model.LOTRModelDwarf;
import lotr.common.entity.npc.LOTREntityBlueDwarf;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;

public class DRRenderDwarfCommander extends DRRenderDwarf {
	private static ResourceLocation cloak = new ResourceLocation("lotr:mob/dwarf/commander_cloak.png");
	private static ResourceLocation blueCloak = new ResourceLocation("lotr:mob/dwarf/blueMountains_commander_cloak.png");
	private LOTRModelDwarf cloakModel = new LOTRModelDwarf(1.5f);

	protected ResourceLocation getCloakTexture(EntityLivingBase entity) {
		return entity instanceof LOTREntityBlueDwarf ? blueCloak : cloak;
	}

	@Override
	public int shouldRenderPass(EntityLiving entity, int pass, float f) {
		if (pass == 0) {
			bindTexture(getCloakTexture(entity));
			cloakModel.bipedHead.showModel = false;
			cloakModel.bipedHeadwear.showModel = false;
			cloakModel.bipedBody.showModel = true;
			cloakModel.bipedRightArm.showModel = true;
			cloakModel.bipedLeftArm.showModel = true;
			cloakModel.bipedRightLeg.showModel = false;
			cloakModel.bipedLeftLeg.showModel = false;
			setRenderPassModel(cloakModel);
			cloakModel.onGround = mainModel.onGround;
			cloakModel.isRiding = mainModel.isRiding;
			cloakModel.isChild = mainModel.isChild;
			cloakModel.heldItemRight = modelBipedMain.heldItemRight;
			return 1;
		}
		return super.shouldRenderPass(entity, pass, f);
	}
}
