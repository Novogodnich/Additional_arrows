package ru.rootpoint.additionalarrows.blowUp;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import ru.rootpoint.additionalarrows.Additionalarrows;

import java.util.function.Supplier;

public class BlowUpArrowEntity extends AbstractArrow {
    public static Supplier<Item> itemSupplier;
    public BlowUpArrowEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public BlowUpArrowEntity(final Level level, final LivingEntity owner, final ItemStack pickupItemStack, final @Nullable ItemStack firedFromWeapon) {
        super(EntityTypes.ARROW, owner, level, pickupItemStack, firedFromWeapon);
    }
    @Override
    public @NonNull Packet<ClientGamePacketListener> getAddEntityPacket(@NonNull ServerEntity serverEntity) {
        return super.getAddEntityPacket(serverEntity);
    }
    @Override
    public void onHitEntity(final @NonNull EntityHitResult hitResult) {
        var pos = hitResult.getLocation();
        Level level = this.level();
        if (!level.isClientSide()) {
            level.explode(this, pos.x, pos.y, pos.z, 2.5F, Level.ExplosionInteraction.NONE);
        }
        this.discard();
    }

     @Override
     public void onHitBlock(final @NonNull BlockHitResult hitResult) {
         var pos = hitResult.getLocation();
         Level level = this.level();
         if (!level.isClientSide()) {
             level.explode(this, pos.x, pos.y, pos.z, 2.7F, Level.ExplosionInteraction.BLOCK);
         }
         this.discard();
     }

    @Override
    protected @NonNull ItemStack getDefaultPickupItem() {
        if (itemSupplier == null || itemSupplier.get() == null) {
            return new ItemStack(net.minecraft.world.item.Items.ARROW);
        }
        return new ItemStack(Additionalarrows.BLOW_UP_ARROW_ITEM);
    }
}
