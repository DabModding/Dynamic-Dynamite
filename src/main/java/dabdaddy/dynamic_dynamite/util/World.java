package dabdaddy.dynamic_dynamite.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class World
{
    public static void explode(Entity _src, BlockPos _pos, Level _level, float _explosionAmount)
    {
        _level.explode(_src,
                _pos.getX(), _pos.getY(), _pos.getZ(),
                4.0f * _explosionAmount,
                Level.ExplosionInteraction.BLOCK);
    }

    public static void lightning(BlockPos _pos, Level _level)
    {
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(_level);
        if (bolt != null)
        {
            bolt.moveTo(Vec3.atBottomCenterOf(_pos));
            _level.addFreshEntity(bolt);
        }
    }

    public static void lightning(Vec3 _pos, Level _level)
    {
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(_level);
        if (bolt != null)
        {
            bolt.moveTo(_pos);
            _level.addFreshEntity(bolt);
        }
    }
}
