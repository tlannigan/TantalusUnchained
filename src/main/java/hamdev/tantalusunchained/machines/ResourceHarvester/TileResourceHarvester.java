package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.ModBlocks;
import hamdev.tantalusunchained.networking.Messages;
import hamdev.tantalusunchained.networking.PacketMachineState;
import hamdev.tantalusunchained.tools.IGuiTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import net.minecraftforge.common.extensions.IForgeTileEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;

import static hamdev.tantalusunchained.networking.Messages.INSTANCE;

public class TileResourceHarvester extends TileEntity implements ITickable, IGuiTile, IInteractionObject
{
    private static final Logger LOGGER = LogManager.getLogger();

    private int curResource = 0;

    public TileResourceHarvester()
    {
        super(ModBlocks.TYPE_RESOURCE_HARVESTER);
    }

    private Integer tickIterator = 0;
    //private NBTTagCompound dateNBTData;
    //private String[] dateArray;

    @Override
    public void tick()
    {
        if(tickIterator >= 20)
        {
            LOGGER.info("Resource: " + curResource);
            tickIterator = 0;
        }
        tickIterator++;

//            if (tickIterator >= 6000) {
//                tickIterator = 0;
//                outputResource();
//            }
//            tickIterator ++;
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

    @Override
    public void read(NBTTagCompound compound)
    {
        super.read(compound);
        readRestorableFromNBT(compound);
        curResource = compound.getInt("Resource");
    }

    public void readRestorableFromNBT(NBTTagCompound compound)
    {
        this.setCurResource(compound.getInt("Resource"));
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound)
    {
        super.write(compound);
        writeRestorableToNBT(compound);
        compound.setInt("Resource", curResource);
        return compound;
    }

    public void writeRestorableToNBT(NBTTagCompound compound)
    {
        compound.setInt("Resource", this.getCurResource());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        NBTTagCompound nbtTag = super.getUpdateTag();
        nbtTag.setInt("Resource", curResource);
        return nbtTag;
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        int resourceState = packet.getNbtCompound().getInt("Resource");

        if (world.isRemote && resourceState != this.curResource)
        {
            this.curResource = resourceState;
        }
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag)
    {
        curResource = this.getUpdateTag().getInt("Resource");
    }

    //    public NBTTagCompound writeNBTData()
//    {
//        //THIS IS AN EXAMPLE, MOFOS
//        dateNBTData.setString("DateArray", "3/26/19 21:40,3/26/19 22:45,3/26/19 22:50,3/26/19 22:55,3/26/19 23:00");
//        return dateNBTData;
//    }
//
//    public void readNBTData(NBTTagCompound dateNBTData)
//    {
//        dateArray = dateNBTData.getString("DateArray").split(",");
//    }

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

    public int getCurResource() {
        return curResource;
    }

    public void setCurResource(int currentResource)
    {
        LOGGER.info("Current Resource being set!");
        curResource = currentResource;
    }
}