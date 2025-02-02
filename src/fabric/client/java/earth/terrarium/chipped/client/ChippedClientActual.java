package earth.terrarium.chipped.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Actual;

import java.util.function.Supplier;

public class ChippedClientActual {
    @Actual
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block.get(), type);
    }
}
