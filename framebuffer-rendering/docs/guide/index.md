# framebuffer-rendering

An observer camera watching a subject camera + frustum.

Category: textures. Controls: WASD + mouse observer, R retarget, ESC.

Ported from raylib's `examples/textures/textures_framebuffer_rendering.c`.

![framebuffer-rendering](../demos/framebuffer-rendering.gif)

## Run it

```sh
cd framebuffer-rendering && bb run   # from this demo (or lein run --disable-sandbox)
bb framebuffer-rendering             # from the repo root
```

## About

raylib [textures] example - framebuffer rendering, ported to jank.

Two views of one scene: the right half is an orbiting 'subject' camera
looking at a gold cube; the left half is a free-look 'observer' camera
watching the same world plus a green prism visualizing the subject
camera's frustum. A crop of the subject view overlays top-right (WASD
+ mouse move the observer, R re-targets it). ESC quits.
Based on raylib/examples/textures/textures_framebuffer_rendering.c

jank-native notes:
- Two UpdateCamera((cpp/& cam) mode) cameras at once (FREE observer +
  ORBITAL subject), each an outer-let Camera3D mutated in place.
- The C's DrawCameraPrism is example-defined maths over raymath
  (GetCameraMatrix / MatrixPerspective / MatrixInvert). Each matrix
  stays a let-local feeding the next raymath call in the same scope,
  so none crosses a fn boundary and the whole thing is jank.
- Both half-screen RenderTextures are create-once outer-let locals;
  the y-flipped source/dest/crop rects build inline at each
  DrawTexturePro.
