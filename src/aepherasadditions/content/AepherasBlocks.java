package aepherasadditions.content;

import aepherasadditions.world.draw.DrawVenusPlasma;
import arc.graphics.Color;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.ConstructBlock;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadRouter;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;
import org.w3c.dom.Attr;

import static mindustry.type.ItemStack.with;

public class AepherasBlocks {

    public static Block

            //environment

            //boulders

            //ores

            //wall ores

            //crafting
            advancedPlastaniumCompressor, blastCatalyzer, cokingBlaster, cokingOven, cryofluidCatalyzer, graphiteBlaster, metaglassBlaster, metaglassCrucible, multiCentrifuge, nuclearCatalyzer, nuclearMixer, phaseLoom, pyratiteCatalyzer, sifter, siliconKiln, sporeMultipress, surgeSmeltery, titanCrucible, titanSmelter, voltaliteCatalyzer, voltaliteMixer,

            //crafting-erekir

            //sandbox

            //walls
            copperWallHuge, copperWallGigantic, titaniumWallHuge, titaniumWallGigantic, plastaniumWallHuge, plastaniumWallGigantic, thoriumWallHuge, thoriumWallGigantic, phaseWallHuge, phaseWallGigantic, surgeWallHuge, surgeWallGigantic, forceWall, forceWallLarge, forceWallHuge, forceWallGigantic, titansteelWall, titansteelWallLarge, titansteelWallHuge, titansteelWallGigantic,


            //walls - erekir

            //defense
            overdriver, mendDome, mendArray, overdriveArray, forceDome,

            //defense - erekir

            //campaign only

            //transport
            titansteelConveyor,

            //transport - alternate

            //liquid

            //liquid - reinforced

            //power
            advancedPowerNode, voltaliteReactor, nuclearReactor, venusReactor,

            //power - erekir

            //production
            hydrator, mycoformer,

            //storage
            coreApex, receptacle,

            //storage - erekir

            //turrets
            discharge, disrupt, hive,


            //turrets - erekir

            //units

            //payloads
            payloadConveyorLarge, payloadRouterLarge


            //logic

            //campaign

            ;

    public static void load(){
        for(int i = 1; i <= Vars.maxBlockSize; i++){
            new ConstructBlock(i);
        }

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

        // walls

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

        //transportation

        titansteelConveyor = new StackConveyor("titansteel-conveyor"){{
            requirements(Category.distribution, with(AepherasItems.titansteel, 2, Items.plastanium, 2, Items.thorium, 2));
            health = 345;
            speed = 0.1f;
            itemCapacity = 25;
        }};

        //power

        advancedPowerNode = new PowerNode("advanced-power-node"){{
            requirements(Category.power, with(Items.lead, 30, Items.titanium, 20, Items.silicon, 45, Items.surgeAlloy, 15, Items.phaseFabric, 20));
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

        // storage

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
    }


}