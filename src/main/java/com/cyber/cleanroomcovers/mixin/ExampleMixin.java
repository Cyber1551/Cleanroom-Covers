package com.cyber.cleanroomcovers.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.cyber.cleanroomcovers.CleanroomCovers;

@Mixin(TitleScreen.class)
public class ExampleMixin {

    @Inject(method = "init", at = @At("HEAD"))
    private void cleanroomcovers$confirmMixinPipeline(CallbackInfo ci) {
        CleanroomCovers.LOGGER.info("[{}] mixin pipeline active (placeholder mixin)", CleanroomCovers.MOD_ID);
    }
}
