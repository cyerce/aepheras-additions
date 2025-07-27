package aepherasadditions.content;

import arc.audio.Sound;
import arc.files.Fi;
import mindustry.Vars;

public class ASounds {
    public static Sound

            artilleryHuge = new Sound(),
            artilleryExplosion = new Sound()
                    ;

    public static void load() {
        if(Vars.headless) return;

        artilleryHuge = Vars.tree.loadSound("artillery-huge");
        artilleryExplosion = Vars.tree.loadSound("artillery-explosion");
    }

    protected static String soundPath(String soundName){
        String name = "sounds/" + soundName;
        return Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";
    }

    protected static Fi soundFile(String soundName){
        return Vars.tree.get(soundPath(soundName));
    }
}
