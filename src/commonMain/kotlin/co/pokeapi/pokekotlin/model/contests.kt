package co.pokeapi.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
public data class ContestType(
  val id: Int,
  val name: String,
  val berryFlavor: NamedApiResource,
  val names: List<ContestName>,
)

@Serializable
public data class ContestName(val name: String, val color: String, val language: NamedApiResource)

@Serializable
public data class ContestEffect(
  val id: Int,
  val appeal: Int,
  val jam: Int,
  val effectEntries: List<Effect>,
  val flavorTextEntries: List<FlavorText>,
)

@Serializable
public data class SuperContestEffect(
  val id: Int,
  val appeal: Int,
  val flavorTextEntries: List<FlavorText>,
  val moves: List<NamedApiResource>,
)
