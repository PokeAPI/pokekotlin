package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
import kotlinx.serialization.Serializable

/**
 * A generation is a grouping of the Pokémon games that separates them based on the Pokémon they
 * include. In each generation, a new set of Pokémon, moves, abilities and types that did not exist
 * in the previous generation are released. See: https://pokeapi.co/docs/v2#generations
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param abilities A list of abilities that were introduced in this generation.
 * @param names The name of this resource listed in different languages.
 * @param mainRegion The main region travelled in this generation.
 * @param moves A list of moves that were introduced in this generation.
 * @param pokemonSpecies A list of Pokémon species that were introduced in this generation.
 * @param types A list of types that were introduced in this generation.
 * @param versionGroups A list of version groups that were introduced in this generation.
 */
@Serializable
@JsNonWasmExport
public data class Generation(
  override val id: Int,
  override val name: String,
  val abilities: List<Handle.Named<Ability>>,
  val names: List<Name>,
  val mainRegion: Handle.Named<Region>,
  val moves: List<Handle.Named<Move>>,
  val pokemonSpecies: List<Handle.Named<PokemonSpecies>>,
  val types: List<Handle.Named<Type>>,
  val versionGroups: List<Handle.Named<VersionGroup>>,
) : NamedModel

/**
 * A Pokédex is a handheld electronic encyclopedia device; one which is capable of recording and
 * retaining information of the various Pokémon in a given region with the exception of the national
 * dex and some smaller dexes related to portions of a region. See:
 * https://pokeapi.co/docs/v2#pokedexes
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param isMainSeries Whether or not this Pokédex originated in the main series of the video games.
 * @param descriptions The description of this resource listed in different languages.
 * @param names The name of this resource listed in different languages.
 * @param pokemonEntries A list of Pokémon catalogued in this Pokédex and their indexes.
 * @param region The region this Pokédex catalogues Pokémon for.
 * @param versionGroups A list of version groups this Pokédex is relevant to.
 */
@Serializable
@JsNonWasmExport
public data class Pokedex(
  override val id: Int,
  override val name: String,
  val isMainSeries: Boolean,
  val descriptions: List<Description>,
  val names: List<Name>,
  val pokemonEntries: List<PokemonEntry>,
  val region: Handle.Named<Region>?,
  val versionGroups: List<Handle.Named<VersionGroup>>,
) : NamedModel

/**
 * A Pokémon species entry within a Pokédex. See: https://pokeapi.co/docs/v2#pokemonentry
 *
 * @param entryNumber The index of this Pokémon species entry within the Pokédex.
 * @param pokemonSpecies The Pokémon species being encountered.
 */
@Serializable
@JsNonWasmExport
public data class PokemonEntry(
  val entryNumber: Int,
  val pokemonSpecies: Handle.Named<PokemonSpecies>,
)

/**
 * Versions of the games, e.g Red, Blue or Yellow. See: https://pokeapi.co/docs/v2#versions
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 * @param versionGroup The version group this version belongs to.
 */
@Serializable
@JsNonWasmExport
public data class Version(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val versionGroup: Handle.Named<VersionGroup>,
) : NamedModel

/**
 * Version groups categorize highly similar versions of the games. See:
 * https://pokeapi.co/docs/v2#version-groups
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param order Order for sorting. Almost by date of release, except similar versions are grouped
 *   together.
 * @param generation The generation this version was introduced in.
 * @param moveLearnMethods A list of methods in which Pokémon can learn moves in this version group.
 * @param pokedexes A list of Pokédexes introduces in this version group.
 * @param regions A list of regions that can be visited in this version group.
 * @param versions The versions this version group owns.
 */
@Serializable
@JsNonWasmExport
public data class VersionGroup(
  override val id: Int,
  override val name: String,
  val order: Int,
  val generation: Handle.Named<Generation>,
  val moveLearnMethods: List<Handle.Named<MoveLearnMethod>>,
  val pokedexes: List<Handle.Named<Pokedex>>,
  val regions: List<Handle.Named<Region>>,
  val versions: List<Handle.Named<Version>>,
) : NamedModel
