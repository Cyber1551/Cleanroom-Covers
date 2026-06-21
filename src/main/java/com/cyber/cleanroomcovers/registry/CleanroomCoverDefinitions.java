package com.cyber.cleanroomcovers.registry;

import com.cyber.cleanroomcovers.CleanroomCovers;
import com.cyber.cleanroomcovers.cover.CleanroomCover;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.SimpleCoverRenderer;
import net.minecraft.resources.ResourceLocation;

public class CleanroomCoverDefinitions {
    public static CoverDefinition CLEANROOM_COVER;
    public static CoverDefinition STERILE_CLEANROOM_COVER;

    private static final ResourceLocation FILTER_CASING = new ResourceLocation("gtceu", "block/casings/cleanroom/filter_casing");
    private static final ResourceLocation STERILE_FILTER_CASING = new ResourceLocation("gtceu", "block/casings/cleanroom/sterilizing_filter_casing");

    public static void init() {
        CLEANROOM_COVER = register("cleanroom_cover", CleanroomType.CLEANROOM, FILTER_CASING);
        STERILE_CLEANROOM_COVER = register("sterile_cleanroom_cover", CleanroomType.STERILE_CLEANROOM, STERILE_FILTER_CASING);
    }

    private static CoverDefinition register(String path, CleanroomType cleanroomType, ResourceLocation faceTexture) {
        var id = CleanroomCovers.id(path);
        var coverDefinition = new CoverDefinition(id,
                (d, coverable, side) -> new CleanroomCover(d, coverable, side, cleanroomType),
                () -> () -> new SimpleCoverRenderer(faceTexture));

        GTRegistries.COVERS.register(id, coverDefinition);
        return coverDefinition;
    }
}
