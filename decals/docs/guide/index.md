# decals

Click to splat logo decals onto a character's surface.

Category: models. Controls: CLICK splat, RMB-hold camera, H model, C clear, ESC.

Ported from raylib's `examples/models/models_decals.c`.

![decals](../demos/decals.gif)

## Run it

```sh
cd decals && bb run   # from this demo (or lein run --disable-sandbox)
bb decals             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - decals, ported to jank.

Click to SPLAT raylib-logo decals onto a character model: the mouse
ray picks the surface, a projection box is clipped against the mesh
triangles and the clipped geometry becomes a new little decal model
hugging the surface (up to 256). A translucent green cube previews
the placement. HOLD RIGHT MOUSE to move the camera, H hides the
model (decals only!), C clears the decals. ESC quits.
Based on raylib/examples/models/models_decals.c

jank-native notes:
- The mesh clipper's two working buffers were hand-grown MemAlloc arrays
  in the C. Here they are ordinary jank vectors of [x y z], so the
  capacity doubling and the memcpy disappear. Decal generation happens on
  click, not per frame, so the vector churn is affordable.
- Three things stay native: the decal Models (boxed in a jank atom, since
  each is created at runtime and must persist), the shared decal
  Material, and the Mesh handed to LoadModelFromMesh, which is built and
  consumed inside one let.
- A Matrix cannot be a jank fn parameter, so the projection travels boxed.
- Material and Model field writes are cpp/=; the ray-versus-model scan
  keeps each RayCollision inside the let that produced it and hands out
  plain numbers.
