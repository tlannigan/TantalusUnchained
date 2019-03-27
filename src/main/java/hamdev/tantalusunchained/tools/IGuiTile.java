package hamdev.tantalusunchained.tools;

import hamdev.tantalusunchained.machines.ResourceHarvester.GuiResourceHarvester;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public interface IGuiTile
{
    GuiContainer createGui(EntityPlayer player);
}
