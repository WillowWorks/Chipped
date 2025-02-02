package earth.terrarium.chipped.client;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.msrandom.multiplatform.annotations.Expect;

import java.util.function.Supplier;

public class ChippedClient {

    public static void init() {
        registerRenderTypes();
    }

    private static void registerRenderTypes() {
        createSetRenderType(ModBlocks.BENCHES, RenderType.cutout());

        createSetRenderType(ModBlocks.ICE, RenderType.translucent());

        createSetRenderType(ModBlocks.GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.BLACK_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.BLACK_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.BLUE_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.BLUE_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.BROWN_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.BROWN_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.CYAN_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.CYAN_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.GRAY_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.GRAY_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.GREEN_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.GREEN_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.LIGHT_BLUE_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.LIGHT_GRAY_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.LIME_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.LIME_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.MAGENTA_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.MAGENTA_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.ORANGE_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.ORANGE_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.PINK_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.PINK_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.PURPLE_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.PURPLE_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.RED_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.RED_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.WHITE_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.WHITE_STAINED_GLASS_PANE, RenderType.translucent());
        createSetRenderType(ModBlocks.YELLOW_STAINED_GLASS, RenderType.translucent());
        createSetRenderType(ModBlocks.YELLOW_STAINED_GLASS_PANE, RenderType.translucent());

        createSetRenderType(ModBlocks.IRON_BARS, RenderType.cutout());

        createSetRenderType(ModBlocks.ACACIA_LEAVES, RenderType.cutout());
        createSetRenderType(ModBlocks.BIRCH_LEAVES, RenderType.cutout());
        createSetRenderType(ModBlocks.DARK_OAK_LEAVES, RenderType.cutout());
        createSetRenderType(ModBlocks.JUNGLE_LEAVES, RenderType.cutout());
        createSetRenderType(ModBlocks.MANGROVE_ROOTS, RenderType.cutout());
        createSetRenderType(ModBlocks.OAK_LEAVES, RenderType.cutout());
        createSetRenderType(ModBlocks.SPRUCE_LEAVES, RenderType.cutout());

        createSetRenderType(ModBlocks.BROWN_MUSHROOM, RenderType.cutout());
        createSetRenderType(ModBlocks.RED_MUSHROOM, RenderType.cutout());
        createSetRenderType(ModBlocks.COBWEB, RenderType.cutout());
        createSetRenderType(ModBlocks.LADDER, RenderType.cutout());

        createSetRenderType(ModBlocks.ACACIA_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.BIRCH_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.DARK_OAK_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.JUNGLE_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.MANGROVE_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.OAK_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.SPRUCE_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.CRIMSON_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.WARPED_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.CHERRY_DOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.BAMBOO_DOOR, RenderType.cutout());

        createSetRenderType(ModBlocks.ACACIA_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.BIRCH_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.DARK_OAK_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.JUNGLE_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.MANGROVE_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.OAK_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.SPRUCE_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.CRIMSON_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.WARPED_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.CHERRY_TRAPDOOR, RenderType.cutout());
        createSetRenderType(ModBlocks.BAMBOO_TRAPDOOR, RenderType.cutout());

        createSetRenderType(ModBlocks.CRIMSON_ROOTS, RenderType.cutout());
        createSetRenderType(ModBlocks.WARPED_ROOTS, RenderType.cutout());
        createSetRenderType(ModBlocks.LANTERN, RenderType.translucent());
        createSetRenderType(ModBlocks.SOUL_LANTERN, RenderType.translucent());
        createSetRenderType(ModBlocks.SPECIAL_LANTERN, RenderType.cutout());
        createSetRenderType(ModBlocks.SPECIAL_SOUL_LANTERN, RenderType.cutout());
        createSetRenderType(ModBlocks.LILY_PAD, RenderType.cutout());
        createSetRenderType(ModBlocks.NETHER_SPROUTS, RenderType.cutout());
        createSetRenderType(ModBlocks.NETHER_WART_BLOCK, RenderType.cutout());
        createSetRenderType(ModBlocks.VINE, RenderType.cutout());
        createSetRenderType(ModBlocks.WARPED_WART_BLOCK, RenderType.cutout());
        createSetRenderType(ModBlocks.CRIMSON_FUNGUS, RenderType.cutout());
        createSetRenderType(ModBlocks.WARPED_FUNGUS, RenderType.cutout());
        createSetRenderType(ModBlocks.POINTED_DRIPSTONE, RenderType.cutout());
        createSetRenderType(ModBlocks.TORCH.getFirst(), RenderType.cutout());
        createSetRenderType(ModBlocks.TORCH.getSecond(), RenderType.cutout());
        createSetRenderType(ModBlocks.REDSTONE_TORCH.getFirst(), RenderType.cutout());
        createSetRenderType(ModBlocks.REDSTONE_TORCH.getSecond(), RenderType.cutout());
    }

    private static void createSetRenderType(ResourcefulRegistry<Block> registry, RenderType type) {
        registry.getEntries().forEach(b -> registerBlockRenderType(type, b));
    }

    @Expect
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block);
}
