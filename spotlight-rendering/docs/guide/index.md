# spotlight-rendering

Three spotlights alpha-masked over a sprite swarm.

Category: shaders. Controls: move the mouse, ESC.

Ported from raylib's `examples/shaders/shaders_spotlight_rendering.c`.

![spotlight-rendering](../demos/spotlight-rendering.gif)

## Run it

```sh
cd spotlight-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb spotlight-rendering             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/shaders/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [shaders] example - spotlight rendering, ported to jank.

A star field and a swarm of orbiting raysan sprites under three
spotlights: the spotlight shader alpha-masks a full-screen rectangle
so the pools of light punch through. The left screen half is pitch
black outside the spots, the right half dimly lit. Spot 0 follows
the mouse (move it!); the other two bounce around. ESC quits.
Based on raylib/examples/shaders/shaders_spotlight_rendering.c

jank-native notes:
- First GLSL struct-array uniforms (uniform Spot spots[3]): each
  member location is just GetShaderLocation with a computed jank
  string (str "spots[" i "].pos") - no C-side name patching like
  the original's posName[6] = '0' + i. Values go through the
  per-type scalar setters (VEC2 position per frame; inner/radius
  FLOAT once at init).
- The C's Star/Spot struct arrays become jank vectors of maps
  threaded through the frame loop (rule 2); Vector2Add/Multiply
  reduce to plain jank arithmetic.
- The C's quirky reset-star re-roll condition
  !(fabs(sx) + (fabs(sy) > 1)) mixes a double and a bool: it
  re-rolls only while sx == 0 AND |sy| <= 1. Kept faithful.
- The mouse spot's y is flipped (HEIGHT - mouse.y): the shader works
  in gl_FragCoord space, which is bottom-up.
