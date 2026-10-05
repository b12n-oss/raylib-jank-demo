# particles

Water / smoke / fire particle effects.

Category: shapes. Controls: mouse · LEFT/RIGHT type · Q.

Ported from raylib's `examples/shapes/shapes_simple_particles.c`.

![particles](../demos/particles.gif)

## Run it

```sh
cd particles && bb run   # from this demo (or lein run --disable-sandbox)
bb particles             # from the repo root
```

## About

raylib [shapes] example - simple particles, ported to jank.

Move the mouse to emit particles. LEFT/RIGHT cycle the type
(water falls, smoke rises and fades, fire shrinks yellow->red).
Press Q to quit. Based on
raylib/examples/shapes/shapes_simple_particles.c
