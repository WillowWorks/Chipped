package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModItems;
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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class WorkbenchCategory extends AbstractRecipeCategory<Ingredient> {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "workbench");
    public static final RecipeType<Ingredient> RECIPE = new RecipeType<>(ID, Ingredient.class);

    public WorkbenchCategory(IGuiHelper guiHelper) {
        super(
            RECIPE,
            Component.translatable("container.chipped.workbench"),
            guiHelper.createDrawableItemLike(ModItems.MASON_TABLE.get()),
            142,
            110
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Ingredient recipe, IFocusGroup focuses) {
        builder.addInputSlot(6, 9)
            .setStandardSlotBackground()
            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.TOP)
            .addIngredients(recipe);

        for (ItemStack stack : recipe.getItems()) {
            builder.addOutputSlot()
                .addItemStack(stack);
        }
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, Ingredient recipe, IFocusGroup focuses) {
        List<IRecipeSlotDrawable> outputs = builder.getRecipeSlots().getSlots(RecipeIngredientRole.OUTPUT);

        builder.addScrollGridWidget(outputs, 7, 5)
            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
    }
}
