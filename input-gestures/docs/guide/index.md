# input-gestures

Log detected mouse/touch gestures.

Category: core. Controls: tap/drag/swipe in the area · Q quit.

Ported from raylib's `examples/core/core_input_gestures.c`.

![input-gestures](../demos/input-gestures.gif)

## Run it

```sh
cd input-gestures && bb run   # from this demo (or lein run --disable-sandbox)
bb input-gestures             # from the repo root
```

## About

raylib [core] example - input gestures, ported to jank.

Mouse/touch gestures (tap, double-tap, hold, drag, swipes) detected
inside the test area are logged in a side panel while a circle follows
the touch point. Q quits.
Based on raylib/examples/core/core_input_gestures.c
(jank-native: gesture ids are compared as plain ints against the
raylib Gesture enum values, and the log is a jank vector of strings
capped at 20 entries like the C string array.)
