package earth.terrarium.chipped.datagen.provider.base;

import com.google.gson.JsonElement;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ModelProvider implements DataProvider {

    private final PackOutput.PathProvider statesPath;
    private final PackOutput.PathProvider itemsPath;
    private final PackOutput.PathProvider modelsPath;

    protected BlockModelGenerators blocks;
    protected ItemModelGenerators items;

    public ModelProvider(PackOutput output) {
        this.statesPath = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.itemsPath = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        this.modelsPath = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        Map<Item, ClientItem> items = new HashMap<>();
        Map<ResourceLocation, ModelInstance> models = new HashMap<>();
        Map<Block, BlockStateGenerator> generators = new HashMap<>();

        this.blocks = new BlockModelGenerators(
            generator -> generators.put(generator.getBlock(), generator),
            new Output(items),
            models::put
        );

        this.items = new ItemModelGenerators(
            new Output(items),
            models::put
        );

        register();

        return CompletableFuture.allOf(
            saveAll(output, block -> this.statesPath.json(block.builtInRegistryHolder().key().location()), generators),
            DataProvider.saveAll(output, ClientItem.CODEC, item -> this.itemsPath.json(item.builtInRegistryHolder().key().location()), items),
            saveAll(output, this.modelsPath::json, models)
        );
    }

    protected abstract void register();

    private static <T> CompletableFuture<?> saveAll(CachedOutput cachedOutput, Function<T, Path> function, Map<T, ? extends Supplier<JsonElement>> map) {
        return DataProvider.saveAll(cachedOutput, Supplier::get, function, map);
    }

    private record Output(Map<Item, ClientItem> items) implements ItemModelOutput {

        @Override
        public void accept(Item item, ItemModel.Unbaked unbaked) {
            this.items.put(item, new ClientItem(unbaked, ClientItem.Properties.DEFAULT));
        }

        @Override
        public void copy(Item item, Item item1) {
            throw new UnsupportedOperationException();
        }
    }
}
