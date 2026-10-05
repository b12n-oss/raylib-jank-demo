# stream-callback

A pull-model synth: sine/square/triangle/sawtooth on demand.

Category: audio. Controls: LEFT/RIGHT wave, UP/DOWN frequency, ESC.

Ported from raylib's `examples/audio/audio_stream_callback.c`.

![stream-callback](../demos/stream-callback.gif)

## Run it

```sh
cd stream-callback && bb run   # from this demo (or lein run --disable-sandbox)
bb stream-callback             # from the repo root
```

## About

raylib [audio] example - stream callback, ported to jank.

A software synthesizer where the audio thread PULLS its samples: a
SetAudioStreamCallback generator fills each buffer on demand.
LEFT/RIGHT cycle sine / square / triangle / sawtooth waves, UP/DOWN
change the frequency, and the last 10ms of generated audio is
plotted. ESC quits.
Based on raylib/examples/audio/audio_stream_callback.c

jank-native notes:
- SetAudioStreamCallback joins the proven callback set: all four
  wave generators live verbatim in cpp/raw sharing the oscillator
  statics + a one-second history buffer; jank switches between
  them by index through a wrapper picking from a C callback array.
- The waveform plot reads the history buffer per column through a
  double-returning accessor.
