package ru.rootpoint.additionalarrows.client.electric;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import ru.rootpoint.additionalarrows.electric.ElectricArrowEntity;

public class ElectricArrowRenderer extends ArrowRenderer<ElectricArrowEntity, ArrowRenderState> {

    public ElectricArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        return Identifier.fromNamespaceAndPath("additionalarrows", "entity/projectiles/electric_arrow");
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
