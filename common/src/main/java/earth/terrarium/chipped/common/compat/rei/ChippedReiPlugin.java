package earth.terrarium.chipped.common.compat.rei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChippedReiPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<WorkbenchDisplay> ID = CategoryIdentifier.of(Chipped.MOD_ID, "workbench");

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new WorkbenchCategory());

        registry.addWorkstations(ID,
            EntryStacks.of(ModBlocks.BOTANIST_WORKBENCH.get()),
            EntryStacks.of(ModBlocks.GLASSBLOWER.get()),
            EntryStacks.of(ModBlocks.CARPENTERS_TABLE.get()),
            EntryStacks.of(ModBlocks.LOOM_TABLE.get()),
            EntryStacks.of(ModBlocks.MASON_TABLE.get()),
            EntryStacks.of(ModBlocks.ALCHEMY_BENCH.get()),
            EntryStacks.of(ModBlocks.TINKERING_TABLE.get())
        );
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager()
            .getAllRecipesFor(ModRecipeTypes.WORKBENCH.get()).forEach(recipe ->
                recipe.value().ingredients().forEach(ingredient ->
                    registry.registerRecipeFiller(ChippedRecipe.class, ModRecipeTypes.WORKBENCH.get(), r -> new WorkbenchDisplay(ingredient))));
    }

    private final List<ChippedPaletteRegistry<Block>> paletteRegistries = new ArrayList<>();

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ChippedRecipe> recipes = recipeManager.getAllRecipesFor(ModRecipeTypes.WORKBENCH.get()).stream()
            .map(recipe -> (ChippedRecipe) recipe.value())
                .toList();

        // Any of the base item keys in here is guaranteed to have at least one palette (left of the pair).
        // Any base item may also have further palettes (right of the pair).
        Object2IntArrayMap<String> palettes = new Object2IntArrayMap<>();

        // For each recipe, iterate over the ingredients for their stack arrays (which are the palettes).
        // Each ingredient's stack array is a palette, whose first item is the base item.
        recipes
            .stream()
            .map(ChippedRecipe::ingredients)
            .flatMap(List::stream)
            .map(Ingredient::getItems)
            .map(Arrays::asList)
            .forEach(ingredientStacks -> {
                // Get the base item from the first stack.
                Item baseItem = ingredientStacks.getFirst().getItem();

                // Get the description ID for the base item.
                String baseItemDescriptionId = baseItem.getDescriptionId();

                // Get the current palette index for this base item.
                int paletteIndex = palettes.getInt(baseItemDescriptionId);

                // Increment the palette index for the next palette.
                palettes.put(baseItemDescriptionId, paletteIndex + 1);

                // Importantly, we don't want the group to include the base item itself.
                ingredientStacks.removeFirst();

                // Register the palette group for this base item.
                registry.group(
                    // Create a new resource location for this palette's REI group.
                    ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "palettes/"
                        + BuiltInRegistries.ITEM.getKey(baseItem).getPath()
                        + "/"
                        + paletteIndex
                    ),
                    // The display name for this palette group is the base item's display name with the palette index appended.
                    Component.translatable(baseItemDescriptionId).append(" [Palette: " + paletteIndex + "]"),
                    EntryIngredients.ofItemStacks(ingredientStacks)
                );
            }
        );
    }
}
