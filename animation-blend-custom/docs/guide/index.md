# animation-blend-custom

Per-bone blending: walking legs + attacking upper body.

Category: models. Controls: SPACE toggle blend mode, ESC.

Ported from raylib's `examples/models/models_animation_blend_custom.c`.

![animation-blend-custom](../demos/animation-blend-custom.gif)

## Run it

```sh
cd animation-blend-custom && bb run   # from this demo (or lein run --disable-sandbox)
bb animation-blend-custom             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/models/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [models] example - animation blend custom, ported to jank.

Two glTF animations blended per bone, with CPU skinning. SPACE toggles
between uniform 50/50 blending and a split where the upper body plays
the attack and the lower body keeps walking.
Based on raylib/examples/models/models_animation_blend_custom.c

jank-native notes:
- Every native value here (Transform, Matrix, Quaternion, Vector3)
  stays inside the let that produced it and is consumed by the next
  raymath call in the same scope, so none of them ever crosses a fn
  boundary. That is what makes the bone loop expressible at all.
- The ModelAnimation array and the Model are reached through boxes.
- The skinning loop uses cpp/ operators on native ints and doubles.
  It is small here (196 vertices, and the C's own cost is 0.065 ms a
  frame) so this is not load-bearing, but the loops are float array
  walks and native ops are what those are for.
- The upper-body bone test keeps BOTH of the C's blocks. They are not
  redundant: strstr is case-sensitive, so upperChest, upperArm and
  lowerArm are matched only by the exact-name list. Folding the two
  together silently drops them.
