precision mediump float;

uniform float u_time;
uniform vec4 u_color;
uniform float u_divisions;

varying vec2 v_uv;
varying vec3 v_worldPos;

float hexPattern(vec2 uv){
    const float sqrt3 = 1.7320508;
    uv.x *= sqrt3;
    vec2 grid = vec2(
    uv.x - floor(uv.x) - 0.5,
    uv.y - floor(uv.y)
    );

    float d = length(grid - vec2(0.0, 0.5 * mod(floor(uv.x) + floor(uv.y), 2.0)));

    return smoothstep(0.48, 0.5, d);
}

void main(){
    vec2 tiledUV = v_uv * u_divisions;
    float hex = hexPattern(tiledUV + vec2(u_time * 0.02, 0.0));

    vec4 ringColor = u_color;
    ringColor.rgb *= 1.0 - hex;

    gl_FragColor = vec4(ringColor.rgb, u_color.a);;
}