package earth.terrarium.chipped.client.screens;

import com.teamresourceful.resourcefullib.client.screens.AbstractContainerCursorScreen;
import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.network.ServerboundCraftPacket;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkbenchScreen extends AbstractContainerCursorScreen<WorkbenchMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "textures/gui/container/workbench.png");

    public static final WidgetSprites SINGLE_BLOCK_BUTTON_SPRITES = new WidgetSprites(
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "single_block_button"),
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "single_block_button_highlighted")
    );

    public static final WidgetSprites HORIZONTAL_BLOCKS_BUTTON_SPRITES = new WidgetSprites(
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "horizontal_blocks_button"),
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "horizontal_blocks_button_highlighted")
    );

    public static final WidgetSprites VERTICAL_BLOCKS_BUTTON_SPRITES = new WidgetSprites(
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "vertical_blocks_button"),
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "vertical_blocks_button_highlighted")
    );

    public static final WidgetSprites TWO_BY_TWO_BUTTON_SPRITES = new WidgetSprites(
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "two_by_two_button"),
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "two_by_two_button_highlighted")
    );

    public static final WidgetSprites BUTTON_SPRITES = new WidgetSprites(
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "button"),
        ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "button_highlighted")
    );

    public static final int YELLOW = 0x70FFFF00;
    public static final int BLUE = 0x700000FF;
    public static final int DARK_GRAY = 0x70000000;

    private static final Component PREVIEW_TEXT = Component.translatable("text.chipped.preview");
    private static final Component CRAFT_TEXT = Component.translatable("text.chipped.craft");
    private static final Component CRAFT_ALL_TEXT = Component.translatable("text.chipped.craft_all");
    private static final Component SINGLE_TEXT = Component.translatable("text.chipped.single");
    private static final Component HORIZONTAL_TEXT = Component.translatable("text.chipped.horizontal");
    private static final Component VERTICAL_TEXT = Component.translatable("text.chipped.vertical");
    private static final Component TWO_BY_TWO_TEXT = Component.translatable("text.chipped.two_by_two");

    protected EditBox searchBox;
    protected double scrollAmount;
    protected RenderWindowWidget renderWindow;

    protected GridLayout grid;
    protected final List<SlotWidget> slotWidgets = new ArrayList<>();
    protected RenderWindowWidget.Mode mode = RenderWindowWidget.Mode.TWO_BY_TWO;

    public WorkbenchScreen(WorkbenchMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.imageWidth = 256;
        this.imageHeight = 256;
        this.titleLabelX = 88;
        this.titleLabelY = 14;
        this.inventoryLabelY = 155;
        this.inventoryLabelX = 88;
    }

    @Override
    protected void init() {
        super.init();

        searchBox = addRenderableWidget(new EditBox(font, leftPos + 105, topPos + 27, 115, 11, Component.empty()));
        searchBox.setTextColor(-1);
        searchBox.setTextColorUneditable(-1);
        searchBox.setBordered(false);
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::onSearchBarChanged);
        searchBox.setEditable(false);

        addRenderableWidget(new ImageButton(leftPos + 9, topPos + 121,
            18, 18,
            SINGLE_BLOCK_BUTTON_SPRITES,
            button -> mode = RenderWindowWidget.Mode.SINGLE_BLOCK)).setTooltip(Tooltip.create(SINGLE_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 27, topPos + 121,
            18, 18,
            HORIZONTAL_BLOCKS_BUTTON_SPRITES,
            button -> mode = RenderWindowWidget.Mode.HORIZONTAL_BLOCK)).setTooltip(Tooltip.create(HORIZONTAL_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 45, topPos + 121,
            18, 18,
            VERTICAL_BLOCKS_BUTTON_SPRITES,
            button -> mode = RenderWindowWidget.Mode.VERTICAL_BLOCK)).setTooltip(Tooltip.create(VERTICAL_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 63, topPos + 121,
            18, 18,
            TWO_BY_TWO_BUTTON_SPRITES,
            button -> mode = RenderWindowWidget.Mode.TWO_BY_TWO)).setTooltip(Tooltip.create(TWO_BY_TWO_TEXT));

        addRenderableWidget(new ImageButton(leftPos + 9, topPos + 101,
            72, 18,
            BUTTON_SPRITES,
            button -> craft()));

        addSlotWidgets();

        renderWindow = addRenderableWidget(new RenderWindowWidget(
            leftPos + 9,
            topPos + 26,
            72,
            72,
            this::mode,
            this::state));
    }

    private void addSlotWidgets() {
        slotWidgets.forEach(this::removeWidget);
        slotWidgets.clear();

        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        grid = new GridLayout(left + 85, top + 41);
        var results = menu.results();
        int rows = Math.max(6, Mth.ceil(results.size() / 9f));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < rows; j++) {
                int index = i + j * 9;
                var stack = results.size() > index ? results.get(index) : ItemStack.EMPTY;
                SlotWidget slot = addWidget(new SlotWidget(stack, menu, top + 40, top + 141));
                grid.addChild(slot, j, i);
                slotWidgets.add(slot);
            }
        }
        grid.arrangeElements();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.renderBackground(graphics, mouseX, mouseY, partialTick);
        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        grid.setY(top + 41 - (int) scrollAmount);
        try (var ignored = RenderUtils.createScissorBox(Objects.requireNonNull(minecraft), graphics.pose(), left + 84, top + 40, 163, 109)) {
            for (var widget : slotWidgets) {
                widget.renderWidget(graphics, mouseX, mouseY, partialTick);
            }
        }

        for (var widget : slotWidgets) {
            widget.renderTooltip(graphics, font, mouseX, mouseY);
        }
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        graphics.blit(RenderType::guiTextured, TEXTURE, left, top, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        graphics.drawString(font, PREVIEW_TEXT, left + 11, top + 14, 0x404040, false);
        graphics.drawCenteredString(font, hasShiftDown() ? CRAFT_ALL_TEXT : CRAFT_TEXT, left + 45, top + 106, 0x404040);

        var stack = menu.chosenStack();
        if (stack.isEmpty()) return;

        var selectedStack = menu.selectedStack();
        if (selectedStack.isEmpty()) return;
        for (var slot : menu.slots) {
            if (selectedStack.equals(slot.getItem()) || (ItemStack.isSameItem(selectedStack, slot.getItem()) && hasShiftDown())) {
                graphics.fill(slot.x + left - 1, slot.y + top - 1, slot.x + left + 17, slot.y + top + 17, YELLOW);
            } else if (ItemStack.isSameItem(selectedStack, slot.getItem())) {
                graphics.fill(slot.x + left - 1, slot.y + top - 1, slot.x + left + 17, slot.y + top + 17, BLUE);
            } else {
                graphics.fill(slot.x + left - 1, slot.y + top - 1, slot.x + left + 17, slot.y + top + 17, DARK_GRAY);
            }
        }
    }

    private void onSearchBarChanged(String filter) {
        scrollAmount = 0;
        menu.updateResults(filter);
        addSlotWidgets();
    }

    @Override
    protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType type) {
        super.slotClicked(slot, slotId, mouseButton, type);
        addSlotWidgets();
        searchBox.setEditable(!menu.selectedStack().isEmpty());
        scrollAmount = 0;
        menu.setFilter(searchBox.getValue());
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            onClose();
            return true;
        }

        if (getFocused() == searchBox) {
            return searchBox.keyPressed(keyCode, scanCode, modifiers)
                || searchBox.canConsumeInput()
                || super.keyPressed(keyCode, scanCode, modifiers);
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (getFocused() != searchBox) {
            setFocused(null);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (menu.results().size() <= 54) return false;
        setScrollAmount(scrollAmount - scrollY * 16 / 2f);
        return true;
    }

    protected void setScrollAmount(double amount) {
        int rows = Mth.ceil(menu.results().size() / 9f);
        scrollAmount = Mth.clamp(amount, 0, rows * 18 - 108);
    }

    public void craft() {
        if (!menu.selectedStack().isEmpty()) {
            NetworkHandler.CHANNEL.sendToServer(new ServerboundCraftPacket(menu.chosenStack(), hasShiftDown()));
            Objects.requireNonNull(minecraft).getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_TAKE_RESULT, 1, 1));
            menu.reset();
            addSlotWidgets();
            scrollAmount = 0;
            setFocused(null);
        }
    }

    public RenderWindowWidget.Mode mode() {
        return mode;
    }

    public BlockState state() {
        Block block = Block.byItem(menu.chosenStack().getItem());
        if (block instanceof IronBarsBlock) {
            return block.defaultBlockState()
                .setValue(IronBarsBlock.NORTH, true)
                .setValue(IronBarsBlock.SOUTH, true);
        }
        BlockState state = block.defaultBlockState();
        return state.isAir() ? null : state;
    }
}