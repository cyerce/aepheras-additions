precision mediump float;

uniform sampler2D u_bloomMask;  // the bloom texture
uniform vec2 u_resolution;
uniform float u_time;

varying vec2 v_texCoords;

// Simulate a soft radial blur around white areas
float blurHalo(vec2 uv) {
    float result = 0.0;
    float count = 0.0;
    float radius = 0.01; // radius of blur

    // Sample around the pixel in a small grid
    for (float x = -3.0; x <= 3.0; x++) {
        for (float y = -3.0; y <= 3.0; y++) {
            vec2 offset = vec2(x, y) * radius / u_resolution;
            result += texture2D(u_bloomMask, uv + offset).a;
            count += 1.0;
        }
    }

    return result / count; // average blur
}

void main() {
    vec4 bloom = texture2D(u_bloomMask, v_texCoords);

    // Compute blurred halo from alpha
    float glow = blurHalo(v_texCoords);

    // Base bloom color (can adjust to be color-dependent)
    vec3 bloomColor = bloom.rgb;

    // Mix bloom directly with blurred halo
    vec3 final = bloomColor * glow * 2.0; // intensity

    // Optional: fade edges softly
    final *= smoothstep(0.0, 1.0, glow);

    gl_FragColor = vec4(final, glow);
}