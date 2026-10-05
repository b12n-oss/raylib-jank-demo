# camera-2d-split-screen

Two players, two cameras, split screen.

Category: core. Controls: W/S/A/D player 1 · ARROWS player 2 · Q quit.

Ported from raylib's `examples/core/core_2d_camera_split_screen.c`.

![camera-2d-split-screen](../demos/camera-2d-split-screen.gif)

## Run it

```sh
cd camera-2d-split-screen && bb run   # from this demo (or lein run --disable-sandbox)
bb camera-2d-split-screen             # from the repo root
```

## About

raylib [core] example - 2d camera split screen, ported to jank.

Two players roam one grid world, each rendered through its own camera
into its own half-screen RenderTexture. W/S/A/D moves player one
(red), the arrow keys move player two (blue), Q quits.
Based on raylib/examples/core/core_2d_camera_split_screen.c
(jank-native: the two RenderTextures live in a let outside the frame
loop and the cameras are built inline per view from threaded player
scalars.)
