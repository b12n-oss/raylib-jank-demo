# image-text

Text baked into an image with a TTF font.

Category: textures. Controls: SPACE = atlas · Q quit.

Ported from raylib's `examples/textures/textures_image_text.c`.

![image-text](../demos/image-text.gif)

## Run it

```sh
cd image-text && bb run   # from this demo (or lein run --disable-sandbox)
bb image-text             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - image text, ported to jank.

A TTF font (KAISG) is rasterized at load, then text is baked INTO the
parrots image with ImageDrawTextEx before it becomes a texture. The
same string is also drawn live below with DrawTextEx; hold SPACE to
instead show the font's glyph atlas. Q quits.
Based on raylib/examples/textures/textures_image_text.c

jank-native: ImageDrawTextEx takes an Image* first arg, formed with
(cpp/& parrots) on the mutable let-local; the font's .baseSize is
nth-boxed for the cpp/float size arg and its .-texture field is read
for the atlas view.
