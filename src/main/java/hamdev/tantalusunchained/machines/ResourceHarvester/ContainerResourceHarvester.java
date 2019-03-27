package hamdev.tantalusunchained.machines.ResourceHarvester;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class ContainerResourceHarvester extends Container
{
    private TileResourceHarvester te;

    public ContainerResourceHarvester(IInventory playerInventory, TileResourceHarvester te)
    {
        this.te = te;

        //addOwnSlots();
        //addPlayerSlots(playerInventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return te.canInteractWith(playerIn);
    }
}
