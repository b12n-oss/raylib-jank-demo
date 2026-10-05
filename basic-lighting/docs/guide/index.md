# basic-lighting

A plane + cube lit by four toggleable colored point lights.

Category: shaders. Controls: Y/R/G/B toggle lights, ESC.

Ported from raylib's `examples/shaders/shaders_basic_lighting.c`.

![basic-lighting](../demos/basic-lighting.gif)

## Run it

```sh
cd basic-lighting && bb run   # from this demo (or lein run --disable-sandbox)
bb basic-lighting             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - basic lighting, ported to jank.

A white plane and cube lit by four colored point lights under the
lighting.vs/lighting.fs shader pair, orbital camera. Keys Y/R/G/B
toggle the yellow/red/green/blue lights (spheres mark them; wire
spheres are off). ESC quits.
Based on raylib/examples/shaders/shaders_basic_lighting.c

jank-native notes:
- Lighting comes from net.b12n.raylib-jnk.rlights, a plain jank namespace.
  It used to be a C header shipped by the -sys wrapper; nothing about
  it needed C once cpp/new was available to produce the pointers
  SetShaderValue wants. See docs/guide/native-value-lifetimes.md.
- The C original writes shader.locs[SHADER_LOC_VECTOR_VIEW] and reads it
  back each frame. That is the example's own bookkeeping - raylib never
  reads that slot itself - so this keeps the location in a jank local
  and skips the write, which jank has no syntax for anyway.
