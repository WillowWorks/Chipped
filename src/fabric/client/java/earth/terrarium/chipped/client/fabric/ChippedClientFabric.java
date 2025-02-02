package earth.terrarium.chipped.client.fabric;

import earth.terrarium.chipped.client.ChippedClient;
import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class ChippedClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChippedClient.init();
        MenuScreens.register(ModMenuTypes.WORKBENCH.get(), WorkbenchScreen::new);
    }
}
