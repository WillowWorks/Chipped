package earth.terrarium.chipped.datagen.provider.client.models;

import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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
}
