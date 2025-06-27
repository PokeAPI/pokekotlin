package co.pokeapi.pokekotlin.internal

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.CacheStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

internal fun createPokeApiKtorfitBuilder(
  baseUrl: String,
  cacheStorage: CacheStorage?,
  engine: HttpClientEngine,
  configure: HttpClientConfig<*>.() -> Unit,
) =
  Ktorfit.Builder()
    .baseUrl(baseUrl)
    .httpClient(
      HttpClient(engine) {
        configure()
        install(HttpCache) { cacheStorage?.let { privateStorage(it) } }
        install(ContentNegotiation) { json(PokeApiJson, ContentType.Any) }
        expectSuccess = true
      }
    )
