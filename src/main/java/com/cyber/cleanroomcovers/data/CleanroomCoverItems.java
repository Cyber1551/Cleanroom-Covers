package com.cyber.cleanroomcovers.data;

import com.cyber.cleanroomcovers.CleanroomCovers;
import com.cyber.cleanroomcovers.cover.CleanroomCoverDefinitions;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;

public class CleanroomCoverItems {
    private static final GTRegistrate REGISTRATE = CleanroomCovers.REGISTRATE;

    public static final ItemEntry<ComponentItem> CLEANROOM_COVER = REGISTRATE.item("cleanroom_cover", ComponentItem::create)
            .lang("Cleanroom Cover")
            .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(CleanroomCoverDefinitions.CLEANROOM_COVER)))
            .register();

    public static final ItemEntry<ComponentItem> STERILE_CLEANROOM_COVER = REGISTRATE.item("sterile_cleanroom_cover", ComponentItem::create)
            .lang("Sterile Cleanroom Cover")
            .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(CleanroomCoverDefinitions.STERILE_CLEANROOM_COVER)))
            .register();

    public static void init() {}
}
