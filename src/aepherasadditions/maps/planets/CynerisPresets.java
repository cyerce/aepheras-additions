package aepherasadditions.maps.planets;

import aepherasadditions.content.AepherasPlanets;
import mindustry.type.SectorPreset;

public class CynerisPresets {
    public static SectorPreset subzeroExpanse;

    public static void load() {
        subzeroExpanse = new SectorPreset("subzeroExpanse", AepherasPlanets.cyneris, 10) {{
            captureWave = 20;
            alwaysUnlocked = true;
            difficulty = 0;
            addStartingItems = false;
            planet = AepherasPlanets.cyneris;
            this.rules = AepherasPlanets.cyneris.ruleSetter;

        }};
    }
}
