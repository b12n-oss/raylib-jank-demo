# music-stream

Stream an MP3 with pan/volume/progress controls.

Category: audio. Controls: SPACE restart · P pause · L/R pan · U/D volume · Q.

Ported from raylib's `examples/audio/audio_music_stream.c`.

![music-stream](../demos/music-stream.gif)

## Run it

```sh
cd music-stream && bb run   # from this demo (or lein run --disable-sandbox)
bb music-stream             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/audio/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [audio] example - music stream, ported to jank.

An MP3 streamed with UpdateMusicStream called every frame, with a
progress bar and live pan/volume sliders. SPACE restarts, P
pauses/resumes, LEFT/RIGHT pan, UP/DOWN volume, Q quits.
Based on raylib/examples/audio/audio_music_stream.c
(jank-native: the Music struct is an outer-let local like a
Texture2D; GetMusicTimePlayed/GetMusicTimeLength returns are boxed
with (+ 0.0 ...) at the binding site before jank arithmetic.)
