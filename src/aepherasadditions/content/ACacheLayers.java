package aepherasadditions.content;

import mindustry.graphics.CacheLayer;

public class ACacheLayers {
    public static CacheLayer
        cauradine,
        crystal,
        crystalDark
            ;

    public static void load(){
        CacheLayer.addLast(
                cauradine = new CacheLayer.ShaderLayer(AShaders.cauradine),
                crystal = new CacheLayer.ShaderLayer(AShaders.crystal),
                crystalDark = new CacheLayer.ShaderLayer(AShaders.crystalDark)
        );
    }
}
