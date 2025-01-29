package earth.terrarium.chipped.common.registry.base;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import earth.terrarium.chipped.common.palette.Palette;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChippedPaletteRegistry extends ResourcefulBlockRegistry {

    private final Block base;
    private final Palette palette;
    @Nullable
    private final String customBase;

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> registry, Block base, Palette palette) {
        this(registry, base, null, palette);
    }

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> registry, Block base, @Nullable String customBase, Palette palette) {
        super(ResourcefulRegistries.create(registry));
        this.base = base;
        this.palette = palette;
        this.customBase = customBase;
    }

    public Block getBase() {
        return base;
    }

    public Optional<String> getCustomBase() {
        return Optional.ofNullable(customBase);
    }

    public Palette getPalette() {
        return palette;
    }
}
