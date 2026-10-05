# model-shader

The watermill OBJ drawn grayscale by a material shader.

Category: shaders. Controls: WASD + mouse look, ESC.

Ported from raylib's `examples/shaders/shaders_model_shader.c`.

![model-shader](../demos/model-shader.gif)

## Run it

```sh
cd model-shader && bb run   # from this demo (or lein run --disable-sandbox)
bb model-shader             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - model shader, ported to jank.

The watermill OBJ model drawn entirely in grayscale: the shader is
assigned to the model's MATERIAL, so it applies wherever the model
is drawn - no BeginShaderMode wrap needed. Free camera: mouse look,
WASD move. ESC quits.
Based on raylib/examples/shaders/shaders_model_shader.c

jank-native notes:
- The first model-based shader port after the Mesh/Model unblock:
  LoadModel(OBJ) + the material .shader / .texture field writes
  (models.jank, which spells both with cpp/=) are all it takes.
- SetConfigFlags(FLAG_MSAA_4X_HINT) before InitWindow works as a
  plain call with the C constant.
