# Usage with JS

## Overview

PokeKotlin is a Kotlin Multiplatform library that compiles to JavaScript, making
it compatible with Node.js and browser environments. The library provides a
Promise-based API for JavaScript interoperability.

## Installation with npm

This library is published to [npmjs.com], and snapshot builds of `main` are
additionally available on [GitHub Packages].

=== "Releases (npm)"

    The latest release is **v{{ gradle.release_version }}**. Install using npm:

    ```bash
    npm install @pokeapi/pokekotlin
    ```

=== "Snapshots (GitHub Packages)"

    !!! warning

        The published documentation is for the latest release, and may not match the snapshot
        version. If using snapshots, always refer to the [latest source code][repo] for the most
        accurate information.

    First, follow [GitHub's guide][gh-packages-guide] for authenticating to GitHub Packages. Your
    .npmrc should have something like this:

    ```ini title=".npmrc"
    @pokeapi:registry=https://npm.pkg.github.com
    //npm.pkg.github.com/:_authToken=YOUR_GITHUB_TOKEN
    ```

    The latest snapshot is **v{{ gradle.snapshot_version }}**. Install the dependency:

    ```bash
    npm install @pokeapi/pokekotlin@{{ gradle.snapshot_version }}
    ```

## Usage

### Example

For basic usage, use the global `PokeApi.Default` instance. The JavaScript API
uses Promises for asynchronous operations:

```javascript
import { PokeApi } from "@pokeapi/pokekotlin";

try {
  // Get a list of Pokémon species
  const list = await PokeApi.Default.getPokemonSpeciesListAsync(0, 10);

  for (const handle of list.results) {
    // Get each species by its handle
    const species = await PokeApi.Default.getAsync(handle);
    console.log(`Found: ${species}`);
  }
} catch (error) {
  console.error(`Error: ${error.message}`);
}
```

### Details

Every PokeApi endpoint has a corresponding asynchronous method in the `PokeApi`
instance that returns a `Promise`. By default, the client will connect to the
official `https://pokeapi.co/` instance and cache results in memory. To
customize the client, you can create your own instance of `PokeApi.Custom`.

For further details, see the Kotlin [API Reference](./api). Any function like
`suspend fun getExample()` available in the Kotlin API has a corresponding
JavaScript API like `async function getExampleAsync()` returning a `Promise`.

[npmjs.com]: https://www.npmjs.com/package/@pokeapi/pokekotlin
[GitHub Packages]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-npm-registry
[gh-packages-guide]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-npm-registry#installing-a-package
[repo]: https://github.com/pokeapi/pokekotlin
