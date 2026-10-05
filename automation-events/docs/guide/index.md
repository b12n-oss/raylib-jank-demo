# automation-events

A platformer recording and replaying its own input.

Category: core. Controls: LEFT/RIGHT move, SPACE jump, R reset, S record, A replay, ESC.

Ported from raylib's `examples/core/core_automation_events.c`.

![automation-events](../demos/automation-events.gif)

## Run it

```sh
cd automation-events && bb run   # from this demo (or lein run --disable-sandbox)
bb automation-events             # from the repo root
```

## About

raylib [core] example - automation events, ported to jank.

A small platformer whose input can be RECORDED and REPLAYED. Arrow
keys move, SPACE jumps, R resets, S starts/stops recording (exported
to automation.rae), A replays the last recording, and dropping a
.rae/.txt file loads and replays it. Mouse wheel zooms. ESC quits.
Based on raylib/examples/core/core_automation_events.c

jank-native notes:
- The player, the five environment elements and all the recording
  state are plain jank data: a Vector2 is two numbers and a Rectangle
  is four, so the whole simulation threads through recur with nothing
  boxed.
- Two things are genuinely native. The Camera2D is boxed because
  BeginMode2D and GetWorldToScreen2D want the struct. The
  AutomationEventList is boxed IN AN ATOM, because dropping a file
  replaces it at runtime and a create-once let-local could not be
  rebound (the viewport-scaling pattern).
- An AutomationEvent is read out of the list with cpp/aget and passed
  straight to PlayAutomationEvent in the same form, so it never has to
  cross a fn boundary.
- TextFormat is variadic and unavailable, so the two readouts are str.
