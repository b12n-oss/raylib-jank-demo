# unicode-emojis

Click emojis for multilingual speech bubbles.

Category: text. Controls: hover + click emojis, SPACE re-roll, ESC.

Ported from raylib's `examples/text/text_unicode_emojis.c`.

![unicode-emojis](../demos/unicode-emojis.gif)

## Run it

```sh
cd unicode-emojis && bb run   # from this demo (or lein run --disable-sandbox)
bb unicode-emojis             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/text/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [text] example - unicode emojis, ported to jank.

A grid of 32 random emojis (Symbola font glyphs, not textures); hover
lights one up, click it to pop a speech bubble with a message in one
of a dozen languages (DejaVu for most, Noto CJK for Chinese/Korean/
Japanese), word-wrapped to the bubble. SPACE re-rolls the emojis and
messages. ESC quits.
Based on raylib/examples/text/text_unicode_emojis.c

jank-native notes:
- The C embeds 180 emojis as a \0-separated UTF-8 byte blob and walks
  char* offsets; the port stores plain codepoint ints (decoded from the
  C source) and draws each with DrawTextCodepoint. The 47 messages are
  real UTF-8 literals (proven in codepoints-loading).
- The C's DrawTextBoxed walks UTF-8 bytes; jank strings are opaque
  here, so the bubble text goes through LoadCodepoints (int* +
  out-param), advances come from glyphs[i].advanceX / recs[i].width
  via struct-array cpp/aget, and a pure-jank greedy breaker
  (break-lines) wraps at codepoint level - hard \n breaks, last-space
  word wrap, mid-word fallback (safe for the spaceless CJK messages).
- Emoji colors are Fade(ColorFromHSV(hue)) rebuilt inline at each draw
  from a stored hue int (rule 2); the message font is picked with an
  (if asian? font-asian font-default) let-local (same-type native
  branches are fine).
- All three BMFonts are create-once outer-let locals; no cpp/raw
  statics anywhere, so helper fns are safe.
- The C's FLAG_MSAA_4X_HINT | FLAG_VSYNC_HINT becomes the literal 96
  (0x20 | 0x40) - jank has no bitwise-or over enum constants.
- Faithful quirk kept: the C's grid puts 9 emojis on the first row
  (the newline check runs after drawing element i%8==0).
