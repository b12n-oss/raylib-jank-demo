# mixed-processor

A DSP distortion callback on the whole audio mix.

Category: audio. Controls: LEFT/RIGHT distortion, SPACE coin, ESC.

Ported from raylib's `examples/audio/audio_mixed_processor.c`.

![mixed-processor](../demos/mixed-processor.gif)

## Run it

```sh
cd mixed-processor && bb run   # from this demo (or lein run --disable-sandbox)
bb mixed-processor             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/audio/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [audio] example - mixed processor, ported to jank.

A DSP callback on the whole audio mix: every frame of the country
song (and any coin SPACE plays over it) passes through a distortion
that raises samples to an adjustable exponent, while a rolling
volume histogram draws on screen. LEFT/RIGHT change the distortion.
ESC quits.
Based on raylib/examples/audio/audio_mixed_processor.c

jank-native notes:
- FIRST AUDIO CALLBACK: jank cannot form C function pointers, but a
  callback DEFINED in the cpp/raw block is ordinary C - a sibling
  wrapper attaches ITS pointer with AttachAudioMixedProcessor. The
  callback runs on the audio thread against C statics (exponent +
  the 400-entry volume history); jank tunes the exponent through a
  setter and reads the history per column for the plot.
