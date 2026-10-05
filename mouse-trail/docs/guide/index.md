# mouse-trail

A fading trail follows the cursor.

Category: shapes. Controls: move the mouse · Q quit.

Ported from raylib's `examples/shapes/shapes_mouse_trail.c`.

![mouse-trail](../demos/mouse-trail.gif)

## Run it

```sh
cd mouse-trail && bb run   # from this demo (or lein run --disable-sandbox)
bb mouse-trail             # from the repo root
```

## About

raylib [shapes] example - mouse trail, ported to jank.

A trail of circles follows the mouse; older positions fade and shrink.
Press Q to quit. Based on raylib/examples/shapes/shapes_mouse_trail.c
