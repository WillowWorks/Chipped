package earth.terrarium.chipped.neoforge;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@Mod(Chipped.MOD_ID)
public class ChippedNeoForge {
    public ChippedNeoForge(IEventBus bus) {
        Chipped.init();

        bus.addListener((BlockEntityTypeAddBlocksEvent event) -> {
            ModBlocks.BARREL.stream().map(RegistryEntry::get).forEach(block -> event.modify(BlockEntityType.BARREL, block));
        });
    }
}
