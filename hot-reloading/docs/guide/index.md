# hot-reloading

Hot-swap the reload.fs fragment shader while it runs.

Category: shaders. Controls: A auto-reload, CLICK reload once, ESC.

Ported from raylib's `examples/shaders/shaders_hot_reloading.c`.

![hot-reloading](../demos/hot-reloading.gif)

## Run it

```sh
cd hot-reloading && bb run   # from this demo (or lein run --disable-sandbox)
bb hot-reloading             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - hot reloading, ported to jank.

A full-screen fractal drawn by reload.fs; edit + save that shader
file while the example runs and it hot-swaps in. A toggles auto
reloading (polls the file every frame), otherwise LEFT CLICK checks
once. ESC quits.
Based on raylib/examples/shaders/shaders_hot_reloading.c

jank-native notes:
- The C reassigns its Shader when the file changes - a native value
  that must persist across frames but cannot thread through
  loop/recur (rule 2). It lives as an opaque box in a jank atom (the
  viewport-scaling render-target pattern), so the box can be swapped
  when the file changes. The reload keeps the old shader when the new
  one failed to compile (id == rlGetShaderIdDefault), matching the C.
- Uniform locations DO thread through the loop as jank ints,
  re-queried after a successful swap.
- GetFileModTime's time_t boxes to a jank int; the timestamp is
  formatted in jank rather than through asctime.
- Native bools that feed and/or logic are boxed first via
  (if native true false) to keep both if-branch types jank.
