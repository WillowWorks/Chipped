package earth.terrarium.chipped.datagen.provider.client;

import earth.terrarium.chipped.common.registry.ModBlockRegistries;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import earth.terrarium.chipped.datagen.provider.base.ModelProvider;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void register() {
        createSet(ModBlocks.AMETHYST_BLOCK);
        createSet(ModBlocks.ANCIENT_DEBRIS);
        createSet(ModBlocks.BLUE_ICE);
        createSet(ModBlocks.COAL_BLOCK);
        createSet(ModBlocks.CRYING_OBSIDIAN);
        createSet(ModBlocks.DARK_PRISMARINE);
        createSet(ModBlocks.DIRT);
        createSet(ModBlocks.DRIPSTONE_BLOCK);
        createSet(ModBlocks.END_STONE);
        createSet(ModBlocks.GILDED_BLACKSTONE);
        createSet(ModBlocks.ICE);
        createSet(ModBlocks.LAPIS_BLOCK);
        createSet(ModBlocks.LODESTONE);
        createSet(ModBlocks.MAGMA_BLOCK);
        createSet(ModBlocks.NETHER_BRICKS);
        createSet(ModBlocks.NETHERRACK);
        createSet(ModBlocks.OBSIDIAN);
        createSet(ModBlocks.PACKED_ICE);
        createSet(ModBlocks.PRISMARINE);
        createSet(ModBlocks.PURPUR_BLOCK);
        createSet(ModBlocks.QUARTZ_BLOCK);
        createSet(ModBlocks.RAW_COPPER_BLOCK);
        createSet(ModBlocks.RAW_GOLD_BLOCK);
        createSet(ModBlocks.RAW_IRON_BLOCK);
        createSet(ModBlocks.RED_NETHER_BRICKS);
        createSet(ModBlocks.RED_SANDSTONE);
        createSet(ModBlocks.REDSTONE_BLOCK);
        createSet(ModBlocks.SANDSTONE);
        createSet(ModBlocks.SNOW_BLOCK);
        createSet(ModBlocks.TUFF);
        createSet(ModBlocks.CLAY);

        ModBlockRegistries.GLAZED_TERRACOTTA.forEach(this::createGlazedSet);

        ModBlockRegistries.FULL_BLOCKS.forEach(this::createSet);
        ModBlockRegistries.GLASS_PANE.forEach(this::createSet);
    }

    private void createSet(ChippedPaletteRegistry registry) {
        createSet(registry, ModTexturedModels::cube, BlockModelGenerators::createSimpleBlock);
    }

    private void createGlazedSet(ChippedPaletteRegistry registry) {
        // TODO
//        createSet(registry, ModTexturedModels::glazedTerracotta);
//
//        this.blocks.blockStateOutput
//            .accept(
//                MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourcelocation))
//                    .with(ModPropertyDispatches.ROTATE)
//            );
    }

    private void createSet(
        ChippedPaletteRegistry registry,
        Function<ChippedPaletteRegistry, TexturedModel.Provider> factory,
        BiFunction<Block, ResourceLocation, BlockStateGenerator> generator
    ) {
        List<Block> blocks = registry.boundStream().toList();
        var provider = factory.apply(registry);

        for (Block block : blocks) {
            ResourceLocation texture = provider.create(block, this.blocks.modelOutput);
            this.blocks.blockStateOutput.accept(generator.apply(block, texture));
            this.items.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block)));
        }
    }

    @Override
    public String getName() {
        return "Chipped Model Provider";
    }
}
