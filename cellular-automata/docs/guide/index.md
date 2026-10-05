# cellular-automata

Wolfram rule cellular automaton, editable rule.

Category: textures. Controls: click rule bits / presets · Q quit.

Ported from raylib's `examples/textures/textures_cellular_automata.c`.

![cellular-automata](../demos/cellular-automata.gif)

## Run it

```sh
cd cellular-automata && bb run   # from this demo (or lein run --disable-sandbox)
bb cellular-automata             # from the repo root
```

## About

raylib [textures] example - cellular automata, ported to jank.

A 1-D elementary cellular automaton (Wolfram rules) grown line by
line into an Image and streamed to a texture with UpdateTexture. Click
the eight rule-output bits to toggle them, or click a preset (18, 30,
60, ...) to load a classic rule; either resets the automaton. Q quits.
Based on raylib/examples/textures/textures_cellular_automata.c

jank-native: the automaton lives in one mutable Image (outer-let
local); each frame ComputeLine reads the previous row with
GetImageColor and writes the next with ImageDrawPixel through
(cpp/& image), then UpdateTexture streams image.data (a void*) to the
texture. Rule maths use jank's bit-and / bit-xor / bit-shift-* ops.
