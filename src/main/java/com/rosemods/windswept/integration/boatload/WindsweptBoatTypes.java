package com.rosemods.windswept.integration.boatload;

import com.rosemods.windswept.core.Windswept;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptItems;
import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public final class WindsweptBoatTypes {
    public static final BoatloadBoatType HOLLY = BoatloadBoatType.register(BoatloadBoatType.create(Windswept.REGISTRY_HELPER.prefix("holly"), () -> WindsweptBlocks.HOLLY_PLANKS.get().asItem(), () -> WindsweptItems.HOLLY_BOAT.getFirst().get(), () -> WindsweptItems.HOLLY_BOAT.getSecond().get(), () -> WindsweptItems.HOLLY_FURNACE_BOAT.get(), () -> WindsweptItems.LARGE_HOLLY_BOAT.get()));
    public static final BoatloadBoatType CHESTNUT = BoatloadBoatType.register(BoatloadBoatType.create(Windswept.REGISTRY_HELPER.prefix("chestnut"), () -> WindsweptBlocks.CHESTNUT_PLANKS.get().asItem(), () -> WindsweptItems.CHESTNUT_BOAT.getFirst().get(), () -> WindsweptItems.CHESTNUT_BOAT.getSecond().get(), () -> WindsweptItems.CHESTNUT_FURNACE_BOAT.get(), () -> WindsweptItems.LARGE_CHESTNUT_BOAT.get()));

    public static final Supplier<Item> HOLLY_FURNACE_BOAT = () -> new FurnaceBoatItem(HOLLY);
    public static final Supplier<Item> LARGE_HOLLY_BOAT = () -> new LargeBoatItem(HOLLY);
    public static final Supplier<Item> CHESTNUT_FURNACE_BOAT = () -> new FurnaceBoatItem(CHESTNUT);
    public static final Supplier<Item> LARGE_CHESTNUT_BOAT = () -> new LargeBoatItem(CHESTNUT);

}
