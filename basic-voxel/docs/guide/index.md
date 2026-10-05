# basic-voxel

An 8x8x8 voxel grid; click to ray-pick and remove.

Category: models. Controls: LEFT/RIGHT spin, click remove, R refill, ESC.

Ported from raylib's `examples/models/models_basic_voxel.c`.

![basic-voxel](../demos/basic-voxel.gif)

## Run it

```sh
cd basic-voxel && bb run   # from this demo (or lein run --disable-sandbox)
bb basic-voxel             # from the repo root
```

## About

raylib [models] example - basic voxel, ported to jank.

An 8x8x8 grid of beige cubes. Left-click a cube to cast a ray into the
world and remove the nearest hit voxel; LEFT/RIGHT spin the camera and R
refills the grid. ESC quits.
Based on raylib/examples/models/models_basic_voxel.c

jank-native notes (three forced substitutions, each with precedent):
- The C's `UpdateCamera(&camera, CAMERA_FIRST_PERSON)` takes a pointer
  jank cannot form, so the camera is an ORBITAL one rebuilt inline each
  frame from a jank-tracked angle (the billboard-rendering pattern).
  Picking follows: instead of a fixed screen-centre crosshair the ray is
  cast from the MOUSE position (the picking-3d pattern), which suits an
  orbital view better.
- The C's `LoadModelFromMesh(GenMeshCube(...))` tinted BEIGE and drawn
  with `DrawModel` is visually identical to a plain `DrawCube ... BEIGE`
  (the mesh is untextured), so no Model/Mesh loading is needed - the one
  blocker class left in `models`. `DrawCubeWires ... BLACK` outlines each.
- The `bool voxels[8][8][8]` becomes a flat 512-slot jank vector of bools
  indexed by `x*64 + y*8 + z` (the fog-of-war flat-grid pattern); removal
  is an `assoc idx false`. No native struct array, no ray/collision value
  carried across frames - `.-hit`/`.-distance` are read into jank
  bools/reals inside the pick loop and discarded.
