package aepherasadditions.content;

import mindustry.content.SerpuloTechTree;
import mindustry.content.TechTree;

public class CynerisTechTree {
    public static void load(){
        AepherasPlanets.cyneris.techTree = TechTree.nodeRoot("cyneris", AepherasBlocks.coreEcho, () -> {
            TechTree.node(AepherasBlocks.coreCodex, () ->{
                TechTree.node(AepherasBlocks.coreAnima);
            });

        });
    }
}
