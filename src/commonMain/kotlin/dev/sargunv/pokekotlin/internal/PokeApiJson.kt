package dev.sargunv.pokekotlin.internal

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

@OptIn(ExperimentalSerializationApi::class)
internal val PokeApiJson = Json {
  prettyPrint = true
  ignoreUnknownKeys = true
  namingStrategy = JsonNamingStrategy.SnakeCase
}
