# camera-3d-free

A free-look 3D camera around a cube.

Category: core. Controls: mouse look, WHEEL zoom, wheel-press pan, Z retarget, ESC.

Ported from raylib's `examples/core/core_3d_camera_free.c`.

![camera-3d-free](../demos/camera-3d-free.gif)

## Run it

```sh
cd camera-3d-free && bb run   # from this demo (or lein run --disable-sandbox)
bb camera-3d-free             # from the repo root
```

## About

raylib [core] example - 3d camera free, ported to jank.

A free-look 3D camera around a red cube: right-mouse drag to look,
mouse wheel to zoom, wheel-press to pan, Z re-targets the origin.
ESC quits (the cursor is captured while running).
Based on raylib/examples/core/core_3d_camera_free.c

jank-native notes:
- THE UpdateCamera(&camera, mode) blocker falls: (cpp/& camera) on the
  outer-let Camera3D forms the pointer (the image-processing address-of
  pattern) and the mutation PERSISTS across frames - the let-local is
  the same storage every loop iteration.
- The C's 'camera.target = {0,0,0}' field write is cpp/=, jank's
  assignment form, which takes an lvalue. The when-branch ends in an
  explicit nil, since cpp/= yields the assigned lvalue and a native
  reference cannot be returned.
