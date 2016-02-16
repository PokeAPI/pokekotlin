package me.sargunvohra.lib.pokekotlin.json

data class JsonGeneration(
        val id: Int,
        val name: String,
        val abilities: List<JsonAbility>,
        val names: List<JsonName>,
        val main_region: JsonNamedApiResource<JsonRegion>,
        val moves: List<JsonNamedApiResource<JsonMove>>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>,
        val types: List<JsonNamedApiResource<JsonType>>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

data class JsonPokedex(
        val id: Int,
        val name: String,
        val is_main_series: Boolean,
        val descriptions: List<JsonDescription>,
        val names: List<JsonName>,
        val pokemon_entries: List<JsonPokemonEntry>,
        val region: JsonNamedApiResource<JsonRegion>,
        val version_groups: List<JsonNamedApiResource<JsonVersionGroup>>
)

data class JsonPokemonEntry(
        val entry_number: Int,
        val pokemon_species: JsonNamedApiResource<JsonPokemonSpecies>
)

data class JsonVersion(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val version_group: JsonNamedApiResource<JsonVersionGroup>
)

data class JsonVersionGroup(
        val id: Int,
        val name: String,
        val order: Int,
        val generation: JsonNamedApiResource<JsonGeneration>,
        val move_learn_methods: List<JsonNamedApiResource<JsonMoveLearnMethod>>,
        val names: List<JsonName>,
        val pokedexes: List<JsonNamedApiResource<JsonPokedex>>,
        val regions: List<JsonNamedApiResource<JsonRegion>>,
        val versions: List<JsonNamedApiResource<JsonVersion>>
)