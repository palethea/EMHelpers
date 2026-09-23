# EMHelpers (no longer maintained)

EMHelpers was a shared helper library for Palethea's Fabric client mods. It provided the HUD layout editor, config toggle and slider widgets, stored key combos, a keybind accessor, and text helpers.

It is no longer used, and this repository is archived.

## Why

EMHelpers was meant to be shared between EMUtils and EMSkyblock. EMSkyblock ended up with a different GUI design, which left EMUtils as the only user. Keeping a separate library for a single mod added work without any benefit:

- EMUtils had to build EMHelpers from a checkout next to its own and bundle it into its jar, so EMUtils couldn't be built from its own repository alone.
- Every new Minecraft version meant porting two projects instead of one.

## Where the code went

The code now lives in [EMUtils](https://github.com/palethea/EMUtils) under `net.emutils.client.emutils`, with the same subpackages and class names. It moved in [palethea/EMUtils#71](https://github.com/palethea/EMUtils/pull/71).

## Source history

The last version of the source, including the final changes EMUtils shipped with, is on the [`legacy`](https://github.com/palethea/EMHelpers/tree/legacy) branch. Earlier history is there too.

## License

EMHelpers is licensed under the [Apache License 2.0](LICENSE).
