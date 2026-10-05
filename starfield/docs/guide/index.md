# starfield

A perspective starfield flying at you.

Category: shapes. Controls: MOUSE WHEEL · SPACE mode · Q.

Ported from raylib's `examples/shapes/shapes_starfield_effect.c`.

![starfield](../demos/starfield.gif)

## Run it

```sh
cd starfield && bb run   # from this demo (or lein run --disable-sandbox)
bb starfield             # from the repo root
```

## About

raylib [shapes] example - starfield effect, ported to jank.

Stars fly toward the camera with a simple perspective projection.
MOUSE WHEEL changes speed, SPACE toggles lines/circles, Q quits.
Based on raylib/examples/shapes/shapes_starfield_effect.c
