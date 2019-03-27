package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TileResourceHarvester extends TileEntity implements ITickable
{
    private static final Logger LOGGER = LogManager.getLogger();

    public TileResourceHarvester()
    {
        super(ModBlocks.TYPE_TEST);
    }

    private Integer tickIterator;

    @Override
    public void tick()
    {
        if(!world.isRemote)
        {
            if (tickIterator >= 6000) {
                tickIterator = 0;
                outputResource();
            }
            tickIterator ++;
            LOGGER.info("Ticking away");
        }
    }

    private void outputResource() {
        //Logic for NBT shit

    }

    //@Override
    //public void deserializeNBT(NBTTagCompound nbt) {

    //}

    //@Override
    //public NBTTagCompound serializeNBT() {

        //  return ;
    //}
}