# world-screen

A 2D label tracking a 3D cube (GetWorldToScreen).

Category: core. Controls: watch · Q quit.

Ported from raylib's `examples/core/core_world_screen.c`.

![world-screen](../demos/world-screen.gif)

## Run it

```sh
cd world-screen && bb run   # from this demo (or lein run --disable-sandbox)
bb world-screen             # from the repo root
```

## About

raylib [core] example - world screen, ported to jank.

A floating 2D label pinned above a 3D cube: each frame the cube's
world position is projected to screen space with GetWorldToScreen so
the text tracks it as the camera moves. Q quits.
Based on raylib/examples/core/core_world_screen.c
(jank-native: the C uses UpdateCamera(&camera, CAMERA_THIRD_PERSON)
free-look, which needs a pointer jank cannot form; here the camera
slowly orbits via the per-frame Camera3D rebuild so the projection
is still visibly dynamic. GetWorldToScreen returns a native Vector2,
read via .-x/.-y inside a local so nothing native escapes.)
