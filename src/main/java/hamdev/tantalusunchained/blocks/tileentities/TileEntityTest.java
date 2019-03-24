package hamdev.tantalusunchained.blocks.tileentities;

import hamdev.tantalusunchained.ModBlocks;
import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ITickable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TileEntityTest extends TileEntity implements ITickable
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static TileEntityType<?> TestType;

//    public TileEntityTest(){
//        super(TestType = TileEntityType.Builder.create(TileEntityTest::new).build(null).setRegistryName(TantalusUnchained.MODID, "block_test"));
//    }

    public TileEntityTest()
    {
        super(ModBlocks.TYPE_TEST);
    }

    @Override
    public void tick()
    {
        if(!world.isRemote)
        {
            LOGGER.info("Ticking away");
        }
    }
}
