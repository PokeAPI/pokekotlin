package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

/**
 * Locations that can be visited within the games. They make up sizable portions of regions, like
 * cities or routes. See: https://pokeapi.co/docs/v2#locations
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param region The region this location can be found in.
 * @param names The name of this resource listed in different languages.
 * @param gameIndices A list of the indices of this location in different games.
 * @param areas A list of areas that can be found in this location.
 */
@Serializable
@JsOnlyExport
public data class Location(
  val id: Int,
  val name: String,
  val region: NamedApiResource?,
  val names: List<Name>,
  val gameIndices: List<GenerationGameIndex>,
  val areas: List<NamedApiResource>,
)

/**
 * Location areas are sections of locations, such as floors in a building or cave. Each area has its
 * own set of possible Pokémon encounters. See: https://pokeapi.co/docs/v2#location-areas
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param gameIndex The internal id of an API resource within game data.
 * @param encounterMethodRates A list of methods in which Pokémon may be encountered in this area
 *   and how likely the method is to occur depending on the version of the game.
 * @param location The location this area can be found in.
 * @param names The name of this resource listed in different languages.
 * @param pokemonEncounters A list of Pokémon that can be encountered in this area along with
 *   version specific details about the encounter.
 */
@Serializable
@JsOnlyExport
public data class LocationArea(
  val id: Int,
  val name: String,
  val gameIndex: Int,
  val encounterMethodRates: List<EncounterMethodRate>,
  val location: NamedApiResource,
  val names: List<Name>,
  val pokemonEncounters: List<PokemonEncounter>,
)

/**
 * The encounter rate for a specific encounter method in a location area. See:
 * https://pokeapi.co/docs/v2#encountermethodrate
 *
 * @param encounterMethod The method in which Pokémon may be encountered in an area.
 * @param versionDetails The chance of the encounter to occur on a version of the game.
 */
@Serializable
@JsOnlyExport
public data class EncounterMethodRate(
  val encounterMethod: NamedApiResource,
  val versionDetails: List<EncounterMethodRateVersionDetail>,
)

/**
 * The encounter rate for a specific encounter method in a location area and version. See:
 * https://pokeapi.co/docs/v2#encountermethodrateversiondetail
 *
 * @param rate The chance of an encounter to occur.
 * @param version The version of the game in which the encounter can occur with the given chance.
 */
@Serializable
@JsOnlyExport
public data class EncounterMethodRateVersionDetail(val rate: Int, val version: NamedApiResource)

/**
 * A Pokémon encounter in a specific location area. See: https://pokeapi.co/docs/v2#pokemonencounter
 *
 * @param pokemon The Pokémon being encountered.
 * @param versionDetails A list of versions and encounters with Pokémon that might happen in the
 *   referenced location area.
 */
@Serializable
@JsOnlyExport
public data class PokemonEncounter(
  val pokemon: NamedApiResource,
  val versionDetails: List<VersionEncounterDetail>,
)

/**
 * Areas used for grouping Pokémon encounters in Pal Park. They're like habitats that are specific
 * to Pal Park. See: https://pokeapi.co/docs/v2#pal-park-areas
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param names The name of this resource listed in different languages.
 * @param pokemonEncounters A list of Pokémon encountered in this pal park area along with details.
 */
@Serializable
@JsOnlyExport
public data class PalParkArea(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonEncounters: List<PalParkEncounterSpecies>,
)

/**
 * A Pokémon species that can be encountered in a specific Pal Park area. See:
 * https://pokeapi.co/docs/v2#palparkencounterspecies
 *
 * @param baseScore The base score given to the player when this Pokémon is caught.
 * @param rate The base rate for encountering this Pokémon in this pal park area.
 * @param pokemonSpecies The Pokémon species being encountered.
 */
@Serializable
@JsOnlyExport
public data class PalParkEncounterSpecies(
  val baseScore: Int,
  val rate: Int,
  val pokemonSpecies: NamedApiResource,
)

/**
 * A region is an organized area of the Pokémon world. Most often, the main difference between
 * regions is the species of Pokémon that can be encountered within them. See:
 * https://pokeapi.co/docs/v2#regions
 *
 * @param id The identifier for this resource.
 * @param name The name for this resource.
 * @param locations A list of locations that can be found in this region.
 * @param mainGeneration The generation this region was introduced in.
 * @param names The name of this resource listed in different languages.
 * @param pokedexes A list of pokédexes that catalogue Pokémon in this region.
 * @param versionGroups A list of version groups where this region can be visited.
 */
@Serializable
@JsOnlyExport
public data class Region(
  val id: Int,
  val name: String,
  val locations: List<NamedApiResource>,
  val mainGeneration: NamedApiResource?,
  val names: List<Name>,
  val pokedexes: List<NamedApiResource>,
  val versionGroups: List<NamedApiResource>,
)
