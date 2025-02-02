package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, Chipped.MOD_ID);

    public static final RegistryEntry<CodecRecipeSerializer<ChippedRecipe>> WORKBENCH = RECIPE_SERIALIZERS.register("workbench", () ->
        new CodecRecipeSerializer<>(ModRecipeTypes.WORKBENCH.get(), ChippedRecipe.CODEC, ChippedRecipe.NETWORK_CODEC));
}
