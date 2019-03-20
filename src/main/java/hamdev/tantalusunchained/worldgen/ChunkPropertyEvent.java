package hamdev.tantalusunchained.worldgen;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChunkPropertyEvent
{
    public static ChunkPropertyEvent chunkPropertyEvent = new ChunkPropertyEvent();

    @SubscribeEvent
    public void OnChunkConstruction(AttachCapabilitiesEvent<Chunk> event)
    {
        if (event.getObject() instanceof Chunk)
        {
            if (!event.getObject().getCapability(ChunkProperties.RESOURCE_DENSITY).isPresent())
            {
                event.addCapability(new ResourceLocation(TantalusUnchained.MODID, "density"), new PropertiesDispatcher());
            }
        }
    }
}
