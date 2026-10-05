# mesh-instancing

Ten thousand lit cubes in one draw call (DrawMeshInstanced).

Category: shaders. Controls: ESC.

Ported from raylib's `examples/shaders/shaders_mesh_instancing.c`.

![mesh-instancing](../demos/mesh-instancing.gif)

## Run it

```sh
cd mesh-instancing && bb run   # from this demo (or lein run --disable-sandbox)
bb mesh-instancing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - mesh instancing, ported to jank.

Ten thousand cubes drawn in ONE draw call: DrawMeshInstanced streams
a per-instance transform array to the lighting_instancing vertex
shader (red, lit), flanked by two ordinary blue DrawMesh cubes for
contrast. Orbital camera. ESC quits.
Based on raylib/examples/shaders/shaders_mesh_instancing.c

jank-native notes:
- First DrawMeshInstanced + first bare-Material use: the 10k Matrix
  transform array is cpp/MemAlloc (640 KB) filled in jank (random
  translate x rotate through raymath), and the pointer goes straight
  to DrawMeshInstanced.
- LoadMaterialDefault returns a Material by value into a let-local;
  its .shader / .maps[].color writes are cpp/= on the field, exactly
  like the Model material pattern.
- DrawMesh takes the Mesh, Material and an inline MatrixTranslate
  all by value - direct call.
