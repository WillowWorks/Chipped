package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ModelGenerator {

    private static final List<Generator> GENERATORS = List.of(
        Generator.of(BlockStateProperties.HORIZONTAL_FACING, ModelGenerator::rotated),
        Generator.of(BlockStateProperties.AXIS, ModelGenerator::column),
        Generator.of(state -> state.getBlock() instanceof RedstoneLampBlock, ModelGenerator::lamp),
        Generator.of(state -> state.getBlock() instanceof CarpetBlock, create("carpet", ModTexturedModels::carpet)),
        Generator.of(state -> true, create("cube", ModTexturedModels::cube))
    );

    private final Map<String, TexturedModel.Provider> providers = new HashMap<>();
    private final ChippedPaletteRegistry registry;
    private final BiConsumer<ResourceLocation, ModelInstance> models;

    public ModelGenerator(ChippedPaletteRegistry registry, BiConsumer<ResourceLocation, ModelInstance> models) {
        this.registry = registry;
        this.models = models;
    }

    private ResourceLocation getModel(Block block, String suffix, String name, BiFunction<ChippedPaletteRegistry, String, TexturedModel.Provider> factory) {
        var provider = this.providers.computeIfAbsent(name + suffix, key -> factory.apply(this.registry, suffix));
        return provider.createWithSuffix(block, suffix, this.models);
    }

    private ResourceLocation getModel(Block block, String name, Function<ChippedPaletteRegistry, TexturedModel.Provider> factory) {
        var provider = this.providers.computeIfAbsent(name, key -> factory.apply(this.registry));
        return provider.create(block, this.models);
    }

    private BlockStateGenerator rotated(Block block) {
        var model = getModel(block, "rotated", ModTexturedModels::rotated);
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)).with(ModPropertyDispatches.FACING);
    }

    private BlockStateGenerator column(Block block) {
        var model = getModel(block, "column", ModTexturedModels::column);
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)).with(ModPropertyDispatches.AXIS);
    }

    private BlockStateGenerator lamp(Block block) {
        var off = getModel(block, "cube", ModTexturedModels::cube);
        var on = getModel(block, "_on", "cube", ModTexturedModels::cube);
        return MultiVariantGenerator.multiVariant(block).with(ModPropertyDispatches.create(BlockStateProperties.LIT, on, off));
    }

    public BlockStateGenerator generate(Block block) {
        var state = block.defaultBlockState();
        for (var generator : GENERATORS) {
            if (generator.test(state)) {
                return generator.create(this, block);
            }
        }
        throw new IllegalStateException("No generator found for block: " + block);
    }

    private static BiFunction<ModelGenerator, Block, BlockStateGenerator> create(String id, Function<ChippedPaletteRegistry, TexturedModel.Provider> factory) {
        return (generator, block) -> {
            var model = generator.getModel(block, id, factory);
            return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model));
        };
    }

    private record Generator(
        Predicate<BlockState> predicate,
        BiFunction<ModelGenerator, Block, BlockStateGenerator> factory
    ) implements Predicate<BlockState> {

        public static Generator of(Predicate<BlockState> predicate, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return new Generator(predicate, factory);
        }

        public static Generator of(Property<?> property, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return new Generator(state -> state.hasProperty(property), factory);
        }

        @Override
        public boolean test(BlockState blockState) {
            return this.predicate.test(blockState);
        }

        public BlockStateGenerator create(ModelGenerator generator, Block block) {
            return this.factory.apply(generator, block);
        }
    }
}
