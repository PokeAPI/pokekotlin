package me.sargunvohra.lib.pokekotlin.json

data class JsonLocation(
        val id: Int,
        val name: String,
        val region: JsonNamedApiResource<JsonRegion>,
        val names: List<JsonName>,
        val game_indices: List<JsonGenerationGameIndex>,
        val areas: JsonApiResource<JsonLocationArea>
)

data class JsonLocationArea(
        val id: Int,
        val name: String,
        val game_index: Int,
        val encounter_method_rates: List<JsonEncounterMethodRate>,
        val location: JsonNamedApiResource<JsonRegion>,
        val names: List<JsonName>,
        val pokemon_encounters: List<JsonPokemonEncounter>
)

data class JsonEncounterMethodRate(
        val encounter_method: JsonNamedApiResource<JsonEncounterMethod>,
        val version_details: List<JsonVersionEncounterDetail>
)

data class JsonPokemonEncounter(
        val pokemon: JsonNamedApiResource<JsonPokemon>,
        val version_details: List<JsonVersionEncounterDetail>
)

data class JsonPalParkArea(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_encounters: List<JsonPalParkEncounterSpecies>
)

data class JsonPalParkEncounterSpecies(
        val base_score: Int,
        val rate: Int,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonRegion(
        val id: Int,
        val name: String,
        val locations: List<JsonLocation>,
        val main_generation: JsonNamedApiResource<JsonGeneration>,
        val names: List<JsonName>,
        val pokedexes: List<JsonNamedApiResource<JsonPokedex>>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)