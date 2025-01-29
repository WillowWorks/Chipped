package earth.terrarium.chipped.common.blocks;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@MethodsReturnNonnullByDefault
@SuppressWarnings("deprecation")
public class SpecialPointedDripstoneBlock extends Block implements Fallable, SimpleWaterloggedBlock {
    public static final EnumProperty<Direction> TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape TIP_MERGE_SHAPE;
    private static final VoxelShape TIP_SHAPE_UP;
    private static final VoxelShape TIP_SHAPE_DOWN;
    private static final VoxelShape FRUSTUM_SHAPE;
    private static final VoxelShape MIDDLE_SHAPE;
    private static final VoxelShape BASE_SHAPE;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK;

    public SpecialPointedDripstoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP).setValue(THICKNESS, DripstoneThickness.TIP).setValue(WATERLOGGED, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return isValidPointedDripstonePlacement(level, pos, state.getValue(TIP_DIRECTION));
    }

    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction != Direction.UP && direction != Direction.DOWN) {
            return state;
        } else {
            Direction direction2 = state.getValue(TIP_DIRECTION);
            if (direction2 == Direction.DOWN && level.getBlockTicks().hasScheduledTick(currentPos, this)) {
                return state;
            } else if (direction == direction2.getOpposite() && !this.canSurvive(state, level, currentPos)) {
                if (direction2 == Direction.DOWN) {
                    level.scheduleTick(currentPos, this, 2);
                } else {
                    level.scheduleTick(currentPos, this, 1);
                }

                return state;
            } else {
                boolean bl = state.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness dripstoneThickness = calculateDripstoneThickness(level, currentPos, direction2, bl);
                return state.setValue(THICKNESS, dripstoneThickness);
            }
        }
    }

    public void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos blockPos = hit.getBlockPos();
        if (level instanceof ServerLevel serverLevel && projectile.mayInteract(serverLevel, blockPos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6) {
            level.destroyBlock(blockPos, true);
        }

    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (state.getValue(TIP_DIRECTION) == Direction.UP && state.getValue(THICKNESS) == DripstoneThickness.TIP) {
            entity.causeFallDamage(fallDistance + 2.0F, 2.0F, level.damageSources().stalagmite());
        } else {
            super.fallOn(level, state, pos, entity, fallDistance);
        }

    }

    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (canDrip(state)) {
            float f = random.nextFloat();
            if (!(f > 0.12F)) {
                getFluidAboveStalactite(level, pos, state).filter((fluid) -> f < 0.02F || canFillCauldron(fluid)).ifPresent((fluid) -> {
                    spawnDripParticle(level, pos, state, fluid);
                });
            }
        }
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (isStalagmite(state) && !this.canSurvive(state, level, pos)) {
            level.destroyBlock(pos, true);
        } else {
            spawnFallingStalactite(state, level, pos);
        }

    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        maybeFillCauldron(state, level, pos, random.nextFloat());
        if (random.nextFloat() < 0.011377778F && isStalactiteStartPos(state, level, pos)) {
            growStalactiteOrStalagmiteIfPossible(state, level, pos, random);
        }

    }

    @VisibleForTesting
    public static void maybeFillCauldron(BlockState state, ServerLevel level, BlockPos pos, float randChance) {
        if (!(randChance > 0.17578125F) || !(randChance > 0.05859375F)) {
            if (isStalactiteStartPos(state, level, pos)) {
                Fluid fluid = getCauldronFillFluidType(level, pos);
                float f;
                if (fluid == Fluids.WATER) {
                    f = 0.17578125F;
                } else {
                    if (fluid != Fluids.LAVA) {
                        return;
                    }

                    f = 0.05859375F;
                }

                if (!(randChance >= f)) {
                    BlockPos blockPos = findTip(state, level, pos, 11, false);
                    if (blockPos != null) {
                        BlockPos blockPos2 = findFillableCauldronBelowStalactiteTip(level, blockPos, fluid);
                        if (blockPos2 != null) {
                            level.levelEvent(1504, blockPos, 0);
                            int i = blockPos.getY() - blockPos2.getY();
                            int j = 50 + i;
                            BlockState blockState = level.getBlockState(blockPos2);
                            level.scheduleTick(blockPos2, blockState.getBlock(), j);
                        }
                    }
                }
            }
        }
    }

    public @NotNull PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelAccessor levelAccessor = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Direction direction = context.getNearestLookingVerticalDirection().getOpposite();
        Direction direction2 = calculateTipDirection(levelAccessor, blockPos, direction);
        if (direction2 == null) {
            return null;
        } else {
            boolean bl = !context.isSecondaryUseActive();
            DripstoneThickness dripstoneThickness = calculateDripstoneThickness(levelAccessor, blockPos, direction2, bl);
            return dripstoneThickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction2).setValue(THICKNESS, dripstoneThickness).setValue(WATERLOGGED, levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER);
        }
    }

    @SuppressWarnings("deprecation")
    public @NotNull FluidState getFluidState(BlockState state) {
        return (Boolean) state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public @NotNull VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        DripstoneThickness dripstoneThickness = state.getValue(THICKNESS);
        VoxelShape voxelShape;
        if (dripstoneThickness == DripstoneThickness.TIP_MERGE) {
            voxelShape = TIP_MERGE_SHAPE;
        } else if (dripstoneThickness == DripstoneThickness.TIP) {
            if (state.getValue(TIP_DIRECTION) == Direction.DOWN) {
                voxelShape = TIP_SHAPE_DOWN;
            } else {
                voxelShape = TIP_SHAPE_UP;
            }
        } else if (dripstoneThickness == DripstoneThickness.FRUSTUM) {
            voxelShape = FRUSTUM_SHAPE;
        } else if (dripstoneThickness == DripstoneThickness.MIDDLE) {
            voxelShape = MIDDLE_SHAPE;
        } else {
            voxelShape = BASE_SHAPE;
        }

        Vec3 vec3 = state.getOffset(pos);
        return voxelShape.move(vec3.x, 0.0, vec3.z);
    }

    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    public BlockBehaviour.@NotNull OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    public float getMaxHorizontalOffset() {
        return 0.125F;
    }

    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        if (!fallingBlock.isSilent()) {
            level.levelEvent(1045, pos, 0);
        }

    }

    public @NotNull Predicate<Entity> getHurtsEntitySelector() {
        return EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
    }

    private static void spawnFallingStalactite(BlockState state, ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        for (BlockState blockState = state; isStalactite(blockState); blockState = level.getBlockState(mutableBlockPos)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(level, mutableBlockPos, blockState);
            if (isTip(blockState, true)) {
                int i = Math.max(1 + pos.getY() - mutableBlockPos.getY(), 6);
                float f = (float) i;
                fallingBlockEntity.setHurtsEntities(f, 40);
                break;
            }

            mutableBlockPos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        BlockState blockState = level.getBlockState(pos.above(1));
        BlockState blockState2 = level.getBlockState(pos.above(2));
        if (canGrow(blockState, blockState2)) {
            BlockPos blockPos = findTip(state, level, pos, 7, false);
            if (blockPos != null) {
                BlockState blockState3 = level.getBlockState(blockPos);
                if (canDrip(blockState3) && canTipGrow(blockState3, level, blockPos)) {
                    if (random.nextBoolean()) {
                        grow(level, blockPos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(level, blockPos);
                    }

                }
            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        for (int i = 0; i < 10; ++i) {
            mutableBlockPos.move(Direction.DOWN);
            BlockState blockState = level.getBlockState(mutableBlockPos);
            if (!blockState.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockState, Direction.UP) && canTipGrow(blockState, level, mutableBlockPos)) {
                grow(level, mutableBlockPos, Direction.UP);
                return;
            }

            if (isValidPointedDripstonePlacement(level, mutableBlockPos, Direction.UP) && !level.isWaterAt(mutableBlockPos.below())) {
                grow(level, mutableBlockPos.below(), Direction.UP);
                return;
            }

            if (!canDripThrough(level, mutableBlockPos, blockState)) {
                return;
            }
        }

    }

    private static void grow(ServerLevel server, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.relative(direction);
        BlockState blockState = server.getBlockState(blockPos);
        if (isUnmergedTipWithDirection(blockState, direction.getOpposite())) {
            createMergedTips(blockState, server, blockPos);
        } else if (blockState.isAir() || blockState.is(Blocks.WATER)) {
            createDripstone(server, blockPos, direction, DripstoneThickness.TIP);
        }

    }

    private static void createDripstone(LevelAccessor level, BlockPos pos, Direction direction, DripstoneThickness thickness) {
        if (level.getBlockState(pos).getBlock() instanceof SpecialPointedDripstoneBlock block) {
            BlockState blockState = block.defaultBlockState().setValue(TIP_DIRECTION, direction).setValue(THICKNESS, thickness).setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER);
            level.setBlock(pos, blockState, Block.UPDATE_ALL);
        }
    }

    private static void createMergedTips(BlockState state, LevelAccessor level, BlockPos pos) {
        BlockPos blockPos2;
        BlockPos blockPos;
        if (state.getValue(TIP_DIRECTION) == Direction.UP) {
            blockPos = pos;
            blockPos2 = pos.above();
        } else {
            blockPos2 = pos;
            blockPos = pos.below();
        }

        createDripstone(level, blockPos2, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createDripstone(level, blockPos, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    @SuppressWarnings("deprecation")
    private static void spawnDripParticle(Level level, BlockPos pos, BlockState state, Fluid fluid) {
        Vec3 vec3 = state.getOffset(pos);
        double e = (double) pos.getX() + 0.5 + vec3.x;
        double f = (double) ((float) (pos.getY() + 1) - 0.6875F) - 0.0625;
        double g = (double) pos.getZ() + 0.5 + vec3.z;
        Fluid fluid2 = getDripFluid(level, fluid);
        ParticleOptions particleOptions = fluid2.is(FluidTags.LAVA) ? ParticleTypes.DRIPPING_DRIPSTONE_LAVA : ParticleTypes.DRIPPING_DRIPSTONE_WATER;
        level.addParticle(particleOptions, e, f, g, 0.0, 0.0, 0.0);
    }

    @Nullable
    private static BlockPos findTip(BlockState state, LevelAccessor level, BlockPos pos, int maxIterations, boolean isTipMerge) {
        if (isTip(state, isTipMerge)) {
            return pos;
        } else {
            Direction direction = state.getValue(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> blockState.getBlock() instanceof SpecialPointedDripstoneBlock && blockState.getValue(TIP_DIRECTION) == direction;
            return findBlockVertical(level, pos, direction.getAxisDirection(), biPredicate, (blockState) -> isTip(blockState, isTipMerge), maxIterations).orElse(null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction dir) {
        Direction direction;
        if (isValidPointedDripstonePlacement(level, pos, dir)) {
            direction = dir;
        } else {
            if (!isValidPointedDripstonePlacement(level, pos, dir.getOpposite())) {
                return null;
            }

            direction = dir.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateDripstoneThickness(LevelReader level, BlockPos pos, Direction dir, boolean isTipMerge) {
        Direction direction = dir.getOpposite();
        BlockState blockState = level.getBlockState(pos.relative(dir));
        if (isPointedDripstoneWithDirection(blockState, direction)) {
            return !isTipMerge && blockState.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isPointedDripstoneWithDirection(blockState, dir)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness dripstoneThickness = blockState.getValue(THICKNESS);
            if (dripstoneThickness != DripstoneThickness.TIP && dripstoneThickness != DripstoneThickness.TIP_MERGE) {
                BlockState blockState2 = level.getBlockState(pos.relative(direction));
                return !isPointedDripstoneWithDirection(blockState2, dir) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    public static boolean canDrip(BlockState state) {
        return isStalactite(state) && state.getValue(THICKNESS) == DripstoneThickness.TIP && !(Boolean) state.getValue(WATERLOGGED);
    }

    private static boolean canTipGrow(BlockState state, ServerLevel level, BlockPos pos) {
        Direction direction = state.getValue(TIP_DIRECTION);
        BlockPos blockPos = pos.relative(direction);
        BlockState blockState = level.getBlockState(blockPos);
        if (!blockState.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockState.isAir() || isUnmergedTipWithDirection(blockState, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState state, int maxIterations) {
        Direction direction = state.getValue(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> blockState.getBlock() instanceof SpecialPointedDripstoneBlock && blockState.getValue(TIP_DIRECTION) == direction;
        return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), biPredicate, (blockState) -> !(blockState.getBlock() instanceof SpecialPointedDripstoneBlock), maxIterations);
    }

    private static boolean isValidPointedDripstonePlacement(LevelReader level, BlockPos pos, Direction dir) {
        BlockPos blockPos = pos.relative(dir.getOpposite());
        BlockState blockState = level.getBlockState(blockPos);
        return blockState.isFaceSturdy(level, blockPos, dir) || isPointedDripstoneWithDirection(blockState, dir);
    }

    private static boolean isTip(BlockState state, boolean isTipMerge) {
        if (!(state.getBlock() instanceof SpecialPointedDripstoneBlock)) {
            return false;
        } else {
            DripstoneThickness dripstoneThickness = state.getValue(THICKNESS);
            return dripstoneThickness == DripstoneThickness.TIP || isTipMerge && dripstoneThickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState state, Direction dir) {
        return isTip(state, false) && state.getValue(TIP_DIRECTION) == dir;
    }

    private static boolean isStalactite(BlockState state) {
        return isPointedDripstoneWithDirection(state, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState state) {
        return isPointedDripstoneWithDirection(state, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState state, LevelReader level, BlockPos pos) {
        return isStalactite(state) && !(level.getBlockState(pos.above()).getBlock() instanceof SpecialPointedDripstoneBlock);
    }

    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    private static boolean isPointedDripstoneWithDirection(BlockState state, Direction dir) {
        return state.getBlock() instanceof SpecialPointedDripstoneBlock && state.getValue(TIP_DIRECTION) == dir;
    }

    @Nullable
    private static BlockPos findFillableCauldronBelowStalactiteTip(Level level, BlockPos pos, Fluid fluid) {
        Predicate<BlockState> predicate = (blockState) -> blockState.getBlock() instanceof CauldronBlock;
        BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> canDripThrough(level, blockPos, blockState);
        return findBlockVertical(level, pos, Direction.DOWN.getAxisDirection(), biPredicate, predicate, 11).orElse(null);
    }

    public static Fluid getCauldronFillFluidType(Level level, BlockPos pos) {
        return getFluidAboveStalactite(level, pos, level.getBlockState(pos)).filter(SpecialPointedDripstoneBlock::canFillCauldron).orElse(Fluids.EMPTY);
    }

    private static Optional<Fluid> getFluidAboveStalactite(Level level, BlockPos pos, BlockState state) {
        return !isStalactite(state) ? Optional.empty() : findRootBlock(level, pos, state, 11).map((blockPos) -> level.getFluidState(blockPos.above()).getType());
    }

    private static boolean canFillCauldron(Fluid fluid) {
        return fluid == Fluids.LAVA || fluid == Fluids.WATER;
    }

    private static boolean canGrow(BlockState dripstoneState, BlockState state) {
        return dripstoneState.is(Blocks.DRIPSTONE_BLOCK) && state.is(Blocks.WATER) && state.getFluidState().isSource();
    }

    private static Fluid getDripFluid(Level level, Fluid fluid) {
        if (fluid.isSame(Fluids.EMPTY)) {
            return level.dimensionType().ultraWarm() ? Fluids.LAVA : Fluids.WATER;
        } else {
            return fluid;
        }
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axis, BiPredicate<BlockPos, BlockState> positionalStatePredicate, Predicate<BlockState> statePredicate, int maxIterations) {
        Direction direction = Direction.get(axis, Direction.Axis.Y);
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        for (int i = 1; i < maxIterations; ++i) {
            mutableBlockPos.move(direction);
            BlockState blockState = level.getBlockState(mutableBlockPos);
            if (statePredicate.test(blockState)) {
                return Optional.of(mutableBlockPos.immutable());
            }

            if (level.isOutsideBuildHeight(mutableBlockPos.getY()) || !positionalStatePredicate.test(mutableBlockPos, blockState)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState state) {
        if (state.isAir()) {
            return true;
        } else if (state.isSolidRender()) {
            return false;
        } else if (!state.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape voxelShape = state.getCollisionShape(level, pos);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelShape, BooleanOp.AND);
        }
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        TIP_MERGE_SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
        TIP_SHAPE_UP = Block.box(5.0, 0.0, 5.0, 11.0, 11.0, 11.0);
        TIP_SHAPE_DOWN = Block.box(5.0, 5.0, 5.0, 11.0, 16.0, 11.0);
        FRUSTUM_SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
        MIDDLE_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
        BASE_SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
        REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    }
}
