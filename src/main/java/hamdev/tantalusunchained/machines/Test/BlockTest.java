package hamdev.tantalusunchained.machines.Test;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import javax.annotation.Nullable;

public class BlockTest extends Block /*implements ITileEntityProvider*/
{
    public BlockTest()
    {
        super(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName(TantalusUnchained.MODID, "block_test");
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    @Nullable
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityTest();
    }
}
