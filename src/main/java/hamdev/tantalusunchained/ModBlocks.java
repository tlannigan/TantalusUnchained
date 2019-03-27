package hamdev.tantalusunchained;

import hamdev.tantalusunchained.machines.ResourceHarvester.BlockResourceHarvester;
import hamdev.tantalusunchained.machines.Test.BlockTest;
import hamdev.tantalusunchained.machines.Test.TileEntityTest;
import hamdev.tantalusunchained.machines.ResourceHarvester.TileResourceHarvester;
import hamdev.tantalusunchained.machines.ResourceHarvester.ItemBlockResourceHarvester;
import hamdev.tantalusunchained.machines.Test.ItemBlockTest;
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
    public static final ItemBlock itemBlockTest = new ItemBlockTest(blockTest);

    public static TileEntityType<?> TYPE_RESOURCE_HARVESTER;
    public static final Block blockResourceHarvester = new BlockResourceHarvester();
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
        registry.register(TYPE_RESOURCE_HARVESTER = TileEntityType.Builder.create(TileResourceHarvester::new).build(null).setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "block_resource_harvester")));
    }
}
