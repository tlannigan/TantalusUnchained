package hamdev.tantalusunchained.networking;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.tools.IHarvesterStateContainer;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketMachineState
{
    private int curResource;

    public PacketMachineState(ByteBuf buf)
    {
        curResource = buf.readInt();
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(curResource);
    }

    public PacketMachineState(int curResource)
    {
        this.curResource = curResource;
    }

    public void handle(Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            EntityPlayerMP player = ctx.get().getSender();
            if(player.openContainer instanceof IHarvesterStateContainer)
            {
                ((IHarvesterStateContainer) player.openContainer).sync(curResource);
            }
        });

        ctx.get().setPacketHandled(true);
    }
}
