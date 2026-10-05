# words-alignment

Align a word inside a rectangle.

Category: text. Controls: L/R h-align · U/D v-align · Q quit.

Ported from raylib's `examples/text/text_words_alignment.c`.

![words-alignment](../demos/words-alignment.gif)

## Run it

```sh
cd words-alignment && bb run   # from this demo (or lein run --disable-sandbox)
bb words-alignment             # from the repo root
```

## About

raylib [text] example - words alignment, ported to jank.

One word (cycling each second) is aligned inside a rectangle: LEFT and
RIGHT arrows pick the horizontal alignment, UP and DOWN the vertical.
Q quits.
Based on raylib/examples/text/text_words_alignment.c
(jank-native: TextSplit becomes a literal word vector; the default
Font lives in a let outside the frame loop like a RenderTexture, and
MeasureTextEx's Vector2 return is read via .-x / .-y field access.
Lerp from 0 is plain multiplication.)
