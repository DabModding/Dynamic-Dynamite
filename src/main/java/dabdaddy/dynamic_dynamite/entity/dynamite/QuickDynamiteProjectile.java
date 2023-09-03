package dabdaddy.dynamic_dynamite.entity.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class QuickDynamiteProjectile extends DynamiteProjectile
{
    public QuickDynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        super(_level, _shooter);
    }

    @Override
    protected void contact(BlockHitResult _result)
    {
        BlockPos pos = _result.getBlockPos();
        float explosionAmount = 2.0f;
        float explosionRadius = 2.0f;

        this.level().explode(this, pos.getX(), pos.getY(), pos.getZ(), explosionRadius, Level.ExplosionInteraction.BLOCK);
    }

    @Override
    protected boolean destroyOnLanding()
    {
        return true;
    }
}
