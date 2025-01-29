//package earth.terrarium.chipped.common.compat.jei;
//
//import earth.terrarium.chipped.Chipped;
//import earth.terrarium.chipped.common.registry.ModItems;
//import earth.terrarium.chipped.common.registry.ModRecipeTypes;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.registration.IRecipeCatalystRegistration;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.client.Minecraft;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeManager;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//import java.util.Objects;
//
//@JeiPlugin
//public class ChippedJeiPlugin implements IModPlugin {
//
//    @Override
//    public @NotNull ResourceLocation getPluginUid() {
//        return ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "jei");
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new WorkbenchCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//        recipeManager.getAllRecipesFor(ModRecipeTypes.WORKBENCH.get())
//            .forEach(recipe -> {
//                List<Ingredient> ingredients = recipe.value().ingredients();
//                registration.addRecipes(WorkbenchCategory.RECIPE, ingredients);
//            });
//    }
//
//    @Override
//    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalysts(WorkbenchCategory.RECIPE,
//            ModItems.BOTANIST_WORKBENCH.get(),
//            ModItems.GLASSBLOWER.get(),
//            ModItems.CARPENTERS_TABLE.get(),
//            ModItems.LOOM_TABLE.get(),
//            ModItems.MASON_TABLE.get(),
//            ModItems.ALCHEMY_BENCH.get(),
//            ModItems.TINKERING_TABLE.get()
//        );
//    }
//}
