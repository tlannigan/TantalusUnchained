package hamdev.tantalusunchained;

import hamdev.tantalusunchained.items.ItemGuideBook;
import hamdev.tantalusunchained.items.ItemOmniTool;
import hamdev.tantalusunchained.items.ItemTechnologyFragment;
import hamdev.tantalusunchained.items.p0_resources.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems
{

    @ObjectHolder("tantalusunchained:toxic_metal")
    public static ItemToxicMetal itemToxicMetal;

    public static void registerItems(IForgeRegistry<Item> registry)
    {
        // P0 Resources
        registry.register(new ItemComplexOrganism());
        registry.register(new ItemCrystallineSolid());
        registry.register(new ItemHardWater());
        registry.register(new ItemInertGas());
        registry.register(new ItemInertMetal());
        registry.register(new ItemIonizedGas());
        registry.register(new ItemLiquidHotMagma());
        registry.register(new ItemMicrobe());
        registry.register(new ItemOrganicColony());
        registry.register(new ItemOrganicCompound());
        registry.register(new ItemPlantBiomatter());
        registry.register(new ItemPlasma());
        registry.register(new ItemSoftMetal());
        registry.register(new ItemToxicMetal());
        registry.register(new ItemUnstableGas());

        // P1 Resources
        registry.register(new ItemGuideBook());
        registry.register(new ItemTechnologyFragment());
        registry.register(new ItemOmniTool());
    }

}
