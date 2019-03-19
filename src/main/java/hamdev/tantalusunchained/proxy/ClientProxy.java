package hamdev.tantalusunchained.proxy;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy
{

    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        OBJLoader.INSTANCE.addDomain(TantalusUnchained.MODID);
    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getInstance().player;
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}