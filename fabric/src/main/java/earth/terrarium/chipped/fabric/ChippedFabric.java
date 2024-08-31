package earth.terrarium.chipped.fabric;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ChippedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Chipped.init();
        ModBlocks.BARREL.stream().map(RegistryEntry::get).forEach(((FabricBlockEntityType) BlockEntityType.BARREL)::addSupportedBlock);
    }
}
