# recursive-tree

A binary fractal tree with live knobs.

Category: shapes. Controls: L/R angle · U/D length · A/S decay · Z/X depth · T/Y thick · B bezier · Q.

Ported from raylib's `examples/shapes/shapes_recursive_tree.c`.

![recursive-tree](../demos/recursive-tree.gif)

## Run it

```sh
cd recursive-tree && bb run   # from this demo (or lein run --disable-sandbox)
bb recursive-tree             # from the repo root
```

## About

raylib [shapes] example - recursive tree, ported to jank.

A binary fractal tree rebuilt every frame. Hold LEFT/RIGHT for the
branch angle, DOWN/UP for the trunk length, A/S for the decay
factor; Z/X step the depth, T/Y the line thickness, B toggles
bezier branches. Q quits.
Based on raylib/examples/shapes/shapes_recursive_tree.c
(jank-native: the C's fixed Branch array becomes a vector of maps
grown breadth-first by indexing into itself; raygui sliders become
held/pressed keys with a text panel.)
