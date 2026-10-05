# sound-multi

Overlapping sound playback via sound aliases.

Category: audio. Controls: SPACE play (rapid = overlap) · Q quit.

Ported from raylib's `examples/audio/audio_sound_multi.c`.

![sound-multi](../demos/sound-multi.gif)

## Run it

```sh
cd sound-multi && bb run   # from this demo (or lein run --disable-sandbox)
bb sound-multi             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/audio/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [audio] example - sound multi, ported to jank.

Overlapping playback: one source Sound plus nine LoadSoundAlias
copies that share its sample data; each SPACE press plays the next
slot so rapid presses overlap. Q quits.
Based on raylib/examples/audio/audio_sound_multi.c
(jank-native: the C's Sound array becomes ten outer-let bindings
with a nested-if dispatch on the current slot id - the same idiom
image_generation uses for its nine textures.)
