package earth.terrarium.chipped.datagen.provider.base;

import com.google.gson.JsonObject;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public abstract class LangProvider implements DataProvider {

    private final Map<String, String> translations = new TreeMap<>();
    private final PackOutput output;
    private final String mod;
    private final String locale;

    public LangProvider(PackOutput output, String mod, String locale) {
        this.output = output;
        this.mod = mod;
        this.locale = locale;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        this.addTranslations();

        JsonObject json = new JsonObject();
        this.translations.forEach(json::addProperty);

        var path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
            .resolve(this.mod)
            .resolve("lang")
            .resolve(this.locale + ".json");

        return DataProvider.saveStable(cache, json, path);
    }

    protected abstract void addTranslations();

    public void addItem(RegistryEntry<Item> item, String name) {
        this.translations.put(item.get().getDescriptionId(), name);
    }

    public void addBlock(RegistryEntry<Block> block, String name) {
        this.translations.put(block.get().getDescriptionId(), name);
    }

    public void add(String key, String value) {
        this.translations.put(key, value);
    }

    @Override
    public String getName() {
        return "";
    }
}
