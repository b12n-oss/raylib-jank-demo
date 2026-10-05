# input-actions

Remappable abstract actions (WASD/arrows) via a keyset map.

Category: core. Controls: WASD/arrows move · SPACE fire · TAB swap keyset · ESC.

Ported from raylib's `examples/core/core_input_actions.c`.

![input-actions](../demos/input-actions.gif)

## Run it

```sh
cd input-actions && bb run   # from this demo (or lein run --disable-sandbox)
bb input-actions             # from the repo root
```

## About

raylib [core] example - input actions, ported to jank.

Decodes input as abstract ACTIONS instead of raw keys, so a binding
can map to a key AND a gamepad button at once and be remapped freely.
Move the square with the movement action (WASD by default), SPACE
fires (recentres + flashes blue for one frame), TAB swaps to the
arrow-key set. ESC quits.
Based on raylib/examples/core/core_input_actions.c

jank-native notes: the C original keeps bindings in a native
`ActionInput[]` struct array mutated by SetActions* functions. jank
can't hold native values in a collection, but the bindings are just
int key/button IDs, so each keyset is a plain jank map
{action -> {:key K :button B}} - two immutable maps swapped by TAB,
no mutable array. The square position can't be a native Vector2 in
loop state (rule 2), so it's tracked as jank reals and the Vector2 is
built inline at DrawRectangleV.
