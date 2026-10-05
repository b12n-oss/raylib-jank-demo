# text-3d-drawing

A bitmap font as textured quads in 3D, one span waving.

Category: text. Controls: F1/F2 boundaries, F3 camera, arrows size/spacing, Home/End layers, Tab multicolor, click cube, ESC.

Ported from raylib's `examples/text/text_3d_drawing.c`.

![text-3d-drawing](../demos/text-3d-drawing.gif)

## Run it

```sh
cd text-3d-drawing && bb run   # from this demo (or lein run --disable-sandbox)
bb text-3d-drawing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - 3d drawing, ported to jank.

Text rendered as textured quads in 3D: each glyph becomes a quad built
straight from rlgl, stacked into layers, with the parts wrapped in ~~
waving on a sine. Orbital camera by default. Type to edit the text,
arrows/PgUp/PgDn change size and spacing, Home/End add layers,
Insert/Delete change layer distance, Tab toggles multicolor, F1/F2
toggle the boundary boxes, F3 switches camera, click the cube to
recolor, and dropping a .ttf/.fnt swaps the font. ESC quits.
Based on raylib/examples/text/text_3d_drawing.c

jank-native notes:
- Three values are genuinely native and boxed: the Camera3D (UpdateCamera
  mutates it and F3 rebuilds it), the Font (a dropped file replaces it at
  runtime, so its box lives in an atom), and the alpha-discard Shader.
  Everything else - the wave config, the colours, the layer stack, the
  text itself - is plain jank data threaded through recur.
- The glyph quads are direct rlgl: rlBegin RL_QUADS, rlTexCoord2f /
  rlVertex3f per corner, inside rlPushMatrix. No wrapper needed.
- Codepoint iteration takes a const char* for the whole string once and
  offsets it with cpp/+, rather than re-slicing the jank string per
  character (the gif-player pointer-arithmetic pattern).
- TextFormat is variadic and unavailable, so the readouts use small
  fixed-decimal helpers.
- A jank fn takes at most 10 parameters, so the glyph-drawing fns take
  their position as an [x y z] vector rather than three arguments.
