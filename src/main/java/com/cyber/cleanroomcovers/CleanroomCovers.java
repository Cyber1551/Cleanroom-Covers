package com.cyber.cleanroomcovers;

import com.cyber.cleanroomcovers.registry.CleanroomCoverItems;
import com.cyber.cleanroomcovers.registry.CleanroomCoversCreativeTab;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.resources.ResourceLocation;
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

    public CleanroomCovers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerRegistrate();
        modBus.addListener(this::commonSetup);
        CleanroomCoverItems.init();
        CleanroomCoversCreativeTab.init(modBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
