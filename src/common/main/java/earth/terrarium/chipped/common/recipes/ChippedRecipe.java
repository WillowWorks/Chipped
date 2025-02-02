package earth.terrarium.chipped.common.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.bytecodecs.base.object.ObjectByteCodec;
import com.teamresourceful.resourcefullib.common.bytecodecs.ExtraByteCodecs;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import earth.terrarium.chipped.common.registry.ModRecipeSerializers;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

public record ChippedRecipe(
    List<Ingredient> ingredients
) implements CodecRecipe<RecipeInput> {

    public static final MapCodec<ChippedRecipe> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(ChippedRecipe::ingredients)
        ).apply(instance, ChippedRecipe::new));

    public static final ByteCodec<ChippedRecipe> NETWORK_CODEC = ObjectByteCodec.create(
        ExtraByteCodecs.INGREDIENT.listOf().fieldOf(ChippedRecipe::ingredients),
        ChippedRecipe::new
    );

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        ItemStack stack = recipeInput.getItem(0);
        return !stack.isEmpty() && this.ingredients.stream().anyMatch(ingredient -> ingredient.test(stack));
    }

    @Override
    public @NotNull List<RecipeDisplay> display() {
        return this.ingredients.stream().map(ChippedRecipeDisplay::create).toList();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }


    @Override
    public @NotNull ItemStack assemble(RecipeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull CodecRecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return ModRecipeSerializers.WORKBENCH.get();
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return ModRecipeTypes.WORKBENCH.get();
    }

    @Override
    public @NotNull PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }
}