package earth.terrarium.chipped.common.recipes;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import org.jetbrains.annotations.NotNull;

public record ChippedRecipeDisplay(Ingredient ingredient) implements RecipeDisplay {

    public static RecipeDisplay create(Ingredient ingredient) {
        return new ChippedRecipeDisplay(ingredient);
    }

    @Override
    public @NotNull SlotDisplay result() {
        return this.ingredient.display();
    }

    @Override
    public @NotNull SlotDisplay craftingStation() {
        return SlotDisplay.Empty.INSTANCE;
    }

    @Override
    public Type<? extends RecipeDisplay> type() {
        return null;
    }
}
