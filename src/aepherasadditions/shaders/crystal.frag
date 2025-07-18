precision mediump float;

varying vec2 v_texCoords;

void main() {

    gl_FragColor = vec4(v_texCoords, 0.0, 1.0);
}