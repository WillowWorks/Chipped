package earth.terrarium.chipped.neoforge;

import earth.terrarium.chipped.Chipped;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Chipped.MOD_ID)
public class ChippedDebug {

    public ChippedDebug(IEventBus bus) {
        if (FMLLoader.isProduction()) return;

        var registries = DeferredRegister.create(BuiltInRegistries.CHUNK_GENERATOR, Chipped.MOD_ID);
        registries.register("debug", () -> ChippedDebugLevelSource.CODEC);
        registries.register(bus);
    }
}
