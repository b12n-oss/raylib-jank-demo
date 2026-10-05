# texture-tiling

A cube model with its texture tiled 3x3 by a shader.

Category: shaders. Controls: WASD + mouse look, Z retarget, ESC.

Ported from raylib's `examples/shaders/shaders_texture_tiling.c`.

![texture-tiling](../demos/texture-tiling.gif)

## Run it

```sh
cd texture-tiling && bb run   # from this demo (or lein run --disable-sandbox)
bb texture-tiling             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - texture tiling, ported to jank.

A generated cube model whose atlas texture is tiled 3x3 across each
face by the tiling.fs shader (TEXTURE_WRAP_REPEAT + scaled UVs).
Free camera: mouse look, WASD move, Z re-target. ESC quits.
Based on raylib/examples/shaders/shaders_texture_tiling.c

jank-native notes:
- THE MODEL BLOCKER FALLS: GenMeshCube -> LoadModelFromMesh ->
  DrawModel all work with zero wrapper changes - the Mesh and Model
  structs (pointers inside and all) bind as outer-let locals exactly
  like Font did in font-loading.
- The C's model.materials[0].maps[MATERIAL_MAP_DIFFUSE].texture and
  .shader field writes go through models.jank, which spells both
  with cpp/=.
- The Z camera re-target is the same cpp/= camera-3d-free uses.
