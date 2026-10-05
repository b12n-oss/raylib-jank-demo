# scissor-test

A scissor rectangle reveals text.

Category: core. Controls: mouse · S toggle · Q quit.

Ported from raylib's `examples/core/core_scissor_test.c`.

![scissor-test](../demos/scissor-test.gif)

## Run it

```sh
cd scissor-test && bb run   # from this demo (or lein run --disable-sandbox)
bb scissor-test             # from the repo root
```

## About

raylib [core] example - scissor test, ported to jank.

A scissor rectangle follows the mouse; only the part of the red
fullscreen rectangle inside it is drawn. S toggles the scissor, Q quits.
Based on raylib/examples/core/core_scissor_test.c
