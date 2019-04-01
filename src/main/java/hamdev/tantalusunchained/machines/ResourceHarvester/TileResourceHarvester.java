package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.ModBlocks;
import hamdev.tantalusunchained.tools.IGuiTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;

public class TileResourceHarvester extends TileEntity implements ITickable, IGuiTile, IInteractionObject
{
    private static final Logger LOGGER = LogManager.getLogger();

    public TileResourceHarvester()
    {
        super(ModBlocks.TYPE_RESOURCE_HARVESTER);
    }

    private Integer tickIterator;
    private NBTTagCompound dateNBTData;
    private String[] dateArray;

    @Override
    public void tick()
    {
//        if(!world.isRemote)
//        {
//            if (tickIterator >= 6000) {
//                tickIterator = 0;
//                outputResource();
//            }
//            tickIterator ++;
//            //LOGGER.info("Ticking away");
//        }
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return !isRemoved() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public GuiContainer createGui(EntityPlayer player)
    {
        return new GuiResourceHarvester(this, new ContainerResourceHarvester(player.inventory, this));
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer player)
    {
        return new ContainerResourceHarvester(inventoryPlayer, this);
    }

    private void outputResource()
    {
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

    @Override
    public String getGuiID()
    {
        return "tantalusunchained:resource_harvester";
    }

    @Override
    public ITextComponent getName()
    {
        return new TextComponentString("Resource Harvester GUI");
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    @Nullable
    public ITextComponent getCustomName()
    {
        return null;
    }
}