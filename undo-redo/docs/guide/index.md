# undo-redo

A grid player with a 26-slot undo/redo ring buffer.

Category: core. Controls: ARROWS move, SPACE color, CTRL+Z/Y undo/redo, ESC.

Ported from raylib's `examples/core/core_undo_redo.c`.

![undo-redo](../demos/undo-redo.gif)

## Run it

```sh
cd undo-redo && bb run   # from this demo (or lein run --disable-sandbox)
bb undo-redo             # from the repo root
```

## About

raylib [core] example - undo redo, ported to jank.

Move a player cell around a grid with the ARROWS and recolor it with
SPACE. Every state change is snapshotted into a 26-slot ring buffer;
CTRL+Z walks back through history and CTRL+Y walks forward. The buffer
is visualised along the bottom (gold = current, blue = recorded span,
green = redo-able span). ESC quits.
Based on raylib/examples/core/core_undo_redo.c

jank-native notes:
- The C snapshots a PlayerState struct into an RL_CALLOC'd ring buffer
  with memcpy and compares slots with memcmp. In jank the whole thing is
  ordinary data: player state is a `{:x :y :r :g :b}` map, the ring buffer
  is a vector of those maps, memcpy -> `assoc idx player`, memcmp -> `=`.
  No native structs, no allocation, no interop beyond the raylib draw
  calls - the ring-buffer index arithmetic is the point and it stays in
  pure jank.
- `draw-slot` can neither take nor return a native Color (rule 2), so it
  receives a keyword id and picks the concrete cpp/Color inline at each
  draw call.
