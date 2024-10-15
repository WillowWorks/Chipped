package earth.terrarium.chipped.common.menus;

import earth.terrarium.chipped.common.blocks.WorkbenchBlock;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WorkbenchMenu extends AbstractContainerMenu {
    protected final Inventory inventory;
    protected final Level level;
    protected final RecipeType<ChippedRecipe> recipeType;

    private int selectedStackId;
    private ItemStack selectedStack = ItemStack.EMPTY;
    private ItemStack chosenStack = ItemStack.EMPTY;
    @Nullable
    private String filter;
    private final List<ItemStack> results = new ArrayList<>();

    public WorkbenchMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, getRecipeFromBuf(inventory.player.level(), buf));
    }

    public WorkbenchMenu(int containerId, Inventory inventory, RecipeType<ChippedRecipe> recipeType) {
        super(ModMenuTypes.WORKBENCH.get(), containerId);
        this.inventory = inventory;
        this.level = inventory.player.level();
        this.recipeType = recipeType;
        addPlayerInvSlots();
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    protected void addPlayerInvSlots() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new InventorySlot(inventory, j + i * 9 + 9, getPlayerInvXOffset() + j * 18, getPlayerInvYOffset() + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlot(new InventorySlot(inventory, i, getPlayerInvXOffset() + i * 18, getPlayerInvYOffset() + 58));
        }
    }

    public int getPlayerInvXOffset() {
        return 86;
    }

    public int getPlayerInvYOffset() {
        return 167;
    }


    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        selectStack(slotId);
        super.clicked(slotId, button, clickType, player);
    }

    public void selectStack(int slotId) {
        if (slotId < 0 || slotId >= slots.size()) return;
        selectedStackId = slots.get(slotId).getContainerSlot();
        selectedStack = slots.get(slotId).getItem();
        chosenStack = selectedStack;
        updateResults(filter);
    }

    public void updateResults(@Nullable String filter) {
        if (selectedStack.isEmpty()) return;
        this.filter = filter;
        SimpleContainer container = new SimpleContainer(selectedStack);
        level.getRecipeManager()
            .getRecipeFor(recipeType, container, level).ifPresentOrElse(recipe -> {
                results.clear();
                recipe.getResults(container.getItem(0)).forEach(result -> {
                    if (filter == null
                        || Util.isBlank(filter)
                        || result.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
                        results.add(result);
                    }
                });
            }, this::reset);
    }

    public void craft(ItemStack stack, boolean replaceAll) {
        if (stack.isEmpty()) return;

        boolean canCraft = false;
        for (var result : results) {
            if (ItemStack.isSameItemSameTags(result, stack)) {
                canCraft = true;
                break;
            }
        }
        if (!canCraft) return;

        inventory.setItem(selectedStackId, stack.copyWithCount(inventory.getItem(selectedStackId).getCount()));
        if (replaceAll) {
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                if (ItemStack.isSameItem(inventory.getItem(i), selectedStack)) {
                    inventory.setItem(i, stack.copyWithCount(inventory.getItem(i).getCount()));
                }
            }
        }

        reset();
    }

    public void reset() {
        selectedStackId = 0;
        selectedStack = ItemStack.EMPTY;
        chosenStack = ItemStack.EMPTY;
        results.clear();
    }

    public ItemStack selectedStack() {
        return selectedStack;
    }

    public ItemStack chosenStack() {
        return chosenStack;
    }

    public void setChosenStack(ItemStack stack) {
        chosenStack = stack;
    }

    public List<ItemStack> results() {
        return results;
    }

    public Level level() {
        return level;
    }

    public void setFilter(@Nullable String filter) {
        this.filter = filter;
    }

    protected static RecipeType<ChippedRecipe> getRecipeFromBuf(Level level, FriendlyByteBuf buf) {
        if (buf == null) return null;
        if (!level.isClientSide) return null;
        Block block = level.getBlockState(buf.readBlockPos()).getBlock();
        if (block instanceof WorkbenchBlock workbench) {
            return workbench.recipeType();
        }
        return null;
    }

    private static class InventorySlot extends Slot {
        public InventorySlot(Container container, int slot, int x, int y) {
            super(container, slot, x, y);
        }

        @Override
        public boolean mayPickup(Player player) {
            return false;
        }
    }
}