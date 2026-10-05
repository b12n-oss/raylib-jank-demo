# custom-logging

A trace-log callback timestamps every raylib line.

Category: core. Controls: watch the console, ESC.

Ported from raylib's `examples/core/core_custom_logging.c`.

![custom-logging](../demos/custom-logging.gif)

## Run it

```sh
cd custom-logging && bb run   # from this demo (or lein run --disable-sandbox)
bb custom-logging             # from the repo root
```

## About

raylib [core] example - custom logging, ported to jank.

Installs a custom trace-log callback that prefixes every raylib log
line with a timestamp and a [INFO]/[ERROR]/[WARN]/[DEBUG] tag, then
opens a window whose only job is to point you at the console. Watch
stdout: the whole raylib init/shutdown log is reformatted by our
callback.
Based on raylib/examples/core/core_custom_logging.c (3/4 complexity).

jank-native notes:
- `SetTraceLogCallback` wants a C function pointer of type
  `void (*)(int, const char*, va_list)` - a shape jank can't hand it
  from jank code. So the callback (with its time()/strftime()/vprintf
  va_list machinery) is defined verbatim in a cpp/raw block as
  ordinary C, and a sibling C wrapper (jank_cl_set_logger) hands its
  pointer to SetTraceLogCallback - the same define-in-cpp/raw,
  attach-via-sibling-wrapper pattern the audio callback examples use.
  It must run BEFORE InitWindow to capture the init logs, so jank
  calls it first, then owns the window lifecycle, the frame loop and
  the drawing.
