# skybox-rendering

A cubemap skybox drawn from inside a unit cube.

Category: models. Controls: WASD + mouse look, ESC.

Ported from raylib's `examples/models/models_skybox_rendering.c`.

![skybox-rendering](../demos/skybox-rendering.gif)

## Run it

```sh
cd skybox-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb skybox-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - skybox rendering, ported to jank.

A cubemap skybox wrapped around the world: a unit cube drawn from
the INSIDE (backface culling + depth writes off) through the skybox
shader, its texture a TextureCubemap loaded from a six-face layout
image. First-person camera (WASD + mouse). ESC quits.
Based on raylib/examples/models/models_skybox_rendering.c

jank-native notes:
- First LoadTextureCubemap: Image in by value + the layout enum,
  a Texture back - bound to MATERIAL_MAP_CUBEMAP via models.jank's
  set-map-texture!. rlDisableBackfaceCulling / rlDisableDepthMask around the
  draw are direct rlgl calls.
- Simplifications vs the C (both off by default there): the HDR
  panorama->cubemap path (GenTextureCubemap render-to-cubemap) and
  the drag&drop skybox swap are dropped.
