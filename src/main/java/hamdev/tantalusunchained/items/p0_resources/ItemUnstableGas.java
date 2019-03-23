package hamdev.tantalusunchained.items.p0_resources;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

public class ItemUnstableGas extends Item
{
    public ItemUnstableGas()
    {
        super(new Item.Properties().group(TantalusUnchained.creativeTab));
        setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "unstable_gas"));
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        list.add(new TextComponentString(""));
        list.add(new TextComponentString("Put something useful here"));
    }
}
