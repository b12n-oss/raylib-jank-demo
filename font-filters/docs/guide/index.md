# font-filters

Scale a TTF word, switch texture filters.

Category: text. Controls: WHEEL size · 1/2/3 filter · L/R move · Q.

Ported from raylib's `examples/text/text_font_filters.c`.

![font-filters](../demos/font-filters.gif)

## Run it

```sh
cd font-filters && bb run   # from this demo (or lein run --disable-sandbox)
bb font-filters             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - font filters, ported to jank.

A big TTF word scaled by the mouse wheel, with the font atlas's
texture filter switchable between POINT (1), BILINEAR (2) and
TRILINEAR (3); LEFT/RIGHT slide the text. Q quits.
Based on raylib/examples/text/text_font_filters.c
(jank-native: SetTextureFilter is called on (.-texture font) read
inline - GL keys the filter by texture id so it affects the real
atlas even though the field read is a by-value copy. Two features
are dropped: GenTextureMipmaps(&font.texture) needs an address-of a
struct field jank can't form - so TRILINEAR looks like BILINEAR,
which the C notes is true in 2D anyway - and the drag-drop dynamic
font load needs a FilePathList pointer array.)
