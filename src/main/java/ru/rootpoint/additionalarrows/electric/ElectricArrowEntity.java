package ru.rootpoint.additionalarrows.electric;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
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

public class ElectricArrowEntity extends AbstractArrow {
    public static Supplier<Item> itemSupplier;
    public ElectricArrowEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public ElectricArrowEntity(final Level level, final LivingEntity owner, final ItemStack pickupItemStack, final @Nullable ItemStack firedFromWeapon) {
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
            LightningBolt bolt = new LightningBolt(EntityTypes.LIGHTNING_BOLT, level);
            bolt.setPos(pos.x, pos.y, pos.z);
            if (this.getOwner() instanceof ServerPlayer player) {
                bolt.setCause(player);
            }
            level.addFreshEntity(bolt);
        }
        this.discard();
    }

    @Override
    public void onHitBlock(final @NonNull BlockHitResult hitResult) {
        var pos = hitResult.getLocation();
        Level level = this.level();
        if (!level.isClientSide()) {
            LightningBolt bolt = new LightningBolt(EntityTypes.LIGHTNING_BOLT, level);
            bolt.setPos(pos.x, pos.y, pos.z);
            level.addFreshEntity(bolt);
        }
        this.discard();
    }

    @Override
    protected @NonNull ItemStack getDefaultPickupItem() {
        if (itemSupplier == null || itemSupplier.get() == null) {
            return new ItemStack(net.minecraft.world.item.Items.ARROW);
        }
        return new ItemStack(Additionalarrows.ELECTRIC_ARROW_ITEM);
    }
}
