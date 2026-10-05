# color-correction

A shader tuning contrast/saturation/brightness.

Category: shaders. Controls: 1-4 picture, Q/W A/S Z/X sliders, R reset, ESC.

Ported from raylib's `examples/shaders/shaders_color_correction.c`.

![color-correction](../demos/color-correction.gif)

## Run it

```sh
cd color-correction && bb run   # from this demo (or lein run --disable-sandbox)
bb color-correction             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - color correction, ported to jank.

A post-process fragment shader adjusts contrast, saturation and
brightness of a picture in real time. Press 1-4 to switch picture;
hold Q/W contrast, A/S saturation, Z/X brightness; R resets; ESC
quits. The original's raygui sliders become held-key adjustments
(docs/guide/raygui-to-keyboard.md).
Based on raylib/examples/shaders/shaders_color_correction.c

jank-native notes:
- The postprocess class (a shader wrapped around a plain DrawTexture)
  - the natural next step after the fullscreen-rect shaders. Three
  FLOAT uniforms (contrast/saturation/brightness) go straight to
  SetShaderValue with (cpp/new cpp/float ...) as the pointer; the
  shader divides each by 100 internally, so the -100..100 range is
  passed raw.
- Four native Texture2D pictures are held as outer-let locals (native
  values cannot live in a jank vector), so the per-index DrawTexture
  happens inside a cond branch, centering from the .width/.height
  reads inline.
