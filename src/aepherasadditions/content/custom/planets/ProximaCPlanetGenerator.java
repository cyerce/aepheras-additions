package aepherasadditions.content.custom.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.struct.ObjectMap;
import arc.util.Tmp;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;

public class ProximaCPlanetGenerator extends PlanetGenerator {
    float scl = 5.0F;
    float iceOffset = 0.07F;

    Block[][] arr = {
            {Blocks.sand, Blocks.sand, Blocks.sand, Blocks.yellowStone, Blocks.yellowStone, Blocks.basalt},
            {Blocks.sand, Blocks.crystalFloor, Blocks.yellowStone, Blocks.yellowStone, Blocks.basalt, Blocks.basalt},
            {Blocks.yellowStone, Blocks.yellowStone, Blocks.basalt, Blocks.basalt, Blocks.sand, Blocks.sand},
            {Blocks.sand, Blocks.sand, Blocks.yellowStone, Blocks.yellowStone, Blocks.basalt, Blocks.basalt}
    };

    ObjectMap<Block, Block> tars = ObjectMap.of(
            Blocks.sporeMoss, Blocks.shale,
            Blocks.moss, Blocks.shale
    );

    float ice = 2.0F / (float)this.arr[0].length;

    float rawHeight(Vec3 position) {
        position = Tmp.v33.set(position).scl(this.scl);
        return (Mathf.pow(Simplex.noise3d(this.seed, 7.0, 0.5, 0.3333333432674408, (double)position.x, (double)position.y, (double)position.z), 2.3F) + this.iceOffset) / (1.0F + this.iceOffset);
    }

    public float getHeight(Vec3 position) {
        float height = this.rawHeight(position);
        return Math.max(height, this.ice);
    }

    public Color getColor(Vec3 position) {
        float lat = position.y; // latitude approximation
        float noise = Simplex.noise3d(seed, 3, 0.5, 0.5, position.x, position.y, position.z);
        float band = Mathf.floor(lat * 10 + noise * 2);

        switch ((int)(band % 5)) {
            case 0: return Color.valueOf("a3682c");
            case 1: return Color.valueOf("dba56f");
            case 2: return Color.valueOf("bc8043");
            case 3: return Color.valueOf("e2b57a");
            default: return Color.valueOf("b36b2d");
        }
    }

    Block getBlock(Vec3 position) {
        float height = this.rawHeight(position);
        Tmp.v31.set(position);
        position = Tmp.v33.set(position).scl(this.scl);
        float rad = this.scl;
        float temp = Mathf.clamp(Math.abs(position.y * 2.0F) / rad);
        float tnoise = Simplex.noise3d(this.seed, 7.0, 0.56, 0.3333333432674408, (double)position.x, (double)(position.y + 999.0F), (double)position.z);
        temp = Mathf.lerp(temp, tnoise, 0.5F);
        height *= 1.2F;
        height = Mathf.clamp(height);
        float tar = Simplex.noise3d(this.seed, 4.0, 0.550000011920929, 0.5, (double)position.x, (double)(position.y + 999.0F), (double)position.z) * 0.3F + Tmp.v31.dst(0.0F, 0.0F, 1.0F) * 0.2F;
        Block res = this.arr[Mathf.clamp((int)(temp * (float)this.arr.length), 0, this.arr[0].length - 1)][Mathf.clamp((int)(height * (float)this.arr[0].length), 0, this.arr[0].length - 1)];
        return tar > 0.5F ? (Block)this.tars.get(res, res) : res;
    }
}
