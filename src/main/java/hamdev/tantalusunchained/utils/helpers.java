package hamdev.tantalusunchained.utils;

import java.util.Random;

import static net.minecraft.util.math.MathHelper.floor;

public class helpers {
    public static double randomGenerator(int chunkX, int chunkZ, int month, int year, double min, double max)
    {
        Random generator = new Random(floor(chunkX));
        int passOne = generator.nextInt();
        generator = new Random(floor(chunkZ));
        int passTwo = generator.nextInt();
        generator = new Random(month + year);
        int passThree = generator.nextInt();

        int finalSeed = passOne + (passTwo * passThree);

        generator = new Random(finalSeed);
        double finalValue = min + (max - min) * generator.nextDouble();

        return finalValue;
    }
}
