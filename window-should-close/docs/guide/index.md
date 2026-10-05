# window-should-close

Confirm-before-exit on window close.

Category: core. Controls: ESC/X then Y/N · Q.

Ported from raylib's `examples/core/core_window_should_close.c`.

![window-should-close](../demos/window-should-close.gif)

## Run it

```sh
cd window-should-close && bb run   # from this demo (or lein run --disable-sandbox)
bb window-should-close             # from the repo root
```

## About

raylib [core] example - window should close, ported to jank.

Closing the window (X button or ESC) asks for confirmation instead of
quitting immediately: press Y to exit, N to cancel.
Based on raylib/examples/core/core_window_should_close.c
