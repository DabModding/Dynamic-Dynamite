package dabdaddy.dynamic_dynamite.entity;

import dabdaddy.dynamic_dynamite.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Reference.MOD_ID);

    public static final RegistryObject<EntityType<DynamiteProjectile>> DYNAMITE_PROJ = TYPES.register("dynamite",
            () -> EntityType.Builder.<DynamiteProjectile>of(DynamiteProjectile::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(Reference.MOD_ID, "dynamite").toString()));
}
