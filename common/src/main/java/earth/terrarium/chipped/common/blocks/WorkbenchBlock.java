package earth.terrarium.chipped.common.blocks;

import com.mojang.serialization.MapCodec;
import earth.terrarium.chipped.common.menus.WorkbenchMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class WorkbenchBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<WorkbenchBlock> CODEC = simpleCodec(WorkbenchBlock::new);

    public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model", WorkbenchModelType.class);

    public WorkbenchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(MODEL_TYPE, WorkbenchModelType.MAIN));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MODEL_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        player.openMenu(new WorkbenchMenuProvider(getName()));
        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide) {
            super.playerWillDestroy(level, pos, state, player);
            return state;
        }

        WorkbenchModelType workbenchModel = state.getValue(MODEL_TYPE);
        if (workbenchModel == WorkbenchModelType.MAIN) {
            BlockPos otherpos = pos.relative(state.getValue(FACING).getClockWise());
            BlockState otherstate = level.getBlockState(otherpos);
            if (otherstate.getBlock() == this) {
                level.setBlock(otherpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, otherpos, Block.getId(otherstate));
            }
        }
        if (workbenchModel == WorkbenchModelType.SIDE) {
            BlockPos otherpos = pos.relative(state.getValue(FACING).getCounterClockWise());
            BlockState otherstate = level.getBlockState(otherpos);
            if (otherstate.getBlock() == this) {
                level.setBlock(otherpos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, otherpos, Block.getId(otherstate));
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            BlockPos blockpos = pos.relative(state.getValue(FACING).getClockWise());
            level.setBlock(blockpos, state.setValue(MODEL_TYPE, WorkbenchModelType.SIDE), Block.UPDATE_ALL);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, Block.UPDATE_ALL);
        }
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return state.getValue(MODEL_TYPE) == WorkbenchModelType.MAIN ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Deprecated
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getClockWise())).canBeReplaced();
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    public enum WorkbenchModelType implements StringRepresentable {
        MAIN, SIDE;

        @Override
        public @NotNull String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }
}