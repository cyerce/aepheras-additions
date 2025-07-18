package aepherasadditions.content.custom;

import arc.Core;
import arc.func.Boolf;
import arc.func.Cons;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Point2;
import arc.math.geom.QuadTree;
import arc.util.Structs;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.world.Edges;
import mindustry.world.Tile;
import mindustry.world.blocks.power.PowerNode;

public class CynerisPowerNode extends PowerNode {
    public Color accentColorOverride;
    public TextureRegion laser;
    public TextureRegion laserEnd;

    public CynerisPowerNode(String name, Color accentColor) {
        super(name);
        this.accentColorOverride = accentColor;
    }

    public void load(){
        super.load();
        this.laser = Core.atlas.find("aepherasadditions-laser");
        this.laserEnd = Core.atlas.find("aepherasadditions-laser-end");
    }

    public void drawLaser(float x1, float y1, float x2, float y2, int size1, int size2) {
        float angle1 = Angles.angle(x1, y1, x2, y2);
        float vx = Mathf.cosDeg(angle1);
        float vy = Mathf.sinDeg(angle1);
        float len1 = (float)(size1 * 8) / 2.0F - 1.5F;
        float len2 = (float)(size2 * 8) / 2.0F - 1.5F;
        Drawf.laser(this.laser, this.laserEnd, x1 + vx * len1, y1 + vy * len1, x2 - vx * len2, y2 - vy * len2, this.laserScale);
    }

    protected void getPotentialLinks(Tile tile, Team team, Cons<Building> others) {
        if (this.autolink) {
            Boolf<Building> valid = (otherx) -> {
                boolean var10000;
                if (otherx != null && otherx.tile() != tile && otherx.block.connectedPower && otherx.power != null && (otherx.block.outputsPower || otherx.block.consumesPower || otherx.block instanceof PowerNode) && this.overlaps((float)(tile.x * 8) + this.offset, (float)(tile.y * 8) + this.offset, otherx.tile(), this.laserRange * 8.0F) && otherx.team == team && !graphs.contains(otherx.power.graph) && !insulated(tile, otherx.tile)) {
                    label26: {
                        Building obuild$temp = otherx;
                        if (obuild$temp instanceof CynerisPowerNodeBuild) {
                            CynerisPowerNodeBuild obuild = (CynerisPowerNodeBuild)obuild$temp;
                            if (obuild.power.links.size >= ((PowerNode)obuild.block).maxNodes) {
                                break label26;
                            }
                        }

                        if (!Structs.contains(Edges.getEdges(this.size), (p) -> {
                            Tile t = Vars.world.tile(tile.x + p.x, tile.y + p.y);
                            return t != null && t.build == otherx;
                        })) {
                            var10000 = true;
                            return var10000;
                        }
                    }
                }

                var10000 = false;
                return var10000;
            };
            tempBuilds.clear();
            graphs.clear();
            Point2[] var5 = Edges.getEdges(this.size);
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Point2 p = var5[var7];
                Tile other = tile.nearby(p);
                if (other != null && other.team() == team && other.build != null && other.build.power != null) {
                    graphs.add(other.build.power.graph);
                }
            }

            if (tile.build != null && tile.build.power != null) {
                graphs.add(tile.build.power.graph);
            }

            float worldRange = this.laserRange * 8.0F;
            QuadTree<Building> tree = team.data().buildingTree;
            if (tree != null) {
                tree.intersect(tile.worldx() - worldRange, tile.worldy() - worldRange, worldRange * 2.0F, worldRange * 2.0F, (build) -> {
                    if (valid.get(build) && !tempBuilds.contains(build)) {
                        tempBuilds.add(build);
                    }

                });
            }

            tempBuilds.sort((a, b) -> {
                int type = -Boolean.compare(a.block instanceof PowerNode, b.block instanceof PowerNode);
                return type != 0 ? type : Float.compare(a.dst2(tile), b.dst2(tile));
            });
            returnInt = 0;
            tempBuilds.each(valid, (t) -> {
                if (returnInt++ < this.maxNodes) {
                    graphs.add(t.power.graph);
                    others.get(t);
                }

            });
        }
    }

    public class CynerisPowerNodeBuild extends PowerNodeBuild{
        public CynerisPowerNodeBuild(){
        }
        @Override
        public void drawSelect() {
            super.drawSelect();
            if (CynerisPowerNode.this.drawRange) {
                Lines.stroke(1.0F);
                Draw.color(CynerisPowerNode.this.accentColorOverride);
                Drawf.circles(this.x, this.y, CynerisPowerNode.this.laserRange * 8.0F);
                Draw.reset();
            }
        }
    }
}
