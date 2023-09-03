package dabdaddy.dynamic_dynamite.util;

import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec2;

public class Random
{
    public static int randomInt(int min, int max)
    {
        return RandomSource.createNewThreadLocalInstance().nextIntBetweenInclusive(min, max);
    }

    public static int randomInt(int max)
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(max);
    }

    public static float randomFloat(float max)
    {
        return RandomSource.createNewThreadLocalInstance().nextFloat() * max;
    }

    public static double randomDouble(double max)
    {
        return RandomSource.createNewThreadLocalInstance().nextDouble() * max;
    }

    public static Vec2 randomPointInRadius(float radius)
    {
        float r = radius * (float)Math.sqrt(randomFloat(1.0f));
        float theta = randomFloat(1.0f) * 2.0f * (float)Math.PI;

        float x = r * (float)Math.cos(theta);
        float y = r * (float)Math.sin(theta);

        return new Vec2(x, y);
    }

    public static Vec2 randomPointInRadius(int radius)
    {
        Vec2 point = randomPointInRadius((float)radius);
        return new Vec2(Math.round(point.x), Math.round(point.y));
    }
}
