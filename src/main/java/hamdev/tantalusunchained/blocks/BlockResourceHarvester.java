package hamdev.tantalusunchained.blocks;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.blocks.tileentities.TileResourceHarvester;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockResourceHarvester extends Block
{
    public BlockResourceHarvester()
    {
        super(Block.Properties.create(Material.GLASS).sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName(TantalusUnchained.MODID, "block_resource_harvester");
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
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
        return new TileResourceHarvester();
    }
}
