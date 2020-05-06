package me.sargunvohra.lib.pokekotlin.model

data class Generation(
    val id: Int,
    val name: String,
    val abilities: List<NamedApiResource>,
    val names: List<Name>,
    val mainRegion: NamedApiResource,
    val moves: List<NamedApiResource>,
    val pokemonSpecies: List<NamedApiResource>,
    val types: List<NamedApiResource>,
    val versionGroups: List<NamedApiResource>
)

data class Pokedex(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    val pokemonEntries: List<PokemonEntry>,
    val region: NamedApiResource?,
    val versionGroups: List<NamedApiResource>
)

data class PokemonEntry(
    val entryNumber: Int,
    val pokemonSpecies: NamedApiResource
)

data class Version(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val versionGroup: NamedApiResource
)

data class VersionGroup(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedApiResource,
    val moveLearnMethods: List<NamedApiResource>,
    val pokedexes: List<NamedApiResource>,
    val regions: List<NamedApiResource>,
    val versions: List<NamedApiResource>
)
