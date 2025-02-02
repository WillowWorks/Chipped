package earth.terrarium.chipped.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialLanternBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    private final VoxelShape toEast;
    private final VoxelShape toNorth;

    public static final VoxelShape CHONK_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    public static final VoxelShape THICC_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    public static final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
    public static final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
    public static final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);

    public SpecialLanternBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
        this.toEast = shape;
        this.toNorth = shape;
    }

    public SpecialLanternBlock(Properties properties, VoxelShape toEast, VoxelShape toNorth) {
        super(properties);
        this.toEast = toEast;
        this.toNorth = toNorth;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getShape(blockState);
    }

    public VoxelShape getShape(BlockState state) {
        Direction direction = state.getValue(FACING);
        if (direction == Direction.EAST || direction == Direction.WEST) {
            return this.toEast;
        } else {
            return this.toNorth;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = this.defaultBlockState();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction[] directions = context.getNearestLookingDirections();

        for (var direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(level, blockpos)) {
                    return blockstate.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
                }
            }
        }
        return null;
    }



    @Override
    protected @NotNull BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, tickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
}
