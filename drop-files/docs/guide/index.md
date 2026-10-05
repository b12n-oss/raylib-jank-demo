# drop-files

Drag files onto the window to list their paths.

Category: core. Controls: drag & drop files, ESC.

Ported from raylib's `examples/core/core_drop_files.c`.

![drop-files](../demos/drop-files.gif)

## Run it

```sh
cd drop-files && bb run   # from this demo (or lein run --disable-sandbox)
bb drop-files             # from the repo root
```

## About

raylib [core] example - drop files, ported to jank.

Drag files from your OS file manager onto the window and their paths are
listed (new drops append to the list). ESC quits.
Based on raylib/examples/core/core_drop_files.c

jank-native notes:
- The C preallocates a fixed char*[4096] and TextCopy's each dropped path
  into it. jank just keeps a growing vector of path strings and conj's new
  drops on - no preallocation, no fixed cap.
- IsFileDropped + LoadDroppedFiles return a FilePathList (char** paths) by
  value; jank can't carry it across frames (rule 2), so each drop is
  snapshotted into the jank vector immediately (paths[i] via `cpp/aget`,
  the same reading directory-files uses) and UnloadDroppedFiles frees
  the native list.
