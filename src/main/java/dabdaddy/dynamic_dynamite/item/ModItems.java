package dabdaddy.dynamic_dynamite.item;

import dabdaddy.dynamic_dynamite.Reference;
import dabdaddy.dynamic_dynamite.item.dynamite.QuickDynamiteItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<Item> DYNAMITE_ITEM = ITEMS.register("dynamite", () -> new DynamiteItem());
    public static final RegistryObject<Item> QUICK_DYNAMITE_ITEM = ITEMS.register("quick_dynamite", () -> new QuickDynamiteItem());
}
