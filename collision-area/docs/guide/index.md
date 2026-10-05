# collision-area

AABB collision between a bouncing + mouse box.

Category: shapes. Controls: mouse · SPACE pause · Q.

Ported from raylib's `examples/shapes/shapes_collision_area.c`.

![collision-area](../demos/collision-area.gif)

## Run it

```sh
cd collision-area && bb run   # from this demo (or lein run --disable-sandbox)
bb collision-area             # from the repo root
```

## About

raylib [shapes] example - collision area, ported to jank.

A gold box bounces horizontally; move the blue box with the mouse.
When they overlap the header turns red and the intersection is drawn.
SPACE pauses the gold box, Q quits.
Based on raylib/examples/shapes/shapes_collision_area.c
