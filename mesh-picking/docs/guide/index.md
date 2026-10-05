# mesh-picking

A mouse ray picks the closest quad/sphere/box/mesh.

Category: models. Controls: mouse aim, RIGHT CLICK camera, ESC.

Ported from raylib's `examples/models/models_mesh_picking.c`.

![mesh-picking](../demos/mesh-picking.gif)

## Run it

```sh
cd mesh-picking && bb run   # from this demo (or lein run --disable-sandbox)
bb mesh-picking             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - mesh picking, ported to jank.

A mouse ray tested against everything in the scene - ground quad,
a triangle, a wire sphere, the turret's bounding box and then its
actual MESH triangles - with the closest hit marked by a cube, its
surface normal drawn, and hit details printed. RIGHT CLICK toggles
first-person camera control. ESC quits.
Based on raylib/examples/models/models_mesh_picking.c

jank-native notes:
- The C accumulates the closest hit by reassigning a RayCollision
  struct; here each native result is BOXED into a jank map the
  moment it's read (hit?/dist/point/normal as reals) and the
  closest-hit logic runs over plain jank data, in the C's order.
- The per-mesh loop reads tower.meshes[m] with cpp/aget and keeps the
  RayCollision inside the let that produced it, boxing the fields out
  as jank numbers; first-hit-wins like the C.
- GetRayCollisionQuad/Triangle/Sphere with inline Vector3 args and
  Vector3Barycenter on the native point complete the collision-API
  coverage.
