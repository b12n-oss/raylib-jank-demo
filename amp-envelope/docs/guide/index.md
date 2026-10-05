# amp-envelope

An ADSR envelope on a tone, with a live shape graph.

Category: audio. Controls: hold SPACE play, Q/A W/S E/D R/F params, ESC.

Ported from raylib's `examples/audio/audio_amp_envelope.c`.

![amp-envelope](../demos/amp-envelope.gif)

## Run it

```sh
cd amp-envelope && bb run   # from this demo (or lein run --disable-sandbox)
bb amp-envelope             # from the repo root
```

## About

raylib [audio] example - amp envelope, ported to jank.

An ADSR amplitude envelope on a 440Hz tone: HOLD SPACE to play -
the gain rises through Attack, falls through Decay, holds at
Sustain and fades through Release when you let go. Q/A, W/S, E/D,
R/F adjust the four parameters, with the envelope shape drawn and a
live gain dot. ESC quits.
Based on raylib/examples/audio/audio_amp_envelope.c

jank-native notes:
- Envelope state (value, ADSR phase, audio time) is a jank atom,
  written once per refill rather than once per sample. The sample
  buffer stays native because UpdateAudioStream takes a pointer, and
  the AudioStream is boxed to cross the fn boundary.
- Affordable because the refill pulls from the main loop ~11 times a
  second, not from an audio callback. Callbacks are the one thing
  jank still cannot do (see cpp-interop-toolbox.md).
- The raygui slider bars become key pairs + drawn value bars; the
  ADSR shape visualization is pure jank math.
