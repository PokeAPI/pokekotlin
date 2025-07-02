# Usage with Java

## Overview

PokeKotlin is a Kotlin Multiplatform library that compiles to JVM bytecode,
making it compatible with Java projects. The library provides both asynchronous
(`CompletableFuture`-based) and blocking APIs for Java interoperability.

## Installation

### Gradle

This library is published via [Maven Central], and snapshot builds of `main` are
additionally available on [GitHub Packages][gh-packages-gradle].

=== "Releases (Maven Central)"

    The latest release is **v{{ gradle.release_version }}**. In your Gradle build script, add:

    ```groovy title="build.gradle"
    dependencies {
        implementation 'co.pokeapi.pokekotlin:pokekotlin-jvm:{{ gradle.release_version }}'
    }
    ```

    Or if using Kotlin DSL:

    ```kotlin title="build.gradle.kts"
    dependencies {
        implementation("co.pokeapi.pokekotlin:pokekotlin-jvm:{{ gradle.release_version }}")
    }
    ```

=== "Snapshots (GitHub Packages)"

    !!! warning

        The published documentation is for the latest release, and may not match the snapshot
        version. If using snapshots, always refer to the [latest source code][repo] for the most
        accurate information.

    First, follow [GitHub's guide][gh-packages-guide-gradle] for authenticating to GitHub Packages. Your
    build.gradle should have something like this:

    ```groovy title="build.gradle"
    repositories {
        maven {
            url = "https://maven.pkg.github.com/pokeapi/pokekotlin"
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("GH_USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("GH_TOKEN")
            }
        }
    }
    ```

    The latest snapshot is **v{{ gradle.snapshot_version }}**. Add the dependency:

    ```groovy title="build.gradle"
    dependencies {
        implementation 'co.pokeapi.pokekotlin:pokekotlin-jvm:{{ gradle.snapshot_version }}'
    }
    ```

### Maven

=== "Releases (Maven Central)"

    The latest release is **v{{ gradle.release_version }}**. In your pom.xml, add:

    ```xml title="pom.xml"
    <dependency>
        <groupId>co.pokeapi.pokekotlin</groupId>
        <artifactId>pokekotlin-jvm</artifactId>
        <version>{{ gradle.release_version }}</version>
    </dependency>
    ```

=== "Snapshots (GitHub Packages)"

    !!! warning

        The published documentation is for the latest release, and may not match the snapshot
        version. If using snapshots, always refer to the [latest source code][repo] for the most
        accurate information.

    First, configure [GitHub Packages][gh-packages-guide-maven] authentication in your settings.xml
    or pom.xml:

    ```xml title="pom.xml"
    <repositories>
        <repository>
            <id>github</id>
            <url>https://maven.pkg.github.com/pokeapi/pokekotlin</url>
        </repository>
    </repositories>
    ```

    The latest snapshot is **v{{ gradle.snapshot_version }}**. Add the dependency:

    ```xml title="pom.xml"
    <dependency>
        <groupId>co.pokeapi.pokekotlin</groupId>
        <artifactId>pokekotlin-jvm</artifactId>
        <version>{{ gradle.snapshot_version }}</version>
    </dependency>
    ```

## Usage

For basic usage, use the global `PokeApi.Default` instance.

### Asynchronous API (Recommended)

For asynchronous usage with CompletableFuture:

```java
public class AsyncExample {
  public static void main(String[] args) {
    // Get a list of Pokémon species
    PokeApi.Default.getPokemonSpeciesListAsync(0, 10).thenAccept(list -> {
      for (NamedHandle<PokemonSpecies> handle : list.getResults()) {
        // Get each species by its handle
        PokeApi.Default.getAsync(handle).thenAccept(species ->
          System.out.println("Found: " + species)
        ).exceptionally(e -> {
          System.err.println("Error fetching species: " + e.getMessage());
          e.printStackTrace();
          return null;
        });
      }
    }).exceptionally(e -> {
      System.err.println("Error fetching species list: " + e.getMessage());
      e.printStackTrace();
      return null;
    });
  }
}
```

### Blocking API

For synchronous/blocking usage:

```java
public class BlockingExample {
  public static void main(String[] args) {
    try {
      // Get a list of Pokémon species
      PaginatedList<PokemonSpecies> list = PokeApi.Default.getPokemonSpeciesListBlocking(0, 10);

      for (Handle<PokemonSpecies> handle : list.getResults()) {
        // Get each species by its handle
        PokemonSpecies species = PokeApi.Default.getBlocking(handle);
        System.out.println("Found: " + species);
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
```

### Further details

Every PokeApi endpoint has a corresponding asynchronous and blocking method in
the `PokeApi` instance. By default, the client will connect to the official
`https://pokeapi.co/` instance and cache results in memory. To customize the
client, you can create your own instance of `PokeApi.Custom`.

For further details, see the Kotlin [API Reference](./api). Any function like
`suspend fun getExample()` available in the Kotlin API has corresponding Java
APIs like `CompletableFuture<Example> getExampleAsync()` for asynchronous
access, or `Example getExampleBlocking()` for synchronous access.

[Maven Central]: https://central.sonatype.com/namespace/co.pokeapi.pokekotlin
[gh-packages-gradle]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry
[gh-packages-guide-gradle]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package
[gh-packages-guide-maven]:
  https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#installing-a-package
[repo]: https://github.com/pokeapi/pokekotlin
