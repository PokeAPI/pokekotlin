package co.pokeapi.pokekotlin.example

import co.pokeapi.pokekotlin.PokeApi

suspend fun simple() {
  // -8<- [start:simple]
  val bulbasaur = PokeApi.getPokemonVariety(1)
  println(bulbasaur)
  // -8<- [end:simple]
}

suspend fun custom() {
  // -8<- [start:custom]
  val client = PokeApi.Custom(baseUrl = "https://localhost:8080")
  val bulbasaur = client.getPokemonVariety(1)
  println(bulbasaur)
  // -8<- [end:custom]
}
