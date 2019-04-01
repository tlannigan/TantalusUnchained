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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
        }
        else
        {
            if(!world.isRemote())
            {
                int x = player.getPosition().getX();
                int z = player.getPosition().getZ();

                helpers.scanResources(player, x, z);
                return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
}
