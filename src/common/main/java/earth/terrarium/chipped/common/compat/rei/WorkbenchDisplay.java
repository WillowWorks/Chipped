//package earth.terrarium.chipped.common.compat.rei;
//
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.display.Display;
//import me.shedaniel.rei.api.common.entry.EntryIngredient;
//import me.shedaniel.rei.api.common.util.EntryIngredients;
//import net.minecraft.world.item.crafting.Ingredient;
//
//import java.util.List;
//
//public record WorkbenchDisplay(Ingredient ingredient) implements Display {
//
//    @Override
//    public List<EntryIngredient> getInputEntries() {
//        return List.of(EntryIngredients.ofIngredient(ingredient));
//    }
//
//    @Override
//    public List<EntryIngredient> getOutputEntries() {
//        return List.of(EntryIngredients.ofIngredient(ingredient));
//    }
//
//    @Override
//    public CategoryIdentifier<?> getCategoryIdentifier() {
//        return ChippedReiPlugin.ID;
//    }
//}
