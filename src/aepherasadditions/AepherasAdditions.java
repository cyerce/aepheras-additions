package aepherasadditions;

import aepherasadditions.content.*;
import aepherasadditions.maps.planets.CynerisPresets;
import arc.*;
import arc.graphics.gl.Shader;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import java.io.IOException;

public class AepherasAdditions extends Mod{

    public AepherasAdditions(){
        Log.info("Loaded AepherasAdditions constructor.");

        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                dialog.cont.image(Core.atlas.find("aepherasadditions-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    public static Shader ringShader;

    @Override
    public void loadContent() {
        AepherasShaders.load();
        AepherasCacheLayers.load();
        AepherasItems.load();
        AepherasLiquids.load();
        AepherasUnitTypes.load();
        AepherasEffects.load();
        AepherasBlocks.load();
        try {
            AepherasPlanets.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CynerisTechTree.load();
        CynerisPresets.load();
        SerpuloPlusTechTree.load();

    }
}
