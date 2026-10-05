# embedded-files

A logo and a sound compiled into the binary as C arrays.

Category: others. Controls: SPACE plays the sound, Q.

Ported from raylib's `examples/others/embedded_files_loading.c`.

![embedded-files](../demos/embedded-files.gif)

## Run it

```sh
cd embedded-files && bb run   # from this demo (or lein run --disable-sandbox)
bb embedded-files             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/others/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [others] example - embedded files loading, ported to jank.

A logo and a sound compiled INTO the binary as C arrays rather than
read from disk. SPACE plays the sound, Q quits.
Based on raylib/examples/others/embedded_files_loading.c
(jank-native: the C builds Wave and Image with designated initialisers,
which jank has no syntax for. Both are allocated zeroed with a no-arg
cpp/new - that is the C's = {0} - and each field is then written with
cpp/=. Their #define constants and static arrays are then ordinary
cpp/ symbols.

The two generated data headers come in through ordinary :include. A
path starting with ./ makes jank emit a QUOTED include instead of an
angled one, so it resolves against the demo's working
directory. Note the ./ is load-bearing even though the path then goes
up: a bare ../ prefix is still emitted angled and is not found. See
docs/guide/cpp-interop-toolbox.md.)
