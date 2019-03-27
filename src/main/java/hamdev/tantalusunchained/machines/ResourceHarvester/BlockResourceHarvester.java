package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class BlockResourceHarvester extends Block
{
    public BlockResourceHarvester()
    {
        super(Block.Properties.create(Material.GLASS).sound(SoundType.STONE).hardnessAndResistance(2.0f));
        setRegistryName(TantalusUnchained.MODID, "block_resource_harvester");
    }

//    @Override
//    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
//    {
//        if(!worldIn.isRemote)
//        {
//            TileEntity tileEntity = worldIn.getTileEntity(pos);
//            if (tileEntity instanceof TileResourceHarvester)
//            {
//                ((TileResourceHarvester) tileEntity).createGui(player);
//            }
//        }
//        return super.onBlockActivated(state, worldIn, pos, player, hand, side, hitX, hitY, hitZ);
//    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        // Only execute on the server
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof IInteractionObject)) {
            return false;
        }
        // @todo 1.13
        NetworkHooks.openGui((EntityPlayerMP) player, (IInteractionObject)te, buf -> {
            buf.writeInt(te.getPos().getX());
            buf.writeInt(te.getPos().getY());
            buf.writeInt(te.getPos().getZ());
        });
//        player.displayGui((IInteractionObject) te);
//        player.openGui(MyMod.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
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
