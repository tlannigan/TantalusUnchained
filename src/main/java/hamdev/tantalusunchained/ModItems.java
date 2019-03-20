package hamdev.tantalusunchained;

import hamdev.tantalusunchained.items.ItemGuideBook;
import hamdev.tantalusunchained.items.ItemOmniTool;
import hamdev.tantalusunchained.items.ItemTechnologyFragment;
import net.minecraft.item.Item;
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
        registry.register(new ItemGuideBook());
        registry.register(new ItemTechnologyFragment());
        registry.register(new ItemOmniTool());
    }

}
