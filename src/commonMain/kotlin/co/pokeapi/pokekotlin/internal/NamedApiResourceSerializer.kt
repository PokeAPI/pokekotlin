package co.pokeapi.pokekotlin.internal

import co.pokeapi.pokekotlin.model.EndpointModel
import co.pokeapi.pokekotlin.model.ResourceHandle
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

internal class NamedApiResourceSerializer<T : EndpointModel> :
  KSerializer<ResourceHandle.Named<T>> by DelegatingSerializer(
    serialName = "co.pokeapi.pokekotlin.model.ResourceHandle.Named",
    delegate = Delegate.serializer(),
    fromDelegate = { ResourceHandle.Named(slug = it.name, url = it.url) },
    toDelegate = { Delegate(name = it.slug, url = it.url) },
  ) {
  @Serializable internal data class Delegate(val name: String, val url: String)
}
