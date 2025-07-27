package aepherasadditions.content;

import aepherasadditions.content.custom.unit.AepheraLegsUnit;
import aepherasadditions.content.custom.unit.AepheraMechUnit;
import aepherasadditions.content.custom.unit.AepheraUnit;
import aepherasadditions.content.custom.unit.AepheraUnitWaterMove;
import arc.graphics.Color;
import mindustry.ai.types.AssemblerAI;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CommandAI;
import mindustry.content.*;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.abilities.ShieldRegenFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.MissileUnitType;
import mindustry.type.weapons.RepairBeamWeapon;
import mindustry.world.meta.Env;

public class AUnitTypes {
    public static UnitType delta;

    public static UnitType gona, dosid, vampyr, enteroct, architeuth;

    public static UnitType regent, sovereign, monarch, empor, dominus;
    public static UnitType phoenix, sagittarius, andromeda, cassiopeia, astralis;
    public static UnitType scytarid, mygalid, silithid, noxarid, maledict;
    public static UnitType corona, umbra, calyx, helios, solstice;
    public static UnitType hexa, deca, dodeca, icosa, tesseract;
    public static UnitType orcinus, leviathan, kraken, hydros, triton;
    public static UnitType glaucus, nembrotha, phyllidia, ondine, nereida;
    public static UnitType node, link, relay, grid, spire, shell, matrix, aegis, vigil, omnis;

    public static UnitType synthesisDrone;


    public static UnitType atta, lasius, formica, eciton, myrmex, dinoponera, titanomyrma;
    public static UnitType drift, veil, tempest, testpest;

    public static UnitType uro, atelo, lycalo, otocyon, cerdocyon;

    public AUnitTypes(){
    }

    public static void load() {
        delta = new UnitType("delta") {{
            constructor = AepheraUnit::new;
            flying = lowAltitude = true;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            mineSpeed = 10f;
            mineTier = 3;
            buildSpeed = 2f;
            drag = 0.05f;
            speed = 3.55f;
            rotateSpeed = 19;
            accel = 0.11f;
            itemCapacity = 90;
            health = 300f;
            engineOffset = 9f;
            hitSize = 13f;
            weapons.add(new Weapon("small-mount-weapon"){{
                top = false;
                alternate = true;
                reload = 15f;
                x = 1f;
                y = 2f;
                shoot.shots = 2;
                shoot.shotDelay = 3f;
                inaccuracy = 3f;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.5f, 15f){{
                    width = 6.5f;
                    height = 11f;
                    lifetime = 70f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                    homingPower = 0.08f;
                }};
            }});
            weapons.add(new Weapon("small-heal-weapon"){{
                top = false;
                alternate = true;
                reload = 45f;
                x = y = 0f;
                shootSound = Sounds.lasershoot;
                shoot.shots = 2;
                shoot.shotDelay = 3;
                inaccuracy = 3f;
                ejectEffect = Fx.none;
                bullet = new LaserBoltBulletType(5f, 13f){{
                    lifetime = 30f;
                    buildingDamageMultiplier = 0.01f;
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Pal.surge;
                    frontColor = Color.white;
                }};
            }});
            abilities.add(new ForceFieldAbility(15f, 1f, 300f, 180f, 16, 0f));
        }};
        node = new UnitType("node"){{
            constructor = AepheraLegsUnit::new;
            health = 150;
            flying = false;
            hovering = true;
            payloadCapacity = 1;
            shadowElevation = 0.1f;
            buildSpeed = 0.3f;
            itemCapacity = 60;
            speed = 0.75f;
            hitSize = 3f;
            researchCostMultiplier = 0.5f;

            legCount = 8;
            legLength = 12f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 4;
            rippleScale = 0.2f;

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                y = 0;
                x = 2;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = true;

                repairSpeed = 0.3f;
                fractionRepairSpeed = 0.03f;

                targetBuildings = targetUnits = autoTarget = true;
                controllable = false;
                laserColor = Pal.heal;
                healColor = Pal.heal;

                bullet = new BulletType(){{
                    maxRange = 65f;
                }};
            }});

            abilities.add(new ForceFieldAbility(25, 1.1f, 350, 120, 6, 0));
        }};

        atta = new UnitType("atta"){{
            constructor = AepheraLegsUnit::new;
            health = 150f;
            flying = false;
            hovering = true;
            shadowElevation = 0.1f;
            buildSpeed = 0.3f;
            itemCapacity = 60;
            speed = 1.5f;
            hitSize = 3f;
            researchCostMultiplier = 0.5f;
            outlineColor = Color.valueOf("18181c");

            legCount = 6;
            legMoveSpace = 1.2f;
            legPairOffset = 3;
            legLength = 15f;
            legExtension = -5f;
            legLengthScl = 0.93f;
            legSpeed = 2f;

            weapons.add(new Weapon("aepherasadditions-atta-weapon"){{
                top = mirror = false;
                reload = 12f;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootY = -2f;
                x = 0f;
                y = 2f;
                shootSound = Sounds.lasershoot;
                bullet = new LaserBoltBulletType(5, 13){{
                    lifetime = 30f;
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.white;
                }};
            }});

            abilities.add(new RepairFieldAbility(10, 240, 60));
        }};

        lasius = new UnitType("lasius"){{
            constructor = AepheraLegsUnit::new;
            health = 350f;
            flying = false;
            hovering = true;
            buildSpeed = 0.5f;
            itemCapacity = 80;
            speed = 1.2f;
            hitSize = 12f;

            legCount = 6;
            legMoveSpace = 1.2f;
            legPairOffset = 3f;
            legLength = 22f;
            legExtension = -5f;
            legBaseOffset = 0f;
            legLengthScl = 0.93f;
            legSpeed = 0.19f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("aepherasadditions-lasius-weapon"){{
                top = false;
                alternate = mirror = true;
                reload = 14f;
                ejectEffect = Fx.none;
                recoil = 2f;
                shootY = -2f;
                x = 7f;
                y = 0f;
                velocityRnd = 0.5f;
                shootSound = Sounds.missile;
                inaccuracy = 15f;
                shoot.shots = 2;
                shoot.shotDelay = 3f;
                bullet = new MissileBulletType(5f, 15){{
                    weaveMag = weaveScale = 4f;
                    lifetime = 60f;
                    homingPower = 0.08f;
                    healPercent = 7f;
                    collidesTeam = true;
                    backColor = trailColor = Pal.heal;
                    frontColor = Color.white;
                    hitEffect = smokeEffect = despawnEffect = Fx.hitLaser;
                    shootEffect = Fx.shootHeal;
                    reflectable = false;
                }};
            }});

            abilities.add(new RepairFieldAbility(15, 480, 120));
            abilities.add(new ShieldRegenFieldAbility(20, 40, 900, 60));
        }};

        formica = new UnitType("formica"){{
            constructor = AepheraLegsUnit::new;
            health = 700f;
            armor = 9f;
            flying = false;
            hovering = true;
            buildSpeed = 1.1f;
            itemCapacity = 120;
            speed = 1f;
            hitSize = 15f;

            legCount = 6;
            legMoveSpace = 1.2f;
            legPairOffset = 3f;
            legLength = 40f;
            legExtension = -8f;
            legBaseOffset = 2f;
            legLengthScl = 0.93f;
            legSpeed = 0.19f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("aepherasadditions-formica-weapon"){{
                top = false;
                alternate = mirror = true;
                reload = 80f;
                ejectEffect = Fx.casing2;
                recoil = 4f;
                shootY = -2f;
                shake = 2f;
                x = 7f;
                y = 0f;
                inaccuracy = 3f;
                shootSound = Sounds.artillery;
                shoot.shotDelay = shoot.shots = 4;
                bullet = new ArtilleryBulletType(5, 10){{
                    lifetime = 130f;
                    knockback = 2f;
                    width = height = 14f;
                    collides = collidesTiles = collidesTeam = true;
                    splashDamage = 20f;
                    splashDamageRadius = 35f;
                    healPercent = 2f;
                    backColor = trailColor = Pal.heal;
                    frontColor = Color.white;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                }};
            }});
            abilities.add(new RepairFieldAbility(15, 120, 60));
            abilities.add(new ShieldRegenFieldAbility(20, 40, 120, 60));
        }};

        eciton = new UnitType("eciton"){{
            constructor = AepheraLegsUnit::new;
            health = 8500f;
            armor = 9f;
            flying = false;
            hovering = true;
            buildSpeed = 3f;
            itemCapacity = 280;
            speed = 0.6f;
            hitSize = 25f;

            legCount = 6;
            legMoveSpace = 1.2f;
            legPairOffset = 3f;
            legLength = 55f;
            legExtension = -12f;
            legBaseOffset = 5f;
            legLengthScl = 0.93f;
            legSpeed = 0.19f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("aepherasadditions-eciton-weapon"){{
                top = false;
                alternate = mirror = true;
                reload = 40f;
                ejectEffect = Fx.casing2;
                recoil = 4f;
                shootY = -2f;
                shake = 2f;
                x = 12f;
                y = 4f;
                inaccuracy = 4f;
                shootSound = Sounds.spark;
                shoot.shots = 2;
                shoot.shotDelay = 1f;
                bullet = new LightningBulletType(){{
                    lifetime = 500f;
                    knockback = 4f;
                    hittable = false;
                    lightningColor = Pal.heal;
                    damage = 100f;
                    lightningLength = 45;
                    healPercent = 5f;
                    collidesTeam = true;
                    hitEffect = Fx.hitLancer;
                }};
            }});
            weapons.add(new Weapon("aepherasadditions-eciton-weapon"){{
                top = false;
                alternate = mirror = true;
                reload = 40f;
                ejectEffect = Fx.casing2;
                recoil = 4f;
                shootY = -2f;
                shake = 2f;
                x = 4f;
                y = 8f;
                inaccuracy = 4f;
                shootSound = Sounds.spark;
                shoot.shots = 2;
                shoot.shotDelay = 1f;
                bullet = new LightningBulletType(){{
                    lifetime = 500f;
                    knockback = 4f;
                    hittable = false;
                    lightningColor = Pal.heal;
                    damage = 100f;
                    lightningLength = 45;
                    healPercent = 5f;
                    collidesTeam = true;
                    hitEffect = Fx.hitLancer;
                }};
            }});
            abilities.add(new RepairFieldAbility(15, 120, 60));
            abilities.add(new ForceFieldAbility(80, 1, 1200, 480, 8, 0));
        }};

        myrmex = new UnitType("myrmex"){{
            constructor = AepheraLegsUnit::new;
            health = 20000;
            armor = 13f;
            flying = false;
            hovering = true;
            itemCapacity = 500;
            speed = 1f;
            hitSize = 28f;
            rotateSpeed = 1.9f;

            legCount = 6;
            legMoveSpace = 1.2f;
            legPairOffset = 3f;
            legLength = 75f;
            legExtension = -8f;
            legBaseOffset = 2f;
            legLengthScl = 0.93f;
            legSpeed = 0.19f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("aepherasadditions-myrmex-weapon"){{
                top = alternate = mirror = rotate = true;
                reload = 30f;
                ejectEffect = Fx.casing2;
                recoil = 6f;
                shootY = 6f;
                shake = 2f;
                rotationLimit = 20f;
                x = 14f;
                y = 0f;
                inaccuracy = 3f;
                shootSound = Sounds.missileLarge;
                shoot.shotDelay = 5;
                shoot.shots = 3;
                bullet = new BulletType(){{
                    shootEffect = Fx.shootHeal;
                    hitColor = Pal.heal;
                    shake = 1f;
                    speed = 0f;
                    keepVelocity = false;
                    spawnUnit = new MissileUnitType("myrmex-missile"){{
                        speed = 5f;
                        maxRange = 5f;
                        health = 100f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineColor = trailColor = Pal.heal;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;
                        collidesTeam = true;
                        healPercent = 7f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(25f, 25){{
                                collidesTeam = true;
                                healPercent = 7f;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.heal;
                                    waveRad = 40f;
                                    smokeSize = 4f;
                                    smokes = 7;
                                    smokeSizeBase = 0f;
                                    sparks = 10;
                                    sparkRad = 40f;
                                    sparkLen = 6f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});
            weapons.add(new Weapon("aepherasadditions-myrmex-missile-launcher"){{
                shootSound = Sounds.missileLarge;
                rotate = true;
                reload = 80f;
                recoil = 1f;
                shootCone = 40f;
                inaccuracy = 5f;
                rotateSpeed = 2.5f;
                x = 0;
                y = -9f;
                mirror = false;
                alternate = true;
                shootY = 15f;
                shoot = new ShootAlternate(3.5f);

                recoils = 2;
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        recoilIndex = f;
                        under = true;
                        moveY = -5.5f;
                        outlineLayerOffset = 5f;
                    }});
                }

                bullet = new BulletType(){{
                    shootEffect = Fx.shootHeal;
                    hitColor = Pal.heal;
                    shake = 1f;
                    speed = 0f;
                    keepVelocity = false;
                    spawnUnit = new MissileUnitType("myrmex-missile-large"){{
                        speed = 5f;
                        maxRange = 6f;
                        health = 100f;
                        lowAltitude = true;
                        engineSize = 6f;
                        engineOffset = 15f;
                        engineColor = trailColor = Pal.heal;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;
                        collidesTeam = true;
                        healPercent = 25f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(350f, 55){{
                                collidesAir = true;
                                collidesTeam = true;
                                healPercent = 7f;
                                fragBullets = 7;
                                fragBullet = new ArtilleryBulletType(2f, 15f){{
                                    width = height = 18;
                                    lifetime = 40;
                                    frontColor = Color.white;
                                    backColor = trailColor = hitColor = Pal.heal;
                                    hitEffect = despawnEffect = Fx.blastExplosion;
                                    trailLength = 15;
                                    collidesTeam = true;
                                    collidesTiles = true;
                                    collidesAir = false;
                                    splashDamageRadius = 25f;
                                    splashDamage = 45f;
                                    healPercent = 10f;
                                    lightning = 2;
                                    lightningLength = 10;
                                    lightningDamage = 10;
                                    lightningColor = Pal.heal;
                                }};
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.heal;
                                    waveRad = 40f;
                                    smokeSize = 4f;
                                    smokes = 7;
                                    smokeSizeBase = 0f;
                                    sparks = 10;
                                    sparkRad = 40f;
                                    sparkLen = 6f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});
            abilities.add(new RepairFieldAbility(15, 120, 120));
            abilities.add(new ForceFieldAbility(100, 1.5f, 3500, 540, 8, 0));
        }};

        drift = new UnitType("drift") {{
            constructor = AepheraUnit::new;
            flying = lowAltitude = true;
            isEnemy = false;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            mineSpeed = 6.5f;
            mineTier = 1;
            buildSpeed = 0.5f;
            drag = 0.05f;
            speed = 3f;
            rotateSpeed = 15;
            accel = 0.1f;
            itemCapacity = 30;
            health = 150f;
            engineOffset = 6f;
            hitSize = 7f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("drift-weapon"){{
                reload = 40f;
                top = mirror = alternate = false;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                x = 0f;

                bullet = new BulletType(){{
                    speed = 0f;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.01f;

                    spawnUnit = new MissileUnitType("drift-missile"){{
                        speed = 3f;
                        maxRange = 3f;
                        health = 25f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineOffset = 3f;
                        engineColor = trailColor = Pal.redLight;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(25f, 20){{
                                collidesAir = true;
                                buildingDamageMultiplier = 0.01f;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.redLight;
                                    waveRad = 15f;
                                    smokeSize = 3f;
                                    smokes = 4;
                                    smokeSizeBase = 0f;
                                    sparks = 3;
                                    sparkRad = 15f;
                                    sparkLen = 4f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});
        }};

        veil = new UnitType("veil"){{
            constructor = AepheraUnit::new;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            isEnemy = false;

            flying = true;
            mineSpeed = 7f;
            mineTier = 1;
            buildSpeed = 0.75f;
            drag = 0.05f;
            speed = 3.3f;
            rotateSpeed = 17f;
            accel = 0.1f;
            fogRadius = 0f;
            itemCapacity = 50;
            health = 170f;
            engineOffset = 6f;
            hitSize = 9f;
            lowAltitude = true;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("veil-weapon"){{
                reload = 20f;
                top = mirror = alternate = false;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                x = 0f;

                bullet = new BulletType(){{
                    speed = 0f;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.01f;

                    spawnUnit = new MissileUnitType("veil-missile"){{
                        speed = 3f;
                        maxRange = 3f;
                        health = 25f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineOffset = 3f;
                        engineColor = trailColor = Pal.redLight;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(25f, 20){{
                                collidesAir = true;
                                buildingDamageMultiplier = 0.01f;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.redLight;
                                    waveRad = 15f;
                                    smokeSize = 3f;
                                    smokes = 4;
                                    smokeSizeBase = 0f;
                                    sparks = 3;
                                    sparkRad = 15f;
                                    sparkLen = 4f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});
        }};

        tempest = new UnitType("tempest"){{
            constructor = AepheraUnit::new;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            isEnemy = false;

            lowAltitude = true;
            flying = true;
            mineSpeed = 8f;
            mineTier = 2;
            buildSpeed = 1f;
            trailColor = Pal.redLight;
            drag = 0.05f;
            speed = 3.55f;
            rotateSpeed = 19f;
            accel = 0.11f;
            fogRadius = 0f;
            itemCapacity = 70;
            health = 220f;
            engineOffset = 6f;
            hitSize = 11f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("tempest-weapon"){{
                reload = 40f;
                top = mirror = alternate = false;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                shoot.shots = 3;
                shoot.shotDelay = 4f;
                x = 0f;

                bullet = new BulletType(){{
                    speed = 0f;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.01f;

                    spawnUnit = new MissileUnitType("tempest-missile"){{
                        speed = 3f;
                        maxRange = 3f;
                        health = 25f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineOffset = 3f;
                        engineColor = trailColor = Pal.redLight;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;

                        abilities.add(new ShieldArcAbility(){{
                            region = "aepherasadditions-tempest-missile-shield";
                            radius = 20f;
                            angle = 70f;
                            regen = 0.75f;
                            cooldown = 120f;
                            max = 250f;
                            y = -20f;
                            width = 3f;
                            whenShooting = false;
                        }});

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(25f, 20){{
                                collidesAir = true;
                                buildingDamageMultiplier = 0.01f;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.redLight;
                                    waveRad = 15f;
                                    smokeSize = 3f;
                                    smokes = 4;
                                    smokeSizeBase = 0f;
                                    sparks = 3;
                                    sparkRad = 15f;
                                    sparkLen = 4f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});
        }};

        testpest = new UnitType("testpest"){{
            constructor = AepheraUnit::new;
            controller = u -> u.team.isAI() ? new BuilderAI(true, 400f) : new CommandAI();
            isEnemy = false;

            lowAltitude = true;
            flying = true;
            mineSpeed = 8f;
            mineTier = 2;
            buildSpeed = 1f;
            trailColor = Pal.redLight;
            drag = 0.05f;
            speed = 3.55f;
            rotateSpeed = 19f;
            accel = 0.11f;
            fogRadius = 0f;
            itemCapacity = 70;
            health = 220f;
            engineOffset = 6f;
            hitSize = 11f;
            outlineColor = Color.valueOf("18181c");

            weapons.add(new Weapon("testpest-weapon"){{
                reload = 40f;
                top = mirror = alternate = false;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.missile;
                x = 0f;
                inaccuracy = 100;
                shoot.shots = 7;

                bullet = new BulletType(){{
                    speed = 0f;
                    keepVelocity = false;
                    buildingDamageMultiplier = 0.01f;

                    spawnUnit = new MissileUnitType("testpest-missile"){{
                        speed = 5f;
                        maxRange = 3f;
                        health = 25f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineOffset = 3f;
                        engineColor = trailColor = Pal.redLight;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(25f, 20){{
                                collidesAir = true;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.redLight;
                                    waveRad = 15f;
                                    smokeSize = 3f;
                                    smokes = 4;
                                    smokeSizeBase = 0f;
                                    sparks = 3;
                                    sparkRad = 15f;
                                    sparkLen = 4f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                        weapons.add(new Weapon("testpest-missile-weapon"){{
                            reload = 10f;
                            alwaysShooting = true;
                            inaccuracy = 50f;
                            shoot.firstShotDelay = 10;
                            shoot.shots = 5;
                            bullet = new BulletType(){{
                                speed = 0f;
                                keepVelocity = false;
                                spawnUnit = new MissileUnitType("testpest-nested-missile"){{
                                    speed = 4f;
                                    maxRange = 3f;
                                    health = 25f;
                                    lowAltitude = true;
                                    lifetime = 3600;
                                    engineSize = 3f;
                                    engineOffset = 3f;
                                    engineColor = trailColor = Pal.redLight;
                                    engineLayer = Layer.effect;
                                    deathExplosionEffect = Fx.none;
                                    loopSoundVolume = 0.1f;

                                    weapons.add(new Weapon(){{
                                        shootCone = 360f;
                                        mirror = false;
                                        reload = 1f;
                                        shootOnDeath = true;
                                        bullet = new ExplosionBulletType(25f, 20){{
                                            collidesAir = true;
                                            fragBullets = 3;
                                            fragBullet = new ArtilleryBulletType(2.5f, 1){{
                                                lifetime = 120;
                                                splashDamageRadius = 100;
                                                splashDamage = 100f;
                                                width = height = 15;
                                            }};
                                            shootEffect = new ExplosionEffect(){{
                                                lifetime = 50f;
                                                waveStroke = 5f;
                                                waveLife = 8f;
                                                waveColor = Color.white;
                                                sparkColor = smokeColor = Pal.redLight;
                                                waveRad = 15f;
                                                smokeSize = 3f;
                                                smokes = 4;
                                                smokeSizeBase = 0f;
                                                sparks = 3;
                                                sparkRad = 15f;
                                                sparkLen = 4f;
                                                sparkStroke = 2f;
                                            }};
                                        }};
                                    }});
                                }};
                            }};
                        }});
                    }};
                }};
            }});
        }};

        gona = new UnitType("gona"){{
            constructor = AepheraUnitWaterMove::new;
            naval = true;
            speed = 1.1f;
            drag = 0.13f;
            hitSize = 11f;
            flying = false;
            health = 300f;
            accel = 0.5f;
            rotateSpeed = 3.3f;
            faceTarget = false;

            armor = 3f;

            weapons.add(new Weapon("aepherasadditions-gona-weapon"){{
                reload = 4f;
                x = 4f;
                shootY = 4f;
                y = 1.5f;
                rotate = true;
                shootSound = Sounds.spray;
                shoot.shots = 2;
                bullet = new LiquidBulletType(Liquids.water){{
                    orbSize = 4f;
                    puddleSize = 8f;
                    knockback = 1.5f;
                    lifetime = 80f;
                    damage = 1f;
                    status = StatusEffects.wet;
                    shootEffect = Fx.shootLiquid;
                    statusDuration = 240f;
                }};
            }});
        }};

        regent = new UnitType("regent"){{
            constructor = AepheraMechUnit::new;
            speed = 0.35f;
            hitSize = 40f;
            rotateSpeed = 1.45f;
            health = 36000;
            armor = 26f;
            mechStepParticles = true;
            stepShake = 1f;
            drownTimeMultiplier = 8f;
            mechFrontSway = 1.9f;
            mechSideSway = 0.6f;
            ammoType = new ItemAmmoType(Items.thorium);

            weapons.add(
                    new Weapon("aepherasadditions-regent-weapon"){{
                        top = false;
                        y = 1f;
                        x = 21.5f;
                        shootY = 11f;
                        reload = 36f;
                        recoil = 7f;
                        shake = 3f;
                        ejectEffect = Fx.casing4;
                        shootSound = Sounds.bang;
                        shoot.shots = 3;
                        shoot.shotDelay = 4;

                        bullet = new BasicBulletType(14f, 120){{
                            pierce = true;
                            pierceCap = 20;
                            width = 16f;
                            height = 45f;
                            lifetime = 15f;
                            shootEffect = Fx.shootBig;
                            fragVelocityMin = 0.8f;

                            hitEffect = Fx.blastExplosion;
                            splashDamage = 26f;
                            splashDamageRadius = 18f;

                            fragBullets = 5;
                            fragLifeMin = 0f;
                            fragRandomSpread = 30f;

                            fragBullet = new BasicBulletType(10f, 25){{
                                width = 12f;
                                height = 12f;
                                pierce = true;
                                pierceBuilding = true;
                                pierceCap = 5;

                                lifetime = 25f;
                                hitEffect = Fx.flakExplosion;
                                splashDamage = 20f;
                                splashDamageRadius = 15f;
                                lightning = 1;
                                lightningLength = 5;
                                lightningDamage = 5;
                            }};
                        }};
                    }}

            );
        }};

        sovereign = new UnitType("sovereign"){{
            constructor = AepheraMechUnit::new;
            speed = 0.25f;
            hitSize = 80f;
            rotateSpeed = 1.25f;
            health = 55000;
            armor = 34f;
            mechStepParticles = true;
            stepShake = 2f;
            drownTimeMultiplier = 12f;
            mechFrontSway = 1.9f;
            mechSideSway = 0.6f;
            ammoType = new ItemAmmoType(Items.surgeAlloy);

            weapons.add(
                    new Weapon("aepherasadditions-sovereign-weapon"){{
                        top = true;
                        y = 10f;
                        x = 45f;
                        shootY = 50f;
                        reload = 36f;
                        recoil = 7f;
                        shake = 3f;
                        ejectEffect = Fx.casing4;
                        shootSound = Sounds.bang;
                        shoot.shots = 5;
                        shoot.shotDelay = 3;
                        shoot.firstShotDelay = 10;
                        inaccuracy = 3;

                        parts.addAll(
                                new RegionPart("-barrel-top"){{
                                    progress = PartProgress.warmup;
                                    mirror = true;
                                    under = true;
                                    heatColor = new Color(Color.valueOf("f9350f"));
                                    moveY = 16f;
                                }},
                                new RegionPart("-barrel-middle"){{
                                    progress = PartProgress.warmup;
                                    mirror = true;
                                    under = true;
                                    heatColor = new Color(Color.valueOf("f9350f"));
                                    moveY = 8f;
                                }},
                                new RegionPart("-barrel-bolts"){{
                                    progress = PartProgress.warmup;
                                    mirror = true;
                                    under = true;
                                    heatColor = new Color(Color.valueOf("f9350f"));
                                    moveX = 3f;
                                    moveY = -2f;
                                }},
                                new RegionPart("-barrel-bottom"){{
                                    progress = PartProgress.warmup;
                                    mirror = true;
                                    under = true;
                                    heatColor = new Color(Color.valueOf("f9350f"));
                                }}
                        );

                        bullet = new BasicBulletType(16f, 1200){{
                            pierce = true;
                            pierceCap = 25;
                            width = 20f;
                            height = 55f;
                            lifetime = 20f;
                            shootEffect = Fx.shootBig;
                            fragVelocityMin = 0.8f;

                            hitEffect = Fx.blastExplosion;
                            splashDamage = 45f;
                            splashDamageRadius = 25f;

                            fragBullets = 7;
                            fragLifeMin = 0f;
                            fragRandomSpread = 30f;

                            fragBullet = new BasicBulletType(12f, 30){{
                                width = height = 15f;
                                pierce = true;
                                pierceBuilding = true;
                                pierceCap = 6;

                                lifetime = 25f;
                                hitEffect = Fx.flakExplosion;
                                splashDamage = 25f;
                                splashDamageRadius = 20f;
                                lightning = 2;
                                lightningLength = 6;
                                lightningDamage = 5;
                            }};
                        }};
                    }}

            );
        }};

        phoenix = new UnitType("phoenix"){{
            constructor = AepheraLegsUnit::new;
            hitSize = 35f;
            health = 25000f;
            armor = 14f;
            stepShake = 2f;
            rotateSpeed = 1.3f;
            drownTimeMultiplier = 8f;

            legCount = 4;
            legLength = 18f;
            legBaseOffset = 11f;
            legMoveSpace = 1.5f;
            legForwardScl = 0.58f;
            hovering = true;
            shadowElevation = 0.2f;
            ammoType = new PowerAmmoType(4000);
            groundLayer = Layer.legUnit;

            speed = 0.25f;

            drawShields = false;

            weapons.add(new Weapon("aepherasadditions-phoenix-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = false;
                mirror = false;
                shake = 17f;
                shootY = 5f;
                x = y = 0;
                reload = 550f;
                recoil = 0f;

                cooldownTime = 550f;

                shootStatusDuration = 60f * 3f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new LaserBulletType(){{
                    length = 560f;
                    damage = 1560f;
                    width = 100f;

                    lifetime = 85f;

                    lightningSpacing = 15f;
                    lightningLength = 10;
                    lightningDelay = 1.1f;
                    lightningLengthRand = 20;
                    lightningDamage = 70;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 55f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};

        sagittarius = new UnitType("sagittarius"){{
            constructor = AepheraLegsUnit::new;
            hitSize = 45f;
            health = 30000f;
            armor = 18f;
            stepShake = 3f;
            rotateSpeed = 1.1f;
            drownTimeMultiplier = 10f;

            legCount = 4;
            legLength = 28f;
            legBaseOffset = 4f;
            legMoveSpace = 1.5f;
            legForwardScl = 0.58f;
            hovering = true;
            shadowElevation = 0.3f;
            ammoType = new PowerAmmoType(10000);
            groundLayer = Layer.legUnit;

            speed = 0.2f;

            drawShields = false;

            abilities.add(new ShieldArcAbility(){{
                region = "aepherasadditions-sagittarius-shield";
                radius = 50f;
                angle = 110f;
                regen = 1.5f;
                cooldown = 1200f;
                max = 20000f;
                y = -20f;
                width = 10f;
                whenShooting = false;
            }});

            weapons.add(new Weapon("aepherasadditions-sagittarius-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = true;
                mirror = false;
                shake = 17f;
                shootY = 5f;
                y = 0;
                x = 30;
                reload = 500f;
                recoil = 0f;

                cooldownTime = 250f;

                shootStatusDuration = 60f * 3f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                parts.addAll(
                        new RegionPart("-arm-top"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            heatColor = new Color(Pal.sap);
                            moveX = 15f / 4f;
                            moveY = 15f;
                        }},
                        new RegionPart("-arm"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            heatColor = new Color(Pal.sap);
                            moveX = 15f / 4f;
                        }}
                );

                bullet = new LaserBulletType(){{
                    length = 600f;
                    damage = 2000f;
                    width = 100f;

                    lifetime = 85f;

                    lightningSpacing = 15f;
                    lightningLength = 10;
                    lightningDelay = 1.1f;
                    lightningLengthRand = 20;
                    lightningDamage = 180;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 85f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
            weapons.add(new Weapon("aepherasadditions-sagittarius-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = true;
                mirror = false;
                shake = 17f;
                shootY = 5f;
                y = 0;
                x = -30;
                reload = 500f;
                recoil = 0f;

                cooldownTime = 250f;

                shootStatusDuration = 60f * 3f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                parts.addAll(
                        new RegionPart("-arm-top"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            heatColor = new Color(Pal.sap);
                            moveX = 15f / 16f;
                            moveY = 15f;
                        }},
                        new RegionPart("-arm"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = true;
                            heatColor = new Color(Pal.sap);
                            moveX = 15f / 4f;
                        }}
                );
                bullet = new LaserBulletType(){{
                    length = 600f;
                    damage = 2000f;
                    width = 100f;

                    lifetime = 85f;

                    lightningSpacing = 15f;
                    lightningLength = 10;
                    lightningDelay = 1.1f;
                    lightningLengthRand = 20;
                    lightningDamage = 180;
                    lightningAngleRand = 40f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 85f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};

        scytarid = new UnitType("scytarid"){{
            constructor = AepheraLegsUnit::new;
            drag = 0.1f;
            speed = 0.45f;
            hitSize = 34f;
            health = 27000;
            armor = 17f;
            lightRadius = 150f;

            rotateSpeed = 1.6f;
            drownTimeMultiplier = 5f;

            legCount = 8;
            legMoveSpace = 0.8f;
            legPairOffset = 3;
            legLength = 85f;
            legExtension = -20;
            legBaseOffset = 8f;
            stepShake = 1.25f;
            legLengthScl = 0.93f;
            rippleScale = 3f;
            legSpeed = 0.19f;
            ammoType = new ItemAmmoType(Items.graphite, 8);

            legSplashDamage = 100;
            legSplashRange = 75;

            hovering = true;
            shadowElevation = 1.0f;
            groundLayer = Layer.legUnit;

            weapons.add(
                    new Weapon("aepherasadditions-scytarid-weapon"){{
                        y = -5f;
                        x = 11f;
                        shootY = 7f;
                        reload = 30;
                        shake = 4f;
                        rotateSpeed = 2f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        rotate = true;
                        shadow = 12f;
                        recoil = 3f;

                        shoot = new ShootSpread(2, 17f);

                        bullet = new ShrapnelBulletType(){{
                            length = 130f;
                            damage = 140f;
                            width = 45f;
                            serrationLenScl = 7f;
                            serrationSpaceOffset = 60f;
                            serrationFadeOffset = 0f;
                            serrations = 10;
                            serrationWidth = 6f;
                            fromColor = Pal.sapBullet;
                            toColor = Pal.sapBulletBack;
                            shootEffect = smokeEffect = Fx.sparkShoot;
                        }};
                    }});

            weapons.add(new Weapon("aepherasadditions-scytarid-cannon"){{
                y = -14f;
                x = 0f;
                shootY = 24f;
                mirror = false;
                reload = 280;
                shake = 12f;
                recoil = 12f;
                rotateSpeed = 0.85f;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 30f;

                rotationLimit = 80f;

                bullet = new ArtilleryBulletType(2.5f, 100){{
                    hitEffect = Fx.sapExplosion;
                    knockback = 1.2f;
                    lifetime = 100f;
                    width = height = 28f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 4f;
                    splashDamageRadius = 125f;
                    splashDamage = 100f;
                    backColor = trailColor = Pal.sapBulletBack;
                    trailLength = 15;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 6;
                    lightningLength = 25;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 12f;
                    lightRadius = 45f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.75f;

                    status = StatusEffects.sapped;
                    statusDuration = 60f * 12;

                    fragLifeMin = 0.4f;
                    fragBullets = 12;

                    fragBullet = new ArtilleryBulletType(2f, 30){{
                        hitEffect = Fx.sapExplosion;
                        knockback = 1.0f;
                        lifetime = 100f;
                        width = height = 21f;
                        collidesTiles = false;
                        splashDamageRadius = 90f;
                        splashDamage = 60f;
                        backColor = Pal.sapBulletBack;
                        frontColor = lightningColor = Pal.sapBullet;
                        lightning = 3;
                        lightningLength = 7;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 6f;
                        lightRadius = 30f;
                        lightColor = Pal.sap;
                        lightOpacity = 0.5f;

                        status = StatusEffects.sapped;
                        statusDuration = 60f * 10;
                    }};
                }};
            }});
        }};

        mygalid = new UnitType("mygalid"){{
            constructor = AepheraLegsUnit::new;
            drag = 0.1f;
            speed = 0.25f;
            hitSize = 45f;
            health = 54000;
            armor = 28f;
            lightRadius = 250f;

            rotateSpeed = 1f;
            drownTimeMultiplier = 10f;

            legCount = 8;
            legMoveSpace = 0.8f;
            legPairOffset = 3;
            legLength = 125f;
            legExtension = -20;
            legBaseOffset = 8f;
            stepShake = 1.25f;
            legLengthScl = 0.93f;
            rippleScale = 3f;
            legSpeed = 0.19f;
            ammoType = new ItemAmmoType(Items.surgeAlloy, 1);

            legSplashDamage = 350;
            legSplashRange = 75;

            hovering = true;
            shadowElevation = 2.0f;
            groundLayer = Layer.legUnit;



            weapons.add(
                    new Weapon("aepherasadditions-mygalid-chelicerae"){{
                        shootY = 20f;
                        reload = 5;
                        x = 0;
                        shake = 6f;
                        shoot = new ShootAlternate(60f);
                        shoot.firstShotDelay = 60f;
                        shoot.shots = 5;
                        shoot.shotDelay = 1;
                        rotateSpeed = 0.75f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        mirror = true;
                        top = rotate = false;
                        shadow = 12f;
                        recoil = 6f;

                        parts.addAll(
                                new RegionPart("-top"){{
                                    progress = PartProgress.warmup;
                                    mirror = false;
                                    under = true;
                                    heatColor = new Color(Pal.sap);
                                    moveY = 15f / 2f;
                                }}
                        );

                        bullet = new LightningBulletType(){{
                            lifetime = 500f;
                            knockback = 4f;
                            hittable = false;
                            lightningColor = Pal.sapBulletBack;
                            damage = 100f;
                            lightningLength = 30;
                            hitEffect = Fx.hitLancer;
                        }};

                    }},
                    new Weapon("aepherasadditions-mygalid-weapon"){{
                        shootY = 20f;
                        reload = 15;
                        x = 0;
                        shake = 6f;
                        shoot = new ShootAlternate(60f);
                        shoot.firstShotDelay = 60f;
                        shoot.shots = 5;
                        shoot.shotDelay = 1;
                        rotateSpeed = 0.75f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        mirror = true;
                        top = rotate = false;
                        shadow = 12f;
                        recoil = 6f;
                        inaccuracy = 30;

                        parts.addAll(
                                new RegionPart("-bottom"){{
                                    progress = PartProgress.warmup;
                                    mirror = false;
                                    under = true;
                                    heatColor = new Color(Pal.sap);
                                    moveY = -15f / 2f;
                                }},
                                new RegionPart("-top"){{
                                    progress = PartProgress.warmup;
                                    mirror = false;
                                    under = true;
                                    heatColor = new Color(Pal.sap);
                                    moveY = 15f / 2f;
                                }}
                        );

                        bullet = new BulletType(){{
                            speed = 0;
                            keepVelocity = false;

                            spawnUnit = new MissileUnitType("mygalid-missile"){{
                                speed = 6f;
                                lifetime = 60f;
                                maxRange = 6f;
                                health = 100f;
                                lowAltitude = true;
                                engineSize = 3f;
                                engineColor = trailColor = Pal.sapBulletBack;
                                engineLayer = Layer.effect;
                                deathExplosionEffect = Fx.blastExplosion;
                                loopSoundVolume = 0.1f;
                                homingDelay = 10;

                                weapons.add(new Weapon(){{
                                    shootCone = 360f;
                                    mirror = false;
                                    reload = 1f;
                                    shootOnDeath = true;
                                    bullet = new ExplosionBulletType(15f, 35){{
                                        collidesAir = true;
                                        shootEffect = new ExplosionEffect(){{
                                            lifetime = 50f;
                                            waveStroke = 5f;
                                            waveLife = 8f;
                                            waveColor = Color.white;
                                            sparkColor = smokeColor = Pal.sapBulletBack;
                                            waveRad = 40f;
                                            smokeSize = 4f;
                                            smokes = 7;
                                            smokeSizeBase = 0f;
                                            sparks = 10;
                                            sparkRad = 40f;
                                            sparkLen = 6f;
                                            sparkStroke = 2f;
                                        }};
                                    }};
                                }});
                            }};
                        }};

                    }}
            );
            weapons.add(new Weapon("aepherasadditions-mygalid-cannon"){{
                y = -14f;
                x = 0f;
                shootY = 24f;
                mirror = false;
                reload = cooldownTime = 450;
                shake = 12f;
                recoil = 12f;
                rotateSpeed = 0.85f;
                rotate = true;
                shadow = 30f;
                rotationLimit = 80f;

                shootSound = ASounds.artilleryHuge;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                shootStatus = StatusEffects.unmoving;
                shootStatusDuration = 120f;
                shoot.firstShotDelay = AFx.sapLaserCharge.lifetime;
                parentizeEffects = true;

                parts.addAll(
                        new RegionPart("-barrel-top"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = false;
                            heatColor = new Color(Pal.sap);
                            moveY = 15f / 2f;
                            moveX = 15f / 2f;
                            outlineLayerOffset = 1f;
                        }},
                        new RegionPart("-barrel"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = false;
                            heatColor = new Color(Pal.sap);
                            moveX = 15f / 2f;
                            outlineLayerOffset = 1f;
                        }}
                );


                bullet = new ArtilleryBulletType(5f, 100){{
                    knockback = 1.2f;
                    lifetime = 125f;
                    width = height = 50f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 1f;
                    splashDamageRadius = 250f;
                    splashDamage = 200f;
                    backColor = trailColor = Pal.sapBulletBack;
                    trailLength = 25;
                    trailWidth = 15f;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 10;
                    lightningLength = 25;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 25f;
                    lightRadius = 60f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.75f;
                    chargeEffect = AFx.sapLaserCharge;
                    hitSound = despawnSound = ASounds.artilleryExplosion;
                    hitEffect = despawnEffect = AFx.sapBomb;

                    status = StatusEffects.sapped;
                    statusDuration = 60f * 12;

                    fragLifeMin = 0.4f;
                    fragBullets = 12;

                    fragBullet = new ArtilleryBulletType(5f, 75){{
                        knockback = 1.0f;
                        lifetime = 75f;
                        width = height = 40f;
                        collidesTiles = false;
                        splashDamageRadius = 150f;
                        splashDamage = 100f;
                        backColor = trailColor = Pal.sapBulletBack;
                        trailLength = 20;
                        trailWidth = 10f;
                        frontColor = lightningColor = Pal.sapBullet;
                        lightning = 5;
                        lightningLength = 25;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 6f;
                        lightRadius = 30f;
                        lightColor = Pal.sap;
                        lightOpacity = 0.5f;
                        hitSound = despawnSound = ASounds.artilleryExplosion;
                        hitEffect = despawnEffect = Fx.massiveExplosion;

                        status = StatusEffects.sapped;
                        statusDuration = 60f * 10;

                        fragBullets = 12;
                        fragBullet = new ArtilleryBulletType(5f, 50){{
                            knockback = 1.0f;
                            lifetime = 50f;
                            width = height = 30f;
                            collidesTiles = false;
                            splashDamageRadius = 100f;
                            splashDamage = 75f;
                            backColor = trailColor = Pal.sapBulletBack;
                            frontColor = lightningColor = Pal.sapBullet;
                            trailLength = 15;
                            trailWidth = 5f;
                            lightning = 5;
                            lightningLength = 15;
                            smokeEffect = Fx.shootBigSmoke2;
                            hitShake = 6f;
                            lightRadius = 30f;
                            lightColor = Pal.sap;
                            lightOpacity = 0.5f;
                            hitSound = despawnSound = ASounds.artilleryExplosion;
                            hitEffect = despawnEffect = Fx.massiveExplosion;

                            status = StatusEffects.sapped;
                            statusDuration = 60f * 10;
                        }};
                    }};
                }};
            }});
        }};

        synthesisDrone = new UnitType("synthesis-drone"){{
            constructor = AepheraUnit::new;
            controller = u -> new AssemblerAI();

            flying = true;
            drag = 0.06f;
            accel = 0.11f;
            speed = 1.3f;
            health = 90;
            engineSize = 2f;
            engineOffset = 6.5f;
            payloadCapacity = 0f;
            targetable = false;
            bounded = false;

            isEnemy = false;
            hidden = true;
            useUnitCap = false;
            logicControllable = false;
            playerControllable = false;
            allowedInPayloads = false;
            createWreck = false;
            envEnabled = Env.any;
            envDisabled = Env.none;
        }};
    }
}
