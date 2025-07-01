package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsNonWasmExport
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
@JsNonWasmExport
public data class Location(
  override val id: Int,
  override val name: String,
  val region: Handle.Named<Region>?,
  val names: List<Name>,
  val gameIndices: List<GenerationGameIndex>,
  val areas: List<Handle.Named<LocationArea>>,
) : NamedModel

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
@JsNonWasmExport
public data class LocationArea(
  override val id: Int,
  override val name: String,
  val gameIndex: Int,
  val encounterMethodRates: List<EncounterMethodRate>,
  val location: Handle.Named<Location>,
  val names: List<Name>,
  val pokemonEncounters: List<PokemonEncounter>,
) : NamedModel

/**
 * The encounter rate for a specific encounter method in a location area. See:
 * https://pokeapi.co/docs/v2#encountermethodrate
 *
 * @param encounterMethod The method in which Pokémon may be encountered in an area.
 * @param versionDetails The chance of the encounter to occur on a version of the game.
 */
@Serializable
@JsNonWasmExport
public data class EncounterMethodRate(
  val encounterMethod: Handle.Named<EncounterMethod>,
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
@JsNonWasmExport
public data class EncounterMethodRateVersionDetail(
  val rate: Int,
  val version: Handle.Named<Version>,
)

/**
 * A Pokémon encounter in a specific location area. See: https://pokeapi.co/docs/v2#pokemonencounter
 *
 * @param pokemon The Pokémon being encountered.
 * @param versionDetails A list of versions and encounters with Pokémon that might happen in the
 *   referenced location area.
 */
@Serializable
@JsNonWasmExport
public data class PokemonEncounter(
  val pokemon: Handle.Named<PokemonVariety>,
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
@JsNonWasmExport
public data class PalParkArea(
  override val id: Int,
  override val name: String,
  val names: List<Name>,
  val pokemonEncounters: List<PalParkEncounterSpecies>,
) : NamedModel

/**
 * A Pokémon species that can be encountered in a specific Pal Park area. See:
 * https://pokeapi.co/docs/v2#palparkencounterspecies
 *
 * @param baseScore The base score given to the player when this Pokémon is caught.
 * @param rate The base rate for encountering this Pokémon in this pal park area.
 * @param pokemonSpecies The Pokémon species being encountered.
 */
@Serializable
@JsNonWasmExport
public data class PalParkEncounterSpecies(
  val baseScore: Int,
  val rate: Int,
  val pokemonSpecies: Handle.Named<PokemonSpecies>,
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
@JsNonWasmExport
public data class Region(
  override val id: Int,
  override val name: String,
  val locations: List<Handle.Named<Location>>,
  val mainGeneration: Handle.Named<Generation>?,
  val names: List<Name>,
  val pokedexes: List<Handle.Named<Pokedex>>,
  val versionGroups: List<Handle.Named<VersionGroup>>,
) : NamedModel
