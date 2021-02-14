package com.ashindigo.nvflashbegone.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class NVFlashBeGone {

    @Inject(method = "getNightVisionStrength", at = @At("RETURN"), cancellable = true)
    private static void noFlash_getNightVisionStrength(LivingEntity livingEntity, float f, CallbackInfoReturnable<Float> info) {
        float i = livingEntity.getStatusEffect(StatusEffects.NIGHT_VISION).getDuration();
        info.setReturnValue(i > 0 ? 1 : i);
        // i > (time till fades) ? (brightness) : i * (faderate)
    }
}
