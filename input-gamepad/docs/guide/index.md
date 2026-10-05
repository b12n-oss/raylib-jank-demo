# input-gamepad

A live controller diagram: buttons/sticks/triggers lit.

Category: core. Controls: plug in a gamepad, LEFT/RIGHT switch slot, click VIBRATE, ESC.

Ported from raylib's `examples/core/core_input_gamepad.c`.

![input-gamepad](../demos/input-gamepad.gif)

## Run it

```sh
cd input-gamepad && bb run   # from this demo (or lein run --disable-sandbox)
bb input-gamepad             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/core/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [core] example - input gamepad, ported to jank.

Draws a live controller diagram: buttons light up as you press them,
the sticks and triggers track the analog axes, and a VIBRATE button
(mouse) rumbles the pad. It recognises Xbox and PlayStation pads by
name (drawing the matching photo) and falls back to a generic layout
otherwise. LEFT/RIGHT switch which gamepad slot is shown. With no
controller plugged in it shows the Xbox diagram greyed out and
'GP0: NOT DETECTED'.
Based on raylib/examples/core/core_input_gamepad.c (2/4 complexity).

jank-native notes:
- Nothing here needed to stay in C. The gamepad API returns ints,
  floats, bools and C strings, all of which cross a jank fn boundary
  freely, and the two controller photos are ordinary let-local
  Texture2Ds used inline.
- The C repeats a button-lit-up draw about sixty times, one `if` per
  button. Here each layout is a vector of [button x y radius colour]
  rows walked by one loop. Same draws in the same order, expressed
  once. Colours travel as [r g b] taken from raylib.h, since a Color
  cannot live in a jank vector.
- Deadzones, the axis readout and the Xbox/PS name match via
  TextFindIndex(TextToLower(...)) are all plain jank.
