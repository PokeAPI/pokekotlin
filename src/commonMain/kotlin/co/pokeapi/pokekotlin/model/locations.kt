package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

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

@Serializable
@JsOnlyExport
public data class EncounterMethodRate(
  val encounterMethod: NamedApiResource,
  val versionDetails: List<EncounterMethodRateVersionDetail>,
)

@Serializable
@JsOnlyExport
public data class EncounterMethodRateVersionDetail(val rate: Int, val version: NamedApiResource)

@Serializable
@JsOnlyExport
public data class PokemonEncounter(
  val pokemon: NamedApiResource,
  val versionDetails: List<VersionEncounterDetail>,
)

@Serializable
@JsOnlyExport
public data class PalParkArea(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonEncounters: List<PalParkEncounterSpecies>,
)

@Serializable
@JsOnlyExport
public data class PalParkEncounterSpecies(
  val baseScore: Int,
  val rate: Int,
  val pokemonSpecies: NamedApiResource,
)

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
