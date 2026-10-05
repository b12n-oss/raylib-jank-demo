# stream-effects

Stackable lowpass + delay effects on one music stream.

Category: audio. Controls: F lowpass, D delay, SPACE restart, P pause, ESC.

Ported from raylib's `examples/audio/audio_stream_effects.c`.

![stream-effects](../demos/stream-effects.gif)

## Run it

```sh
cd stream-effects && bb run   # from this demo (or lein run --disable-sandbox)
bb stream-effects             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/audio/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [audio] example - stream effects, ported to jank.

DSP effects attached to ONE music stream (not the whole mix): F
toggles a 70Hz lowpass filter, D a one-second delay - both can
stack. SPACE restarts the song, P pauses. ESC quits.
Based on raylib/examples/audio/audio_stream_effects.c

jank-native notes:
- Per-STREAM audio callbacks (AttachAudioStreamProcessor on
  music.stream), the mixed-processor pattern: both effect callbacks
  live verbatim in cpp/raw with their filter/ring-buffer statics,
  and toggle wrappers attach/detach them; the delay's RL_CALLOC'd
  ring buffer gets init/free wrappers.
- The Music struct passes into the toggle shims by value; the
  stream field access happens in C.
