package dooood.tekkit.fixdatcamera.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "dev.latvian.mods.kubejs.client.KubeJSClientEventHandler", remap = false)
public class FixKubeJSEventHandlerMixin {
    @Inject(
            method = "worldRender",
            at = @At(
                value = "INVOKE",
                target = "Ldev/latvian/mods/kubejs/client/highlight/HighlightRenderer;clearBuffers(Lnet/minecraft/client/Minecraft;)V",
                shift = At.Shift.AFTER
        )
    )
    private static void rebindVistaRenderTarget(CallbackInfo ci, @Local Minecraft mc) {
        mc.getMainRenderTarget().bindWrite(true);
    }
}