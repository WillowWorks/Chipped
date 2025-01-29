package earth.terrarium.chipped.client.screens;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teamresourceful.resourcefullib.common.exceptions.NotImplementedException;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Objects;
import java.util.Set;

public class FakeLevel implements BlockAndTintGetter {
    @Nullable
    private BlockState state;
    @Nullable
    private Set<BlockPos> positions;

    public static final Vector3f SCENE_LIGHT_1 = new Vector3f(1, 0, 1);
    public static final Vector3f SCENE_LIGHT_2 = new Vector3f(-1, 1, -1);

    @Override
    public float getShade(Direction direction, boolean shade) {
        return 1;
    }

    @Override
    public LevelLightEngine getLightEngine() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBlockTint(BlockPos blockPos, ColorResolver colorResolver) {
        return Objects.requireNonNull(Minecraft.getInstance().level)
            .getBlockTint(blockPos, colorResolver);
    }

    @Override
    public int getBrightness(LightLayer lightType, BlockPos blockPos) {
        return 15;
    }

    @Override
    public int getRawBrightness(BlockPos blockPos, int amount) {
        return 15;
    }

    @Nullable
    @Override
    public BlockEntity getBlockEntity(BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getBlockState(BlockPos pos) {
        return (state != null && positions != null && positions.contains(pos)) ? state : Blocks.AIR.defaultBlockState();
    }

    @Override
    public FluidState getFluidState(BlockPos pos) {
        return Blocks.AIR.defaultBlockState().getFluidState();
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    public void setState(BlockState state) {
        this.state = state;
    }

    public void setPositions(Set<BlockPos> positions) {
        this.positions = positions;
    }

    public void renderBlock(PoseStack poseStack) {
        if (state == null || positions == null) return;
        Minecraft mc = Minecraft.getInstance();
        BlockRenderDispatcher dispatcher = mc.getBlockRenderer();
        MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();
        RenderType renderType = ItemBlockRenderTypes.getRenderType(state);
        VertexConsumer consumer = bufferSource.getBuffer(renderType);

        RenderSystem.setupGui3DDiffuseLighting(SCENE_LIGHT_1, SCENE_LIGHT_2);

        positions.forEach(pos -> {
            poseStack.pushPose();
            poseStack.translate(pos.getX(), pos.getY(), pos.getZ());
            renderBatched(
                dispatcher,
                state,
                pos,
                this,
                poseStack,
                consumer,
                true,
                Objects.requireNonNull(mc.level).random,
                renderType
            );
            poseStack.popPose();
        });
        bufferSource.endBatch();
        Lighting.setupFor3DItems();
    }

    @ExpectPlatform
    public static void renderBatched(BlockRenderDispatcher dispatcher, BlockState state, BlockPos pos, BlockAndTintGetter level, PoseStack poseStack, VertexConsumer consumer, boolean checkSides, RandomSource random, RenderType type) {
        throw new NotImplementedException();
    }
}
