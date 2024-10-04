package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@JeiPlugin
public class ChippedJeiPlugin implements IModPlugin {

    private static final ResourceLocation UID = new ResourceLocation(Chipped.MOD_ID, "chipped");

    private static List<ChippedRecipeCategory.FlattenedRecipe> flatten(Collection<ChippedRecipe> recipes) {
        List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
        for (ChippedRecipe recipe : recipes) {
            for (HolderSet<Item> tag : recipe.tags()) {
                var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
                Ingredient ingredient = Ingredient.of(items.stream().map(ItemStack::new));
                for (Item item : items) {
                    flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(ingredient, new ItemStack(item)));
                }
            }
        }
        return flattenedRecipes;
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper helper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(
            new ChippedRecipeCategory(ModBlocks.BOTANIST_WORKBENCH.get().asItem(), ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.GLASSBLOWER.get().asItem(), ChippedRecipeCategory.GLASSBLOWER_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.CARPENTERS_TABLE.get().asItem(), ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.LOOM_TABLE.get().asItem(), ChippedRecipeCategory.LOOM_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.MASON_TABLE.get().asItem(), ChippedRecipeCategory.MASON_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.ALCHEMY_BENCH.get().asItem(), ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.TINKERING_TABLE.get().asItem(), ChippedRecipeCategory.TINKERING_TABLE_RECIPE, helper)

        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        registration.addRecipes(ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.BOTANIST_WORKBENCH.get())));
        registration.addRecipes(ChippedRecipeCategory.GLASSBLOWER_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.GLASSBLOWER.get())));
        registration.addRecipes(ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.CARPENTERS_TABLE.get())));
        registration.addRecipes(ChippedRecipeCategory.LOOM_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.LOOM_TABLE.get())));
        registration.addRecipes(ChippedRecipeCategory.MASON_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.MASON_TABLE.get())));
        registration.addRecipes(ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.ALCHEMY_BENCH.get())));
        registration.addRecipes(ChippedRecipeCategory.TINKERING_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.TINKERING_TABLE.get())));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModBlocks.BOTANIST_WORKBENCH.get(), ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.GLASSBLOWER.get(), ChippedRecipeCategory.GLASSBLOWER_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.CARPENTERS_TABLE.get(), ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.LOOM_TABLE.get(), ChippedRecipeCategory.LOOM_TABLE_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.MASON_TABLE.get(), ChippedRecipeCategory.MASON_TABLE_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.ALCHEMY_BENCH.get(), ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE);
        registration.addRecipeCatalyst(ModBlocks.TINKERING_TABLE.get(), ChippedRecipeCategory.TINKERING_TABLE_RECIPE);
    }
}
