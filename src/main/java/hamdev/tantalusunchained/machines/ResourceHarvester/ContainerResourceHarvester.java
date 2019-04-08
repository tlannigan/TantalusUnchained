package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.networking.Messages;
import hamdev.tantalusunchained.networking.PacketMachineState;
import hamdev.tantalusunchained.tools.IHarvesterStateContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.network.NetworkDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContainerResourceHarvester extends Container implements IHarvesterStateContainer
{
    private static final Logger LOGGER = LogManager.getLogger();

    private TileResourceHarvester te;

    public ContainerResourceHarvester(IInventory playerInventory, TileResourceHarvester te)
    {
        this.te = te;

        //addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory)
    {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row)
        {
            for (int col = 0; col < 9; ++col)
            {
                int x = 10 + col * 18;
                int y = row * 18 + 70;
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row)
        {
            int x = 10 + row * 18;
            int y = 58 + 70;
            this.addSlot(new Slot(playerInventory, row, x, y));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return te.canInteractWith(playerIn);
    }

//    @Override
//    public void detectAndSendChanges()
//    {
//        super.detectAndSendChanges();
//
//        if(!te.getWorld().isRemote)
//        {
//            if(te.getCurResource() != te.getCurResource())
//            {
//                te.setCurResource(te.getCurResource());
//
//                for(IContainerListener listener: listeners)
//                {
//                    if(listener instanceof EntityPlayerMP)
//                    {
//                        EntityPlayerMP player = (EntityPlayerMP) listener;
//                        int curResource = te.getCurResource();
//                        Messages.INSTANCE.sendTo(new PacketMachineState(curResource), player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
//                    }
//                }
//            }
//        }
//    }

    @Override
    public void sync(int curResource)
    {
        this.te.setCurResource(curResource);
    }
}
