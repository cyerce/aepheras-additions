#ifdef GL_ES
precision mediump float;
#endif

varying vec2 v_texCoord;
uniform vec4 u_color;

void main() {
    gl_FragColor = u_color;
}