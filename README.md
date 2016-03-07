[![Build Status](https://travis-ci.org/sargunster/PokeKotlin.svg?branch=master)](https://travis-ci.org/sargunster/PokeKotlin)
[![Download](https://api.bintray.com/packages/sargunster/maven/PokeKotlin/images/download.svg) ](https://bintray.com/sargunster/maven/PokeKotlin/_latestVersion)

# PokeKotlin

Kotlin wrapper for [PokeApi](https://github.com/phalt/pokeapi). Currently under development.

## Status

Model classes: 100%

API interface: 100%

Testing: about 60%

## Example

```kotlin
fun main(args: Array<String>) {
  PokeApi.getPokemon(1).promise success {
    println(it)
  } fail {
    println(it.message)
  }
}
```

## Download

```kotlin
dependencies {
    compile("me.sargunvohra.lib:PokeKotlin:<version>")
}
```
