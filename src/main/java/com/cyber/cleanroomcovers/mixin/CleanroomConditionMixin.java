package com.cyber.cleanroomcovers.mixin;

import com.cyber.cleanroomcovers.cover.CleanroomCover;
import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.recipe.condition.CleanroomCondition;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = CleanroomCondition.class, remap = false)
public class CleanroomConditionMixin {
    @Shadow private CleanroomType cleanroom;

    @ModifyReturnValue(method = "testCondition", at = @At("RETURN"))
    private boolean cleanroomcovers$coverGrantsAccess(boolean original, GTRecipe recipe, RecipeLogic recipeLogic) {
        if (original) return true;

        if (this.cleanroom == null) return false;

        var machine = recipeLogic.getMachine();
        if (!(machine instanceof ICleanroomReceiver)) return false;

        return machine.getCoverContainer().getCovers().stream().anyMatch(cover -> cover instanceof CleanroomCover cc && cc.getCleanroomType() == this.cleanroom);
    }
}
