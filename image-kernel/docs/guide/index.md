# image-kernel

Sharpen/sobel/gaussian convolution kernels.

Category: textures. Controls: watch · Q quit.

Ported from raylib's `examples/textures/textures_image_kernel.c`.

![image-kernel](../demos/image-kernel.gif)

## Run it

```sh
cd image-kernel && bb run   # from this demo (or lein run --disable-sandbox)
bb image-kernel             # from the repo root
```

It loads files from the vendored raylib checkout (`jank-raylib-sys/raylib/examples/textures/resources/`) by a path relative to this directory, so run it from here. The repo's `jank-raylib-sys/raylib` submodule has to be checked out.

## About

raylib [textures] example - image kernel, ported to jank.

The cat image put through three convolution kernels on the CPU -
sharpen, Sobel edge-detect, and a 6x-iterated Gaussian blur - shown
side by side with the untouched original. Q quits.
Based on raylib/examples/textures/textures_image_kernel.c

jank-native: ImageKernelConvolution wants a `float *kernel`. jank
builds one with cpp/MemAlloc plus cpp/unsafe-cast, filled element-wise
with cpp/aget and cpp/=; the array outlives the fn that made it because
MemAlloc is heap. Each Image is mutated through (cpp/& img).
