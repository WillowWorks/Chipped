package earth.terrarium.chipped.mixins;

import earth.terrarium.chipped.Chipped;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {

    @Inject(
        method = "getDrops",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/Collections;emptyList()Ljava/util/List;",
            ordinal = 0
        ),
        cancellable = true
    )
    private void chipped$getDrops(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        //noinspection ConstantValue
        if (((Object) this) instanceof Block block) {
            final var blockId = BuiltInRegistries.BLOCK.getKey(block);
            if (blockId.getNamespace().equals(Chipped.MOD_ID)) {
                final var id = ResourceLocation.fromNamespaceAndPath(blockId.getNamespace(), "blocks/" + blockId.getPath());
                final var table = builder.getLevel().getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, id));
                if (table != LootTable.EMPTY) {
                    final LootParams context = builder.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
                    cir.setReturnValue(table.getRandomItems(context));
                } else if (!state.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) || state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                    cir.setReturnValue(List.of(new ItemStack(block)));
                }
            }
        }
    }
}
