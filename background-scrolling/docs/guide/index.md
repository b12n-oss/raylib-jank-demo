# background-scrolling

Parallax-scrolling cyberpunk street layers.

Category: textures. Controls: Q quit.

Ported from raylib's `examples/textures/textures_background_scrolling.c`.

![background-scrolling](../demos/background-scrolling.gif)

## Run it

```sh
cd background-scrolling && bb run   # from this demo (or lein run --disable-sandbox)
bb background-scrolling             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - background scrolling, ported to jank.

Parallax scrolling: three cyberpunk-street layers (background,
midground, foreground) scroll left at different speeds, each drawn
twice at 2x scale so the seam wraps. Q quits.
Cyberpunk Street Environment by Luis Zuno (@ansimuz).
Based on raylib/examples/textures/textures_background_scrolling.c
(jank-native: the three textures live as let-locals captured by the
frame loop; the three scroll offsets thread the loop as plain reals.)
