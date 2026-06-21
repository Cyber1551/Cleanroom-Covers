package com.cyber.cleanroomcovers.registry;

import com.cyber.cleanroomcovers.CleanroomCovers;
import com.cyber.cleanroomcovers.cover.CleanroomCoverPlacementValidator;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public class CleanroomCoverItems {
    private static final GTRegistrate REGISTRATE = CleanroomCovers.REGISTRATE;

    public static final ItemEntry<ComponentItem> CLEANROOM_COVER = REGISTRATE.item("cleanroom_cover", ComponentItem::create)
            .lang("Cleanroom Cover")
            .onRegister(attach(() -> new CleanroomCoverPlacementValidator()))
            .onRegister(attach(() -> new CoverPlaceBehavior(CleanroomCoverDefinitions.CLEANROOM_COVER)))
            .onRegister(attach(() -> new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.cleanroomcovers.cleanroom_cover.tooltip.0"));
                lines.add(Component.translatable("item.cleanroomcovers.cleanroom_cover.tooltip.1"));
                lines.add(Component.translatable("item.cleanroomcovers.cleanroom_cover.tooltip.2"));
            })))
            .register();

    public static final ItemEntry<ComponentItem> STERILE_CLEANROOM_COVER = REGISTRATE.item("sterile_cleanroom_cover", ComponentItem::create)
            .lang("Sterile Cleanroom Cover")
            .onRegister(attach(() -> new CleanroomCoverPlacementValidator()))
            .onRegister(attach(() -> new CoverPlaceBehavior(CleanroomCoverDefinitions.STERILE_CLEANROOM_COVER)))
            .onRegister(attach(() -> new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.cleanroomcovers.sterile_cleanroom_cover.tooltip.0"));
                lines.add(Component.translatable("item.cleanroomcovers.sterile_cleanroom_cover.tooltip.1"));
                lines.add(Component.translatable("item.cleanroomcovers.sterile_cleanroom_cover.tooltip.2"));
            })))
            .register();

    private static NonNullConsumer<ComponentItem> attach(Supplier<IItemComponent> component) {
        return item -> item.attachComponents(component.get());
    }

    // no-op
    public static void init() { }
}
