# tiled-drawing

Tile a texture pattern with scale/rotation/color.

Category: textures. Controls: click pattern/color · UP/DOWN scale · L/R rotation · SPACE reset · Q.

Ported from raylib's `examples/textures/textures_tiled_drawing.c`.

![tiled-drawing](../demos/tiled-drawing.gif)

## Run it

```sh
cd tiled-drawing && bb run   # from this demo (or lein run --disable-sandbox)
bb tiled-drawing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - tiled drawing, ported to jank.

Tile a chosen sub-pattern of a texture across a panel, with live
scale (UP/DOWN), rotation (LEFT/RIGHT) and a click-to-pick pattern
and color. SPACE resets, Q quits.
Based on raylib/examples/textures/textures_tiled_drawing.c
(jank-native: the C's DrawTextureTiled is an in-example helper, not
a raylib API. It is reimplemented INLINE in the frame loop rather
than as a fn, because a native Texture2D passed as a jank fn
parameter is boxed to object_ref and the cpp call then rejects it -
natives must stay let-locals / inline call args. Patterns and
colors are jank vectors of data; the window is fixed-size.)
