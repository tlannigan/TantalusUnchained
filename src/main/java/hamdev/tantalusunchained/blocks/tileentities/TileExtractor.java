package hamdev.tantalusunchained.blocks.tileentities;

import hamdev.tantalusunchained.ModBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TileExtractor extends TileEntity implements ITickable
{
    private static final Logger LOGGER = LogManager.getLogger();

    public TileExtractor()
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