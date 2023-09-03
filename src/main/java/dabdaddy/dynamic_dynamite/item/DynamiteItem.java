package dabdaddy.dynamic_dynamite.item;

import dabdaddy.dynamic_dynamite.entity.DynamiteProjectile;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DynamiteItem extends Item
{
    public DynamiteItem()
    {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level _level, Player _player, InteractionHand _usedHand)
    {
        ItemStack stack = _player.getItemInHand(_usedHand);

        if(!_level.isClientSide())
        {
            // Construct projectile
            DynamiteProjectile proj = new DynamiteProjectile(_level, _player);
            proj.setItem(stack);
            proj.shootFromRotation(_player, _player.getXRot(), _player.getYRot(), 0.0F, 1.5F, 1.0F);
            _level.addFreshEntity(proj);

            // Add Item Cooldown
            int cooldownLengthTicks = 20;
            _player.getCooldowns().addCooldown(this, cooldownLengthTicks);
        }

        _player.awardStat(Stats.ITEM_USED.get(this));
        if (!_player.getAbilities().instabuild)
        {
            stack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(stack, _level.isClientSide());
    }
}
