# viewport-scaling

A fixed game resolution scaled into a resizable window.

Category: core. Controls: resize window, click < > buttons, ESC.

Ported from raylib's `examples/core/core_viewport_scaling.c`.

![viewport-scaling](../demos/viewport-scaling.gif)

## Run it

```sh
cd viewport-scaling && bb run   # from this demo (or lein run --disable-sandbox)
bb viewport-scaling             # from the repo root
```

## About

raylib [core] example - viewport scaling, ported to jank.

A game scene rendered at a fixed 'game resolution' into a RenderTexture,
scaled into a resizable window under six viewport policies (keep aspect /
height / width, each with an integer pixel-snap variant). Two < > button
pairs cycle the game resolution (64x64 / 256x240 / 320x180 / 4K) and the
policy; a LIME circle tracks the mouse mapped into game space. Resize the
window to see each policy react. ESC quits.
Based on raylib/examples/core/core_viewport_scaling.c

jank-native notes:
- The C recreates its RenderTexture2D on every resize/mode change with a
  size computed from the CURRENT window - a native value that must
  persist across frames but cannot thread through loop/recur (rule 2).
  NEW pattern: the target lives as an opaque box in a jank atom, so
  the box can be swapped on resize; each frame unboxes it into a
  let-local, which never crosses a jank fn boundary.
- The C's six Keep* helpers write through Rectangle* out-params; the
  port computes plain jank maps {:sx .. :dh} instead - pure math, no
  pointers. (The C's KeepHeightCentered[Integer] pair and
  KeepWidthCentered[Integer] pair are character-identical, so the port
  shares one fn per axis and keeps all six mode names.)
- Screen2RenderTexturePosition scales BOTH axes by the x ratio in the C;
  kept faithful.
- TextFormat %.2f becomes a str + str/index-of + subs trim; C's
  (float)(int) truncations become (+ 0.0 (int ...)).
