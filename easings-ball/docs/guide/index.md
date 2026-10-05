# easings-ball

A ball animated through easing stages.

Category: shapes. Controls: ENTER replay · R restart · Q quit.

Ported from raylib's `examples/shapes/shapes_easings_ball.c`.

![easings-ball](../demos/easings-ball.gif)

## Run it

```sh
cd easings-ball && bb run   # from this demo (or lein run --disable-sandbox)
bb easings-ball             # from the repo root
```

## About

raylib [shapes] example - easings ball, ported to jank.

A ball animates through three easing stages: elastic slide-in, elastic
grow, then a cubic fade to green. ENTER replays, R restarts the current
stage, Q quits. Based on raylib/examples/shapes/shapes_easings_ball.c
(jank-native: easing fns from reasings.h via C pow/sin).
