package hamdev.tantalusunchained.worldgen;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PropertiesDispatcher implements ICapabilitySerializable<NBTTagCompound>
{

    private ResourceDensity resourceDensity = new ResourceDensity();

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == ChunkProperties.RESOURCE_DENSITY)
        {
            return LazyOptional.of(() -> (T) resourceDensity);
        }
        return null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        resourceDensity.saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        resourceDensity.loadNBTData(nbt);
    }
}
