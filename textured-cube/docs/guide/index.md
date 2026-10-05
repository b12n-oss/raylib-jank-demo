# textured-cube

Two rlgl textured 3D cubes from a shared atlas.

Category: models. Controls: ESC.

Ported from raylib's `examples/models/models_textured_cube.c`.

![textured-cube](../demos/textured-cube.gif)

## Run it

```sh
cd textured-cube && bb run   # from this demo (or lein run --disable-sandbox)
bb textured-cube             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - textured cube, ported to jank.

Two textured cubes drawn with rlgl immediate mode from a shared
atlas: the left cube maps the whole texture across each face, the
right cube maps only the bottom-left quarter (a texture-source
rectangle). A static perspective camera looks down at both. ESC quits.
Based on raylib/examples/models/models_textured_cube.c
(DrawCubeTexture / DrawCubeTextureRec are example-local helpers,
reimplemented here.)

jank-native notes:
- No UpdateCamera here (static camera), so this 3D example doesn't hit
  the pointer-camera blocker - the Camera3D is an outer-let local.
- The cube-draw functions can't take the native Texture2D by value
  (rule 2), so they receive the already-read texture id (+ normalized
  source coords for the Rec variant) as jank data. rlSetTexture takes
  the boxed id fine (function coercion).
- `tv` bundles an rlTexCoord2f + rlVertex3f pair; its (u v x y z)
  signature is a graphics-primitive one (mirrors the two rl* calls),
  so it stays positional despite >3 args.
