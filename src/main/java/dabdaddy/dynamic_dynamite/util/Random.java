package dabdaddy.dynamic_dynamite.util;

import net.minecraft.util.RandomSource;

public class Random
{
    public static int getRandomInt(int min, int max)
    {
        return RandomSource.createNewThreadLocalInstance().nextIntBetweenInclusive(min, max);
    }

    public static int getRandomInt(int max)
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(max);
    }
}
