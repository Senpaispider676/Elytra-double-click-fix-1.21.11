package com.yourname.elytrafilter.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.item.Items;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {

    @Unique
    private long lastLeftClickTime = 0;

    @Unique
    private final int doubleClickThresholdMs = 150; 

    @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
    private void onMouseButton(long window, int button, int action, int mods, CallbackInfo ci) {
        if (button != GLFW.GLFW_MOUSE_BUTTON_LEFT || action != GLFW.GLFW_PRESS) {
            return;
        }

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null || client.currentScreen != null) {
            return;
        }

        boolean holdingElytra = client.player.getMainHandStack().isOf(Items.ELYTRA) || 
                                client.player.getOffHandStack().isOf(Items.ELYTRA);

        if (holdingElytra) {
            long currentTime = System.currentTimeMillis();
            
            if (currentTime - lastLeftClickTime < doubleClickThresholdMs) {
                ci.cancel(); 
            } else {
                lastLeftClickTime = currentTime;
            }
        }
    }
}
