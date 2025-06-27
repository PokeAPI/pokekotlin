package co.pokeapi.pokekotlin.example

import co.pokeapi.pokekotlin.PokeApi
import co.pokeapi.pokekotlin.createPokeApi

suspend fun simple() {
  // -8<- [start:simple]
  val bulbasaur = PokeApi.getPokemon(1)
  println(bulbasaur)
  // -8<- [end:simple]
}

suspend fun custom() {
  // -8<- [start:custom]
  val client = createPokeApi(baseUrl = "https://localhost:8080")
  val bulbasaur = client.getPokemon(1)
  println(bulbasaur)
  // -8<- [end:custom]
}
