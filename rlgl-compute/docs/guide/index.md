# rlgl-compute

Game of Life stepped entirely on the GPU by compute shaders.

Category: shaders. Controls: LEFT draw, RIGHT erase, WHEEL brush, ESC.

Ported from raylib's `examples/shaders/shaders_rlgl_compute.c`.

## Run it

```sh
cd rlgl-compute && bb run   # from this demo (or lein run --disable-sandbox)
bb rlgl-compute             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - rlgl compute, ported to jank.

Conway's Game of Life run ENTIRELY on the GPU: a compute shader
steps the world in two ping-ponged shader storage buffers, a second
compute shader stamps mouse strokes into the grid, and a fragment
shader renders the live cells. LEFT draws, RIGHT erases, WHEEL
changes the brush. ESC quits.
Based on raylib/examples/shaders/shaders_rlgl_compute.c

jank-native notes:
- FIRST COMPUTE SHADERS: requires jank-raylib-sys built with
  OPENGL_VERSION 4.3 (same GL 3.3 feature set + compute; flipped in
  the wrapper's jank-build.bb for this port).
- Compute programs load with direct rlgl calls (LoadFileText ->
  rlLoadShader RL_COMPUTE_SHADER -> rlLoadShaderProgramCompute);
  the intermediate shader ids are not kept for unload - the GL
  context teardown reclaims them (simplification vs the C).
- The mouse-command SSBO struct (count + 48 GolUpdateCmd) is a
  cpp/MemAlloc array behind a box; the grid
  SSBOs are plain unsigned-int ids held as JANK ints, so the
  classic ssboA<->ssboB ping-pong swap is just recur with the loop
  vars exchanged.
- rlEnableShader / rlBindShaderBuffer / rlComputeShaderDispatch are
  direct rlgl calls with jank-int ids.
