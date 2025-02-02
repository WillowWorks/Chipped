package earth.terrarium.chipped.common.palette;

public class Palettes {

    public static final Palette MELON = PaletteBuilder.create()
        .add("bright_%", "dark_%", "golden_%", "ripe_%", "rustic_%", "sticky_%", "sunny_%", "swampy_%", "sweet_%", "tropics_%")
        .build();

    public static final Palette HAY_BLOCK = PaletteBuilder.create()
        .add("antique_%", "bundled_%", "detailed_%", "fertile_%", "jungle_%", "pale_%", "rich_%", "swampy_%")
        .build();

    public static final Palette MOSS_BLOCK = PaletteBuilder.create()
        .add("blobby_%", "blue_%", "crunchy_%", "lime_%", "old_%", "red_%", "smooth_%", "spongy_%", "sprinkled_%", "yellow_%")
        .build();

    public static final Palette MUSHROOM_STEM = PaletteBuilder.create()
        .add("blooming_%", "broken_%", "grimy_%", "old_%", "poisonous_%", "smooth_%", "warm_%")
        .build();

    public static final Palette DRIED_KELP_BLOCK = PaletteBuilder.create()
        .add("bamboo_%", "blue_%", "brown_%", "compact_%", "crimson_%", "leafy_%", "mossy_%", "netherwart_%", "rough_crimson_%", "shroomy_%", "sugarcane_%", "wart_%")
        .build();

    public static final Palette SPONGE = PaletteBuilder.create()
        .add("bulby_%", "fine_%", "giant_%", "lush_%", "old_%", "smooth_%", "soft_%")
        .build();

    public static final Palette BONE_BLOCK = PaletteBuilder.create()
        .add("cracked_%", "crunched_%", "dark_%", "double_roped_%", "fractured_%", "gilded_basalt_%", "inscribed_%", "reinforced_%", "roped_%", "tiled_%", "weaved_%")
        .build();

    public static final Palette MUSHROOM = PaletteBuilder.create()
        .add("bulbed_%", "button_%", "clustered_%", "double_%", "franken_%", "hooded_%", "micro_%", "mini_%", "%_bulb", "%_bushel", "%_cluster", "%_trio", "umbrella_%", "wicked_%")
        .build();

    public static final Palette WARPED_FUNGUS = PaletteBuilder.create(MUSHROOM, "clustered_%")
        .build();

    public static final Palette MUSHROOM_BLOCK = PaletteBuilder.create()
        .add("dark_dusted_%", "dark_freckled_%", "dark_scaled_%", "dark_smooth_%", "dark_spotted_%", "dark_sprinkled_%", "dusted_%", "freckled_%", "light_dusted_%", "light_freckled_%", "light_scaled_%", "light_smooth_%", "light_spotted_%", "light_sprinkled_%", "scaled_%", "smooth_%", "spotted_%", "sprinkled_%", "white_dusted_%", "white_freckled_%", "white_spotted_%", "white_sprinkled_%")
        .build();

    public static final Palette RED_MUSHROOM_BLOCK = PaletteBuilder.create()
        .add("dark_dotted_%", "dark_dusted_%", "dark_freckled_%", "dark_smooth_%", "dark_spotted_%", "dotted_%", "dusted_%", "freckled_%", "light_dotted_%", "light_dusted_%", "light_freckled_%", "light_smooth_%", "light_spotted_%", "smooth_%", "spotted_%")
        .build();

    public static final Palette COBWEB = PaletteBuilder.create()
        .add("broken_%", "hanging_broken_%", "%_arch", "%_floor", "dense_%", "hanging_%", "scattered_%", "stretched_%", "stringy_%", "thick_%_floor")
        .build();

    public static final Palette CRIMSON_ROOTS = PaletteBuilder.create()
        .add("budding_%_bulb", "budding_%", "%_bloom", "%_bramble", "%_bud", "%_bulb", "%_floret", "flowered_%_bulb", "flowered_%", "small_%_bud", "sprouting_%_bulb", "sprouting_%", "wilted_%_bud", "wilted_%_bulb")
        .build();

    public static final Palette WARPED_ROOTS = PaletteBuilder.create()
        .add("bloomed_%", "flowering_%", "half_grown_%", "lily_%", "mangled_%", "overgrown_%", "stem_%", "wiggly_%", "young_%")
        .build();

    public static final Palette WART_BLOCK = PaletteBuilder.create()
        .add("bubbling_%", "crumbled_%", "dried_%", "erratic_%", "eyed_%", "patched_%", "porous_%", "rough_%", "scabbed_%", "scaled_%", "seared_%", "semi_spongy_%", "speckled_%", "spongy_%")
        .build();

    public static final Palette NETHER_SPROUTS = PaletteBuilder.create()
        .add("bolby_%", "bushy_%", "corny_%", "corrupted_%", "creeping_%", "crusted_%", "fired_%", "flimsy_%", "grizly_%", "high_%", "large_%", "%_weeds", "seeded_%", "short_%", "shroomy_%", "tall_shroomy_%", "thin_%", "tubed_%", "warty_%", "wide_%")
        .build();

    public static final Palette LILY_PAD = PaletteBuilder.create()
        .add("big_flower_%", "broken_%", "dark_broken_%", "dark_flowering_%", "dark_large_%", "dark_leaf_%", "dark_micro_%s", "dark_paddle_%", "dark_rough_%", "dark_smol_%", "dark_smooth_%", "flowering_%", "large_%", "leaf_%", "light_leaf_%", "light_rough_%", "micro_%s", "pacman_%", "paddle_%", "rough_%", "smol_%", "smooth_%")
        .build();

    public static final Palette VINE = PaletteBuilder.create()
        .add("droopy_%", "flowery_%", "ivy_%", "leafy_%", "long_%", "lush_%", "nether_%", "poisonous_%", "thicc_%", "thin_%", "warped_%")
        .build();

    public static final Palette LEAVES = PaletteBuilder.create()
        .add("apple_%", "cherry_%", "dead_%", "frosted_%", "golden_%", "golden_apple_%", "golden_cherry_%", "magenta_flower_%", "orange_%", "red_%", "white_flower_%")
        .build();

    public static final Palette ROOTS = PaletteBuilder.create()
        .add("blue_%", "crimson_%", "flowery_%", "leafy_%", "lush_%", "muddy_%", "thin_%")
        .build();

    public static final Palette PUMPKIN = PaletteBuilder.create()
        .add("autumnkin", "dewkin", "dirty_dewkin", "dirty_goldkin", "dirty_rosekin", "end_%", "end_%_purple", "goldkin", "kabotchkin", "nether_%", "overgrown_%", "overgrown_autumnkin", "overgrown_lumpkin", "overgrown_pimpkin", "pimpkin", "rosekin")
        .build();

    public static final Palette CARVED_PUMPKIN = PaletteBuilder.create()
        .add("anguished_%", "bad_time_%", "boo_%", "creepy_%", "devious_%", "end_%", "end_purple_%", "horrified_%", "kitty_faced_%", "nether_%", "overjoyed_%", "owo_%", "silly_%", "slight_smile_%", "smiling_%", "spooky_%", "squished_cute_%", "suspicious_%", "tiny_smug_%", "traditional_%", "upside_down_%", "wide_eyed_%")
        .build();

    public static final Palette GRAVEL = PaletteBuilder.create()
        .add("andesite_%", "dirty_%", "dusty_%", "orange_%", "rought_%", "sandy_%", "sifted_%")
        .build();

    public static final Palette SAND = PaletteBuilder.create()
        .add("ash_%", "coarse_%", "desert_%", "kelp_%", "lush_red_%", "overgrown_%", "pearl_%", "soft_%", "tar_%", "wet_%", "wet_red_%", "white_%")
        .build();

    public static final Palette SOUL_SAND = PaletteBuilder.create()
        .add("faded_%", "fine_%", "glowing_%", "graveled_%", "happy_%", "hardened_%", "lauching_%", "meming_%", "reanimated_%", "scared_%", "sifted_%", "smoothed_%", "trampled_%")
        .build();

    public static final Palette GLOWSTONE = PaletteBuilder.create()
        .add("broken_%", "bulbed_%", "cracked_%", "double_inlayed_%", "edged_%_lantern", "fancy_%_lantern", "framed_%_lantern", "glowing_lodestone_side", "%_lantern", "hived_%", "inlayed_%", "nether_engraved_%", "ornate_%_lantern", "patterned_%", "polished_%", "shimmering_%", "smooth_%", "thick_inlayed_%", "tiled_%_pillar", "wither_engraved_%")
        .build();

    public static final Palette SEA_LANTERN = PaletteBuilder.create()
        .add("broken_%", "bulbed_%", "cracked_%", "double_inlayed_%", "fancy_%", "framed_%", "hived_%", "inlayed_%", "ornate_%", "polished_%", "reinforced_%", "sea_lodestone_side", "shimmering_%", "smooth_%", "special_%", "thick_inlayed_%", "tiled_%_pillar")
        .build();

    public static final Palette SHROOMLIGHT = PaletteBuilder.create()
        .add("broken_%", "cracked_%", "double_inlayed_%", "edged_%_lantern", "fancy_%_lantern", "framed_%_lantern", "hived_%", "inlayed_%", "ornate_%_lantern", "polished_%", "reinforced_%", "shimmering_%", "%_lantern", "%_lodestone_side", "smooth_%", "thick_inlayed_%", "tiled_%_pillar")
        .build();

    public static final Palette TORCH = PaletteBuilder.create()
        .add("acacia_%", "birch_%", "crimson_%", "dark_oak_%", "glow_%", "iron_%", "jungle_%", "spruce_%", "warped_%")
        .build();

    public static final Palette REDSTONE_TORCH = PaletteBuilder.create()
        .add("blue_%", "crimson_%", "green_%", "lightstick_%", "yellow_%")
        .build();

    public static final Palette REDSTONE_LAMP = PaletteBuilder.create()
        .add("edged_%", "edged_white_%", "fancy_%", "fancy_white_%", "hived_%", "hived_white_%", "inlayed_%", "inlayed_white_%", "nice_%", "nice_white_%", "ornate_%", "ornate_white_%", "reinforced_%", "reinforced_white_%", "smooth_%", "smooth_white_%", "thick_inlayed_%", "thick_white_inlayed_%")
        .build();

    public static final Palette SPECIAL_LANTERN = PaletteBuilder.create()
        .add("big_lantern", "donut_lantern", "tall_lantern", "wide_lantern")
        .build();

    public static final Palette SPECIAL_SOUL_LANTERN = PaletteBuilder.create()
        .add("big_soul_lantern", "donut_soul_lantern", "tall_soul_lantern", "wide_soul_lantern")
        .build();

    public static final Palette LANTERN = PaletteBuilder.create()
        .add("blue_paper_%", "burning_coal_%", "checkered_iron_%", "dark_blue_paper_%", "ender_%", "green_paper_%", "iron_bowl_%", "purple_paper_%", "red_paper_%", "small_green_%", "white_paper_%", "wooden_cage_%", "wrought_iron_%", "yellow_tube_%")
        .build();

    public static final Palette SOUL_LANTERN = PaletteBuilder.create()
        .add("blue_paper_%", "blue_tube_%", "checkered_iron_%", "golden_paper_%", "gray_paper_%", "iron_bowl_%", "lime_paper_%", "orange_paper_%", "small_red_%", "wooden_cage_%", "yellow_paper_%")
        .build();

    public static final Palette FROGLIGHT = PaletteBuilder.create()
        .add("ad_astra_%", "ancient_%", "barred_%", "elemental_%", "exposed_%", "glass_%", "reinforced_%", "round_%")
        .build();

    public static final Palette BOOKSHELF = PaletteBuilder.create()
        .add("ancient_cubed_oak_%", "ancient_oak_%", "ancient_oak_large_%", "ancient_vertical_oak_%", "botanical_oak_%", "botanical_oak_cubed_%", "botanical_oak_large_%", "cubed_oak_%", "cubed_oak_empty_%", "cubed_oak_spaced_%", "cubed_oak_webbed_%", "curvy_%", "dusty_%", "full_%", "historical_oak_%", "historical_oak_large_%", "mixed_cubed_oak_%", "mixed_oak_%", "mixed_oak_large_%", "oak_%", "oak_empty_%", "oak_large_%", "oak_lighted_%", "oak_lighted_large_%", "oak_spaced_%", "oak_spaced_large_%", "oak_webbed_%", "oak_webbed_large_%", "vertical_botanical_oak_%", "vertical_mixed_oak_%", "vertical_oak_%", "vertical_oak_lighted_%", "vertical_oak_webbed_%")
        .build();

    public static final Palette LADDER = PaletteBuilder.create()
        .add("crooked_%", "crooked_plank_%", "crooked_ropeplank_%", "metal_%", "mossy_%", "plank_%", "railed_%", "rope_planked_%", "roped_%", "strong_%")
        .build();

    public static final Palette WOOL = PaletteBuilder.create()
        .add("barky_%", "blocky_%", "bundled_%", "cross_haired_%", "cubed_%", "knitted_%", "patched_%", "rectangle_%", "ribbled_%", "scaled_%", "soft_%", "stringed_%", "tiled_%", "tripped_%", "wickered_%", "windmill_%", "woved_%")
        .ctm("cornered_%", "crafted_%", "harsh_quilted_%")
        .build();

    public static final Palette CARPET = PaletteBuilder.create(WOOL, id -> id == IdType.CTM ? IdType.CARPET_CTM : id)
        .build();

    public static final Palette STONE = PaletteBuilder.create()
        .add("%_bricks", "%_mini_tiles", "%_pillar", "%_pillar_top", "%_scales", "angry_%", "blank_%_carving", "carved_%", "checkered_%_tiles", "cobbled_%", "cracked_%_bricks", "cracked_disordered_%_bricks", "cracked_flat_%_tiles", "creeper_%_carving", "crying_%", "cut_blank_%", "glad_%", "duh_%", "engraved_%", "eroded_%", "etched_%_bricks", "flat_%_tiles", "inlayed_%", "inscribed_%", "layed_%_bricks", "loded_%", "offset_%_bricks", "pillar_%_bricks", "prismal_%_remnants", "rough_%", "rounded_%_bricks", "runic_carved_%", "sad_%", "sanded_%", "small_%_bricks", "smooth_inlayed_%", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiraled_%", "stacked_%_bricks", "tiled_%", "tiny_%_bricks", "tiny_layered_%_bricks", "tiny_layered_%_slabs", "trodden_%", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks", "weathered_%")
        .ctm("bordered_%", "brick_bordered_%", "cut_%_column", "edged_%_bricks", "overlapping_%_tiles", "polished_%", "smooth_%_column", "thick_inlayed_%", "tiled_%_column", "tiled_bordered_%", "tiny_brick_bordered_%")
        .pillar("curly_%_pillar", "fine_%_pillar", "ornate_%_pillar", "simple_%_pillar")
        .giant("massive_%_bricks")
        .build();

    public static final Palette BASALT = PaletteBuilder.create(STONE, "rough_%", "trodden_%")
        .build();

    public static final Palette BLACKSTONE = PaletteBuilder.create(STONE, "%_bricks", "cracked_%_bricks", "rough_%", "weathered_%")
        .add("smooth_%_bricks")
        .build();

    public static final Palette DARK_PRISMARINE = PaletteBuilder.create(STONE, "%_mini_tiles")
        .build();

    public static final Palette DEEPSLATE = PaletteBuilder.create(STONE, "%_bricks", "cobbled_%", "cracked_%_bricks", "cracked_flat_%_tiles", "flat_%_tiles", "layed_%_bricks", "offset_%_bricks")
        .build();

    public static final Palette GILDED_BLACKSTONE = PaletteBuilder.create(STONE, "rough_%", "smooth_%")
        .add("chunky_%", "reinforced_%", "special_%", "spiral_%")
        .build();

    public static final Palette LODESTONE = PaletteBuilder.create()
        .add("%_bricks", "%_mini_tiles", "%_pillar", "%_pillar_top", "%_scales", "angry_%", "blank_%_carving", "blank_%_side", "carved_%", "checkered_%_tiles", "cobbled_%", "cracked_%_bricks", "cracked_disordered_%_bricks", "cracked_flat_%_tiles", "creeper_%_carving", "crying_%", "cut_blank_%", "glad_%", "diamond_%", "dot_%", "duh_%", "engraved_%", "eroded_%", "etched_%_bricks", "flat_%_tiles", "inlayed_%", "inscribed_%", "layed_%_bricks", "offset_%_bricks", "pillar_%_bricks", "prismal_%_remnants", "ring_%", "ring_%_side", "rough_%", "rounded_%_bricks", "runic_carved_%", "sad_%", "sanded_%", "sea_lantern_%", "small_%_bricks", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiraled_%", "stacked_%_bricks", "tiled_%", "tiny_%_bricks", "tiny_layered_%_bricks", "tiny_layered_%_slabs", "trodden_%", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks", "watching_%", "weathered_%", "wider_diamond_%", "wider_ring_%", "wider_watching_%")
        .ctm("bordered_%", "brick_bordered_%", "cut_%_column", "edged_%_bricks", "overlapping_%_tiles", "polished_%", "smooth_%_column", "thick_inlayed_%", "tiled_%_column", "tiled_bordered_%", "tiny_brick_bordered_%")
        .pillar("curly_%_pillar", "fine_%_pillar", "ornate_%_pillar", "simple_%_pillar")
        .giant("massive_%_bricks")
        .build();

    public static final Palette MOSSY_STONE_BRICKS = PaletteBuilder.create(STONE, "%_bricks")
        .build();

    public static final Palette PRISMARINE = PaletteBuilder.create(STONE, "prismal_%_remnants")
        .ctm("granite_%")
        .build();

    public static final Palette PURPUR_BLOCK = PaletteBuilder.create(STONE, "checkered_%_tiles")
        .build();

    public static final Palette QUARTZ_BLOCK = PaletteBuilder.create(STONE, "carved_%", "offset_%_bricks", "%_pillar_top", "spiraled_%")
        .build();

    public static final Palette BASE_STONE = PaletteBuilder.create(STONE, "%_bricks", "cracked_%_bricks", "eroded_%", "smooth_ringed_%")
        .build();

    public static final Palette CLAY = PaletteBuilder.create(STONE, "eroded_%")
        .build();

    public static final Palette BRICKS = PaletteBuilder.create(STONE, "layed_%_bricks")
        .build();

    public static final Palette MUD = PaletteBuilder.create()
        .add("%_bricks", "%_pillar", "%_pillar_top", "%_scales", "angled_%_bricks", "angry_%", "arrow_%", "button_%", "carved_%", "centered_%", "chiseled_%", "cracked_%_bricks", "creeper_%_carving", "crunched_%_bricks", "crying_%", "cut_blank_%", "double_%_bricks", "duh_%", "engraved_%", "etched_%_bricks", "eye_%", "fancy_%", "fancy_chiseled_%", "glad_%", "heart_%", "horned_%", "inlayed_%", "keyhole_%", "large_tiled_%", "leaning_%", "mini_tiled_%", "offset_%_bricks", "pancake_%", "panelled_%", "placed_%", "polished_%", "prismal_%_remnants", "quad_%", "rough_%", "rough_panelled_%", "rune_%", "sad_%", "sigil_%", "small_%_bricks", "smooth_%", "smooth_ringed_%", "smoothed_double_inlayed_%", "spider_%_carving", "spiral_%", "stacked_%_bricks", "star_%", "symbol_%", "symbolic_%_pillar", "thick_inlayed_%", "tiled_%_bricks", "tiny_%_bricks", "tiny_layered_%_bricks", "unamused_%", "vertical_cut_%", "vertical_disordered_%_bricks")
        .ctm("bordered_%", "brick_bordered_%", "edged_%_bricks", "hard_%", "overlapping_%_tiles", "scaly_%", "tiled_bordered_%", "tiled_%_column")
        .pillar("carved_%_pillar", "curly_%_pillar", "fancy_%_pillar", "fine_%_pillar", "ornate_%_pillar", "simple_%_pillar")
        .giant("massive_%_bricks", "diamond_%_bricks", "large_%_sigil", "loreful_%")
        .build();

    public static final Palette PLANKS = PaletteBuilder.create()
        .add("%_mosaic", "%_shavings", "basket_woven_%", "boxed_%", "brick_bond_%", "bricky_%", "cross_laced_%", "crossed_%", "detailed_%", "diagonal_%", "diamond_%", "double_herringbone_%", "fine_%", "fine_vertical_%", "herringbone_%", "hewn_%", "laced_%", "nailed_%", "polished_%", "railed_%", "shifted_%", "slanted_%", "smooth_%", "stacked_%", "thin_%", "tiled_%", "versailles_%", "vertical_%", "vertically_railed_%", "wickered_%")
        .ctm("%_panel", "cornered_%", "crated_%", "enclosed_%", "framed_%", "natural_%", "pegged_%", "whirlwind_%")
        .build();

    public static final Palette MANGROVE_PLANKS = PaletteBuilder.create()
        .add("%_mosaic", "%_shavings", "basket_woven_%", "boxed_%", "brick_bond_%", "bricky_%", "carved_%", "chiseled_%", "cross_laced_%", "crossed_%", "cut_%", "detailed_%", "diagonal_%", "diamond_%", "double_herringbone_%", "fine_%", "fine_vertical_%", "herringbone_%", "hewn_%", "laced_%", "nailed_%", "polished_%", "railed_%", "ringed_%", "shelved_%", "shifted_%", "sided_%", "slanted_%", "smooth_%", "stacked_%", "thin_%", "tiled_%", "versailles_%", "vertical_%", "vertically_railed_%")
        .ctm("bricked_%", "cornered_%", "crated_%", "enclosed_%", "framed_%", "%_panel", "natural_%", "pegged_%")
        .build();

    public static final Palette BAMBOO_PLANKS = PaletteBuilder.create()
        .add("%_fine_mosaic", "%_shavings", "basket_woven_%", "boxed_%", "brick_bond_%", "bricky_%", "cross_laced_%", "crossed_%", "detailed_%", "diagonal_%", "diamond_%", "double_herringbone_%", "fine_%", "fine_vertical_%", "herringbone_%", "hewn_%", "laced_%", "reinforced_%", "polished_%", "railed_%", "shifted_%", "slanted_%", "smooth_%", "stacked_%", "thin_%", "tiled_%", "versailles_%", "vertical_%", "vertically_railed_%", "wickered_%")
        .ctm("%_panel", "cornered_%", "crated_%", "enclosed_%", "framed_%", "natural_%", "tied_%", "whirlwind_%")
        .build();

    public static final Palette LOG = PaletteBuilder.create()
        .add("bundled_%", "center_cut_%", "damaged_%", "edge_cut_%", "firewood_%", "flowering_%", "mixed_%", "nailed_%", "overgrown_%", "planked_%", "reinforced_%")
        .build();

    public static final Palette WARPED_STEM = PaletteBuilder.create()
        .add("bundled_%", "center_cut_%", "damaged_%", "edge_cut_%", "firewood_%", "nailed_%", "planked_%", "rotted_%", "shrooming_%", "smooth_%")
        .build();

    public static final Palette CRIMSON_STEM = PaletteBuilder.create()
        .add("bundled_%", "center_cut_%", "crying_%", "damaged_%", "edge_cut_%", "firewood_%", "glittering_%", "glowing_%", "mixed_%", "nailed_%", "planked_%", "rotten_%", "shrooming_%", "smooth_%")
        .build();

    public static final Palette STRIPPED_LOG = PaletteBuilder.create()
        .add("carved_%", "chipped_%", "d_sign_%", "edged_%", "f_sign_%", "i_sign_%", "k_sign_%", "knotted_%", "l_sign_%", "layered_%", "lumpy_%", "m_sign_%", "patient_%", "reinforced_%", "sign_%", "stern_%", "wise_%")
        .build();

    public static final Palette STRIPPED_MANGROVE_LOG = PaletteBuilder.create()
        .add("carved_%", "chipped_%", "chiseled_%", "d_sign_%", "edged_%", "f_sign_%", "i_sign_%", "k_sign_%", "knotted_%", "l_sign_%", "lumpy_%", "m_sign_%", "patient_%", "reinforced_%", "sign_%", "stern_%", "vertical_layered_%", "wise_%")
        .build();

    public static final Palette BARREL = PaletteBuilder.create()
        .add("acacia_%", "acacia_crate", "bamboo_%", "birch_%", "birch_crate", "coal_%", "copper_%", "crimson_%", "crimson_crate", "dark_oak_crate", "fish_%", "fruit_%", "gilded_%", "gold_%", "iron_%", "jungle_crate", "mangrove_brick_%", "mangrove_crate", "mangrove_tile_%", "metal_%", "mushroom_%", "netherite_safe", "oak_%", "oak_crate", "reinforced_acacia_crate", "reinforced_birch_crate", "reinforced_crimson_crate", "reinforced_dark_oak_crate", "reinforced_jungle_crate", "reinforced_mangrove_crate", "reinforced_oak_crate", "reinforced_spruce_crate", "reinforced_warped_crate", "spruce_%", "spruce_crate", "varnished_%", "warped_crate")
        .build();

    public static final Palette METAL = PaletteBuilder.create()
        .add("%_panels", "ancient_%", "chipped_%", "engraved_%", "layered_%", "plated_%", "polished_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%")
        .build();

    public static final Palette NETHERITE_BLOCK = PaletteBuilder.create()
        .add("%_panels", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "polished_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%")
        .build();

    public static final Palette DIAMOND_BLOCK = PaletteBuilder.create()
        .add("%_panels", "ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%")
        .build();

    public static final Palette EMERALD_BLOCK = PaletteBuilder.create()
        .add("%_panels", "ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "polished_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%")
        .build();

    public static final Palette COPPER_BLOCK = PaletteBuilder.create()
        .add("ancient_%", "chipped_%", "embossed_%", "engraved_%", "layered_%", "plated_%", "pressed_%", "reinforced_%", "sheet_%", "shuttered_%", "stacked_%")
        .build();

    public static final Palette IRON_BARS = PaletteBuilder.create()
        .add("%_top", "barbed_%", "bolted_%", "chained_%", "crossbolted_%", "crossed_%", "floral_%", "harp_%", "linked_%", "loose_%", "piked_%", "railed_%", "sighthole_%", "stepped_%", "sturdy_%", "supported_%", "thorned_%", "victorian_%_pikes", "vined_%", "woven_%", "zippered_%")
        .build();

    public static final Palette TERRACOTTA = PaletteBuilder.create()
        .add("%_bricks", "%_tile", "%_tiles", "chiseled_%", "crossed_%", "cut_%", "decorated_%", "layered_%", "triangular_%")
        .pillar("%_column", "%_pillar")
        .ctm("small_%_tiles", "curled_%", "hexagonical_%")
        .giant("circular_%", "inscribed_%", "starry_%")
        .build();

    public static final Palette GLAZED_TERRACOTTA = PaletteBuilder.create()
        .add("%_pillar_sides", "%_pillar_top", "%_smooth_tiles", "%_tiles", "decorated_%", "hexagonical_%", "minimized_%", "paved_%", "shrunken_%", "starry_%", "waved_%")
        .build();

    public static final Palette POINTED_DRIPSTONE = PaletteBuilder.create()
        .add("andesite_%", "calcite_%", "deepslate_%", "diorite_%", "smooth_basalt_%", "granite_%", "stone_%", "tuff_%", "basalt_%", "blackstone_%", "endstone_%", "netherrack_%", "packed_ice_%")
        .build();

    public static final Palette GLASS = PaletteBuilder.create()
        .add("circle_oak_%", "fancy_leaded_%", "large_diamond_leaded_%", "lead_woven_%", "oak_snowflake_%", "square_leaded_%", "vertical_leaded_%")
        .limitedPillar("arched_leaded_%_pillar")
        .ctm("clear_leaded_%", "oak_bared_%", "oak_bordered_%", "oak_diamond_bordered_%", "oak_horizontal_lined_%", "oak_large_diamond_%", "oak_line_bared_%", "oak_ornate_bared_%", "oak_woven_%", "ornate_leaded_%", "raster_leaded_%", "small_diamond_leaded_%", "square_oak_%")
        .build();

    public static final Palette GLASS_PANE = PaletteBuilder.create(GLASS, id -> switch (id) {
            case CTM -> IdType.PANE_CTM;
            case PILLAR, LIMITED_PILLAR -> IdType.PANE_PILLAR;
            default -> id;
        })
        .build();

    public static final Palette STAINED_GLASS = PaletteBuilder.create()
        .add("circular_%", "large_diamond_%", "square_%", "vertical_stiped_%", "woven_%")
        .limitedPillar("arched_%_pillar")
        .ctm("fancy_%", "ornate_%", "raster_%", "small_%", "tiled_%")
        .build();

    public static final Palette STAINED_GLASS_PANE = PaletteBuilder.create(STAINED_GLASS, id -> switch (id) {
            case CTM -> IdType.PANE_CTM;
            case PILLAR, LIMITED_PILLAR -> IdType.PANE_PILLAR;
            default -> id;
        })
        .build();


    public static final Palette CONCRETE = PaletteBuilder.create()
        .add("%_bricks", "%_tiles", "creeper_%", "grid_%", "mosaic_%", "stacked_%", "stop_%")
        .ctm("grill_%", "%_panel", "pegged_%", "smooth_%", "striped_%", "wired_%")
        .pillar("%_pillar")
        .directional("bolted_%", "hazard_%", "railed_%", "reinforced_%", "rusted_%", "warning_%")
        .build();

    public static final Palette TRAPDOOR = PaletteBuilder.create()
        .add("airy_%", "barred_%", "checkered_%", "classic_%", "classic_windowed_%", "cobweb_%", "distorted_%", "fancy_%", "golden_barred_%", "heavy_%", "iron_barred_%", "leafy_%", "meshed_%", "overgrown_%", "pointless_%", "slotted_%", "solid_%", "suspicious_%", "twisted_%", "vined_%", "warted_%", "windowed_%", "woven_%")
        .build();

    public static final Palette OAK_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "classic_%")
        .build();

    public static final Palette SPRUCE_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "heavy_%")
        .build();

    public static final Palette CRIMSON_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "suspicious_%")
        .build();

    public static final Palette WARPED_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "distorted_%", "fancy_%")
        .build();

    public static final Palette JUNGLE_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "fancy_%")
        .build();

    public static final Palette ACACIA_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "airy_%")
        .build();

    public static final Palette CHERRY_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "airy_%")
        .build();

    public static final Palette BAMBOO_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "airy_%")
        .build();

    public static final Palette MANGROVE_TRAPDOOR = PaletteBuilder.create(TRAPDOOR, "distorted_%", "fancy_%")
        .build();

    public static final Palette DOOR = PaletteBuilder.create()
        .add("barred_%", "beach_%", "boarded_%", "dual_paneled_%", "fortified_%", "gated_%", "glass_%", "heavy_%", "overgrown_%", "paneled_%", "paper_%", "pressed_%", "screen_%", "secret_%", "shack_%", "sliding_%", "supported_%", "tile_windowed_%", "tiled_%", "windowed_%")
        .build();

    public static final Palette ACACIA_DOOR = PaletteBuilder.create(DOOR, "barred_%")
        .build();

    public static final Palette BIRCH_DOOR = PaletteBuilder.create(DOOR, "paper_%")
        .build();

    public static final Palette DARK_OAK_DOOR = PaletteBuilder.create(DOOR, "paneled_%")
        .build();

    public static final Palette JUNGLE_DOOR = PaletteBuilder.create(DOOR, "beach_%")
        .build();

    public static final Palette SPRUCE_DOOR = PaletteBuilder.create(DOOR, "boarded_%")
        .build();

    public static final Palette CRIMSON_DOOR = PaletteBuilder.create(DOOR, "supported_%")
        .build();

    public static final Palette WARPED_DOOR = PaletteBuilder.create(DOOR, "overgrown_%", "sliding_%")
        .build();

    public static final Palette CHERRY_DOOR = PaletteBuilder.create(DOOR, "windowed_%")
        .build();

    public static final Palette BAMBOO_DOOR = PaletteBuilder.create(DOOR, "windowed_%")
        .build();

    public static final Palette MANGROVE_DOOR = PaletteBuilder.create(DOOR, "screen_%", "shack_%", "tiled_%")
        .build();
}
