package com.rosemods.windswept.core.other.tags;

import com.rosemods.windswept.core.Windswept;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public final class WindsweptBannerPatternTags {
    public static final TagKey<BannerPattern> SNOW_CHARGE = createTag("pattern_item/snow_charge");
    public static final TagKey<BannerPattern> SNOW_GOLEM = createTag("pattern_item/snow_golem");
    public static final TagKey<BannerPattern> ROSE_FLOWER = createTag("pattern_item/rose_flower");

    private static TagKey<BannerPattern> createTag(String name) {
        return TagKey.create(Registry.BANNER_PATTERN_REGISTRY, Windswept.REGISTRY_HELPER.prefix(name));
    }

}
