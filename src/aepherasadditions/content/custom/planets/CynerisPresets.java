package aepherasadditions.content.custom.planets;

import aepherasadditions.content.APlanets;
import mindustry.type.SectorPreset;

public class CynerisPresets {
    public static SectorPreset subzeroExpanse;

    public static void load() {
        subzeroExpanse = new SectorPreset("subzeroExpanse", APlanets.cyneris, 10) {{
            captureWave = 20;
            alwaysUnlocked = true;
            difficulty = 0;
            addStartingItems = false;
            planet = APlanets.cyneris;
            this.rules = APlanets.cyneris.ruleSetter;

        }};
    }
}
