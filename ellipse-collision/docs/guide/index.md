# ellipse-collision

Overlap test between two ellipses.

Category: shapes. Controls: mouse · A/B switch · Q quit.

Ported from raylib's `examples/shapes/shapes_ellipse_collision.c`.

![ellipse-collision](../demos/ellipse-collision.gif)

## Run it

```sh
cd ellipse-collision && bb run   # from this demo (or lein run --disable-sandbox)
bb ellipse-collision             # from the repo root
```

## About

raylib [shapes] example - ellipse collision, ported to jank.

Two ellipses; move one with the mouse and press A/B to switch which one
you control. They turn red when they overlap. Q quits.
Based on raylib/examples/shapes/shapes_ellipse_collision.c
(jank-native: C sqrt/atan2/cos/sin for the radial ellipse-overlap test).
