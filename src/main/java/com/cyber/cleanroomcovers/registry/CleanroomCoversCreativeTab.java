package com.cyber.cleanroomcovers.registry;

import com.gregtechceu.gtceu.GTCEu;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class CleanroomCoversCreativeTab {
    private static final ResourceKey<CreativeModeTab> GT_ITEM_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, GTCEu.id("item"));

    public static void init(IEventBus modBus) {
        modBus.addListener(CleanroomCoversCreativeTab::onBuildContents);
    }

    private static void onBuildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(GT_ITEM_TAB)) {
            event.accept(CleanroomCoverItems.CLEANROOM_COVER.get());
            event.accept(CleanroomCoverItems.STERILE_CLEANROOM_COVER.get());
        }
    }
}
