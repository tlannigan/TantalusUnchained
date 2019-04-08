package hamdev.tantalusunchained.networking;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Messages
{
    public static SimpleChannel INSTANCE;

    private static int ID = 0;

    private static int nextID()
    {
        return ID++;
    }

    public static void registerMessages(String channelName)
    {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(TantalusUnchained.MODID, channelName), () -> "1.0", s -> true, s -> true);

        // Send machine state from client to server
        INSTANCE.registerMessage(nextID(), PacketMachineState.class,
                PacketMachineState::toBytes,
                PacketMachineState::new,
                PacketMachineState::handle);
    }
}
