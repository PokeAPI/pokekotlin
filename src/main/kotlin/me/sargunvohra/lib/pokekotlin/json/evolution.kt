package me.sargunvohra.lib.pokekotlin.json

data class JsonEvolutionChain(
        val id: Int,
        val baby_trigger_item: JsonNamedApiResource<JsonItem>,
        val chain: JsonChainLink
)

data class JsonChainLink(
        val is_baby: Boolean,
        val species: JsonNamedApiResource<JsonPokemonSpecies>,
        val evolution_details: JsonEvolutionDetail,
        val evolves_to: JsonChainLink
)

data class JsonEvolutionDetail(
        val item: JsonNamedApiResource<JsonItem>?,
        val trigger: JsonNamedApiResource<JsonEvolutionTrigger>,
        val gender: JsonNamedApiResource<JsonGender>?,
        val held_item: JsonNamedApiResource<JsonItem>?,
        val known_move: JsonNamedApiResource<JsonMove>?,
        val known_move_type: JsonNamedApiResource<JsonMove>?,
        val location: JsonNamedApiResource<JsonLocation>?,
        val min_level: Int?,
        val min_happiness: Int?,
        val min_beauty: Int?,
        val min_affection: Int?,
        val needs_overworld_rain: Boolean,
        val part_species: JsonNamedApiResource<JsonPokemonSpecies>,
        val party_type: JsonNamedApiResource<JsonType>,
        val relative_physical_stats: Int,
        val time_of_day: String,
        val trade_species: JsonNamedApiResource<JsonPokemonSpecies>,
        val turn_upside_down: Boolean
)

data class JsonEvolutionTrigger(
        val id: Int,
        val name: String,
        val names: List<JsonName>,
        val pokemon_species: List<JsonNamedApiResource<JsonPokemonSpecies>>
)