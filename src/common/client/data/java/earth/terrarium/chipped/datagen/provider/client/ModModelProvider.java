package earth.terrarium.chipped.datagen.provider.client;

import earth.terrarium.chipped.common.registry.ModBlockRegistries;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import earth.terrarium.chipped.datagen.provider.base.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void register() {
        createSet(ModBlocks.AMETHYST_BLOCK);
        createSet(ModBlocks.ANCIENT_DEBRIS);
        createSet(ModBlocks.ANDESITE);
        createSet(ModBlocks.BASALT);
        createSet(ModBlocks.BLACKSTONE);
        createSet(ModBlocks.BLUE_ICE);
        createSet(ModBlocks.CALCITE);
        createSet(ModBlocks.COAL_BLOCK);
        createSet(ModBlocks.COBBLESTONE);
        createSet(ModBlocks.CRYING_OBSIDIAN);
        createSet(ModBlocks.DARK_PRISMARINE);
        createSet(ModBlocks.DEEPSLATE);
        createSet(ModBlocks.DIORITE);
        createSet(ModBlocks.DIRT);
        createSet(ModBlocks.DRIPSTONE_BLOCK);
        createSet(ModBlocks.END_STONE);
        createSet(ModBlocks.GILDED_BLACKSTONE);
        createSet(ModBlocks.GRANITE);
        createSet(ModBlocks.ICE);
        createSet(ModBlocks.LAPIS_BLOCK);
        createSet(ModBlocks.LODESTONE);
        createSet(ModBlocks.MAGMA_BLOCK);
        createSet(ModBlocks.MOSSY_COBBLESTONE);
        createSet(ModBlocks.MOSSY_STONE_BRICKS);
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
        createSet(ModBlocks.STONE);
        createSet(ModBlocks.SMOOTH_STONE);
        createSet(ModBlocks.SNOW_BLOCK);
        createSet(ModBlocks.TUFF);
        createSet(ModBlocks.CLAY);

        ModBlockRegistries.FULL_BLOCKS.forEach(this::createSet);
        ModBlockRegistries.GLASS_PANE.forEach(this::createSet);
    }

    private void createSet(ChippedPaletteRegistry registry) {
        List<Block> blocks = registry.boundStream().toList();

        var cubeAll = ModTexturedModels.cube(registry);

        for (Block block : blocks) {
            this.blocks.createTrivialBlock(block, cubeAll);
            this.items.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block)));
        }
    }

    @Override
    public String getName() {
        return "Chipped Model Provider";
    }
}
