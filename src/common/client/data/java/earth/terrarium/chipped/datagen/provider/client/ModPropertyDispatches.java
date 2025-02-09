package earth.terrarium.chipped.datagen.provider.client;

import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModPropertyDispatches {

    public static final PropertyDispatch ROTATE = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
        .select(Direction.SOUTH, Variant.variant())
        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
}
