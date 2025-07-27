package aepherasadditions;

import aepherasadditions.content.*;
import aepherasadditions.content.custom.planets.CynerisPresets;
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
        ASounds.load();
        AShaders.load();
        ACacheLayers.load();
        AItems.load();
        ALiquids.load();
        AUnitTypes.load();
        AEffects.load();
        ABlocks.load();
        try {
            APlanets.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CynerisTechTree.load();
        CynerisPresets.load();
        ASerpuloTechTree.load();

    }
}
