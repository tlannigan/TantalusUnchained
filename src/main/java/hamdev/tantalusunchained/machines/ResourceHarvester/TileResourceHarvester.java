package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.ModBlocks;
import hamdev.tantalusunchained.tools.IGuiTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;
import java.util.function.BiFunction;

public class TileResourceHarvester extends TileEntity implements ITickable, IGuiTile, IInteractionObject
{
    private static final Logger LOGGER = LogManager.getLogger();

    public TileResourceHarvester()
    {
        super(ModBlocks.TYPE_RESOURCE_HARVESTER);
    }

    @Override
    public void tick()
    {
        if(!world.isRemote)
        {

        }
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return !isRemoved() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public GuiContainer createGui(EntityPlayer player)
    {
        LOGGER.info("I'm trying to createGui, Captain!");
        return new GuiResourceHarvester(this, new ContainerResourceHarvester(player.inventory, this));
    }

    @Override
    public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer player)
    {
        LOGGER.info("I'm trying to createContainer, Captain!");
        return new ContainerResourceHarvester(inventoryPlayer, this);
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

    @Nullable
    @Override
    public ITextComponent getCustomName()
    {
        return null;
    }
}