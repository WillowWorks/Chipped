package earth.terrarium.chipped.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import earth.terrarium.athena.api.client.neoforge.AthenaBakedModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.msrandom.multiplatform.annotations.Actual;
import net.neoforged.neoforge.client.model.data.ModelData;

public class FakeLevelActual {
    @Actual
    public static void renderBatched(BlockRenderDispatcher dispatcher, BlockState state, BlockPos pos, BlockAndTintGetter level, PoseStack poseStack, VertexConsumer consumer, boolean checkSides, RandomSource random, RenderType type) {
        BakedModel blockModel = dispatcher.getBlockModel(state);
        if (blockModel instanceof AthenaBakedModel) {
            dispatcher.renderBatched(state, pos, level, poseStack, consumer, checkSides, random, blockModel.getModelData(level, pos, state, ModelData.EMPTY), type);
        } else {
            dispatcher.renderBatched(state, pos, level, poseStack, consumer, checkSides, random);
        }
    }
}
