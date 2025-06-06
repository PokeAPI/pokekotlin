package dev.sargunv.pokekotlin.client

import de.jensklingenberg.ktorfit.Ktorfit.Builder
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class PokeApiClient(
  baseUrl: String = "https://pokeapi.co/api/v2/",
  configure: HttpClientConfig<*>.() -> Unit = {},
) :
  PokeApi by (Builder()
    .apply {
      baseUrl(baseUrl)
      httpClient(
        HttpClient {
          install(ContentNegotiation) { json(PokeApiJson) }
          configure()
        }
      )
    }
    .build()
    .createPokeApi())
