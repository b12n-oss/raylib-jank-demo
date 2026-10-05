# rlgl-solar-system

Sun/Earth/Moon via the rlgl matrix stack.

Category: models. Controls: watch · Q quit.

Ported from raylib's `examples/models/models_rlgl_solar_system.c`.

![rlgl-solar-system](../demos/rlgl-solar-system.gif)

## Run it

```sh
cd rlgl-solar-system && bb run   # from this demo (or lein run --disable-sandbox)
bb rlgl-solar-system             # from the repo root
```

## About

raylib [models] example - rlgl solar system, ported to jank.

A hierarchical solar system built on the rlgl matrix stack: the
Earth orbits the Sun while spinning, and the Moon orbits the Earth,
each transform nested with rlPushMatrix/rlPopMatrix. Q quits.
Based on raylib/examples/models/models_rlgl_solar_system.c
(jank-native: the C's custom DrawSphereBasic (a unit sphere at the
origin) is raylib's DrawSphere at (0,0,0) radius 1 - it renders
through the same rlgl batch, so the stack transforms apply to it
identically.)
