package dabdaddy.dynamic_dynamite.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class Chat
{
    public static void sendChatMessageForPlayer(Player _player, String _text)
    {
        _player.sendSystemMessage(Component.literal(_text));
    }
}
