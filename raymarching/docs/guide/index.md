# raymarching

A raymarched SDF scene with a first-person fly-cam.

Category: shaders. Controls: WASD move, mouse look, Q/E down/up, ESC.

Ported from raylib's `examples/shaders/shaders_raymarching_rendering.c`.

![raymarching](../demos/raymarching.gif)

## Run it

```sh
cd raymarching && bb run   # from this demo (or lein run --disable-sandbox)
bb raymarching             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - raymarching rendering, ported to jank.

A raymarched scene (Inigo Quilez's SDF primitives, MIT) rendered
entirely in a fragment shader over a single full-screen rectangle.
The camera is a first-person fly-cam: move with W/A/S/D, look with
the mouse, Q/E down/up. ESC quits (cursor is captured while running).
Based on raylib/examples/shaders/shaders_raymarching_rendering.c

jank-native notes:
- First VEC3 uniforms: the eye/target camera vectors, read off the
  camera with .-position / .-target and pushed through shaders.jank.
- runTime accumulates as a plain jank double threaded through recur;
  the per-frame GetFrameTime is boxed via (+ 0.0 ...) before adding.
- Simplification vs the C: the window is a fixed size, so the
  resolution uniform is set once and the FLAG_WINDOW_RESIZABLE /
  IsWindowResized re-send path is dropped.
