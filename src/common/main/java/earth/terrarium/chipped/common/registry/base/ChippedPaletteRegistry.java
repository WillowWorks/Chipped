package earth.terrarium.chipped.common.registry.base;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import earth.terrarium.chipped.common.palette.Palette;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

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

    public String getBasePath() {
        if (this.customBase != null) return this.customBase;
        return BuiltInRegistries.BLOCK.getKey(this.base).getPath();
    }

    public Palette getPalette() {
        return palette;
    }
}
