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
        if (!super.canAttach()) return false;

        var machine = MetaMachine.getMachine(coverHolder.getLevel(), coverHolder.getPos());

        var hasCleanroomCapability = machine instanceof ICleanroomReceiver;
        var isMultiblock = machine instanceof IMultiController || machine instanceof IMultiPart;
        var noExistingCover = coverHolder.getCovers().stream().noneMatch(c -> c instanceof CleanroomCover);

        // Only allow single block machines with cleanroom capability and no existing cleanroom cover
        return hasCleanroomCapability && !isMultiblock && noExistingCover;
    }

    public CleanroomType getCleanroomType() {
        return _cleanroomType;
    }
}
