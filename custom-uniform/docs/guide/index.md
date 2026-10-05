# custom-uniform

A mouse-steered swirl over a render-textured scene.

Category: shaders. Controls: move the mouse, ESC.

Ported from raylib's `examples/shaders/shaders_custom_uniform.c`.

![custom-uniform](../demos/custom-uniform.gif)

## Run it

```sh
cd custom-uniform && bb run   # from this demo (or lein run --disable-sandbox)
bb custom-uniform             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - custom uniform (swirl), ported to jank.

A swirl post-process distorts a 3D scene around the mouse. The scene
is rendered to a RenderTexture, then drawn back through the swirl
fragment shader whose 'center' VEC2 uniform tracks the cursor. The
camera orbits automatically. ESC quits.
Based on raylib/examples/shaders/shaders_custom_uniform.c

jank-native notes:
- Postprocess over a RenderTexture (vs color-correction's direct
  DrawTexture): the scene is drawn into `target` under BeginTextureMode,
  then the whole target.texture is drawn once through BeginShaderMode,
  y-flipped via a negative-height source Rectangle.
- The single custom uniform 'center' is a VEC2 following the mouse,
  pushed through the same scalar C setter the other shader ports use.
- Intentional simplification: the C loads an OBJ model (barracks.obj)
  which needs the still-blocked LoadModel path. The swirl only needs
  *something* in the render texture, so the scene is a handful of
  DrawCube primitives + a grid (the basic-voxel 'DrawModel reduces to
  DrawCube' precedent). The postprocess pipeline is unchanged.
