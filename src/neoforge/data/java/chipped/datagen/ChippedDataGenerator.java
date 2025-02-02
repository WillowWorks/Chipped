package chipped.datagen;

import earth.terrarium.chipped.datagen.provider.MinifiedProvider;
import earth.terrarium.chipped.datagen.provider.client.ModLangProvider;
import earth.terrarium.chipped.datagen.provider.server.ModBlockTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModItemTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModLootTableProvider;
import earth.terrarium.chipped.datagen.provider.server.ModRecipeProvider;
import earth.terrarium.chipped.Chipped;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Chipped.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ChippedDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        gatherClientData(event);
        gatherServerData(event);
    }

    private static void gatherClientData(GatherDataEvent event) {
        addProvider(event, ModLangProvider::new);
    }

    private static void gatherServerData(GatherDataEvent event) {
        var blockTags = addProvider(event, ModBlockTagProvider::new);
        addProvider(event, (out, lookup) -> new ModItemTagProvider(out, lookup, blockTags.contentsGetter()));
        addProvider(event, ModLootTableProvider::new);
        addProvider(event, ModRecipeProvider.Runner::new);
    }

    private static void addProvider(GatherDataEvent event, GatherDataEvent.DataProviderFromOutput<DataProvider> provider) {
        event.<DataProvider>createProvider(output -> new MinifiedProvider(provider.create(output)));
    }

    private static <T extends DataProvider> T addProvider(GatherDataEvent event, GatherDataEvent.DataProviderFromOutputLookup<T> factory) {
        var provider = factory.create(event.getGenerator().getPackOutput(), event.getLookupProvider());
        event.addProvider(new MinifiedProvider(provider));
        return provider;
    }
}
