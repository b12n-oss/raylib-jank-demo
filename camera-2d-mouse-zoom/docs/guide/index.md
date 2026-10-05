# camera-2d-mouse-zoom

Pan + zoom-to-cursor a 2D camera.

Category: core. Controls: 1/2 mode · LEFT drag · WHEEL/RIGHT zoom · Q.

Ported from raylib's `examples/core/core_2d_camera_mouse_zoom.c`.

![camera-2d-mouse-zoom](../demos/camera-2d-mouse-zoom.gif)

## Run it

```sh
cd camera-2d-mouse-zoom && bb run   # from this demo (or lein run --disable-sandbox)
bb camera-2d-mouse-zoom             # from the repo root
```

## About

raylib [core] example - 2d camera mouse zoom, ported to jank.

Pan a 2D world by dragging with the LEFT button and zoom toward the
cursor: mode [1] zooms with the mouse WHEEL, mode [2] zooms by
holding RIGHT and moving. The camera keeps the world point under the
cursor fixed while zooming. Q quits.
Based on raylib/examples/core/core_2d_camera_mouse_zoom.c
(jank-native: the C mutates camera.target/.offset/.zoom in place;
here the Camera2D is rebuilt each frame from tracked scalars, twice
when needed - once post-pan for the GetScreenToWorld2D query, once
final for drawing. GetMouseDelta's native Vector2 return is avoided
by threading the previous mouse position and subtracting; the world
point from GetScreenToWorld2D is read via .-x/.-y inside a local so
no native value escapes. Uses rlgl matrix ops for the tilted grid.)
