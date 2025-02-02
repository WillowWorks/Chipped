package earth.terrarium.chipped.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Actual;

import java.util.function.Supplier;

public class ChippedClientActual {
    @Actual
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), type);
    }
}
