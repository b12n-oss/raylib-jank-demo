# font-spritefont

Three colored sprite fonts from PNG atlases.

Category: text. Controls: watch · Q quit.

Ported from raylib's `examples/text/text_font_spritefont.c`.

![font-spritefont](../demos/font-spritefont.gif)

## Run it

```sh
cd font-spritefont && bb run   # from this demo (or lein run --disable-sandbox)
bb font-spritefont             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - font spritefont, ported to jank.

Three colored sprite fonts, each loaded straight from a PNG atlas
with LoadFont and drawn centered with DrawTextEx (each with its own
glyph spacing). Q quits.
Based on raylib/examples/text/text_font_spritefont.c
(jank-native: sprite fonts load from a .png the same as any Font;
the three center positions are computed once before the loop from
MeasureTextEx's Vector2 (read via .-x, nth-boxed) and .-baseSize.)
