# bullet-hell

A magic circle spraying bullet spirals.

Category: shapes. Controls: L/R rows · U/D speed · Z/X cooldown · SPACE angle · ENTER method · C clear · Q.

Ported from raylib's `examples/shapes/shapes_bullet_hell.c`.

![bullet-hell](../demos/bullet-hell.gif)

## Run it

```sh
cd bullet-hell && bb run   # from this demo (or lein run --disable-sandbox)
bb bullet-hell             # from the repo root
```

## About

raylib [shapes] example - bullet hell, ported to jank.

A spinning magic circle sprays rings of bullets. RIGHT/LEFT (or D/A)
change the row count, UP/DOWN (or W/S) the bullet speed, Z/X the
spawn cooldown, holding SPACE grows the spiral angle increment,
ENTER switches between the pre-rendered-texture and DrawCircle draw
methods, C clears, Q quits.
Based on raylib/examples/shapes/shapes_bullet_hell.c
(jank-native: bullets are a vector of maps rebuilt per frame instead
of a mutable C array, and MAX-BULLETS is 5000 rather than the C's
500000 calloc headroom - the reset-at-cap behavior is the same. The
C's (Color){0,0,0,200} UI panels become Fade BLACK 0.784.)
