# rlgl-triangle

A rainbow triangle via rlgl immediate mode.

Category: shapes. Controls: drag corners · SPACE lines · L/R culling · R reset · Q.

Ported from raylib's `examples/shapes/shapes_rlgl_triangle.c`.

![rlgl-triangle](../demos/rlgl-triangle.gif)

## Run it

```sh
cd rlgl-triangle && bb run   # from this demo (or lein run --disable-sandbox)
bb rlgl-triangle             # from the repo root
```

## About

raylib [shapes] example - rlgl triangle, ported to jank.

A rainbow-vertex triangle drawn with the low-level rlgl immediate
mode. Drag the corner handles with the mouse, SPACE toggles
lines/filled mode, LEFT/RIGHT enable/disable backface culling,
R resets, Q quits.
Based on raylib/examples/shapes/shapes_rlgl_triangle.c
(jank-native: FIRST rlgl example - rlgl.h is already installed
next to raylib.h by jank-raylib-sys, so (:include "rlgl.h") is all
it takes; rlBegin/rlColor4ub/rlVertex2f/rlEnd work directly. The
C's GetMouseDelta returns a native Vector2, so the drag delta is
computed from a threaded previous mouse position instead.)
