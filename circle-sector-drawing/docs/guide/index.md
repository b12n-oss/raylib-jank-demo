# circle-sector-drawing

A circle sector with adjustable angles.

Category: shapes. Controls: L/R + U/D angles · A/S radius · O/P segments · Q quit.

Ported from raylib's `examples/shapes/shapes_circle_sector_drawing.c`.

![circle-sector-drawing](../demos/circle-sector-drawing.gif)

## Run it

```sh
cd circle-sector-drawing && bb run   # from this demo (or lein run --disable-sandbox)
bb circle-sector-drawing             # from the repo root
```

## About

raylib [shapes] example - circle sector drawing, ported to jank.

A filled circle sector plus its outline, with adjustable angles,
radius and segment count. Hold LEFT/RIGHT for the start angle,
DOWN/UP for the end angle, A/S for the radius, O/P for the segment
count (below the auto threshold = AUTO mode). Q quits.
Based on raylib/examples/shapes/shapes_circle_sector_drawing.c
(jank-native: the raygui sliders become held-key adjustments with the
control panel drawn as text, mirroring ring_drawing.jank.)
