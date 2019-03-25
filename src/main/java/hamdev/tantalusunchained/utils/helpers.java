package hamdev.tantalusunchained.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import java.time.LocalDate;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.floor;

public class helpers {
    public static double randomGenerator(int resourceModifier, double chunkX, double chunkZ, double min, double max)
    {
        Random generator = new Random(floor(chunkX / 16));
        int passOne = generator.nextInt();

        generator = new Random(floor(chunkZ / 16));
        int passTwo = generator.nextInt();

        generator = new Random((int)Math.pow(LocalDate.now().getYear() - 2000, LocalDate.now().getMonthValue()));
        int passThree = generator.nextInt();

        generator = new Random(resourceModifier);
        int passFour = generator.nextInt();

        int finalSeed = passOne + (passTwo * passThree) + passFour;
        generator = new Random(finalSeed);

        return min + (max - min) * generator.nextDouble();
    }

    public static void scanResources(EntityPlayer player, int x, int z)
    {
        String[] resources;

        if(player.world.getDimension().getType().getId() == -1)
        {
            resources = new String[]{"Soft Metals: ", "Dense Metals: ", "Crystalline Solids: ", "Liquid Hot Magma: ", "Rare Metals: "};
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
}
