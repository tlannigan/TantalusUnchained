package hamdev.tantalusunchained.items;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import java.util.List;

public class ItemHeavyMetal extends Item
{
    public ItemHeavyMetal()
    {
        super(new Properties().group(TantalusUnchained.creativeTab));
        setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "heavy_metal"));
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, player, list, flag);
        //Pull from lang file. Need more info here...
        //ResourceLocation tooltip = new ResourceLocation(TantalusUnchained.MODID, "heavy_metal_description");
        //list.add(new TextComponentString(tooltip.toString()));
        list.add(new TextComponentString("Brent is a slut."));
    }

}
