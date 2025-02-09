package earth.terrarium.chipped.common.registry.base;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import earth.terrarium.chipped.common.palette.Palette;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ChippedPaletteRegistry extends ResourcefulBlockRegistry {

    public static final List<ChippedPaletteRegistry> REGISTRIES = new ArrayList<>();

    private final Block parent;
    private final Block base;
    private final Palette palette;
    @Nullable
    private final String customBase;

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> registry, Block base, Palette palette) {
        this(registry, base, base, palette);
    }

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> registry, Block parent, Block base, Palette palette) {
        this(registry, parent, base, null, palette);
    }

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> registry, Block parent, Block base, @Nullable String customBase, Palette palette) {
        super(ResourcefulRegistries.create(registry));
        this.parent = parent;
        this.base = base;
        this.palette = palette;
        this.customBase = customBase;

        REGISTRIES.add(this);
    }

    public Block getBase() {
        return base;
    }

    public String getBasePath() {
        if (this.customBase != null) return this.customBase;
        return BuiltInRegistries.BLOCK.getKey(this.base).getPath();
    }

    public String getRootPath() {
        if (this.customBase != null) return this.customBase;
        return BuiltInRegistries.BLOCK.getKey(this.parent).getPath();
    }

    public Palette getPalette() {
        return palette;
    }
}
