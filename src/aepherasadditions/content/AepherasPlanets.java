package aepherasadditions.content;

import aepherasadditions.maps.planets.CynerisPlanetGenerator;
import aepherasadditions.maps.planets.MercuryPlanetGenerator;
import aepherasadditions.maps.planets.ProximaCPlanetGenerator;
import aepherasadditions.world.mesh.RingMesh;
import arc.func.Cons;
import arc.graphics.Color;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.meta.Env;

import java.io.IOException;
import java.util.concurrent.Phaser;

import static arc.struct.ObjectSet.with;

public class AepherasPlanets {
    public static Planet
    cyneris, elaris,

    alphaCentauri,
            centauriA,
            centauriB,
            proximaCentauri,
                proximaD,
                proximaB,
                proximaC, cI, cII, cIII,

    tauCeti, cetiB, cetiC, cetiD, cetiE, cetiF,

    caudora, crimor, deimor,
            orianu, ori,
            rtascina, titusta, ubonas,
            iberci, rinasci,
            torsat, quelluta, ditascury, turasc,

    sol, mercury, venus,
            earth,
            mars, phobos, deimos,
            jupiter, ganymede, callisto, io, europa,
            saturn, mimas, enceladus, tethys, dione, rhea, titan, iapetus,
            caelus, miranda, ariel, umbriel, titania, oberon,
            neptune, triton
     ;


    public static void load() throws IOException {
        cyneris = new Planet("cyneris", Planets.sun, 1f, 1){{
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.techBlue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.techBlue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            allowLaunchToNumbered = false;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.hideBannedBlocks = true;
                r.waveTeam = Team.blue;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
                r.blockWhitelist = true;
                r.bannedBlocks.addAll(AepherasBlocks.serpuloBlocks);
                r.bannedBlocks.addAll(AepherasBlocks.erekirBlocks);
                r.fog = false;
                r.cleanupDeadTeams = true;
                r.coreIncinerates = true;
                r.planet = AepherasPlanets.cyneris;

            };
            iconColor = Pal.techBlue;
            atmosphereColor = Color.white;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 10;
            alwaysUnlocked = true;
            landCloudColor = Pal.techBlue.cpy().a(0.5f);
            defaultCore = AepherasBlocks.coreEcho;
            hiddenItems.addAll(AepherasItems.serpuloItemsKey);
            hiddenItems.addAll(AepherasItems.erekirItemsKey);
            hiddenItems.removeAll(AepherasItems.cynerisItemsKey);
            itemWhitelist = AepherasItems.cynerisItemsKey;

        }};

        elaris = new Planet("elaris", cyneris, 0.25f, 2 ){{
            accessible = false;
            generator = new CynerisPlanetGenerator();
            hasAtmosphere = false;
            orbitRadius = 4f;
            orbitTime = 0.001f;
            bloom = false;
        }};

        alphaCentauri = new Planet("alpha-centauri", null, 0.0001f){{
            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ff7a38"),
                    Color.valueOf("ff9638"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffe371"),
                    Color.valueOf("f4ee8e")
            );
            accessible = false;
        }};

        centauriA = new Planet("centauri-a", alphaCentauri, 5f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ff7a38"),
                    Color.valueOf("ff9638"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffe371"),
                    Color.valueOf("f4ee8e")
            );
            orbitRadius = 10f;
        }};

        centauriB = new Planet("centauri-b", alphaCentauri, 4f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("d9643b"),
                    Color.valueOf("e07b4f"),
                    Color.valueOf("e7a366"),
                    Color.valueOf("e7a366"),
                    Color.valueOf("f0bf7e"),
                    Color.valueOf("f5dba1")
            );
            orbitRadius = 30f;

        }};

        proximaCentauri = new Planet("proxima-centauri", alphaCentauri, 3f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("a63636"),
                    Color.valueOf("be4a4a"),
                    Color.valueOf("d56363"),
                    Color.valueOf("d56363"),
                    Color.valueOf("e89292"),
                    Color.valueOf("f2baba")
            );
            orbitRadius = 90f;
        }};

        proximaD = new Planet("proxima-d", proximaCentauri, 0.85f, 2){{
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.techBlue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.techBlue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            iconColor = Pal.redDust;
            startSector = 170;
            alwaysUnlocked = true;
            orbitRadius = 7.5f;
        }};

        proximaB = new Planet("proxima-b", proximaCentauri, 0.75f, 2){{
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.techBlue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.techBlue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            atmosphereColor = Color.white;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 170;
            alwaysUnlocked = true;
            landCloudColor = Pal.techBlue.cpy().a(0.5f);
            camRadius = 10f;
            orbitRadius = 15f;
        }};

        proximaC = new Planet("proxima-c", proximaCentauri, 1f, 2){{
            RingMesh rings1 = new RingMesh(2f, 2.6f, this, 0f, Color.valueOf("5a4a3c"), 0f, 0f, 0f, 0.5f);
            RingMesh rings2 = new RingMesh(2.6f, 2.8f, this, 0f, Color.valueOf("a18b78"), 0f, 0f, 0f, 0.5f);
            RingMesh rings3 = new RingMesh(2.8f, 3.6f, this, 0f, Color.valueOf("f7cba4"), 0f, 0f, 0f, 0.5f);
            RingMesh rings4 = new RingMesh(4f, 4.6f, this, 0f, Color.valueOf("d0c0b2"), 0f, 0f, 0f, 0.5f);
            RingMesh rings5 = new RingMesh(4.6f, 4.8f, this, 0f, Color.valueOf("f7cba4"), 0f, 0f, 0f, 0.5f);

            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 6)
            );
            cloudMeshLoader = () -> new MultiMesh(

                    new HexSkyMesh(this, 11, 1.5f, 0.15f, 5, new Color().set(Color.valueOf("f7cba4")).mul(0.9f).a(1f), 2, 0.45f, 0.9f, 0.78f),
                    new HexSkyMesh(this, 10, 1.4f, 0.2f, 5, new Color().set(Color.valueOf("f9d1b0")).mul(0.9f).a(0.95f), 2, 0.45f, 0.9f, 0.76f),
                    new HexSkyMesh(this, 9, 1.3f, 0.25f, 5, new Color().set(Color.valueOf("f3c28f")).mul(0.9f).a(0.9f), 2, 0.45f, 0.9f, 0.74f),
                    new HexSkyMesh(this, 8, 1.2f, 0.3f, 5, new Color().set(Color.valueOf("eecb9e")).mul(0.9f).a(0.85f), 2, 0.45f, 0.9f, 0.72f),
                    new HexSkyMesh(this, 7, 1.1f, 0.35f, 5, new Color().set(Color.valueOf("f7d7b2")).mul(0.9f).a(0.8f), 2, 0.45f, 0.9f, 0.70f),
                    new HexSkyMesh(this, 6, 1.0f, 0.4f, 5, new Color().set(Color.valueOf("f5c695")).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.68f),
                    new HexSkyMesh(this, 5, 0.9f, 0.45f, 5, new Color().set(Color.valueOf("f0b880")).mul(0.9f).a(0.7f), 2, 0.45f, 0.9f, 0.66f),
                    new HexSkyMesh(this, 4, 0.8f, 0.5f, 5, new Color().set(Color.valueOf("f0b880")).mul(0.9f).a(0.65f), 2, 0.45f, 0.9f, 0.64f),
                    new HexSkyMesh(this, 3, 0.7f, 0.55f, 5, new Color().set(Color.valueOf("f4cfa2")).mul(0.9f).a(0.6f), 2, 0.45f, 0.9f, 0.62f),
                    new HexSkyMesh(this, 2, 0.6f, 0.6f, 5, new Color().set(Color.valueOf("f8d4a7")).mul(0.9f).a(0.55f), 2, 0.45f, 0.9f, 0.60f),
                    new HexSkyMesh(this, 1, 0.5f, 0.65f, 5, Color.valueOf("f2bc8a").cpy().lerp(Color.valueOf("f2bc8a"), 0.55f).a(0.75f), 2, 0.45f, 1f, 0.11f),
                    rings1,
                    rings2,
                    rings3,
                    rings4,
                    rings5
                    );
            generator = new ProximaCPlanetGenerator();

            atmosphereColor = Color.valueOf("f7cba4");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            landCloudColor = Color.valueOf("f7cba4").cpy().a(0.5f);
            accessible = false;
            orbitRadius = 35f;
        }};

        cI = new Planet("c-i", proximaC, 0.2f, 2){{
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.techBlue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.techBlue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            iconColor = Pal.redDust;
            startSector = 170;
            alwaysUnlocked = true;
            orbitRadius = 6f;
            camRadius = 0.2f;
            minZoom = 0.2f;

        }};
        cII = new Planet("c-ii", proximaC, 0.4f, 2){{
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Pal.techBlue).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Pal.techBlue, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            iconColor = Pal.redDust;
            startSector = 170;
            alwaysUnlocked = true;
            orbitRadius = 8f;
            camRadius = 0.4f;
            minZoom = 0.4f;

        }};
        cIII = new Planet("c-iii", proximaC, 0.3f, 2){{
            meshLoader = () -> new HexMesh(this, 6);

            generator = new CynerisPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = false;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            iconColor = Pal.redDust;
            startSector = 170;
            alwaysUnlocked = true;
            orbitRadius = 10f;
            camRadius = 0.3f;
            minZoom = 0.3f;
        }};
        sol = new Planet("sol", null, 4f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ff7a38"),
                    Color.valueOf("ff9638"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffe371"),
                    Color.valueOf("f4ee8e")
            );
        }};
        mercury = new Planet("mercury", sol, 0.4f, 1){{
            meshLoader = () -> new HexMesh(this, 6);

            generator = new MercuryPlanetGenerator();

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
                r.coreDestroyClear = true;
            };
            iconColor = Pal.lightishGray;
            startSector = 170;
            alwaysUnlocked = true;
            hasAtmosphere = false;
        }};

        venus = new Planet("venus", sol, 0.85f, 1){{
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 6)
            );
            cloudMeshLoader = () -> new MultiMesh(

                    new HexSkyMesh(this, 11, 1.5f, 0.15f, 5, new Color().set(Color.valueOf("f7cba4")).mul(0.9f).a(1f), 2, 0.45f, 0.9f, 0.78f),
                    new HexSkyMesh(this, 10, 1.4f, 0.2f, 5, new Color().set(Color.valueOf("f9d1b0")).mul(0.9f).a(0.95f), 2, 0.45f, 0.9f, 0.76f),
                    new HexSkyMesh(this, 9, 1.3f, 0.25f, 5, new Color().set(Color.valueOf("f3c28f")).mul(0.9f).a(0.9f), 2, 0.45f, 0.9f, 0.74f),
                    new HexSkyMesh(this, 8, 1.2f, 0.3f, 5, new Color().set(Color.valueOf("eecb9e")).mul(0.9f).a(0.85f), 2, 0.45f, 0.9f, 0.72f),
                    new HexSkyMesh(this, 7, 1.1f, 0.35f, 5, new Color().set(Color.valueOf("f7d7b2")).mul(0.9f).a(0.8f), 2, 0.45f, 0.9f, 0.70f),
                    new HexSkyMesh(this, 6, 1.0f, 0.4f, 5, new Color().set(Color.valueOf("f5c695")).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.68f),
                    new HexSkyMesh(this, 5, 0.9f, 0.45f, 5, new Color().set(Color.valueOf("f0b880")).mul(0.9f).a(0.7f), 2, 0.45f, 0.9f, 0.66f),
                    new HexSkyMesh(this, 4, 0.8f, 0.5f, 5, new Color().set(Color.valueOf("f0b880")).mul(0.9f).a(0.65f), 2, 0.45f, 0.9f, 0.64f),
                    new HexSkyMesh(this, 3, 0.7f, 0.55f, 5, new Color().set(Color.valueOf("f4cfa2")).mul(0.9f).a(0.6f), 2, 0.45f, 0.9f, 0.62f),
                    new HexSkyMesh(this, 2, 0.6f, 0.6f, 5, new Color().set(Color.valueOf("f8d4a7")).mul(0.9f).a(0.55f), 2, 0.45f, 0.9f, 0.60f),
                    new HexSkyMesh(this, 1, 0.5f, 0.65f, 5, Color.valueOf("f2bc8a").cpy().lerp(Color.valueOf("f2bc8a"), 0.55f).a(0.75f), 2, 0.45f, 1f, 0.11f)
            );
            generator = new ProximaCPlanetGenerator();

            atmosphereColor = Color.valueOf("f7cba4");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            landCloudColor = Color.valueOf("f7cba4").cpy().a(0.5f);
            iconColor = Color.valueOf("f7cba4");
            accessible = true;
            alwaysUnlocked = true;
        }};

        earth = new Planet("earth", sol, 0.25f, 1){{
            bloom = true;
            accessible = true;
            alwaysUnlocked = true;
            RingMesh ring1 = new RingMesh(1, 1.25f, this, 0f, Pal.darkishGray, 0f, 0f, -30f, 0.5f);
            RingMesh ring2 = new RingMesh(1f, 1.25f, this, 0f, Pal.darkerGray, 0f, 0f, 30f, 0.5f);

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ff7a38"),
                    Color.valueOf("ff9638"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffc64c"),
                    Color.valueOf("ffe371"),
                    Color.valueOf("f4ee8e")
            );
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("ff7a38");
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0f, 0.75f, 5, new Color().set(Pal.darkerGray).mul(0.9f).a(1f), 2, 0.45f, 0.9f, 0.5f),
                    new HexSkyMesh(this, 12, 0.1f, 0.85f, 6, new Color().set(Pal.darkishGray).mul(0.9f).a(1f), 2, 0.45f, 0.9f, 0.35f),
                    new HexSkyMesh(this, 12, 0.5f, 2f, 6, new Color().set(Pal.stoneGray).mul(0.9f).a(1f), 5, 0.65f, 1f, 0.35f),
                    new HexSkyMesh(this, 13, 0.5f, 2f, 6, new Color().set(Pal.darkishGray).mul(0.9f).a(1f), 5, 0.65f, 1f, 0.35f),
                    new HexSkyMesh(this, 14, 0.5f, 2f, 6, new Color().set(Pal.darkestGray).mul(0.9f).a(1f), 5, 0.65f, 1f, 0.35f),
                    ring1,
                    ring2

            );
            minZoom = 6f;

        }};



        Planets.serpulo.hiddenItems.addAll(AepherasItems.cynerisItemsKey);
        Planets.erekir.hiddenItems.addAll(AepherasItems.cynerisItemsKey);
    }

    private static Planet makeAsteroid(String name, Planet parent, Block base, Block tint, int seed, float tintThresh, int pieces, float scale, Cons<AsteroidGenerator> cgen){
        return new Planet(name, parent, 0.12f){{
            hasAtmosphere = false;
            updateLighting = false;
            sectors.add(new Sector(this, PlanetGrid.Ptile.empty));
            camRadius = 0.68f * scale;
            minZoom = 0.6f;
            drawOrbit = false;
            accessible = false;
            clipRadius = 2f;
            defaultEnv = Env.space;
            icon = "commandRally";
            generator = new AsteroidGenerator();
            cgen.get((AsteroidGenerator)generator);

            meshLoader = () -> {
                iconColor = tint.mapColor;
                Color tinted = tint.mapColor.cpy().a(1f - tint.mapColor.a);
                Seq<GenericMesh> meshes = new Seq<>();
                Color color = base.mapColor;
                Rand rand = new Rand(id + 2);

                meshes.add(new NoiseMesh(
                        this, seed, 2, radius, 2, 0.55f, 0.45f, 14f,
                        color, tinted, 3, 0.6f, 0.38f, tintThresh
                ));

                for(int j = 0; j < pieces; j++){
                    meshes.add(new MatMesh(
                            new NoiseMesh(this, seed + j + 1, 1, 0.022f + rand.random(0.039f) * scale, 2, 0.6f, 0.38f, 20f,
                                    color, tinted, 3, 0.6f, 0.38f, tintThresh),
                            new Mat3D().setToTranslation(Tmp.v31.setToRandomDirection(rand).setLength(rand.random(0.44f, 1.4f) * scale)))
                    );
                }

                return new MultiMesh(meshes.toArray(GenericMesh.class));
            };
        }};
    }
}
