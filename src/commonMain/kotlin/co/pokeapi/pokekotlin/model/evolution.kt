package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.Serializable

/**
 * Evolution chains are essentially family trees. They start with the lowest stage within a family
 * and detail evolution conditions for each as well as Pokémon they can evolve into up through the
 * hierarchy. See: https://pokeapi.co/docs/v2#evolution-chains
 *
 * @param id The identifier for this resource.
 * @param babyTriggerItem The item that a Pokémon would be holding when mating that would trigger
 *   the egg hatching a baby Pokémon rather than a basic Pokémon.
 * @param chain The base chain link object. Each link contains evolution details for a Pokémon in
 *   the chain.
 */
@Serializable
@JsNonWasmExport
public data class EvolutionChain(
  override val id: Int,
  val babyTriggerItem: Handle.Named<Item>?,
  val chain: ChainLink,
) : Model

/**
 * A single link within an evolution chain. Each link represents a Pokémon species and the
 * conditions required for it to evolve. See: https://pokeapi.co/docs/v2#chainlink
 *
 * @param isBaby Whether or not this link is for a baby Pokémon. This would only ever be true on the
 *   base link.
 * @param species The Pokémon species at this point in the evolution chain.
 * @param evolutionDetails A list of evolution details for this Pokémon in order of occurrence.
 * @param evolvesTo A list of chain objects describing further evolutions from this species.
 */
@Serializable
@JsNonWasmExport
public data class ChainLink(
  val isBaby: Boolean,
  val species: Handle.Named<PokemonSpecies>,
  val evolutionDetails: List<EvolutionDetail>,
  val evolvesTo: List<ChainLink>,
)

/**
 * Evolution details specify the conditions under which a Pokémon species will evolve. See:
 * https://pokeapi.co/docs/v2#evolutiondetail
 *
 * @param trigger The type of event that triggers evolution into this Pokémon species.
 * @param item The item required to cause evolution into this Pokémon species.
 * @param gender The id of the gender of the evolving Pokémon species required for evolution.
 * @param heldItem The item the evolving Pokémon species must be holding during the evolution
 *   trigger event.
 * @param knownMove The move that must be known by the evolving Pokémon species.
 * @param knownMoveType The evolving Pokémon species must know a move with this type.
 * @param location The location the evolution must be triggered at.
 * @param minLevel The minimum required level of the evolving Pokémon species.
 * @param minHappiness The minimum required level of happiness of the evolving Pokémon species.
 * @param minBeauty The minimum required level of beauty of the evolving Pokémon species.
 * @param minAffection The minimum required level of affection of the evolving Pokémon species.
 * @param partySpecies The Pokémon species that must be in the players party to trigger evolution.
 * @param partyType The player must have a Pokémon of this type in their party to trigger evolution.
 * @param relativePhysicalStats The required relation between the Pokémon's Attack and Defense
 *   stats.
 * @param timeOfDay The required time of day for evolution to trigger.
 * @param tradeSpecies Pokémon species for which this one must be traded.
 * @param needsOverworldRain Whether or not it must be raining in the overworld to trigger
 *   evolution.
 * @param turnUpsideDown Whether or not the 3DS needs to be turned upside-down as this Pokémon
 *   levels up.
 */
@Serializable
@JsNonWasmExport
public data class EvolutionDetail(
  val trigger: Handle.Named<EvolutionTrigger>,
  val item: Handle.Named<Item>? = null,
  val gender: Int? = null,
  val heldItem: Handle.Named<Item>? = null,
  val knownMove: Handle.Named<Move>? = null,
  val knownMoveType: Handle.Named<Type>? = null,
  val location: Handle.Named<Location>? = null,
  val minLevel: Int? = null,
  val minHappiness: Int? = null,
  val minBeauty: Int? = null,
  val minAffection: Int? = null,
  val partySpecies: Handle.Named<PokemonSpecies>? = null,
  val partyType: Handle.Named<Type>? = null,
  val relativePhysicalStats: Int? = null,
  val timeOfDay: String = "",
  val tradeSpecies: Handle.Named<PokemonSpecies>? = null,
  val needsOverworldRain: Boolean = false,
  val turnUpsideDown: Boolean = false,
)

/**
 * Evolution triggers are the events and conditions that cause a Pokémon to evolve. See:
 * https://pokeapi.co/docs/v2#evolution-triggers
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 * @param pokemonSpecies A list of pokemon species that result from this evolution trigger.
 */
@Serializable
@JsNonWasmExport
public data class EvolutionTrigger(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
) : NamedModel
