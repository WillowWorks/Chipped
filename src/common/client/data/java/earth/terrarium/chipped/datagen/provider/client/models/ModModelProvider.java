package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.ModBlockRegistries;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import earth.terrarium.chipped.datagen.provider.base.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
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
        createSet(ModBlocks.COBWEB);
        createSet(ModBlocks.LADDER);
        createSet(ModBlocks.IRON_BARS);

        ModBlockRegistries.GENERIC_BLOCKS.forEach(this::createSet);
        ModBlockRegistries.GLASS_PANE.forEach(this::createSet);

        createColumnSet(ModBlocks.BOOKSHELF, ResourceLocation.withDefaultNamespace("block/oak_planks"));

        ModBlockRegistries.FLAT_ITEMS.forEach(this::createFlatItemSet);
    }

    private void createSet(ChippedPaletteRegistry registry) {
        List<Block> blocks = registry.boundStream().toList();
        ModelGenerator generator = new ModelGenerator(registry, this.modelOutput);

        for (Block block : blocks) {
            this.addBlock(generator.generate(block));
            this.addItem(block, ModelLocationUtils.getModelLocation(block));
        }
    }

    private void createColumnSet(ChippedPaletteRegistry registry, @Nullable ResourceLocation end) {
        List<Block> blocks = registry.boundStream().toList();
        var provider = end == null ? ModTexturedModels.column(registry) : ModTexturedModels.column(registry, end);

        for (Block block : blocks) {
            var model = provider.create(block, this.modelOutput);
            this.addBlock(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)));
            this.addItem(block, ModelLocationUtils.getModelLocation(block));
        }
    }

    private void createFlatItemSet(ChippedPaletteRegistry registry) {
        List<Block> blocks = registry.boundStream().toList();

        for (Block block : blocks) {
            this.addItem(
                block,
                ModelTemplates.FLAT_ITEM.create(
                    ModelLocationUtils.getModelLocation(block.asItem()),
                    TextureMapping.layer0(ModTexturedModels.texture(registry, block)),
                    this.modelOutput
                )
            );
        }
    }

    @Override
    public String getName() {
        return "Chipped Model Provider";
    }
}
