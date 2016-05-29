package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Location(
        val id: Int,
        val name: String,
        val region: NamedApiResource?,
        val names: List<Name>,
        @Json(name = "game_indices")
        val gameIndices: List<GenerationGameIndex>,
        val areas: List<NamedApiResource>
)

data class LocationArea(
        val id: Int,
        val name: String,
        @Json(name = "game_index")
        val gameIndex: Int,
        @Json(name = "encounter_method_rates")
        val encounterMethodRates: List<EncounterMethodRate>,
        val location: NamedApiResource,
        val names: List<Name>,
        @Json(name = "pokemon_encounters")
        val pokemonEncounters: List<PokemonEncounter>
)

data class EncounterMethodRate(
        @Json(name = "encounter_method")
        val encounterMethod: NamedApiResource,
        @Json(name = "version_details")
        val versionDetails: List<EncounterMethodRateVersionDetail>
)

data class EncounterMethodRateVersionDetail(
        val rate: Int,
        val version: NamedApiResource
)

data class PokemonEncounter(
        val pokemon: NamedApiResource,
        @Json(name = "version_details")
        val versionDetails: List<VersionEncounterDetail>
)

data class PalParkArea(
        val id: Int,
        val name: String,
        val names: List<Name>,
        @Json(name = "pokemon_encounters")
        val pokemonEncounters: List<PalParkEncounterSpecies>
)

data class PalParkEncounterSpecies(
        @Json(name = "base_score")
        val baseScore: Int,
        val rate: Int,
        @Json(name = "pokemon_species")
        val pokemonSpecies: NamedApiResource
)

data class Region(
        val id: Int,
        val name: String,
        val locations: List<NamedApiResource>,
        @Json(name = "main_generation")
        val mainGeneration: NamedApiResource,
        val names: List<Name>,
        val pokedexes: List<NamedApiResource>,
        @Json(name = "version_groups")
        val versionGroups: List<NamedApiResource>
)