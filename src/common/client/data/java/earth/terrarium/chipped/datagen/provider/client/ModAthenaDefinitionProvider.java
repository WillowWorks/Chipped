package earth.terrarium.chipped.datagen.provider.client;

import com.google.gson.JsonObject;
import earth.terrarium.athena.impl.client.DefaultModels;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModAthenaDefinitionProvider implements DataProvider {

    private static final String ATHENA = DefaultModels.MODID;
    private static final String LOADER_FIELD = ATHENA + ":loader";

    private final PackOutput output;
    private final ModCtmTextureProvider textures;
    private final List<ChippedPaletteRegistry> registries = new ArrayList<>();

    public ModAthenaDefinitionProvider(PackOutput output, ModCtmTextureProvider textures) {
        this.output = output;
        this.textures = textures;

        addRegistries();
    }

    public void addRegistries() {
        registries.add(ModBlocks.AMETHYST_BLOCK);
        registries.add(ModBlocks.COAL_BLOCK);
        registries.add(ModBlocks.CRYING_OBSIDIAN);
        registries.add(ModBlocks.LAPIS_BLOCK);
        registries.add(ModBlocks.BLUE_ICE);
        registries.add(ModBlocks.DIRT);
        registries.add(ModBlocks.ICE);
        registries.add(ModBlocks.PACKED_ICE);
        registries.add(ModBlocks.SNOW_BLOCK);
        registries.add(ModBlocks.ANCIENT_DEBRIS);
        registries.add(ModBlocks.ANDESITE);
        registries.add(ModBlocks.BASALT);
        registries.add(ModBlocks.BLACKSTONE);
        registries.add(ModBlocks.CALCITE);
        registries.add(ModBlocks.COBBLESTONE);
        registries.add(ModBlocks.DARK_PRISMARINE);
        registries.add(ModBlocks.DEEPSLATE);
        registries.add(ModBlocks.DIORITE);
        registries.add(ModBlocks.DRIPSTONE_BLOCK);
        registries.add(ModBlocks.END_STONE);
        registries.add(ModBlocks.GILDED_BLACKSTONE);
        registries.add(ModBlocks.GRANITE);
        registries.add(ModBlocks.MAGMA_BLOCK);
        registries.add(ModBlocks.MOSSY_COBBLESTONE);
        registries.add(ModBlocks.MOSSY_STONE_BRICKS);
        registries.add(ModBlocks.NETHER_BRICKS);
        registries.add(ModBlocks.NETHERRACK);
        registries.add(ModBlocks.OBSIDIAN);
        registries.add(ModBlocks.PRISMARINE);
        registries.add(ModBlocks.PURPUR_BLOCK);
        registries.add(ModBlocks.QUARTZ_BLOCK);
        registries.add(ModBlocks.RAW_COPPER_BLOCK);
        registries.add(ModBlocks.RAW_GOLD_BLOCK);
        registries.add(ModBlocks.RAW_IRON_BLOCK);
        registries.add(ModBlocks.RED_NETHER_BRICKS);
        registries.add(ModBlocks.RED_SANDSTONE);
        registries.add(ModBlocks.SANDSTONE);
        registries.add(ModBlocks.STONE);
        registries.add(ModBlocks.SMOOTH_STONE);
        registries.add(ModBlocks.TUFF);
        registries.add(ModBlocks.LODESTONE);
        registries.add(ModBlocks.REDSTONE_BLOCK);
        registries.add(ModBlocks.MUD);
        registries.add(ModBlocks.MUD_BRICKS);
        registries.add(ModBlocks.PACKED_MUD);
        registries.add(ModBlocks.CLAY);
        registries.add(ModBlocks.BRICKS);
        registries.add(ModBlocks.BORDERLESS_BRICKS);
        registries.add(ModBlocks.WHITE_WOOL);
        registries.add(ModBlocks.BLACK_WOOL);
        registries.add(ModBlocks.BLUE_WOOL);
        registries.add(ModBlocks.CYAN_WOOL);
        registries.add(ModBlocks.GRAY_WOOL);
        registries.add(ModBlocks.GREEN_WOOL);
        registries.add(ModBlocks.BROWN_WOOL);
        registries.add(ModBlocks.LIGHT_BLUE_WOOL);
        registries.add(ModBlocks.LIGHT_GRAY_WOOL);
        registries.add(ModBlocks.LIME_WOOL);
        registries.add(ModBlocks.MAGENTA_WOOL);
        registries.add(ModBlocks.ORANGE_WOOL);
        registries.add(ModBlocks.PINK_WOOL);
        registries.add(ModBlocks.PURPLE_WOOL);
        registries.add(ModBlocks.RED_WOOL);
        registries.add(ModBlocks.YELLOW_WOOL);
        registries.add(ModBlocks.WHITE_CARPET);
        registries.add(ModBlocks.BLACK_CARPET);
        registries.add(ModBlocks.BLUE_CARPET);
        registries.add(ModBlocks.CYAN_CARPET);
        registries.add(ModBlocks.GRAY_CARPET);
        registries.add(ModBlocks.GREEN_CARPET);
        registries.add(ModBlocks.BROWN_CARPET);
        registries.add(ModBlocks.LIGHT_BLUE_CARPET);
        registries.add(ModBlocks.LIGHT_GRAY_CARPET);
        registries.add(ModBlocks.LIME_CARPET);
        registries.add(ModBlocks.MAGENTA_CARPET);
        registries.add(ModBlocks.ORANGE_CARPET);
        registries.add(ModBlocks.PINK_CARPET);
        registries.add(ModBlocks.PURPLE_CARPET);
        registries.add(ModBlocks.RED_CARPET);
        registries.add(ModBlocks.YELLOW_CARPET);

        registries.add(ModBlocks.ACACIA_PLANKS);
        registries.add(ModBlocks.BIRCH_PLANKS);
        registries.add(ModBlocks.DARK_OAK_PLANKS);
        registries.add(ModBlocks.JUNGLE_PLANKS);
        registries.add(ModBlocks.MANGROVE_PLANKS);
        registries.add(ModBlocks.OAK_PLANKS);
        registries.add(ModBlocks.SPRUCE_PLANKS);
        registries.add(ModBlocks.CRIMSON_PLANKS);
        registries.add(ModBlocks.WARPED_PLANKS);
        registries.add(ModBlocks.CHERRY_PLANKS);
        registries.add(ModBlocks.BAMBOO_PLANKS);

        registries.add(ModBlocks.TERRACOTTA);
        registries.add(ModBlocks.WHITE_TERRACOTTA);
        registries.add(ModBlocks.BLACK_TERRACOTTA);
        registries.add(ModBlocks.BLUE_TERRACOTTA);
        registries.add(ModBlocks.CYAN_TERRACOTTA);
        registries.add(ModBlocks.GRAY_TERRACOTTA);
        registries.add(ModBlocks.GREEN_TERRACOTTA);
        registries.add(ModBlocks.BROWN_TERRACOTTA);
        registries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA);
        registries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA);
        registries.add(ModBlocks.LIME_TERRACOTTA);
        registries.add(ModBlocks.MAGENTA_TERRACOTTA);
        registries.add(ModBlocks.ORANGE_TERRACOTTA);
        registries.add(ModBlocks.PINK_TERRACOTTA);
        registries.add(ModBlocks.PURPLE_TERRACOTTA);
        registries.add(ModBlocks.RED_TERRACOTTA);
        registries.add(ModBlocks.YELLOW_TERRACOTTA);

        registries.add(ModBlocks.WHITE_CONCRETE);
        registries.add(ModBlocks.BLACK_CONCRETE);
        registries.add(ModBlocks.BLUE_CONCRETE);
        registries.add(ModBlocks.CYAN_CONCRETE);
        registries.add(ModBlocks.GRAY_CONCRETE);
        registries.add(ModBlocks.GREEN_CONCRETE);
        registries.add(ModBlocks.BROWN_CONCRETE);
        registries.add(ModBlocks.LIGHT_BLUE_CONCRETE);
        registries.add(ModBlocks.LIGHT_GRAY_CONCRETE);
        registries.add(ModBlocks.LIME_CONCRETE);
        registries.add(ModBlocks.MAGENTA_CONCRETE);
        registries.add(ModBlocks.ORANGE_CONCRETE);
        registries.add(ModBlocks.PINK_CONCRETE);
        registries.add(ModBlocks.PURPLE_CONCRETE);
        registries.add(ModBlocks.RED_CONCRETE);
        registries.add(ModBlocks.YELLOW_CONCRETE);

        registries.add(ModBlocks.GLASS);
        registries.add(ModBlocks.WHITE_STAINED_GLASS);
        registries.add(ModBlocks.BLACK_STAINED_GLASS);
        registries.add(ModBlocks.BLUE_STAINED_GLASS);
        registries.add(ModBlocks.CYAN_STAINED_GLASS);
        registries.add(ModBlocks.GRAY_STAINED_GLASS);
        registries.add(ModBlocks.GREEN_STAINED_GLASS);
        registries.add(ModBlocks.BROWN_STAINED_GLASS);
        registries.add(ModBlocks.LIGHT_BLUE_STAINED_GLASS);
        registries.add(ModBlocks.LIGHT_GRAY_STAINED_GLASS);
        registries.add(ModBlocks.LIME_STAINED_GLASS);
        registries.add(ModBlocks.MAGENTA_STAINED_GLASS);
        registries.add(ModBlocks.ORANGE_STAINED_GLASS);
        registries.add(ModBlocks.PINK_STAINED_GLASS);
        registries.add(ModBlocks.PURPLE_STAINED_GLASS);
        registries.add(ModBlocks.RED_STAINED_GLASS);
        registries.add(ModBlocks.YELLOW_STAINED_GLASS);

        registries.add(ModBlocks.GLASS_PANE);
        registries.add(ModBlocks.WHITE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BLACK_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BLUE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.CYAN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.GRAY_STAINED_GLASS_PANE);
        registries.add(ModBlocks.GREEN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BROWN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIME_STAINED_GLASS_PANE);
        registries.add(ModBlocks.MAGENTA_STAINED_GLASS_PANE);
        registries.add(ModBlocks.ORANGE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.PINK_STAINED_GLASS_PANE);
        registries.add(ModBlocks.PURPLE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.RED_STAINED_GLASS_PANE);
        registries.add(ModBlocks.YELLOW_STAINED_GLASS_PANE);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {

        for (ChippedPaletteRegistry registry : this.registries) {
            final String id = registry.getBasePath();
            for (var entry : registry.getPalette().getSpecial()) {
                var type = entry.getFirst();
                var loader = type.id();
                var blockid = entry.getSecond().replace("%", id);

                var path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
                    .resolve(registry.namespace())
                    .resolve(ATHENA)
                    .resolve(blockid + ".json");

                JsonObject json = new JsonObject();
                JsonObject textures = new JsonObject();

                // TODO - this is awful and is a temporary fix and should be removed and replaced with a proper solution and not a hack and a half and a half and a half and a half
                var badId = id.replaceAll("_pane$", "");
                var badBlockid = entry.getSecond().replace("%", badId);

                textures.addProperty("particle", "chipped:block/%s/%s".formatted(badId, badBlockid));
                String suffix = !type.suffix().isEmpty() ? "_" + type.suffix() : "";

                for (var textureId : type.getTextureIds()) {
                    String location = "%s:block/%s/ctm/%s/%s".formatted(Chipped.MOD_ID, badId, badBlockid + suffix, textureId.keyInt());
                    textures.addProperty(textureId.value(), this.textures.getTexture(location));
                }
                type.addTextureInfo(json);

                json.add("ctm_textures", textures);
                json.addProperty(LOADER_FIELD, "%s:%s".formatted(ATHENA, loader));
                DataProvider.saveStable(cache, json, path).join();
            }
        }

        return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Chipped Athena Definition Provider";
    }
}
