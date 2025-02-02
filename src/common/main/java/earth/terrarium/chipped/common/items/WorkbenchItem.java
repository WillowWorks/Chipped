package earth.terrarium.chipped.common.items;

import earth.terrarium.chipped.common.menus.WorkbenchMenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WorkbenchItem extends Item {

    public WorkbenchItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        var stack = player.getItemInHand(usedHand);
        player.openMenu(new WorkbenchMenuProvider(getName(stack)));
        return InteractionResult.SUCCESS;
    }
}
