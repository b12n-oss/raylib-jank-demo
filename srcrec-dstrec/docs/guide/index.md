# srcrec-dstrec

Rotate + scale a sprite frame (DrawTexturePro).

Category: textures. Controls: Q quit.

Ported from raylib's `examples/textures/textures_srcrec_dstrec.c`.

![srcrec-dstrec](../demos/srcrec-dstrec.gif)

## Run it

```sh
cd srcrec-dstrec && bb run   # from this demo (or lein run --disable-sandbox)
bb srcrec-dstrec             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - srcrec dstrec, ported to jank.

One frame of the scarfy spritesheet drawn with DrawTexturePro:
the source rectangle picks the frame, the destination rectangle
scales it 2x at screen center, and the origin makes it spin in
place (rotation increments every frame). Q quits.
Scarfy sprite by Eiden Marsal.
Based on raylib/examples/textures/textures_srcrec_dstrec.c
(jank-native: all rectangles/vectors are built inline as call
arguments each frame; only the rotation int threads the loop.)
