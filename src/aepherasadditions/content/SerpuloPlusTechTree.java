package aepherasadditions.content;

import arc.struct.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;

public class SerpuloPlusTechTree {
    public static TechNode context = null;

    public static void load(){
        addToNode(arc, () -> node(AepherasBlocks.discharge));
        addToNode(ripple, () -> node(AepherasBlocks.disrupt));
        addToNode(cyclone, () -> node(AepherasBlocks.hive));
        addToNode(waterExtractor, () -> node(AepherasBlocks.hydrator));
        addToNode(cultivator, () -> node(AepherasBlocks.mycoformer));
        addToNode(plastaniumConveyor, () -> node(AepherasBlocks.titansteelConveyor));
        addToNode(powerNodeLarge, () -> node(AepherasBlocks.advancedPowerNode));
        addToNode(impactReactor, () -> node(AepherasBlocks.voltaliteReactor));
        addToNode(AepherasBlocks.voltaliteReactor, () -> node(AepherasBlocks.nuclearReactor));
        addToNode(AepherasBlocks.nuclearReactor, () -> node(AepherasBlocks.venusReactor));
        addToNode(copperWallLarge, () -> node(AepherasBlocks.copperWallHuge));
        addToNode(AepherasBlocks.copperWallHuge, () -> node(AepherasBlocks.copperWallGigantic));
        addToNode(titaniumWallLarge, () -> node(AepherasBlocks.titaniumWallHuge));
        addToNode(AepherasBlocks.titaniumWallHuge, () -> node(AepherasBlocks.titaniumWallGigantic));
        addToNode(plastaniumWallLarge, () -> node(AepherasBlocks.plastaniumWallHuge));
        addToNode(AepherasBlocks.plastaniumWallHuge, () -> node(AepherasBlocks.plastaniumWallGigantic));
        addToNode(thoriumWallLarge, () -> node(AepherasBlocks.thoriumWallHuge));
        addToNode(AepherasBlocks.thoriumWallHuge, () -> node(AepherasBlocks.thoriumWallGigantic));
        addToNode(phaseWallLarge, () -> node(AepherasBlocks.phaseWallHuge));
        addToNode(AepherasBlocks.phaseWallHuge, () -> node(AepherasBlocks.phaseWallGigantic));
        addToNode(surgeWallLarge, () -> node(AepherasBlocks.surgeWallHuge));
        addToNode(AepherasBlocks.surgeWallHuge, () -> node(AepherasBlocks.surgeWallGigantic));
        addToNode(titaniumWall, () -> node(AepherasBlocks.forceWall));
        addToNode(AepherasBlocks.forceWall, () -> node(AepherasBlocks.forceWallLarge));
        addToNode(AepherasBlocks.forceWallLarge, () -> node(AepherasBlocks.forceWallHuge));
        addToNode(AepherasBlocks.forceWallHuge, () -> node(AepherasBlocks.forceWallGigantic));
        addToNode(surgeWall, () -> node(AepherasBlocks.titansteelWall));
        addToNode(AepherasBlocks.titansteelWall, () -> node(AepherasBlocks.titansteelWallLarge));
        addToNode(AepherasBlocks.titansteelWallLarge, () -> node(AepherasBlocks.titansteelWallHuge));
        addToNode(AepherasBlocks.titansteelWallHuge, () -> node(AepherasBlocks.titansteelWallGigantic));
        addToNode(plastaniumCompressor, () -> node(AepherasBlocks.advancedPlastaniumCompressor));
        addToNode(blastMixer, () -> node(AepherasBlocks.voltaliteMixer));
        addToNode(AepherasBlocks.voltaliteMixer, () -> node(AepherasBlocks.nuclearMixer));
        addToNode(pyratiteMixer, () -> node(AepherasBlocks.pyratiteCatalyzer));
        addToNode(blastMixer, () -> node(AepherasBlocks.blastCatalyzer));
        addToNode(AepherasBlocks.voltaliteMixer, () -> node(AepherasBlocks.voltaliteCatalyzer));
        addToNode(AepherasBlocks.nuclearMixer, () -> node(AepherasBlocks.nuclearCatalyzer));
        addToNode(surgeSmelter, () -> node(AepherasBlocks.cokingOven));
        addToNode(AepherasBlocks.cokingOven, () -> node(AepherasBlocks.cokingBlaster));
        addToNode(cryofluidMixer, () -> node(AepherasBlocks.cryofluidCatalyzer));
        addToNode(multiPress, () -> node(AepherasBlocks.graphiteBlaster));
        addToNode(kiln, () -> node(AepherasBlocks.metaglassCrucible));
        addToNode(AepherasBlocks.metaglassCrucible, () -> node(AepherasBlocks.metaglassBlaster));
        addToNode(coalCentrifuge, () -> node(AepherasBlocks.multiCentrifuge));
        addToNode(phaseWeaver, () -> node(AepherasBlocks.phaseLoom));
        addToNode(pulverizer, () -> node(AepherasBlocks.sifter));
        addToNode(siliconCrucible, () -> node(AepherasBlocks.siliconKiln));
        addToNode(sporePress, () -> node(AepherasBlocks.sporeMultipress));
        addToNode(surgeSmelter, () -> node(AepherasBlocks.surgeSmeltery));
        addToNode(surgeSmelter, () -> node(AepherasBlocks.titanSmelter));
        addToNode(AepherasBlocks.titanSmelter, () -> node(AepherasBlocks.titanCrucible));
        addToNode(mender, () -> node(AepherasBlocks.overdriver));
        addToNode(mendProjector, () -> node(AepherasBlocks.mendDome));
        addToNode(overdriveDome, () -> node(AepherasBlocks.overdriveArray));
        addToNode(AepherasBlocks.mendDome, () -> node(AepherasBlocks.mendArray));
        addToNode(forceProjector, () -> node(AepherasBlocks.forceDome));
        addToNode(coreNucleus, () -> node(AepherasBlocks.coreApex));
        addToNode(vault, () -> node(AepherasBlocks.receptacle));
        addToNode(repairTurret, () -> node(AepherasBlocks.repairSpire));

    }

    // Credits to guiYMOUR/mindustry-Extra-Utilities for the help on this code block :)
    public static void addToNode(UnlockableContent p, Runnable c) {
        context = TechTree.all.find(t -> t.content == p);
        c.run();
    }

    public static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    public static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

    public static void node(UnlockableContent block){
        node(block, () -> {});
    }

    public static void nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.add(new Produce(content)), children);
    }

    public static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, new Seq<>(), children);
    }
}
