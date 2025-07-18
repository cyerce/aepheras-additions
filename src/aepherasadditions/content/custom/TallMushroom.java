package aepherasadditions.content.custom;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.Prop;

public class TallMushroom extends Prop {
    public float shadowOffset = -3.0F;
    public float rotationRand = 20.0F;
    public float shadowAlpha = 0.6F;
    public TextureRegion[] variantRegions;
    public TextureRegion[] variantShadowRegions;

    public TallMushroom(String name) {
        super(name);
        clipSize = 90f;
        customShadow = true;
        hasShadow = true;
    }

    @Override
    public void load() {
        super.load();
        // Load variant regions
        variantRegions = new TextureRegion[variants];
        variantShadowRegions = new TextureRegion[variants];
        for(int i = 0; i < variants; i++){
            variantRegions[i] = Core.atlas.find(name + (i + 1));
            variantShadowRegions[i] = Core.atlas.find(name + "-shadow" + (i + 1));
        }
    }

    @Override
    public void drawBase(Tile tile){
        int variant = Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - 1));
        float rot = Mathf.randomSeedRange(tile.pos() + 1, rotationRand);

        Draw.z(69f);
        Draw.color(0f, 0f, 0f, shadowAlpha);
        Draw.rect(variantShadowRegions[variant], tile.worldx() + shadowOffset, tile.worldy() + shadowOffset, rot);
        Draw.color();

        Draw.z(71f);
        Draw.rect(variantRegions[variant], tile.worldx(), tile.worldy(), rot);
    }

    @Override
    public TextureRegion[] icons(){
        return variants > 0 ? new TextureRegion[]{Core.atlas.find(name + "1")} : super.icons();
    }
}
