# textured-curve

A road texture swept along a draggable Bezier.

Category: textures. Controls: drag points · SPACE curve · +/- width · L/R segments · Q.

Ported from raylib's `examples/textures/textures_textured_curve.c`.

![textured-curve](../demos/textured-curve.gif)

## Run it

```sh
cd textured-curve && bb run   # from this demo (or lein run --disable-sandbox)
bb textured-curve             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - textured curve, ported to jank.

A road texture swept along a cubic Bezier spline as a strip of
textured quads. Drag the four control points (start, end, and their
two tangents) to reshape the road; SPACE shows/hides the base spline,
+/- change the road width, LEFT/RIGHT change the segment count. Q
quits.
Based on raylib/examples/textures/textures_textured_curve.c

jank-native notes:
- The C original tracks the dragged handle with a `Vector2*`; jank
  tracks it as an index (0-3, -1 = none) into a jank vector of the four
  [x y] control points, which lives in loop state. No pointer needed.
- DrawTexturedCurve is reimplemented with rlgl RL_QUADS: the Bezier
  point, the segment normal (for the strip width) and the running v
  texture coordinate are all computed in jank per segment.
- MSAA/VSYNC config flags from the C original are omitted (cosmetic);
  the road texture still gets a bilinear filter.
