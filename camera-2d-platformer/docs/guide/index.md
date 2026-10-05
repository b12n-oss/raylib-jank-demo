# camera-2d-platformer

A platformer with 5 camera-follow modes.

Category: core. Controls: LEFT/RIGHT move · SPACE jump · WHEEL zoom · C camera · R reset · Q quit.

Ported from raylib's `examples/core/core_2d_camera_platformer.c`.

![camera-2d-platformer](../demos/camera-2d-platformer.gif)

## Run it

```sh
cd camera-2d-platformer && bb run   # from this demo (or lein run --disable-sandbox)
bb camera-2d-platformer             # from the repo root
```

## About

raylib [core] example - 2d camera platformer, ported to jank.

A tiny platformer: LEFT/RIGHT move the red player, SPACE jumps,
mouse wheel zooms, C cycles five camera-follow modes, R resets
position + zoom, Q quits.
Based on raylib/examples/core/core_2d_camera_platformer.c
(jank-native: the camera is threaded as plain scalars [target offset
zoom] and, since rotation is always 0 here, the raymath and
GetWorldToScreen2D/GetScreenToWorld2D calls reduce to
screen = (world - target)*zoom + offset, done in jank math.)
