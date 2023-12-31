package dabdaddy.dynamic_dynamite.entity.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.item.ModItems;
import dabdaddy.dynamic_dynamite.util.Random;
import dabdaddy.dynamic_dynamite.util.World;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class LightningDynamiteProjectile extends DynamiteProjectile
{
    private final int LIGHTNING_AMOUNT = 10;
    private final int LIGHTNING_RADIUS = 3;

    public LightningDynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        super(_level, _shooter);
    }

    @Override
    protected void contact(BlockHitResult _result)
    {
        for(int i = 0; i < LIGHTNING_AMOUNT; i++)
        {
            Vec2 randomOffset = Random.randomPointInRadius(LIGHTNING_RADIUS);
            Vec3 position = new Vec3(
                    _result.getBlockPos().getX() + randomOffset.x,
                    _result.getBlockPos().getY(),
                    _result.getBlockPos().getZ() + randomOffset.y);
            World.lightning(position, this.level());
        }
    }

    @Override
    protected boolean destroyOnLanding()
    {
        return true;
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.LIGHTNING_DYNAMITE_ITEM.get();
    }
}
