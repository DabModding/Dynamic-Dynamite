package dabdaddy.dynamic_dynamite;

import dabdaddy.dynamic_dynamite.entity.ModEntities;
import dabdaddy.dynamic_dynamite.item.ModItems;
import dabdaddy.dynamic_dynamite.tabs.ModCreativeTabs;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class DynamicDynamite
{
    public DynamicDynamite()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModEntities.TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModItems.addItemsToCreativeTab();
        ModCreativeTabs.TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
