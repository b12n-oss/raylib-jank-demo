# multi-sample2d

Two textures blended in a shader via a second sampler2D.

Category: shaders. Controls: LEFT/RIGHT divider, ESC.

Ported from raylib's `examples/shaders/shaders_multi_sample2d.c`.

![multi-sample2d](../demos/multi-sample2d.gif)

## Run it

```sh
cd multi-sample2d && bb run   # from this demo (or lein run --disable-sandbox)
bb multi-sample2d             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - multi sample2d, ported to jank.

A red texture drawn while a blue texture is bound to a second
sampler2D slot; the color_mix fragment shader blends them across a
divider. LEFT/RIGHT move the divider. ESC quits.
Based on raylib/examples/shaders/shaders_multi_sample2d.c

jank-native notes:
- First SetShaderValueTexture use: its args (Shader, int, Texture2D)
  are all by-value so it calls directly, no shim. Per the C's note it
  must be re-bound inside BeginShaderMode every frame - EndShaderMode
  resets the extra texture units.
- The C's (Color){255,0,0,255} literals become cpp/GetColor with a
  packed RGBA int (cpp/Color's unsigned-char ctor rejects jank ints).
- The divider FLOAT uniform is a plain SetShaderValue over a
  cpp/new float.
