package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeModeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulItemRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.base.ItemLikeEntry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.items.WorkbenchItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;

public class ModItems {
    public static final ResourcefulItemRegistry ITEMS = ResourcefulRegistries.createForItems(Chipped.MOD_ID);
    public static final ResourcefulItemRegistry BENCHES = ResourcefulRegistries.createForItems(ITEMS);

    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, Chipped.MOD_ID);
    public static final RegistryEntry<CreativeModeTab> TAB = TABS.register("main", () -> new ResourcefulCreativeModeTab(ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "main"))
        .setItemIcon(() -> ModItems.BOTANIST_WORKBENCH.get())
        .addRegistry(ITEMS)
        .build());

    public static final ItemLikeEntry<BlockItem> BOTANIST_WORKBENCH = ITEMS.register("botanist_workbench", ModBlocks.BOTANIST_WORKBENCH, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> GLASSBLOWER = ITEMS.register("glassblower", ModBlocks.GLASSBLOWER, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> CARPENTERS_TABLE = ITEMS.register("carpenters_table", ModBlocks.CARPENTERS_TABLE, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> LOOM_TABLE = ITEMS.register("loom_table", ModBlocks.LOOM_TABLE, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> MASON_TABLE = ITEMS.register("mason_table", ModBlocks.MASON_TABLE, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> ALCHEMY_BENCH = ITEMS.register("alchemy_bench", ModBlocks.ALCHEMY_BENCH, Item.Properties::new);
    public static final ItemLikeEntry<BlockItem> TINKERING_TABLE = ITEMS.register("tinkering_table", ModBlocks.TINKERING_TABLE, Item.Properties::new);

    public static final ItemLikeEntry<Item> WATERING_CAN = ITEMS.register("watering_can", WorkbenchItem::new, Item.Properties::new);
    public static final ItemLikeEntry<Item> ALCHEMY_BOOK = ITEMS.register("alchemy_book", WorkbenchItem::new, Item.Properties::new);
    public static final ItemLikeEntry<Item> SAW = ITEMS.register("saw", WorkbenchItem::new, Item.Properties::new);
    public static final ItemLikeEntry<Item> NEEDLES = ITEMS.register("needles", WorkbenchItem::new, Item.Properties::new);
    public static final ItemLikeEntry<Item> CHISEL = ITEMS.register("chisel", WorkbenchItem::new, Item.Properties::new);
    public static final ItemLikeEntry<Item> MULTIMETER = ITEMS.register("multimeter", WorkbenchItem::new, Item.Properties::new);

    public static void createItemRegistry(ResourcefulRegistry<Block> blocks, BiFunction<Block, Item.Properties, BlockItem> itemType) {
        var registry = ResourcefulRegistries.createForItems(ModItems.ITEMS);
        blocks.stream().forEach(block -> registry.register(
            block.getId().getPath(),
            (properties) -> itemType.apply(block.get(), properties),
            () -> new Item.Properties().useBlockDescriptionPrefix()
        ));
    }
}
