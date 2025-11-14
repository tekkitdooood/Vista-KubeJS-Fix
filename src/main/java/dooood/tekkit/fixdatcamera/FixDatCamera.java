package dooood.tekkit.fixdatcamera;

import net.mehvahdjukaar.vista.client.LiveFeedRendererManager;
import net.neoforged.fml.common.Mod;

@Mod(FixDatCamera.MOD_ID)
public class FixDatCamera {
    public static final String MOD_ID = "fixdatcamera";
    public static boolean viewfinderRender() {
        return LiveFeedRendererManager.LIVE_FEED_BEING_RENDERED != null;
    }
}
