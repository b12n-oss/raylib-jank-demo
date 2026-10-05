# fog-of-war

A tile map hidden by smooth fog of war.

Category: textures. Controls: ARROWS move · Q quit.

Ported from raylib's `examples/textures/textures_fog_of_war.c`.

![fog-of-war](../demos/fog-of-war.gif)

## Run it

```sh
cd fog-of-war && bb run   # from this demo (or lein run --disable-sandbox)
bb fog-of-war             # from the repo root
```

## About

raylib [textures] example - fog of war, ported to jank.

A 25x15 tile map hidden by fog: the player (ARROW keys) reveals
tiles around it; visited tiles fall back to half-fog. The fog is
drawn one pixel per tile into a tiny RenderTexture and upscaled
with bilinear filtering for the smooth look. Q quits.
Based on raylib/examples/textures/textures_fog_of_war.c
(jank-native: the C's two unsigned char* map arrays become jank
vectors of ints - tile ids fixed, fog state updated functionally
with mapv/assoc each frame.)
