package earth.terrarium.chipped.common.registry;

import com.google.common.collect.Iterables;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;

import java.util.List;

public class ModBlockRegistries {

    public static final Iterable<ChippedPaletteRegistry> WOOL = List.of(
        ModBlocks.BLACK_WOOL, ModBlocks.BLUE_WOOL, ModBlocks.BROWN_WOOL, ModBlocks.CYAN_WOOL,
        ModBlocks.GRAY_WOOL, ModBlocks.GREEN_WOOL, ModBlocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_GRAY_WOOL,
        ModBlocks.LIME_WOOL, ModBlocks.MAGENTA_WOOL, ModBlocks.ORANGE_WOOL, ModBlocks.PINK_WOOL,
        ModBlocks.PURPLE_WOOL, ModBlocks.RED_WOOL, ModBlocks.WHITE_WOOL, ModBlocks.YELLOW_WOOL
    );

    public static final Iterable<ChippedPaletteRegistry> CARPET = List.of(
        ModBlocks.BLACK_CARPET, ModBlocks.BLUE_CARPET, ModBlocks.BROWN_CARPET, ModBlocks.CYAN_CARPET,
        ModBlocks.GRAY_CARPET, ModBlocks.GREEN_CARPET, ModBlocks.LIGHT_BLUE_CARPET, ModBlocks.LIGHT_GRAY_CARPET,
        ModBlocks.LIME_CARPET, ModBlocks.MAGENTA_CARPET, ModBlocks.ORANGE_CARPET, ModBlocks.PINK_CARPET,
        ModBlocks.PURPLE_CARPET, ModBlocks.RED_CARPET, ModBlocks.WHITE_CARPET, ModBlocks.YELLOW_CARPET
    );

    public static final Iterable<ChippedPaletteRegistry> CONCRETE = List.of(
        ModBlocks.BLACK_CONCRETE, ModBlocks.BLUE_CONCRETE, ModBlocks.BROWN_CONCRETE, ModBlocks.CYAN_CONCRETE,
        ModBlocks.GRAY_CONCRETE, ModBlocks.GREEN_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE,
        ModBlocks.LIME_CONCRETE, ModBlocks.MAGENTA_CONCRETE, ModBlocks.ORANGE_CONCRETE, ModBlocks.PINK_CONCRETE,
        ModBlocks.PURPLE_CONCRETE, ModBlocks.RED_CONCRETE, ModBlocks.WHITE_CONCRETE, ModBlocks.YELLOW_CONCRETE
    );

    public static final Iterable<ChippedPaletteRegistry> TERRACOTTA = List.of(
        ModBlocks.TERRACOTTA, ModBlocks.BLACK_TERRACOTTA, ModBlocks.BLUE_TERRACOTTA, ModBlocks.BROWN_TERRACOTTA,
        ModBlocks.CYAN_TERRACOTTA, ModBlocks.GRAY_TERRACOTTA, ModBlocks.GREEN_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA,
        ModBlocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIME_TERRACOTTA, ModBlocks.MAGENTA_TERRACOTTA, ModBlocks.ORANGE_TERRACOTTA,
        ModBlocks.PINK_TERRACOTTA, ModBlocks.PURPLE_TERRACOTTA, ModBlocks.RED_TERRACOTTA, ModBlocks.WHITE_TERRACOTTA,
        ModBlocks.YELLOW_TERRACOTTA
    );

    public static final Iterable<ChippedPaletteRegistry> GLAZED_TERRACOTTA = List.of(
        ModBlocks.BLACK_GLAZED_TERRACOTTA, ModBlocks.BLUE_GLAZED_TERRACOTTA, ModBlocks.BROWN_GLAZED_TERRACOTTA, ModBlocks.CYAN_GLAZED_TERRACOTTA,
        ModBlocks.GRAY_GLAZED_TERRACOTTA, ModBlocks.GREEN_GLAZED_TERRACOTTA, ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA, ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
        ModBlocks.LIME_GLAZED_TERRACOTTA, ModBlocks.MAGENTA_GLAZED_TERRACOTTA, ModBlocks.ORANGE_GLAZED_TERRACOTTA, ModBlocks.PINK_GLAZED_TERRACOTTA,
        ModBlocks.PURPLE_GLAZED_TERRACOTTA, ModBlocks.RED_GLAZED_TERRACOTTA, ModBlocks.WHITE_GLAZED_TERRACOTTA, ModBlocks.YELLOW_GLAZED_TERRACOTTA
    );

    public static final Iterable<ChippedPaletteRegistry> PLANK = List.of(
        ModBlocks.ACACIA_PLANKS, ModBlocks.BIRCH_PLANKS, ModBlocks.CRIMSON_PLANKS, ModBlocks.DARK_OAK_PLANKS,
        ModBlocks.JUNGLE_PLANKS, ModBlocks.OAK_PLANKS, ModBlocks.SPRUCE_PLANKS, ModBlocks.WARPED_PLANKS,
        ModBlocks.MANGROVE_PLANKS, ModBlocks.BAMBOO_PLANKS, ModBlocks.CHERRY_PLANKS
    );

    public static final Iterable<ChippedPaletteRegistry> LOG = List.of(
        ModBlocks.ACACIA_LOG, ModBlocks.BIRCH_LOG, ModBlocks.CRIMSON_STEM, ModBlocks.DARK_OAK_LOG,
        ModBlocks.JUNGLE_LOG, ModBlocks.OAK_LOG, ModBlocks.SPRUCE_LOG, ModBlocks.WARPED_STEM,
        ModBlocks.MANGROVE_LOG, ModBlocks.CHERRY_LOG
    );

    public static final Iterable<ChippedPaletteRegistry> STRIPPED_LOG = List.of(
        ModBlocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_CRIMSON_STEM, ModBlocks.STRIPPED_DARK_OAK_LOG,
        ModBlocks.STRIPPED_JUNGLE_LOG, ModBlocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_WARPED_STEM,
        ModBlocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_CHERRY_LOG
    );

    public static final Iterable<ChippedPaletteRegistry> WOOD_DOOR = List.of(
        ModBlocks.ACACIA_DOOR, ModBlocks.BIRCH_DOOR, ModBlocks.CRIMSON_DOOR, ModBlocks.DARK_OAK_DOOR,
        ModBlocks.JUNGLE_DOOR, ModBlocks.OAK_DOOR, ModBlocks.SPRUCE_DOOR, ModBlocks.WARPED_DOOR,
        ModBlocks.MANGROVE_DOOR, ModBlocks.BAMBOO_DOOR, ModBlocks.CHERRY_DOOR
    );

    public static final Iterable<ChippedPaletteRegistry> WOOD_TRAPDOOR = List.of(
        ModBlocks.ACACIA_TRAPDOOR, ModBlocks.BIRCH_TRAPDOOR, ModBlocks.CRIMSON_TRAPDOOR, ModBlocks.DARK_OAK_TRAPDOOR,
        ModBlocks.JUNGLE_TRAPDOOR, ModBlocks.OAK_TRAPDOOR, ModBlocks.SPRUCE_TRAPDOOR, ModBlocks.WARPED_TRAPDOOR,
        ModBlocks.MANGROVE_TRAPDOOR, ModBlocks.BAMBOO_TRAPDOOR, ModBlocks.CHERRY_TRAPDOOR
    );

    public static final Iterable<ChippedPaletteRegistry> GLASS = List.of(
        ModBlocks.GLASS, ModBlocks.BLACK_STAINED_GLASS, ModBlocks.BLUE_STAINED_GLASS, ModBlocks.BROWN_STAINED_GLASS,
        ModBlocks.CYAN_STAINED_GLASS, ModBlocks.GRAY_STAINED_GLASS, ModBlocks.GREEN_STAINED_GLASS, ModBlocks.LIGHT_BLUE_STAINED_GLASS,
        ModBlocks.LIGHT_GRAY_STAINED_GLASS, ModBlocks.LIME_STAINED_GLASS, ModBlocks.MAGENTA_STAINED_GLASS, ModBlocks.ORANGE_STAINED_GLASS,
        ModBlocks.PINK_STAINED_GLASS, ModBlocks.PURPLE_STAINED_GLASS, ModBlocks.RED_STAINED_GLASS, ModBlocks.WHITE_STAINED_GLASS,
        ModBlocks.YELLOW_STAINED_GLASS
    );

    public static final Iterable<ChippedPaletteRegistry> GLASS_PANE = List.of(
        ModBlocks.GLASS_PANE, ModBlocks.BLACK_STAINED_GLASS_PANE, ModBlocks.BLUE_STAINED_GLASS_PANE, ModBlocks.BROWN_STAINED_GLASS_PANE,
        ModBlocks.CYAN_STAINED_GLASS_PANE, ModBlocks.GRAY_STAINED_GLASS_PANE, ModBlocks.GREEN_STAINED_GLASS_PANE, ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE,
        ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, ModBlocks.LIME_STAINED_GLASS_PANE, ModBlocks.MAGENTA_STAINED_GLASS_PANE, ModBlocks.ORANGE_STAINED_GLASS_PANE,
        ModBlocks.PINK_STAINED_GLASS_PANE, ModBlocks.PURPLE_STAINED_GLASS_PANE, ModBlocks.RED_STAINED_GLASS_PANE, ModBlocks.WHITE_STAINED_GLASS_PANE,
        ModBlocks.YELLOW_STAINED_GLASS_PANE
    );

    public static final Iterable<ChippedPaletteRegistry> STONE = List.of(
        ModBlocks.STONE, ModBlocks.ANDESITE, ModBlocks.DIORITE, ModBlocks.GRANITE, ModBlocks.COBBLESTONE,
        ModBlocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_STONE_BRICKS, ModBlocks.SMOOTH_STONE, ModBlocks.TUFF,
        ModBlocks.BASALT, ModBlocks.BLACKSTONE, ModBlocks.DEEPSLATE, ModBlocks.DRIPSTONE_BLOCK,
        ModBlocks.CALCITE
    );

    public static final Iterable<ChippedPaletteRegistry> GROUND = List.of(
        ModBlocks.GRAVEL, ModBlocks.DIRT, ModBlocks.CLAY, ModBlocks.SAND, ModBlocks.MUD, ModBlocks.PACKED_MUD
    );

    public static final Iterable<ChippedPaletteRegistry> MATERIALS = List.of(
        ModBlocks.COAL_BLOCK, ModBlocks.IRON_BLOCK, ModBlocks.GOLD_BLOCK, ModBlocks.DIAMOND_BLOCK, ModBlocks.EMERALD_BLOCK,
        ModBlocks.LAPIS_BLOCK, ModBlocks.REDSTONE_BLOCK, ModBlocks.QUARTZ_BLOCK, ModBlocks.NETHERITE_BLOCK, ModBlocks.AMETHYST_BLOCK,
        ModBlocks.WAXED_COPPER_BLOCK, ModBlocks.WAXED_EXPOSED_COPPER, ModBlocks.WAXED_OXIDIZED_COPPER, ModBlocks.WAXED_WEATHERED_COPPER
    );

    public static final Iterable<ChippedPaletteRegistry> RAW_ORES = List.of(
        ModBlocks.RAW_COPPER_BLOCK, ModBlocks.RAW_IRON_BLOCK, ModBlocks.RAW_GOLD_BLOCK, ModBlocks.ANCIENT_DEBRIS
    );

    public static final Iterable<ChippedPaletteRegistry> LEAVES = List.of(
        ModBlocks.ACACIA_LEAVES, ModBlocks.BIRCH_LEAVES, ModBlocks.DARK_OAK_LEAVES, ModBlocks.JUNGLE_LEAVES,
        ModBlocks.OAK_LEAVES, ModBlocks.SPRUCE_LEAVES
    );

    public static final Iterable<ChippedPaletteRegistry> LIGHTS = List.of(
        ModBlocks.SHROOMLIGHT, ModBlocks.GLOWSTONE, ModBlocks.REDSTONE_LAMP, ModBlocks.SEA_LANTERN,
        ModBlocks.OCHRE_FROGLIGHT, ModBlocks.PEARLESCENT_FROGLIGHT, ModBlocks.VERDANT_FROGLIGHT
    );

    public static final Iterable<ChippedPaletteRegistry> VEGITATION = List.of(
        ModBlocks.LILY_PAD, ModBlocks.NETHER_SPROUTS, ModBlocks.CRIMSON_FUNGUS, ModBlocks.CRIMSON_ROOTS,
        ModBlocks.WARPED_FUNGUS, ModBlocks.WARPED_ROOTS
    );

    public static final Iterable<ChippedPaletteRegistry> FLAT_ITEMS = Iterables.concat(
        VEGITATION,
        List.of(ModBlocks.COBWEB, ModBlocks.LADDER)
    );

    public static final Iterable<ChippedPaletteRegistry> FULL_BLOCKS = Iterables.concat(
        WOOL, CONCRETE, GLAZED_TERRACOTTA, TERRACOTTA, PLANK, LOG, STRIPPED_LOG, GLASS, STONE, GROUND, MATERIALS, RAW_ORES, LEAVES, LIGHTS,
        List.of(ModBlocks.BRICKS, ModBlocks.BORDERLESS_BRICKS, ModBlocks.MUD_BRICKS),
        List.of(ModBlocks.HAY_BLOCK, ModBlocks.MOSS_BLOCK, ModBlocks.BONE_BLOCK, ModBlocks.MANGROVE_ROOTS),
        List.of(ModBlocks.BROWN_MUSHROOM_BLOCK, ModBlocks.RED_MUSHROOM_BLOCK, ModBlocks.MUSHROOM_STEM),
        List.of(ModBlocks.WARPED_WART_BLOCK, ModBlocks.NETHER_WART_BLOCK, ModBlocks.SOUL_SAND),
        List.of(ModBlocks.SPONGE) // TODO These blocks really shouldn't exist imo - Sophie
    );

}
