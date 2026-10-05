# vr-simulator

A 3D scene in stereo through a simulated Oculus Rift.

Category: core. Controls: mouse look (first-person), ESC.

Ported from raylib's `examples/core/core_vr_simulator.c`.

![vr-simulator](../demos/vr-simulator.gif)

## Run it

```sh
cd vr-simulator && bb run   # from this demo (or lein run --disable-sandbox)
bb vr-simulator             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/core/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [core] example - vr simulator, ported to jank.

Renders a simple 3D scene (a red cube on a grid) in stereo through a
simulated Oculus Rift CV1: the scene is drawn twice into an HMD-sized
RenderTexture inside BeginVrStereoMode, then a lens-distortion +
chromatic-aberration fragment shader warps that texture onto the
window. No headset required - it is a *simulator*. Move with the mouse
(first-person camera). ESC quits.
Based on raylib/examples/core/core_vr_simulator.c (3/4 complexity).

jank-native notes:
- The whole VR pipeline is native values: a VrDeviceInfo whose scalar
  and float[] fields are filled with cpp/=, the VrStereoConfig from
  LoadVrStereoConfig, the distortion Shader (fed
  config.leftLensCenter / device.lensDistortionValues array pointers
  straight into SetShaderValue's void*), the HMD-sized RenderTexture
  and the first-person Camera. Each is boxed where it is created, so
  init, the stereo render, the distortion blit and cleanup are all
  jank.
