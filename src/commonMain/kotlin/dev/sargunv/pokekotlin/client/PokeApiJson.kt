package dev.sargunv.pokekotlin.client

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

@OptIn(ExperimentalSerializationApi::class)
val PokeApiJson = Json {
  prettyPrint = true
  ignoreUnknownKeys = true
  namingStrategy = JsonNamingStrategy.SnakeCase
}
