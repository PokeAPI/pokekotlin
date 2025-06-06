package dev.sargunv.pokekotlin.client

import de.jensklingenberg.ktorfit.Ktorfit.Builder
import dev.sargunv.pokekotlin.util.getDefaultEngine
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class PokeApiClient(
  baseUrl: String = "https://pokeapi.co/api/v2/",
  engine: HttpClientEngine = getDefaultEngine(),
  configure: HttpClientConfig<*>.() -> Unit = {},
) : PokeApi by getInstance(baseUrl, engine, configure) {
  private companion object {
    private fun HttpClientConfig<*>.configureWithJson(configure: HttpClientConfig<*>.() -> Unit) {
      install(ContentNegotiation) { json(PokeApiJson) }
      configure()
    }

    private fun getInstance(
      baseUrl: String,
      engine: HttpClientEngine,
      configure: HttpClientConfig<*>.() -> Unit,
    ) =
      Builder()
        .baseUrl(baseUrl)
        .httpClient(HttpClient(engine) { configureWithJson(configure) })
        .build()
        .createPokeApi()
  }
}
