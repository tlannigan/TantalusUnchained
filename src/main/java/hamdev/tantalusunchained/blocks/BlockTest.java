package hamdev.tantalusunchained.blocks;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.blocks.tileentities.TileEntityTest;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import javax.annotation.Nullable;

public class BlockTest extends Block /*implements ITileEntityProvider*/
{
    public BlockTest() {
        super(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName(TantalusUnchained.MODID, "block_test");
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
        return new TileEntityTest();
    }
}
