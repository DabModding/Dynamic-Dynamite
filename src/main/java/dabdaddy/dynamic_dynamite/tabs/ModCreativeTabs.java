package dabdaddy.dynamic_dynamite.tabs;

import dabdaddy.dynamic_dynamite.Reference;
import dabdaddy.dynamic_dynamite.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.event.ItemListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final List<Supplier<? extends ItemLike>> DYNAMITE_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> DYNAMITE_TAB = TABS.register("dynamite_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.dynamite_tab"))
                    .icon(ModItems.DYNAMITE_ITEM.get()::getDefaultInstance)
                    .displayItems((_displayParams, _output) -> {
                        DYNAMITE_TAB_ITEMS.forEach(itemLike -> _output.accept(itemLike.get()));
                    })
                    .build());

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        DYNAMITE_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
