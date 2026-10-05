# polygon-drawing

A cat texture mapped onto a spinning polygon.

Category: textures. Controls: watch · Q quit.

Ported from raylib's `examples/textures/textures_polygon_drawing.c`.

![polygon-drawing](../demos/polygon-drawing.gif)

## Run it

```sh
cd polygon-drawing && bb run   # from this demo (or lein run --disable-sandbox)
bb polygon-drawing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - polygon drawing, ported to jank.

A cat texture mapped onto a spinning 10-sided polygon. The C example
implements DrawTexturePoly itself with rlgl immediate mode, so this
port needs no Vector2* array interop: the fixed texcoords and base
points live in jank vectors, are rotated per frame, and are emitted as
a triangle fan via rlSetTexture / rlBegin / rlTexCoord2f / rlVertex2f.
Q quits. Cat sprite by Eiden Marsal.
Based on raylib/examples/textures/textures_polygon_drawing.c
