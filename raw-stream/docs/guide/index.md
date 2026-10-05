# raw-stream

A sine wave generated sample-by-sample into a stream.

Category: audio. Controls: UP/DOWN frequency, LEFT/RIGHT pan, ESC.

Ported from raylib's `examples/audio/audio_raw_stream.c`.

![raw-stream](../demos/raw-stream.gif)

## Run it

```sh
cd raw-stream && bb run   # from this demo (or lein run --disable-sandbox)
bb raw-stream             # from the repo root
```

## About

raylib [audio] example - raw stream, ported to jank.

A sine wave GENERATED sample-by-sample into a raw 44.1kHz mono
float audio stream: UP/DOWN change the frequency (switched at zero
crossings so it never clicks), LEFT/RIGHT pan, and the same wave is
plotted on screen. ESC quits.
Based on raylib/examples/audio/audio_raw_stream.c

jank-native notes:
- FIRST RAW AUDIO STREAM: LoadAudioStream binds as a let-local like
  any create-once native; IsAudioStreamProcessed gates the refill.
- Oscillator state (sample index, live frequency, the GetTime of the
  last zero crossing) is a jank atom, written once per refill. The
  sample buffer stays native because UpdateAudioStream takes a
  pointer, and the AudioStream is boxed to cross the fn boundary.
- The waveform plot is jank cpp/sin math, one DrawLineV per column.
