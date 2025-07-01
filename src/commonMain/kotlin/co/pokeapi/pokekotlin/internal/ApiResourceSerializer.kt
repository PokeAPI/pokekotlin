package co.pokeapi.pokekotlin.internal

import co.pokeapi.pokekotlin.model.EndpointModel
import co.pokeapi.pokekotlin.model.ResourceHandle
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

internal class ApiResourceSerializer<T : EndpointModel> :
  KSerializer<ResourceHandle.Unnamed<T>> by DelegatingSerializer(
    serialName = "co.pokeapi.pokekotlin.model.ResourceHandle.Unnamed",
    delegate = Delegate.serializer(),
    fromDelegate = { ResourceHandle.Unnamed(url = it.url) },
    toDelegate = { Delegate(url = it.url) },
  ) {
  @Serializable internal data class Delegate(val url: String)
}
