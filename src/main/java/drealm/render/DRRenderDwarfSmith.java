package drealm.render;

import lotr.common.entity.npc.LOTREntityDwarf;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class DRRenderDwarfSmith extends DRRenderDwarf {
	private static final ResourceLocation APRON_TEXTURE = new ResourceLocation("lotr:mob/dwarf/blacksmith_apron.png");

	@Override
	public int shouldRenderPass(EntityLiving entity, int pass, float f) {
		LOTREntityDwarf dwarf = (LOTREntityDwarf) entity;
		if (pass == 1 && dwarf.getEquipmentInSlot(3) == null) {
			setRenderPassModel(standardRenderPassModel);
			bindTexture(APRON_TEXTURE);
			return 1;
		}
		return super.shouldRenderPass(entity, pass, f);
	}
}
