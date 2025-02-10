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
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.column(texture(block, name), texture(block, name).withSuffix("_top")),
            ModelTemplates.CUBE_COLUMN
        );
    }

    public static TexturedModel.Provider column(ChippedPaletteRegistry registry, ResourceLocation end) {
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.column(texture(block, name), end),
            ModelTemplates.CUBE_COLUMN
        );
    }

    public static TexturedModel.Provider carpet(ChippedPaletteRegistry registry) {
        String name = registry.getBasePath();
        String root = registry.getRootPath();
        return TexturedModel.createDefault(
            block -> {
                ResourceLocation key = block.builtInRegistryHolder().key().location();
                return TextureMapping.wool(ResourceLocation.fromNamespaceAndPath(
                    key.getNamespace(),
                    "block/%s/%s".formatted(root, key.getPath().replaceAll(name, root))
                ));
            },
            ModelTemplates.CARPET
        );
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
        String name = registry.getBasePath();
        String root = registry.getRootPath();
        return create("template_glass_pane" + suffix, "", block -> {
            var key = block.builtInRegistryHolder().key().location();
            return ResourceLocation.fromNamespaceAndPath(
                key.getNamespace(),
                "block/%s/%s".formatted(root, key.getPath().replaceAll(name, root))
            );
        }, TextureSlot.EDGE, TextureSlot.PANE);
    }

    private static TexturedModel.Provider create(ChippedPaletteRegistry registry, String template, TextureSlot... slots) {
        return create(registry, template, "", slots);
    }

    private static TexturedModel.Provider create(ChippedPaletteRegistry registry, String template, String suffix, TextureSlot... slots) {
        String name = registry.getBasePath();
        return create(template, suffix, block -> texture(block, name), slots);
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

    public static ResourceLocation texture(Block block, String folder) {
        ResourceLocation key = block.builtInRegistryHolder().key().location();
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "block/%s/%s".formatted(folder, key.getPath()));
    }
}
