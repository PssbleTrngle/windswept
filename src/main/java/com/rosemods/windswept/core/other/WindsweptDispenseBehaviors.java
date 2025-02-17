package com.rosemods.windswept.core.other;

import com.rosemods.windswept.common.item.wooden_bucket.WoodenBucketItem;
import com.rosemods.windswept.core.api.IWoodenBucketPickupBlock;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public final class WindsweptDispenseBehaviors {

    public static void registerDispenseBehaviors() {
        DispenserBlock.registerBehavior(WindsweptItems.WOODEN_BUCKET.get(), WindsweptDispenseBehaviors::fillBucket);
        DispenserBlock.registerBehavior(WindsweptItems.WOODEN_WATER_BUCKET.get(), WindsweptDispenseBehaviors::emptyWaterBucket);
        DispenserBlock.registerBehavior(WindsweptItems.WOODEN_POWDER_SNOW_BUCKET.get(), WindsweptDispenseBehaviors::emptyPowderSnowBucket);
    }

    private static ItemStack fillBucket(BlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        Level level = source.getLevel().getLevel();
        BlockPos pos = source.getPos().relative(direction);
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof IWoodenBucketPickupBlock pickupBlock && pickupBlock.canPickup(level, pos, state)) {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

            ItemStack filled = pickupBlock.getWoodenBucketItem().getDefaultInstance();
            filled.setDamageValue(stack.getDamageValue());

            return filled;
        }

        return stack;
    }

    private static ItemStack emptyBucket(Block fill, BlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        Level level = source.getLevel().getLevel();
        BlockPos pos = source.getPos().relative(direction);

        if (level.getBlockState(pos).isAir()) {
            level.setBlockAndUpdate(pos, fill.defaultBlockState());

            return WoodenBucketItem.getEmpty(stack, null, null);
        }

        return stack;
    }

    private static ItemStack emptyWaterBucket(BlockSource source, ItemStack stack) {
        return emptyBucket(Blocks.WATER, source, stack);
    }

    private static ItemStack emptyPowderSnowBucket(BlockSource source, ItemStack stack) {
        return emptyBucket(Blocks.POWDER_SNOW, source, stack);
    }

}
