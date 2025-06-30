package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

/**
 * Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall grass.
 * See: https://pokeapi.co/docs/v2#encounter-methods
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param order A good value for sorting.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsOnlyExport
public data class EncounterMethod(
  val id: Int,
  val name: String,
  val order: Int,
  val names: List<Name>,
)

/**
 * Conditions which affect what pokemon might appear in the wild, e.g., day or night. See:
 * https://pokeapi.co/docs/v2#encounter-conditions
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 * @param values A list of possible values for this encounter condition.
 */
@Serializable
@JsOnlyExport
public data class EncounterCondition(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val values: List<NamedApiResource>,
)

/**
 * Encounter condition values are the various states that an encounter condition can have, i.e.,
 * time of day can be either day or night. See:
 * https://pokeapi.co/docs/v2#encounter-condition-values
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param condition The condition this encounter condition value pertains to.
 * @param names The name of this resource listed in different languages.
 */
@Serializable
@JsOnlyExport
public data class EncounterConditionValue(
  val id: Int,
  val name: String,
  val condition: NamedApiResource,
  val names: List<Name>,
)
