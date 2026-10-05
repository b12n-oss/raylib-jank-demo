# top-down-lights

2D lights casting shadow volumes off boxes.

Category: shapes. Controls: drag light 1 · RIGHT add light · L debug view · Q quit.

Ported from raylib's `examples/shapes/shapes_top_down_lights.c`.

![top-down-lights](../demos/top-down-lights.gif)

## Run it

```sh
cd top-down-lights && bb run   # from this demo (or lein run --disable-sandbox)
bb top-down-lights             # from the repo root
```

## About

raylib [shapes] example - top down lights, ported to jank.

Top-down 2D lighting: lights cast shadow volumes off boxes into a
blended alpha mask over a checkerboard floor. Drag to move light 1,
RIGHT-click adds a light (up to 16), L toggles the shadow-volume
debug view, Q quits.
Based on raylib/examples/shapes/shapes_top_down_lights.c
(jank-native: the C caches one mask RenderTexture per light and
re-renders only dirty ones; native handles can't live in a jank
vector, so this port keeps ONE scratch mask reused per light plus
the global mask, and rebuilds all lights whenever any is dirty.
Shadow quads come from a pure fn of light position + boxes;
DrawTriangleFan (a Vector2* API) becomes paired DrawTriangles drawn
in both windings so variable quad winding survives backface culling.
A light dragged inside a box contributes nothing (the C shows its
stale mask). F1 is L here - macOS eats F1.)
