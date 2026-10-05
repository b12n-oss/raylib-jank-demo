# font-sdf

Bitmap vs SDF font scaling, the SDF drawn through a shader.

Category: text. Controls: MOUSE WHEEL scale, hold SPACE for SDF, ESC.

Ported from raylib's `examples/text/text_font_sdf.c`.

![font-sdf](../demos/font-sdf.gif)

## Run it

```sh
cd font-sdf && bb run   # from this demo (or lein run --disable-sandbox)
bb font-sdf             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - font sdf, ported to jank.

The same TTF rasterized two ways: a plain 16px bitmap font and a
16px SDF (signed distance field) font drawn through the sdf.fs
shader. Scale with the MOUSE WHEEL - the bitmap font blurs while
the SDF font stays crisp. HOLD SPACE for the SDF version; the
font's atlas texture shows top-left. ESC quits.
Based on raylib/examples/text/text_font_sdf.c

jank-native notes:
- The C assembles each Font by hand: LoadFileData -> LoadFontData
  (GlyphInfo* + an int* out-param) -> GenImageFontAtlas (a
  Rectangle** out-param) -> struct field writes. All of that is jank:
  out-params through (cpp/& n), the Rectangle** read with cpp/aget,
  and the Font fields written with cpp/=. Each Font is built inside
  one let and boxed, since a Font cannot cross a fn boundary.
- SetTextureFilter on the SDF atlas (required for SDF sampling)
  takes the Texture read straight off the Font with .-texture.
- The %02.02f render-size readout reuses viewport-scaling's
  str-trim helper.
