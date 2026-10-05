# logo-anim

The raylib logo assembling itself.

Category: shapes. Controls: R replay · Q quit.

Ported from raylib's `examples/shapes/shapes_logo_raylib_anim.c`.

![logo-anim](../demos/logo-anim.gif)

## Run it

```sh
cd logo-anim && bb run   # from this demo (or lein run --disable-sandbox)
bb logo-anim             # from the repo root
```

## About

raylib [shapes] example - logo animation, ported to jank.

The raylib logo assembles itself via a small state machine:
0) blinking square  1) top+left bars grow  2) bottom+right bars grow
3) letters appear then fade  4) press R to replay. Q quits.
Based on raylib/examples/shapes/shapes_logo_raylib_anim.c
