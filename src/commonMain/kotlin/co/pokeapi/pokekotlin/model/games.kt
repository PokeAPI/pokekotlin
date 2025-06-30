package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
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
@JsOnlyExport
public data class Generation(
  val id: Int,
  val name: String,
  val abilities: List<NamedApiResource>,
  val names: List<Name>,
  val mainRegion: NamedApiResource,
  val moves: List<NamedApiResource>,
  val pokemonSpecies: List<NamedApiResource>,
  val types: List<NamedApiResource>,
  val versionGroups: List<NamedApiResource>,
)

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
@JsOnlyExport
public data class Pokedex(
  val id: Int,
  val name: String,
  val isMainSeries: Boolean,
  val descriptions: List<Description>,
  val names: List<Name>,
  val pokemonEntries: List<PokemonEntry>,
  val region: NamedApiResource?,
  val versionGroups: List<NamedApiResource>,
)

/**
 * A Pokémon species entry within a Pokédex. See: https://pokeapi.co/docs/v2#pokemonentry
 *
 * @param entryNumber The index of this Pokémon species entry within the Pokédex.
 * @param pokemonSpecies The Pokémon species being encountered.
 */
@Serializable
@JsOnlyExport
public data class PokemonEntry(val entryNumber: Int, val pokemonSpecies: NamedApiResource)

/**
 * Versions of the games, e.g Red, Blue or Yellow. See: https://pokeapi.co/docs/v2#versions
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 * @param versionGroup The version group this version belongs to.
 */
@Serializable
@JsOnlyExport
public data class Version(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val versionGroup: NamedApiResource,
)

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
@JsOnlyExport
public data class VersionGroup(
  val id: Int,
  val name: String,
  val order: Int,
  val generation: NamedApiResource,
  val moveLearnMethods: List<NamedApiResource>,
  val pokedexes: List<NamedApiResource>,
  val regions: List<NamedApiResource>,
  val versions: List<NamedApiResource>,
)
