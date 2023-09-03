package dabdaddy.dynamic_dynamite.entity;

import dabdaddy.dynamic_dynamite.item.ModItems;
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
        BlockPos pos = _result.getBlockPos();
        float explosionAmount = 4.0f;
        float explosionRadius = 4.0f;

        if(!this.level().isClientSide())
        {
            this.level().explode(this, pos.getX(), pos.getY(), pos.getZ(), explosionRadius, Level.ExplosionInteraction.BLOCK);
            this.discard();
        }

        super.onHitBlock(_result);
    }
}
