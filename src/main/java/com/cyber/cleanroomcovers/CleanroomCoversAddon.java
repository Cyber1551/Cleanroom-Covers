package com.cyber.cleanroomcovers;

import com.cyber.cleanroomcovers.cover.CleanroomCoverDefinitions;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

@GTAddon
public class CleanroomCoversAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return CleanroomCovers.REGISTRATE;
    }

    @Override
    public String addonModId() {
        return CleanroomCovers.MOD_ID;
    }

    @Override
    public void registerCovers() {
        CleanroomCoverDefinitions.init();
    }

    @Override
    public void initializeAddon() { }
}
