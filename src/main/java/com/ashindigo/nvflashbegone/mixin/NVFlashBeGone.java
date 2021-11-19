package com.ashindigo.nvflashbegone.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GameRenderer.class)
public class NVFlashBeGone {
	@Overwrite
	public static float getNightVisionStrength(LivingEntity entity, float tickDelta) {
		int dur = entity.getStatusEffect(StatusEffects.NIGHT_VISION).getDuration();
		if (dur <= 0) return 0f;
		if (dur > 200) return 1f;
		return (dur - tickDelta) / 200f; // slowly fade out over the last 10 seconds
	}
}
