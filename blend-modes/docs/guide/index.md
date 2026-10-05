# blend-modes

Four 2D blend modes over the cyberpunk street.

Category: textures. Controls: SPACE mode · Q quit.

Ported from raylib's `examples/textures/textures_blend_modes.c`.

![blend-modes](../demos/blend-modes.gif)

## Run it

```sh
cd blend-modes && bb run   # from this demo (or lein run --disable-sandbox)
bb blend-modes             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - blend modes, ported to jank.

The cyberpunk-street foreground drawn over the background through
the four 2D blend modes (ALPHA / ADDITIVE / MULTIPLIED / ADD_COLORS).
SPACE cycles the mode, Q quits.
Cyberpunk Street Environment by Luis Zuno (@ansimuz).
Based on raylib/examples/textures/textures_blend_modes.c
(jank-native: BeginBlendMode takes the mode as a plain jank int;
the mode name is picked with nested ifs returning jank strings.)
