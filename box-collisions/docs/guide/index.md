# box-collisions

A player cube colliding with 3D obstacles.

Category: models. Controls: ARROWS move · Q quit.

Ported from raylib's `examples/models/models_box_collisions.c`.

![box-collisions](../demos/box-collisions.gif)

## Run it

```sh
cd box-collisions && bb run   # from this demo (or lein run --disable-sandbox)
bb box-collisions             # from the repo root
```

## About

raylib [models] example - box collisions, ported to jank.

A player cube (ARROW keys) colliding with an enemy box and an
enemy sphere in 3D; the player turns red while overlapping.
Q quits.
Based on raylib/examples/models/models_box_collisions.c
(jank-native: the player position threads the loop as three plain
reals; BoundingBoxes are constructed inline from nested Vector3
args at each CheckCollision* call.)
