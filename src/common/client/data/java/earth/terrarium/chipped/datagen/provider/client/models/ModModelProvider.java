package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.ModBlockRegistries;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import earth.terrarium.chipped.datagen.provider.base.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void register() {
        createSet(ModBlocks.BLUE_ICE);
        createSet(ModBlocks.CRYING_OBSIDIAN);
        createSet(ModBlocks.DARK_PRISMARINE);
        createSet(ModBlocks.END_STONE);
        createSet(ModBlocks.GILDED_BLACKSTONE);
        createSet(ModBlocks.ICE);
        createSet(ModBlocks.LODESTONE);
        createSet(ModBlocks.MAGMA_BLOCK);
        createSet(ModBlocks.NETHER_BRICKS);
        createSet(ModBlocks.NETHERRACK);
        createSet(ModBlocks.OBSIDIAN);
        createSet(ModBlocks.PACKED_ICE);
        createSet(ModBlocks.PRISMARINE);
        createSet(ModBlocks.PURPUR_BLOCK);
        createSet(ModBlocks.RED_NETHER_BRICKS);
        createSet(ModBlocks.RED_SANDSTONE);
        createSet(ModBlocks.SANDSTONE);
        createSet(ModBlocks.SNOW_BLOCK);

        ModBlockRegistries.CARPET.forEach(this::createSet);
        ModBlockRegistries.FULL_BLOCKS.forEach(this::createSet);
        ModBlockRegistries.GLASS_PANE.forEach(this::createSet);

        createColumnSet(ModBlocks.DRIED_KELP_BLOCK, null);
        createColumnSet(ModBlocks.MELON, null);
        createColumnSet(ModBlocks.BOOKSHELF, ResourceLocation.withDefaultNamespace("block/oak_planks"));
    }

    private void createSet(ChippedPaletteRegistry registry) {
        List<Block> blocks = registry.boundStream().toList();
        ModelGenerator generator = new ModelGenerator(registry, this.blocks.modelOutput);

        for (Block block : blocks) {
            this.blocks.blockStateOutput.accept(generator.generate(block));
            this.items.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block)));
        }
    }

    private void createColumnSet(ChippedPaletteRegistry registry, @Nullable ResourceLocation end) {
        List<Block> blocks = registry.boundStream().toList();
        var provider = end == null ? ModTexturedModels.column(registry) : ModTexturedModels.column(registry, end);

        for (Block block : blocks) {
            var model = provider.create(block, this.blocks.modelOutput);
            this.blocks.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model))
            );
            this.items.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block)));
        }
    }

    @Override
    public String getName() {
        return "Chipped Model Provider";
    }
}
