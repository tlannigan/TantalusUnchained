package hamdev.tantalusunchained.items;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemHeavyMetal extends Item
{
    public ItemHeavyMetal()
    {
        super(new Properties().group(TantalusUnchained.creativeTab));
        setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "heavy_metal"));
    }
}
