# math-sine-cosine

A live unit-circle trig visualization.

Category: shapes. Controls: SPACE pause · L/R scrub angle · Q quit.

Ported from raylib's `examples/shapes/shapes_math_sine_cosine.c`.

![math-sine-cosine](../demos/math-sine-cosine.gif)

## Run it

```sh
cd math-sine-cosine && bb run   # from this demo (or lein run --disable-sandbox)
bb math-sine-cosine             # from the repo root
```

## About

raylib [shapes] example - math sine cosine, ported to jank.

A unit-circle visualization: sine, cosine, tangent and cotangent
drawn live on a rotating angle, with the sine/cosine waves plotted
in a mini graph. SPACE pauses, hold LEFT/RIGHT to scrub the angle,
Q quits.
Based on raylib/examples/shapes/shapes_math_sine_cosine.c
(jank-native: DrawSplineLinear needs a Vector2* array, which jank
can't build, so the waves draw as per-segment DrawLineEx lines over
the same 36 precomputed points; raymath's Clamp/Wrap are inline jank
math; the raygui angle slider/pause toggle become keys; the degree
sign in labels becomes 'deg' to keep the source ASCII.)
