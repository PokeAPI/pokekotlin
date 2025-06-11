package co.pokeapi.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
public data class Machine(
  val id: Int,
  val item: NamedApiResource,
  val move: NamedApiResource,
  val versionGroup: NamedApiResource,
)
