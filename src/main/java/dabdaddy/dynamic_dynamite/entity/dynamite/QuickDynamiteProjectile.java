package dabdaddy.dynamic_dynamite.entity.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.util.World;
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
        World.explode(this, _result.getBlockPos(), this.level(), 0.5f);
    }

    @Override
    protected boolean destroyOnLanding()
    {
        return true;
    }
}
