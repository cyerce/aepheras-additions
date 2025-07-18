package aepherasadditions.content;

import aepherasadditions.content.custom.*;
import aepherasadditions.world.draw.DrawVenusPlasma;
import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.ConstructBlock;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.ArmoredConduit;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadRouter;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.units.RepairTurret;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class AepherasBlocks {

    public static Block

            //environment

            //environment - erekir

            //environement - cyneris
            oreAluminum, oreFerrite, oreChromium, oreSulfur, oreVanadium, oreCobalt, rubyCluster, sapphireCluster, amethystCluster, emeraldCluster, citrineCluster, quartzCluster, roseQuartzCluster, rubyFloor, sapphireFloor, amethystFloor, emeraldFloor, citrineFloor, quartzFloor, roseQuartzFloor, rubyWall, sapphireWall, amethystWall, emeraldWall, citrineWall, quartzWall, roseQuartzWall, scoria, scoriaWall, obsidian, obsidianWall, caveWater, mycelium, myceliumWall, mushroomFloor, glowingMushroom, glowingMushroomLarge, mushroomWall, cauradine, cauricStone, cauricWall,

            //boulders

            //ores

            //wall ores

            //crafting
            advancedPlastaniumCompressor, blastCatalyzer, cokingBlaster, cokingOven, cryofluidCatalyzer, graphiteBlaster, metaglassBlaster, metaglassCrucible, multiCentrifuge, nuclearCatalyzer, nuclearMixer, phaseLoom, pyratiteCatalyzer, sifter, siliconKiln, sporeMultipress, surgeSmeltery, titanCrucible, titanSmelter, voltaliteCatalyzer, voltaliteMixer,

            //crafting- Cyneris
            carbyteCondensor, sapphireCrystallizer, grapheneSynthesizer,

            //sandbox

            //walls
            copperWallHuge, copperWallGigantic, titaniumWallHuge, titaniumWallGigantic, plastaniumWallHuge, plastaniumWallGigantic, thoriumWallHuge, thoriumWallGigantic, phaseWallHuge, phaseWallGigantic, surgeWallHuge, surgeWallGigantic, forceWall, forceWallLarge, forceWallHuge, forceWallGigantic, titansteelWall, titansteelWallLarge, titansteelWallHuge, titansteelWallGigantic,


            //walls - erekir

            //defense
            overdriver, mendDome, mendArray, overdriveArray, forceDome,

            //defense - erekir
            radarLarge,

            //campaign only

            //transport
            titansteelConveyor,

            //transport - Cyneris
            pulseDriver, strataDriver, primeDriver,

            //liquid

            //liquid - Cyneris
            insulatedConduit, primeConduit, shieldedConduit, liquidCapsule, liquidCell, liquidReservoir, insulatedLiquidRouter, insulatedLiquidJunction, insulatedLiquidBridge,

            //power
            advancedPowerNode, voltaliteReactor, nuclearReactor, venusReactor,

            //power - Cyneris
            linkNode, linkNodeLarge,

            //production
            impulseDrill, hydrator, mycoformer,

            //production - Cyneris

            mechanicalHarvester, impulseHarvester, magneticHarvester, surgeHarvesterLarge, carbonScrubber, carbonConcentrator, aqueousExtractor, hydricExtractor, OsmoticExtractor,

            //storage
            coreApex, receptacle,

            //storage - erekir

            //storage - cyneris
            coreEcho, coreCodex, coreAnima, capsule,

            //turrets
            discharge, disrupt, hive,

            //turrets - Cyneris
            bract, gale, reign,

            //units
            repairSpire,

            //payloads
            payloadConveyorLarge, payloadRouterLarge,

            //payloads - Cyneris
            mechanicalPayloadConveyor, mechanicalPayloadConveyorLarge, mechanicalPayloadConveyorHuge,
            mechanicalPayloadRouter, mechanicalPayloadRouterLarge, mechanicalPayloadRouterHuge,
            mechanicalConstructor, mechanicalConstructorLarge, mechanicalConstructorHuge,
            mechanicalDeconstructor, mechanicalDeconstructorLarge, mechanicalDeconstructorHuge,
            mechanicalPayloadLoader, mechanicalPayloadLoaderLarge, mechanicalPayloadLoaderHuge,
            mechanicalPayloadUnloader, mechanicalPayloadUnloaderLarge, mechanicalPayloadUnloaderHuge

            //logic

            //campaign

            ;

    public static final Seq<Block> serpuloBlocks = new Seq<>(), erekirBlocks = new Seq<>(), cynerisBlocks = new Seq<>();

    public static void load(){
        for(int i = 1; i <= Vars.maxBlockSize; i++){
            new ConstructBlock(i);
        }

        oreAluminum = new OreBlock("ore-aluminum", AepherasItems.aluminum);
        oreFerrite = new OreBlock("ore-ferrite", AepherasItems.ferrite);
        oreCobalt = new OreBlock("ore-cobalt", AepherasItems.cobalt);
        oreChromium = new OreBlock("ore-chromium", AepherasItems.chromium);
        oreSulfur = new OreBlock("ore-sulfur", AepherasItems.sulfur);
        oreVanadium = new OreBlock("ore-vanadium", AepherasItems.vanadium);

        rubyCluster = new CrystalBlock("ruby-cluster"){{
            lightColor = Color.valueOf("f15454");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        sapphireCluster = new CrystalBlock("sapphire-cluster"){{
            lightColor = Color.valueOf("544deb");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        amethystCluster = new CrystalBlock("amethyst-cluster"){{
            lightColor = Color.valueOf("f08dd5");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        emeraldCluster = new CrystalBlock("emerald-cluster"){{
            lightColor = Color.valueOf("96f58c");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        citrineCluster = new CrystalBlock("citrine-cluster"){{
            lightColor = Color.valueOf("feb380");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        quartzCluster = new CrystalBlock("quartz-cluster"){{
            lightColor = Color.valueOf("ffffff");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        roseQuartzCluster = new CrystalBlock("rose-quartz-cluster"){{
            lightColor = Color.valueOf("ffcbdd");
            lightRadius = 100f;
            alpha = 0.38f;
            variants = 3;
            clipSize = 128f;
        }};

        rubyFloor = new Floor("ruby-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("f15454").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        sapphireFloor = new Floor("sapphire-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("544deb").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        amethystFloor = new Floor("amethyst-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("f08dd5").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        emeraldFloor = new Floor("emerald-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("96f58c").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        citrineFloor = new Floor("citrine-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("feb380").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        quartzFloor = new Floor("quartz-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("ffffff").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        roseQuartzFloor = new Floor("rose-quartz-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("ffcbdd").a(0.38f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        rubyWall = new StaticWall("ruby-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        sapphireWall = new StaticWall("sapphire-wall"){{
            sapphireFloor.asFloor().wall = this;
        }};

        amethystWall = new StaticWall("amethyst-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        emeraldWall = new StaticWall("emerald-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        citrineWall = new StaticWall("citrine-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        quartzWall = new StaticWall("quartz-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        roseQuartzWall = new StaticWall("rose-quartz-wall"){{
            rubyFloor.asFloor().wall = this;
        }};

        scoria = new Floor("scoria"){{
            attributes.set(Attribute.water, -0.25f);
        }};

        scoriaWall = new StaticWall("scoria-wall"){{
            scoria.asFloor().wall = this;
        }};

        obsidian = new Floor("obsidian"){{
            attributes.set(Attribute.water, -0.25f);
            cacheLayer = AepherasCacheLayers.crystal;
        }};

        obsidianWall = new StaticWall("obsidian-wall"){{
            obsidian.asFloor().wall = this;
        }};

        caveWater = new Floor("cave-water"){{
            speedMultiplier = 0.5f;
            variants = 0;
            status = StatusEffects.wet;
            statusDuration = 90f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};

        mycelium = new Floor("mycelium"){{
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.1f);
            lightRadius = 10f;
        }};

        myceliumWall = new StaticWall("mycelium-wall"){{
            mycelium.asFloor().wall = this;
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.1f);
            lightRadius = 10f;
        }};

        mushroomFloor = new Floor("mushroom-floor"){{
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.15f);
            lightRadius = 15f;
        }};

        mushroomWall = new StaticWall("mushroom-wall"){{
            mushroomFloor.asFloor().wall = this;
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.15f);
            lightRadius = 15f;
        }};

        glowingMushroom = new Prop("glowing-mushroom"){{
            variants = 3;
            breakSound = Sounds.plantBreak;
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.25f);
            lightRadius = 20f;
        }};

        glowingMushroomLarge = new TallMushroom("glowing-mushroom-large"){{
            emitLight = true;
            lightColor = Color.valueOf("679abb").a(0.5f);
            lightRadius = 50f;
            variants = 3;
        }};

        cauradine = new Floor("cauradine"){{
            drownTime = 230f;
            status = StatusEffects.melting;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = Liquids.slag;
            isLiquid = true;
            cacheLayer = AepherasCacheLayers.cauradine;
            attributes.set(Attribute.heat, 0.85f);

            emitLight = true;
            lightRadius = 40f;
            lightColor = Color.red.cpy().a(0.25f);
        }};

        cauricStone = new Floor("cauric-stone"){{
            emitLight = true;
            lightColor = Color.red.cpy().a(0.1f);
            lightRadius = 25f;
            cacheLayer = AepherasCacheLayers.crystalDark;
        }};

        // crafting

        advancedPlastaniumCompressor = new GenericCrafter("advanced-plastanium-compressor"){{
            requirements(Category.crafting, with(Items.lead, 230, Items.graphite, 120, Items.titanium, 160, Items.silicon, 160, Items.plastanium, 90));
            size = 3;
            craftEffect = Fx.formsmoke;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFade());
            hasItems = hasLiquids = hasPower = true;
            itemCapacity = 12;
            liquidCapacity = 84f;
            craftTime = 60f;


            consumeItems(with(Items.titanium, 6, Items.pyratite, 1));
            consumeLiquid(Liquids.oil, 0.7f);
            consumePower(7f);

            outputItem = new ItemStack(Items.plastanium, 4);

        }};

        pyratiteCatalyzer = new GenericCrafter("pyratite-catalyzer"){{
            requirements(Category.crafting, with(Items.copper, 125, Items.lead, 125, Items.plastanium, 40, Items.silicon, 50));
            size = 3;
            hasItems = hasLiquids = hasPower = true;
            itemCapacity = 12;
            liquidCapacity = 24;
            craftTime = 80f;

            consumePower(2f);
            consumeItems(with(Items.coal, 6, Items.lead, 8, Items.sand, 8));
            consumeLiquid(Liquids.water, 0.2f);

            outputItem = new ItemStack(Items.pyratite, 6);
        }};

        blastCatalyzer = new GenericCrafter("blast-catalyzer"){{
            requirements(Category.crafting, with(Items.copper, 125, Items.titanium, 125, Items.plastanium, 40, Items.silicon, 50));
            size = 3;
            hasItems = hasLiquids = hasPower = true;
            itemCapacity = 12;
            liquidCapacity = 24;
            craftTime = 80f;

            consumePower(2f);
            consumeItems(with(Items.pyratite, 6, Items.sporePod, 4));
            consumeLiquid(Liquids.water, 0.2f);

            outputItem = new ItemStack(Items.blastCompound, 6);
        }};

        cokingOven = new GenericCrafter("coking-oven"){{
            requirements(Category.crafting, with(Items.copper, 80, Items.lead, 120, Items.silicon, 60));
            size = 2;
            hasItems = hasPower = true;
            itemCapacity = 10;
            craftTime = 90f;

            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(1f);
            consumeItem(Items.coal, 2);

            outputItem = new ItemStack(AepherasItems.coalCoke, 1);
        }};

        cokingBlaster = new AttributeCrafter("coking-blaster"){{
            requirements(Category.crafting, with(Items.lead, 100, Items.silicon, 30, Items.graphite, 50, Items.titanium, 90));
            size = 3;
            hasItems = hasPower = true;
            itemCapacity = 18;
            craftTime = 90f;

            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(3f);
            consumeItems(with(Items.coal, 9, Items.pyratite, 1));

            outputItem = new ItemStack(AepherasItems.coalCoke, 4);
        }};

        cryofluidCatalyzer = new GenericCrafter("cryofluid-catalyzer"){{
            requirements(Category.crafting, with(Items.lead, 230, Items.titanium, 160, Items.silicon, 160, Items.thorium, 90));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 10;
            liquidCapacity = 72;
            craftTime = 60f;

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(Liquids.cryofluid){{drawLiquidLight = true;}}, new DrawDefault());

            consumePower(5f);
            consumeLiquid(Liquids.water, 0.6f);
            consumeItem(Items.titanium, 1);

            outputLiquid = new LiquidStack(Liquids.cryofluid, 0.6f);
        }};

        graphiteBlaster = new AttributeCrafter("graphite-blaster"){{
            requirements(Category.crafting, with(Items.titanium, 180, Items.silicon, 160, Items.plastanium, 160, Items.thorium, 120));
            size = 4;
            hasItems = hasPower = true;
            itemCapacity = 32;
            craftTime = 90f;

            craftEffect = Fx.pulverizeMedium;

            consumePower(4f);
            consumeItems(with(Items.coal, 16, Items.pyratite, 1));

            outputItem = new ItemStack(Items.graphite, 12);
        }};

        metaglassCrucible = new AttributeCrafter("metaglass-crucible"){{
            requirements(Category.crafting, with(Items.titanium, 140, Items.lead, 120, Items.silicon, 120, Items.plastanium, 90));
            size = 3;
            hasItems = hasPower = true;
            itemCapacity = 20;
            craftTime = 120f;

            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(2f);
            consumeItems(with(Items.sand, 8, Items.lead, 8, Items.pyratite, 1));

            outputItem = new ItemStack(Items.metaglass, 10);
        }};

        metaglassBlaster = new AttributeCrafter("metaglass-blaster"){{
            requirements(Category.crafting, with(Items.titanium, 180, Items.silicon, 160, Items.plastanium, 160, Items.thorium,160 ));
            size = 4;
            hasItems = hasPower = true;
            itemCapacity = 32;
            craftTime = 90f;

            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(5f);
            consumeItems(with(Items.sand, 10, Items.lead, 10, Items.blastCompound, 2));

            outputItem = new ItemStack(Items.metaglass, 16);
        }};

        multiCentrifuge = new GenericCrafter("multi-centrifuge"){{
            requirements(Category.crafting, with(Items.lead, 80, Items.titanium, 120, Items.graphite, 60, Items.plastanium, 35));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 32;
            liquidCapacity = 144f;
            craftTime = 30f;

            consumePower(3f);
            consumeLiquid(Liquids.oil, 1.2f);
            consumeItem(Items.pyratite, 1);

            outputItem = new ItemStack(Items.coal, 16);
        }};

        voltaliteMixer = new GenericCrafter("voltalite-mixer"){{
            requirements(Category.crafting, with(Items.lead, 120, Items.silicon, 120, Items.thorium, 60, Items.surgeAlloy, 20));
            size = 2;
            hasItems = hasPower = true;
            itemCapacity = 10;
            craftTime = 80f;

            consumePower(0.8f);
            consumeItems(with(Items.blastCompound, 1, Items.surgeAlloy, 2));

            outputItem = new ItemStack(AepherasItems.voltalite, 1);
        }};

        voltaliteCatalyzer = new GenericCrafter("voltalite-catalyzer"){{
            requirements(Category.crafting, with(Items.lead, 180, Items.graphite, 130, Items.titanium, 180, Items.thorium, 120, Items.surgeAlloy, 45));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 12;
            liquidCapacity = 24f;
            craftTime = 80f;

            consumePower(3f);
            consumeItems(with(Items.blastCompound, 6, Items.surgeAlloy, 4));
            consumeLiquid(Liquids.water, 0.2f);

            outputItem = new ItemStack(AepherasItems.voltalite, 6);
        }};

        nuclearMixer = new GenericCrafter("nuclear-mixer"){{
            requirements(Category.crafting, with(Items.lead, 160, Items.silicon, 140, Items.thorium, 80, Items.surgeAlloy, 35, Items.phaseFabric, 20));
            size = 2;
            hasItems = hasPower = true;
            itemCapacity = 10;
            craftTime = 80f;

            consumePower(1.6f);
            consumeItems(with(AepherasItems.voltalite, 1, Items.thorium, 3));

            outputItem = new ItemStack(AepherasItems.nuclearCompound, 1);
        }};

        nuclearCatalyzer = new GenericCrafter("nuclear-catalyzer"){{
            requirements(Category.crafting, with(Items.copper, 125, Items.titanium, 125, Items.plastanium, 60, Items.silicon, 40, Items.surgeAlloy, 50, Items.phaseFabric, 40));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 12;
            liquidCapacity = 24f;
            craftTime = 80f;

            consumePower(6f);
            consumeItems(with(AepherasItems.voltalite, 6, Items.thorium, 12));
            consumeLiquid(Liquids.water, 0.2f);

            outputItem = new ItemStack(AepherasItems.nuclearCompound, 6);
        }};

        phaseLoom = new GenericCrafter("phase-loom"){{
            requirements(Category.crafting, with(Items.lead, 160, Items.thorium, 120, Items.silicon, 90, Items.plastanium, 80, Items.surgeAlloy, 35));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 48;
            liquidCapacity = 12f;
            craftTime = 240f;

            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.02f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawWeave(), new DrawDefault());

            consumePower(7f);
            consumeItems(with(Items.thorium, 12, Items.sand, 24));
            consumeLiquid(Liquids.cryofluid, 0.1f);

            outputItem = new ItemStack(Items.phaseFabric, 4);
        }};

        sifter = new GenericCrafter("sifter"){{
            requirements(Category.crafting, with(Items.copper, 80, Items.lead, 120, Items.silicon, 60));
            size = 2;
            hasItems = hasPower = true;
            itemCapacity = 20;
            craftTime = 90f;

            consumePower(3f);
            consumeItem(Items.sand, 10);

            outputItem = new ItemStack(Items.scrap, 8);
        }};

        siliconKiln = new AttributeCrafter("silicon-kiln"){{
            requirements(Category.crafting, with(Items.titanium, 140, Items.silicon, 120, Items.plastanium, 90, Items.thorium, 180));
            size = 4;
            hasItems = hasPower = true;
            itemCapacity = 40;
            craftTime = 90f;

            drawer = new DrawMulti(new DrawDefault(), new DrawFlame());

            consumePower(4);
            consumeItems(with(Items.coal, 10, Items.sand, 15, Items.blastCompound, 2));

            outputItem = new ItemStack(Items.silicon, 20);
        }};

        sporeMultipress = new GenericCrafter("spore-multipress"){{
            requirements(Category.crafting, with(Items.lead, 230, Items.graphite, 120, Items.titanium, 160, Items.silicon, 160, Items.plastanium, 90));
            size = 4;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 10;
            liquidCapacity = 240f;
            craftTime = 20f;

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.oil), new DrawDefault(), new DrawRegion("-top"));

            consumePower(3f);
            consumeItem(Items.sporePod, 5);
            consumeLiquid(Liquids.water, 0.2f);

            outputLiquid = new LiquidStack(Liquids.oil, 2f);
        }};

        surgeSmeltery = new AttributeCrafter("surge-smeltery"){{
            requirements(Category.crafting, with(Items.lead, 300, Items.silicon, 230, Items.thorium, 200, Items.surgeAlloy, 60));
            size = 4;
            hasItems = hasPower = true;
            itemCapacity = 24;
            craftTime = 90f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.1f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(), new DrawDefault(), new DrawFlame());

            consumePower(4f);
            consumeItems(with(Items.copper, 9, Items.lead, 12, Items.titanium, 6, Items.silicon, 9, Items.pyratite, 1));

            outputItem = new ItemStack(Items.surgeAlloy, 4);
        }};

        titanSmelter = new GenericCrafter("titan-smelter"){{
            requirements(Category.crafting, with(Items.lead, 180, Items.graphite, 130, Items.titanium, 180, Items.thorium, 120, Items.surgeAlloy, 45));
            size = 3;
            hasItems = hasPower = true;
            itemCapacity = 10;
            craftTime = 30f;

            craftEffect = Fx.smeltsmoke;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.1f;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8ca9e8")));

            consumePower(3f);
            consumeItems(with(Items.titanium, 2, AepherasItems.coalCoke, 2));

            outputItem = new ItemStack(AepherasItems.titansteel, 2);
        }};

        titanCrucible = new AttributeCrafter("titan-crucible"){{
            requirements(Category.crafting, with(Items.lead, 300, Items.silicon, 230, Items.thorium, 200, Items.surgeAlloy, 60));
            size = 4;
            hasItems = hasPower = true;
            itemCapacity = 16;
            craftTime = 90f;

            craftEffect = Fx.smeltsmoke;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.2f;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8ca9e8")));

            consumePower(4f);
            consumeItems(with(Items.titanium, 6, AepherasItems.coalCoke, 4, Items.pyratite, 1));

            outputItem = new ItemStack(AepherasItems.titansteel, 8);
        }};

        //crafting - Cyneris

        carbyteCondensor = new GenericCrafter("carbyte-condensor"){{
            requirements(Category.crafting, with(AepherasItems.aluminum, 30, AepherasItems.ferrite, 25));
            size = 2;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 10;
            craftTime = 80;

            craftEffect = Fx.pulverizeMedium;
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 1f), new DrawRegion("-top"));

            consumePower(0.5f);
            consumeLiquid(AepherasLiquids.carbonDioxide, 0.6f);

            outputItem = new ItemStack(AepherasItems.carybte, 2);
            outputLiquid = new LiquidStack(Liquids.ozone, 0.4f);

            researchCostMultiplier = 0.11f;
        }};

        sapphireCrystallizer = new GenericCrafter("sapphire-crystallizer"){{
            requirements(Category.crafting, with(AepherasItems.aluminum, 90, AepherasItems.ferrite, 75));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            itemCapacity = 10;
            craftTime = 30f;

            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.05f;

            DrawPlasma sapphirePlasma = new DrawPlasma();
            sapphirePlasma.plasma1 = sapphirePlasma.plasma2 = Color.white;
            drawer = new DrawMulti(new DrawDefault(), new DrawLiquidRegion(Liquids.water), new DrawPlasma(), new DrawRegion("-top"));

            consumePower(0.5f);
            consumeItems(with(AepherasItems.aluminum, 1, AepherasItems.ferrite, 1));
            consumeLiquid(Liquids.water, 0.2f);

            outputItem = new ItemStack(AepherasItems.sapphire, 1);
        }};

        grapheneSynthesizer = new GenericCrafter("graphene-synthesizer"){{
            requirements(Category.crafting, with(AepherasItems.aluminum, 40, AepherasItems.ferrite, 30));
            size = 2;
            hasItems = hasPower = true;
            itemCapacity = 10;
            craftTime = 40f;

            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.05f;

            drawer = new DrawMulti(new DrawDefault(), new DrawGrapheneWeave("-weave1", "clockwise"), new DrawGrapheneWeave("-weave2", "counterclockwise"), new DrawRegion("-top"));

            consumePower(1f);
            consumeItem(AepherasItems.carybte, 2);

            outputItem = new ItemStack(AepherasItems.graphene, 1);
        }};

        //walls

        copperWallHuge = new Wall("copper-wall-huge"){{
            requirements(Category.defense, with(Items.copper, 54));
            size = 3;
            scaledHealth = 320f;
        }};

        copperWallGigantic = new Wall("copper-wall-gigantic"){{
           requirements(Category.defense, with(Items.copper, 96));
           size = 4;
           scaledHealth = 320f;
        }};

        titaniumWallHuge = new Wall("titanium-wall-huge"){{
            requirements(Category.defense, with(Items.titanium, 54));
            size = 3;
            scaledHealth = 440f;
        }};

        titaniumWallGigantic = new Wall("titanium-wall-gigantic"){{
            requirements(Category.defense, with(Items.titanium, 96));
            size = 4;
            scaledHealth = 440f;
        }};

        plastaniumWallHuge = new Wall("plastanium-wall-huge"){{
            requirements(Category.defense, with(Items.metaglass, 18, Items.plastanium, 45));
            size = 3;
            scaledHealth = 500f;
            insulated = true;
            absorbLasers = true;
        }};

        plastaniumWallGigantic = new Wall("plastanium-wall-gigantic"){{
            requirements(Category.defense, with(Items.metaglass, 32, Items.plastanium, 80));
            size = 4;
            scaledHealth = 500f;
            insulated = true;
            absorbLasers = true;
        }};

        thoriumWallHuge = new Wall("thorium-wall-huge"){{
            requirements(Category.defense, with(Items.thorium, 54));
            size = 3;
            scaledHealth = 800f;
        }};

        thoriumWallGigantic = new Wall("thorium-wall-gigantic"){{
            requirements(Category.defense, with(Items.thorium, 96));
            size = 4;
            scaledHealth = 800f;
        }};

        phaseWallHuge = new Wall("phase-wall-huge"){{
            requirements(Category.defense, with(Items.phaseFabric, 54));
            size = 3;
            scaledHealth = 600f;
            flashHit = true;
            chanceDeflect = 10f;
        }};

        phaseWallGigantic = new Wall("phase-wall-gigantic"){{
            requirements(Category.defense, with(Items.phaseFabric, 96));
            size = 4;
            scaledHealth = 600f;
            chanceDeflect = 10f;
        }};

        surgeWallHuge = new Wall("surge-wall-huge"){{
            requirements(Category.defense, with(Items.surgeAlloy, 54));
            size = 3;
            scaledHealth = 920f;
            lightningChance = 0.05f;
            lightningDamage = 20f;
        }};

        surgeWallGigantic = new Wall("surge-wall-gigantic"){{
            requirements(Category.defense, with(Items.surgeAlloy, 96));
            size = 4;
            scaledHealth = 920f;
            lightningChance = 0.05f;
            lightningDamage = 20f;
        }};

        forceWall = new ShieldWall("force-wall"){{
            requirements(Category.defense, with(Items.titanium, 12, Items.silicon, 6, Items.lead, 18));
            size = 1;
            scaledHealth = 600f;
            hasPower = consumesPower = conductivePower = true;
            outputsPower = false;
            shieldHealth = 100f;
            breakCooldown = 600f;
            regenSpeed = 2f;
            consumePower(0.1f);
        }};

        forceWallLarge = new ShieldWall("force-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 48, Items.silicon, 24, Items.lead, 72));
            size = 2;
            scaledHealth = 600f;
            hasPower = consumesPower = conductivePower = true;
            outputsPower = false;
            shieldHealth = 400f;
            breakCooldown = 600f;
            regenSpeed = 2f;
            consumePower(0.1f);
        }};

        forceWallHuge = new ShieldWall("force-wall-huge"){{
            requirements(Category.defense, with(Items.titanium, 108, Items.silicon, 54, Items.lead, 162));
            size = 3;
            scaledHealth = 600f;
            hasPower = consumesPower = conductivePower = true;
            outputsPower = false;
            shieldHealth = 900f;
            breakCooldown = 600f;
            regenSpeed = 2f;
            consumePower(0.1f);
        }};

        forceWallGigantic = new ShieldWall("force-wall-gigantic"){{
            requirements(Category.defense, with(Items.titanium, 192, Items.silicon, 96, Items.lead, 288));
            size = 4;
            scaledHealth = 600f;
            hasPower = consumesPower = conductivePower = true;
            outputsPower = false;
            shieldHealth = 1600f;
            breakCooldown = 600f;
            regenSpeed = 2f;
            consumePower(0.1f);
        }};

        titansteelWall = new Wall("titansteel-wall"){{
            requirements(Category.defense, with(AepherasItems.titansteel, 12, Items.surgeAlloy, 12, Items.plastanium, 10, Items.metaglass, 4, Items.phaseFabric, 12));
            size = 1;
            scaledHealth = 1024f;
            insulated = absorbLasers = flashHit = true;
            chanceDeflect = 10f;
            lightningDamage = 20f;
            lightningChance = 0.05f;
        }};

        titansteelWallLarge = new Wall("titansteel-wall-large"){{
            requirements(Category.defense, with(AepherasItems.titansteel, 48, Items.surgeAlloy, 48, Items.plastanium, 40, Items.metaglass, 16, Items.phaseFabric, 48));
            size = 2;
            scaledHealth = 1024f;
            insulated = absorbLasers = flashHit = true;
            chanceDeflect = 10f;
            lightningDamage = 20f;
            lightningChance = 0.05f;
        }};

        titansteelWallHuge = new Wall("titansteel-wall-huge"){{
            requirements(Category.defense, with(AepherasItems.titansteel, 108, Items.surgeAlloy, 108, Items.plastanium, 90, Items.metaglass, 36, Items.phaseFabric, 108));
            size = 3;
            scaledHealth = 1024f;
            insulated = absorbLasers = flashHit = true;
            chanceDeflect = 10f;
            lightningDamage = 20f;
            lightningChance = 0.05f;
        }};

        titansteelWallGigantic = new Wall("titansteel-wall-gigantic"){{
            requirements(Category.defense, with(AepherasItems.titansteel, 192, Items.surgeAlloy, 192, Items.plastanium, 160, Items.metaglass, 64, Items.phaseFabric, 192));
            size = 4;
            scaledHealth = 1024f;
            insulated = absorbLasers = flashHit = true;
            chanceDeflect = 10f;
            lightningDamage = 20f;
            lightningChance = 0.05f;
        }};

        //defense

        overdriver = new OverdriveProjector("overdriver"){{
            requirements(Category.effect, with(Items.copper, 50, Items.lead, 60, Items.silicon, 20, Items.titanium, 30));
            size = 1;
            speedBoost = 1.25f;
            speedBoostPhase = 0.25f;

            consumePower(0.7f);
            consumeItem(Items.silicon, 1).boost();
        }};

        mendDome = new MendProjector("mend-dome"){{
            requirements(Category.effect, with(Items.lead, 200, Items.titanium, 50, Items.silicon, 50, Items.plastanium, 40, Items.surgeAlloy, 120));
            size = 3;
            healPercent = 20f;
            range = 200f;
            useTime = 300f;

            consumePower(3f);
            consumeItems(with(Items.silicon, 1, Items.phaseFabric, 1));
        }};

        mendArray = new MendProjector("mend-array"){{
            requirements(Category.effect, with(Items.lead, 500, Items.titanium, 250, Items.silicon, 250, Items.plastanium, 300, Items.thorium, 300, Items.phaseFabric, 250, Items.surgeAlloy, 320));
            size = 5;
            healPercent = 35f;
            range = 300f;
            useTime = 150f;

            consumePower(6f);
            consumeItems(with(Items.silicon, 2, Items.phaseFabric, 2));
            consumeLiquid(Liquids.cryofluid, 0.3f);
        }};

        overdriveArray = new OverdriveProjector("overdrive-array"){{
            requirements(Category.effect, with(Items.lead,600, Items.titanium, 400, Items.silicon, 340, Items.thorium, 300, Items.plastanium, 360, Items.surgeAlloy, 320));
            size = 5;
            hasBoost = false;
            speedBoost = 3.5f;
            range = 300f;
            useTime = 150f;

            consumePower(6f);
            consumeItems(with(Items.silicon, 2, Items.phaseFabric, 2));
            consumeLiquid(Liquids.cryofluid, 0.3f);
        }};

        forceDome = new ForceProjector("force-dome"){{
            requirements(Category.effect, with(Items.lead, 250, Items.titanium, 200, Items.silicon, 200, Items.plastanium, 130, Items.surgeAlloy, 135));
            size = 5;
            radius = 140;
            phaseRadiusBoost = 90f;
            shieldHealth = 1000f;
            cooldownNormal = 1.7f;
            cooldownLiquid = 1.4f;
            cooldownBrokenBase = 0.55f;
            phaseShieldBoost = 750f;

            itemConsumer = consumeItems(with(Items.phaseFabric, 2, Items.silicon, 2)).boost();
            consumePower(9f);
        }};

        //defense - Erekir
        radarLarge = new Radar("radar-large"){{
            requirements(Category.effect, BuildVisibility.fogOnly, with(Items.silicon, 110, Items.thorium, 85, Items.oxide, 45));
            size = 2;
            outlineColor = Color.valueOf("4a4b53");
            fogRadius = 75;

            consumePower(2f);
        }};

        //transportation

        titansteelConveyor = new StackConveyor("titansteel-conveyor"){{
            requirements(Category.distribution, with(AepherasItems.titansteel, 2, Items.plastanium, 2, Items.thorium, 2));
            health = 345;
            speed = 0.1f;
            itemCapacity = 25;
        }};

        //transportation - Cyneris

        pulseDriver = new MassDriver("pulse-driver"){{
            requirements(Category.distribution, with(AepherasItems.aluminum, 10));
            size = 1;
            range = 80f;
            itemCapacity = 15;
            researchCostMultiplier = 0.11f;
            hasPower = false;
        }};

        strataDriver = new MassDriver("strata-driver"){{
            requirements(Category.distribution, with(AepherasItems.aluminum, 50, AepherasItems.ferrite, 40, AepherasItems.graphene, 30));
            size = 2;
            range = 200f;
            itemCapacity = 50;
            consumePower(1/3f);
            researchCostMultiplier = 0.11f;
        }};

        primeDriver = new MassDriver("prime-driver"){{
            requirements(Category.distribution, with( AepherasItems.ferrite, 130, AepherasItems.graphene, 80, AepherasItems.steel, 55));
            size = 3;
            range = 500f;
            itemCapacity = 125;
            consumePower(1f);
            researchCostMultiplier = 0.11f;
        }};

        //liquid - Cyneris

        insulatedConduit = new Conduit("insulated-conduit"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 1, AepherasItems.aluminum, 1));
            size = 1;
            liquidCapacity = 20f;
            health = 65;
        }};

        primeConduit = new Conduit("prime-conduit"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 1, AepherasItems.cobalt, 2));
            size = 1;
            liquidCapacity = 40f;
            liquidPressure = 1.025f;
            health = 130;
        }};

        shieldedConduit = new ArmoredConduit("shielded-conduit"){{
            requirements(Category.liquid, with(AepherasItems.steel, 2, AepherasItems.sapphire, 1, AepherasItems.chromium, 1));
            size = 1;
            liquidCapacity = 50f;
            liquidPressure = 1.03f;
            health = 300;
        }};

        insulatedLiquidRouter = new LiquidRouter("insulated-liquid-router"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 2, AepherasItems.ferrite, 4));
            size = 1;
            liquidCapacity = 120f;
            underBullets = true;
            solid = false;
        }};

        liquidCapsule = new LiquidRouter("liquid-capsule"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 15, AepherasItems.cobalt, 10));
            size = 2;
            liquidCapacity = 700f;
            solid = true;
        }};

        liquidCell = new LiquidRouter("liquid-cell"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 40, AepherasItems.cobalt, 30));
            size = 3;
            liquidCapacity = 1800;
            solid = true;
        }};

        liquidReservoir = new LiquidRouter("liquid-reservoir"){{
            requirements(Category.liquid, with(AepherasItems.sapphire, 75, AepherasItems.cobalt, 50));
            size = 4;
            liquidCapacity = 5500;
            solid = true;
        }};


        //power

        advancedPowerNode = new PowerNode("advanced-power-node"){{
            requirements(Category.power, with(Items.lead, 30, Items.titanium, 20, Items.silicon, 45, Items.surgeAlloy, 15, Items.phaseFabric, 20));
            size = 2;
            health = 650;
            maxNodes = 25;
            laserRange = 40f;
        }};

        voltaliteReactor = new ImpactReactor("voltalite-reactor"){{
            requirements(Category.power, with(Items.copper, 13550, Items.lead, 14330, Items.silicon, 13550, Items.graphite, 7500, Items.thorium, 8500, Items.surgeAlloy, 3500, Items.phaseFabric, 4400));
            size = 5;
            hasItems = hasPower = hasLiquids = true;
            powerProduction = 312f;
            ambientSound = Sounds.beam;
            ambientSoundVolume = 0.5f;
            consumePower(60f);
            consumeItems(with(AepherasItems.voltalite, 5, Items.thorium, 5, Items.blastCompound, 5));
            consumeLiquid(Liquids.cryofluid, 1.6f);
            explodeEffect = AepherasFx.voltaliteReactorExplosion;
        }};

        nuclearReactor = new ImpactReactor("nuclear-reactor"){{
            requirements(Category.power, with(Items.lead, 18650, Items.silicon, 17350, Items.graphite, 7500, Items.thorium, 11500, Items.surgeAlloy, 5500, Items.phaseFabric, 6400));
            size = 6;
            hasItems = hasPower = hasLiquids = true;
            powerProduction = 676f;
            ambientSound = Sounds.beam;
            ambientSoundVolume = 0.625f;
            consumePower(130f);
            consumeItems(with(AepherasItems.nuclearCompound, 5, Items.graphite, 1, Items.titanium, 1));
            consumeLiquid(Liquids.cryofluid, 2.4f);
            explodeEffect = AepherasFx.nuclearReactorExplosion;
        }};

        venusReactor = new ImpactReactor("venus-reactor"){{
            requirements(Category.power, with(Items.lead, 21000, Items.silicon, 19350, Items.graphite, 9500, Items.thorium, 13550, Items.surgeAlloy, 7500, Items.phaseFabric, 6400));
            size = 7;
            itemCapacity = 30;
            hasItems = hasPower = hasLiquids = true;
            powerProduction = 3515.2f;
            ambientSound = Sounds.beam;
            ambientSoundVolume = 0.75f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawVenusPlasma(), new DrawDefault());
            consumePower(676f);
            consumeItems(with(AepherasItems.nuclearCompound, 5, AepherasItems.voltalite, 10, Items.blastCompound, 15));
            consumeLiquid(Liquids.cryofluid, 3.2f);
            explodeEffect = new MultiEffect(AepherasFx.venusReactorExplosion1, AepherasFx.venusReactorExplosion2, Fx.bigShockwave, Fx.scatheExplosion, Fx.sparkExplosion, Fx.explosion, Fx.titanExplosion);
        }};

        linkNode = new CynerisPowerNode("link-node", Color.valueOf("4c7ee7")){{
            requirements(Category.power, with(AepherasItems.aluminum, 2, AepherasItems.ferrite, 2));
            maxNodes = 10;
            laserRange = 6f;
            laserColor2 = Color.valueOf("80a9ff");
        }};

        linkNodeLarge = new CynerisPowerNode("link-node-large", Color.valueOf("4c7ee7")){{
            requirements(Category.power, with(AepherasItems.aluminum, 2, AepherasItems.ferrite, 2));
            size = 2;
            maxNodes = 15;
            laserRange = 15f;
            laserColor2 = Color.valueOf("80a9ff");
        }};

        impulseDrill = new Drill("impulse-drill"){{
            requirements(Category.production, with(Items.copper, 285, Items.silicon, 230, Items.titanium, 200, Items.thorium, 175, Items.surgeAlloy, 35));
            drillTime = 120;
            size = 4;
            drawRim = true;
            hasPower = true;
            tier = 5;
            updateEffect = Fx.pulverizeRed;
            updateEffectChance = 0.03f;
            drillEffect = Fx.mineHuge;
            rotateSpeed = 8f;
            warmupSpeed = 0.01f;
            itemCapacity = 40;

            liquidBoostIntensity = 2.4f;

            consumePower(7f);
            consumeLiquid(Liquids.water, 0.1f).boost();
        }};

        hydrator = new SolidPump("hydrator"){{
            requirements(Category.production, with(Items.metaglass, 120, Items.graphite, 80, Items.silicon, 60, Items.titanium, 75));
            size = 3;
            hasPower = hasLiquids = true;
            liquidCapacity = 360f;
            result = Liquids.water;
            pumpAmount = 0.6f;
            attribute = Attribute.water;

            consumePower(3f);
        }};

        mycoformer = new AttributeCrafter("mycoformer"){{
            requirements(Category.production, with(Items.lead, 125, Items.titanium, 125, Items.silicon, 50, Items.plastanium, 50));
            size = 3;
            hasItems = hasPower = hasLiquids = true;
            attribute = Attribute.spores;
            legacyReadWarmup = true;
            maxBoost = 2f;
            itemCapacity = 10;
            liquidCapacity = 144f;
            craftTime = 60f;

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawDefault(), new DrawCultivator(), new DrawRegion("-top"));

            consumePower(4f);
            consumeItem(Items.coal, 1);
            consumeLiquid(Liquids.water, 1.2f);

            outputItem = new ItemStack(Items.sporePod, 3);
        }};

        //production - Cyneris

        carbonScrubber = new GenericCrafter("carbon-scrubber"){{
            requirements(Category.production, with(AepherasItems.aluminum, 30, AepherasItems.ferrite, 40));
            size = 2;
            hasLiquids = true;
            liquidCapacity = 24f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawBlurSpin("-rotator", 5),
                    new DrawRegion("-top")
            );
            consumePower(0.5f);
            outputLiquid = new LiquidStack(AepherasLiquids.carbonDioxide, 0.1f);
        }};

        //storage

        coreApex = new CoreBlock("core-apex"){{
            requirements(Category.effect, with(Items.copper, 12000, Items.lead, 12000, Items.silicon, 9000, Items.thorium, 8000, Items.metaglass, 8000, Items.plastanium, 7000));
            health = 9500;
            size = 6;
            unitCapModifier = 32;
            researchCostMultiplier = 0.11f;
            itemCapacity = 18000;
            unitType = AepherasUnitTypes.delta;
        }};

        receptacle = new StorageBlock("receptacle"){{
            requirements(Category.effect, with(Items.titanium, 500, Items.thorium, 250, AepherasItems.titansteel, 125));
            scaledHealth = 55f;
            itemCapacity = 3000;
            size = 5;
        }};

        // storage - cyneris

        coreEcho = new CoreBlock("core-echo"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(AepherasItems.aluminum, 1000, AepherasItems.ferrite, 1000));
            health = 1000;
            size = 2;
            alwaysUnlocked = isFirstTier = true;
            unitCapModifier = 8;
            itemCapacity = 5000;
            unitType = AepherasUnitTypes.drift;
        }};

        coreCodex = new CoreBlock("core-codex"){{
            requirements(Category.effect, BuildVisibility.shown, with(AepherasItems.aluminum, 4000, AepherasItems.ferrite, 4000, AepherasItems.graphene, 3000));
            health = 3000;
            size = 3;
            unitCapModifier = 16;
            itemCapacity = 10000;
            researchCostMultiplier = 0.11f;
            unitType = AepherasUnitTypes.veil;
        }};

        coreAnima = new CoreBlock("core-anima"){{
            requirements(Category.effect, BuildVisibility.shown, with(AepherasItems.aluminum, 9000, AepherasItems.ferrite, 9000, AepherasItems.steel, 5000, AepherasItems.graphene, 6000));
            health = 5000;
            size = 4;
            unitCapModifier = 24;
            itemCapacity = 15000;
            researchCostMultiplier = 0.11f;
            unitType = AepherasUnitTypes.tempest;
        }};

        capsule = new StorageBlock("capsule"){{
            requirements(Category.effect, with(AepherasItems.aluminum, 10));
            scaledHealth = 55f;
            itemCapacity = 25;
            size = 1;
        }};


        // turrets

        discharge = new PowerTurret("discharge"){{
            requirements(Category.turret, with(Items.copper, 110, Items.lead, 90, Items.titanium, 80, Items.silicon, 70));
            size = 2;
            range = 165f;
            reload = 45f;
            recoil = 2f;
            shootCone = 30f;
            rotateSpeed = 5f;
            targetGround = true;
            targetAir = true;
            shootEffect = Fx.lightningShoot;
            shootSound = Sounds.spark;

            consumeCoolant(0.2f);
            consumePower(8f);

            shoot.shots = 5;
            shootType = new LightningBulletType(){{
                damage = 20f;
                lightningLength = 30;
                collidesAir = true;
                ammoMultiplier = 1f;
                status = StatusEffects.shocked;
                hittable = false;
                buildingDamageMultiplier = 0.25f;
                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = 500f;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = StatusEffects.shocked;
                    hittable = false;
                    lightColor = Color.white;
                    collidesAir = true;
                    buildingDamageMultiplier = 0.25f;
                }};
            }};
        }};
        disrupt = new ItemTurret("disrupt"){{
            requirements(Category.turret, with(Items.lead, 250, Items.graphite, 185, Items.titanium, 210, Items.surgeAlloy, 125));
            range = 350f;
            recoil = 6f;
            reload = 60f;
            shake = 2f;
            size = 4;
            targetGround = true;
            targetAir = false;
            shoot.shots = 5;
            shootCone = 35f;
            inaccuracy = 12f;
            shootSound = Sounds.artillery;

            consumeCoolant(0.5f);

            ammo(
                    Items.silicon, new ArtilleryBulletType(4f, 15){{
                        lifetime = 100f;
                        width = height = 15f;
                        collidesTiles = false;
                        splashDamage = 40f;
                        splashDamageRadius = 20;
                        homingRange = 50f;
                        homingPower = 0.08f;

                        trailLength = 9;
                        trailWidth = 3.1f;
                        frontColor = Color.valueOf("999ba0");
                        backColor = trailColor = hitColor = Color.valueOf("707594");
                        hitEffect = Fx.hitBulletColor;
                    }},
                    Items.pyratite, new ArtilleryBulletType(3f, 13){{
                        lifetime = 100f;
                        width = height = 15f;
                        collidesTiles = false;
                        splashDamage = 50f;
                        splashDamageRadius = 20f;
                        makeFire = true;
                        ammoMultiplier = 4f;
                        status = StatusEffects.burning;
                        statusDuration = 1440;

                        frontColor = Pal.lightishOrange;
                        backColor = hitColor = Pal.lightOrange;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }},
                    Items.blastCompound, new ArtilleryBulletType(3f, 15){{
                        lifetime = 100f;
                        width = height = 16f;
                        collidesTiles = false;
                        splashDamage = 65f;
                        splashDamageRadius = 25f;
                        ammoMultiplier = 4f;
                        status = StatusEffects.blasted;

                        frontColor = Color.valueOf("eeab89");
                        backColor = trailColor = hitColor = Color.valueOf("e9665b");
                        hitEffect = despawnEffect = Fx.blastExplosion;
                    }},
                    Items.plastanium, new ArtilleryBulletType(3f, 12){{
                        lifetime = 100f;
                        width = height = 15f;
                        collidesTiles = false;
                        splashDamage = 25f;
                        splashDamageRadius = 15f;
                        fragBullets = 3;

                        frontColor = Pal.plastaniumFront;
                        backColor = trailColor = hitColor = Pal.plastaniumBack;
                        hitEffect = despawnEffect = Fx.plasticExplosion;

                        fragBullet = new BasicBulletType(3f, 10, "bullet"){{
                            lifetime = 15;
                            width = height = 10f;
                            splashDamage = 15f;
                            splashDamageRadius = 10f;

                            frontColor = Pal.plastaniumFront;
                            backColor = Pal.plastaniumBack;
                            hitEffect = despawnEffect = Fx.plasticExplosion;
                        }};
                    }},
                    AepherasItems.voltalite, new ArtilleryBulletType(3f, 20){{
                        lifetime = 100f;
                        width = height = 16f;
                        collidesTiles = false;
                        splashDamage = 85f;
                        splashDamageRadius = 20f;
                        status = StatusEffects.shocked;
                        lightning = 4;
                        lightningLength = 10;
                        lightningDamage = 20f;
                        ammoMultiplier = 5f;

                        frontColor = Color.white;
                        backColor = Pal.surge;
                        hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, Fx.lightningShoot, Fx.lightningCharge);
                    }},
                    AepherasItems.nuclearCompound, new ArtilleryBulletType(3f, 30){{
                        lifetime = 100f;
                        width = height = 16f;
                        collidesTiles = false;
                        splashDamage = 110f;
                        splashDamageRadius = 50f;
                        status = StatusEffects.blasted;
                        ammoMultiplier = 6f;

                        frontColor = Color.white;
                        backColor = Pal.thoriumPink;
                        hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, Fx.massiveExplosion);
                    }}
            );
        }};
        hive = new ItemTurret("hive"){{
            requirements(Category.turret, with(Items.lead, 750, Items.graphite, 430, Items.silicon, 350, Items.plastanium, 230, Items.surgeAlloy, 110, Items.thorium, 250));
            size = 3;
            range = 300f;
            targetGround = false;
            targetAir = true;
            reload = 30f;
            recoil = 2f;
            shake = 1f;
            shootCone = 35f;
            inaccuracy = 17f;
            shootSound = Sounds.artillery;

            consumeCoolant(0.5f);

            ammo(
                    Items.pyratite, new ArtilleryBulletType(3f, 10){{
                        lifetime = 50f;
                        width = height = 14f;
                        collidesGround = collidesTiles = false;
                        fragBullets = 3;
                        status = StatusEffects.burning;
                        statusDuration = 900f;
                        makeFire = true;
                        splashDamage = 55f;
                        splashDamageRadius = 30f;

                        frontColor = Pal.lightishOrange;
                        backColor = hitColor = Pal.lightOrange;
                        trailEffect = Fx.incendTrail;
                        hitEffect = despawnEffect = Fx.hitBulletColor;

                        fragBullet = new BasicBulletType(6, 15){{
                            lifetime = 100;
                            homingRange = 100f;
                            homingPower = 0.08f;
                            splashDamage = 25f;
                            splashDamageRadius = 25f;
                            collidesAir = true;
                            collidesGround = collidesTiles = false;
                            makeFire = true;
                            trailEffect = Fx.incendTrail;
                            status = StatusEffects.burning;
                            statusDuration = 900f;

                            frontColor = Pal.lightishOrange;
                            backColor = hitColor = Pal.lightOrange;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }},
                    Items.blastCompound, new ArtilleryBulletType(3f, 20){{
                        lifetime = 50f;
                        width = height = 15f;
                        collidesGround = collidesTiles = false;
                        fragBullets = 3;
                        status = StatusEffects.blasted;
                        splashDamage = 55f;
                        splashDamageRadius = 65f;

                        frontColor = Color.valueOf("eeab89");
                        backColor = trailColor = hitColor = Color.valueOf("e9665b");
                        hitEffect = despawnEffect = Fx.blastExplosion;

                        fragBullet = new BasicBulletType(6, 17){{
                            lifetime = 100;
                            homingRange = 100f;
                            homingPower = 0.08f;
                            splashDamage = 30f;
                            splashDamageRadius = 35f;
                            collidesAir = true;
                            collidesGround = collidesTiles = false;
                            status = StatusEffects.blasted;

                            frontColor = Color.valueOf("eeab89");
                            backColor = hitColor = Color.valueOf("e9665b");
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }},
                    Items.plastanium, new ArtilleryBulletType(3f, 13){{
                        lifetime = 50f;
                        width = height = 14f;
                        collidesGround = collidesTiles = false;
                        fragBullets = 10;
                        splashDamage = 40f;
                        splashDamageRadius = 30f;

                        frontColor = Pal.plastaniumFront;
                        backColor = trailColor = hitColor = Pal.plastaniumBack;
                        hitEffect = despawnEffect = Fx.plasticExplosion;

                        fragBullet = new BasicBulletType(6, 17){{
                            lifetime = 100;
                            homingRange = 100f;
                            homingPower = 0.08f;
                            splashDamage = 20f;
                            splashDamageRadius = 25f;
                            collidesAir = true;
                            collidesGround = collidesTiles = false;

                            frontColor = Pal.plastaniumFront;
                            backColor = hitColor = Pal.plastaniumBack;
                            hitEffect = despawnEffect = Fx.plasticExplosion;
                        }};
                    }},
                    AepherasItems.voltalite, new ArtilleryBulletType(3f, 25){{
                        lifetime = 50f;
                        width = height = 15f;
                        collidesGround = collidesTiles = false;
                        fragBullets = 3;
                        status = StatusEffects.shocked;
                        splashDamage = 85f;
                        splashDamageRadius = 45f;

                        lightning = 4;
                        lightningLength = 7;
                        lightningDamage = 30f;

                        frontColor = Color.white;
                        backColor = trailColor = hitColor = Pal.surge;
                        hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, Fx.titanExplosion);

                        fragBullet = new BasicBulletType(6, 18){{
                            lifetime = 100;
                            homingRange = 100f;
                            homingPower = 0.08f;
                            splashDamage = 40f;
                            splashDamageRadius = 40f;
                            collidesAir = true;
                            collidesGround = collidesTiles = false;
                            status = StatusEffects.shocked;

                            lightning = 2;
                            lightningLength = 4;
                            lightningDamage = 20f;

                            frontColor = Color.white;
                            backColor = hitColor = Pal.surge;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }},
                    AepherasItems.nuclearCompound, new ArtilleryBulletType(3f, 30){{
                        lifetime = 50f;
                        width = height = 16f;
                        collidesGround = collidesTiles = false;
                        fragBullets = 3;
                        status = StatusEffects.blasted;
                        splashDamage = 100f;
                        splashDamageRadius = 75f;

                        frontColor = Color.white;
                        backColor = trailColor = hitColor = Pal.thoriumPink;
                        hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, Fx.massiveExplosion);

                        fragBullet = new BasicBulletType(6, 20){{
                            lifetime = 100;
                            homingRange = 100f;
                            homingPower = 0.08f;
                            splashDamage = 50f;
                            splashDamageRadius = 45f;
                            collidesAir = true;
                            collidesGround = collidesTiles = false;
                            status = StatusEffects.blasted;

                            frontColor = Color.white;
                            backColor = hitColor = Pal.thoriumPink;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }}
            );
        }};
        //turrets - Cyneris
        bract = new ItemTurret("bract"){{
            requirements(Category.turret, with(AepherasItems.aluminum, 30, AepherasItems.ferrite, 10));
            ammo(
                    AepherasItems.aluminum, new BasicBulletType(2.5f, 9){{
                        width = 7f;
                        height = 9f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        frontColor = AEPal.aluminumAmmoFront;
                        backColor = AEPal.aluminumAmmoBack;
                    }},
                    AepherasItems.ferrite, new BasicBulletType(2f, 9){{
                        width = 7f;
                        height = 9f;
                        lifetime = 75f;
                        ammoMultiplier = 2;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        frontColor = AEPal.ferriteAmmoFront;
                        backColor = AEPal.ferriteAmmoBack;
                    }},
                    AepherasItems.vanadium, new BasicBulletType(3f, 15){{
                        width = 7f;
                        height = 9f;
                        lifetime = 50f;
                        ammoMultiplier = 1;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        frontColor = AEPal.vanadiumAmmoFront;
                        backColor = AEPal.vanadiumAmmoBack;
                    }},
                    AepherasItems.graphene, new BasicBulletType(2.5f, 9){{
                        width = 6f;
                        height = 8f;
                        lifetime = 60f;
                        ammoMultiplier = 4;
                        reloadMultiplier = 2/3f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        frontColor = AEPal.grapheneAmmoFront;
                        backColor = AEPal.grapheneAmmoBack;
                        homingPower = 0.08f;
                        homingRange = 50f;
                    }}
            );
            recoil = 0.5f;
            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-barrel"){{
                    progress = PartProgress.recoil;
                    recoilIndex = 0;
                    under = true;
                    moveY = -1.5f;
                }});
            }};
            shootY = 3f;
            reload = 20f;
            range = 160;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            limitRange(5f);
        }};

        gale = new ItemTurret("gale"){{
            requirements(Category.turret, with(AepherasItems.aluminum, 75, AepherasItems.ferrite, 60));
            ammo(
                    AepherasItems.ferrite, new FlakBulletType(5f, 2){{
                        lifetime = 48f;
                        ammoMultiplier = 3f;
                        shootEffect = Fx.shootSmall;
                        width = 6f;
                        height = 8f;
                        hitEffect = Fx.blastExplosion;
                        splashDamage = 10f;
                        splashDamageRadius = 30f;

                        frontColor = AEPal.ferriteAmmoFront;
                        backColor = AEPal.ferriteAmmoBack;
                        despawnEffect = Fx.hitBulletColor;

                    }},
                    AepherasItems.vanadium, new FlakBulletType(6f, 3){{
                        lifetime = 40f;
                        ammoMultiplier = 3f;
                        shootEffect = Fx.shootSmall;
                        width = 5f;
                        height = 9f;
                        hitEffect = Fx.blastExplosion;
                        splashDamage = 15f;
                        splashDamageRadius = 25f;

                        frontColor = AEPal.vanadiumAmmoFront;
                        backColor = AEPal.vanadiumAmmoBack;
                        despawnEffect = Fx.hitBulletColor;

                    }},
                    AepherasItems.sapphire, new FlakBulletType(5f, 5){{
                        lifetime = 48f;
                        ammoMultiplier = 5f;
                        shootEffect = Fx.shootSmall;
                        width = 6.5f;
                        height = 8.5f;
                        hitEffect = Fx.blastExplosion;
                        splashDamage = 20f;
                        splashDamageRadius = 35f;

                        frontColor = AEPal.sapphireAmmoFront;
                        backColor = AEPal.sapphireAmmoBack;
                        despawnEffect = Fx.hitBulletColor;

                        fragBullets = 6;
                        fragBullet = new BasicBulletType(3f, 1){{
                            width = 5f;
                            height = 12f;
                            shrinkY = 1f;
                            lifetime = 20f;
                            backColor = trailColor = AEPal.sapphireAmmoBack;
                            hitColor = frontColor = AEPal.sapphireAmmoFront;
                            despawnEffect = Fx.none;
                            collidesGround = false;
                        }};

                    }}
            );
            drawer = new DrawTurret(){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = false;
                        moveY = -2.5f;
                    }});
                }
            }};

            reload = 9f;
            range = 220f;
            size = 2;
            targetGround = false;

            shoot = new ShootAlternate(12f);
            shootY = 0f;
            shoot.shotDelay = 5f;
            shoot.shots = 4;

            recoil = 1f;
            rotateSpeed = 15f;
            inaccuracy = 8f;
            shootCone = 20f;

            scaledHealth = 150;
            shootSound = Sounds.shootSnap;
            coolant = consumeCoolant(0.2f);
            researchCostMultiplier = 0.05f;

        }};

        //units
        repairSpire = new RepairTurret("repair-spire"){{
            requirements(Category.units, with(Items.plastanium, 120, Items.silicon, 130, Items.thorium, 180, Items.surgeAlloy, 80, Items.phaseFabric, 35));
            size = 3;
            repairSpeed = 12f;
            repairRadius = 200f;
            length = 8.25f;
            powerUse = 12f;
            beamWidth = 1.5f;
            pulseRadius = 8f;
            coolantUse = 0.3f;
            coolantMultiplier = 2.5f;
            acceptCoolant = true;
        }};

        // payloads

        payloadConveyorLarge = new PayloadConveyor("payload-conveyor-large"){{
            requirements(Category.units, with(Items.copper, 25, Items.graphite, 25, Items.silicon, 25));
            size = 5;
            payloadLimit = 5f;
            canOverdrive = false;
        }};

        payloadRouterLarge = new PayloadRouter("payload-router-large"){{
            requirements(Category.units, with(Items.copper, 25, Items.graphite, 35, Items.silicon, 15));
            size = 5;
            payloadLimit = 5f;
            canOverdrive = false;
        }};

        //payloads - Cyneris

        mechanicalPayloadConveyor = new PayloadConveyor("mechanical-payload-conveyor"){{
            requirements(Category.units, with(AepherasItems.aluminum, 1));
            size = 1;
            payloadLimit = 1;
            moveTime = 20f;
        }};

        mechanicalPayloadConveyorLarge = new PayloadConveyor("mechanical-payload-conveyor-large"){{
            requirements(Category.units, with(AepherasItems.aluminum, 10, AepherasItems.graphene, 5));
            size = 2;
            payloadLimit = 2;
            moveTime = 20f;
        }};

        mechanicalPayloadConveyor = new PayloadConveyor("mechanical-payload-conveyor-huge"){{
            requirements(Category.units, with(AepherasItems.aluminum, 15, AepherasItems.graphene, 10, AepherasItems.steel, 5));
            size = 3;
            payloadLimit = 3;
            moveTime = 20f;
        }};

        mechanicalPayloadRouter = new PayloadRouter("mechanical-payload-router"){{
            requirements(Category.units, with(AepherasItems.aluminum, 2));
            size = 1;
            payloadLimit = 1;
            moveTime = 20f;
        }};

        mechanicalPayloadRouterLarge = new PayloadRouter("mechanical-payload-router-large"){{
            requirements(Category.units, with(AepherasItems.aluminum, 12, AepherasItems.graphene, 10));
            size = 2;
            payloadLimit = 2;
            moveTime = 20f;
        }};

        mechanicalPayloadRouterHuge = new PayloadRouter("mechanical-payload-router-huge"){{
            requirements(Category.units, with(AepherasItems.aluminum, 18, AepherasItems.graphene, 15, AepherasItems.steel, 8));
            size = 3;
            payloadLimit = 3;
            moveTime = 20f;
        }};



        serpuloBlocks.addAll(Blocks.duo, Blocks.scatter, Blocks.scorch, Blocks.hail, Blocks.wave, Blocks.lancer, Blocks.arc, Blocks.parallax, Blocks.swarmer, Blocks.salvo, Blocks.segment, Blocks.tsunami, Blocks.fuse, Blocks.cyclone, Blocks.foreshadow, Blocks.spectre, Blocks.ripple, Blocks.meltdown, Blocks.mechanicalDrill, Blocks.pneumaticDrill, Blocks.laserDrill, Blocks.blastDrill, Blocks.waterExtractor, Blocks.cultivator, Blocks.oilExtractor, Blocks.conveyor, Blocks.titaniumConveyor, Blocks.plastaniumConveyor, Blocks.armoredConveyor, Blocks.junction, Blocks.itemBridge, Blocks.phaseConduit, Blocks.sorter, Blocks.invertedSorter, Blocks.router, Blocks.distributor, Blocks.overflowDuct, Blocks.underflowGate, Blocks.massDriver, Blocks.mechanicalPump, Blocks.rotaryPump, Blocks.impulsePump, Blocks.conduit, Blocks.pulseConduit, Blocks.platedConduit, Blocks.liquidRouter, Blocks.liquidContainer, Blocks.liquidTank, Blocks.liquidJunction, Blocks.bridgeConduit, Blocks.phaseConduit, Blocks.powerNode, Blocks.powerNodeLarge, Blocks.surgeTower, Blocks.battery, Blocks.batteryLarge, Blocks.diode, Blocks.combustionGenerator, Blocks.thermalGenerator, Blocks.steamGenerator, Blocks.differentialGenerator, Blocks.rtgGenerator, Blocks.solarPanel, Blocks.largeSolarPanel, Blocks.thoriumReactor, Blocks.impactReactor, Blocks.copperWall, Blocks.copperWallLarge, Blocks.titaniumWall, Blocks.titaniumWallLarge, Blocks.plastaniumWall, Blocks.plastaniumWallLarge, Blocks.thoriumWall, Blocks.thoriumWallLarge, Blocks.phaseWall, Blocks.phaseWallLarge, Blocks.surgeWall, Blocks.surgeWallLarge, Blocks.scrapWall, Blocks.scrapWallLarge, Blocks.scrapWallHuge, Blocks.scrapWallGigantic, Blocks.door, Blocks.doorLarge, Blocks.thruster, Blocks.graphitePress, Blocks.multiPress, Blocks.siliconSmelter, Blocks.siliconCrucible, Blocks.kiln, Blocks.plastaniumCompressor, Blocks.phaseWeaver, Blocks.surgeSmelter, Blocks.cryofluidMixer, Blocks.pyratiteMixer, Blocks.blastMixer, Blocks.melter, Blocks.separator, Blocks.disassembler, Blocks.coalCentrifuge, Blocks.sporePress, Blocks.pulverizer, Blocks.incinerator, Blocks.groundFactory, Blocks.airFactory, Blocks.navalFactory, Blocks.additiveReconstructor, Blocks.multiplicativeReconstructor, Blocks.exponentialReconstructor, Blocks.tetrativeReconstructor, Blocks.payloadConveyor, Blocks.payloadRouter, Blocks.repairPoint, Blocks.repairTurret, Blocks.mender, Blocks.mendProjector, Blocks.overdriveProjector, Blocks.overdriveDome, Blocks.forceProjector, Blocks.coreShard, Blocks.coreFoundation, Blocks.coreNucleus, Blocks.launchPad, Blocks.interplanetaryAccelerator, Blocks.shockMine, Blocks.container, Blocks.vault, Blocks.unloader, Blocks.message, Blocks.switchBlock, Blocks.microProcessor, Blocks.logicProcessor, Blocks.hyperProcessor, Blocks.memoryBank, Blocks.memoryCell, Blocks.logicDisplay, Blocks.largeLogicDisplay, discharge, disrupt, hive, hydrator, mycoformer, titansteelConveyor, advancedPowerNode, voltaliteReactor, nuclearReactor, venusReactor, copperWallHuge, copperWallGigantic, titaniumWallHuge, titaniumWallGigantic, plastaniumWallHuge, plastaniumWallGigantic, thoriumWallHuge, thoriumWallGigantic, phaseWallHuge, phaseWallGigantic, surgeWallHuge, surgeWallGigantic, forceWall,forceWallLarge, forceWallHuge, forceWallGigantic, titansteelWall, titansteelWallLarge, titansteelWallHuge, titaniumWallGigantic, advancedPlastaniumCompressor, pyratiteCatalyzer, blastCatalyzer, voltaliteMixer, nuclearMixer, voltaliteCatalyzer, nuclearCatalyzer, cokingOven, cokingBlaster, cryofluidCatalyzer, graphiteBlaster, siliconKiln, metaglassCrucible, metaglassBlaster, multiCentrifuge, phaseLoom, sifter, sporeMultipress, surgeSmeltery, titanSmelter, titanCrucible, payloadConveyorLarge, payloadRouterLarge, mendDome, overdriver, mendArray, forceDome, overdriveArray, coreApex, receptacle);
        erekirBlocks.addAll(Blocks.breach, Blocks.diffuse, Blocks.sublimate, Blocks.titan, Blocks.disperse, Blocks.afflict, Blocks.lustre, Blocks.scathe, Blocks.malign, Blocks.ventCondenser, Blocks.cliffCrusher, Blocks.plasmaBore, Blocks.largePlasmaBore, Blocks.impactDrill, Blocks.eruptionDrill, Blocks.duct, Blocks.ductBridge, Blocks.ductRouter, Blocks.ductUnloader, Blocks.armoredDuct, Blocks.overflowDuct, Blocks.underflowDuct, Blocks.surgeConveyor, Blocks.surgeRouter, Blocks.unitCargoLoader, Blocks.unitCargoUnloadPoint, Blocks.reinforcedPump, Blocks.reinforcedConduit, Blocks.reinforcedLiquidRouter, Blocks.reinforcedBridgeConduit, Blocks.reinforcedLiquidRouter, Blocks.reinforcedLiquidTank, Blocks.reinforcedLiquidContainer, Blocks.beamNode, Blocks.beamLink, Blocks.beamTower, Blocks.turbineCondenser, Blocks.chemicalCombustionChamber, Blocks.pyrolysisGenerator, Blocks.fluxReactor, Blocks.neoplasiaReactor, Blocks.berylliumWall, Blocks.berylliumWallLarge, Blocks.tungstenWall, Blocks.tungstenWallLarge, Blocks.blastDoor, Blocks.carbideWallLarge, Blocks.carbideWall, Blocks.shieldedWall, Blocks.reinforcedSurgeWall, Blocks.reinforcedSurgeWallLarge, Blocks.siliconArcFurnace, Blocks.electrolyzer, Blocks.atmosphericConcentrator, Blocks.oxidationChamber, Blocks.electricHeater, Blocks.slagHeater, Blocks.phaseHeater, Blocks.heatRedirector, Blocks.heatRouter, Blocks.slagIncinerator, Blocks.carbideCrucible, Blocks.surgeCrucible, Blocks.cyanogenSynthesizer, Blocks.phaseSynthesizer, Blocks.heatSource, Blocks.tankAssembler, Blocks.shipAssembler, Blocks.mechAssembler, Blocks.tankFabricator, Blocks.shipFabricator, Blocks.mechFabricator, Blocks.basicAssemblerModule, Blocks.unitRepairTower, Blocks.reinforcedPayloadConveyor, Blocks.reinforcedPayloadRouter, Blocks.payloadMassDriver, Blocks.largePayloadMassDriver, Blocks.deconstructor, Blocks.smallDeconstructor, Blocks.constructor, Blocks.largeConstructor, Blocks.payloadLoader, Blocks.payloadUnloader, Blocks.radar, radarLarge, Blocks.buildTower, Blocks.regenProjector, Blocks.shockwaveTower, Blocks.shieldProjector, Blocks.shieldBreaker, Blocks.largeShieldProjector, Blocks.coreBastion, Blocks.coreCitadel, Blocks.coreAcropolis, Blocks.reinforcedContainer, Blocks.reinforcedVault, Blocks.canvas, Blocks.reinforcedMessage, Blocks.worldCell, Blocks.worldProcessor, Blocks.worldMessage, Blocks.beamLink, Blocks.heatSource, Blocks.shieldProjector, Blocks.largeShieldProjector);
        cynerisBlocks.addAll(carbonScrubber, strataDriver, primeDriver, insulatedConduit, insulatedLiquidRouter, insulatedLiquidJunction, insulatedLiquidBridge, primeConduit, shieldedConduit, linkNode, linkNodeLarge, carbyteCondensor, sapphireCrystallizer, grapheneSynthesizer, coreCodex, coreAnima, mechanicalPayloadConveyor, mechanicalPayloadConveyorLarge, mechanicalPayloadConveyorHuge, mechanicalPayloadRouter, mechanicalPayloadRouterLarge, mechanicalPayloadConveyorHuge, mechanicalConstructor, mechanicalConstructorLarge, mechanicalConstructorHuge, mechanicalDeconstructor, mechanicalDeconstructorLarge, mechanicalDeconstructorHuge);
    }


}