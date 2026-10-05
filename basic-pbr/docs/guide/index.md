# basic-pbr

The rusty car under physically-based rendering (PBR maps).

Category: shaders. Controls: 1-4 toggle lights, ESC.

Ported from raylib's `examples/shaders/shaders_basic_pbr.c`.

![basic-pbr](../demos/basic-pbr.gif)

## Run it

```sh
cd basic-pbr && bb run   # from this demo (or lein run --disable-sandbox)
bb basic-pbr             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - basic pbr, ported to jank.

Physically-based rendering: the rusty-car GLB under four colored
point lights, every surface driven by albedo + normal + MRA
(metalness/roughness/occlusion) + emissive texture maps through the
pbr shader pair. Keys 1-4 toggle the lights. Orbital camera. ESC
quits. Model: 'Old Rusty Car' by Renafox (CC BY-NC).
Based on raylib/examples/shaders/shaders_basic_pbr.c

jank-native notes:
- This example's lights carry an intensity field that rlights.h does
  not; rlights.jank takes it as an optional :intensity, so the whole
  lighting path is the shared namespace.
- Material map .color / .value / .texture writes go through
  models.jank; the per-model uniform values (tiling, emissive,
  metallic, roughness) are jank constants re-sent per frame, matching
  the C reads off the material.
- Teardown keeps the C's unbind dance (shader zeroed, material
  unloaded manually, maps NULLed) so the shared PBR shader is not
  double-freed. Each step is a cpp/= on the material field.
