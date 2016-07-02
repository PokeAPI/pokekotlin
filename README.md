[![Build Status](https://travis-ci.org/PokeAPI/pokekotlin.svg?branch=master)](https://travis-ci.org/PokeAPI/pokekotlin)
[![Download](https://api.bintray.com/packages/sargunster/maven/pokekotlin/images/download.svg) ](https://bintray.com/sargunster/maven/pokekotlin/_latestVersion)

# PokeKotlin

This is a Java (and Kotlin, Scala, etc) client for [PokeApi](https://github.com/PokeAPI/pokeapi). It's written in Kotlin.

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

PokeKotlin is available from the JCenter repository.

### Gradle

```groovy
dependencies {
    compile 'me.sargunvohra.lib:pokekotlin:2.2.1'
}
```

### Kobalt

```kotlin
val p = project {
    dependencies {
        compile("me.sargunvohra.lib:pokekotlin:2.2.1")
    }
}
```
