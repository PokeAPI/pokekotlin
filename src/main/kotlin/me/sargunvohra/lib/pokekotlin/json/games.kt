package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Generation(
        val id: Int,
        val name: String,
        val abilities: List<NamedApiResource>,
        val names: List<Name>,
        @Json(name = "main_region")
        val mainRegion: NamedApiResource,
        val moves: List<NamedApiResource>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource>,
        val types: List<NamedApiResource>,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource>
)

data class Pokedex(
        val id: Int,
        val name: String,
        @Json(name = "is_main_series")
        val isMainSeries: Boolean,
        val descriptions: List<Description>,
        val names: List<Name>,
        @Json(name = "pokemon_entries")
        val pokemonEntries: List<PokemonEntry>,
        val region: NamedApiResource,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource>
)

data class PokemonEntry(
        @Json(name = "entry_number")
        val entryNumber: Int,
        @Json(name = "pokemon_species")
        val pokemonSpecies: NamedApiResource
)

data class Version(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource
)

data class VersionGroup(
        val id: Int,
        val name: String,
        val order: Int,
        val generation: NamedApiResource,
        @Json(name = "move_learn_methods")
        val moveLearnMethods: List<NamedApiResource>,
        val pokedexes: List<NamedApiResource>,
        val regions: List<NamedApiResource>,
        val versions: List<NamedApiResource>
)