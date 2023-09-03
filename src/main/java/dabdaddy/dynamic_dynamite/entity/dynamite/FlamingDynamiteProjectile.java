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

public class FlamingDynamiteProjectile extends DynamiteProjectile
{
    private final int FLAME_AMOUNT = 20;
    private final int FLAME_RADIUS = 3;

    public FlamingDynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        super(_level, _shooter);
    }

    @Override
    protected void contact(BlockHitResult _result)
    {
        for(int i = 0; i < FLAME_AMOUNT; i++)
        {
            Vec2 randomOffset = Random.randomPointInRadius(FLAME_RADIUS);
            Vec3 position = new Vec3(
                _result.getBlockPos().getX() + randomOffset.x,
                _result.getBlockPos().getY() + 1,
                _result.getBlockPos().getZ() + randomOffset.y
            );
            World.ignite(position, this.level());
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
        return ModItems.FLAMING_DYNAMITE_ITEM.get();
    }
}
