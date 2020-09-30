[![Bintray](https://img.shields.io/bintray/v/sargunv/maven/pokekotlin)](https://bintray.com/sargunv/maven/pokekotlin)
[![JitPack](https://img.shields.io/jitpack/v/github/PokeAPI/pokekotlin)](https://jitpack.io/#PokeAPI/pokekotlin/)
[![License](https://img.shields.io/github/license/PokeAPI/pokekotlin)](https://github.com/PokeAPI/pokekotlin/blob/master/LICENSE)
[![Build](https://img.shields.io/github/workflow/status/pokeapi/pokekotlin/Java%20CI%20with%20Gradle)](https://github.com/PokeAPI/pokekotlin/actions?query=workflow%3A%22Java+CI+with+Gradle%22)
[![Codecov](https://img.shields.io/codecov/c/github/PokeAPI/pokekotlin)](https://codecov.io/gh/PokeAPI/pokekotlin)

# PokeKotlin

Maintainer: [sargunv](https://github.com/sargunv)

This is a Kotlin (and Java, Scala, etc) client for [PokeApi](https://github.com/PokeAPI/pokeapi). It's written in Kotlin
(Kotlin is basically like Java, C and C++ also is a “statically typed programming language”. Statically typed programming languages are those languages in which variables need not be defined before they are used.)

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

PokeKotlin is available from Bintray or Jitpack. The latest version number is: ![Bintray](https://img.shields.io/bintray/v/sargunv/maven/pokekotlin?label)

```groovy
repositories {
    mavenCentral()
    maven { url 'https://dl.bintray.com/sargunv/maven' }
}
dependencies {
    implementation 'me.sargunvohra.lib:pokekotlin:<VERSION>'
}
```
