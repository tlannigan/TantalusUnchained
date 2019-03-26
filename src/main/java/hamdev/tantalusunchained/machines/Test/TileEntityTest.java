package hamdev.tantalusunchained.machines.Test;

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
