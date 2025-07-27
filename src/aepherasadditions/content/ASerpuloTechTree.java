package aepherasadditions.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;

public class ASerpuloTechTree {
    public static TechNode context = null;

    public static void load(){
        addToNode(arc, () -> node(ABlocks.discharge));
        addToNode(ripple, () -> node(ABlocks.disrupt));
        addToNode(cyclone, () -> node(ABlocks.hive));
        addToNode(waterExtractor, () -> node(ABlocks.hydrator));
        addToNode(cultivator, () -> node(ABlocks.mycoformer));
        addToNode(plastaniumConveyor, () -> node(ABlocks.titansteelConveyor));
        addToNode(powerNodeLarge, () -> node(ABlocks.advancedPowerNode));
        addToNode(impactReactor, () -> node(ABlocks.voltaliteReactor));
        addToNode(ABlocks.voltaliteReactor, () -> node(ABlocks.nuclearReactor));
        addToNode(ABlocks.nuclearReactor, () -> node(ABlocks.venusReactor));
        addToNode(copperWallLarge, () -> node(ABlocks.copperWallHuge));
        addToNode(ABlocks.copperWallHuge, () -> node(ABlocks.copperWallGigantic));
        addToNode(titaniumWallLarge, () -> node(ABlocks.titaniumWallHuge));
        addToNode(ABlocks.titaniumWallHuge, () -> node(ABlocks.titaniumWallGigantic));
        addToNode(plastaniumWallLarge, () -> node(ABlocks.plastaniumWallHuge));
        addToNode(ABlocks.plastaniumWallHuge, () -> node(ABlocks.plastaniumWallGigantic));
        addToNode(thoriumWallLarge, () -> node(ABlocks.thoriumWallHuge));
        addToNode(ABlocks.thoriumWallHuge, () -> node(ABlocks.thoriumWallGigantic));
        addToNode(phaseWallLarge, () -> node(ABlocks.phaseWallHuge));
        addToNode(ABlocks.phaseWallHuge, () -> node(ABlocks.phaseWallGigantic));
        addToNode(surgeWallLarge, () -> node(ABlocks.surgeWallHuge));
        addToNode(ABlocks.surgeWallHuge, () -> node(ABlocks.surgeWallGigantic));
        addToNode(titaniumWall, () -> node(ABlocks.forceWall));
        addToNode(ABlocks.forceWall, () -> node(ABlocks.forceWallLarge));
        addToNode(ABlocks.forceWallLarge, () -> node(ABlocks.forceWallHuge));
        addToNode(ABlocks.forceWallHuge, () -> node(ABlocks.forceWallGigantic));
        addToNode(surgeWall, () -> node(ABlocks.titansteelWall));
        addToNode(ABlocks.titansteelWall, () -> node(ABlocks.titansteelWallLarge));
        addToNode(ABlocks.titansteelWallLarge, () -> node(ABlocks.titansteelWallHuge));
        addToNode(ABlocks.titansteelWallHuge, () -> node(ABlocks.titansteelWallGigantic));
        addToNode(plastaniumCompressor, () -> node(ABlocks.advancedPlastaniumCompressor));
        addToNode(blastMixer, () -> node(ABlocks.voltaliteMixer));
        addToNode(ABlocks.voltaliteMixer, () -> node(ABlocks.nuclearMixer));
        addToNode(pyratiteMixer, () -> node(ABlocks.pyratiteCatalyzer));
        addToNode(blastMixer, () -> node(ABlocks.blastCatalyzer));
        addToNode(ABlocks.voltaliteMixer, () -> node(ABlocks.voltaliteCatalyzer));
        addToNode(ABlocks.nuclearMixer, () -> node(ABlocks.nuclearCatalyzer));
        addToNode(surgeSmelter, () -> node(ABlocks.cokingOven));
        addToNode(ABlocks.cokingOven, () -> node(ABlocks.cokingBlaster));
        addToNode(cryofluidMixer, () -> node(ABlocks.cryofluidCatalyzer));
        addToNode(multiPress, () -> node(ABlocks.graphiteBlaster));
        addToNode(kiln, () -> node(ABlocks.metaglassCrucible));
        addToNode(ABlocks.metaglassCrucible, () -> node(ABlocks.metaglassBlaster));
        addToNode(coalCentrifuge, () -> node(ABlocks.multiCentrifuge));
        addToNode(phaseWeaver, () -> node(ABlocks.phaseLoom));
        addToNode(pulverizer, () -> node(ABlocks.sifter));
        addToNode(siliconCrucible, () -> node(ABlocks.siliconKiln));
        addToNode(sporePress, () -> node(ABlocks.sporeMultipress));
        addToNode(surgeSmelter, () -> node(ABlocks.surgeSmeltery));
        addToNode(surgeSmelter, () -> node(ABlocks.titanSmelter));
        addToNode(ABlocks.titanSmelter, () -> node(ABlocks.titanCrucible));
        addToNode(mender, () -> node(ABlocks.overdriver));
        addToNode(mendProjector, () -> node(ABlocks.mendDome));
        addToNode(overdriveDome, () -> node(ABlocks.overdriveArray));
        addToNode(ABlocks.mendDome, () -> node(ABlocks.mendArray));
        addToNode(forceProjector, () -> node(ABlocks.forceDome));
        addToNode(coreNucleus, () -> node(ABlocks.coreApex));
        addToNode(vault, () -> node(ABlocks.receptacle));
        addToNode(repairTurret, () -> node(ABlocks.repairSpire));

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
