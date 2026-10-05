# strings-management

Drag/slice/shatter/glue text; 1-6 run TextTo* fns.

Category: text. Controls: L-mouse grab/throw, R-mouse slice (+Shift shatter), M-mouse shake, L-Ctrl glue, 1-6 reset, ESC.

Ported from raylib's `examples/text/text_strings_management.c`.

![strings-management](../demos/strings-management.gif)

## Run it

```sh
cd strings-management && bb run   # from this demo (or lein run --disable-sandbox)
bb strings-management             # from the repo root
```

## About

raylib [text] example - strings management, ported to jank.

An interactive text-particle physics toy that showcases raylib's C
string API. A phrase starts as one draggable, bouncing text box;
grab/throw it with the left mouse, slice it in half with the right
mouse, shatter it into single chars with Shift+right, glue two
particles by dragging with Left-Ctrl, or (when only one remains) slice
it on a typed char. Keys 1-6 reset the phrase through
TextToUpper/Lower/Pascal/Snake/Camel. Middle mouse shakes them all.
Based on raylib/examples/text/text_strings_management.c (3/4).

jank-native notes:
- raylib's TextX API is called directly, since demonstrating it is the
  point of the example: TextToUpper/Lower/Pascal/Snake/Camel,
  TextSubtext, TextSplit, TextLength and MeasureText all take a jank
  string (which converts to const char*) and their const char* returns
  fold back with str. TextSplit's const char** plus int* out-param
  reads back with (cpp/& n) and cpp/aget.
- TextFormat is the exception: it is variadic, and jank has no va_list
  handling. Its two uses here are a one-char substring and a
  concatenation, so they are subs and str.
- A particle is a plain jank map. The C's struct is a char[] plus a
  Rectangle, two Vector2s, floats, a Color and a bool - all of which
  are strings or numbers, so nothing needs boxing and the pool is an
  ordinary jank vector threaded through recur. The grabbed pointer
  becomes an index.
- padding / borderWidth / friction / elasticity are per-particle
  fields in the C that it never varies, so they are constants here.
