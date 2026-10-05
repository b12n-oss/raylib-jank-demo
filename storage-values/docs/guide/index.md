# storage-values

Save/load a score pair to a binary storage file.

Category: core. Controls: R random, ENTER save, SPACE load, ESC.

Ported from raylib's `examples/core/core_storage_values.c`.

![storage-values](../demos/storage-values.gif)

## Run it

```sh
cd storage-values && bb run   # from this demo (or lein run --disable-sandbox)
bb storage-values             # from the repo root
```

## About

raylib [core] example - storage values, ported to jank.

A score / hi-score pair persisted to a binary storage file. R rolls new
random values, ENTER saves them to storage.data, SPACE loads them back
(0 when the file is missing). ESC quits.
Based on raylib/examples/core/core_storage_values.c

jank-native notes:
- SaveStorageValue / LoadStorageValue are the C example's own module
  functions, not raylib API. The save half is RL_REALLOC buffer surgery
  (grow the file to fit a byte position, poke an i32 into it) with no
  jank surface at all, so it stays C. This is one of the examples that
  keeps its C deliberately.
- The load half IS expressed in jank: LoadFileData with the int*
  out-param pattern ((cpp/int 0) + (cpp/& size), the gif-player trick),
  cpp/unsafe-cast to reinterpret the unsigned char* as int* before
  cpp/aget subscripts it, and
  UnloadFileData when done (free(NULL) is safe on the missing-file path).
- The C's TextFormat readouts become str; the storage file lands in the
  working directory like the C (gitignored).
