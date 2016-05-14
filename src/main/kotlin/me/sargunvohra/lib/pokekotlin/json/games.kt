package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Generation(
        val id: Int,
        val name: String,
        val abilities: List<NamedApiResource<Ability>>,
        val names: List<Name>,
        @Json(name = "main_region")
        val mainRegion: NamedApiResource<Region>,
        val moves: List<NamedApiResource<Move>>,
        @Json(name = "pokemon_species")
        val pokemonSpecies: List<NamedApiResource<PokemonSpecies>>,
        val types: List<NamedApiResource<Type>>,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource<VersionGroup>>
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
        val region: NamedApiResource<Region>,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource<VersionGroup>>
)

data class PokemonEntry(
        @Json(name = "entry_number")
        val entryNumber: Int,
        @Json(name = "pokemon_species")
        val pokemonSpecies: NamedApiResource<PokemonSpecies>
)

data class Version(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "version_group")
        val versionGroup: NamedApiResource<VersionGroup>
)

data class VersionGroup(
        val id: Int,
        val name: String,
        val order: Int,
        val generation: NamedApiResource<Generation>,
        @Json(name = "move_learn_methods")
        val moveLearnMethods: List<NamedApiResource<MoveLearnMethod>>,
        val pokedexes: List<NamedApiResource<Pokedex>>,
        val regions: List<NamedApiResource<Region>>,
        val versions: List<NamedApiResource<Version>>
)