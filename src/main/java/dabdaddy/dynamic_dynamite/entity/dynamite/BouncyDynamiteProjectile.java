package dabdaddy.dynamic_dynamite.entity.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.item.ModItems;
import dabdaddy.dynamic_dynamite.util.Chat;
import dabdaddy.dynamic_dynamite.util.World;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BouncyDynamiteProjectile extends DynamiteProjectile
{
    private final int BOUNCE_LIMIT = 3;
    private final float BOUNCE_MOVEMENT_DAMPENING = 0.5f;
    private int currentBounces = 0;

    public BouncyDynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        super(_level, _shooter);
    }

    @Override
    protected void contact(BlockHitResult _result)
    {
        if(currentBounces == BOUNCE_LIMIT)
        {
            World.explode(this, _result.getBlockPos(), this.level(), 0.5f);
            destroy();
        }
        else
        {
            currentBounces += 1;
            Vec3 deltaMovement = this.getDeltaMovement();
            Vec3i blockNormal = _result.getDirection().getNormal();

            double finalDeltaX = deltaMovement.x();
            double finalDeltaY = deltaMovement.y();
            double finalDeltaZ = deltaMovement.z();

            if(blockNormal.getX() != 0)
            {
                finalDeltaX *= BOUNCE_MOVEMENT_DAMPENING;
                finalDeltaX /= currentBounces + 1;
                finalDeltaX = -finalDeltaX;
            }
            if(blockNormal.getY() != 0)
            {
                finalDeltaY *= BOUNCE_MOVEMENT_DAMPENING;
                finalDeltaY /= currentBounces + 1;
                finalDeltaY = -finalDeltaY;
            }
            if(blockNormal.getZ() != 0)
            {
                finalDeltaZ *= BOUNCE_MOVEMENT_DAMPENING;
                finalDeltaZ /= currentBounces + 1;
                finalDeltaZ = -finalDeltaZ;
            }

            this.setDeltaMovement(finalDeltaX, finalDeltaY, finalDeltaZ);
        }
    }

    @Override
    protected boolean destroyOnLanding()
    {
        return false;
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.BOUNCY_DYNAMITE_ITEM.get();
    }
}
