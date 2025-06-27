package co.pokeapi.pokekotlin.model

import co.pokeapi.pokekotlin.internal.JsOnlyExport
import kotlinx.serialization.Serializable

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

@Serializable
@JsOnlyExport
public data class PokemonEntry(val entryNumber: Int, val pokemonSpecies: NamedApiResource)

@Serializable
@JsOnlyExport
public data class Version(
  val id: Int,
  val name: String,
  val names: List<Name>,
  val versionGroup: NamedApiResource,
)

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
