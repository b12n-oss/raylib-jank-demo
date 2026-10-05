# point-rendering

Up to 10 million points: GPU point mode vs per-point draws.

Category: models. Controls: UP/DOWN count, SPACE method, ESC.

Ported from raylib's `examples/models/models_point_rendering.c`.

![point-rendering](../demos/point-rendering.gif)

## Run it

```sh
cd point-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb point-rendering             # from the repo root
```

## About

raylib [models] example - point rendering, ported to jank.

A spherical point cloud (1 thousand to 10 MILLION points, UP/DOWN
scale by 10x) drawn two ways: SPACE toggles between one GPU
point-mode DrawModel call and the old per-point DrawPoint3D loop -
watch the FPS difference at high counts. Orbital camera. ESC quits.
Based on raylib/examples/models/models_point_rendering.c

jank-native notes:
- The point-cloud Model is REPLACED on every count change, so the
  Mesh + Model pair live as C statics behind load/draw/unload
  wrappers (the hot-reloading runtime-replaced-native pattern);
  the spherical generator (MemAlloc'd vertex/color arrays, rand())
  stays verbatim C.
- Both draw paths are shims: the new one wraps DrawModel in
  rlEnablePointMode, the old one walks mesh.vertices[]/colors[]
  calling DrawPoint3D per point.
