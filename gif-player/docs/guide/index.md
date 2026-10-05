# gif-player

An animated GIF streamed frame-by-frame to a texture.

Category: textures. Controls: RIGHT/LEFT change speed · Q.

Ported from raylib's `examples/textures/textures_gif_player.c`.

![gif-player](../demos/gif-player.gif)

## Run it

```sh
cd gif-player && bb run   # from this demo (or lein run --disable-sandbox)
bb gif-player             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - gif player, ported to jank.

An animated GIF loaded as one Image holding every frame back-to-back
in image.data; each frame is streamed to a single texture with
UpdateTexture by pointing at that frame's byte offset. RIGHT/LEFT
change the frame delay. Q quits. Scarfy sprite by Eiden Marsal.
Based on raylib/examples/textures/textures_gif_player.c

jank-native notes (this proves two new pointer techniques):
- LoadImageAnim writes the frame count through an `int *frames`
  out-param. jank makes a native int (`(cpp/int 0)`), passes its
  address with `(cpp/& frames)`, then boxes it back for the loop.
- The next frame's pixels live at `image.data + w*h*4*frame`. `cpp/cast`
  cannot reinterpret `void*` -> `unsigned char*` (it goes through
  `convert`), but `cpp/unsafe-cast` is C-style casting and can, so the
  cast and the arithmetic are both plain jank and the frame pointer goes
  straight to UpdateTexture.
