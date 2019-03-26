package hamdev.tantalusunchained;

import hamdev.tantalusunchained.blocks.BlockResourceHarvester;
import hamdev.tantalusunchained.blocks.BlockTest;
import hamdev.tantalusunchained.blocks.tileentities.TileEntityTest;
import hamdev.tantalusunchained.blocks.tileentities.TileResourceHarvester;
import hamdev.tantalusunchained.items.itemblocks.ItemBlockResourceHarvester;
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
    public static final Block blockResourceHarvester = new BlockResourceHarvester();

    public static final ItemBlock itemBlockTest = new ItemBlockTest(blockTest);
    public static final ItemBlock itemBlockResourceHarvester = new ItemBlockResourceHarvester(blockResourceHarvester);


    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(blockTest);
        registry.register(blockResourceHarvester);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        registry.register(itemBlockTest);
        registry.register(itemBlockResourceHarvester);
    }

    public static void registerTileEntities(IForgeRegistry<TileEntityType<?>> registry)
    {
        registry.register(TYPE_TEST = TileEntityType.Builder.create(TileEntityTest::new).build(null).setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "block_test")));
        registry.register(TYPE_TEST = TileEntityType.Builder.create(TileResourceHarvester::new).build(null).setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "block_resource_harvester")));
    }
}
