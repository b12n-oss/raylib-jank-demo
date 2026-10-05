# to-image

Round-trip an image VRAM<->RAM (LoadImageFromTexture).

Category: textures. Controls: watch · Q quit.

Ported from raylib's `examples/textures/textures_to_image.c`.

![to-image](../demos/to-image.gif)

## Run it

```sh
cd to-image && bb run   # from this demo (or lein run --disable-sandbox)
bb to-image             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - to image, ported to jank.

Round-trips the raylib logo VRAM<->RAM: an image becomes a texture,
the texture is read back to an image with LoadImageFromTexture, and
that image becomes a texture again - proving the GPU->CPU readback.
Q quits.
Based on raylib/examples/textures/textures_to_image.c

jank-native: pure by-value Image/Texture round-trips, each held as a
let-local; no pointers needed.
