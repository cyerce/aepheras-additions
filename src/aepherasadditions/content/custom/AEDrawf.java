package aepherasadditions.content.custom;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.Vars;

public class AEDrawf {
    public static void cyLaser(TextureRegion line, TextureRegion edge, float x, float y, float x2, float y2, float scale) {
        cyLaser(line, edge, edge, x, y, x2, y2, scale);
    }

    public static void cyLaser(TextureRegion line, TextureRegion start, TextureRegion end, float x, float y, float x2, float y2, float scale) {
        float scl = 8.0F * scale * Draw.scl;
        float rot = Mathf.angle(x2 - x, y2 - y);
        float vx = Mathf.cosDeg(rot) * scl;
        float vy = Mathf.sinDeg(rot) * scl;
        Draw.rect(start, x, y, (float)start.width * scale * start.scl(), (float)start.height * scale * start.scl(), rot + 180.0F);
        Draw.rect(end, x2, y2, (float)end.width * scale * end.scl(), (float)end.height * scale * end.scl(), rot);
        Lines.stroke(12.0F * scale);
        Lines.line(line, x + vx, y + vy, x2 - vx, y2 - vy, false);
        Lines.stroke(1.0F);
        cyLight(x, y, x2, y2);
    }

    public static void cyLight(float x, float y, float x2, float y2) {
        if (Vars.renderer != null) {
            Vars.renderer.lights.line(x, y, x2, y2, 30.0F, Color.valueOf("80a9ff"), 0.3F);
        }
    }
}
