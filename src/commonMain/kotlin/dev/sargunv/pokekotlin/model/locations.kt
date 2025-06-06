package dev.sargunv.pokekotlin.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
  val id: Int,
  val name: String,
  val region: NamedApiResource?,
  val names: List<Name>,
  val gameIndices: List<GenerationGameIndex>,
  val areas: List<NamedApiResource>,
)

@Serializable
data class LocationArea(
  val id: Int,
  val name: String,
  val gameIndex: Int,
  val encounterMethodRates: List<EncounterMethodRate>,
  val location: NamedApiResource,
  val names: List<Name>,
  val pokemonEncounters: List<PokemonEncounter>,
)

@Serializable
data class EncounterMethodRate(
  val encounterMethod: NamedApiResource,
  val versionDetails: List<EncounterMethodRateVersionDetail>,
)

@Serializable
data class EncounterMethodRateVersionDetail(val rate: Int, val version: NamedApiResource)

@Serializable
data class PokemonEncounter(
  val pokemon: NamedApiResource,
  val versionDetails: List<VersionEncounterDetail>,
)

@Serializable
data class PalParkArea(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val pokemonEncounters: List<PalParkEncounterSpecies>,
)

@Serializable
data class PalParkEncounterSpecies(
  val baseScore: Int,
  val rate: Int,
  val pokemonSpecies: NamedApiResource,
)

@Serializable
data class Region(
  val id: Int,
  val name: String,
  val locations: List<NamedApiResource>,
  val mainGeneration: NamedApiResource,
  val names: List<Name>,
  val pokedexes: List<NamedApiResource>,
  val versionGroups: List<NamedApiResource>,
)
