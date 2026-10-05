# heightmap-rendering

Terrain generated from a grayscale heightmap image.

Category: models. Controls: ESC.

Ported from raylib's `examples/models/models_heightmap_rendering.c`.

![heightmap-rendering](../demos/heightmap-rendering.gif)

## Run it

```sh
cd heightmap-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb heightmap-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - heightmap rendering, ported to jank.

A terrain mesh generated from a grayscale heightmap image (pixel
brightness = elevation), textured with the same image and orbited
by an auto camera; the source heightmap shows top-right. ESC quits.
Based on raylib/examples/models/models_heightmap_rendering.c

jank-native notes:
- GenMeshHeightmap(image, size) is the third GenMesh* proven after
  the model unblock: the Image goes in by value, the Vector3 size
  inline, and the resulting Mesh feeds LoadModelFromMesh as a call
  argument. Material texture write via models.jank.
