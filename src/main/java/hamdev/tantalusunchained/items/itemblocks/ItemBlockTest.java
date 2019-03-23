package hamdev.tantalusunchained.items.itemblocks;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlockTest extends ItemBlock {
    public ItemBlockTest(Block block) {
        super(block, new Item.Properties().group(TantalusUnchained.creativeTab));
        setRegistryName(TantalusUnchained.MODID, "block_test");
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);

        list.add(new TextComponentString(""));
        list.add(new TextComponentString("\u00A79This is a test, bitch!"));
    }
}
