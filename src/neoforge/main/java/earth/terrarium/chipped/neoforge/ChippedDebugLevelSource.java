package earth.terrarium.chipped.neoforge;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.Mth;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ChippedDebugLevelSource extends ChunkGenerator {

    public static final MapCodec<ChippedDebugLevelSource> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
        RegistryOps.retrieveElement(Biomes.PLAINS)
    ).apply(instance, ChippedDebugLevelSource::new));

    private final List<Entry> entries;
    private final List<BlockState> states;

    private final int gridWidth;
    private final int gridHeight;

    public ChippedDebugLevelSource(Holder.Reference<Biome> biome) {
        super(new FixedBiomeSource(biome));

        this.entries = ChippedPaletteRegistry.REGISTRIES.stream()
            .map(registry -> new Entry(registry, registry.boundStream()
                .flatMap(block -> block.getStateDefinition().getPossibleStates().stream())
                .filter(ChippedDebugLevelSource::isAllowedState)
                .toList())
            )
            .toList();

        this.states = this.entries.stream()
            .flatMap(entry -> entry.states.stream())
            .toList();

        this.gridWidth = Mth.ceil(Mth.sqrt(this.states.size()));
        this.gridHeight = Mth.ceil(this.states.size() / (double) this.gridWidth);
    }

    @Override
    protected @NotNull MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyBiomeDecoration(@NotNull WorldGenLevel level, ChunkAccess chunk, @NotNull StructureManager structures) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        ChunkPos chunkpos = chunk.getPos();
        int chunkX = chunkpos.x;
        int chunkZ = chunkpos.z;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int blockX = SectionPos.sectionToBlockCoord(chunkX, x);
                int blockZ = SectionPos.sectionToBlockCoord(chunkZ, z);
                level.setBlock(blockpos$mutableblockpos.set(blockX, 60, blockZ), Blocks.BARRIER.defaultBlockState(), 2);
                BlockState blockstate = getBlockstateAt(blockX, blockZ);
                setBlock(level, blockpos$mutableblockpos.set(blockX, 70, blockZ), blockstate);
            }
        }
    }

    // region Unused methods

    public void buildSurface(WorldGenRegion p_223978_, StructureManager p_223979_, RandomState p_223980_, ChunkAccess p_223981_) {
    }

    public CompletableFuture<ChunkAccess> fillFromNoise(Blender p_223992_, RandomState p_223993_, StructureManager p_223994_, ChunkAccess p_223995_) {
        return CompletableFuture.completedFuture(p_223995_);
    }

    public int getBaseHeight(int p_223964_, int p_223965_, Heightmap.Types p_223966_, LevelHeightAccessor p_223967_, RandomState p_223968_) {
        return 0;
    }

    public NoiseColumn getBaseColumn(int p_223959_, int p_223960_, LevelHeightAccessor p_223961_, RandomState p_223962_) {
        return new NoiseColumn(0, new BlockState[0]);
    }

    public void addDebugScreenInfo(List<String> p_223987_, RandomState p_223988_, BlockPos p_223989_) {
    }

    public void applyCarvers(WorldGenRegion p_223970_, long p_223971_, RandomState p_223972_, BiomeManager p_223973_, StructureManager p_223974_, ChunkAccess p_223975_) {
    }

    public void spawnOriginalMobs(WorldGenRegion p_188511_) {
    }

    public int getMinY() {
        return 0;
    }

    public int getGenDepth() {
        return 384;
    }

    public int getSeaLevel() {
        return 63;
    }

    // endregion

    private BlockState getBlockstateAt(int x, int z) {
        if (x > 0 && z > 0 && x % 2 != 0 && z % 2 != 0) {
            x /= 2;
            z /= 2;

            if (z < this.entries.size()) {
                return this.entries.get(z).get(x);
            }
        } else if (x < 0 && z < 0 && x % 2 != 0 && z % 2 != 0) {
            x = Math.abs(x);
            z = Math.abs(z);

            x /= 2;
            z /= 2;

            if (x <= gridWidth && z <= gridHeight) {
                int i = Mth.abs(x * gridWidth + z);
                if (i < this.states.size()) {
                    return this.states.get(i);
                }
            }
        }
        return Blocks.AIR.defaultBlockState();
    }

    private static void setBlock(WorldGenLevel level, BlockPos pos, BlockState state) {
        int flag = Block.UPDATE_CLIENTS;
        level.setBlock(pos, state, flag);
        if (pos.getX() == 0) return;

        if (state.hasProperty(BlockStateProperties.AXIS) && state.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) {
            level.setBlock(pos.above(), state, flag);
            level.setBlock(pos.above(2), state, flag);
        } else if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF)) {
            level.setBlock(pos.above(), state.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), flag);
        }
    }

    private static boolean isAllowedState(BlockState state) {
        if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) return false;
        if (state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) && state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.UPPER) return false;
        return true;
    }

    private record Entry(ChippedPaletteRegistry registry, List<BlockState> states) {

        public BlockState get(int index) {
            if (index < 0) return Blocks.AIR.defaultBlockState();
            if (index > this.states.size()) return Blocks.AIR.defaultBlockState();

            return index == 0 ? this.registry.getBase().defaultBlockState() : this.states.get(index - 1);
        }
    }
}
