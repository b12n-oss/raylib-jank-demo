# window-flags

Toggle window state flags live with a bouncing ball.

Category: core. Controls: F/R/D/H/N/M/U/T/A/V/B toggle flags · ESC.

Ported from raylib's `examples/core/core_window_flags.c`.

![window-flags](../demos/window-flags.gif)

## Run it

```sh
cd window-flags && bb run   # from this demo (or lein run --disable-sandbox)
bb window-flags             # from the repo root
```

## About

raylib [core] example - window flags, ported to jank.

Toggle window state flags live and watch the effect. A ball bounces
inside the frame so resizing/maximizing is obvious. Keys:
  F fullscreen   R resizable   D undecorated   H hide (3s)
  N minimize (3s)   M maximize   U unfocused    T topmost
  A always-run   V vsync        B borderless    ESC quit
Some flags (HIGHDPI, TRANSPARENT, MSAA) can only be set before window
creation, so they stay off here.
Based on raylib/examples/core/core_window_flags.c

jank-native notes: every function here is by-value or no-arg, so the
port is a straight transcription. The bouncing ball can't be a native
Vector2 in loop/recur state (rule 2), so its position/speed are plain
jank reals and the Vector2 is built inline at the DrawCircleV call.
