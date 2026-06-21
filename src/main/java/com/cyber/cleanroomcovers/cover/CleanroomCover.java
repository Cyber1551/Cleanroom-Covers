package com.cyber.cleanroomcovers.cover;

import com.gregtechceu.gtceu.api.capability.ICleanroomReceiver;
import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.cover.CoverBehavior;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import net.minecraft.core.Direction;

public class CleanroomCover extends CoverBehavior {
    private final CleanroomType _cleanroomType;

    public CleanroomCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide, CleanroomType cleanroomType) {
        super(definition, coverHolder, attachedSide);
        _cleanroomType = cleanroomType;
    }

    @Override
    public boolean canAttach() {
        return super.canAttach() && getRejectReason(coverHolder) == null;
    }

    // Why a cleanroom cover can't be attached to the given holder
    public static String getRejectReason(ICoverable coverHolder) {
        var machine = MetaMachine.getMachine(coverHolder.getLevel(), coverHolder.getPos());

        if (coverHolder.getCovers().stream().anyMatch(c -> c instanceof CleanroomCover)) {
            return "cover.cleanroomcovers.reject.already";
        }

        if (machine instanceof IMultiController || machine instanceof IMultiPart) {
            return "cover.cleanroomcovers.reject.multiblock";
        }

        if (!(machine instanceof ICleanroomReceiver)) {
            return "cover.cleanroomcovers.reject.not_receiver";
        }

        return null;
    }

    public CleanroomType getCleanroomType() {
        return _cleanroomType;
    }
}
