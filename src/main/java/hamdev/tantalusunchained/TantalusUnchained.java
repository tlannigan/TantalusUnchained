package hamdev.tantalusunchained;

import hamdev.tantalusunchained.proxy.ClientProxy;
import hamdev.tantalusunchained.proxy.GuiHandler;
import hamdev.tantalusunchained.proxy.IProxy;
import hamdev.tantalusunchained.proxy.ServerProxy;
import hamdev.tantalusunchained.worldgen.ResourceDensity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

@Mod(TantalusUnchained.MODID)
public class TantalusUnchained
{
    public static final String MODID = "tantalusunchained";

    private static final Logger LOGGER = LogManager.getLogger();

    //unused until proxy files are added - proxy used between client and server "sides"
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ItemGroup creativeTab = new ItemGroup("TantalusUnchained") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.itemHeavyMetal);
        }
    };

    public TantalusUnchained()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> GuiHandler::getClientGuiElement);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("PreINIT");

        CapabilityManager.INSTANCE.register(ResourceDensity.class, new Capability.IStorage<ResourceDensity>()
        {
           @Nullable
           @Override
           public INBTBase writeNBT(Capability<ResourceDensity> capability, ResourceDensity instance, EnumFacing side)
           {
               throw new UnsupportedOperationException();
           }

           @Override
           public void readNBT(Capability<ResourceDensity> capability, ResourceDensity instance, EnumFacing side, INBTBase nbt)
           {
               throw new UnsupportedOperationException();
           }
        }, () -> null);

        proxy.setup(event);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Item> event)
        {
            // register a new block here
            ModItems.register(event.getRegistry());
            LOGGER.info("HELLO from Register Block");
        }
    }
}
