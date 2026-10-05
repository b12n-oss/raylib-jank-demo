# sprite-fonts

A gallery of raylib's eight bundled sprite fonts.

Category: text. Controls: watch · Q quit.

Ported from raylib's `examples/text/text_sprite_fonts.c`.

![sprite-fonts](../demos/sprite-fonts.gif)

## Run it

```sh
cd sprite-fonts && bb run   # from this demo (or lein run --disable-sandbox)
bb sprite-fonts             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - sprite fonts, ported to jank.

A gallery of the eight free sprite fonts bundled with raylib, each
loaded from its PNG atlas and drawn at 2x its base size in its own
color and glyph spacing. Q quits.
Based on raylib/examples/text/text_sprite_fonts.c
(jank-native: the C keeps the eight Font structs in an array and
loops; jank can't hold natives in a vector, so the eight fonts are
separate let-locals and the draws are unrolled. Each center-x comes
from MeasureTextEx's Vector2 (.-x, nth-boxed) and .-baseSize.)
