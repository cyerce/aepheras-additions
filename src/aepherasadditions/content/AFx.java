package aepherasadditions.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

public class AFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static final Effect voltaliteReactorExplosion = new Effect(30.0F, 500.0F, (b) -> {
        float intensity = 8.0F;
        float baseLifetime = 25.0F + intensity * 15.0F;
        b.lifetime = 50.0F + intensity * 64.0F;
        Draw.color(Pal.surge);
        Draw.alpha(0.8F);

        for(int i = 0; i < 5; ++i) {
            rand.setSeed((long)(b.id * 2 + i));
            float lenScl = rand.random(0.25F, 1.0F);
            int fi = i;
            b.scaled(b.lifetime * lenScl, (e) -> {
                Angles.randLenVectors((long)(e.id + fi - 1), e.fin(Interp.pow10Out), (int)(2.8F * intensity), 25.0F * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5F, 1.0F);
                    float rad = fout * (2.0F + intensity) * 2.35F;
                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 2.6F, Pal.surge, 0.7F);
                });
            });
        }

        b.scaled(baseLifetime, (e) -> {
            Draw.color();
            e.scaled(5.0F + intensity * 2.0F, (i) -> {
                Lines.stroke((3.1F + intensity / 5.0F) * i.fout());
                Lines.circle(e.x, e.y, (3.0F + i.fin() * 14.0F) * intensity);
                Drawf.light(e.x, e.y, i.fin() * 14.0F * 2.0F * intensity, Color.white, 0.9F * e.fout());
            });
            Draw.color(Color.white, Pal.surge, e.fin());
            Lines.stroke(2.0F * e.fout());
            Draw.z(110.001F);
            Angles.randLenVectors((long)(e.id + 1), e.finpow() + 0.001F, (int)(8.0F * intensity), 30.0F * intensity, (x, y, in, out) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + out * 4.0F * (4.0F + intensity));
                Drawf.light(e.x + x, e.y + y, out * 4.0F * (3.0F + intensity) * 3.5F, Draw.getColor(), 0.8F);
            });
        });
    });
    public static final Effect nuclearReactorExplosion = new Effect(30.0F, 600.0F, (b) -> {
        float intensity = 12.0F;
        float baseLifetime = 25.0F + intensity * 15.0F;
        b.lifetime = 50.0F + intensity * 64.0F;
        Draw.color(Pal.techBlue);
        Draw.alpha(0.8F);

        for(int i = 0; i < 5; ++i) {
            rand.setSeed((long)(b.id * 2 + i));
            float lenScl = rand.random(0.25F, 1.0F);
            int fi = i;
            b.scaled(b.lifetime * lenScl, (e) -> {
                Angles.randLenVectors((long)(e.id + fi - 1), e.fin(Interp.pow10Out), (int)(2.8F * intensity), 25.0F * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5F, 1.0F);
                    float rad = fout * (2.0F + intensity) * 2.35F;
                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 2.6F, Pal.techBlue, 0.7F);
                });
            });
        }

        b.scaled(baseLifetime, (e) -> {
            Draw.color();
            e.scaled(5.0F + intensity * 2.0F, (i) -> {
                Lines.stroke((3.1F + intensity / 5.0F) * i.fout());
                Lines.circle(e.x, e.y, (3.0F + i.fin() * 14.0F) * intensity);
                Drawf.light(e.x, e.y, i.fin() * 14.0F * 2.0F * intensity, Color.white, 0.9F * e.fout());
            });
            Draw.color(Color.white, Pal.techBlue, e.fin());
            Lines.stroke(2.0F * e.fout());
            Draw.z(110.001F);
            Angles.randLenVectors((long)(e.id + 1), e.finpow() + 0.001F, (int)(8.0F * intensity), 30.0F * intensity, (x, y, in, out) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + out * 4.0F * (4.0F + intensity));
                Drawf.light(e.x + x, e.y + y, out * 4.0F * (3.0F + intensity) * 3.5F, Draw.getColor(), 0.8F);
            });
        });
    });
    public static final Effect venusReactorExplosion1 = new Effect(30.0F, 700.0F, (b) -> {
        float intensity = 16.0F;
        float baseLifetime = 25.0F + intensity * 15.0F;
        b.lifetime = 50.0F + intensity * 64.0F;
        Draw.color(Pal.reactorPurple);
        Draw.alpha(0.8F);

        for(int i = 0; i < 5; ++i) {
            rand.setSeed((long)(b.id * 2 + i));
            float lenScl = rand.random(0.25F, 1.0F);
            int fi = i;
            b.scaled(b.lifetime * lenScl, (e) -> {
                Angles.randLenVectors((long)(e.id + fi - 1), e.fin(Interp.pow10Out), (int)(2.8F * intensity), 25.0F * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5F, 1.0F);
                    float rad = fout * (2.0F + intensity) * 2.35F;
                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 2.6F, Pal.reactorPurple, 0.7F);
                });
            });
        }

        b.scaled(baseLifetime, (e) -> {
            Draw.color();
            e.scaled(5.0F + intensity * 2.0F, (i) -> {
                Lines.stroke((3.1F + intensity / 5.0F) * i.fout());
                Lines.circle(e.x, e.y, (3.0F + i.fin() * 14.0F) * intensity);
                Drawf.light(e.x, e.y, i.fin() * 14.0F * 2.0F * intensity, Color.white, 0.9F * e.fout());
            });
            Draw.color(Color.white, Pal.reactorPurple, e.fin());
            Lines.stroke(2.0F * e.fout());
            Draw.z(110.001F);
            Angles.randLenVectors((long)(e.id + 1), e.finpow() + 0.001F, (int)(8.0F * intensity), 30.0F * intensity, (x, y, in, out) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + out * 4.0F * (4.0F + intensity));
                Drawf.light(e.x + x, e.y + y, out * 4.0F * (3.0F + intensity) * 3.5F, Draw.getColor(), 0.8F);
            });
        });
    });
    public static final Effect venusReactorExplosion2 = new Effect(30.0F, 700.0F, (b) -> {
        float intensity = 16.0F;
        float baseLifetime = 25.0F + intensity * 15.0F;
        b.lifetime = 50.0F + intensity * 64.0F;
        Draw.color(Pal.reactorPurple2);
        Draw.alpha(0.8F);

        for(int i = 0; i < 5; ++i) {
            rand.setSeed((long)(b.id * 2 + i));
            float lenScl = rand.random(0.25F, 1.0F);
            int fi = i;
            b.scaled(b.lifetime * lenScl, (e) -> {
                Angles.randLenVectors((long)(e.id + fi - 1), e.fin(Interp.pow10Out), (int)(2.8F * intensity), 25.0F * intensity, (x, y, in, out) -> {
                    float fout = e.fout(Interp.pow5Out) * rand.random(0.5F, 1.0F);
                    float rad = fout * (2.0F + intensity) * 2.35F;
                    Fill.circle(e.x + x, e.y + y, rad);
                    Drawf.light(e.x + x, e.y + y, rad * 2.6F, Pal.reactorPurple2, 0.7F);
                });
            });
        }

        b.scaled(baseLifetime, (e) -> {
            Draw.color();
            e.scaled(5.0F + intensity * 2.0F, (i) -> {
                Lines.stroke((3.1F + intensity / 5.0F) * i.fout());
                Lines.circle(e.x, e.y, (3.0F + i.fin() * 14.0F) * intensity);
                Drawf.light(e.x, e.y, i.fin() * 14.0F * 2.0F * intensity, Color.white, 0.9F * e.fout());
            });
            Draw.color(Color.white, Pal.reactorPurple2, e.fin());
            Lines.stroke(2.0F * e.fout());
            Draw.z(110.001F);
            Angles.randLenVectors((long)(e.id + 1), e.finpow() + 0.001F, (int)(8.0F * intensity), 30.0F * intensity, (x, y, in, out) -> {
                Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + out * 4.0F * (4.0F + intensity));
                Drawf.light(e.x + x, e.y + y, out * 4.0F * (3.0F + intensity) * 3.5F, Draw.getColor(), 0.8F);
            });
        });
    });

    public static final Effect irradiated = new Effect(35.0F, (e) -> {
        Draw.color(Pal.thoriumPink, Color.white, e.fin());
        Angles.randLenVectors((long)e.id, 3, 2.0F + e.fin() * 7.0F, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.1F + e.fout() * 1.4F);
        });
    });

    public static final Effect meltingAcid = new Effect(40.0F, (e) -> {
        Draw.color(Color.valueOf("ffee6b"), Color.valueOf("fff6b0"), e.fout() / 5.0F + Mathf.randomSeedRange((long)e.id, 0.12F));
        Angles.randLenVectors((long)e.id, 2, 1.0F + e.fin() * 3.0F, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.2F + e.fout() * 1.2F);
        });
    });

    public static final Effect sapLaserCharge = (new Effect(80.0F, 100.0F, (e) -> {
        Draw.color(Pal.sap);
        Lines.stroke(e.fin() * 2.0F);
        Lines.circle(e.x, e.y, 4.0F + e.fout() * 100.0F);
        Fill.circle(e.x, e.y, e.fin() * 20.0F);
        Angles.randLenVectors((long)e.id, 20, 40.0F * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 5.0F);
            Drawf.light(e.x + x, e.y + y, e.fin() * 15.0F, Pal.sap, 0.7F);
        });
        Draw.color();
        Fill.circle(e.x, e.y, e.fin() * 10.0F);
        Drawf.light(e.x, e.y, e.fin() * 20.0F, Pal.sap, 0.7F);
    })).followParent(true).rotWithParent(true);

    public static final Effect sapBomb = new Effect(40.0F, 100.0F, (e) -> {
        Draw.color(Pal.sap);
        Lines.stroke(e.fout() * 2.0F);
        float circleRad = 4.0F + e.finpow() * 65.0F;
        Lines.circle(e.x, e.y, circleRad);
        Draw.color(Pal.sap);

        int i;
        for(i = 0; i < 4; ++i) {
            Drawf.tri(e.x, e.y, 6.0F, 100.0F * e.fout(), (float)(i * 90));
        }

        Draw.color();

        for(i = 0; i < 4; ++i) {
            Drawf.tri(e.x, e.y, 3.0F, 35.0F * e.fout(), (float)(i * 90));
        }

        Drawf.light(e.x, e.y, circleRad * 1.6F, Pal.sap, e.fout());
    });
}