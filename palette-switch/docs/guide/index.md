# palette-switch

Palette-indexed bands recolored by a shader uniform.

Category: shaders. Controls: LEFT/RIGHT palette, ESC.

Ported from raylib's `examples/shaders/shaders_palette_switch.c`.

![palette-switch](../demos/palette-switch.gif)

## Run it

```sh
cd palette-switch && bb run   # from this demo (or lein run --disable-sandbox)
bb palette-switch             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - palette switch, ported to jank.

Eight horizontal bands whose gray values 0..7 are palette indices;
the palette_switch fragment shader maps each index to a color from
an 8-color palette uniform. LEFT/RIGHT switch between three
palettes (3-BIT RGB, AMMO-8, RKBV). ESC quits.
Based on raylib/examples/shaders/shaders_palette_switch.c

jank-native notes:
- First ARRAY uniform (SetShaderValueV, 8 x ivec3): the per-type
  scalar-setter pattern cannot take 24 components as args, so this
  revives the static staging buffer - an int[24] filled through an
  index setter from a flat jank vector, then one SetShaderValueV
  call with the element count. Restaged every frame, matching the C.
- The C's (Color){i,i,i,255} band colors become cpp/GetColor with a
  packed RGBA int built from the palette index.
