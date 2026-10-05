# animation-blending

SPACE cross-fades the robot between two animations.

Category: models. Controls: SPACE blend, LEFT/RIGHT + UP/DOWN anims, Z/X + N/M speeds, P, ESC.

Ported from raylib's `examples/models/models_animation_blending.c`.

![animation-blending](../demos/animation-blending.gif)

## Run it

```sh
cd animation-blending && bb run   # from this demo (or lein run --disable-sandbox)
bb animation-blending             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - animation blending, ported to jank.

Two robot animations cross-faded on demand: SPACE starts a 2-second
blend from the playing animation to the other one (both advance
during the fade). LEFT/RIGHT pick animation A, UP/DOWN animation B,
Z/X and N/M change their speeds, P pauses. Two timelines + a blend
progress bar at the bottom. Orbital camera. ESC quits.
Based on raylib/examples/models/models_animation_blending.c

jank-native notes:
- First UpdateModelAnimationEx: both animations are cpp/aget off the
  ModelAnimation array, with both fractional frames and the blend
  factor as cpp/floats.
- The raygui dropdowns/sliders/progress bars become keyboard
  controls + hand-drawn bars (the animation-timing pattern).
- The C's SUPPORT_GPU_SKINNING block is compiled out by default
  (CPU skinning) - same here. The blend-direction progress-bar
  styling is simplified to a single left-to-right bar.
