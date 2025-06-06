package dev.sargunv.pokekotlin.client

import de.jensklingenberg.ktorfit.Ktorfit.Builder
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class PokeApiClient(
  baseUrl: String = "https://pokeapi.co/api/v2/",
  engine: HttpClientEngine? = null,
  configure: HttpClientConfig<*>.() -> Unit = {},
) :
  PokeApi by (run {
    fun HttpClientConfig<*>.fullyConfigure() {
      install(ContentNegotiation) { json(PokeApiJson) }
      configure()
    }
    Builder()
      .apply {
        baseUrl(baseUrl)
        httpClient(
          if (engine != null) HttpClient(engine) { fullyConfigure() }
          else HttpClient { fullyConfigure() }
        )
      }
      .build()
      .createPokeApi()
  })
