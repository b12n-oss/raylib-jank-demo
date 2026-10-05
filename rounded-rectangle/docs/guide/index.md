# rounded-rectangle

A rounded rectangle, size/roundness knobs.

Category: shapes. Controls: A/S Z/X size · L/R roundness · U/D thickness · O/P segments · R/L/G · Q.

Ported from raylib's `examples/shapes/shapes_rounded_rectangle_drawing.c`.

![rounded-rectangle](../demos/rounded-rectangle.gif)

## Run it

```sh
cd rounded-rectangle && bb run   # from this demo (or lein run --disable-sandbox)
bb rounded-rectangle             # from the repo root
```

## About

raylib [shapes] example - rounded rectangle drawing, ported to jank.

A rounded rectangle with adjustable size, roundness, outline
thickness and segment count. Hold A/S for width, Z/X for height,
LEFT/RIGHT for roundness, DOWN/UP for outline thickness, O/P for
segments. R toggles the rounded fill, L the rounded outline, G the
plain gold rectangle. Q quits.
Based on raylib/examples/shapes/shapes_rounded_rectangle_drawing.c
(jank-native: the raygui sliders/checkboxes become held-key
adjustments + toggle keys, with the control panel drawn as text.)
