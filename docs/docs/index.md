# Overview

## Introduction

PokeKotlin is a modern [Kotlin Multiplatform] client for [PokéAPI]. You can use
it to integrate all sorts of Pokémon data into your Kotlin, Java, JS, or Swift
projects.

Under the hood, it's built on [Ktor], [Kotlin Serialization], and [coroutines].

## Features

- **Multiplatform**: Works on JVM, Node, the web, and native platforms like iOS,
  macOS, Linux, and Windows.
- **Caching**: Uses Ktor's built-in caching to reduce API calls and speed up
  responses.
- **Asynchronous**: Built on coroutines for non-blocking calls.

## Languages

### Kotlin

On Kotlin, we support all major Kotlin Multiplatform targets, including JVM, JS,
and native platforms like iOS and macOS. The API is based on `suspend fun`
calls:

```kotlin
fun main() = runBlocking {
  with(PokeApi) {
    val list = getPokemonSpeciesList(offset = 0, limit = 10)
    for (handle in list.results) {
      val species = handle.get()
      println("Found: $species")
    }
  }
}
```

On JVM targets, the Java APIs below are also available. Similarly, on JS
targets, the JavaScript APIs below are available.

### Java

For Java, we provide an API based on `CompletableFuture`:

```java
public class Example {
  public static void main(String[] args) {
    PokeApi.getPokemonSpeciesListAsync(0, 10).thenAccept(list -> {
      for (NamedHandle<PokemonSpecies> handle : list.getResults()) {
        PokeApi.getAsync(handle).thenAccept(species -> {
          System.out.println("Found: " + species);
        });
      }
    });
  }
}
```

We also provide a synchronous API:

```java
public class Example {
  public static void main(String[] args) {
    PokemonSpeciesList list = PokeApi.getPokemonSpeciesListBlocking(0, 10);
    for (NamedHandle<PokemonSpecies> handle : list.getResults()) {
      PokemonSpecies species = PokeApi.getBlocking(handle);
      System.out.println("Found: " + species);
    }
  }
}
```

### JS

For JavaScript, we provide an ESM module with TypeScript typings and a
`Promise`-based API that works in browsers and in Node:

```typescript
import { PokeApi } from "@pokeapi/pokekotlin";

const list = await PokeApi.Default.getPokemonSpeciesListAsync(0, 10);
for (const handle of list.results) {
  const species = await PokeApi.Default.getAsync(handle);
  console.log(`Found: ${species}`);
}
```

### Swift

The Swift package is not yet published.

[Kotlin Multiplatform]: https://kotlinlang.org/docs/multiplatform.html
[PokéAPI]: https://pokeapi.co/
[Ktor]: https://ktor.io/
[Kotlin Serialization]: https://github.com/Kotlin/kotlinx.serialization
[coroutines]: https://kotlinlang.org/docs/coroutines-guide.html
