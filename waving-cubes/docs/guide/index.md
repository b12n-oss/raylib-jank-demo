# waving-cubes

3375 rainbow cubes waving in 3D.

Category: models. Controls: watch · Q quit.

Ported from raylib's `examples/models/models_waving_cubes.c`.

## Run it

```sh
cd waving-cubes && bb run   # from this demo (or lein run --disable-sandbox)
bb waving-cubes             # from the repo root
```

## About

raylib [models] example - waving cubes, ported to jank.

A 15x15x15 lattice of rainbow cubes breathing and waving in 3D
while the camera circles the scene. Q quits.
Based on raylib/examples/models/models_waving_cubes.c
(jank-native: the camera is rebuilt inline each frame from the
accumulated time (the per-frame Camera3D pattern); cube hues come
from ColorFromHSV inline. 3375 cubes of per-frame jank math also
make this an informal throughput benchmark - watch the FPS.)
