package dabdaddy.dynamic_dynamite.item.dynamite;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import dabdaddy.dynamic_dynamite.entity.dynamite.QuickDynamiteProjectile;
import dabdaddy.dynamic_dynamite.item.DynamiteItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class QuickDynamiteItem extends DynamiteItem
{
    @Override
    protected int getCooldownTimeInTicks()
    {
        return 10;
    }

    @Override
    protected DynamiteProjectile constructProjectile(Level _level, Player _player)
    {
        return new QuickDynamiteProjectile(_level, _player);
    }
}
