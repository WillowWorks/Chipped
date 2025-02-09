package earth.terrarium.chipped.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ModBlockTagProvider extends BlockTagsProvider {

    public static final TagKey<Item> ALCHEMY_BENCH_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "alchemy_bench"));
    public static final TagKey<Item> BOTANIST_WORKBENCH_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "botanist_workbench"));
    public static final TagKey<Item> CARPENTERS_TABLE_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "carpenters_table"));
    public static final TagKey<Item> GLASSBLOWER_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "glassblower"));
    public static final TagKey<Item> LOOM_TABLE_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "loom_table"));
    public static final TagKey<Item> MASON_TABLE_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "mason_table"));
    public static final TagKey<Item> TINKERING_TABLE_TAG = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "tinkering_table"));

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chipped.MOD_ID);
    }

    public static void registerTags(BlockRegistry registry) {
        registry.register(Blocks.AMETHYST_BLOCK, ModBlocks.AMETHYST_BLOCK, "amethyst_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.COAL_BLOCK, ModBlocks.COAL_BLOCK, "coal_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.CRYING_OBSIDIAN, ModBlocks.CRYING_OBSIDIAN, "crying_obsidian", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LODESTONE, ModBlocks.LODESTONE, "lodestone", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LAPIS_BLOCK, ModBlocks.LAPIS_BLOCK, "lapis_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DIAMOND_BLOCK, ModBlocks.DIAMOND_BLOCK, "diamond_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.EMERALD_BLOCK, ModBlocks.EMERALD_BLOCK, "emerald_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GOLD_BLOCK, ModBlocks.GOLD_BLOCK, "gold_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.IRON_BLOCK, ModBlocks.IRON_BLOCK, "iron_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.NETHERITE_BLOCK, ModBlocks.NETHERITE_BLOCK, "netherite_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SPONGE, ModBlocks.SPONGE, "sponge", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.GLOWSTONE, ModBlocks.GLOWSTONE, "glowstone", ALCHEMY_BENCH_TAG);
        registry.register(Blocks.WAXED_COPPER_BLOCK, ModBlocks.WAXED_COPPER_BLOCK, "waxed_copper_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WAXED_EXPOSED_COPPER, ModBlocks.WAXED_EXPOSED_COPPER, "waxed_exposed_copper_block", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WAXED_WEATHERED_COPPER, ModBlocks.WAXED_WEATHERED_COPPER, "waxed_weathered_copper", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WAXED_OXIDIZED_COPPER, ModBlocks.WAXED_OXIDIZED_COPPER, "waxed_oxidized_copper", ALCHEMY_BENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);

        registry.register(Blocks.BLUE_ICE, ModBlocks.BLUE_ICE, "blue_ice", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DIRT, ModBlocks.DIRT, "dirt", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.ICE, ModBlocks.ICE, "ice", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PACKED_ICE, ModBlocks.PACKED_ICE, "packed_ice", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SNOW_BLOCK, ModBlocks.SNOW_BLOCK, "snow_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.CLAY, ModBlocks.CLAY, "clay", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.MUD, ModBlocks.MUD, "mud", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.PACKED_MUD, ModBlocks.PACKED_MUD, "packed_mud", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.ACACIA_LEAVES, ModBlocks.ACACIA_LEAVES, "acacia_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.BIRCH_LEAVES, ModBlocks.BIRCH_LEAVES, "birch_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.DARK_OAK_LEAVES, ModBlocks.DARK_OAK_LEAVES, "dark_oak_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.JUNGLE_LEAVES, ModBlocks.JUNGLE_LEAVES, "jungle_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.MANGROVE_ROOTS, ModBlocks.MANGROVE_ROOTS, "mangrove_roots", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.OAK_LEAVES, ModBlocks.OAK_LEAVES, "oak_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.SPRUCE_LEAVES, ModBlocks.SPRUCE_LEAVES, "spruce_leaves", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.OCHRE_FROGLIGHT, ModBlocks.OCHRE_FROGLIGHT, "ochre_froglight", BOTANIST_WORKBENCH_TAG);
        registry.register(Blocks.PEARLESCENT_FROGLIGHT, ModBlocks.PEARLESCENT_FROGLIGHT, "pearlescent_froglight", BOTANIST_WORKBENCH_TAG);
        registry.register(Blocks.VERDANT_FROGLIGHT, ModBlocks.VERDANT_FROGLIGHT, "verdant_froglight", BOTANIST_WORKBENCH_TAG);
        registry.register(Blocks.BONE_BLOCK, ModBlocks.BONE_BLOCK, "bone_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BROWN_MUSHROOM_BLOCK, ModBlocks.BROWN_MUSHROOM_BLOCK, "brown_mushroom_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.RED_MUSHROOM_BLOCK, ModBlocks.RED_MUSHROOM_BLOCK, "red_mushroom_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BROWN_MUSHROOM, ModBlocks.BROWN_MUSHROOM, "brown_mushroom", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.RED_MUSHROOM, ModBlocks.RED_MUSHROOM, "red_mushroom", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.COBWEB, ModBlocks.COBWEB, "cobweb", BOTANIST_WORKBENCH_TAG);
        registry.register(Blocks.MUSHROOM_STEM, ModBlocks.MUSHROOM_STEM, "mushroom_stem", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.GRAVEL, ModBlocks.GRAVEL, "gravel", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.HAY_BLOCK, ModBlocks.HAY_BLOCK, "hay_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.MOSS_BLOCK, ModBlocks.MOSS_BLOCK, "moss_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.MELON, ModBlocks.MELON, "melon", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.SHROOMLIGHT, ModBlocks.SHROOMLIGHT, "shroomlight", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.SAND, ModBlocks.SAND, "sand", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.SOUL_SAND, ModBlocks.SOUL_SAND, "soul_sand", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_SHOVEL);
        registry.register(Blocks.CRIMSON_ROOTS, ModBlocks.CRIMSON_ROOTS, "crimson_roots", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.WARPED_ROOTS, ModBlocks.WARPED_ROOTS, "warped_roots", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.DRIED_KELP_BLOCK, ModBlocks.DRIED_KELP_BLOCK, "dried_kelp_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.LILY_PAD, ModBlocks.LILY_PAD, "lily_pad", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.NETHER_SPROUTS, ModBlocks.NETHER_SPROUTS, "nether_sprouts", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.NETHER_WART_BLOCK, ModBlocks.NETHER_WART_BLOCK, "nether_wart_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.PUMPKIN, ModBlocks.PUMPKIN, "pumpkin", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CARVED_PUMPKIN, ModBlocks.CARVED_PUMPKIN, "carved_pumpkin", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.JACK_O_LANTERN, ModBlocks.JACK_O_LANTERN, "jack_o_lantern", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.VINE, ModBlocks.VINE, "vine", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.WARPED_WART_BLOCK, ModBlocks.WARPED_WART_BLOCK, "warped_wart_block", BOTANIST_WORKBENCH_TAG, BlockTags.MINEABLE_WITH_HOE);
        registry.register(Blocks.CRIMSON_FUNGUS, ModBlocks.CRIMSON_FUNGUS, "crimson_fungus", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);
        registry.register(Blocks.WARPED_FUNGUS, ModBlocks.WARPED_FUNGUS, "warped_fungus", BOTANIST_WORKBENCH_TAG, BlockTags.SWORD_EFFICIENT);

        registry.register(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANKS, "acacia_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANKS, "birch_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANKS, "dark_oak_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANKS, "jungle_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANKS, "mangrove_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.OAK_PLANKS, ModBlocks.OAK_PLANKS, "oak_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANKS, "spruce_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANKS, "crimson_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANKS, "warped_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANKS, "cherry_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANKS, "bamboo_planks", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.ACACIA_LOG, ModBlocks.ACACIA_LOG, "acacia_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BIRCH_LOG, ModBlocks.BIRCH_LOG, "birch_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_LOG, "dark_oak_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_LOG, "jungle_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_LOG, "mangrove_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.OAK_LOG, ModBlocks.OAK_LOG, "oak_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_LOG, "spruce_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_STEM, "crimson_stem", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.WARPED_STEM, ModBlocks.WARPED_STEM, "warped_stem", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CHERRY_LOG, ModBlocks.CHERRY_LOG, "cherry_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BARREL, ModBlocks.BARREL, "barrel", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BOOKSHELF, ModBlocks.BOOKSHELF, "bookshelf", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.LADDER, ModBlocks.LADDER, "ladder", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_ACACIA_LOG, ModBlocks.STRIPPED_ACACIA_LOG, "stripped_acacia_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_BIRCH_LOG, ModBlocks.STRIPPED_BIRCH_LOG, "stripped_birch_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_OAK_LOG, "stripped_dark_oak_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.STRIPPED_JUNGLE_LOG, "stripped_jungle_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG, "stripped_mangrove_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_OAK_LOG, "stripped_oak_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.STRIPPED_SPRUCE_LOG, "stripped_spruce_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_WARPED_STEM, ModBlocks.STRIPPED_WARPED_STEM, "stripped_warped_stem", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_CRIMSON_STEM, ModBlocks.STRIPPED_CRIMSON_STEM, "stripped_crimson_stem", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.STRIPPED_CHERRY_LOG, ModBlocks.STRIPPED_CHERRY_LOG, "stripped_cherry_log", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.ACACIA_DOOR, ModBlocks.ACACIA_DOOR, "acacia_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BIRCH_DOOR, ModBlocks.BIRCH_DOOR, "birch_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.DARK_OAK_DOOR, ModBlocks.DARK_OAK_DOOR, "dark_oak_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.JUNGLE_DOOR, ModBlocks.JUNGLE_DOOR, "jungle_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.MANGROVE_DOOR, ModBlocks.MANGROVE_DOOR, "mangrove_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.OAK_DOOR, ModBlocks.OAK_DOOR, "oak_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.SPRUCE_DOOR, ModBlocks.SPRUCE_DOOR, "spruce_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CRIMSON_DOOR, ModBlocks.CRIMSON_DOOR, "crimson_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.WARPED_DOOR, ModBlocks.WARPED_DOOR, "warped_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CHERRY_DOOR, ModBlocks.CHERRY_DOOR, "cherry_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BAMBOO_DOOR, ModBlocks.BAMBOO_DOOR, "bamboo_door", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.ACACIA_TRAPDOOR, ModBlocks.ACACIA_TRAPDOOR, "acacia_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BIRCH_TRAPDOOR, ModBlocks.BIRCH_TRAPDOOR, "birch_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.DARK_OAK_TRAPDOOR, ModBlocks.DARK_OAK_TRAPDOOR, "dark_oak_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.JUNGLE_TRAPDOOR, ModBlocks.JUNGLE_TRAPDOOR, "jungle_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.MANGROVE_TRAPDOOR, ModBlocks.MANGROVE_TRAPDOOR, "mangrove_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.OAK_TRAPDOOR, ModBlocks.OAK_TRAPDOOR, "oak_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.SPRUCE_TRAPDOOR, ModBlocks.SPRUCE_TRAPDOOR, "spruce_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CRIMSON_TRAPDOOR, ModBlocks.CRIMSON_TRAPDOOR, "crimson_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.WARPED_TRAPDOOR, ModBlocks.WARPED_TRAPDOOR, "warped_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.CHERRY_TRAPDOOR, ModBlocks.CHERRY_TRAPDOOR, "cherry_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);
        registry.register(Blocks.BAMBOO_TRAPDOOR, ModBlocks.BAMBOO_TRAPDOOR, "bamboo_trapdoor", CARPENTERS_TABLE_TAG, BlockTags.MINEABLE_WITH_AXE);

        registry.register(Blocks.GLASS, ModBlocks.GLASS, "glass", GLASSBLOWER_TAG);
        registry.register(Blocks.GLASS_PANE, ModBlocks.GLASS_PANE, "glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.BLACK_STAINED_GLASS, ModBlocks.BLACK_STAINED_GLASS, "black_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.BLACK_STAINED_GLASS_PANE, ModBlocks.BLACK_STAINED_GLASS_PANE, "black_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.BLUE_STAINED_GLASS, ModBlocks.BLUE_STAINED_GLASS, "blue_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.BLUE_STAINED_GLASS_PANE, ModBlocks.BLUE_STAINED_GLASS_PANE, "blue_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.BROWN_STAINED_GLASS, ModBlocks.BROWN_STAINED_GLASS, "brown_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.BROWN_STAINED_GLASS_PANE, ModBlocks.BROWN_STAINED_GLASS_PANE, "brown_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.CYAN_STAINED_GLASS, ModBlocks.CYAN_STAINED_GLASS, "cyan_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.CYAN_STAINED_GLASS_PANE, ModBlocks.CYAN_STAINED_GLASS_PANE, "cyan_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.GRAY_STAINED_GLASS, ModBlocks.GRAY_STAINED_GLASS, "gray_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.GRAY_STAINED_GLASS_PANE, ModBlocks.GRAY_STAINED_GLASS_PANE, "gray_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.GREEN_STAINED_GLASS, ModBlocks.GREEN_STAINED_GLASS, "green_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.GREEN_STAINED_GLASS_PANE, ModBlocks.GREEN_STAINED_GLASS_PANE, "green_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.LIGHT_BLUE_STAINED_GLASS, ModBlocks.LIGHT_BLUE_STAINED_GLASS, "light_blue_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE, "light_blue_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.LIGHT_GRAY_STAINED_GLASS, ModBlocks.LIGHT_GRAY_STAINED_GLASS, "light_gray_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, "light_gray_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.LIME_STAINED_GLASS, ModBlocks.LIME_STAINED_GLASS, "lime_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.LIME_STAINED_GLASS_PANE, ModBlocks.LIME_STAINED_GLASS_PANE, "lime_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.MAGENTA_STAINED_GLASS, ModBlocks.MAGENTA_STAINED_GLASS, "magenta_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.MAGENTA_STAINED_GLASS_PANE, ModBlocks.MAGENTA_STAINED_GLASS_PANE, "magenta_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.ORANGE_STAINED_GLASS, ModBlocks.ORANGE_STAINED_GLASS, "orange_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.ORANGE_STAINED_GLASS_PANE, ModBlocks.ORANGE_STAINED_GLASS_PANE, "orange_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.PINK_STAINED_GLASS, ModBlocks.PINK_STAINED_GLASS, "pink_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.PINK_STAINED_GLASS_PANE, ModBlocks.PINK_STAINED_GLASS_PANE, "pink_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.PURPLE_STAINED_GLASS, ModBlocks.PURPLE_STAINED_GLASS, "purple_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.PURPLE_STAINED_GLASS_PANE, ModBlocks.PURPLE_STAINED_GLASS_PANE, "purple_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.RED_STAINED_GLASS, ModBlocks.RED_STAINED_GLASS, "red_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.RED_STAINED_GLASS_PANE, ModBlocks.RED_STAINED_GLASS_PANE, "red_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.WHITE_STAINED_GLASS, ModBlocks.WHITE_STAINED_GLASS, "white_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.WHITE_STAINED_GLASS_PANE, ModBlocks.WHITE_STAINED_GLASS_PANE, "white_stained_glass_pane", GLASSBLOWER_TAG);
        registry.register(Blocks.YELLOW_STAINED_GLASS, ModBlocks.YELLOW_STAINED_GLASS, "yellow_stained_glass", GLASSBLOWER_TAG);
        registry.register(Blocks.YELLOW_STAINED_GLASS_PANE, ModBlocks.YELLOW_STAINED_GLASS_PANE, "yellow_stained_glass_pane", GLASSBLOWER_TAG);

        registry.register(Blocks.BLACK_WOOL, ModBlocks.BLACK_WOOL, "black_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.BLUE_WOOL, ModBlocks.BLUE_WOOL, "blue_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.BROWN_WOOL, ModBlocks.BROWN_WOOL, "brown_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.CYAN_WOOL, ModBlocks.CYAN_WOOL, "cyan_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.GRAY_WOOL, ModBlocks.GRAY_WOOL, "gray_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.GREEN_WOOL, ModBlocks.GREEN_WOOL, "green_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_WOOL, "light_blue_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GRAY_WOOL, "light_gray_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.LIME_WOOL, ModBlocks.LIME_WOOL, "lime_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_WOOL, "magenta_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_WOOL, "orange_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.PINK_WOOL, ModBlocks.PINK_WOOL, "pink_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_WOOL, "purple_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.RED_WOOL, ModBlocks.RED_WOOL, "red_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.WHITE_WOOL, ModBlocks.WHITE_WOOL, "white_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_WOOL, "yellow_wool", LOOM_TABLE_TAG);
        registry.register(Blocks.BLACK_CARPET, ModBlocks.BLACK_CARPET, "black_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.BLUE_CARPET, ModBlocks.BLUE_CARPET, "blue_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.BROWN_CARPET, ModBlocks.BROWN_CARPET, "brown_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.CYAN_CARPET, ModBlocks.CYAN_CARPET, "cyan_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.GRAY_CARPET, ModBlocks.GRAY_CARPET, "gray_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.GREEN_CARPET, ModBlocks.GREEN_CARPET, "green_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.LIGHT_BLUE_CARPET, ModBlocks.LIGHT_BLUE_CARPET, "light_blue_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.LIGHT_GRAY_CARPET, ModBlocks.LIGHT_GRAY_CARPET, "light_gray_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.LIME_CARPET, ModBlocks.LIME_CARPET, "lime_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.MAGENTA_CARPET, ModBlocks.MAGENTA_CARPET, "magenta_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.ORANGE_CARPET, ModBlocks.ORANGE_CARPET, "orange_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.PINK_CARPET, ModBlocks.PINK_CARPET, "pink_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.PURPLE_CARPET, ModBlocks.PURPLE_CARPET, "purple_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.RED_CARPET, ModBlocks.RED_CARPET, "red_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.WHITE_CARPET, ModBlocks.WHITE_CARPET, "white_carpet", LOOM_TABLE_TAG);
        registry.register(Blocks.YELLOW_CARPET, ModBlocks.YELLOW_CARPET, "yellow_carpet", LOOM_TABLE_TAG);

        registry.register(Blocks.ANCIENT_DEBRIS, ModBlocks.ANCIENT_DEBRIS, "ancient_debris", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.ANDESITE, ModBlocks.ANDESITE, "andesite", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BASALT, ModBlocks.BASALT, "basalt", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLACKSTONE, ModBlocks.BLACKSTONE, "blackstone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.CALCITE, ModBlocks.CALCITE, "calcite", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.COBBLESTONE, ModBlocks.COBBLESTONE, "cobblestone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DARK_PRISMARINE, ModBlocks.DARK_PRISMARINE, "dark_prismarine", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DEEPSLATE, ModBlocks.DEEPSLATE, "deepslate", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DIORITE, ModBlocks.DIORITE, "diorite", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.DRIPSTONE_BLOCK, ModBlocks.DRIPSTONE_BLOCK, "dripstone_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.END_STONE, ModBlocks.END_STONE, "end_stone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GILDED_BLACKSTONE, ModBlocks.GILDED_BLACKSTONE, "gilded_blackstone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GRANITE, ModBlocks.GRANITE, "granite", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MAGMA_BLOCK, ModBlocks.MAGMA_BLOCK, "magma_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE, "mossy_cobblestone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MOSSY_STONE_BRICKS, ModBlocks.MOSSY_STONE_BRICKS, "mossy_stone_bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.NETHER_BRICKS, ModBlocks.NETHER_BRICKS, "nether_bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.NETHERRACK, ModBlocks.NETHERRACK, "netherrack", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN, "obsidian", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PRISMARINE, ModBlocks.PRISMARINE, "prismarine", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PURPUR_BLOCK, ModBlocks.PURPUR_BLOCK, "purpur_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.QUARTZ_BLOCK, ModBlocks.QUARTZ_BLOCK, "quartz_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RAW_COPPER_BLOCK, ModBlocks.RAW_COPPER_BLOCK, "raw_copper_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RAW_GOLD_BLOCK, ModBlocks.RAW_GOLD_BLOCK, "raw_gold_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RAW_IRON_BLOCK, ModBlocks.RAW_IRON_BLOCK, "raw_iron_block", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RED_NETHER_BRICKS, ModBlocks.RED_NETHER_BRICKS, "red_nether_bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE, "red_sandstone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SANDSTONE, ModBlocks.SANDSTONE, "sandstone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.STONE, ModBlocks.STONE, "stone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SMOOTH_STONE, ModBlocks.SMOOTH_STONE, "smooth_stone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.TUFF, ModBlocks.TUFF, "tuff", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.TERRACOTTA, ModBlocks.TERRACOTTA, "terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLACK_TERRACOTTA, ModBlocks.BLACK_TERRACOTTA, "black_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLUE_TERRACOTTA, ModBlocks.BLUE_TERRACOTTA, "blue_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BROWN_TERRACOTTA, ModBlocks.BROWN_TERRACOTTA, "brown_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.CYAN_TERRACOTTA, ModBlocks.CYAN_TERRACOTTA, "cyan_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GRAY_TERRACOTTA, ModBlocks.GRAY_TERRACOTTA, "gray_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GREEN_TERRACOTTA, ModBlocks.GREEN_TERRACOTTA, "green_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIME_TERRACOTTA, ModBlocks.LIME_TERRACOTTA, "lime_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MAGENTA_TERRACOTTA, ModBlocks.MAGENTA_TERRACOTTA, "magenta_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.ORANGE_TERRACOTTA, ModBlocks.ORANGE_TERRACOTTA, "orange_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PINK_TERRACOTTA, ModBlocks.PINK_TERRACOTTA, "pink_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PURPLE_TERRACOTTA, ModBlocks.PURPLE_TERRACOTTA, "purple_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RED_TERRACOTTA, ModBlocks.RED_TERRACOTTA, "red_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WHITE_TERRACOTTA, ModBlocks.WHITE_TERRACOTTA, "white_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.YELLOW_TERRACOTTA, ModBlocks.YELLOW_TERRACOTTA, "yellow_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLACK_GLAZED_TERRACOTTA, ModBlocks.BLACK_GLAZED_TERRACOTTA, "black_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLUE_GLAZED_TERRACOTTA, ModBlocks.BLUE_GLAZED_TERRACOTTA, "blue_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BROWN_GLAZED_TERRACOTTA, ModBlocks.BROWN_GLAZED_TERRACOTTA, "brown_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.CYAN_GLAZED_TERRACOTTA, ModBlocks.CYAN_GLAZED_TERRACOTTA, "cyan_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GRAY_GLAZED_TERRACOTTA, ModBlocks.GRAY_GLAZED_TERRACOTTA, "gray_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GREEN_GLAZED_TERRACOTTA, ModBlocks.GREEN_GLAZED_TERRACOTTA, "green_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "light_blue_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "light_gray_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIME_GLAZED_TERRACOTTA, ModBlocks.LIME_GLAZED_TERRACOTTA, "lime_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MAGENTA_GLAZED_TERRACOTTA, ModBlocks.MAGENTA_GLAZED_TERRACOTTA, "magenta_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.ORANGE_GLAZED_TERRACOTTA, ModBlocks.ORANGE_GLAZED_TERRACOTTA, "orange_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PINK_GLAZED_TERRACOTTA, ModBlocks.PINK_GLAZED_TERRACOTTA, "pink_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PURPLE_GLAZED_TERRACOTTA, ModBlocks.PURPLE_GLAZED_TERRACOTTA, "purple_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RED_GLAZED_TERRACOTTA, ModBlocks.RED_GLAZED_TERRACOTTA, "red_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WHITE_GLAZED_TERRACOTTA, ModBlocks.WHITE_GLAZED_TERRACOTTA, "white_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.YELLOW_GLAZED_TERRACOTTA, ModBlocks.YELLOW_GLAZED_TERRACOTTA, "yellow_glazed_terracotta", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_CONCRETE, "black_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_CONCRETE, "blue_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_CONCRETE, "brown_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_CONCRETE, "cyan_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_CONCRETE, "gray_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_CONCRETE, "green_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_CONCRETE, "light_blue_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_CONCRETE, "light_gray_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LIME_CONCRETE, ModBlocks.LIME_CONCRETE, "lime_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_CONCRETE, "magenta_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_CONCRETE, "orange_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PINK_CONCRETE, ModBlocks.PINK_CONCRETE, "pink_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_CONCRETE, "purple_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.RED_CONCRETE, ModBlocks.RED_CONCRETE, "red_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_CONCRETE, "white_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_CONCRETE, "yellow_concrete", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BRICKS, ModBlocks.BRICKS, "bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.BRICKS, ModBlocks.BORDERLESS_BRICKS, "borderless_bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.MUD_BRICKS, ModBlocks.MUD_BRICKS, "mud_bricks", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.POINTED_DRIPSTONE, ModBlocks.POINTED_DRIPSTONE, "pointed_dripstone", MASON_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);

        registry.register(Blocks.IRON_BARS, ModBlocks.IRON_BARS, "iron_bars", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SEA_LANTERN, ModBlocks.SEA_LANTERN, "sea_lantern", TINKERING_TABLE_TAG);
        registry.register(Blocks.REDSTONE_LAMP, ModBlocks.REDSTONE_LAMP, "redstone_lamp", TINKERING_TABLE_TAG);
        registry.register(Blocks.REDSTONE_BLOCK, ModBlocks.REDSTONE_BLOCK, "redstone_block", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.LANTERN, ModBlocks.LANTERN, "lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(Blocks.SOUL_LANTERN, ModBlocks.SOUL_LANTERN, "soul_lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(null, ModBlocks.SPECIAL_LANTERN, "special_lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
        registry.register(null, ModBlocks.SPECIAL_SOUL_LANTERN, "special_soul_lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public static void registerSpecial(SpecialBlockRegistry registry) {
        registry.register(Blocks.LANTERN, Stream.concat(ModBlocks.LANTERN.getEntries().stream(), ModBlocks.SPECIAL_LANTERN.getEntries().stream())
            .collect(Collectors.toList()), "lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);

        registry.register(Blocks.SOUL_LANTERN, Stream.concat(ModBlocks.SOUL_LANTERN.getEntries().stream(), ModBlocks.SPECIAL_SOUL_LANTERN.getEntries().stream())
            .collect(Collectors.toList()), "soul_lantern", TINKERING_TABLE_TAG, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        registerTags(this::createSet);
        registerSpecial(this::createSet);
        addVanillaTags();
        createVanillaSet(ModBlocks.BENCHES, BlockTags.MINEABLE_WITH_AXE);
    }

    private void addVanillaTags() {
        createVanillaSet(ModBlocks.BLACK_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.BLUE_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.BROWN_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.CYAN_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.GRAY_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.GREEN_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIGHT_BLUE_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIGHT_GRAY_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIME_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.MAGENTA_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.ORANGE_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.PINK_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.PURPLE_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.RED_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.WHITE_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.YELLOW_CARPET, BlockTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LADDER, BlockTags.CLIMBABLE);
        createVanillaSet(ModBlocks.VINE, BlockTags.CLIMBABLE);
        createVanillaSet(ModBlocks.DIRT, BlockTags.DIRT);
        createVanillaSet(ModBlocks.ACACIA_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.BIRCH_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.DARK_OAK_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.JUNGLE_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.MANGROVE_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.OAK_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.SPRUCE_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.CRIMSON_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.WARPED_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.CHERRY_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.BAMBOO_DOOR, BlockTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.OBSIDIAN, BlockTags.DRAGON_IMMUNE);
        createVanillaSet(ModBlocks.CRYING_OBSIDIAN, BlockTags.DRAGON_IMMUNE);
        createVanillaSet(ModBlocks.CLAY, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.MELON, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.PUMPKIN, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.CARVED_PUMPKIN, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.BROWN_MUSHROOM_BLOCK, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.RED_MUSHROOM_BLOCK, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.CRIMSON_FUNGUS, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.WARPED_FUNGUS, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.CRIMSON_ROOTS, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.WARPED_ROOTS, BlockTags.ENDERMAN_HOLDABLE);
        createVanillaSet(ModBlocks.WARPED_FUNGUS, BlockTags.HOGLIN_REPELLENTS);
        createVanillaSet(ModBlocks.ICE, BlockTags.ICE);
        createVanillaSet(ModBlocks.PACKED_ICE, BlockTags.ICE);
        createVanillaSet(ModBlocks.BLUE_ICE, BlockTags.ICE);
        createVanillaSet(ModBlocks.GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.WHITE_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.ORANGE_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.MAGENTA_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.YELLOW_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.LIME_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.PINK_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.GRAY_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.CYAN_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.PURPLE_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.BLUE_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.BROWN_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.GREEN_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.RED_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.BLACK_STAINED_GLASS, BlockTags.IMPERMEABLE);
        createVanillaSet(ModBlocks.NETHERRACK, BlockTags.INFINIBURN_OVERWORLD);
        createVanillaSet(ModBlocks.ACACIA_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.BIRCH_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.DARK_OAK_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.JUNGLE_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.OAK_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.SPRUCE_LEAVES, BlockTags.LEAVES);
        createVanillaSet(ModBlocks.OBSIDIAN, BlockTags.NEEDS_DIAMOND_TOOL);
        createVanillaSet(ModBlocks.CRYING_OBSIDIAN, BlockTags.NEEDS_DIAMOND_TOOL);
        createVanillaSet(ModBlocks.SOUL_LANTERN, BlockTags.PIGLIN_REPELLENTS);
        createVanillaSet(ModBlocks.ACACIA_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.BIRCH_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.DARK_OAK_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.JUNGLE_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.MANGROVE_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.OAK_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.SPRUCE_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.CRIMSON_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.WARPED_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.CHERRY_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.BAMBOO_PLANKS, BlockTags.PLANKS);
        createVanillaSet(ModBlocks.VINE, BlockTags.REPLACEABLE_BY_TREES);
        createVanillaSet(ModBlocks.SAND, BlockTags.SAND);
        createVanillaSet(ModBlocks.SNOW_BLOCK, BlockTags.SNOW);
        createVanillaSet(ModBlocks.SOUL_SAND, BlockTags.SOUL_FIRE_BASE_BLOCKS);
        createVanillaSet(ModBlocks.SOUL_SAND, BlockTags.SOUL_SPEED_BLOCKS);
        createVanillaSet(ModBlocks.ACACIA_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.BIRCH_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.DARK_OAK_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.JUNGLE_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.MANGROVE_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.OAK_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.SPRUCE_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.CRIMSON_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.WARPED_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.CHERRY_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.BAMBOO_TRAPDOOR, BlockTags.TRAPDOORS);
        createVanillaSet(ModBlocks.ACACIA_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.BIRCH_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.DARK_OAK_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.JUNGLE_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.MANGROVE_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.OAK_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.SPRUCE_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.CRIMSON_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.WARPED_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.CHERRY_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.BAMBOO_TRAPDOOR, BlockTags.WOODEN_TRAPDOORS);
        createVanillaSet(ModBlocks.NETHER_WART_BLOCK, BlockTags.WART_BLOCKS);
        createVanillaSet(ModBlocks.WARPED_WART_BLOCK, BlockTags.WART_BLOCKS);
        createVanillaSet(ModBlocks.SOUL_SAND, BlockTags.WITHER_SUMMON_BASE_BLOCKS);
        createVanillaSet(ModBlocks.BLACK_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.BLUE_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.BROWN_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.CYAN_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.GRAY_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.GREEN_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.LIGHT_BLUE_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.LIGHT_GRAY_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.LIME_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.MAGENTA_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.ORANGE_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.PINK_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.PURPLE_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.RED_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.WHITE_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.YELLOW_WOOL, BlockTags.WOOL);
        createVanillaSet(ModBlocks.SOUL_SAND, BlockTags.SOUL_SPEED_BLOCKS);
        createVanillaSet(ModBlocks.BOOKSHELF, BlockTags.ENCHANTMENT_POWER_PROVIDER);
    }

    private void createVanillaSet(ResourcefulRegistry<Block> registry, TagKey<Block> tag) {
        registry.stream().forEach(b -> tag(tag).add(TagEntry.element(b.getId())));
    }

    private void createSet(Block block, Collection<RegistryEntry<Block>> registry, String tag, TagKey<Item> workbench, @Nullable TagKey<Block> mineable) {
        createSet(block, registry, ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, tag), mineable);
    }

    private void createSet(Block block, ResourcefulRegistry<Block> registry, String tag, TagKey<Item> workbench, @Nullable TagKey<Block> mineableTag) {
        createSet(block, registry.getEntries(), ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, tag), mineableTag);
    }

    private void createSet(Block block, Collection<RegistryEntry<Block>> registry, ResourceLocation tag, @Nullable TagKey<Block> mineableTag) {
        var tagKey = TagKey.create(Registries.BLOCK, tag);
        if (block != null) {
            tag(tagKey).add(TagEntry.element(Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block))));
        }
        registry.forEach(b -> tag(tagKey).add(TagEntry.element(b.getId())));
        if (mineableTag != null) {
            tag(mineableTag).addTag(tagKey);
        }
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
        return super.run(new MinifiedTagOutput(output));
    }

    @FunctionalInterface
    public interface BlockRegistry {
        void register(Block block, ResourcefulRegistry<Block> registry, String tag, TagKey<Item> workbench, @Nullable TagKey<Block> mineable);

        default void register(Block block, ResourcefulRegistry<Block> registry, String tag, TagKey<Item> workbench) {
            register(block, registry, tag, workbench, null);
        }
    }

    @FunctionalInterface
    public interface SpecialBlockRegistry {
        void register(Block block, Collection<RegistryEntry<Block>> registry, String id, TagKey<Item> tag, @Nullable TagKey<Block> mineable);
    }
}
