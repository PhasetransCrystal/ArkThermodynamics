package com.phasetranscrystal.ark_thermodynamics.resource;

import com.phasetranscrystal.ark_thermodynamics.ArkThermodynamics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.dimension.DimensionType;

public class Tags {
    public static void bootstrap(){
        DimensionTypeTags.bootstrap();
    }


    public static class DimensionTypeTags {
        public static final TagKey<DimensionType> HAS_WORLD_STATE = tag("has_world_state");

        private static TagKey<DimensionType> tag(String path){
            return TagKey.create(Registries.DIMENSION_TYPE,ResourceLocation.fromNamespaceAndPath(ArkThermodynamics.MODID,path));
        }
        public static void bootstrap(){
        }

    }
}
