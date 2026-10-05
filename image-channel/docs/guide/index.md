# image-channel

RGBA channels split + alpha-masked.

Category: textures. Controls: watch · Q quit.

Ported from raylib's `examples/textures/textures_image_channel.c`.

![image-channel](../demos/image-channel.gif)

## Run it

```sh
cd image-channel && bb run   # from this demo (or lein run --disable-sandbox)
bb image-channel             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - image channel, ported to jank.

The fudesumi sprite split into its R, G, B and A channels with
ImageFromChannel; each colour channel is alpha-masked by the sprite's
own alpha, then all five (plus the original) are drawn over a checked
background. Q quits. Fudesumi sprite by Eiden Marsal.
Based on raylib/examples/textures/textures_image_channel.c

jank-native: ImageFromChannel / GenImageChecked return Images by
value (bound to let-locals); ImageAlphaMask takes an Image* formed
with (cpp/& img). The sprite's width/height are captured as jank ints
before UnloadImage, since the freed struct can't be read afterward.
