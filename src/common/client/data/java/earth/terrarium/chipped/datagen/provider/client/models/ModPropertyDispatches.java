package earth.terrarium.chipped.datagen.provider.client.models;

import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ModPropertyDispatches {

    public static final PropertyDispatch FACING_REVERSED = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
        .select(Direction.SOUTH, Variant.variant())
        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

    public static final PropertyDispatch FACING = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
        .select(Direction.NORTH, Variant.variant())
        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

    public static final PropertyDispatch DIRECTION = PropertyDispatch.property(BlockStateProperties.FACING)
        .select(Direction.UP, Variant.variant())
        .select(Direction.DOWN, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R180))
        .select(Direction.NORTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
        .select(Direction.WEST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
        .select(Direction.EAST, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

    public static final PropertyDispatch AXIS = PropertyDispatch.property(BlockStateProperties.AXIS)
        .select(Direction.Axis.Y, Variant.variant())
        .select(Direction.Axis.X, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
        .select(Direction.Axis.Z, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90));

    public static PropertyDispatch create(BooleanProperty property, ResourceLocation trueModel, ResourceLocation falseModel) {
        return PropertyDispatch.property(property)
            .select(true, Variant.variant().with(VariantProperties.MODEL, trueModel))
            .select(false, Variant.variant().with(VariantProperties.MODEL, falseModel));
    }
}
