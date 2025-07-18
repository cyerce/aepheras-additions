package aepherasadditions.content.custom;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.TallBlock;

public class CrystalBlock extends TallBlock {
    public Color lightColor = Color.valueOf("ffffff");
    public float alpha = 1.0f;
    public float lightRadius = 50f;

    public CrystalBlock(String name){
        super(name);
        update = false;
    }

    @Override
    public void drawBase(Tile tile) {
        super.drawBase(tile);
        Draw.z(Layer.light);
        Draw.color(lightColor.r, lightColor.g, lightColor.b, alpha);
        Drawf.light(tile.worldx(), tile.worldy(), lightRadius, lightColor, alpha);
        Draw.color();
    }
}