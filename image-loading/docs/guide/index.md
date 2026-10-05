# image-loading

LoadImage (RAM) then LoadTextureFromImage (VRAM).

Category: textures. Controls: Q quit.

Ported from raylib's `examples/textures/textures_image_loading.c`.

![image-loading](../demos/image-loading.gif)

## Run it

```sh
cd image-loading && bb run   # from this demo (or lein run --disable-sandbox)
bb image-loading             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - image loading, ported to jank.

The two-step image path: LoadImage reads a PNG into CPU RAM, then
LoadTextureFromImage uploads it to GPU VRAM and the Image is freed.
(Contrast with logo-texture, which uses the one-step LoadTexture.)
Q quits.
Based on raylib/examples/textures/textures_image_loading.c
