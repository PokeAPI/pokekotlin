[![Build](https://img.shields.io/github/workflow/status/pokeapi/pokekotlin/Java%20CI%20with%20Gradle?style=flat-square)][Build]
[![JitPack](https://img.shields.io/jitpack/v/github/PokeAPI/pokekotlin?style=flat-square)][Jitpack]

# PokeKotlin

Maintainer: [sargunv](https://github.com/sargunv)

This is a Kotlin (and Java, Scala, etc) client for [PokeApi](https://github.com/PokeAPI/pokeapi). It's written in Kotlin.

## Example

Full documentation coming soon. Meanwhile, look at these usage examples:

### Java

```java
public class Example {
    public static void main(String[] args) {
        PokeApi pokeApi = new PokeApiClient();
        PokemonSpecies bulbasaur = pokeApi.getPokemonSpecies(1);
        System.out.println(bulbasaur);
    }
}
```

### Kotlin

```kotlin
fun main(args: Array<String>) {
    val pokeApi = PokeApiClient()
    val bulbasaur = pokeApi.getPokemonSpecies(1)
    println(bulbasaur)
}
```

## Download

PokeKotlin is available from [Jitpack]. See the Releases tab for the latest version number.

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.PokeAPI:pokekotlin:<VERSION>'
}
```

[Build]: https://github.com/PokeAPI/pokekotlin/actions?query=workflow%3A%22Java+CI+with+Gradle%22
[Jitpack]: https://jitpack.io/#PokeAPI/pokekotlin/