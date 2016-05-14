package me.sargunvohra.lib.pokekotlin.json

import com.squareup.moshi.Json

data class Location(
        val id: Int,
        val name: String,
        val region: NamedApiResource<Region>,
        val names: List<Name>,
        val game_indices: List<GenerationGameIndex>,
        val areas: ApiResource<LocationArea>
)

data class LocationArea(
        val id: Int,
        val name: String,
        val game_index: Int,
        val encounter_method_rates: List<EncounterMethodRate>,
        val location: NamedApiResource<Region>,
        val names: List<Name>,
        val pokemon_encounters: List<PokemonEncounter>
)

data class EncounterMethodRate(
        val encounter_method: NamedApiResource<EncounterMethod>,
        val version_details: List<VersionEncounterDetail>
)

data class PokemonEncounter(
        val pokemon: NamedApiResource<Pokemon>,
        @Json(name = "version_details")
        val versionDetails: List<VersionEncounterDetail>
)

data class PalParkArea(
        val id: Int,
        val name: String,
        val names: List<Name>,
        val pokemon_encounters: List<PalParkEncounterSpecies>
)

data class PalParkEncounterSpecies(
        val base_score: Int,
        val rate: Int,
        val pokemon_species: NamedApiResource<PokemonSpecies>
)

data class Region(
        val id: Int,
        val name: String,
        val locations: List<Location>,
        val main_generation: NamedApiResource<Generation>,
        val names: List<Name>,
        val pokedexes: List<NamedApiResource<Pokedex>>,
        val version_groups: List<NamedApiResource<VersionGroup>>
)