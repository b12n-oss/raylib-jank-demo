# kaleidoscope

Draw strokes mirrored with 6-fold symmetry.

Category: shapes. Controls: LEFT mouse draw · L/R history · R reset · Q quit.

Ported from raylib's `examples/shapes/shapes_kaleidoscope.c`.

![kaleidoscope](../demos/kaleidoscope.gif)

## Run it

```sh
cd kaleidoscope && bb run   # from this demo (or lein run --disable-sandbox)
bb kaleidoscope             # from the repo root
```

## About

raylib [shapes] example - kaleidoscope, ported to jank.

Draw with the LEFT mouse button and every stroke is repeated with
6-fold symmetry plus a mirror image. LEFT/RIGHT arrows step back and
forward through the drawing history, R resets, Q quits. Runs at the
C's deliberate 20 FPS drawing cadence.
Based on raylib/examples/shapes/shapes_kaleidoscope.c
(jank-native: the static Line array becomes a vector of segment
maps; Vector2Rotate/Multiply are inline math; the raygui buttons
become keys; and the C's outer symmetry loop that redraws identical
lines s times is drawn once - the symmetry is already baked into the
stored lines.)
