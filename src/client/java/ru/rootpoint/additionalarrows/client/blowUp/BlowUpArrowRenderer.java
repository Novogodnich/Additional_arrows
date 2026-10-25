package ru.rootpoint.additionalarrows.client.blowUp;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import ru.rootpoint.additionalarrows.blowUp.BlowUpArrowEntity;

public class BlowUpArrowRenderer extends ArrowRenderer<BlowUpArrowEntity, ArrowRenderState> {

    public BlowUpArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        return Identifier.fromNamespaceAndPath("additionalarrows", "entity/projectiles/blow_up_arrow");
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
