package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.lib.Constants;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.blocks.DirectionBlock;
import earth.terrarium.chipped.common.blocks.SpecialLanternBlock;
import earth.terrarium.chipped.common.blocks.SpecialPointedDripstoneBlock;
import earth.terrarium.chipped.common.blocks.WorkbenchBlock;
import earth.terrarium.chipped.common.palette.IdType;
import earth.terrarium.chipped.common.palette.Palette;
import earth.terrarium.chipped.common.palette.Palettes;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Locale;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {

    public static final Function<BlockBehaviour.Properties, Block> DEFAULT_CREATOR = Block::new;

    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, Chipped.MOD_ID);
    public static final ResourcefulBlockRegistry BENCHES = ResourcefulRegistries.createForBlocks(ResourcefulRegistries.create(BLOCKS));

    public static final TagKey<Block> SOUL_SAND_TAG = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "soul_sand"));

    public static final RegistryEntry<Block> BOTANIST_WORKBENCH = BENCHES.register("botanist_workbench", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> GLASSBLOWER = BENCHES.register("glassblower", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CARPENTERS_TABLE = BENCHES.register("carpenters_table", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> LOOM_TABLE = BENCHES.register("loom_table", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MASON_TABLE = BENCHES.register("mason_table", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> ALCHEMY_BENCH = BENCHES.register("alchemy_bench", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TINKERING_TABLE = BENCHES.register("tinkering_table", WorkbenchBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());

    public static final ChippedPaletteRegistry AMETHYST_BLOCK = createRegistry(Blocks.AMETHYST_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry COAL_BLOCK = createRegistry(Blocks.COAL_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry CRYING_OBSIDIAN = createRegistry(Blocks.CRYING_OBSIDIAN, Palettes.STONE);
    public static final ChippedPaletteRegistry LODESTONE = createRegistry(Blocks.LODESTONE, Palettes.LODESTONE);
    public static final ChippedPaletteRegistry LAPIS_BLOCK = createRegistry(Blocks.LAPIS_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry DIAMOND_BLOCK = createRegistry(Blocks.DIAMOND_BLOCK, Palettes.DIAMOND_BLOCK);
    public static final ChippedPaletteRegistry EMERALD_BLOCK = createRegistry(Blocks.EMERALD_BLOCK, Palettes.EMERALD_BLOCK);
    public static final ChippedPaletteRegistry GOLD_BLOCK = createRegistry(Blocks.GOLD_BLOCK, Palettes.DIAMOND_BLOCK);
    public static final ChippedPaletteRegistry IRON_BLOCK = createRegistry(Blocks.IRON_BLOCK, Palettes.METAL);
    public static final ChippedPaletteRegistry NETHERITE_BLOCK = createRegistry(Blocks.NETHERITE_BLOCK, Palettes.NETHERITE_BLOCK);
    public static final ChippedPaletteRegistry SPONGE = createRegistry(Blocks.SPONGE, Palettes.SPONGE, SpongeBlock::new);
    public static final ChippedPaletteRegistry GLOWSTONE = createRegistry(Blocks.GLOWSTONE, Palettes.GLOWSTONE);
    public static final ChippedPaletteRegistry WAXED_COPPER_BLOCK = createRegistry(Blocks.WAXED_COPPER_BLOCK, Palettes.COPPER_BLOCK);
    public static final ChippedPaletteRegistry WAXED_EXPOSED_COPPER = createRegistry(Blocks.WAXED_EXPOSED_COPPER, Palettes.COPPER_BLOCK);
    public static final ChippedPaletteRegistry WAXED_WEATHERED_COPPER = createRegistry(Blocks.WAXED_WEATHERED_COPPER, Palettes.COPPER_BLOCK);
    public static final ChippedPaletteRegistry WAXED_OXIDIZED_COPPER = createRegistry(Blocks.WAXED_OXIDIZED_COPPER, Palettes.COPPER_BLOCK);

    public static final ChippedPaletteRegistry BLUE_ICE = createRegistry(Blocks.BLUE_ICE, Palettes.STONE);
    public static final ChippedPaletteRegistry DIRT = createRegistry(Blocks.DIRT, Palettes.STONE);
    public static final ChippedPaletteRegistry ICE = createRegistry(Blocks.ICE, Palettes.STONE);
    public static final ChippedPaletteRegistry PACKED_ICE = createRegistry(Blocks.PACKED_ICE, Palettes.STONE);
    public static final ChippedPaletteRegistry SNOW_BLOCK = createRegistry(Blocks.SNOW_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry CLAY = createRegistry(Blocks.CLAY, Palettes.CLAY);
    public static final ChippedPaletteRegistry MUD = createRegistry(Blocks.MUD, Palettes.MUD);
    public static final ChippedPaletteRegistry PACKED_MUD = createRegistry(Blocks.PACKED_MUD, Palettes.MUD);
    public static final ChippedPaletteRegistry ACACIA_LEAVES = createRegistry(Blocks.ACACIA_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry BIRCH_LEAVES = createRegistry(Blocks.BIRCH_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry DARK_OAK_LEAVES = createRegistry(Blocks.DARK_OAK_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry JUNGLE_LEAVES = createRegistry(Blocks.JUNGLE_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry MANGROVE_ROOTS = createRegistry(Blocks.MANGROVE_ROOTS, Palettes.ROOTS, MangroveRootsBlock::new);
    public static final ChippedPaletteRegistry OAK_LEAVES = createRegistry(Blocks.OAK_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry SPRUCE_LEAVES = createRegistry(Blocks.SPRUCE_LEAVES, Palettes.LEAVES, LeavesBlock::new);
    public static final ChippedPaletteRegistry OCHRE_FROGLIGHT = createRegistry(Blocks.OCHRE_FROGLIGHT, Palettes.FROGLIGHT);
    public static final ChippedPaletteRegistry PEARLESCENT_FROGLIGHT = createRegistry(Blocks.PEARLESCENT_FROGLIGHT, Palettes.FROGLIGHT);
    public static final ChippedPaletteRegistry VERDANT_FROGLIGHT = createRegistry(Blocks.VERDANT_FROGLIGHT, Palettes.FROGLIGHT);
    public static final ChippedPaletteRegistry BONE_BLOCK = createRegistry(Blocks.BONE_BLOCK, Palettes.BONE_BLOCK, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry BROWN_MUSHROOM_BLOCK = createRegistry(Blocks.BROWN_MUSHROOM_BLOCK, Palettes.MUSHROOM_BLOCK);
    public static final ChippedPaletteRegistry RED_MUSHROOM_BLOCK = createRegistry(Blocks.RED_MUSHROOM_BLOCK, Palettes.RED_MUSHROOM_BLOCK);
    public static final ChippedPaletteRegistry BROWN_MUSHROOM = createRegistry(Blocks.BROWN_MUSHROOM, Palettes.MUSHROOM, b -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, b));
    public static final ChippedPaletteRegistry RED_MUSHROOM = createRegistry(Blocks.RED_MUSHROOM, Palettes.MUSHROOM, b -> new MushroomBlock(TreeFeatures.HUGE_RED_MUSHROOM, b));
    public static final ChippedPaletteRegistry COBWEB = createRegistry(Blocks.COBWEB, Palettes.COBWEB, WebBlock::new);
    public static final ChippedPaletteRegistry MUSHROOM_STEM = createRegistry(Blocks.MUSHROOM_STEM, Palettes.MUSHROOM_STEM, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry GRAVEL = createRegistry(Blocks.GRAVEL, Palettes.GRAVEL, p -> new ColoredFallingBlock(new ColorRGBA(0xff807c7b), p));
    public static final ChippedPaletteRegistry HAY_BLOCK = createRegistry(Blocks.HAY_BLOCK, Palettes.HAY_BLOCK, HayBlock::new);
    public static final ChippedPaletteRegistry MOSS_BLOCK = createRegistry(Blocks.MOSS_BLOCK, Palettes.MOSS_BLOCK, props -> new BonemealableFeaturePlacerBlock(CaveFeatures.MOSS_PATCH_BONEMEAL, props));
    public static final ChippedPaletteRegistry MELON = createRegistry(Blocks.MELON, Palettes.MELON);
    public static final ChippedPaletteRegistry SHROOMLIGHT = createRegistry(Blocks.SHROOMLIGHT, Palettes.SHROOMLIGHT);
    public static final ChippedPaletteRegistry SAND = createRegistry(Blocks.SAND, Palettes.SAND, p -> new ColoredFallingBlock(new ColorRGBA(0xdbd3a0), p));
    public static final ChippedPaletteRegistry SOUL_SAND = createRegistry(Blocks.SOUL_SAND, Palettes.SOUL_SAND, SoulSandBlock::new);
    public static final ChippedPaletteRegistry CRIMSON_ROOTS = createRegistry(Blocks.CRIMSON_ROOTS, Palettes.CRIMSON_ROOTS, RootsBlock::new);
    public static final ChippedPaletteRegistry WARPED_ROOTS = createRegistry(Blocks.WARPED_ROOTS, Palettes.WARPED_ROOTS, RootsBlock::new);
    public static final ChippedPaletteRegistry DRIED_KELP_BLOCK = createRegistry(Blocks.DRIED_KELP_BLOCK, Palettes.DRIED_KELP_BLOCK);
    public static final ChippedPaletteRegistry LILY_PAD = createRegistry(Blocks.LILY_PAD, Palettes.LILY_PAD, WaterlilyBlock::new, PlaceOnWaterBlockItem::new);
    public static final ChippedPaletteRegistry NETHER_SPROUTS = createRegistry(Blocks.NETHER_SPROUTS, Palettes.NETHER_SPROUTS);
    public static final ChippedPaletteRegistry NETHER_WART_BLOCK = createRegistry(Blocks.NETHER_WART_BLOCK, Palettes.WART_BLOCK);
    public static final ChippedPaletteRegistry PUMPKIN = createRegistry(Blocks.PUMPKIN, Palettes.PUMPKIN, PumpkinBlock::new);
    public static final ChippedPaletteRegistry CARVED_PUMPKIN = createRegistry(Blocks.CARVED_PUMPKIN, Palettes.CARVED_PUMPKIN, CarvedPumpkinBlock::new);
    public static final ChippedPaletteRegistry JACK_O_LANTERN = createRegistry(Blocks.JACK_O_LANTERN, Palettes.CARVED_PUMPKIN, CarvedPumpkinBlock::new);
    public static final ChippedPaletteRegistry VINE = createRegistry(Blocks.VINE, Palettes.VINE, VineBlock::new);
    public static final ChippedPaletteRegistry WARPED_WART_BLOCK = createRegistry(Blocks.WARPED_WART_BLOCK, Palettes.WART_BLOCK);
    public static final ChippedPaletteRegistry CRIMSON_FUNGUS = createRegistry(Blocks.CRIMSON_FUNGUS, Palettes.MUSHROOM);
    public static final ChippedPaletteRegistry WARPED_FUNGUS = createRegistry(Blocks.WARPED_FUNGUS, Palettes.WARPED_FUNGUS);

    public static final ChippedPaletteRegistry ACACIA_PLANKS = createRegistry(Blocks.ACACIA_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry BIRCH_PLANKS = createRegistry(Blocks.BIRCH_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry DARK_OAK_PLANKS = createRegistry(Blocks.DARK_OAK_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry JUNGLE_PLANKS = createRegistry(Blocks.JUNGLE_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry MANGROVE_PLANKS = createRegistry(Blocks.MANGROVE_PLANKS, Palettes.MANGROVE_PLANKS);
    public static final ChippedPaletteRegistry OAK_PLANKS = createRegistry(Blocks.OAK_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry SPRUCE_PLANKS = createRegistry(Blocks.SPRUCE_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry CRIMSON_PLANKS = createRegistry(Blocks.CRIMSON_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry WARPED_PLANKS = createRegistry(Blocks.WARPED_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry CHERRY_PLANKS = createRegistry(Blocks.CHERRY_PLANKS, Palettes.PLANKS);
    public static final ChippedPaletteRegistry BAMBOO_PLANKS = createRegistry(Blocks.BAMBOO_PLANKS, Palettes.BAMBOO_PLANKS);
    public static final ChippedPaletteRegistry ACACIA_LOG = createRegistry(Blocks.ACACIA_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry BIRCH_LOG = createRegistry(Blocks.BIRCH_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry DARK_OAK_LOG = createRegistry(Blocks.DARK_OAK_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry JUNGLE_LOG = createRegistry(Blocks.JUNGLE_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry MANGROVE_LOG = createRegistry(Blocks.MANGROVE_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry OAK_LOG = createRegistry(Blocks.OAK_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry SPRUCE_LOG = createRegistry(Blocks.SPRUCE_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry CRIMSON_STEM = createRegistry(Blocks.CRIMSON_STEM, Palettes.CRIMSON_STEM, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry WARPED_STEM = createRegistry(Blocks.WARPED_STEM, Palettes.WARPED_STEM, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry CHERRY_LOG = createRegistry(Blocks.CHERRY_LOG, Palettes.LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry BARREL = createRegistry(Blocks.BARREL, Palettes.BARREL, BarrelBlock::new);
    public static final ChippedPaletteRegistry BOOKSHELF = createRegistry(Blocks.BOOKSHELF, Palettes.BOOKSHELF);
    public static final ChippedPaletteRegistry LADDER = createRegistry(Blocks.LADDER, Palettes.LADDER, LadderBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_ACACIA_LOG = createRegistry(Blocks.STRIPPED_ACACIA_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_BIRCH_LOG = createRegistry(Blocks.STRIPPED_BIRCH_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_DARK_OAK_LOG = createRegistry(Blocks.STRIPPED_DARK_OAK_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_JUNGLE_LOG = createRegistry(Blocks.STRIPPED_JUNGLE_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_MANGROVE_LOG = createRegistry(Blocks.STRIPPED_MANGROVE_LOG, Palettes.STRIPPED_MANGROVE_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_OAK_LOG = createRegistry(Blocks.STRIPPED_OAK_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_SPRUCE_LOG = createRegistry(Blocks.STRIPPED_SPRUCE_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_WARPED_STEM = createRegistry(Blocks.STRIPPED_WARPED_STEM, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_CRIMSON_STEM = createRegistry(Blocks.STRIPPED_CRIMSON_STEM, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry STRIPPED_CHERRY_LOG = createRegistry(Blocks.STRIPPED_CHERRY_LOG, Palettes.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ChippedPaletteRegistry ACACIA_DOOR = createRegistry(Blocks.ACACIA_DOOR, Palettes.ACACIA_DOOR, props -> new DoorBlock(BlockSetType.ACACIA, props));
    public static final ChippedPaletteRegistry BIRCH_DOOR = createRegistry(Blocks.BIRCH_DOOR, Palettes.BIRCH_DOOR, props -> new DoorBlock(BlockSetType.BIRCH, props));
    public static final ChippedPaletteRegistry DARK_OAK_DOOR = createRegistry(Blocks.DARK_OAK_DOOR, Palettes.DARK_OAK_DOOR, props -> new DoorBlock(BlockSetType.DARK_OAK, props));
    public static final ChippedPaletteRegistry JUNGLE_DOOR = createRegistry(Blocks.JUNGLE_DOOR, Palettes.JUNGLE_DOOR, props -> new DoorBlock(BlockSetType.JUNGLE, props));
    public static final ChippedPaletteRegistry MANGROVE_DOOR = createRegistry(Blocks.MANGROVE_DOOR, Palettes.MANGROVE_DOOR, props -> new DoorBlock(BlockSetType.MANGROVE, props));
    public static final ChippedPaletteRegistry OAK_DOOR = createRegistry(Blocks.OAK_DOOR, Palettes.DOOR, props -> new DoorBlock(BlockSetType.OAK, props));
    public static final ChippedPaletteRegistry SPRUCE_DOOR = createRegistry(Blocks.SPRUCE_DOOR, Palettes.SPRUCE_DOOR, props -> new DoorBlock(BlockSetType.SPRUCE, props));
    public static final ChippedPaletteRegistry CRIMSON_DOOR = createRegistry(Blocks.CRIMSON_DOOR, Palettes.CRIMSON_DOOR, props -> new DoorBlock(BlockSetType.CRIMSON, props));
    public static final ChippedPaletteRegistry WARPED_DOOR = createRegistry(Blocks.WARPED_DOOR, Palettes.WARPED_DOOR, props -> new DoorBlock(BlockSetType.WARPED, props));
    public static final ChippedPaletteRegistry CHERRY_DOOR = createRegistry(Blocks.CHERRY_DOOR, Palettes.CHERRY_DOOR, props -> new DoorBlock(BlockSetType.CHERRY, props));
    public static final ChippedPaletteRegistry BAMBOO_DOOR = createRegistry(Blocks.BAMBOO_DOOR, Palettes.BAMBOO_DOOR, props -> new DoorBlock(BlockSetType.BAMBOO, props));
    public static final ChippedPaletteRegistry ACACIA_TRAPDOOR = createRegistry(Blocks.ACACIA_TRAPDOOR, Palettes.ACACIA_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.ACACIA, props));
    public static final ChippedPaletteRegistry BIRCH_TRAPDOOR = createRegistry(Blocks.BIRCH_TRAPDOOR, Palettes.TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.BIRCH, props));
    public static final ChippedPaletteRegistry DARK_OAK_TRAPDOOR = createRegistry(Blocks.DARK_OAK_TRAPDOOR, Palettes.TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.DARK_OAK, props));
    public static final ChippedPaletteRegistry JUNGLE_TRAPDOOR = createRegistry(Blocks.JUNGLE_TRAPDOOR, Palettes.JUNGLE_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.JUNGLE, props));
    public static final ChippedPaletteRegistry MANGROVE_TRAPDOOR = createRegistry(Blocks.MANGROVE_TRAPDOOR, Palettes.MANGROVE_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.MANGROVE, props));
    public static final ChippedPaletteRegistry OAK_TRAPDOOR = createRegistry(Blocks.OAK_TRAPDOOR, Palettes.OAK_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.OAK, props));
    public static final ChippedPaletteRegistry SPRUCE_TRAPDOOR = createRegistry(Blocks.SPRUCE_TRAPDOOR, Palettes.SPRUCE_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.SPRUCE, props));
    public static final ChippedPaletteRegistry CRIMSON_TRAPDOOR = createRegistry(Blocks.CRIMSON_TRAPDOOR, Palettes.CRIMSON_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.CRIMSON, props));
    public static final ChippedPaletteRegistry WARPED_TRAPDOOR = createRegistry(Blocks.WARPED_TRAPDOOR, Palettes.WARPED_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.WARPED, props));
    public static final ChippedPaletteRegistry CHERRY_TRAPDOOR = createRegistry(Blocks.CHERRY_TRAPDOOR, Palettes.CHERRY_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.CHERRY, props));
    public static final ChippedPaletteRegistry BAMBOO_TRAPDOOR = createRegistry(Blocks.BAMBOO_TRAPDOOR, Palettes.BAMBOO_TRAPDOOR, props -> new TrapDoorBlock(BlockSetType.BAMBOO, props));

    public static final ChippedPaletteRegistry GLASS = createRegistry(Blocks.GLASS, Palettes.GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry GLASS_PANE = createRegistry(Blocks.GLASS_PANE, Palettes.GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry BLACK_STAINED_GLASS = createRegistry(Blocks.BLACK_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry BLACK_STAINED_GLASS_PANE = createRegistry(Blocks.BLACK_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry BLUE_STAINED_GLASS = createRegistry(Blocks.BLUE_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry BLUE_STAINED_GLASS_PANE = createRegistry(Blocks.BLUE_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry BROWN_STAINED_GLASS = createRegistry(Blocks.BROWN_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry BROWN_STAINED_GLASS_PANE = createRegistry(Blocks.BROWN_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry CYAN_STAINED_GLASS = createRegistry(Blocks.CYAN_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry CYAN_STAINED_GLASS_PANE = createRegistry(Blocks.CYAN_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry GRAY_STAINED_GLASS = createRegistry(Blocks.GRAY_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry GRAY_STAINED_GLASS_PANE = createRegistry(Blocks.GRAY_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry GREEN_STAINED_GLASS = createRegistry(Blocks.GREEN_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry GREEN_STAINED_GLASS_PANE = createRegistry(Blocks.GREEN_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry LIGHT_BLUE_STAINED_GLASS = createRegistry(Blocks.LIGHT_BLUE_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry LIGHT_BLUE_STAINED_GLASS_PANE = createRegistry(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry LIGHT_GRAY_STAINED_GLASS = createRegistry(Blocks.LIGHT_GRAY_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry LIGHT_GRAY_STAINED_GLASS_PANE = createRegistry(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry LIME_STAINED_GLASS = createRegistry(Blocks.LIME_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry LIME_STAINED_GLASS_PANE = createRegistry(Blocks.LIME_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry MAGENTA_STAINED_GLASS = createRegistry(Blocks.MAGENTA_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry MAGENTA_STAINED_GLASS_PANE = createRegistry(Blocks.MAGENTA_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry ORANGE_STAINED_GLASS = createRegistry(Blocks.ORANGE_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry ORANGE_STAINED_GLASS_PANE = createRegistry(Blocks.ORANGE_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry PINK_STAINED_GLASS = createRegistry(Blocks.PINK_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry PINK_STAINED_GLASS_PANE = createRegistry(Blocks.PINK_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry PURPLE_STAINED_GLASS = createRegistry(Blocks.PURPLE_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry PURPLE_STAINED_GLASS_PANE = createRegistry(Blocks.PURPLE_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry RED_STAINED_GLASS = createRegistry(Blocks.RED_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry RED_STAINED_GLASS_PANE = createRegistry(Blocks.RED_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry WHITE_STAINED_GLASS = createRegistry(Blocks.WHITE_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry WHITE_STAINED_GLASS_PANE = createRegistry(Blocks.WHITE_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);
    public static final ChippedPaletteRegistry YELLOW_STAINED_GLASS = createRegistry(Blocks.YELLOW_STAINED_GLASS, Palettes.STAINED_GLASS, p -> new TransparentBlock(p.isValidSpawn(ModBlocks::never)) {});
    public static final ChippedPaletteRegistry YELLOW_STAINED_GLASS_PANE = createRegistry(Blocks.YELLOW_STAINED_GLASS_PANE, Palettes.STAINED_GLASS_PANE, IronBarsBlock::new);

    public static final ChippedPaletteRegistry BLACK_WOOL = createRegistry(Blocks.BLACK_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry BLUE_WOOL = createRegistry(Blocks.BLUE_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry BROWN_WOOL = createRegistry(Blocks.BROWN_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry CYAN_WOOL = createRegistry(Blocks.CYAN_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry GRAY_WOOL = createRegistry(Blocks.GRAY_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry GREEN_WOOL = createRegistry(Blocks.GREEN_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry LIGHT_BLUE_WOOL = createRegistry(Blocks.LIGHT_BLUE_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry LIGHT_GRAY_WOOL = createRegistry(Blocks.LIGHT_GRAY_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry LIME_WOOL = createRegistry(Blocks.LIME_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry MAGENTA_WOOL = createRegistry(Blocks.MAGENTA_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry ORANGE_WOOL = createRegistry(Blocks.ORANGE_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry PINK_WOOL = createRegistry(Blocks.PINK_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry PURPLE_WOOL = createRegistry(Blocks.PURPLE_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry RED_WOOL = createRegistry(Blocks.RED_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry WHITE_WOOL = createRegistry(Blocks.WHITE_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry YELLOW_WOOL = createRegistry(Blocks.YELLOW_WOOL, Palettes.WOOL);
    public static final ChippedPaletteRegistry BLACK_CARPET = createRegistry(Blocks.BLACK_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry BLUE_CARPET = createRegistry(Blocks.BLUE_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry BROWN_CARPET = createRegistry(Blocks.BROWN_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry CYAN_CARPET = createRegistry(Blocks.CYAN_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry GRAY_CARPET = createRegistry(Blocks.GRAY_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry GREEN_CARPET = createRegistry(Blocks.GREEN_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry LIGHT_BLUE_CARPET = createRegistry(Blocks.LIGHT_BLUE_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry LIGHT_GRAY_CARPET = createRegistry(Blocks.LIGHT_GRAY_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry LIME_CARPET = createRegistry(Blocks.LIME_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry MAGENTA_CARPET = createRegistry(Blocks.MAGENTA_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry ORANGE_CARPET = createRegistry(Blocks.ORANGE_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry PINK_CARPET = createRegistry(Blocks.PINK_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry PURPLE_CARPET = createRegistry(Blocks.PURPLE_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry RED_CARPET = createRegistry(Blocks.RED_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry WHITE_CARPET = createRegistry(Blocks.WHITE_CARPET, Palettes.CARPET, CarpetBlock::new);
    public static final ChippedPaletteRegistry YELLOW_CARPET = createRegistry(Blocks.YELLOW_CARPET, Palettes.CARPET, CarpetBlock::new);

    public static final ChippedPaletteRegistry ANCIENT_DEBRIS = createRegistry(Blocks.ANCIENT_DEBRIS, Palettes.STONE);
    public static final ChippedPaletteRegistry ANDESITE = createRegistry(Blocks.ANDESITE, Palettes.STONE);
    public static final ChippedPaletteRegistry BASALT = createRegistry(Blocks.BASALT, Palettes.BASALT);
    public static final ChippedPaletteRegistry BLACKSTONE = createRegistry(Blocks.BLACKSTONE, Palettes.BLACKSTONE);
    public static final ChippedPaletteRegistry CALCITE = createRegistry(Blocks.CALCITE, Palettes.STONE);
    public static final ChippedPaletteRegistry COBBLESTONE = createRegistry(Blocks.COBBLESTONE, Palettes.STONE);
    public static final ChippedPaletteRegistry DARK_PRISMARINE = createRegistry(Blocks.DARK_PRISMARINE, Palettes.DARK_PRISMARINE);
    public static final ChippedPaletteRegistry DEEPSLATE = createRegistry(Blocks.DEEPSLATE, Palettes.DEEPSLATE);
    public static final ChippedPaletteRegistry DIORITE = createRegistry(Blocks.DIORITE, Palettes.STONE);
    public static final ChippedPaletteRegistry DRIPSTONE_BLOCK = createRegistry(Blocks.DRIPSTONE_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry END_STONE = createRegistry(Blocks.END_STONE, Palettes.STONE);
    public static final ChippedPaletteRegistry GILDED_BLACKSTONE = createRegistry(Blocks.GILDED_BLACKSTONE, Palettes.GILDED_BLACKSTONE);
    public static final ChippedPaletteRegistry GRANITE = createRegistry(Blocks.GRANITE, Palettes.STONE);
    public static final ChippedPaletteRegistry MAGMA_BLOCK = createRegistry(Blocks.MAGMA_BLOCK, Palettes.STONE); // Don't use the magma block type because we don't want these blocks to burn you
    public static final ChippedPaletteRegistry MOSSY_COBBLESTONE = createRegistry(Blocks.MOSSY_COBBLESTONE, Palettes.STONE);
    public static final ChippedPaletteRegistry MOSSY_STONE_BRICKS = createRegistry(Blocks.MOSSY_STONE_BRICKS, Palettes.MOSSY_STONE_BRICKS);
    public static final ChippedPaletteRegistry NETHER_BRICKS = createRegistry(Blocks.NETHER_BRICKS, Palettes.STONE);
    public static final ChippedPaletteRegistry NETHERRACK = createRegistry(Blocks.NETHERRACK, Palettes.STONE);
    public static final ChippedPaletteRegistry OBSIDIAN = createRegistry(Blocks.OBSIDIAN, Palettes.STONE);
    public static final ChippedPaletteRegistry PRISMARINE = createRegistry(Blocks.PRISMARINE, Palettes.PRISMARINE);
    public static final ChippedPaletteRegistry PURPUR_BLOCK = createRegistry(Blocks.PURPUR_BLOCK, Palettes.PURPUR_BLOCK);
    public static final ChippedPaletteRegistry QUARTZ_BLOCK = createRegistry(Blocks.QUARTZ_BLOCK, Palettes.QUARTZ_BLOCK);
    public static final ChippedPaletteRegistry RAW_COPPER_BLOCK = createRegistry(Blocks.RAW_COPPER_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry RAW_GOLD_BLOCK = createRegistry(Blocks.RAW_GOLD_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry RAW_IRON_BLOCK = createRegistry(Blocks.RAW_IRON_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry RED_NETHER_BRICKS = createRegistry(Blocks.RED_NETHER_BRICKS, Palettes.STONE);
    public static final ChippedPaletteRegistry RED_SANDSTONE = createRegistry(Blocks.RED_SANDSTONE, Palettes.STONE);
    public static final ChippedPaletteRegistry SANDSTONE = createRegistry(Blocks.SANDSTONE, Palettes.STONE);
    public static final ChippedPaletteRegistry STONE = createRegistry(Blocks.STONE, Palettes.BASE_STONE);
    public static final ChippedPaletteRegistry SMOOTH_STONE = createRegistry(Blocks.SMOOTH_STONE, Palettes.STONE);
    public static final ChippedPaletteRegistry TUFF = createRegistry(Blocks.TUFF, Palettes.STONE);

    public static final ChippedPaletteRegistry TERRACOTTA = createRegistry(Blocks.TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry BLACK_TERRACOTTA = createRegistry(Blocks.BLACK_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry BLUE_TERRACOTTA = createRegistry(Blocks.BLUE_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry BROWN_TERRACOTTA = createRegistry(Blocks.BROWN_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry CYAN_TERRACOTTA = createRegistry(Blocks.CYAN_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry GRAY_TERRACOTTA = createRegistry(Blocks.GRAY_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry GREEN_TERRACOTTA = createRegistry(Blocks.GREEN_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry LIGHT_BLUE_TERRACOTTA = createRegistry(Blocks.LIGHT_BLUE_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry LIGHT_GRAY_TERRACOTTA = createRegistry(Blocks.LIGHT_GRAY_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry LIME_TERRACOTTA = createRegistry(Blocks.LIME_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry MAGENTA_TERRACOTTA = createRegistry(Blocks.MAGENTA_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry ORANGE_TERRACOTTA = createRegistry(Blocks.ORANGE_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry PINK_TERRACOTTA = createRegistry(Blocks.PINK_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry PURPLE_TERRACOTTA = createRegistry(Blocks.PURPLE_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry RED_TERRACOTTA = createRegistry(Blocks.RED_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry WHITE_TERRACOTTA = createRegistry(Blocks.WHITE_TERRACOTTA, Palettes.TERRACOTTA);
    public static final ChippedPaletteRegistry YELLOW_TERRACOTTA = createRegistry(Blocks.YELLOW_TERRACOTTA, Palettes.TERRACOTTA);

    public static final ChippedPaletteRegistry BLACK_GLAZED_TERRACOTTA = createRegistry(Blocks.BLACK_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry BLUE_GLAZED_TERRACOTTA = createRegistry(Blocks.BLUE_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry BROWN_GLAZED_TERRACOTTA = createRegistry(Blocks.BROWN_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry CYAN_GLAZED_TERRACOTTA = createRegistry(Blocks.CYAN_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry GRAY_GLAZED_TERRACOTTA = createRegistry(Blocks.GRAY_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry GREEN_GLAZED_TERRACOTTA = createRegistry(Blocks.GREEN_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry LIGHT_BLUE_GLAZED_TERRACOTTA = createRegistry(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry LIGHT_GRAY_GLAZED_TERRACOTTA = createRegistry(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry LIME_GLAZED_TERRACOTTA = createRegistry(Blocks.LIME_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry MAGENTA_GLAZED_TERRACOTTA = createRegistry(Blocks.MAGENTA_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry ORANGE_GLAZED_TERRACOTTA = createRegistry(Blocks.ORANGE_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry PINK_GLAZED_TERRACOTTA = createRegistry(Blocks.PINK_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry PURPLE_GLAZED_TERRACOTTA = createRegistry(Blocks.PURPLE_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry RED_GLAZED_TERRACOTTA = createRegistry(Blocks.RED_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry WHITE_GLAZED_TERRACOTTA = createRegistry(Blocks.WHITE_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ChippedPaletteRegistry YELLOW_GLAZED_TERRACOTTA = createRegistry(Blocks.YELLOW_GLAZED_TERRACOTTA, Palettes.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);

    public static final ChippedPaletteRegistry BLACK_CONCRETE = createRegistry(Blocks.BLACK_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry BLUE_CONCRETE = createRegistry(Blocks.BLUE_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry BROWN_CONCRETE = createRegistry(Blocks.BROWN_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry CYAN_CONCRETE = createRegistry(Blocks.CYAN_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry GRAY_CONCRETE = createRegistry(Blocks.GRAY_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry GREEN_CONCRETE = createRegistry(Blocks.GREEN_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry LIGHT_BLUE_CONCRETE = createRegistry(Blocks.LIGHT_BLUE_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry LIGHT_GRAY_CONCRETE = createRegistry(Blocks.LIGHT_GRAY_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry LIME_CONCRETE = createRegistry(Blocks.LIME_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry MAGENTA_CONCRETE = createRegistry(Blocks.MAGENTA_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry ORANGE_CONCRETE = createRegistry(Blocks.ORANGE_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry PINK_CONCRETE = createRegistry(Blocks.PINK_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry PURPLE_CONCRETE = createRegistry(Blocks.PURPLE_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry RED_CONCRETE = createRegistry(Blocks.RED_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry WHITE_CONCRETE = createRegistry(Blocks.WHITE_CONCRETE, Palettes.CONCRETE);
    public static final ChippedPaletteRegistry YELLOW_CONCRETE = createRegistry(Blocks.YELLOW_CONCRETE, Palettes.CONCRETE);

    public static final ChippedPaletteRegistry BRICKS = createRegistry(Blocks.BRICKS, Palettes.BRICKS);
    public static final ChippedPaletteRegistry BORDERLESS_BRICKS = registerBorderlessBricks("borderless_bricks", Palettes.BRICKS);
    public static final ChippedPaletteRegistry MUD_BRICKS = createRegistry(Blocks.MUD_BRICKS, Palettes.MUD);
    public static final ChippedPaletteRegistry POINTED_DRIPSTONE = createRegistry(Blocks.POINTED_DRIPSTONE, Palettes.POINTED_DRIPSTONE, SpecialPointedDripstoneBlock::new);

    public static final ChippedPaletteRegistry IRON_BARS = createRegistry(Blocks.IRON_BARS, Palettes.IRON_BARS, IronBarsBlock::new);
    public static final ChippedPaletteRegistry SEA_LANTERN = createRegistry(Blocks.SEA_LANTERN, Palettes.SEA_LANTERN);
    public static final ChippedPaletteRegistry REDSTONE_LAMP = createRegistry(Blocks.REDSTONE_LAMP, Palettes.REDSTONE_LAMP, RedstoneLampBlock::new);
    public static final ChippedPaletteRegistry REDSTONE_BLOCK = createRegistry(Blocks.REDSTONE_BLOCK, Palettes.STONE);
    public static final ChippedPaletteRegistry LANTERN = createRegistry(Blocks.LANTERN, Palettes.LANTERN, LanternBlock::new);
    public static final ChippedPaletteRegistry SOUL_LANTERN = createRegistry(Blocks.SOUL_LANTERN, Palettes.SOUL_LANTERN, LanternBlock::new);
    public static final ChippedPaletteRegistry SPECIAL_LANTERN = registerSpecialLanterns("special_lantern", Palettes.SPECIAL_LANTERN);
    public static final ChippedPaletteRegistry SPECIAL_SOUL_LANTERN = registerSpecialLanterns("special_soul_lantern", Palettes.SPECIAL_SOUL_LANTERN);

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette) {
        return createRegistry(ref, palette, DEFAULT_CREATOR);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType) {
        return createRegistry(ref, palette, blockType, BlockItem::new);
    }

    public static ChippedPaletteRegistry createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType, BiFunction<Block, Item.Properties, BlockItem> itemType) {
        var registry = new ChippedPaletteRegistry(BLOCKS, ref, palette);
        for (var entry : palette.ids()) {
            String id = entry.getSecond().replace("%", BuiltInRegistries.BLOCK.getKey(ref).getPath().toLowerCase(Locale.ROOT));
            IdType type = Objects.requireNonNull(entry.getFirst());
            if (type == IdType.PILLAR) {
                if (blockType != DEFAULT_CREATOR) {
                    Constants.LOGGER.error("ID: {}, Reference: {}, Palette: {}", id, BuiltInRegistries.BLOCK.getKey(ref).getPath(), palette);
                    throw new IllegalArgumentException("Cannot use custom block type with non-default id type");
                }
                registry.register(id, RotatedPillarBlock::new, () -> createProperties(ref));
            } else if (type == IdType.DIRECTIONAL) {
                registry.register(id, DirectionBlock::new, () -> createProperties(ref));
            } else {
                registry.register(id, blockType, () -> createProperties(ref));
            }
        }
        ModItems.createItemRegistry(registry, itemType);
        return registry;
    }

    public static ChippedPaletteRegistry registerSpecialLanterns(String block, Palette palette) {
        var registry = new ChippedPaletteRegistry(BLOCKS, Blocks.LANTERN, palette);
        registry.register(palette.get(0).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.CHONK_LANTERN_SHAPE), () -> createProperties(Blocks.LANTERN));
        registry.register(palette.get(1).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.DONUT_LANTERN_SHAPE_EAST, SpecialLanternBlock.DONUT_LANTERN_SHAPE_NORTH), () -> createProperties(Blocks.LANTERN));
        registry.register(palette.get(2).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.TALL_LANTERN_SHAPE), () -> createProperties(Blocks.LANTERN));
        registry.register(palette.get(3).replace("%", block), (properties) -> new SpecialLanternBlock(properties, SpecialLanternBlock.THICC_LANTERN_SHAPE), () -> createProperties(Blocks.LANTERN));
        ModItems.createItemRegistry(registry, BlockItem::new);
        return registry;
    }

    public static ChippedPaletteRegistry registerBorderlessBricks(String block, Palette palette) {
        var registry = new ChippedPaletteRegistry(BLOCKS, Blocks.BRICKS, block, palette);
        for (var entry : palette.ids()) {
            String id = entry.getSecond().replace("%", block);
            if (Objects.requireNonNull(entry.getFirst()) == IdType.PILLAR) {
                registry.register(id, RotatedPillarBlock::new, () -> createProperties(Blocks.BRICKS));
            } else {
                registry.register(id, Block::new, () -> createProperties(Blocks.BRICKS));
            }
        }
        ModItems.createItemRegistry(registry, BlockItem::new);
        return registry;
    }

    private static BlockBehaviour.Properties createProperties(Block ref) {
        return BlockBehaviour.Properties.ofFullCopy(ref).noLootTable();
    }

    private static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entity) {
        return false;
    }
}
