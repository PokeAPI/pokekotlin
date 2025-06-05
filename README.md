[![License](https://img.shields.io/github/license/PokeAPI/pokekotlin)](https://github.com/PokeAPI/pokekotlin/blob/master/LICENSE)

# PokeKotlin

Maintainer: [@sargunv](https://github.com/sargunv)

This is a [Kotlin](https://kotlinlang.org/) client for
[PokeApi](https://github.com/PokeAPI/pokeapi).

| Platform | Status             |
| -------- | ------------------ |
| JVM      | :white_check_mark: |
| Native   | :x:                |
| JS       | :x:                |
| WASM     | :x:                |

## Example

Full documentation coming ~~soon~~. Meanwhile, look at these usage examples:

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

TODO
