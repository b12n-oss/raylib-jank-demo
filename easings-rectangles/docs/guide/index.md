# easings-rectangles

A grid shrinks and spins via easing fns.

Category: shapes. Controls: SPACE replay · Q quit.

Ported from raylib's `examples/shapes/shapes_easings_rectangles.c`.

![easings-rectangles](../demos/easings-rectangles.gif)

## Run it

```sh
cd easings-rectangles && bb run   # from this demo (or lein run --disable-sandbox)
bb easings-rectangles             # from the repo root
```

## About

raylib [shapes] example - easings rectangles, ported to jank.

A grid of rectangles shrinks to nothing while rotating, driven by
easing functions. Press SPACE to replay, Q to quit.
Based on raylib/examples/shapes/shapes_easings_rectangles.c
(jank-native: C sqrt, Rectangle + Vector2 structs built inline for
DrawRectanglePro).
