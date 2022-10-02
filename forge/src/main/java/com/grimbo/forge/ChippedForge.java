package com.grimbo.forge;

import dev.architectury.platform.forge.EventBuses;
import com.grimbo.chipped.Chipped;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class ChippedForge {
    public ChippedForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Chipped.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Chipped.init();
    }
}
