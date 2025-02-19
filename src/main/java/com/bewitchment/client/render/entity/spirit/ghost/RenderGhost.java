package com.bewitchment.client.render.entity.spirit.ghost;

import com.bewitchment.Bewitchment;
import com.bewitchment.client.model.entity.spirit.ghost.ModelGhost;
import com.bewitchment.common.entity.spirit.ghost.EntityGhost;
import com.bewitchment.common.entity.util.ModEntityMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("WeakerAccess")
@SideOnly(Side.CLIENT)
public class RenderGhost extends RenderLiving<EntityGhost> {
	private static final ResourceLocation[] TEX = {new ResourceLocation(Bewitchment.MODID, "textures/entity/ghost_1.png"), new ResourceLocation(Bewitchment.MODID, "textures/entity/ghost_2.png"), new ResourceLocation(Bewitchment.MODID, "textures/entity/ghost_3.png"), new ResourceLocation(Bewitchment.MODID, "textures/entity/ghost_4.png")};
	
	public RenderGhost(RenderManager manager) {
		this(manager, new ModelGhost());
	}
	
	protected RenderGhost(RenderManager manager, ModelBase model) {
		super(manager, model, 0.3f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entity) {
		return TEX[entity.getDataManager().get(ModEntityMob.SKIN)];
	}
	
	@Override
	protected void preRenderCallback(EntityGhost entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		GlStateManager.scale(1.6, 1.6, 1.6);
	}
}