# following-eyes

Two eyes track the mouse cursor.

Category: shapes. Controls: move the mouse · Q quit.

Ported from raylib's `examples/shapes/shapes_following_eyes.c`.

![following-eyes](../demos/following-eyes.gif)

## Run it

```sh
cd following-eyes && bb run   # from this demo (or lein run --disable-sandbox)
bb following-eyes             # from the repo root
```

## About

raylib [shapes] example - following eyes, ported to jank.

Two eyes whose irises track the mouse, clamped to the sclera. Q quits.
Based on raylib/examples/shapes/shapes_following_eyes.c
(jank-native: C atan2/cos/sin, pure-math point-in-circle test).
