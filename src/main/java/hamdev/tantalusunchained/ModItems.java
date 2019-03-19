package hamdev.tantalusunchained;

import net.minecraft.item.Item;
import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.items.ItemHeavyMetal;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems
{

    @ObjectHolder("tantalusunchained:heavy_metal")
    public static ItemHeavyMetal itemHeavyMetal;

    public static void register(IForgeRegistry<Item> registry)
    {
        registry.register(new ItemHeavyMetal());
    }

}
