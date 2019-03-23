package hamdev.tantalusunchained.utils;

import java.time.LocalDate;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.floor;

public class helpers {
    public static double randomGenerator(int chunkX, int chunkZ, double min, double max)
    {
        Random generator = new Random(floor(chunkX / 16));
        int passOne = generator.nextInt();

        generator = new Random(floor(chunkZ / 16));
        int passTwo = generator.nextInt();

        generator = new Random(LocalDate.now().getMonthValue() + LocalDate.now().getYear());
        int passThree = generator.nextInt();

        int finalSeed = passOne + (passTwo * passThree);
        generator = new Random(finalSeed);

        double finalValue = min + (max - min) * generator.nextDouble();
        return finalValue;
    }
}
