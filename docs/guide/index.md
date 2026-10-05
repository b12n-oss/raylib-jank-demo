# raylib-jank-demo

213 [raylib](https://github.com/raysan5/raylib) examples ported to
[jank](https://jank-lang.org), each one its own small Leiningen project with a
`project.clj`, a `bb.edn` and one source file. raylib comes from the official
`org.jank-lang.commons/raylib-sys` package, and the four helpers several demos
share live in `common/`.

The [gallery](demos.md) shows every demo with its recording.

## Getting it running

You need Leiningen, a working jank and babashka. The demos are macOS-first.

```sh
git clone --recurse-submodules https://github.com/b12n-oss/raylib-jank-demo
cd raylib-jank-demo
bb doctor                      # Leiningen, a jank that starts, the asset submodule
bb starfield                   # from the repo root
cd starfield && bb run         # from inside the demo
```

The first demo you run builds raylib-sys natively into the shared `target/`.
Every later demo reuses that build, and opens in seconds rather than minutes.
If `bb doctor` says your jank can't start, point `JANK` at one that can, such
as Homebrew's: `JANK=/opt/homebrew/opt/jank/bin/jank bb starfield`.

## How a demo is laid out

```
basic-lighting/
  project.clj                    lein-jank, raylib-sys, ../common/src on the source path
  bb.edn                         the `run` task
  src/net/b12n/raylib_jnk/scenes/basic_lighting.jank
  docs/guide/index.md            what it shows, its controls, where it was ported from
  docs/demos/basic-lighting.gif
```

A demo runs from its own directory, which is where its asset paths
(`../jank-raylib-sys/raylib/examples/...`) resolve against the repo's raylib
submodule.

## Where the examples came from

They were split out of [raylib-jnk](https://github.com/b12n-oss/raylib-jnk),
which keeps the guide to jank's C++ interop that explains how they're written.
All but one are ports of raylib's own example programs, and each demo's page
names the original. The
[NOTICE](https://github.com/b12n-oss/raylib-jank-demo/blob/main/NOTICE) file
carries the licence terms.
