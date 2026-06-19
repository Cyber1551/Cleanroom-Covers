package com.cyber.cleanroomcovers;

import com.cyber.cleanroomcovers.data.CleanroomCoverItems;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CleanroomCovers.MOD_ID)
public class CleanroomCovers {

    public static final String MOD_ID = "cleanroomcovers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final GTRegistrate REGISTRATE = GTRegistrate.create(MOD_ID);

    private static final ResourceKey<CreativeModeTab> GTCEU_ITEM_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation("gtceu", "item"));

    public CleanroomCovers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerRegistrate();
        modBus.addListener(this::commonSetup);
        LOGGER.info("[{}] constructed", MOD_ID);
        CleanroomCoverItems.init();
        modBus.addListener(this::buildCreativeTabContents);
    }

    private void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == GTCEU_ITEM_TAB) {
            event.accept(CleanroomCoverItems.CLEANROOM_COVER.get());
            event.accept(CleanroomCoverItems.STERILE_CLEANROOM_COVER.get());
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
