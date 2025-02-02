package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.network.Network;
import earth.terrarium.chipped.Chipped;
import net.minecraft.resources.ResourceLocation;

public class NetworkHandler {

    public static final Network CHANNEL = new Network(ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "main"), 1);

    public static void init() {
        CHANNEL.register(ServerboundCraftPacket.TYPE);
    }
}
