# julia-set

A Julia set fractal computed in a fragment shader.

Category: shaders. Controls: mouse zoom/drift, 1-6 presets, LEFT/RIGHT speed, SPACE, R, F1, ESC.

Ported from raylib's `examples/shaders/shaders_julia_set.c`.

![julia-set](../demos/julia-set.gif)

## Run it

```sh
cd julia-set && bb run   # from this demo (or lein run --disable-sandbox)
bb julia-set             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - julia set, ported to jank.

A Julia set fractal computed entirely in a fragment shader: keys 1-6
jump to interesting c constants, LEFT/RIGHT change the animation speed
of c (SPACE pauses), mouse left/right buttons zoom in/out while
drifting toward the cursor, R recenters, F1 hides the help. ESC quits.
Based on raylib/examples/shaders/shaders_julia_set.c

jank-native notes:
- All fractal state (c, zoom, offset, speed) threads as jank reals;
  the three uniforms are re-sent every frame as plain SetShaderValue
  calls over cpp/new Vector2/float. The C only re-sends zoom/offset
  on change - re-sending every frame is visually identical and
  simpler.
- The C's pointsOfInterest float[6][2] is a jank vector of pairs.
