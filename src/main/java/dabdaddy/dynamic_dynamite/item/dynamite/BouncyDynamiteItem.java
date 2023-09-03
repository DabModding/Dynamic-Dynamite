package dabdaddy.dynamic_dynamite.item.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.entity.dynamite.BouncyDynamiteProjectile;
import dabdaddy.dynamic_dynamite.item.DynamiteItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BouncyDynamiteItem extends DynamiteItem
{
    @Override
    protected int getCooldownTimeInTicks()
    {
        return 20;
    }

    @Override
    protected DynamiteProjectile constructProjectile(Level _level, Player _player)
    {
        return new BouncyDynamiteProjectile(_level, _player);
    }
}
