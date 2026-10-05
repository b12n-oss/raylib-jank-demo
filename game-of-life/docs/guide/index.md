# game-of-life

Conway's Life on a 2048x2048 world: pan/zoom, presets.

Category: shaders. Controls: 1-9/0 presets, R/P/D mode, Z/X zoom, F/S speed, drag pan, ESC.

Ported from raylib's `examples/shaders/shaders_game_of_life.c`.

![game-of-life](../demos/game-of-life.gif)

## Run it

```sh
cd game-of-life && bb run   # from this demo (or lein run --disable-sandbox)
bb game-of-life             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - game of life, ported to jank.

Conway's Game of Life on a 2048x2048 world, stepped by a FRAGMENT
shader ping-ponging two render textures (the compute-free cousin of
rlgl-compute). Explore with pan (drag) + zoom (wheel or Z/X), load
preset patterns with keys 1-9 and 0 (random soup), R runs, P
pauses, D enters draw mode (paint cells with the mouse), F/S change
the simulation speed. ESC quits.
Based on raylib/examples/shaders/shaders_game_of_life.c

jank-native notes:
- The raygui side panel becomes keyboard controls + a drawn key
  legend (the raygui-to-keyboard repo pattern).
- The two ping-ponged worlds are RenderTexture let-locals selected
  per frame by a jank flip? bool - (if flip? world1 world2) binds
  the native by branch, nothing native crosses recur.
- Draw mode's Image snapshot (LoadImageFromTexture, GetImageColor
  stroke color-lock, ImageDrawPixel, UpdateTextureRec upload) and the
  preset/random-soup loaders are jank over an Image held boxed.
- Pan state (previous mouse position) and the stroke color reset
  thread as jank loop vars.
