package aepherasadditions.content;

import mindustry.content.TechTree;

public class CynerisTechTree {
    public static void load(){
        APlanets.cyneris.techTree = TechTree.nodeRoot("cyneris", ABlocks.coreEcho, () -> {
            TechTree.node(ABlocks.coreCodex, () ->{
                TechTree.node(ABlocks.coreAnima);
            });

        });
    }
}
