package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class ModelGenerator {

    // Make sure when you add new generators you put them in order of priority
    private static final List<Generator> GENERATORS = List.of(
        Generator.of(RedstoneLampBlock.class, ModStateGenerators::lamp),
        Generator.of(LadderBlock.class, ModStateGenerators::ladder),
        Generator.of(CarpetBlock.class, create("carpet", ModTexturedModels::carpet)),
        Generator.of(WaterlilyBlock.class, create("lily_pad", ModTexturedModels::lilypad)),
        Generator.of(WebBlock.class, create("cobweb", ModTexturedModels::cross)),
        Generator.of(PumpkinBlock.class, create("pumpkin", ModTexturedModels::columnTopBottom)),
        Generator.of(BarrelBlock.class, ModStateGenerators::barrel),
        Generator.of(TrapDoorBlock.class, ModStateGenerators::trapdoor),
        Generator.of(DoorBlock.class, ModStateGenerators::door),

        Generator.of(Blocks.CRIMSON_FUNGUS, create("crimson_fungus", ModTexturedModels::cross)),
        Generator.of(Blocks.CRIMSON_ROOTS, create("crimson_roots", ModTexturedModels::cross)),
        Generator.of(Blocks.WARPED_FUNGUS, create("crimson_fungus", ModTexturedModels::cross)),
        Generator.of(Blocks.WARPED_ROOTS, create("crimson_roots", ModTexturedModels::cross)),
        Generator.of(Blocks.NETHER_SPROUTS, create("nether_sprouts", ModTexturedModels::cross)),
        Generator.of(Blocks.MELON, create("melon", ModTexturedModels::column)),
        Generator.of(Blocks.DRIED_KELP_BLOCK, create("dried_kelp", ModTexturedModels::column)),
        Generator.of(Blocks.IRON_BARS, ModStateGenerators::ironbars),

        Generator.of(IronBarsBlock.class, ModStateGenerators::pane), // Has to be after iron bars or it will match ironbars

        Generator.of(BlockStateProperties.HORIZONTAL_FACING, ModStateGenerators::rotated),
        Generator.of(BlockStateProperties.AXIS, ModStateGenerators::column),

        Generator.of(state -> true, create("cube", ModTexturedModels::cube))
    );

    final Map<String, TexturedModel.Provider> providers = new HashMap<>();
    final ChippedPaletteRegistry registry;
    final BiConsumer<ResourceLocation, ModelInstance> models;

    public ModelGenerator(ChippedPaletteRegistry registry, BiConsumer<ResourceLocation, ModelInstance> models) {
        this.registry = registry;
        this.models = models;
    }

    ResourceLocation getModel(Block block, String suffix, String name, BiFunction<ChippedPaletteRegistry, String, TexturedModel.Provider> factory) {
        var provider = this.providers.computeIfAbsent(name + suffix, key -> factory.apply(this.registry, suffix));
        return provider.createWithSuffix(block, suffix, this.models);
    }

    ResourceLocation getModel(Block block, String name, Function<ChippedPaletteRegistry, TexturedModel.Provider> factory) {
        var provider = this.providers.computeIfAbsent(name, key -> factory.apply(this.registry));
        return provider.create(block, this.models);
    }

    public BlockStateGenerator generate(Block block) {
        var state = block.defaultBlockState();
        for (var generator : GENERATORS) {
            if (generator.test(this.registry, state)) {
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
        BiPredicate<ChippedPaletteRegistry, BlockState> predicate,
        BiFunction<ModelGenerator, Block, BlockStateGenerator> factory
    ) implements BiPredicate<ChippedPaletteRegistry, BlockState> {

        public static Generator of(Predicate<BlockState> predicate, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return new Generator(($, state) -> predicate.test(state), factory);
        }

        public static Generator of(Block base, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return new Generator((registry, $) -> registry.getBase() == base, factory);
        }

        public static Generator of(Property<?> property, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return of(state -> state.hasProperty(property), factory);
        }

        public static Generator of(Class<? extends Block> clazz, BiFunction<ModelGenerator, Block, BlockStateGenerator> factory) {
            return of(state -> clazz.isAssignableFrom(state.getBlock().getClass()), factory);
        }

        @Override
        public boolean test(ChippedPaletteRegistry registry, BlockState blockState) {
            return this.predicate.test(registry, blockState);
        }

        public BlockStateGenerator create(ModelGenerator generator, Block block) {
            return this.factory.apply(generator, block);
        }
    }
}
