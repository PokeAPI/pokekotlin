package co.pokeapi.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
public data class EncounterMethod(
  val id: Int,
  val name: String,
  val order: Int,
  val names: List<Name>,
)

@Serializable
public data class EncounterCondition(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val values: List<NamedApiResource>,
)

@Serializable
public data class EncounterConditionValue(
  val id: Int,
  val name: String,
  val condition: NamedApiResource,
  val names: List<Name>,
)
