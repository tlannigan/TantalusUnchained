package hamdev.tantalusunchained.items;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.utils.helpers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
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

    public ResourceType getResource(ItemStack stack)
    {
        if (!stack.hasTag())
        {
            return ResourceType.HARD_WATER;
        }
        return ResourceType.values()[stack.getTag().getInt("resource")];
    }

    public void toggleResource(EntityPlayer player, ItemStack stack)
    {
        ResourceType resource = getResource(stack);
        if(resource == ResourceType.UNSTABLE_GAS)
        {
            resource = ResourceType.HARD_WATER;
        }
        else
        {
            resource = getResource(stack);
        }

        player.sendStatusMessage(new TextComponentString(TextFormatting.GREEN + "Scanning for: " + resource.name()), false);

        if (!stack.hasTag())
        {
            stack.setTag(new NBTTagCompound());
        }

        stack.getTag().setInt("resource", stack.getTag().getInt("resource") + 1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (player.isSneaking())
        {
            if(!world.isRemote)
            {
                toggleResource(player, player.getHeldItem(hand));
            }
        }
        else
        {
            if(!world.isRemote())
            {
                scanRegion(player);
                return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    private void scanRegion(EntityPlayer player)
    {
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();

        double density = helpers.randomGenerator(x, z, 0.5, 2.0);
        player.sendMessage(new TextComponentString("Scan complete: Region reveals a density of " + (int) (density * 100) + "%."));
    }
}
