package hamdev.tantalusunchained;

import hamdev.tantalusunchained.networking.Messages;
import hamdev.tantalusunchained.proxy.ClientProxy;
import hamdev.tantalusunchained.proxy.GuiHandler;
import hamdev.tantalusunchained.proxy.IProxy;
import hamdev.tantalusunchained.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TantalusUnchained.MODID)
public class TantalusUnchained
{
    public static final String MODID = "tantalusunchained";
//    private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ItemGroup creativeTab = new ItemGroup("TantalusUnchained")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.itemDenseMetal);
        }
    };

    public TantalusUnchained()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> GuiHandler::getClientGuiElement);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Messages.registerMessages("tantalusunchained");
        proxy.setup(event);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
        // do something when the server starts
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event)
        {
            ModItems.registerItems(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event)
        {
            ModBlocks.registerBlocks(event.getRegistry());
        }
        @SubscribeEvent
        public static void onTilesRegistry(final RegistryEvent.Register<TileEntityType<?>> event)
        {
            ModBlocks.registerTileEntities(event.getRegistry());
        }
    }
}
