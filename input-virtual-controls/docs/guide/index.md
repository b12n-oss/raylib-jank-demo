# input-virtual-controls

An on-screen D-pad moving a player circle.

Category: core. Controls: hold LEFT on a button · Q quit.

Ported from raylib's `examples/core/core_input_virtual_controls.c`.

![input-virtual-controls](../demos/input-virtual-controls.gif)

## Run it

```sh
cd input-virtual-controls && bb run   # from this demo (or lein run --disable-sandbox)
bb input-virtual-controls             # from the repo root
```

## About

raylib [core] example - input virtual controls, ported to jank.

An on-screen D-pad: press one of the four arrow buttons (touch, or
mouse-down on desktop) to move the maroon player circle. The nearest
button to the input point within its radius is the pressed one. Q
quits.
Based on raylib/examples/core/core_input_virtual_controls.c
(jank-native: the C example's buttonPositions / arrowTris arrays are
compile-time constant data, kept here as plain jank vectors of coords;
the per-button label Color is selected by index with nested `if`
forms - the native-value-by-index rule - not stored in a collection.
Only the player position lives in loop state, as jank reals.)
