precision mediump float;

uniform float u_time;
uniform vec2 u_resolution;
uniform sampler2D u_texture;
uniform vec2 u_campos;

varying vec2 v_texCoords;

// Simple hash function from float to [0,1]
float hash(float x) {
    return fract(sin(x) * 43758.5453);
}

void main() {
    // Convert texture coords to world coords
    vec2 worldUV = v_texCoords * u_resolution + u_campos;

    float speed = 50.0;

    // CONTROL VARIABLES:
    float spacing = 100000.0;       // Distance between beams in world pixels
    float coreWidthWorld = 15.0;  // Beam core width in world pixels (actual visual width)

    // Position along the diagonal, normalized by spacing
    float pos = (worldUV.x + worldUV.y + u_time * speed) / spacing;
    float beamIndex = floor(pos);
    float diagonalPos = fract(pos);

    // Convert core width from world pixels to normalized [0,1] per beam
    float baseWidth = coreWidthWorld / spacing;

    // Variation proportional to baseWidth (about ±15%)
    float variation = 0.3 * baseWidth;

    // Randomized core width per beam, clamped to positive values
    float coreWidth = baseWidth + (hash(beamIndex) - 0.5) * variation;
    coreWidth = max(coreWidth, 0.001);

    float haloWidth = coreWidth + 0.05;

    float dist = abs(diagonalPos - 0.5);

    // Hard core with sharp edges
    float hard = dist < coreWidth ? 1.0 : 0.0;

    // Soft halo with smooth edges
    float soft = smoothstep(haloWidth, coreWidth, dist);

    // Combine hard and soft, multiply by max alpha 0.75
    float glint = max(hard, soft * 0.4) * 0.75;

    // Sample original texture color
    vec4 texColor = texture2D(u_texture, v_texCoords);

    // White glint color
    vec3 glintColor = vec3(1.0);

    // Mix original color with glint
    texColor.rgb = mix(texColor.rgb, glintColor, glint);

    gl_FragColor = texColor;
}