package com.ashindigo.nvflashbegone.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.resource.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class NVFlashBeGone {

    @Overwrite()
    public static float getNightVisionStrength(LivingEntity livingEntity, float f) {
        int i = livingEntity.getStatusEffect(StatusEffects.NIGHT_VISION).getDuration();
        return i > 0 ? 1 : i;
        // i > (time till fades) ? (brightness) : i * (faderate)
    }
}
