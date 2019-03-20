package hamdev.tantalusunchained.worldgen;

import net.minecraft.nbt.NBTTagCompound;

public class ResourceDensity
{
    // this value will increase base density value by n%
    private float density = (float) (Math.random() * 1.25);

    public ResourceDensity()
    {

    }

    public float getDensity()
    {
        return density;
    }

    public void saveNBTData(NBTTagCompound compound)
    {
        compound.setFloat("density", density);
    }

    public void loadNBTData(NBTTagCompound compound)
    {
        compound.getFloat("density");
    }
}
