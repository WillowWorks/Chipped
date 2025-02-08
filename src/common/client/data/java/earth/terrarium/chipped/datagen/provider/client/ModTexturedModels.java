package earth.terrarium.chipped.datagen.provider.client;

import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModTexturedModels {

    public static TexturedModel.Provider cube(ChippedPaletteRegistry registry) {
        String name = registry.getBasePath();
        return TexturedModel.createDefault(
            block -> TextureMapping.cube(texture(block, name)),
            ModelTemplates.CUBE_ALL
        );
    }

    private static ResourceLocation texture(Block block, String folder) {
        ResourceLocation key = block.builtInRegistryHolder().key().location();
        return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), "block/%s/%s".formatted(folder, key.getPath()));
    }
}
