package aepherasadditions.content;

import mindustry.graphics.CacheLayer;

public class AepherasCacheLayers {
    public static CacheLayer
        cauradine,
        crystal,
        crystalDark
            ;

    public static void load(){
        CacheLayer.addLast(
                cauradine = new CacheLayer.ShaderLayer(AepherasShaders.cauradine),
                crystal = new CacheLayer.ShaderLayer(AepherasShaders.crystal),
                crystalDark = new CacheLayer.ShaderLayer(AepherasShaders.crystalDark)
        );
    }
}
