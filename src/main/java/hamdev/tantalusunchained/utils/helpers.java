package hamdev.tantalusunchained.utils;

import java.time.LocalDate;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.floor;

public class helpers {
    public static double randomGenerator(double chunkX, double chunkZ, double min, double max)
    {
        Random generator = new Random(floor(chunkX / 16));
        int passOne = generator.nextInt();

        generator = new Random(floor(chunkZ / 16));
        int passTwo = generator.nextInt();

        generator = new Random((int)Math.pow(LocalDate.now().getYear() - 2000, LocalDate.now().getMonthValue()));
        int passThree = generator.nextInt();

        int finalSeed = passOne + (passTwo * passThree);
        generator = new Random(finalSeed);

        return min + (max - min) * generator.nextDouble();
    }
}
