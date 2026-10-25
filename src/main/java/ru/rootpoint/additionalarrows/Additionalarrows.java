package ru.rootpoint.additionalarrows;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import ru.rootpoint.additionalarrows.blowUp.BlowUpArrowEntity;
import ru.rootpoint.additionalarrows.blowUp.BlowUpArrowItem;

public class Additionalarrows implements ModInitializer {
    public static final String MOD_ID = "additionalarrows";

    @Override
    public void onInitialize() {
        BlowUpArrowItem.entityTypeSupplier = () -> BLOW_UP_ARROW_ENTITY;
        BlowUpArrowEntity.itemSupplier = () -> BLOW_UP_ARROW_ITEM;
    }

    public static final EntityType<BlowUpArrowEntity> BLOW_UP_ARROW_ENTITY = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(MOD_ID, "blow_up_arrow"),
            EntityType.Builder.<BlowUpArrowEntity>of(BlowUpArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath("additionalarrows", "blow_up_arrow")
                    ))
    );

    public static final Item BLOW_UP_ARROW_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            Identifier.fromNamespaceAndPath(MOD_ID, "blow_up_arrow"),
            new BlowUpArrowItem(new Item.Properties())
    );
}
