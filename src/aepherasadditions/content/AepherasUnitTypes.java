package aepherasadditions.content;

import aepherasadditions.world.unit.AepheraLegsUnit;
import aepherasadditions.world.unit.AepheraMechUnit;
import aepherasadditions.world.unit.AepheraUnit;
import aepherasadditions.world.unit.AepheraUnitWaterMove;
import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CommandAI;
import mindustry.ai.types.SuicideAI;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.abilities.ShieldRegenFieldAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

public class AepherasUnitTypes {
    public static UnitType delta;

    public static UnitType gona;
    public static UnitType dosid;
    public static UnitType vampyr;
    public static UnitType enteroct;
    public static UnitType architeuth;



    public static UnitType atta;
    public static UnitType lasius;
    public static UnitType formica;
    public static UnitType eciton;
    public static UnitType myrmex;

    public static UnitType drift;
    public static UnitType veil;
    public static UnitType tempest;

    public static UnitType uro;
    public static UnitType atelo;
    public static UnitType lycalo;
    public static UnitType otocyon;
    public static UnitType cerdocyon;

    public AepherasUnitTypes(){
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
                    healPercent = 5f;
                    collidesTeam = true;
                    backColor = Pal.surge;
                    frontColor = Color.white;
                }};
            }});
            abilities.add(new ForceFieldAbility(15f, 1f, 300f, 180f, 16, 0f));
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
    }
}
