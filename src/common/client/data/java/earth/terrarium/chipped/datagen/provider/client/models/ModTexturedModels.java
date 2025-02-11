package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModTexturedModels {

    public static TexturedModel.Provider cube(ChippedPaletteRegistry registry, String suffix) {
        return create(registry, "cube_all", suffix, TextureSlot.ALL);
    }

    public static TexturedModel.Provider cube(ChippedPaletteRegistry registry) {
        return create(registry, "cube_all", TextureSlot.ALL);
    }

    public static TexturedModel.Provider rotated(ChippedPaletteRegistry registry) {
        return create(registry, "template_glazed_terracotta", TextureSlot.PATTERN);
    }

    public static TexturedModel.Provider column(ChippedPaletteRegistry registry) {
        return TexturedModel.createDefault(
            block -> TextureMapping.column(texture(registry, block), texture(registry, block).withSuffix("_top")),
            ModelTemplates.CUBE_COLUMN
        );
    }

    public static TexturedModel.Provider column(ChippedPaletteRegistry registry, ResourceLocation end) {
        return TexturedModel.createDefault(block -> TextureMapping.column(texture(registry, block), end), ModelTemplates.CUBE_COLUMN);
    }

    public static TexturedModel.Provider columnTop(ChippedPaletteRegistry registry) {
        return TexturedModel.createDefault(
            block -> TextureMapping.column(texture(registry, block).withSuffix("_side"), texture(registry, block).withSuffix("_top")),
            ModelTemplates.CUBE_COLUMN
        );
    }

    public static TexturedModel.Provider columnTopBottom(ChippedPaletteRegistry registry) {
        return columnTopBottom(registry, "");
    }

    public static TexturedModel.Provider columnTopBottom(ChippedPaletteRegistry registry, String topSuffix) {
        return TexturedModel.createDefault(block -> new TextureMapping()
                .put(TextureSlot.TOP, texture(registry, block).withSuffix("_top").withSuffix(topSuffix))
                .put(TextureSlot.BOTTOM, texture(registry, block).withSuffix("_bottom"))
                .put(TextureSlot.SIDE, texture(registry, block).withSuffix("_side")),
            ModelTemplates.CUBE_BOTTOM_TOP
        );
    }

    public static TexturedModel.Provider carpet(ChippedPaletteRegistry registry) {
        return TexturedModel.createDefault(block -> TextureMapping.wool(texture(registry, block)), ModelTemplates.CARPET);
    }

    public static TexturedModel.Provider lilypad(ChippedPaletteRegistry registry) {
        return create(registry, "lily_pad", TextureSlot.TEXTURE);
    }

    public static TexturedModel.Provider cross(ChippedPaletteRegistry registry) {
        return create(registry, "cross", TextureSlot.CROSS);
    }

    public static TexturedModel.Provider ladder(ChippedPaletteRegistry registry) {
        return create(registry, "ladder", TextureSlot.TEXTURE);
    }

    public static TexturedModel.Provider ironbars(ChippedPaletteRegistry registry, String suffix) {
        return create(registry, "iron_bars" + suffix, TextureSlot.create("edge"), TextureSlot.create("bars"));
    }

    public static TexturedModel.Provider pane(ChippedPaletteRegistry registry, String suffix) {
        return create("template_glass_pane" + suffix, "", block -> texture(registry, block), TextureSlot.EDGE, TextureSlot.PANE);
    }

    public static TexturedModel.Provider trapdoor(ChippedPaletteRegistry registry, String suffix) {
        return create("template_trapdoor" + suffix, "", block -> texture(registry, block), TextureSlot.TEXTURE);
    }

    public static TexturedModel.Provider door(ChippedPaletteRegistry registry, String suffix) {
        return create("door" + suffix, suffix.replaceAll("(_left|_right)(_open)?$", ""),
            block -> texture(registry, block),
            TextureSlot.TOP, TextureSlot.BOTTOM
        );
    }

    private static TexturedModel.Provider create(ChippedPaletteRegistry registry, String template, TextureSlot... slots) {
        return create(registry, template, "", slots);
    }

    private static TexturedModel.Provider create(ChippedPaletteRegistry registry, String template, String suffix, TextureSlot... slots) {
        return create(template, suffix, block -> texture(registry, block), slots);
    }

    private static TexturedModel.Provider create(String template, String suffix, Function<Block, ResourceLocation> texture, TextureSlot... slots) {
        return TexturedModel.createDefault(
            block -> {
                var mapping = new TextureMapping();
                for (TextureSlot slot : slots) mapping.put(slot, texture.apply(block).withSuffix(suffix));
                return mapping;
            },
            ModelTemplates.create(template, slots)
        );
    }

    @SuppressWarnings("deprecation")
    public static ResourceLocation texture(ChippedPaletteRegistry registry, Block block) {
        String base = registry.getBasePath();
        String root = registry.getRootPath();
        ResourceLocation key = block.builtInRegistryHolder().key().location();
        return ResourceLocation.fromNamespaceAndPath(
            key.getNamespace(),
            "block/%s/%s".formatted(root, key.getPath().replaceAll(base, root))
        );
    }
}
