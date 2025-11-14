package dooood.tekkit.fixdatcamera.mixin;

import dooood.tekkit.fixdatcamera.FixDatCamera;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
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
            at = @At("HEAD"),
            cancellable = true,
            remap = false,
            require = 0
    )
    private static void blockWorldRenderDuringVista(RenderLevelStageEvent event, CallbackInfo ci) {
        if (FixDatCamera.viewfinderRender()) {
            ci.cancel();
        }
    }
}