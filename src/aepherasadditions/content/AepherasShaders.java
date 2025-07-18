package aepherasadditions.content;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Texture;
import arc.graphics.gl.Shader;
import arc.util.Time;
import mindustry.Vars;
import mindustry.graphics.Pal;
import mindustry.graphics.Shaders;

public class AepherasShaders {
    public static Shader ringShader;
    public static AepheraSurfaceShader cauradine;
    public static AepheraSurfaceShader crystal;
    public static AepheraSurfaceShader crystalDark;
    public static Shader crystalCluster;
    public static Fi cauradineFrag = Vars.tree.get("shaders/cauradine.frag");
    public static Fi crystalFrag = Vars.tree.get("shaders/crystal.frag");
    public static Fi crystalDarkFrag = Vars.tree.get("shaders/crystal-dark.frag");

    public static void load() {
        Fi ringvert = Vars.tree.get("shaders/ring.vert");
        Fi ringfrag = Vars.tree.get("shaders/ring.frag");

        Fi clustervert = Vars.tree.get("shaders/crystal-cluster.vert");
        Fi clusterfrag = Vars.tree.get("shaders/crystal-cluster.frag");

        ringShader = new Shader(ringvert, ringfrag);
        crystalCluster = new Shader(clustervert, clusterfrag);

        cauradine = new AepheraSurfaceShader(cauradineFrag);
        crystal = new AepheraSurfaceShader(crystalFrag);
        crystalDark = new AepheraSurfaceShader(crystalDarkFrag);

    }

    public static class AepheraSurfaceShader extends Shader {
        Texture noiseTex;

        public AepheraSurfaceShader(Fi frag) {
            super(Shaders.getShaderFi("screenspace.vert"), frag);
            this.loadNoise();
        }

        public AepheraSurfaceShader(String vertRaw, String fragRaw) {
            super(vertRaw, fragRaw);
            this.loadNoise();
        }

        public String textureName() {
            return "noise";
        }

        public void loadNoise() {
            Core.assets.load("sprites/" + this.textureName() + ".png", Texture.class).loaded = (t) -> {
                t.setFilter(Texture.TextureFilter.linear);
                t.setWrap(Texture.TextureWrap.repeat);
            };
        }

        public void apply() {
            this.setUniformf("u_campos", Core.camera.position.x - Core.camera.width / 2.0F, Core.camera.position.y - Core.camera.height / 2.0F);
            this.setUniformf("u_resolution", Core.camera.width, Core.camera.height);
            this.setUniformf("u_time", Time.time);
            if (this.hasUniform("u_noise")) {
                if (this.noiseTex == null) {
                    this.noiseTex = (Texture)Core.assets.get("sprites/" + this.textureName() + ".png", Texture.class);
                }

                this.noiseTex.bind(1);
                ((Texture)Vars.renderer.effectBuffer.getTexture()).bind(0);
                this.setUniformi("u_noise", 1);
            }

        }
    }
}