package dabdaddy.dynamic_dynamite.entity;

import dabdaddy.dynamic_dynamite.item.ModItems;
import dabdaddy.dynamic_dynamite.util.World;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class DynamiteProjectile extends ThrowableItemProjectile
{
    public DynamiteProjectile(EntityType<? extends DynamiteProjectile> _entityType, Level _level)
    {
        super(_entityType, _level);
    }

    public DynamiteProjectile(Level _level, LivingEntity _shooter)
    {
        // TODO: Replace snowball with custom entity type
        super(EntityType.SNOWBALL, _shooter, _level);
    }

    public DynamiteProjectile(Level _level, double _x, double _y, double _z)
    {
        super(EntityType.SNOWBALL, _x, _y, _z, _level);
    }

    protected boolean destroyOnLanding()
    {
        return true;
    }

    protected void contact(BlockHitResult _result)
    {
        World.explode(this, _result.getBlockPos(), this.level(), 1.0f);
    }

    protected void destroy()
    {
        this.discard();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.DYNAMITE_ITEM.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult _result)
    {
        if(!this.level().isClientSide())
        {
            contact(_result);
            if(destroyOnLanding())
            {
                destroy();
            }
        }

        super.onHitBlock(_result);
    }
}
