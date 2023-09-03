package dabdaddy.dynamic_dynamite.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
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

    public static void ignite(BlockPos _pos, Level _level)
    {
        BlockState blockstate = BaseFireBlock.getState(_level, _pos);
        if (_level.getBlockState(_pos).isAir() && blockstate.canSurvive(_level, _pos))
        {
            _level.setBlockAndUpdate(_pos, blockstate);
        }
    }

    public static void ignite(Vec3 _pos, Level _level)
    {
        BlockPos position = new BlockPos(
                (int)Math.round(_pos.x),
                (int)Math.round(_pos.y),
                (int)Math.round(_pos.z)
        );
        ignite(position, _level);
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
