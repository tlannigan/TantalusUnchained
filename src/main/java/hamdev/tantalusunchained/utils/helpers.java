package hamdev.tantalusunchained.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import java.time.LocalDate;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.abs;
import static net.minecraft.util.math.MathHelper.floor;

public class helpers {
    public static double randomGenerator(int resourceModifier, double chunkX, double chunkZ, double min, double max)
    {
        int finalX = floor(chunkX / 16);
        int finalZ = floor(chunkZ / 16);
        String bitShift = "";

        if(finalX<0&&finalZ<0)
        {
            bitShift = "-";
        }
        else if(finalX<0 && finalZ>=0)
        {
            bitShift = "0";
        }
        else if(finalX>=0 && finalZ<0)
        {
            bitShift = "1";
        }

        String finalSeed = bitShift + "" + abs(finalX) + "" + abs(finalZ) + "" + LocalDate.now().getYear() + "" + LocalDate.now().getMonthValue();
        Random generator = new Random((resourceModifier + 1) * Integer.parseInt(finalSeed));

        return min + (max - min) * generator.nextDouble();
    }

    public static void scanResources(EntityPlayer player, int x, int z)
    {
        String[] resources;

        if(player.world.getDimension().getType().getId() == -1)
        {
            resources = new String[]{"Common Metals: ", "Dense Metals: ", "Crystalline Solids: ", "Liquid Hot Magma: ", "Rare Metals: "};
        }
        else if (player.world.getDimension().getType().getId() == 1)
        {
            resources = new String[]{"Inert Gas: ", "Ionized Gas: ", "Liquid Hot Plasma: ", "Unstable Gas: "};
        }
        else
        {
            resources = new String[]{"Hard Water: ", "Organic Compounds: ", "Plant Fibers: ", "Microbes: ", "Phytoplankton: ", "Complex Organisms: "};
        }

        double density;

        player.sendMessage(new TextComponentString("Region density scan complete:"));
        for(int i = 0; i < resources.length; i++)
        {
            density = randomGenerator(i, x, z, 0.5, 2.0);
            player.sendMessage(new TextComponentString(resources[i] + (int) (density * 100) + "%"));
        }
    }

    public static void getDimensionResources()
    {

    }
}
