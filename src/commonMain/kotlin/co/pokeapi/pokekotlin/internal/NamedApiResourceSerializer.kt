package co.pokeapi.pokekotlin.internal

import co.pokeapi.pokekotlin.model.NamedApiResource
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

internal class NamedApiResourceSerializer :
  KSerializer<NamedApiResource> by DelegatingSerializer(
    serialName = "co.pokeapi.pokekotlin.model.NamedApiResource",
    delegate = Delegate.serializer(),
    fromDelegate = { NamedApiResource(name = it.name, url = it.url) },
    toDelegate = { Delegate(name = it.name, url = it.url) },
  ) {
  @Serializable internal data class Delegate(val name: String, val url: String)
}
