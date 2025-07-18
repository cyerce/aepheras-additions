attribute vec3 a_position;
attribute vec2 a_texCoord0;

uniform mat4 u_proj;
uniform mat4 u_view;
uniform mat4 u_rotation;

varying vec2 v_uv;
varying vec3 v_worldPos;

void main(){
    vec4 world = u_rotation * vec4(a_position, 1.0);
    v_worldPos = world.xyz;
    v_uv = a_texCoord0;

    gl_Position = u_proj * u_view * world;
}