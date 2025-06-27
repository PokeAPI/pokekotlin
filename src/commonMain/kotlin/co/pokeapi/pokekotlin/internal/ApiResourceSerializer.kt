package co.pokeapi.pokekotlin.internal

import co.pokeapi.pokekotlin.model.ApiResource
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

internal class ApiResourceSerializer :
  KSerializer<ApiResource> by DelegatingSerializer(
    serialName = "co.pokeapi.pokekotlin.model.ApiResource",
    delegate = Delegate.serializer(),
    fromDelegate = { ApiResource(url = it.url) },
    toDelegate = { Delegate(url = it.url) },
  ) {
  @Serializable internal data class Delegate(val url: String)
}
