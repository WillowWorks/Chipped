package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, Chipped.MOD_ID);

    public static final RegistryEntry<RecipeType<ChippedRecipe>> WORKBENCH = RECIPE_TYPES.register("workbench", () -> new RecipeType<>() {
        @Override
        public String toString() {
            return "workbench";
        }
    });
}
