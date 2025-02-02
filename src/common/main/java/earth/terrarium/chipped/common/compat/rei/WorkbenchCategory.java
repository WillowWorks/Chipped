//package earth.terrarium.chipped.common.compat.rei;
//
//import earth.terrarium.chipped.common.registry.ModBlocks;
//import me.shedaniel.math.Point;
//import me.shedaniel.math.Rectangle;
//import me.shedaniel.rei.api.client.gui.Renderer;
//import me.shedaniel.rei.api.client.gui.widgets.Widget;
//import me.shedaniel.rei.api.client.gui.widgets.Widgets;
//import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import net.minecraft.network.chat.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WorkbenchCategory implements DisplayCategory<WorkbenchDisplay> {
//
//    @Override
//    public CategoryIdentifier<? extends WorkbenchDisplay> getCategoryIdentifier() {
//        return ChippedReiPlugin.ID;
//    }
//
//    @Override
//    public Component getTitle() {
//        return Component.translatable("container.chipped.workbench");
//    }
//
//    @Override
//    public Renderer getIcon() {
//        return EntryStacks.of(ModBlocks.MASON_TABLE.get());
//    }
//
//    @Override
//    public int getDisplayWidth(WorkbenchDisplay display) {
//        return 140;
//    }
//
//    @Override
//    public int getDisplayHeight() {
//        return 36;
//    }
//
//    @Override
//    public List<Widget> setupDisplay(WorkbenchDisplay display, Rectangle bounds) {
//        List<Widget> widgets = new ArrayList<>();
//        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
//        widgets.add(Widgets.createRecipeBase(bounds));
//        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
//        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
//        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5)).entries(display.getInputEntries().get(0)).markInput());
//        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
//        return widgets;
//    }
//}
