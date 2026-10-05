# delta-time

Delta-time vs per-frame movement.

Category: core. Controls: WHEEL fps · R reset · Q.

Ported from raylib's `examples/core/core_delta_time.c`.

![delta-time](../demos/delta-time.gif)

## Run it

```sh
cd delta-time && bb run   # from this demo (or lein run --disable-sandbox)
bb delta-time             # from the repo root
```

## About

raylib [core] example - delta time, ported to jank.

Two circles race: the red one moves with delta time (frame-rate
independent), the blue one moves a fixed amount per frame. Change the
FPS target with the mouse wheel to see the difference; R resets, Q quits.
Based on raylib/examples/core/core_delta_time.c
