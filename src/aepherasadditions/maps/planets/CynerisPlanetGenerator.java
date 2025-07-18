package aepherasadditions.maps.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.struct.ObjectMap;
import arc.util.Tmp;
import arc.util.noise.Simplex;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.game.Schematics;
import mindustry.maps.generators.*;
import mindustry.world.Block;

import java.io.IOException;

public class CynerisPlanetGenerator extends PlanetGenerator {

    float scl = 5.0F;
    float iceOffset = 0.07F;
    public CynerisPlanetGenerator() throws IOException {
        this.defaultLoadout = Schematics.read(Vars.tree.get("schematics/core-echo.msch"));
    }

    Block[][] arr = {
            {Blocks.ice, Blocks.ice, Blocks.ice, Blocks.snow, Blocks.snow, Blocks.basalt},
            {Blocks.ice, Blocks.iceSnow, Blocks.snow, Blocks.snow, Blocks.basalt, Blocks.basalt},
            {Blocks.snow, Blocks.snow, Blocks.basalt, Blocks.basalt, Blocks.ice, Blocks.ice},
            {Blocks.ice, Blocks.ice, Blocks.snow, Blocks.snow, Blocks.basalt, Blocks.basalt}
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
        Block block = this.getBlock(position);
        return block == Blocks.ice ? Blocks.snow.mapColor : Tmp.c1.set(block.mapColor).a(1.0F - block.albedo);
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
