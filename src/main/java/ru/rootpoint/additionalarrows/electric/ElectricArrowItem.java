package ru.rootpoint.additionalarrows.electric;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

public class ElectricArrowItem extends ArrowItem{
    public static Supplier<EntityType<ElectricArrowEntity>> entityTypeSupplier;
    public ElectricArrowItem(Properties props) {
        super(props);
    }

    @Override
    public @NonNull AbstractArrow createArrow(@NonNull Level level, @NonNull ItemStack itemStack, @NonNull LivingEntity owner, @Nullable ItemStack firedFromWeapon) {
        return new ElectricArrowEntity(level, owner, itemStack.copyWithCount(1), firedFromWeapon);
    }
}
