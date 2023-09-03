package dabdaddy.dynamic_dynamite.entity.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.item.ModItems;
import dabdaddy.dynamic_dynamite.util.World;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class FusedDynamiteProjectile extends DynamiteProjectile
{
    private final int FUSE_LENGTH_SECONDS = 2;
    private int fuseTickTimer;
    private boolean fuseTimerStarted;
    private BlockPos explosionPosition;

    public FusedDynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        super(_level, _shooter);
        fuseTimerStarted = false;
    }

    @Override
    protected void contact(BlockHitResult _result)
    {
        if(fuseTimerStarted)
        {
            return;
        }

        this.setDeltaMovement(0.0, 0.0, 0.0);
        fuseTimerStarted = true;
        fuseTickTimer = 0;
        explosionPosition = _result.getBlockPos();
    }

    @Override
    protected boolean destroyOnLanding()
    {
        return false;
    }

    @Override
    public void tick()
    {
        if(fuseTimerStarted)
        {
            fuseTickTimer += 1;
            if(fuseTickTimer == FUSE_LENGTH_SECONDS * 20)
            {
                World.explode(this, explosionPosition, this.level(), 2.0f);
            }
        }

        super.tick();
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.FUSED_DYNAMITE_ITEM.get();
    }
}
