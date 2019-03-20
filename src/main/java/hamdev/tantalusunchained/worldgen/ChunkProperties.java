package hamdev.tantalusunchained.worldgen;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ChunkProperties {

    @CapabilityInject(ResourceDensity.class)
    public static Capability<ResourceDensity> RESOURCE_DENSITY;
}
