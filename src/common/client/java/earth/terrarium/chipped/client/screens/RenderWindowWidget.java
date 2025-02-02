package earth.terrarium.chipped.client.screens;

import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.CloseablePoseStack;
import com.teamresourceful.resourcefullib.client.components.CursorWidget;
import com.teamresourceful.resourcefullib.client.screens.CursorScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.function.Supplier;

public class RenderWindowWidget extends AbstractWidget implements CursorWidget {
    public static final BlockPos ORIGIN = BlockPos.ZERO;
    public static final BlockPos NORTH = BlockPos.ZERO.north();
    public static final BlockPos NORTH_UP = BlockPos.ZERO.north().above();
    public static final BlockPos SOUTH = BlockPos.ZERO.south();
    public static final BlockPos UP = BlockPos.ZERO.above();
    public static final BlockPos DOWN = BlockPos.ZERO.below();
    private static final Set<BlockPos> DOOR_POSITIONS_BOTTOM = Set.of(ORIGIN);
    private static final Set<BlockPos> DOOR_POSITIONS_TOP = Set.of(UP);

    private final Supplier<Mode> mode;
    private final Supplier<@Nullable BlockState> state;
    private final FakeLevel fakeLevel = new FakeLevel();

    public RenderWindowWidget(int x, int y, int width, int height, Supplier<Mode> mode, Supplier<BlockState> state) {
        super(x, y, width, height, CommonComponents.EMPTY);
        this.mode = mode;
        this.state = state;
    }

    @Override
    protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        Mode mode = this.mode.get();
        BlockState state = this.state.get();
        if (state == null) return;
        boolean isDoor = state.getBlock() instanceof DoorBlock;

        try (var pose = new CloseablePoseStack(graphics)) {
            pose.translate(getX(), getY(), 100);
            pose.translate(46, 46, 0);
            if (!isDoor) {
                pose.translate(mode.xOffset, mode.yOffset, 0);
            } else {
                pose.translate(5, 12, 0);
            }
            pose.scale(-20, -20, -20);

            pose.translate(0.5, 0.5, 0.5);
            pose.mulPose(Axis.XP.rotationDegrees(-30));
            pose.mulPose(Axis.YP.rotationDegrees(45));
            pose.translate(-0.5, -0.5, -0.5);

            fakeLevel.setState(state);
            if (isDoor) {
                fakeLevel.setPositions(DOOR_POSITIONS_BOTTOM);
                fakeLevel.renderBlock(pose);
                fakeLevel.setState(state.setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER));
                fakeLevel.setPositions(DOOR_POSITIONS_TOP);
                fakeLevel.renderBlock(pose);
            } else {
                fakeLevel.setPositions(mode.positions);
                fakeLevel.renderBlock(pose);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return false;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}

    @Override
    public CursorScreen.Cursor getCursor() {
        return CursorScreen.Cursor.DEFAULT;
    }

    public enum Mode {
        SINGLE_BLOCK(0, 0, ORIGIN),
        HORIZONTAL_BLOCK(0, 0, ORIGIN, NORTH, SOUTH),
        VERTICAL_BLOCK(0, 0, ORIGIN, UP, DOWN),
        TWO_BY_TWO(-7, 5, ORIGIN, NORTH, UP, NORTH_UP);

        private final int xOffset;
        private final int yOffset;
        private final Set<BlockPos> positions;

        Mode(int xOffset, int yOffset, BlockPos... positions) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            this.positions = Set.of(positions);
        }
    }
}
