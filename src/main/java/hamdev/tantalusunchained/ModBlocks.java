package hamdev.tantalusunchained;

import hamdev.tantalusunchained.blocks.BlockExtractor;
import hamdev.tantalusunchained.blocks.BlockTest;
import hamdev.tantalusunchained.blocks.tileentities.TileEntityTest;
import hamdev.tantalusunchained.blocks.tileentities.TileExtractor;
import hamdev.tantalusunchained.items.itemblocks.ItemBlockExtractor;
import hamdev.tantalusunchained.items.itemblocks.ItemBlockTest;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
    public static TileEntityType<?> TYPE_TEST;

    public static final Block blockTest = new BlockTest();
    public static final Block blockExtractor = new BlockExtractor();

    public static final ItemBlock itemBlockTest = new ItemBlockTest(blockTest);
    public static final ItemBlock itemBlockExtractor = new ItemBlockExtractor(blockExtractor);


    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(blockTest);
        registry.register(blockExtractor);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        registry.register(itemBlockTest);
        registry.register(itemBlockExtractor);
    }

    public static void registerTileEntities(IForgeRegistry<TileEntityType<?>> registry)
    {
        registry.register(TYPE_TEST = TileEntityType.Builder.create(TileEntityTest::new).build(null).setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "block_test")));
        registry.register(TYPE_TEST = TileEntityType.Builder.create(TileExtractor::new).build(null).setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "block_extractor")));
    }
}
