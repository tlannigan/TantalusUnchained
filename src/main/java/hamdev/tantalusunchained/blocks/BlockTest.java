package hamdev.tantalusunchained.blocks;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTest extends Block
{
    public BlockTest() {
        super(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName(TantalusUnchained.MODID, "block_test");
    }
}
