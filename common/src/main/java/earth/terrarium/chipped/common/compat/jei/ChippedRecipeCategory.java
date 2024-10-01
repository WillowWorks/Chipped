package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotDrawable;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class ChippedRecipeCategory extends AbstractRecipeCategory<ChippedRecipeCategory.FlattenedRecipe> {

    public static final RecipeType<FlattenedRecipe> BOTANIST_WORKBENCH_RECIPE = RecipeType.create(Chipped.MOD_ID, "botanist_workbench", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> GLASSBLOWER_RECIPE = RecipeType.create(Chipped.MOD_ID, "glassblower", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> CARPENTERS_TABLE_RECIPE = RecipeType.create(Chipped.MOD_ID, "carpenters_table", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> LOOM_TABLE_RECIPE = RecipeType.create(Chipped.MOD_ID, "loom_table", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> MASON_TABLE_RECIPE = RecipeType.create(Chipped.MOD_ID, "mason_table", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> ALCHEMY_BENCH_RECIPE = RecipeType.create(Chipped.MOD_ID, "alchemy_bench", FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> TINKERING_TABLE_RECIPE = RecipeType.create(Chipped.MOD_ID, "tinkering_table", FlattenedRecipe.class);

    private static Component getTitle(Item item) {
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(item);
        return Component.translatable("container.chipped." + resourceLocation.getPath());
    }

    public ChippedRecipeCategory(Item item, RecipeType<FlattenedRecipe> type, IGuiHelper guiHelper) {
        super(
            type,
            getTitle(item),
            guiHelper.createDrawableItemLike(item),
            142,
            110
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FlattenedRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(6, 9)
            .setStandardSlotBackground()
            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.TOP)
            .addItemStack(recipe.result);

        for (ItemStack stack : recipe.tag.getItems()) {
            builder.addOutputSlot()
                .addItemStack(stack);
        }
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, FlattenedRecipe recipe, IFocusGroup focuses) {
        List<IRecipeSlotDrawable> outputs = builder.getRecipeSlots().getSlots(RecipeIngredientRole.OUTPUT);

        builder.addScrollGridWidget(outputs, 7, 5)
            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
    }

    public record FlattenedRecipe(Ingredient tag, ItemStack result) {
    }
}
