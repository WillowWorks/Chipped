package earth.terrarium.chipped.datagen.provider.client.models;

import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;

public class ModStateGenerators {

    public static BlockStateGenerator rotated(ModelGenerator generator, Block block) {
        var model = generator.getModel(block, "rotated", ModTexturedModels::rotated);
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)).with(ModPropertyDispatches.FACING_REVERSED);
    }

    public static BlockStateGenerator column(ModelGenerator generator, Block block) {
        var model = generator.getModel(block, "column", ModTexturedModels::column);
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)).with(ModPropertyDispatches.AXIS);
    }

    public static BlockStateGenerator lamp(ModelGenerator generator, Block block) {
        var off = generator.getModel(block, "cube", ModTexturedModels::cube);
        var on = generator.getModel(block, "_on", "cube", ModTexturedModels::cube);
        return MultiVariantGenerator.multiVariant(block).with(ModPropertyDispatches.create(BlockStateProperties.LIT, on, off));
    }

    public static BlockStateGenerator ladder(ModelGenerator generator, Block block) {
        var model = generator.getModel(block, "ladder", ModTexturedModels::ladder);
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)).with(ModPropertyDispatches.FACING);
    }

    public static BlockStateGenerator ironbars(ModelGenerator generator, Block block) {
        var postEnds = generator.getModel(block, "_post_ends", "iron_bars", ModTexturedModels::ironbars);
        var post = generator.getModel(block, "_post", "iron_bars", ModTexturedModels::ironbars);
        var cap = generator.getModel(block, "_cap", "iron_bars", ModTexturedModels::ironbars);
        var capAlt = generator.getModel(block, "_cap_alt", "iron_bars", ModTexturedModels::ironbars);
        var side = generator.getModel(block, "_side", "iron_bars", ModTexturedModels::ironbars);
        var sideAlt = generator.getModel(block, "_side_alt", "iron_bars", ModTexturedModels::ironbars);
        return MultiPartGenerator.multiPart(block)
            .with(Variant.variant().with(VariantProperties.MODEL, postEnds))
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, false)
                .term(BlockStateProperties.EAST, false)
                .term(BlockStateProperties.SOUTH, false)
                .term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, post)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, true)
                .term(BlockStateProperties.EAST, false)
                .term(BlockStateProperties.SOUTH, false)
                .term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, cap)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, false)
                .term(BlockStateProperties.EAST, true)
                .term(BlockStateProperties.SOUTH, false)
                .term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, cap).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, false)
                .term(BlockStateProperties.EAST, false)
                .term(BlockStateProperties.SOUTH, true)
                .term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, capAlt)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, false)
                .term(BlockStateProperties.EAST, false)
                .term(BlockStateProperties.SOUTH, false)
                .term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, capAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, sideAlt)
            )
            .with(Condition.condition()
                .term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
            );
    }

    public static BlockStateGenerator pane(ModelGenerator generator, Block block) {
        var post = generator.getModel(block, "_post", "glass_pane", ModTexturedModels::pane);
        var side = generator.getModel(block, "_side", "glass_pane", ModTexturedModels::pane);
        var sideAlt = generator.getModel(block, "_side_alt", "glass_pane", ModTexturedModels::pane);
        var noSide = generator.getModel(block, "_noside", "glass_pane", ModTexturedModels::pane);
        var noSideAlt = generator.getModel(block, "_noside_alt", "glass_pane", ModTexturedModels::pane);

        return MultiPartGenerator.multiPart(block)
            .with(Variant.variant().with(VariantProperties.MODEL, post))
            .with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side))
            .with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, sideAlt))
            .with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, noSide))
            .with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt))
            .with(Condition.condition().term(BlockStateProperties.SOUTH, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, noSide).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
    }

    public static BlockStateGenerator barrel(ModelGenerator generator, Block block) {
        boolean isCrate = block.builtInRegistryHolder().key().location().getPath().endsWith("_crate");
        if (isCrate) {
            var model = generator.getModel(block, "column", ModTexturedModels::columnTop);
            return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model))
                .with(ModPropertyDispatches.DIRECTION);
        } else {
            var closed = generator.getModel(block, "barrel", ModTexturedModels::columnTopBottom);
            var open = generator.getModel(block, "_open", "barrel", ModTexturedModels::columnTopBottom);
            return MultiVariantGenerator.multiVariant(block, Variant.variant())
                .with(ModPropertyDispatches.DIRECTION)
                .with(PropertyDispatch.property(BlockStateProperties.OPEN)
                    .select(true, Variant.variant().with(VariantProperties.MODEL, open))
                    .select(false, Variant.variant().with(VariantProperties.MODEL, closed))
                );
        }
    }

    public static BlockStateGenerator trapdoor(ModelGenerator generator, Block block) {
        var top = generator.getModel(block, "_top", "trapdoor", ModTexturedModels::trapdoor);
        var bottom = generator.getModel(block, "_bottom", "trapdoor", ModTexturedModels::trapdoor);
        var open = generator.getModel(block, "_open", "trapdoor", ModTexturedModels::trapdoor);

        return MultiVariantGenerator.multiVariant(block)
            .with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
                .select(Direction.NORTH, Half.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, bottom))
                .select(Direction.SOUTH, Half.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, bottom))
                .select(Direction.EAST, Half.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, bottom))
                .select(Direction.WEST, Half.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, bottom))
                .select(Direction.NORTH, Half.TOP, false, Variant.variant().with(VariantProperties.MODEL, top))
                .select(Direction.SOUTH, Half.TOP, false, Variant.variant().with(VariantProperties.MODEL, top))
                .select(Direction.EAST, Half.TOP, false, Variant.variant().with(VariantProperties.MODEL, top))
                .select(Direction.WEST, Half.TOP, false, Variant.variant().with(VariantProperties.MODEL, top))
                .select(Direction.NORTH, Half.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, open))
                .select(Direction.SOUTH, Half.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, Half.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, Half.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, Half.TOP, true, Variant.variant().with(VariantProperties.MODEL, open))
                .select(Direction.SOUTH, Half.TOP, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, Half.TOP, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, Half.TOP, true, Variant.variant().with(VariantProperties.MODEL, open).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
            );
    }

    public static BlockStateGenerator door(ModelGenerator generator, Block block) {
        var bottomLeft = generator.getModel(block, "_bottom_left", "door", ModTexturedModels::door);
        var bottomRight = generator.getModel(block, "_bottom_right", "door", ModTexturedModels::door);
        var topLeft = generator.getModel(block, "_top_left", "door", ModTexturedModels::door);
        var topRight = generator.getModel(block, "_top_right", "door", ModTexturedModels::door);
        var bottomLeftOpen = generator.getModel(block, "_bottom_left_open", "door", ModTexturedModels::door);
        var bottomRightOpen = generator.getModel(block, "_bottom_right_open", "door", ModTexturedModels::door);
        var topLeftOpen = generator.getModel(block, "_top_left_open", "door", ModTexturedModels::door);
        var topRightOpen = generator.getModel(block, "_top_right_open", "door", ModTexturedModels::door);

        return MultiVariantGenerator.multiVariant(block)
            .with(configureDoorHalf(
                configureDoorHalf(
                    PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN),
                    DoubleBlockHalf.LOWER, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen
                ),
                DoubleBlockHalf.UPPER, topLeft, topLeftOpen, topRight, topRightOpen
            ));
    }

    public static PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> configureDoorHalf(PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> dispatch, DoubleBlockHalf half, ResourceLocation left, ResourceLocation leftOpen, ResourceLocation right, ResourceLocation rightOpen) {
        return dispatch.select(Direction.EAST, half, DoorHingeSide.LEFT, false, Variant.variant().with(VariantProperties.MODEL, left))
            .select(Direction.SOUTH, half, DoorHingeSide.LEFT, false, Variant.variant().with(VariantProperties.MODEL, left).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.WEST, half, DoorHingeSide.LEFT, false, Variant.variant().with(VariantProperties.MODEL, left).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
            .select(Direction.NORTH, half, DoorHingeSide.LEFT, false, Variant.variant().with(VariantProperties.MODEL, left).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
            .select(Direction.EAST, half, DoorHingeSide.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, right))
            .select(Direction.SOUTH, half, DoorHingeSide.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, right).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.WEST, half, DoorHingeSide.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, right).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
            .select(Direction.NORTH, half, DoorHingeSide.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, right).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
            .select(Direction.EAST, half, DoorHingeSide.LEFT, true, Variant.variant().with(VariantProperties.MODEL, leftOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.SOUTH, half, DoorHingeSide.LEFT, true, Variant.variant().with(VariantProperties.MODEL, leftOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
            .select(Direction.WEST, half, DoorHingeSide.LEFT, true, Variant.variant().with(VariantProperties.MODEL, leftOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
            .select(Direction.NORTH, half, DoorHingeSide.LEFT, true, Variant.variant().with(VariantProperties.MODEL, leftOpen))
            .select(Direction.EAST, half, DoorHingeSide.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, rightOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
            .select(Direction.SOUTH, half, DoorHingeSide.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, rightOpen))
            .select(Direction.WEST, half, DoorHingeSide.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, rightOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.NORTH, half, DoorHingeSide.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, rightOpen).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));
    }
}
