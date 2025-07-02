# Usage with Kotlin

## Overview

PokeKotlin is a pure Kotlin library, so we can support all platforms that are
supported by our dependencies. If we're missing one, please file an issue. We
currently support:

- Kotlin/JVM, including Android
- Kotlin/JS for browser and Node
- Kotlin/WASM for browser and Node
- Kotlin/Native for Linux, Windows, macOS, iOS, tvOS, and watchOS

## Installation with Gradle

This library is published via [Maven Central], and snapshot builds of `main` are
additionally available on [GitHub Packages].

=== "Releases (Maven Central)"

    The latest release is **v{{ gradle.release_version }}**. In your Gradle version catalog, add:

    ```toml title="libs.versions.toml"
    [libraries]
    pokekotlin = { module = "co.pokeapi.pokekotlin:pokekotlin", version = "{{ gradle.release_version }}" }
    ```

=== "Snapshots (GitHub Packages)"

    !!! warning

        The published documentation is for the latest release, and may not match the snapshot
        version. If using snapshots, always refer to the [latest source code][repo] for the most
        accurate information.

    First, follow [GitHub's guide][gh-packages-guide] for authenticating to GitHub Packages. Your
    settings.gradle.kts should have something like this:

    ```kotlin title="settings.gradle.kts"
    repositories {
      maven {
        url = uri("https://maven.pkg.github.com/pokeapi/pokekotlin")
        credentials {
          username = project.findProperty("gpr.user") as String? ?: System.getenv("GH_USERNAME")
          password = project.findProperty("gpr.key") as String? ?: System.getenv("GH_TOKEN")
        }
      }
    }
    ```

    The latest snapshot is **v{{ gradle.snapshot_version }}**. In your Gradle version catalog, add:

    ```toml title="libs.versions.toml"
    [libraries]
    pokekotlin = { module = "co.pokeapi.pokekotlin:pokekotlin", version = "{{ gradle.snapshot_version }}" }
    ```

In your Gradle build script, add:

```kotlin title="build.gradle.kts"
commonMain.dependencies {
  implementation(libs.pokekotlin)
}
```

## Usage

For basic usage, use the global `PokeApi` instance:

```kotlin
fun main() = runBlocking {
  with(PokeApi) {
    runCatching {
      // Get a list of Pokémon species
      val list = getPokemonSpeciesList(0, 10)

      for (handle in list.results) {
        // Get each species by its handle
        val species = handle.get()
        println("Species: $species")
      }
    }.onFailure { e ->
      println("Error: ${e.message}")
    }
  }
}
```

Every PokeApi endpoint has a corresponding `suspend fun` method in the `PokeApi`
instance. By default, the client will connect to the official
`https://pokeapi.co/` instance and cache results in memory. To customize the
client, you can create your own instance of `PokeApi.Custom`.

For further details, see the Dokka [API Reference](./api).

[Maven Central]: https://central.sonatype.com/namespace/co.pokeapi.pokekotlin
[GitHub Packages]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry
[gh-packages-guide]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package
[repo]: https://github.com/pokeapi/pokekotlin
[Ktor]: https://ktor.io/
[Kotlin Serialization]: https://github.com/Kotlin/kotlinx.serialization
[coroutines]: https://kotlinlang.org/docs/coroutines-guide.html
