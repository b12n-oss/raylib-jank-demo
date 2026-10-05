# raylib-jank-demo

213 [raylib](https://github.com/raysan5/raylib) examples ported to
[jank](https://jank-lang.org), the native Clojure dialect on C++/LLVM, each one
its own small Leiningen project. They started life in
[raylib-jnk](https://github.com/b12n-oss/raylib-jnk), whose guide to jank's
C++ interop explains how they're written. raylib itself comes from the
official [`org.jank-lang.commons/raylib-sys`](https://github.com/jank-lang/commons)
package.

You need Leiningen, a working jank, babashka for the tasks, and git (for the
asset submodule). The demos are macOS-first; `--disable-sandbox` is on every run
because macOS has no `bwrap`.

## Layout

```
bb.edn                        root tasks: info, list, run, run-all, check, lint,
                              doctor, clean, gen, record, sync-recordings, plus
                              one task per demo
demos.edn                     every demo's name, category, description, controls
                              and upstream source
common/src/net/b12n/raylib_jnk/
                              the shared helpers: rlights, shaders, models,
                              rendertex (net.b12n.raylib-jnk.<name>)
jank-raylib-sys/raylib        git submodule: raylib 6.0, kept only for the
                              example assets (shaders, models, textures, audio)
<demo>/                       213 of these, e.g. basic-lighting/
  project.clj                 lein-jank, raylib-sys, ../common/src on the source path
  bb.edn                      a `run` task
  src/net/b12n/raylib_jnk/scenes/<demo>.jank
  docs/guide/index.md         what it shows, its controls, where it was ported from
  docs/demos/<demo>.gif       its recording (211 of the 213 have one)
target/                       the shared build cache every demo writes to (ignored)
docs/                         the site: site.edn, guide/index.md, the generated
                              guide/demos.md gallery, and a second copy of every
                              recording in demos/
scripts/                      gen.clj, check.clj, sync_recordings.clj and the
                              screen-grab manifest for `bb record`
.clj-kondo/                   lint config that teaches clj-kondo about jank
```

Each demo's namespace is `net.b12n.raylib-jnk.scenes.<demo>`, matching its
folder. In raylib-jnk they were `raylib-examples.<demo>`.

Every demo builds into the root `target/`, so the native build of raylib-sys
happens once, on the first demo you run. After that, `basic-lighting` opened
its window about 10 seconds after a first-ever `bb run`, compile included.

## Running

Start with `bb doctor`. It checks for Leiningen, a jank that starts, and the
asset submodule.

```sh
git clone --recurse-submodules https://github.com/b12n-oss/raylib-jank-demo
cd raylib-jank-demo
bb doctor
bb starfield            # from the root, run in the demo's own directory
cd starfield && bb run  # the same, from inside the demo
```

```sh
bb info           # grouped cheat-sheet, every demo included
bb list           # flat list with descriptions
bb run-all 4      # every demo for 4 seconds each, exits 1 if any fail
bb check          # offline gates; compiles nothing
bb clean          # remove the shared build cache
```

A demo always runs from its own directory, because the ones that load assets
reach them as `../jank-raylib-sys/raylib/examples/...`. The tasks fetch the
submodule if it's missing.

**Which jank runs.** lein-jank calls the first `jank` on your PATH. Set
`JANK=/path/to/jank` to choose another, and `LEIN=/path/to/lein` likewise for
Leiningen. A source-built jank stops working when Homebrew upgrades the LLVM
it was linked against, and `bb doctor` says so. Homebrew's own jank
(`brew install jank`) is a working fallback:

```sh
JANK=/opt/homebrew/opt/jank/bin/jank bb starfield
```

## Checks

jank can't be compiled in a per-PR job (building it means building Clang), so
`bb check` runs everything that fails before the compiler would:

- every `.jank` source reads to EOF, which catches unbalanced parens
- the tooling's EDN parses
- `bb gen --check`: `demos.edn`, the demo directories, the per-demo tasks and
  the gallery agree
- `bb sync-recordings --check`: each demo's recording matches the site's copy

`bb lint` runs clj-kondo over every `.jank` source, passing them by name
because clj-kondo skips `.jank` files when given a directory. It reports 0
warnings today.

## Adding a demo

1. Create `<demo>/src/net/b12n/raylib_jnk/scenes/<demo>.jank`, with the
   namespace `net.b12n.raylib-jnk.scenes.<demo>` and a `-main`.
2. Copy `project.clj` and `bb.edn` from any existing demo and change the names.
3. Add a line for it to `demos.edn`.
4. Run `bb gen`. It adds the root task and the gallery entry.
5. Write its `docs/guide/index.md`, and put its recording in both
   `<demo>/docs/demos/` and `docs/demos/`.

## Recording the GIFs

Every recording is committed. `bb record` regenerates them through
[screen-grab](https://github.com/burinc/b12n-screen-grab), an internal capture
tool that isn't publicly released, and says so if it's missing. The manifest is
`scripts/demo_manifest.edn`; afterwards `bb record` runs `bb sync-recordings`
and `bb gen`. `rlgl-compute` is left out: it needs OpenGL 4.3, and macOS stops
at 4.1.

## The site

`docs/` builds with [docs-engine](https://github.com/jlt-commons/docs-engine)
into a gallery of every demo:

```sh
(cd ../docs-engine && jolt run build ../raylib-jank-demo)
BASE_PATH=/raylib-jank-demo bash docs/check-site.sh
```

## License

EPL 2.0, inherited from raylib-jnk. See `LICENSE`. The demos are ports of
raylib's examples, which are zlib, and `NOTICE` carries those terms along with
the rest of the project's history.
