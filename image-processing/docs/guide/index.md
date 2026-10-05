# image-processing

Nine CPU image filters via pointer-taking Image* APIs.

Category: textures. Controls: click / UP / DOWN · Q quit.

Ported from raylib's `examples/textures/textures_image_processing.c`.

![image-processing](../demos/image-processing.gif)

## Run it

```sh
cd image-processing && bb run   # from this demo (or lein run --disable-sandbox)
bb image-processing             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - image processing, ported to jank.

Pick one of nine CPU image processes (grayscale, tint, invert,
contrast, brightness, gaussian blur, flip V/H) from the toggle list -
click or UP/DOWN - and it is applied to a fresh copy of the parrots
image, then re-uploaded to the on-screen texture. Q quits.
Based on raylib/examples/textures/textures_image_processing.c

jank-native notes:
- This is the repo's first use of pointer-taking `Image*` APIs. jank
  forms the pointer with `(cpp/& img)` on a mutable let-local (the
  same address-of C uses: `ImageColorInvert(&imCopy)`). No -sys
  wrapper change was needed - every raylib fn is already callable.
- The working copy `imCopy` is never carried in loop/recur state (a
  native value can't be): it is rebuilt from `imOrigin`, processed,
  read back via `LoadImageColors` (a `Color*` return) into
  `UpdateTexture`, and unloaded, all inside the reload block that only
  runs when the selected process changes. Only the process index (a
  jank int) lives in loop state.
