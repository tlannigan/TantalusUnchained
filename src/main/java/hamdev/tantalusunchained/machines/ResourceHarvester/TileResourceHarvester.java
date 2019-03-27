package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
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
    private NBTTagCompound dateNBTData;
    private String[] dateArray;

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
            //LOGGER.info("Ticking away");
        }
    }

    private void outputResource() {
        //Logic for NBT shit

    }

    public NBTTagCompound writeNBTData()
    {
        //THIS IS AN EXAMPLE, MOFOS
        dateNBTData.setString("DateArray", "3/26/19 21:40,3/26/19 22:45,3/26/19 22:50,3/26/19 22:55,3/26/19 23:00");
        return dateNBTData;
    }

    public void readNBTData(NBTTagCompound dateNBTData)
    {
        dateArray = dateNBTData.getString("DateArray").split(",");
    }

}