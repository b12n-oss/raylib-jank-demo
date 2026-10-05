# ball-physics

Grab and throw balls under gravity.

Category: shapes. Controls: drag · RIGHT spawn · WHEEL gravity · MIDDLE shake · Q.

Ported from raylib's `examples/shapes/shapes_ball_physics.c`.

![ball-physics](../demos/ball-physics.gif)

## Run it

```sh
cd ball-physics && bb run   # from this demo (or lein run --disable-sandbox)
bb ball-physics             # from the repo root
```

## About

raylib [shapes] example - ball physics, ported to jank.

Grab a ball with the mouse and throw it by releasing. Right-click to
spawn a new ball, mouse wheel changes gravity, middle-click shakes.
Q quits. Based on raylib/examples/shapes/shapes_ball_physics.c
(jank-native: C hypot, ColorFromHSV per-ball hue, scalar drawing).
