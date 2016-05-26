[![Build Status](https://travis-ci.org/pokesource/pokekotlin.svg?branch=master)](https://travis-ci.org/pokesource/pokekotlin)
[![Download](https://api.bintray.com/packages/sargunster/maven/PokeKotlin/images/download.svg) ](https://bintray.com/sargunster/maven/PokeKotlin/_latestVersion)

# PokeKotlin

Kotlin wrapper for [PokeApi](https://github.com/phalt/pokeapi). Currently under development.

## Status

Model classes: 100%

API interface: 100%

Testing: about 95%

## Example

### Kotlin

```kotlin
fun main(args: Array<String>) {
    val bulbasaur = PokeApi.getPokemonSpecies(1)
    println(bulbasaur)
}
```

### Java

```java
public class Example {
    public static void main(String[] args) {
        PokemonSpecies bulbasaur = PokeApi.INSTANCE.getPokemonSpecies(1);
        System.out.println(bulbasaur);
    }
}
```

## Download

### Gradle

```groovy
dependencies {
    compile 'me.sargunvohra.lib:PokeKotlin:<version>'
}
```

### Kobalt

```kotlin
val p = project {
    dependencies {
        compile("me.sargunvohra.lib:PokeKotlin:<version>")
    }
}
```
