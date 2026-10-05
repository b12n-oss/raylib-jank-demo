# cubicmap-rendering

A cube maze generated from a tiny black-and-white image.

Category: models. Controls: P pause orbit, ESC.

Ported from raylib's `examples/models/models_cubicmap_rendering.c`.

![cubicmap-rendering](../demos/cubicmap-rendering.gif)

## Run it

```sh
cd cubicmap-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb cubicmap-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - cubicmap rendering, ported to jank.

A maze of cubes generated from a tiny black-and-white image (white
pixel = wall cube, black = floor), textured from an atlas and
orbited by an auto camera; the source image shows top-right at 4x.
P pauses the orbit. ESC quits.
Based on raylib/examples/models/models_cubicmap_rendering.c

jank-native notes:
- GenMeshCubicmap(image, cubeSize) joins the proven GenMesh* set;
  same shape as heightmap-rendering (Image by value, Vector3
  inline, Mesh straight into LoadModelFromMesh).
- The pause flag threads through the loop as a jank bool gating
  UpdateCamera.
