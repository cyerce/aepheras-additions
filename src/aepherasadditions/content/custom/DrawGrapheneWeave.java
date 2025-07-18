package aepherasadditions.content.custom;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.gen.Building;
import mindustry.graphics.Pal;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawGrapheneWeave extends DrawBlock {
    public TextureRegion weave;
    public String suffix;
    public String direction;

    public DrawGrapheneWeave(String suffix, String direction) {
        this.suffix = suffix;
        this.direction = direction;
    }

    public void draw(Building build) {
        if (this.direction.equals("clockwise")) {
            Draw.rect(this.weave, build.x, build.y, build.totalProgress());
        } else if (this.direction.equals("counterclockwise")) {
            Draw.rect(this.weave, build.x, build.y, -build.totalProgress());
        }
        Draw.color(Pal.accent);
        Draw.alpha(build.warmup());
        Lines.lineAngleCenter(build.x + Mathf.sin(build.totalProgress(), 6.0F, 2.6666667F * (float)build.block.size), build.y, 90.0F, (float)(build.block.size * 8) / 2.0F);
        Draw.reset();
    }

    public TextureRegion[] icons(Block block) {
        return new TextureRegion[]{this.weave};
    }

    public void load(Block block) {
        this.weave = Core.atlas.find(block.name + this.suffix);
    }

}
