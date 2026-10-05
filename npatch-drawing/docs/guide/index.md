# npatch-drawing

Stretchable 9-patch / 3-patch UI panels.

Category: textures. Controls: move mouse · Q quit.

Ported from raylib's `examples/textures/textures_npatch_drawing.c`.

![npatch-drawing](../demos/npatch-drawing.gif)

## Run it

```sh
cd npatch-drawing && bb run   # from this demo (or lein run --disable-sandbox)
bb npatch-drawing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - N-patch drawing, ported to jank.

Four N-patches drawn from one texture with DrawTextureNPatch: two
9-patches (stretch on both axes), one horizontal 3-patch and one
vertical 3-patch. Move the mouse to stretch/shrink them; the source
texture is shown at the left. Q quits.
Based on raylib/examples/textures/textures_npatch_drawing.c
(jank-native: the four NPatchInfo structs are built once as outer-let
locals - like a Camera3D - and reused; each frame's destination
Rectangle is built inline from the jank-int mouse position, so no
native value is carried in loop state.)
