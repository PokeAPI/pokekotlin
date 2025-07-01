package co.pokeapi.pokekotlin.internal

import co.pokeapi.pokekotlin.model.Handle
import co.pokeapi.pokekotlin.model.Model
import co.pokeapi.pokekotlin.model.NamedModel
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

internal object HandleSerializers {
  class Unnamed<T : Model> :
    KSerializer<Handle.Unnamed<T>> by DelegatingSerializer(
      serialName = "co.pokeapi.pokekotlin.model.ResourceHandle.Unnamed",
      delegate = Delegate.serializer(),
      fromDelegate = { Handle.Unnamed(url = it.url) },
      toDelegate = { Delegate(url = it.url) },
    ) {
    @Serializable internal data class Delegate(val url: String)
  }

  class Named<T : NamedModel> :
    KSerializer<Handle.Named<T>> by DelegatingSerializer(
      serialName = "co.pokeapi.pokekotlin.model.ResourceHandle.Named",
      delegate = Delegate.serializer(),
      fromDelegate = { Handle.Named(name = it.name, url = it.url) },
      toDelegate = { Delegate(name = it.name, url = it.url) },
    ) {
    @Serializable internal data class Delegate(val name: String, val url: String)
  }
}
