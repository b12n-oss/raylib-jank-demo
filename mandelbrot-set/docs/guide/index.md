# mandelbrot-set

The Mandelbrot set in a shader, deep-zoom presets.

Category: shaders. Controls: mouse zoom/drift, 1-6 presets, UP/DOWN iterations, R, F1, ESC.

Ported from raylib's `examples/shaders/shaders_mandelbrot_set.c`.

![mandelbrot-set](../demos/mandelbrot-set.gif)

## Run it

```sh
cd mandelbrot-set && bb run   # from this demo (or lein run --disable-sandbox)
bb mandelbrot-set             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - mandelbrot set, ported to jank.

The Mandelbrot set in a fragment shader: keys 1-6 jump to deep-zoom
points of interest, mouse left/right buttons zoom in/out while
drifting toward the cursor, UP/DOWN change the iteration budget,
R recenters, F1 hides the help. ESC quits.
Based on raylib/examples/shaders/shaders_mandelbrot_set.c

jank-native notes:
- First INT uniform: cpp/new on a cpp/int gives SetShaderValue the
  pointer it wants, exactly as the float and vector cases do.
- The C's adaptive iteration formula (nested sqrtf/fabsf) becomes
  cpp/sqrt from math.h with an if-based abs; state (zoom, offset,
  iteration multiplier) threads as jank reals and uniforms re-send
  every frame (the julia-set simplification).
