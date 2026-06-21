package com.cyber.cleanroomcovers.cover;

import com.gregtechceu.gtceu.api.capability.GTCapabilityHelper;
import com.gregtechceu.gtceu.api.item.component.IInteractionItem;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public record CleanroomCoverPlacementValidator() implements IInteractionItem {
    @Override
    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext context) {
        var coverable = GTCapabilityHelper.getCoverable(context.getLevel(), context.getClickedPos(), context.getClickedFace());
        if (coverable == null) return InteractionResult.PASS;

        var reason = CleanroomCover.getRejectReason(coverable);
        if (reason == null) return InteractionResult.PASS; // placeable

        // Message server-side only (sends to that client's action bar)
        if (context.getPlayer() instanceof ServerPlayer serverPlayer) {
            serverPlayer.displayClientMessage(Component.translatable(reason), true);
        }

        return InteractionResult.FAIL;
    }
}
