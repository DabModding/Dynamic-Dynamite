package dabdaddy.dynamic_dynamite.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class World
{
    public static void explode(Entity _src, BlockPos _pos, Level _level, float _explosionAmount)
    {
        _level.explode(_src,
                _pos.getX(), _pos.getY(), _pos.getZ(),
                4.0f * _explosionAmount,
                Level.ExplosionInteraction.BLOCK);
    }
}
