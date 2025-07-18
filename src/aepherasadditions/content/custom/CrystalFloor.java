package aepherasadditions.content.custom;

import aepherasadditions.content.AepherasShaders;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.gl.Shader;
import arc.math.Mathf;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Floor;

public class CrystalFloor extends Floor {
    public static Color glintColor;
    public CrystalFloor(String name, Color glintColor) {
        super(name);
        this.glintColor = glintColor;
    }

    @Override
    public void drawBase(Tile tile) {
        Mathf.rand.setSeed((long)tile.pos());
        Draw.rect(
                this.variantRegions[Mathf.randomSeed((long)tile.pos(), 0, Math.max(0, this.variantRegions.length - 1))],
                tile.worldx(),
                tile.worldy()
        );
        Draw.alpha(1f);
        Draw.blend();
        this.drawEdges(tile);
        this.drawOverlay(tile);
    }
}
