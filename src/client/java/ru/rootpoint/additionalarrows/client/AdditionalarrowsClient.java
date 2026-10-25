package ru.rootpoint.additionalarrows.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import ru.rootpoint.additionalarrows.Additionalarrows;
import ru.rootpoint.additionalarrows.client.blowUp.BlowUpArrowRenderer;

public class AdditionalarrowsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRenderers.register(Additionalarrows.BLOW_UP_ARROW_ENTITY, BlowUpArrowRenderer::new);
    }
}
