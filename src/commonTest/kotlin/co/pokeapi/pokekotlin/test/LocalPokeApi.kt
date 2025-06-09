package co.pokeapi.pokekotlin.test

import co.pokeapi.PokeApi
import co.pokeapi.internal.PokeApiJson
import co.pokeapi.model.ApiResourceList
import co.pokeapi.model.NamedApiResourceList
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.statement.request
import io.ktor.utils.io.readBuffer
import kotlin.math.min
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.io.decodeFromSource

@OptIn(ExperimentalSerializationApi::class)
private val OffsetLimitPlugin =
  createClientPlugin("OffsetLimit") {
    transformResponseBody { response, content, requestedType ->
      val offset = response.request.url.parameters["offset"]?.toIntOrNull() ?: 0
      val limit = response.request.url.parameters["limit"]?.toIntOrNull() ?: 20
      val endIndex = offset + limit

      when (requestedType.type) {
        ApiResourceList::class -> {
          val fullList = PokeApiJson.decodeFromSource<ApiResourceList>(content.readBuffer())
          fullList.copy(
            results = fullList.results.subList(offset, min(endIndex, fullList.count)),
            previous = if (offset == 0) null else "TODO",
            next = if (endIndex < fullList.count) "TODO" else null,
          )
        }
        NamedApiResourceList::class -> {
          val fullList = PokeApiJson.decodeFromSource<NamedApiResourceList>(content.readBuffer())
          fullList.copy(
            results = fullList.results.subList(offset, min(endIndex, fullList.count)),
            previous = if (offset == 0) null else "TODO",
            next = if (endIndex < fullList.count) "TODO" else null,
          )
        }
        else -> null
      }
    }
  }

object LocalPokeApi :
  PokeApi by (PokeApi(baseUrl = "http://localhost:8080/api/v2/") { install(OffsetLimitPlugin) })
