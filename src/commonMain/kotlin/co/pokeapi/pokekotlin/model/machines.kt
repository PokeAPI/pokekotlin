package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

@Serializable
@JsOnlyExport
public data class Machine(
  val id: Int,
  val item: NamedApiResource,
  val move: NamedApiResource,
  val versionGroup: NamedApiResource,
)
