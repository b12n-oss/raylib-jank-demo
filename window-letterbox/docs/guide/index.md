# window-letterbox

A fixed 640x480 game letterboxed on resize.

Category: core. Controls: resize the window · SPACE recolor · Q quit.

Ported from raylib's `examples/core/core_window_letterbox.c`.

![window-letterbox](../demos/window-letterbox.gif)

## Run it

```sh
cd window-letterbox && bb run   # from this demo (or lein run --disable-sandbox)
bb window-letterbox             # from the repo root
```

## About

raylib [core] example - window letterbox, ported to jank.

The game renders at a fixed 640x480 into an offscreen RenderTexture,
which is scaled and letterboxed into whatever size you drag the
(resizable) window to. SPACE recolors the bars, Q quits. The mouse
readouts show the raw window coordinates vs the virtual (game-space)
coordinates.
Based on raylib/examples/core/core_window_letterbox.c
(jank-native: bar colors are packed RGBA hex ints resolved through
GetColor, and SetConfigFlags is called once per flag since it ORs
into the internal state - no bitwise op needed.)
