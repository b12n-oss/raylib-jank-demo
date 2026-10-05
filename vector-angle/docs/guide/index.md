# vector-angle

Two ways to measure an angle.

Category: shapes. Controls: mouse · SPACE mode · RIGHT move · Q.

Ported from raylib's `examples/shapes/shapes_vector_angle.c`.

![vector-angle](../demos/vector-angle.gif)

## Run it

```sh
cd vector-angle && bb run   # from this demo (or lein run --disable-sandbox)
bb vector-angle             # from the repo root
```

## About

raylib [shapes] example - vector angle, ported to jank.

Shows two ways to measure an angle. MODE 0: the angle between line
v0->v1 and line v0->v2 (right-click moves v1). MODE 1: the angle of
line v0->v2 from horizontal. SPACE switches mode, Q quits.
Based on raylib/examples/shapes/shapes_vector_angle.c
(jank-native: Vector2Angle/Vector2LineAngle reimplemented via C atan2).
