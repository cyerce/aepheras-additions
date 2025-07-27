package aepherasadditions.content.custom.mesh;

import aepherasadditions.content.AShaders;
import arc.graphics.Color;
import arc.graphics.GL20;
import arc.graphics.Mesh;
import arc.graphics.VertexAttribute;
import arc.graphics.gl.Shader;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Time;
import mindustry.graphics.g3d.GenericMesh;
import mindustry.graphics.g3d.PlanetParams;
import arc.math.geom.Mat3D;
import mindustry.type.Planet;

public class RingMesh implements GenericMesh {
    private final Mesh mesh;
    private static final int SEGMENTS = 64;
    public Color ringColor = Color.white.cpy();
    float ringHexDivisions = 12f;
    public Planet planet;
    public float pitch = 0.0f;
    public float yaw = 0.0f;
    public float roll = 0.0f;
    public float alpha = 0.5f;


    public RingMesh(float innerRadius, float outerRadius, Planet planet, float speed, Color ringColor, Float pitch, Float yaw, Float roll, Float alpha) {
        float[] vertices = new float[SEGMENTS * 2 * 5]; // x, y, z, u, v
        short[] indices = new short[SEGMENTS * 6];
        this.planet = planet;
        this.ringColor = ringColor;
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;

        for (int i = 0; i < SEGMENTS; i++) {
            float angle = i * Mathf.PI2 / SEGMENTS;
            float cos = Mathf.cos(angle);
            float sin = Mathf.sin(angle);

            int vertIdx = i * 10;

            // Outer vertex
            vertices[vertIdx] = cos * outerRadius;
            vertices[vertIdx + 1] = 0;
            vertices[vertIdx + 2] = sin * outerRadius;
            vertices[vertIdx + 3] = ((float) i / SEGMENTS) * ringHexDivisions; // u * hexDivisions for tiling
            vertices[vertIdx + 4] = 1f; // v

            // Inner vertex
            vertices[vertIdx + 5] = cos * innerRadius;
            vertices[vertIdx + 6] = 0;
            vertices[vertIdx + 7] = sin * innerRadius;
            vertices[vertIdx + 8] = ((float) i / SEGMENTS) * ringHexDivisions; // u * hexDivisions for tiling
            vertices[vertIdx + 9] = 0f; // v
        }

        for (int i = 0; i < SEGMENTS; i++) {
            int base = i * 2;
            int next = ((i + 1) % SEGMENTS) * 2;

            int idx = i * 6;
            indices[idx] = (short) base;
            indices[idx + 1] = (short) (base + 1);
            indices[idx + 2] = (short) next;
            indices[idx + 3] = (short) (base + 1);
            indices[idx + 4] = (short) (next + 1);
            indices[idx + 5] = (short) next;
        }

        mesh = new Mesh(true, SEGMENTS * 2, SEGMENTS * 6,
                VertexAttribute.position3, VertexAttribute.texCoords);
        mesh.setVertices(vertices);
        mesh.setIndices(indices);
    }

    public float getTime() {
        return Time.globalTime;
    }

    @Override
    public void render(PlanetParams params, Mat3D projection, Mat3D view) {
        Shader shader = AShaders.ringShader;

        Mat3D rotation = new Mat3D();
        rotation.rotate(Vec3.X, this.pitch);
        rotation.rotate(Vec3.Y, this.yaw);
        rotation.rotate(Vec3.Z, this.roll);

        shader.bind();
        shader.setUniformMatrix4("u_proj", projection.val);
        shader.setUniformMatrix4("u_view", view.val);
        shader.setUniformMatrix4("u_rotation", rotation.val);
        shader.setUniformf("u_time", (Time.time));
        shader.setUniformf("u_color", ringColor);
        shader.setUniformf("u_divisions", ringHexDivisions);
        shader.setUniformf("u_alpha", alpha);

        mesh.render(shader, GL20.GL_TRIANGLES);
    }
}