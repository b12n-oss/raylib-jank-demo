# deferred-rendering

A three-target G-buffer + deferred lighting pass.

Category: shaders. Controls: Y/R/G/B lights, 1-4 views, ESC.

Ported from raylib's `examples/shaders/shaders_deferred_rendering.c`.

![deferred-rendering](../demos/deferred-rendering.gif)

## Run it

```sh
cd deferred-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb deferred-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - deferred rendering, ported to jank.

A deferred pipeline: the scene renders once into a three-target
G-buffer (world position, normal, albedo+specular), then a
full-screen quad shades every pixel from those textures under four
toggleable point lights (Y/R/G/B). Keys 1/2/3/4 show the raw
position / normal / albedo textures / the final shading. Orbital
camera. ESC quits.
Based on raylib/examples/shaders/shaders_deferred_rendering.c

jank-native notes:
- First MULTI-RENDER-TARGET framebuffer: the G-buffer (3 color
  textures + depth renderbuffer, rlActiveDrawBuffers 3) is built with
  direct rlgl calls, its ids held as plain jank ints since GL names are
  unsigned ints and cross a fn boundary freely.
- The debug views draw a Texture2D assembled with cpp/new from a raw
  GL id.
- Lights ride the rlights namespace against the deferred shader; the 30
  random cubes are a jank vector of maps drawn with DrawModelEx.
