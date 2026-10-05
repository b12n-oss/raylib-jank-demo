# billboard-rendering

Camera-facing billboards + an orbiting camera.

Category: models. Controls: watch · Q quit.

Ported from raylib's `examples/models/models_billboard_rendering.c`.

![billboard-rendering](../demos/billboard-rendering.gif)

## Run it

```sh
cd billboard-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb billboard-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - billboard rendering, ported to jank.

Two camera-facing billboards over a grid - one static (DrawBillboard)
and one spinning around its center (DrawBillboardPro) - while the
camera orbits the scene. Draw order flips by distance so the nearer
one composites over the farther one. Q quits.
Based on raylib/examples/models/models_billboard_rendering.c
(jank-native: the C's UpdateCamera(&camera, CAMERA_ORBITAL) needs a
pointer jank cannot form, so the orbit is done by REBUILDING the
Camera3D inline each frame from a jank-tracked angle - the
per-frame-camera pattern. Distances come from scalar jank math.)
