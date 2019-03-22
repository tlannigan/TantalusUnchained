package hamdev.tantalusunchained.items;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.utils.helpers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class ItemOmniTool extends Item
{
    private static final Logger LOGGER = LogManager.getLogger();

    public ItemOmniTool()
    {
        super(new Properties().group(TantalusUnchained.creativeTab));
        setRegistryName(new ResourceLocation(TantalusUnchained.MODID, "omni_tool"));
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);

        list.add(new TextComponentString(""));
        list.add(new TextComponentString("\u00A79This tool can handle anything you can throw in the kitchen sink!"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (player.isSneaking())
        {
            return null;
        }
        else
        {
            if(!world.isRemote())
            {
                scanRegion(world, player);
                return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    private void scanRegion(World world, EntityPlayer player)
    {
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();

        Chunk chunk = world.getChunk(x, z);
        ChunkPos chunkPos = chunk.getPos();

        int chunkX = chunkPos.x / 16;
        int chunkZ = chunkPos.z / 16;

        double density = helpers.randomGenerator(chunkX, chunkZ, LocalDate.now().getMonthValue(), LocalDate.now().getYear(), 0.5, 2.0);
        player.sendMessage(new TextComponentString("Scan complete: Region reveals a density of " + (int) (density * 100) + "%."));
    }
}
