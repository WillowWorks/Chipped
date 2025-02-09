package earth.terrarium.chipped.datagen.provider.client.models;

import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModTexturedModels {

    public static TexturedModel.Provider cube(ChippedPaletteRegistry registry, String suffix) {
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.cube(texture(block, name).withSuffix(suffix)),
            ModelTemplates.CUBE_ALL
        );
    }

    public static TexturedModel.Provider cube(ChippedPaletteRegistry registry) {
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.cube(texture(block, name)),
            ModelTemplates.CUBE_ALL
        );
    }

    public static TexturedModel.Provider rotated(ChippedPaletteRegistry registry) {
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.singleSlot(TextureSlot.PATTERN, texture(block, name)),
            ModelTemplates.GLAZED_TERRACOTTA
        );
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
        String ogname = registry.getBasePath();
        String name = registry.getBasePath().replace("_carpet", "_wool");
        return TexturedModel.createDefault(
            block -> {
                ResourceLocation key = block.builtInRegistryHolder().key().location();
                return TextureMapping.wool(ResourceLocation.fromNamespaceAndPath(
                    key.getNamespace(),
                    "block/%s/%s".formatted(name, key.getPath().replaceAll(ogname, name))
                ));
            },
            ModelTemplates.CARPET
        );
    }

    private static ResourceLocation texture(Block block, String folder) {
        ResourceLocation key = block.builtInRegistryHolder().key().location();
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "block/%s/%s".formatted(folder, key.getPath()));
    }
}
