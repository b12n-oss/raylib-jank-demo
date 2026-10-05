# tesseract-view

A rotating 4D hypercube projected to 3D.

Category: models. Controls: watch · Q quit.

Ported from raylib's `examples/models/models_tesseract_view.c`.

![tesseract-view](../demos/tesseract-view.gif)

## Run it

```sh
cd tesseract-view && bb run   # from this demo (or lein run --disable-sandbox)
bb tesseract-view             # from the repo root
```

## About

raylib [models] example - tesseract view, ported to jank.

A rotating 4D hypercube: the XW plane spins, then each vertex
projects from perspective point (0,0,0,3) down to XYZ. Sphere size
shows each vertex's W value; edges connect vertices differing in
exactly one coordinate. Q quits.
Based on raylib/examples/models/models_tesseract_view.c
(jank-native: the 16 Vector4 vertices are jank [x y z w] vectors,
the 32 edges are precomputed once at load, and the rotation /
projection is scalar jank math; only the final DrawSphere /
DrawLine3D calls build native Vector3s inline.)
