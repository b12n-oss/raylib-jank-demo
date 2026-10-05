# loading-gltf

The animated glTF robot, switchable animations.

Category: models. Controls: LEFT/RIGHT animation, ESC.

Ported from raylib's `examples/models/models_loading_gltf.c`.

![loading-gltf](../demos/loading-gltf.gif)

## Run it

```sh
cd loading-gltf && bb run   # from this demo (or lein run --disable-sandbox)
bb loading-gltf             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - loading gltf, ported to jank.

The animated glTF robot: LEFT/RIGHT switch between its animations
(idle, walk, dance, ...) with the current one's name on screen,
orbital camera. ESC quits.
Based on raylib/examples/models/models_loading_gltf.c

jank-native notes:
- LoadModelAnimations returns the array and writes its count through
  an int* out-param; both bind in the outer let, so nothing has to
  live in a static. Plus one addition: the animation's char[32] name field folds to a jank
  string through a const-char*-returning accessor.
- The animation index and frame counter thread as jank ints; the
  frame wraps by the CURRENT animation's keyframe count.
